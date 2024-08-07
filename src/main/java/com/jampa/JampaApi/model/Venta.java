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
  @Temporal(TemporalType.TIMESTAMP) // inserte automaticamente
  private Date fecha_venta;
  @Column(precision = 10, scale = 2)
  private BigDecimal valor_envio;
  @Column(nullable = false)
  private Boolean estado = true; // valor por defecto


  // Relación con Pedido
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
  private Pedido pedido;

  // Relación con DetalleEntrega
  @OneToOne(mappedBy = "venta", cascade = CascadeType.ALL)
//  @JsonManagedReference
  private DetalleEntrega detalleEntrega;

  @PrePersist
  protected void onCreate() {
    fecha_venta = new Date(); // Establece la fecha actual al momento de crear la venta
  }

}
