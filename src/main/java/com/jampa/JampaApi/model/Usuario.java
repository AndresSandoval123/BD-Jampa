package com.jampa.JampaApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor //Gracias a Lombok podemos usar estos paquetes o metodos para ahorra codigo.
@AllArgsConstructor //Gracias a Lombok podemos usar estos paquetes o metodos para ahorra codigo.
@Getter //Gracias a Lombok podemos usar estos paquetes o metodos para ahorra codigo.
@Setter //Gracias a Lombok podemos usar estos paquetes o metodos para ahorra codigo.
@Entity //Se determina que es una entidad
@Table(name="usuarios") //Creación de tabla
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

  // un usuario pude tener muchos pedidos
  @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
  //@JsonManagedReference // evitar la recursión infinita al serialización JSON.
  private List<Pedido> pedidos;

}
