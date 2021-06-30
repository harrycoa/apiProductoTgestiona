package com.tgestiona.apiProductoTgestiona.service;

import com.tgestiona.apiProductoTgestiona.entities.Producto;
import com.tgestiona.apiProductoTgestiona.exceptions.ProductoNotFoundException;
import com.tgestiona.apiProductoTgestiona.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;


    public Producto findProductById(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        return producto
                .orElseThrow(() -> new ProductoNotFoundException("Producto no encontrado"));
    }

    public List<Producto> findAllProducts(){
        return productoRepository.findAll();
    }

    public Producto saveProduct(Producto producto){
        return productoRepository.save(producto);
    }

    public void deleteProduct(Producto producto){
        productoRepository.delete(producto);
    }
}
