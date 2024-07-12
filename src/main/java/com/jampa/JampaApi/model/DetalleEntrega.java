package com.jampa.JampaApi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
  @Column(length = 35)
  private String persona_que_recibe;
  @Column(length = 35)
  private String direccion_entrega;
  @Column(length = 50)
  private String ciudad;
  @Column(length = 15)
  private String telefono_quien_recibe;
  /* Pendiente relación
  id_venta
   */

  // Relación con Venta
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_venta")
  @JsonBackReference
  private Venta venta;

//  @OneToOne
//  @JoinColumn(name = "id_venta")
//  private Venta venta;
}
