package com.jampa.JampaApi.controller;

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

    @PostMapping("/agregar")
    public Venta addVenta(@RequestBody Venta venta){
        return ventaServices.addVenta(venta);
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

    // Método personalizado para buscar una Venta por su id
    @GetMapping("/buscar-venta-id/{id}")
    public Venta findProducto(@PathVariable Long id) {
        return ventaServices.findVenta(id);
    }


}
