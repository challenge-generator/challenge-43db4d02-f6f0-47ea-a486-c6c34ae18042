package com.inversiones.cartera.infrastructure.controllers;

import com.inversiones.cartera.application.usecases.CarteraService;
import com.inversiones.cartera.domain.model.Cartera;
import com.inversiones.cartera.infrastructure.controllers.dto.CarteraRequest;
import com.inversiones.cartera.infrastructure.controllers.dto.CarteraResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CarteraController.class)
class CarteraControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarteraService carteraService;

    private Cartera carteraMock;
    private CarteraResponse carteraResponse;
    private CarteraRequest carteraRequest;

    @BeforeEach
    void setUp() {
        UUID carteraId = UUID.fromString("550e8400-e29b-41d4-a716-446655440000");
        carteraMock = new Cartera(
            carteraId,
            "Cartera Principal",
            "Cartera de inversiones a largo plazo",
            new BigDecimal("100000.00"),
            LocalDateTime.now()
        );

        carteraResponse = new CarteraResponse(
            carteraId,
            "Cartera Principal",
            "Cartera de inversiones a largo plazo",
            new BigDecimal("100000.00"),
            LocalDateTime.now(),
            List.of()
        );

        carteraRequest = new CarteraRequest(
            "Cartera Principal",
            "Cartera de inversiones a largo plazo",
            new BigDecimal("100000.00")
        );
    }

    @Test
    @DisplayName("GET /api/carteras debe retornar todas las carteras")
    void testObtenerTodasLasCarteras() throws Exception {
        when(carteraService.obtenerTodas()).thenReturn(List.of(carteraResponse));

        mockMvc.perform(get("/api/carteras"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(carteraResponse.id().toString()))
            .andExpect(jsonPath("$[0].nombre").value("Cartera Principal"))
            .andExpect(jsonPath("$[0].saldoInicial").value(100000.00));
    }

    @Test
    @DisplayName("GET /api/carteras/{id} debe retornar una cartera por su ID")
    void testObtenerCarteraPorId() throws Exception {
        UUID carteraId = carteraMock.getId();
        when(carteraService.obtenerPorId(carteraId)).thenReturn(java.util.Optional.of(carteraResponse));

        mockMvc.perform(get("/api/carteras/" + carteraId.toString()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(carteraId.toString()))
            .andExpect(jsonPath("$.nombre").value("Cartera Principal"));
    }

    @Test
    @DisplayName("GET /api/carteras/{id} debe retornar 404 cuando la cartera no existe")
    void testObtenerCarteraPorIdNoExistente() throws Exception {
        UUID carteraId = UUID.fromString("550e8400-e29b-41d4-a716-446655440001");
        when(carteraService.obtenerPorId(carteraId)).thenReturn(java.util.Optional.empty());

        mockMvc.perform(get("/api/carteras/" + carteraId.toString()))
            .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST /api/carteras debe crear una nueva cartera")
    void testCrearCartera() throws Exception {
        when(carteraService.crear(any(CarteraRequest.class))).thenReturn(carteraResponse);

        mockMvc.perform(post("/api/carteras")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Cartera Principal\",\"descripcion\":\"Cartera de inversiones a largo plazo\",\"saldoInicial\":100000.00}"))
            .andExpect(status().isCreated())
            .andExpect(header().exists("Location"))
            .andExpect(jsonPath("$.nombre").value("Cartera Principal"));
    }

    @Test
    @DisplayName("POST /api/carteras debe retornar 400 cuando los datos son inválidos")
    void testCrearCarteraDatosInvalidos() throws Exception {
        when(carteraService.crear(any(CarteraRequest.class))).thenReturn(carteraResponse);

        mockMvc.perform(post("/api/carteras")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"\",\"descripcion\":\"\",\"saldoInicial\":-100}"))
            .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("PUT /api/carteras/{id} debe actualizar completamente una cartera")
    void testActualizarCartera() throws Exception {
        UUID carteraId = carteraMock.getId();
        when(carteraService.actualizar(eq(carteraId), any(CarteraRequest.class))).thenReturn(carteraResponse);

        mockMvc.perform(put("/api/carteras/" + carteraId.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Cartera Actualizada\",\"descripcion\":\"Nueva descripcion\",\"saldoInicial\":200000.00}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nombre").value("Cartera Principal"));
    }

    @Test
    @DisplayName("DELETE /api/carteras/{id} debe eliminar una cartera")
    void testEliminarCartera() throws Exception {
        UUID carteraId = carteraMock.getId();
        doNothing().when(carteraService).eliminar(carteraId);

        mockMvc.perform(delete("/api/carteras/" + carteraId.toString()))
            .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("DELETE /api/carteras/{id} debe retornar 404 cuando la cartera no existe")
    void testEliminarCarteraNoExistente() throws Exception {
        UUID carteraId = UUID.fromString("550e8400-e29b-41d4-a716-446655440001");
        doNothing().when(carteraService).eliminar(carteraId);

        mockMvc.perform(delete("/api/carteras/" + carteraId.toString()))
            .andExpect(status().isNoContent());
    }
}