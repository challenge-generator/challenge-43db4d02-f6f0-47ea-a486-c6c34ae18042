package com.inversiones.cartera.infrastructure.controllers.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public record CarteraRequest(
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    String nombre,
    
    @Size(max = 500, message = "La descripción no puede exceder 500 caracteres")
    String descripcion,
    
    @DecimalMin(value = "0.0", message = "El saldo inicial no puede ser negativo")
    BigDecimal saldoInicial,
    
    @Size(min = 3, max = 20, message = "El símbolo debe tener entre 3 y 20 caracteres")
    String simbolo,
    
    @DecimalMin(value = "0.000001", message = "La cantidad debe ser mayor a cero")
    BigDecimal cantidad,
    
    @DecimalMin(value = "0.01", message = "El precio de compra debe ser mayor a cero")
    BigDecimal precioCompra
) {
    public CarteraRequest {
        if (descripcion == null) {
            descripcion = "";
        }
        if (saldoInicial == null) {
            saldoInicial = BigDecimal.ZERO;
        }
    }
}