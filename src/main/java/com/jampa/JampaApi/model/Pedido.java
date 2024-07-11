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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "producto_id")
  @JsonIgnore
  private Producto producto;


  // Relación con Venta
  @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
//  @JsonBackReference
  @JsonIgnore
  private Venta venta;

  // un usuario pude tener muchos pedidos
  @ManyToOne
  @JoinColumn(name = "id_usuario", nullable = false)
//  @JsonBackReference// Evita la serialización circular si Usuario tiene referencia a Pedido
  @JsonIgnore
  private Usuario usuario;

}
