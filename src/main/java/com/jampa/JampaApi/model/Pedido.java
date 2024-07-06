package com.jampa.JampaApi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_pedido;
  private int cantidad;
  /* Pendiente relaciones con
  Long id_usuario;
  Long id_producto;
  */
}
