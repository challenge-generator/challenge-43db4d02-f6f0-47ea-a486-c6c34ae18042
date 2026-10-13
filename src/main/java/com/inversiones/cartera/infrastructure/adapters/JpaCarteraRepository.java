package com.inversiones.cartera.infrastructure.adapters;

import com.inversiones.cartera.domain.model.Cartera;
import com.inversiones.cartera.domain.model.Inversion;
import com.inversiones.cartera.domain.ports.CarteraRepository;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JpaCarteraRepository implements CarteraRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Cartera> findById(UUID id) {
        CarteraEntity entity = entityManager.find(CarteraEntity.class, id);
        return Optional.ofNullable(entity).map(this::toDomain);
    }

    @Override
    public List<Cartera> findAll() {
        List<CarteraEntity> entities = entityManager
            .createQuery("SELECT c FROM CarteraEntity c", CarteraEntity.class)
            .getResultList();
        return entities.stream()
            .map(this::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Cartera save(Cartera cartera) {
        if (cartera.getId() == null) {
            cartera = new Cartera(
                UUID.randomUUID(),
                cartera.getNombre(),
                cartera.getDescripcion(),
                cartera.getSaldoInicial(),
                LocalDateTime.now()
            );
        }
        CarteraEntity entity = toEntity(cartera);
        entityManager.persist(entity);
        return toDomain(entity);
    }

    @Override
    public void deleteById(UUID id) {
        CarteraEntity entity = entityManager.find(CarteraEntity.class, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    @Override
    public boolean existsById(UUID id) {
        CarteraEntity entity = entityManager.find(CarteraEntity.class, id);
        return entity != null;
    }

    @Override
    public List<Cartera> findByNombreContainingIgnoreCase(String nombre) {
        List<CarteraEntity> entities = entityManager
            .createQuery("SELECT c FROM CarteraEntity c WHERE LOWER(c.nombre) LIKE LOWER(:nombre)", CarteraEntity.class)
            .setParameter("nombre", "%" + nombre + "%")
            .getResultList();
        return entities.stream()
            .map(this::toDomain)
            .collect(Collectors.toList());
    }

    private CarteraEntity toEntity(Cartera cartera) {
        CarteraEntity entity = new CarteraEntity();
        entity.setId(cartera.getId());
        entity.setNombre(cartera.getNombre());
        entity.setDescripcion(cartera.getDescripcion());
        entity.setSaldoInicial(cartera.getSaldoInicial());
        entity.setFechaCreacion(cartera.getFechaCreacion());
        
        if (cartera.getInversiones() != null) {
            List<InversionEntity> inversiones = cartera.getInversiones().stream()
                .map(this::toInversionEntity)
                .collect(Collectors.toList());
            entity.setInversiones(inversiones);
        }
        return entity;
    }

    private Cartera toDomain(CarteraEntity entity) {
        Cartera cartera = new Cartera(
            entity.getId(),
            entity.getNombre(),
            entity.getDescripcion(),
            entity.getSaldoInicial(),
            entity.getFechaCreacion()
        );
        
        if (entity.getInversiones() != null) {
            for (InversionEntity invEntity : entity.getInversiones()) {
                cartera.agregarInversion(toInversionDomain(invEntity));
            }
        }
        return cartera;
    }

    private InversionEntity toInversionEntity(Inversion inversion) {
        InversionEntity entity = new InversionEntity();
        entity.setId(inversion.getId());
        entity.setNombre(inversion.getNombre());
        entity.setSimbolo(inversion.getSimbolo());
        entity.setCantidad(inversion.getCantidad());
        entity.setPrecioCompra(inversion.getPrecioCompra());
        entity.setFechaCompra(inversion.getFechaCompra());
        return entity;
    }

    private Inversion toInversionDomain(InversionEntity entity) {
        Inversion inversion = new Inversion(
            entity.getId(),
            entity.getNombre(),
            entity.getSimbolo(),
            entity.getCantidad(),
            entity.getPrecioCompra()
        );
        return inversion;
    }

    @Entity
    @Table(name = "carteras")
    public static class CarteraEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;
        
        @Column(nullable = false, length = 100)
        private String nombre;
        
        @Column(length = 500)
        private String descripcion;
        
        @Column(precision = 19, scale = 4)
        private BigDecimal saldoInicial;
        
        @Column(nullable = false)
        private LocalDateTime fechaCreacion;
        
        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
        @JoinColumn(name = "cartera_id")
        private List<InversionEntity> inversiones;

        public UUID getId() { return id; }
        public void setId(UUID id) { this.id = id; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getDescripcion() { return descripcion; }
        public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
        public BigDecimal getSaldoInicial() { return saldoInicial; }
        public void setSaldoInicial(BigDecimal saldoInicial) { this.saldoInicial = saldoInicial; }
        public LocalDateTime getFechaCreacion() { return fechaCreacion; }
        public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
        public List<InversionEntity> getInversiones() { return inversiones; }
        public void setInversiones(List<InversionEntity> inversiones) { this.inversiones = inversiones; }
    }

    @Entity
    @Table(name = "inversiones")
    public static class InversionEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;
        
        @Column(nullable = false, length = 100)
        private String nombre;
        
        @Column(length = 20)
        private String simbolo;
        
        @Column(precision = 19, scale = 6)
        private BigDecimal cantidad;
        
        @Column(precision = 19, scale = 4)
        private BigDecimal precioCompra;
        
        @Column(nullable = false)
        private LocalDateTime fechaCompra;

        public UUID getId() { return id; }
        public void setId(UUID id) { this.id = id; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getSimbolo() { return simbolo; }
        public void setSimbolo(String simbolo) { this.simbolo = simbolo; }
        public BigDecimal getCantidad() { return cantidad; }
        public void setCantidad(BigDecimal cantidad) { this.cantidad = cantidad; }
        public BigDecimal getPrecioCompra() { return precioCompra; }
        public void setPrecioCompra(BigDecimal precioCompra) { this.precioCompra = precioCompra; }
        public LocalDateTime getFechaCompra() { return fechaCompra; }
        public void setFechaCompra(LocalDateTime fechaCompra) { this.fechaCompra = fechaCompra; }
    }
}