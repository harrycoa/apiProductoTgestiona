package com.tgestiona.apiProductoTgestiona.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="PRODUCTO")
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="COD_PRODUCTO", unique = true)
    private String cod_producto;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name = "PRECIO")
    private Double precio;

}
