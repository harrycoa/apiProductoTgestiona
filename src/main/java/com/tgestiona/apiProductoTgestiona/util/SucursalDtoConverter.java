package com.tgestiona.apiProductoTgestiona.util;

import com.tgestiona.apiProductoTgestiona.dto.SucursalDto;
import com.tgestiona.apiProductoTgestiona.dto.UsuarioDto;
import com.tgestiona.apiProductoTgestiona.entities.Sucursal;
import com.tgestiona.apiProductoTgestiona.entities.Usuario;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SucursalDtoConverter {
    @Autowired
    private ModelMapper modelMapper;

    public SucursalDto convertSucursalToDto(Sucursal sucursal) {

        return modelMapper.map(sucursal, SucursalDto.class);
    }

    public List<SucursalDto> convertEntityToDtos(List<Sucursal> sucursales){
        return sucursales.stream()
                .map(sucursal -> convertSucursalToDto(sucursal))
                .collect(Collectors.toList());
    }

    public Sucursal convertSucursalToEntity(SucursalDto sucursalDto) {
        return modelMapper.map(sucursalDto, Sucursal.class);
    }

    public Sucursal map(Sucursal sucursalToUpdate, Sucursal sucursal) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(sucursalToUpdate, sucursal);
        return sucursal;
    }
}
