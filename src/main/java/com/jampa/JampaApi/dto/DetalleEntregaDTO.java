package com.jampa.JampaApi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalleEntregaDTO {
    private Long id_entrega;
    private Long id_venta;  // ID de la venta asociada
    private String persona_que_recibe;
    private String direccion_entrega;
    private String ciudad;
    private String telefono_quien_recibe;
}
