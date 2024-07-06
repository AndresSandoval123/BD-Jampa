package com.jampa.JampaApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor //Gracias a Lombok podemos usar estos paquetes o metodos para ahorra codigo.
@AllArgsConstructor //Gracias a Lombok podemos usar estos paquetes o metodos para ahorra codigo.
@Getter //Gracias a Lombok podemos usar estos paquetes o metodos para ahorra codigo.
@Setter //Gracias a Lombok podemos usar estos paquetes o metodos para ahorra codigo.
@Entity //Se determina que es una entidad
@Table(name="usuarios") //Creacion de tabla
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //Nos permite decirle al id que se incremente automaticamente.

  private Long id_usuario;
  @Column(length = 35)
  private String nombre_usuario;
  @Column(length = 35)
  private String apellido_usuario;
  @Column(length = 40)
  private String correo_usuario;
  @Column(length = 40)
  private String contrasena_usuario;


}
