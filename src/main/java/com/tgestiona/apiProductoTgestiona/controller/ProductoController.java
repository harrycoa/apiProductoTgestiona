package com.tgestiona.apiProductoTgestiona.controller;


import com.tgestiona.apiProductoTgestiona.dto.ProductoDto;
import com.tgestiona.apiProductoTgestiona.entities.Producto;
import com.tgestiona.apiProductoTgestiona.service.ProductoService;
import com.tgestiona.apiProductoTgestiona.util.ProductoDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class ProductoController {
    @Autowired
    private ProductoDtoConverter productoDtoConverter;

    @Autowired
    private ProductoService productoService;


    @GetMapping(value = "tgestiona/producto/{id}")
    public ResponseEntity<ProductoDto> findProductById(@PathVariable("id") Long id) {
        Producto producto = productoService.findProductById(id);
        return new ResponseEntity<>(productoDtoConverter.convertProductoToDto(producto), HttpStatus.OK);
    }

    @GetMapping(value = "tgestiona/productos")
    public ResponseEntity<List<ProductoDto>> findAllProducts() {
        List<Producto> productos = productoService.findAllProducts();
        return new ResponseEntity<>(productoDtoConverter.convertEntityToDtos(productos), HttpStatus.OK);
    }


    @PostMapping(value = "tgestiona/producto")
    public ResponseEntity<ProductoDto> createProduct(@RequestBody ProductoDto productoDto) {
        Producto newProduct = productoDtoConverter.convertProductoToEntity(productoDto);
        newProduct = productoService.saveProduct(newProduct);
        return new ResponseEntity<>(productoDtoConverter.convertProductoToDto(newProduct), HttpStatus.CREATED);
    }

    @PutMapping(value = "tgestiona/producto/{id}")
    public ResponseEntity<ProductoDto> updateProduct(@PathVariable("id") Long id, @RequestBody ProductoDto productoDto) {
        Producto productUpdate = productoService.findProductById(id);

        Producto updatedProduct = productoDtoConverter.map(productoDtoConverter.convertProductoToEntity(productoDto), productUpdate);
        updatedProduct = productoService.saveProduct(updatedProduct);
        return new ResponseEntity<>(productoDtoConverter.convertProductoToDto(updatedProduct), HttpStatus.OK);
    }

    @DeleteMapping(value = "tgestiona/producto/{id}")
    public ResponseEntity<ProductoDto> deleteProduct(@PathVariable("id") Long id) {
        Producto product = productoService.findProductById(id);
        productoService.deleteProduct(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
