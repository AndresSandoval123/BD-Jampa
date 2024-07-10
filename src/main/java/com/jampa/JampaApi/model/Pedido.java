package com.jampa.JampaApi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
  @Column(name = "cantidad")
  private int cantidad;
  //@Column(name = "producto_id", unique = true)
  //private Long pedidoId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "producto_id")
  //@JsonManagedReference
  private Producto producto;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_venta")
  private Venta venta;



  // un usuario pude tener muchos pedidos
  @ManyToOne
  @JoinColumn(name = "id_usuario", nullable = false)
  //@JsonBackReference
  @JsonIgnore
  private Usuario usuario;

}
