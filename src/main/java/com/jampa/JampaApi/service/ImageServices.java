package com.jampa.JampaApi.service;

import com.jampa.JampaApi.model.Imagen;
import com.jampa.JampaApi.repository.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServices {


    @Autowired //Inyectamos la dependencia del PedidoRepository
    private ImagenRepository imagenRepository;

    //Método ver todas las Imágenes de la lista
    public List<Imagen> getAllImagen(){
        return imagenRepository.findAll();
    }

    // Método para agregar una imagen
    public Imagen agregarImagen(Imagen imagen) {
        return imagenRepository.save(imagen);
    }

    //Método eliminar una imagen
    public void eliminarImagen(Long id){
        imagenRepository.deleteById(id);
    }

    //buscar una imagen por id
    public Imagen findImagen(Long id) {
        return imagenRepository.findById(id).orElse(null);
    }

    // editar una imagen
//    public void editImagen(Imagen imagen) {
//        this.agregarImagen(imagen);
//    }
}
