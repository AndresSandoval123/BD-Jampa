package com.jampa.JampaApi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor //Gracias a Lombok podemos usar estos paquetes o metodos para ahorra codigo.
@AllArgsConstructor //Gracias a Lombok podemos usar estos paquetes o metodos para ahorra codigo.
@Getter //Gracias a Lombok podemos usar estos paquetes o metodos para ahorra codigo.
@Setter //Gracias a Lombok podemos usar estos paquetes o metodos para ahorra codigo.
@Entity
@Table(name = "productos") //Creacion de tabla
public class Producto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_producto;
  @Column(length = 35)
  private String nombre_producto;
  @Column(length = 70)
  private String descripcion;
  @Column(length = 10)
  private String color;
  @Column(length = 5)
  private String talla;
  @Column(name = "stock_disponible")
  private int stockDisponible;
  @Column(precision = 10, scale = 2)//De esta manera se parametriza para que de dos decimales unicamente y en tipo de dato es BigDecimal
  private BigDecimal precio_producto;
  @Column(length = 15)
  private String categoria;

  @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Pedido> pedidos;


  // un usuario pude tener muchos pedidos
  @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
  //@JsonIgnore
  private List<Imagen> imagen;

}
