package com.jampa.JampaApi.service;

import com.jampa.JampaApi.model.Producto;
import com.jampa.JampaApi.repository.ProductoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
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

    //buscar un producto por id
    public Producto findProducto(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    // Método para buscar libros por título usando JPQL
    public List<Producto> buscarPorTitulo(String titulo) {
        return productoRepository.findProductoByProducto(titulo);
    }

    // buscar producto por termino deseado
    public List<Producto> buscarPorTermino(String termino) {
        return productoRepository.buscarPorTermino(termino);
    }

    // editar un producto
    public void editProducto(Producto producto) {
        if (producto.getId_producto() != null) {
            productoRepository.save(producto);
        }else  {
                // Manejamos en caso en el que no se proporcione un ID válido (opcional)
                throw new IllegalArgumentException("El ID del producto no puede ser nulo para actualizar.");
            }
    }
    // EntityManager, de JPA y se utiliza para interactuar directamente con la base de datos.
    @PersistenceContext
    private EntityManager entityManager; // método de EntityManager

    @Transactional
    public void editProducto(Long idProducto, Producto productoActualizado) {
        // Cargar el producto existente desde la base de datos
        Producto productoExistente = entityManager.find(Producto.class, idProducto);

        if (productoExistente != null) {
            // Actualizar solo los campos que se requieren
            if (productoActualizado.getNombre_producto() != null) {
                productoExistente.setNombre_producto(productoActualizado.getNombre_producto());
            }
            if (productoActualizado.getDescripcion() != null) {
                productoExistente.setDescripcion(productoActualizado.getDescripcion());
            }
            if (productoActualizado.getColor() != null) {
                productoExistente.setColor(productoActualizado.getColor());
            }
            if (productoActualizado.getTalla() != null) {
                productoExistente.setTalla(productoActualizado.getTalla());
            }
            if (productoActualizado.getStockDisponible() != 0) {
                productoExistente.setStockDisponible(productoActualizado.getStockDisponible());
            }
            if (productoActualizado.getPrecio_producto() != null) {
                productoExistente.setPrecio_producto(productoActualizado.getPrecio_producto());
            }
            if (productoActualizado.getCategoria() != null) {
                productoExistente.setCategoria(productoActualizado.getCategoria());
            }

            // Guardar los cambios en la base de datos
            entityManager.merge(productoExistente);
            entityManager.flush(); // Forzar la sincronización y guardar en la base de datos
        }
    }
}
