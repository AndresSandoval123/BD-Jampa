package com.jampa.JampaApi.repository;

import com.jampa.JampaApi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // todos los usuarios que tienen pedidos
    @Query("SELECT DISTINCT u FROM Usuario u JOIN FETCH u.pedidos p")
    List<Usuario> findUsuariosConPedidos();
}
