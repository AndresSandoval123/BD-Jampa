package com.jampa.JampaApi.repository;

import com.jampa.JampaApi.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Lo determinamos
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // (2. CONSULTAS -> JPQL) "Util para consultas complejas" muy parecido a SQL
    @Query("SELECT p FROM Producto p WHERE p.nombre_producto = :nombre_producto")
    List<Producto> findProductoByProducto(@Param("nombre_producto") String nombre_producto);

    @Query("SELECT p FROM Producto p WHERE p.categoria LIKE %:termino% OR p.descripcion LIKE %:termino% OR p.nombre_producto LIKE %:termino%")
    List<Producto> buscarPorTermino(@Param("termino") String termino);

}
