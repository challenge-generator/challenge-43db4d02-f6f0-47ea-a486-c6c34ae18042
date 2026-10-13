package com.inversiones.cartera.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cartera {
    private UUID id;
    private String nombre;
    private String descripcion;
    private BigDecimal saldoInicial;
    private LocalDateTime fechaCreacion;
    private List<Inversion> inversiones;

    public Cartera(UUID id, String nombre, String descripcion, BigDecimal saldoInicial) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.saldoInicial = saldoInicial;
        this.fechaCreacion = LocalDateTime.now();
        this.inversiones = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public List<Inversion> getInversiones() {
        return new ArrayList<>(inversiones);
    }

    public void agregarInversion(Inversion inversion) {
        if (inversion == null) {
            throw new IllegalArgumentException("La inversión no puede ser nula");
        }
        this.inversiones.add(inversion);
    }

    public void eliminarInversion(UUID inversionId) {
        inversiones.removeIf(inversion -> inversion.getId().equals(inversionId));
    }

    public BigDecimal calcularSaldoActual() {
        BigDecimal saldoActual = saldoInicial;
        for (Inversion inversion : inversiones) {
            for (Transaccion transaccion : inversion.getTransacciones()) {
                saldoActual = saldoActual.add(transaccion.getMonto());
            }
        }
        return saldoActual;
    }
}