package com.tgestiona.apiProductoTgestiona.util;

import com.tgestiona.apiProductoTgestiona.dto.UsuarioDto;
import com.tgestiona.apiProductoTgestiona.entities.Usuario;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public UsuarioDto convertUsuarioToDto(Usuario usuario) {

        return modelMapper.map(usuario, UsuarioDto.class);
    }

    public List<UsuarioDto> convertEntityToDtos(List<Usuario> usuarios){
        return usuarios.stream()
                .map(usuario -> convertUsuarioToDto(usuario))
                .collect(Collectors.toList());
    }

    public Usuario convertUsuarioToEntity(UsuarioDto usuarioDto) {
        return modelMapper.map(usuarioDto, Usuario.class);
    }

    public Usuario map(Usuario usuarioToUpdate, Usuario usuario) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(usuarioToUpdate, usuario);
        return usuario;
    }
}
