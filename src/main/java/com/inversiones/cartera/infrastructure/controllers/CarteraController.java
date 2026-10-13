package com.inversiones.cartera.infrastructure.controllers;

import com.inversiones.cartera.application.usecases.CarteraService;
import com.inversiones.cartera.domain.model.Cartera;
import com.inversiones.cartera.infrastructure.controllers.dto.CarteraRequest;
import com.inversiones.cartera.infrastructure.controllers.dto.CarteraResponse;
import com.inversiones.cartera.infrastructure.controllers.dto.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/carteras")
@Tag(name = "Carteras", description = "API para gestión de carteras de inversión")
public class CarteraController {

    private final CarteraService carteraService;

    public CarteraController(CarteraService carteraService) {
        this.carteraService = carteraService;
    }

    @GetMapping
    @Operation(summary = "Listar todas las carteras", description = "Retorna una lista de todas las carteras de inversión registradas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de carteras obtenida exitosamente",
                     content = @Content(schema = @Schema(implementation = CarteraResponse.class))),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<List<CarteraResponse>> listarCarteras() {
        List<Cartera> carteras = carteraService.obtenerTodasCarteras();
        List<CarteraResponse> respuestas = carteras.stream()
                .map(CarteraResponse::fromDomain)
                .collect(Collectors.toList());
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener cartera por ID", description = "Retorna los detalles de una cartera específica")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cartera encontrada",
                     content = @Content(schema = @Schema(implementation = CarteraResponse.class))),
        @ApiResponse(responseCode = "404", description = "Cartera no encontrada",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<CarteraResponse> obtenerCartera(
            @Parameter(description = "ID único de la cartera", required = true)
            @PathVariable UUID id) {
        Cartera cartera = carteraService.obtenerCarteraPorId(id);
        if (cartera == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(CarteraResponse.fromDomain(cartera));
    }

    @PostMapping
    @Operation(summary = "Crear nueva cartera", description = "Crea una nueva cartera de inversión")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cartera creada exitosamente",
                     content = @Content(schema = @Schema(implementation = CarteraResponse.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<CarteraResponse> crearCartera(
            @Valid @RequestBody CarteraRequest request) {
        Cartera carteraCreada = carteraService.crearCartera(request);
        CarteraResponse response = CarteraResponse.fromDomain(carteraCreada);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(carteraCreada.getId())
                .toUri();
        
        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar cartera completamente", description = "Reemplaza todos los campos de una cartera existente (idempotente)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cartera actualizada exitosamente",
                     content = @Content(schema = @Schema(implementation = CarteraResponse.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", descripción = "Cartera no encontrada",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<CarteraResponse> actualizarCartera(
            @Parameter(description = "ID único de la cartera", required = true)
            @PathVariable UUID id,
            @Valid @RequestBody CarteraRequest request) {
        Cartera carteraActualizada = carteraService.actualizarCartera(id, request);
        if (carteraActualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(CarteraResponse.fromDomain(carteraActualizada));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar cartera", description = "Elimina una cartera de inversión por su ID (idempotente)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Cartera eliminada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Cartera no encontrada",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                     content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<Void> eliminarCartera(
            @Parameter(description = "ID único de la cartera", required = true)
            @PathVariable UUID id) {
        boolean eliminada = carteraService.eliminarCartera(id);
        if (!eliminada) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}