package com.inversiones.cartera.application.usecases;

import com.inversiones.cartera.domain.model.Cartera;
import com.inversiones.cartera.domain.model.Inversion;
import com.inversiones.cartera.domain.ports.CarteraRepository;
import com.inversiones.cartera.infrastructure.controllers.dto.CarteraRequest;
import com.inversiones.cartera.infrastructure.controllers.dto.CarteraResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarteraServiceTest {

    @Mock
    private CarteraRepository carteraRepository;

    @InjectMocks
    private CarteraService carteraService;

    private Cartera carteraMock;
    private CarteraRequest carteraRequest;
    private UUID carteraId;

    @BeforeEach
    void setUp() {
        carteraId = UUID.fromString("550e8400-e29b-41d4-a716-446655440000");
        carteraMock = new Cartera(
            carteraId,
            "Cartera Principal",
            "Cartera de inversiones a largo plazo",
            new BigDecimal("100000.00"),
            LocalDateTime.of(2024, 1, 15, 10, 30)
        );

        Inversion inversionMock = new Inversion(
            UUID.fromString("550e8400-e29b-41d4-a716-446655440001"),
            "Apple Inc.",
            "AAPL",
            new BigDecimal("50"),
            new BigDecimal("150.00")
        );
        carteraMock.agregarInversion(inversionMock);

        carteraRequest = new CarteraRequest(
            "Cartera Principal",
            "Cartera de inversiones a largo plazo",
            new BigDecimal("100000.00")
        );
    }

    @Test
    @DisplayName("obtenerTodas debe retornar lista de carteras")
    void testObtenerTodas() {
        when(carteraRepository.findAll()).thenReturn(List.of(carteraMock));

        List<CarteraResponse> result = carteraService.obtenerTodas();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Cartera Principal", result.get(0).nombre());
        verify(carteraRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("obtenerTodas debe retornar lista vacía cuando no hay carteras")
    void testObtenerTodasVacia() {
        when(carteraRepository.findAll()).thenReturn(List.of());

        List<CarteraResponse> result = carteraService.obtenerTodas();

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(carteraRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("obtenerPorId debe retornar cartera cuando existe")
    void testObtenerPorIdExistente() {
        when(carteraRepository.findById(carteraId)).thenReturn(Optional.of(carteraMock));

        Optional<CarteraResponse> result = carteraService.obtenerPorId(carteraId);

        assertTrue(result.isPresent());
        assertEquals(carteraId, result.get().id());
        assertEquals("Cartera Principal", result.get().nombre());
        verify(carteraRepository, times(1)).findById(carteraId);
    }

    @Test
    @DisplayName("obtenerPorId debe retornar Optional.empty cuando no existe")
    void testObtenerPorIdNoExistente() {
        UUID idNoExistente = UUID.fromString("550e8400-e29b-41d4-a716-446655440099");
        when(carteraRepository.findById(idNoExistente)).thenReturn(Optional.empty());

        Optional<CarteraResponse> result = carteraService.obtenerPorId(idNoExistente);

        assertFalse(result.isPresent());
        verify(carteraRepository, times(1)).findById(idNoExistente);
    }

    @Test
    @DisplayName("crear debe persistir y retornar la cartera creada")
    void testCrearCartera() {
        when(carteraRepository.save(any(Cartera.class))).thenReturn(carteraMock);

        CarteraResponse result = carteraService.crear(carteraRequest);

        assertNotNull(result);
        assertEquals("Cartera Principal", result.nombre());
        assertEquals(new BigDecimal("100000.00"), result.saldoInicial());
        verify(carteraRepository, times(1)).save(any(Cartera.class));
    }

    @Test
    @DisplayName("crear debe asignar ID y fecha de creación")
    void testCrearCarteraAsignaIdYFecha() {
        when(carteraRepository.save(any(Cartera.class))).thenAnswer(invocation -> {
            Cartera cartera = invocation.getArgument(0);
            assertNotNull(cartera.getId(), "El ID debe ser asignado");
            assertNotNull(cartera.getFechaCreacion(), "La fecha de creación debe ser asignada");
            return cartera;
        });

        carteraService.crear(carteraRequest);

        verify(carteraRepository, times(1)).save(any(Cartera.class));
    }

    @Test
    @DisplayName("actualizar debe modificar datos y retornar la cartera actualizada")
    void testActualizarCartera() {
        when(carteraRepository.findById(carteraId)).thenReturn(Optional.of(carteraMock));
        when(carteraRepository.save(any(Cartera.class))).thenReturn(carteraMock);

        CarteraRequest updateRequest = new CarteraRequest(
            "Cartera Actualizada",
            "Nueva descripción",
            new BigDecimal("200000.00")
        );

        CarteraResponse result = carteraService.actualizar(carteraId, updateRequest);

        assertNotNull(result);
        verify(carteraRepository, times(1)).findById(carteraId);
        verify(carteraRepository, times(1)).save(any(Cartera.class));
    }

    @Test
    @DisplayName("actualizar debe lanzar excepción cuando la cartera no existe")
    void testActualizarCarteraNoExistente() {
        UUID idNoExistente = UUID.fromString("550e8400-e29b-41d4-a716-446655440099");
        when(carteraRepository.findById(idNoExistente)).thenReturn(Optional.empty());

        assertThrows(
            RuntimeException.class,
            () -> carteraService.actualizar(idNoExistente, carteraRequest)
        );

        verify(carteraRepository, times(1)).findById(idNoExistente);
        verify(carteraRepository, never()).save(any(Cartera.class));
    }

    @Test
    @DisplayName("eliminar debe borrar la cartera existente")
    void testEliminarCarteraExistente() {
        when(carteraRepository.findById(carteraId)).thenReturn(Optional.of(carteraMock));
        doNothing().when(carteraRepository).delete(carteraMock);

        assertDoesNotThrow(() -> carteraService.eliminar(carteraId));

        verify(carteraRepository, times(1)).findById(carteraId);
        verify(carteraRepository, times(1)).delete(carteraMock);
    }

    @Test
    @DisplayName("eliminar debe lanzar excepción cuando la cartera no existe")
    void testEliminarCarteraNoExistente() {
        UUID idNoExistente = UUID.fromString("550e8400-e29b-41d4-a716-446655440099");
        when(carteraRepository.findById(idNoExistente)).thenReturn(Optional.empty());

        assertThrows(
            RuntimeException.class,
            () -> carteraService.eliminar(idNoExistente)
        );

        verify(carteraRepository, times(1)).findById(idNoExistente);
        verify(carteraRepository, never()).delete(any(Cartera.class));
    }

    @Test
    @DisplayName("calcularSaldoActual debe retornar el saldo con ganancias")
    void testCalcularSaldoActual() {
        when(carteraRepository.findById(carteraId)).thenReturn(Optional.of(carteraMock));

        Optional<BigDecimal> result = carteraService.calcularSaldoActual(carteraId);

        assertTrue(result.isPresent());
        assertTrue(result.get().compareTo(new BigDecimal("100000.00")) > 0,
            "El saldo actual debe ser mayor al inicial por las inversiones");
    }

    @Test
    @DisplayName("calcularSaldoActual debe retornar Optional.empty para cartera inexistente")
    void testCalcularSaldoActualCarteraNoExistente() {
        UUID idNoExistente = UUID.fromString("550e8400-e29b-41d4-a716-446655440099");
        when(carteraRepository.findById(idNoExistente)).thenReturn(Optional.empty());

        Optional<BigDecimal> result = carteraService.calcularSaldoActual(idNoExistente);

        assertFalse(result.isPresent());
    }
}