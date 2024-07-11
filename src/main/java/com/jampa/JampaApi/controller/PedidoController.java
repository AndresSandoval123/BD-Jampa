package com.jampa.JampaApi.controller;

import com.jampa.JampaApi.model.Pedido;
import com.jampa.JampaApi.service.PedidoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoServices pedidoServices;

    @GetMapping("/todos")
    public List<Pedido> getAllPedidos(){
        return pedidoServices.getAllPedidos();
    }

    @PostMapping("/agregar")
    public Pedido addPedi(@RequestBody Pedido pedido){
        return pedidoServices.addPedido(pedido);
    }

    // ResponseEntity -> nos permite mandar mensaje de confirmación desde el servidor al cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long id) {
        try {
            // Verificar si el pedido si existe
            Pedido pedido = pedidoServices.findPedido(id);

            if (pedido != null) {
                pedidoServices.eliminarProducto(id);
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
    public Pedido findPedido(@PathVariable Long id) {
        return pedidoServices.findPedido(id);    }



    // Modificar los datos de un producto
    @PutMapping("/edit")
    public String editPedido(@RequestBody Pedido pedido) {
        pedidoServices.editPedido(pedido);
        return "Pedido editado correctamente";
    }

}
