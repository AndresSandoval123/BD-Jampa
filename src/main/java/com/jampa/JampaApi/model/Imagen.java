package com.jampa.JampaApi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "imagenes")
public class Imagen {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_magen;
  private String url_imagen;
  /* Pendiente relación
  id_producto
   */
}
