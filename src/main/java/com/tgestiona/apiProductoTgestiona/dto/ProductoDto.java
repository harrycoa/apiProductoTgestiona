package com.tgestiona.apiProductoTgestiona.dto;

import lombok.Data;

@Data
public class ProductoDto {
    private Long id;
    private String cod_producto;
    private String nombre;
    private Double precio;

}
