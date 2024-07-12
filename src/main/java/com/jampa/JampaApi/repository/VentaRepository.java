package com.jampa.JampaApi.repository;

import com.jampa.JampaApi.dto.VentaDetalleDTO;
import com.jampa.JampaApi.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    @Query("SELECT new com.jampa.JampaApi.dto.VentaDetalleDTO(" +
            "v.id_venta, v.fecha_venta, v.valor_envio, u.nombre_usuario, " +
            "p.cantidad, pr.nombre_producto, d.persona_que_recibe, d.ciudad, d.direccion_entrega) " +
            "FROM Venta v " +
            "LEFT JOIN v.pedido p " +
            "LEFT JOIN p.usuario u " +
            "LEFT JOIN p.producto pr " +
            "LEFT JOIN v.detalleEntrega d")
    List<VentaDetalleDTO> obtenerVentasDetalle();

}
