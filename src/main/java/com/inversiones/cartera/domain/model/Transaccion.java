package com.inversiones.cartera.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaccion {
    private UUID id;
    private TipoTransaccion tipo;
    private BigDecimal monto;
    private LocalDateTime fecha;
    private String descripcion;

    public enum TipoTransaccion {
        COMPRA, VENTA, DIVIDENDO, AJUSTE
    }

    public Transaccion(UUID id, TipoTransaccion tipo, BigDecimal monto, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = LocalDateTime.now();
        this.descripcion = descripcion;
    }

    public UUID getId() {
        return id;
    }

    public TipoTransaccion getTipo() {
        return tipo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal calcularImpacto() {
        return tipo == TipoTransaccion.VENTA || tipo == TipoTransaccion.DIVIDENDO ? monto : monto.negate();
    }
}