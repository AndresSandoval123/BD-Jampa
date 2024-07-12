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
public class VentaDetalleDTO {
    private Long idVenta;
    private Date fechaVenta;
    private BigDecimal valorEnvio;
    private String nombreUsuario;
    private int cantidad;
    private String nombreProducto;
    private String personaQueRecibe;
    private String ciudad;
    private String direccionEntrega;
}