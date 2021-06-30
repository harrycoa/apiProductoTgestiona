package com.tgestiona.apiProductoTgestiona.util;

import com.tgestiona.apiProductoTgestiona.dto.ProductoDto;
import com.tgestiona.apiProductoTgestiona.entities.Producto;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductoDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public ProductoDto convertProductoToDto(Producto producto) {

        return modelMapper.map(producto, ProductoDto.class);
    }

    public List<ProductoDto> convertEntityToDtos(List<Producto> productos){
        return productos.stream()
                .map(producto -> convertProductoToDto(producto))
                .collect(Collectors.toList());
    }

    public Producto convertProductoToEntity(ProductoDto productoDto) {
        return modelMapper.map(productoDto, Producto.class);
    }

    public Producto map(Producto productoToUpdate, Producto producto) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(productoToUpdate, producto);
        return producto;
    }
}
