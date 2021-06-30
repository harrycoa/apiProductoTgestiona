package com.tgestiona.apiProductoTgestiona.dto;
import com.tgestiona.apiProductoTgestiona.entities.Sucursal;
import lombok.Data;

@Data
public class UsuarioDto {
    private Long id;
    private String cod_usuario;
    private String nombre;
    private String usuario;
    private String password;
    private Sucursal sucursal;
}
