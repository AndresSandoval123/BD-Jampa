package com.jampa.JampaApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pedidos")
public class Pedido {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_pedido;
  private int cantidad;

  @OneToMany
  @JoinColumn(name = "id_usuario")
  private List<Usuario> usuario;
  /* Pendiente relaciones con
  Long id_usuario;
  Long id_producto;
  */
}
