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
  @Column(name = "producto_id", unique = true)
  private Long pedidoId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_venta")
  private Venta venta;

  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
  private List<Producto> productos;

  // un usuario pude tener muchos pedidos
  @ManyToOne
  @JoinColumn(name = "id_usuario", nullable = false)
  private Usuario usuario;

}
