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
    private Long id_venta;
    private Date fecha_venta;
    private BigDecimal valor_envio;
    private PedidoDTO pedido;


    // Constructor y métodos getter/setter

}