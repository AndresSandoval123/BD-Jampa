package com.jampa.JampaApi.service;

import com.jampa.JampaApi.model.Producto;
import com.jampa.JampaApi.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServices {

    @Autowired //Inyectamos la dependencia del ProductoRepository
    private ProductoRepository productoRepository;

    //Método ver todos los productos de la lista
    public List<Producto> getAllProducto(){
        return productoRepository.findAll();
    }

    //Método agregar un producto
    public Producto addProducto( Producto producto){
        return productoRepository.save(producto);
    }

    //Método eliminar producto
    public void eliminarProducto(Long id){
        productoRepository.deleteById(id);
    }

    //buscar un solo producto
    public Producto findProducto(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    // Método para buscar libros por título usando JPQL
    public List<Producto> buscarPorTitulo(String titulo) {
        return productoRepository.findProductoByProducto(titulo);
    }


}
