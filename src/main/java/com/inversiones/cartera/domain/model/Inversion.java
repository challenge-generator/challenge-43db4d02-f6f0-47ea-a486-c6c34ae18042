package com.inversiones.cartera.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Inversion {
    private UUID id;
    private String nombre;
    private String simbolo;
    private BigDecimal cantidad;
    private BigDecimal precioCompra;
    private LocalDateTime fechaCompra;
    private List<Transaccion> transacciones;

    public Inversion(UUID id, String nombre, String simbolo, BigDecimal cantidad, BigDecimal precioCompra) {
        this.id = id;
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.fechaCompra = LocalDateTime.now();
        this.transacciones = new ArrayList<>();
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

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public List<Transaccion> getTransacciones() {
        return new ArrayList<>(transacciones);
    }

    public void agregarTransaccion(Transaccion transaccion) {
        if (transaccion == null) {
            throw new IllegalArgumentException("La transacción no puede ser nula");
        }
        this.transacciones.add(transaccion);
    }

    public BigDecimal calcularValorActual() {
        BigDecimal valorActual = cantidad.multiply(precioCompra);
        for (Transaccion transaccion : transacciones) {
            valorActual = valorActual.add(transaccion.getMonto());
        }
        return valorActual;
    }
}