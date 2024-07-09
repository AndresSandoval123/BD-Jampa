package com.jampa.JampaApi.controller;

import com.jampa.JampaApi.model.DetalleEntrega;
import com.jampa.JampaApi.service.DetalleEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-pedido")
public class DetalleEntregaController {

    @Autowired
    private DetalleEntregaService detalleEntregaService;

    @GetMapping("/todos")
    public List<DetalleEntrega> getAllPedidos(){
        return detalleEntregaService.getAllDetEntrega();
    }

    @PostMapping("/agregar")
    public DetalleEntrega addDetalleEntrega(@RequestBody DetalleEntrega detalleEntrega){
        return detalleEntregaService.addDetEntregaPedido(detalleEntrega);
    }

    // ResponseEntity -> nos permite mandar mensaje de confirmación desde el servidor al cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long id) {
        try {
            // Verificar si el pedido si existe
            DetalleEntrega detalleEnt = detalleEntregaService.findDetEntregaPedido(id);

            if (detalleEnt != null) {
                detalleEntregaService.eliminarDetEntregaPedido(id);
                return new ResponseEntity<>("Pedido eliminado con éxito", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Pedido no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar pedido: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método personalizado para buscar un Pedido por su id
    @GetMapping("/buscar-pedido-id/{id}")
    public DetalleEntrega findDetalle(@PathVariable Long id) {
        return detalleEntregaService.findDetEntregaPedido(id);    }


    // Modificar los datos de un Pedido
    @PutMapping("/edit")
    public String editDetalleEntrega(@RequestBody DetalleEntrega detalleEntrega) {
        detalleEntregaService.editDetEntregaPedido(detalleEntrega);
        return "Detalle de del pedido editado correctamente";
    }

}

