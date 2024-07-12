package com.jampa.JampaApi.controller;

import com.jampa.JampaApi.dto.DetalleEntregaDTO;
import com.jampa.JampaApi.model.DetalleEntrega;
import com.jampa.JampaApi.service.DetalleEntregaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/detalle")
public class DetalleEntregaController {

    @Autowired
    private DetalleEntregaService detalleEntregaService;

    // Endpoint para agregar un detalle de entrega
    @PostMapping("/agregar")
    public ResponseEntity<?> agregarDetalleEntrega(@RequestBody DetalleEntregaDTO detalleDTO) {
        try {
            DetalleEntrega detalleAgregado = detalleEntregaService.agregarDetalleEntrega(detalleDTO);
            DetalleEntregaDTO detalleAgregadoDTO = detalleEntregaService.convertirADetalleEntregaDTO(detalleAgregado);
            return new ResponseEntity<>(detalleAgregadoDTO, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<List<DetalleEntregaDTO>> obtenerTodosLosDetalles() {
        List<DetalleEntrega> detalles = detalleEntregaService.getAllDetalles();
        List<DetalleEntregaDTO> detalleDTOs = detalles.stream()
                .map(detalle -> detalleEntregaService.convertirADetalleEntregaDTO(detalle))
                .collect(Collectors.toList());
        return new ResponseEntity<>(detalleDTOs, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> obtenerDetallePorId(@PathVariable Long id) {
        DetalleEntrega detalle = detalleEntregaService.findDetalle(id);
        if (detalle == null) {
            return new ResponseEntity<>("Detalle de entrega no encontrado con ID: " + id, HttpStatus.NOT_FOUND);
        }
        DetalleEntregaDTO detalleDTO = detalleEntregaService.convertirADetalleEntregaDTO(detalle);
        return new ResponseEntity<>(detalleDTO, HttpStatus.OK);
    }

    @PutMapping("/actualizar/{idEntrega}")
    public ResponseEntity<?> actualizarDetalleEntrega(
            @PathVariable Long idEntrega,
            @RequestBody DetalleEntregaDTO detalleEntregaDTO
    ) {
        try {
            DetalleEntrega detalleEntregaActualizado = detalleEntregaService.actualizarDetalleEntrega(idEntrega, detalleEntregaDTO);
            return ResponseEntity.ok(detalleEntregaActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    // ResponseEntity -> nos permite mandar mensaje de confirmación desde el servidor al cliente
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> eliminarProducto(@PathVariable Long id) {
//        try {
//            // Verificar si el pedido si existe
//            DetalleEntrega detalleEnt = detalleEntregaService.findDetEntregaPedido(id);
//
//            if (detalleEnt != null) {
//                detalleEntregaService.eliminarDetEntregaPedido(id);
//                return new ResponseEntity<>("Pedido eliminado con éxito", HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>("Pedido no encontrado", HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>("Error al eliminar pedido: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}

