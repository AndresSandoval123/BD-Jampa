package com.jampa.JampaApi.controller;

import com.jampa.JampaApi.dto.VentaDTO;
import com.jampa.JampaApi.model.Venta;
import com.jampa.JampaApi.service.VentaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ventas")
public class VentaController {

    @Autowired
    private VentaServices ventaServices;

    @GetMapping("/todos")
    public List<Venta> getAllVentas(){
        return ventaServices.getAllVentas();
    }

    @GetMapping("/todas")
    public ResponseEntity<List<VentaDTO>> obtenerTodasLasVentas() {
        List<Venta> ventas = ventaServices.getAllVentas();
        List<VentaDTO> ventasDTO = ventaServices.convertirAVentaDTOList(ventas);
        return new ResponseEntity<>(ventasDTO, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarVenta(@RequestBody VentaDTO ventaDTO) {
        try {
            Venta venta = ventaServices.crearVenta(ventaDTO);
            VentaDTO responseDTO = ventaServices.convertirAVentaDTO(venta);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // ResponseEntity -> nos permite mandar mensaje de confirmación desde el servidor al cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarVenta(@PathVariable Long id) {
        try {
            // Verificar si la venta existe
            Venta venta = ventaServices.findVenta(id);

            if (venta != null) {
                ventaServices.eliminarVenta(id);
                return new ResponseEntity<>("Venta eliminada con éxito", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Venta no encontrada", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la venta: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminarVenta(@PathVariable Long id) {
//        ventaServices.eliminarVenta(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }


    // Método personalizado para buscar una Venta por su id
    @GetMapping("buscar/{id}")
    public ResponseEntity<?> obtenerVentaPorId(@PathVariable Long id) {
        Venta venta = ventaServices.findVenta(id);
        if (venta == null) {
            return new ResponseEntity<>("Venta no encontrada con ID: " + id, HttpStatus.NOT_FOUND);
        }
        VentaDTO ventaDTO = ventaServices.convertirAVentaDTO(venta);
        return new ResponseEntity<>(ventaDTO, HttpStatus.OK);
    }


}
