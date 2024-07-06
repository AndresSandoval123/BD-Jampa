package com.jampa.JampaApi.repository;

import com.jampa.JampaApi.model.DetalleEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleEntregaRepository extends JpaRepository<DetalleEntrega, Long> {
}
