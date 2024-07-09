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
import java.util.Optional;

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
    public ResponseEntity<String> eliminarProducto(@PathVariable Long id) {
        try {
            // Verificar si el producto existe
            Producto producto = productoServices.findProducto(id);

            if (producto != null) {
                productoServices.eliminarProducto(id);
                return new ResponseEntity<>("Producto eliminado con éxito", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método personalizado para buscar un Producto por su id
    @GetMapping("/buscar-producto-id/{id}")
    public Producto findProducto(@PathVariable Long id) {
        return productoServices.findProducto(id);
    }

    // Consulta JPQL personalizada-avanzada
    @GetMapping("/buscar-producto-titulo/{nombre_producto}")
    public List<Producto> buscarProductoPorTitulo(@PathVariable String nombre_producto) {
        return productoServices.buscarPorTitulo(nombre_producto);
    }

    // busca cualquier coincidencia de la bd
    @GetMapping("/buscar/{termino}")
    public List<Producto> buscarProductos(@PathVariable String termino) {
        return productoServices.buscarPorTermino(termino);
    }


}