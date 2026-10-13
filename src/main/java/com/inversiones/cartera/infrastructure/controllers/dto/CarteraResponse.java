package com.inversiones.cartera.infrastructure.controllers.dto;

import com.inversiones.cartera.domain.model.Cartera;
import com.inversiones.cartera.domain.model.Inversion;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CarteraResponse(
    UUID id,
    String nombre,
    String descripcion,
    BigDecimal saldoInicial,
    BigDecimal saldoActual,
    LocalDateTime fechaCreacion,
    List<InversionResponse> inversiones
) {
    public static CarteraResponse fromEntity(Cartera cartera) {
        List<InversionResponse> inversionesResponse = cartera.getInversiones().stream()
            .map(InversionResponse::fromEntity)
            .toList();
        
        return new CarteraResponse(
            cartera.getId(),
            cartera.getNombre(),
            cartera.getDescripcion(),
            cartera.getSaldoInicial(),
            cartera.calcularSaldoActual(),
            cartera.getFechaCreacion(),
            inversionesResponse
        );
    }

    public static record InversionResponse(
        UUID id,
        String nombre,
        String simbolo,
        BigDecimal cantidad,
        BigDecimal precioCompra,
        BigDecimal valorActual,
        LocalDateTime fechaCompra
    ) {
        public static InversionResponse fromEntity(Inversion inversion) {
            return new InversionResponse(
                inversion.getId(),
                inversion.getNombre(),
                inversion.getSimbolo(),
                inversion.getCantidad(),
                inversion.getPrecioCompra(),
                inversion.calcularValorActual(),
                inversion.getFechaCompra()
            );
        }
    }
}