package com.jampa.JampaApi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VentaDTO {
    // consulta de ventas
    private Long id_venta;
    private Date fecha_venta;
    private Boolean estado;
    private BigDecimal valor_envio;
    private PedidoDTO pedido;


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class PedidoDTO {
        //actualización del dto para que en la respuesta me traiga el estado
        private Long id_pedido;
        private int cantidad;
        private String nombre_usuario;
    }



}