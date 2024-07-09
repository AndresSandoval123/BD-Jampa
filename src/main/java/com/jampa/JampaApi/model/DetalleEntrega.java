package com.jampa.JampaApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="detalle_entrega")
public class DetalleEntrega {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_entrega;
  private String persona_que_recibe;
  private String direccion_entrega;
  private String ciudad;
  private int telefono_quien_recibe;
  /* Pendiente relación
  id_venta
   */

  @OneToOne
  @JoinColumn(name = "id_venta")
  private Venta venta;
}
