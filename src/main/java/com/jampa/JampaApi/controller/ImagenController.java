package com.jampa.JampaApi.controller;

import com.jampa.JampaApi.model.Imagen;
import com.jampa.JampaApi.service.ImageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/imagen")
public class ImagenController {

    @Autowired
    private ImageServices imageServices;

    @GetMapping("/todos")
    public List<Imagen> getAllProductos(){
        return imageServices.getAllImagen();
    }

    // Endpoint para agregar una imagen
    @PostMapping("/agregar")
    public Imagen agregarImagen(@RequestBody Imagen imagen) {
        return imageServices.agregarImagen(imagen);
    }

    // ResponseEntity -> nos permite mandar mensaje de confirmación desde el servidor al cliente
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarImagen(@PathVariable Long id) {
        try {
            // Verificar si la imagen existe
            Imagen imagen = imageServices.findImagen(id);

            if (imagen != null) {
                imageServices.eliminarImagen(id);
                return new ResponseEntity<>("Imagen eliminada con éxito", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Imagen no encontrada", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar una imagen: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método personalizado para buscar un Producto por su id
    @GetMapping("/buscar/{id}")
    public Imagen findProducto(@PathVariable Long id) {
        return imageServices.findImagen(id);
    }

    // Modificar datos de una imagen
//    @PutMapping("/edit")
//    public String editImagen(@RequestBody Imagen imagen) {
//        imageServices.editImagen(imagen);
//        return "Imagen editada correctamente";
//    }

}