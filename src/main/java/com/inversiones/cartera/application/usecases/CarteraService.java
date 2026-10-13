package com.inversiones.cartera.application.usecases;

import com.inversiones.cartera.domain.model.Cartera;
import com.inversiones.cartera.domain.model.Inversion;
import com.inversiones.cartera.domain.ports.CarteraRepository;
import com.inversiones.cartera.infrastructure.controllers.dto.CarteraRequest;
import com.inversiones.cartera.infrastructure.controllers.dto.CarteraResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class CarteraService {

    private static final Logger log = LoggerFactory.getLogger(CarteraService.class);

    private final CarteraRepository carteraRepository;

    public CarteraService(CarteraRepository carteraRepository) {
        this.carteraRepository = carteraRepository;
    }

    public List<CarteraResponse> listarCarteras() {
        log.info("Listando todas las carteras");
        List<Cartera> carteras = carteraRepository.findAll();
        return carteras.stream()
            .map(CarteraResponse::fromEntity)
            .toList();
    }

    public Optional<CarteraResponse> obtenerCarteraPorId(UUID id) {
        log.info("Obteniendo cartera con id: {}", id);
        return carteraRepository.findById(id)
            .map(CarteraResponse::fromEntity);
    }

    public CarteraResponse crearCartera(@Valid CarteraRequest request) {
        log.info("Creando nueva cartera con nombre: {}", request.nombre());

        if (carteraRepository.existsByNombre(request.nombre())) {
            throw new IllegalArgumentException("Ya existe una cartera con el nombre: " + request.nombre());
        }

        Cartera cartera = new Cartera(
            UUID.randomUUID(),
            request.nombre(),
            request.descripcion(),
            request.saldoInicial() != null ? request.saldoInicial() : BigDecimal.ZERO
        );

        Cartera saved = carteraRepository.save(cartera);
        log.info("Cartera creada exitosamente con id: {}", saved.getId());
        return CarteraResponse.fromEntity(saved);
    }

    public Optional<CarteraResponse> actualizarCartera(UUID id, @Valid CarteraRequest request) {
        log.info("Actualizando cartera con id: {}", id);

        return carteraRepository.findById(id)
            .map(carteraExistente -> {
                boolean nombreDuplicado = carteraRepository.existsByNombreAndIdNot(
                    request.nombre(), id
                );
                if (nombreDuplicado) {
                    throw new IllegalArgumentException(
                        "Ya existe otra cartera con el nombre: " + request.nombre()
                    );
                }

                carteraExistente.setNombre(request.nombre());
                carteraExistente.setDescripcion(request.descripcion());
                if (request.saldoInicial() != null) {
                    carteraExistente.setSaldoInicial(request.saldoInicial());
                }

                Cartera updated = carteraRepository.save(carteraExistente);
                log.info("Cartera actualizada exitosamente: {}", id);
                return CarteraResponse.fromEntity(updated);
            });
    }

    public Optional<CarteraResponse> actualizarParcialCartera(UUID id, @Valid CarteraRequest request) {
        log.info("Actualizando parcialmente cartera con id: {}", id);

        return carteraRepository.findById(id)
            .map(carteraExistente -> {
                if (request.nombre() != null && !request.nombre().equals(carteraExistente.getNombre())) {
                    boolean nombreDuplicado = carteraRepository.existsByNombreAndIdNot(
                        request.nombre(), id
                    );
                    if (nombreDuplicado) {
                        throw new IllegalArgumentException(
                            "Ya existe otra cartera con el nombre: " + request.nombre()
                        );
                    }
                    carteraExistente.setNombre(request.nombre());
                }

                if (request.descripcion() != null) {
                    carteraExistente.setDescripcion(request.descripcion());
                }

                if (request.saldoInicial() != null) {
                    carteraExistente.setSaldoInicial(request.saldoInicial());
                }

                Cartera updated = carteraRepository.save(carteraExistente);
                log.info("Cartera actualizada parcialmente: {}", id);
                return CarteraResponse.fromEntity(updated);
            });
    }

    public boolean eliminarCartera(UUID id) {
        log.info("Eliminando cartera con id: {}", id);

        if (!carteraRepository.existsById(id)) {
            log.warn("Cartera no encontrada para eliminación: {}", id);
            return false;
        }

        carteraRepository.deleteById(id);
        log.info("Cartera eliminada exitosamente: {}", id);
        return true;
    }

    public Optional<CarteraResponse> agregarInversion(UUID carteraId, String nombreInversion, 
                                                       String simbolo, BigDecimal cantidad, 
                                                       BigDecimal precioCompra) {
        log.info("Agregando inversión a cartera {}: {} ({})", carteraId, nombreInversion, simbolo);

        return carteraRepository.findById(carteraId)
            .map(cartera -> {
                Inversion inversion = new Inversion(
                    UUID.randomUUID(),
                    nombreInversion,
                    simbolo,
                    cantidad,
                    precioCompra
                );
                inversion.setFechaCompra(LocalDateTime.now());

                cartera.agregarInversion(inversion);
                Cartera updated = carteraRepository.save(cartera);

                log.info("Inversión agregada exitosamente a cartera {}", carteraId);
                return CarteraResponse.fromEntity(updated);
            });
    }

    public Optional<CarteraResponse> eliminarInversion(UUID carteraId, UUID inversionId) {
        log.info("Eliminando inversión {} de cartera {}", inversionId, carteraId);

        return carteraRepository.findById(carteraId)
            .map(cartera -> {
                cartera.eliminarInversion(inversionId);
                Cartera updated = carteraRepository.save(cartera);

                log.info("Inversión {} eliminada de cartera {}", inversionId, carteraId);
                return CarteraResponse.fromEntity(updated);
            });
    }

    public Optional<BigDecimal> calcularSaldoActual(UUID carteraId) {
        log.info("Calculando saldo actual de cartera: {}", carteraId);

        return carteraRepository.findById(carteraId)
            .map(Cartera::calcularSaldoActual);
    }
}