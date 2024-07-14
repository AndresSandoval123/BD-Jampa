package com.jampa.JampaApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "imagen")
public class Imagen {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_magen;
  @Column(nullable = false)
  private String url_imagen;
  /* Pendiente relación
  id_producto
  */

  // un producto pude tener una o varias fotos
  @ManyToOne
  @JoinColumn(name = "id_producto", nullable = false)
  @JsonIgnore
  private Producto producto;
}
