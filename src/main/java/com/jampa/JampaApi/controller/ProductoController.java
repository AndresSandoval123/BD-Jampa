package com.jampa.JampaApi.controller;

import com.jampa.JampaApi.model.Producto;
import com.jampa.JampaApi.model.Usuario;
import com.jampa.JampaApi.service.ProductoServices;
import com.jampa.JampaApi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoServices productoServices;

    @GetMapping("/todos")
    public List<Producto> getAllProductos(){
        return productoServices.getAllProducto();
    }

    @PostMapping("/agregar")
    public Producto addProducto(@RequestBody Producto producto){
        return productoServices.addProducto(producto);
    }

    // ResponseEntity -> nos permite mandar mensaje de confirmación desde el servidor al cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long id){
        try {
            productoServices.eliminarProducto(id);
            return new ResponseEntity<>("Producto eliminado con éxito", HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // si no se pudo eliminar por cualquier otro error manda este ménsaje
            return new ResponseEntity<>("Error al eliminar usuario: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}