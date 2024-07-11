package com.jampa.JampaApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ventas")
public class Venta {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_venta;
  private Date fecha_venta;
  @Column(precision = 10, scale = 2)
  private BigDecimal valor_envio;


  // Relación con Pedido
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
  @JsonManagedReference
  private Pedido pedido;

  // Relación con DetalleEntrega
  @OneToOne(mappedBy = "venta", cascade = CascadeType.ALL)
  @JsonManagedReference
  private DetalleEntrega detalleEntrega;

  //@OneToOne(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  //private DetalleEntrega detalleEntrega;
}
