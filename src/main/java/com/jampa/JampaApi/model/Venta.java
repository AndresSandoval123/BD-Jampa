package com.jampa.JampaApi.model;

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
  private BigDecimal precio_total;
  @Column(precision = 10, scale = 2)
  private BigDecimal valor_envio;
  /*Pendiente relacion
  Usuario, pedido y producto
   */

  @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
  private List<Pedido> pedidos;

  // si elimina una venta elimina el detalle de venta
  // fetch = FetchType.LAZ-> para que los detalles de ventas sean vistas facil desde el detalle de venta
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @JoinColumn(name = "id_venta")
  private DetalleEntrega detalleEntrega;
}
