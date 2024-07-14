package com.jampa.JampaApi.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PedidoDTO {
    private Long id_pedido;
    private int cantidad;
    private String nombre_producto;
    private String nombre_usuario;
}