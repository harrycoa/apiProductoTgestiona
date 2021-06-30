package com.tgestiona.apiProductoTgestiona.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="USUARIO")
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="COD_USUARIO", unique = true)
    private String cod_usuario;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="USUARIO")
    private String usuario;

    @Column(name="PASSWORD")
    private String password;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "SUCURSAL_ID", referencedColumnName = "ID")
    private Sucursal sucursal;


}
