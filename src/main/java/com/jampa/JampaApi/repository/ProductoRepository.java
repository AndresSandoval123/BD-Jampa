package com.jampa.JampaApi.repository;

import com.jampa.JampaApi.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Lo determinamos
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
