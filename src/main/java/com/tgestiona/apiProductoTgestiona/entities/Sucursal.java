package com.tgestiona.apiProductoTgestiona.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="SUCURSAL")
@Entity
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="COD_SUCURSAL", unique = true)
    public String cod_sucursal;

    @Column(name="NOMBRE")
    public String nombre;
}
