package com.tgestiona.apiProductoTgestiona.controller;

import com.tgestiona.apiProductoTgestiona.dto.SucursalDto;
import com.tgestiona.apiProductoTgestiona.dto.UsuarioDto;
import com.tgestiona.apiProductoTgestiona.entities.Sucursal;
import com.tgestiona.apiProductoTgestiona.entities.Usuario;
import com.tgestiona.apiProductoTgestiona.service.SucursalService;
import com.tgestiona.apiProductoTgestiona.util.SucursalDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;

    @Autowired
    private SucursalDtoConverter sucursalDtoConverter;


    @GetMapping(value = "tgestiona/sucursal/{id}")
    public ResponseEntity<SucursalDto> findSucursalById(@PathVariable("id") Long id) {
        Sucursal sucursal = sucursalService.findSucursalById(id);
        return new ResponseEntity<>(sucursalDtoConverter.convertSucursalToDto(sucursal), HttpStatus.OK);
    }

    @GetMapping(value = "tgestiona/sucursales")
    public ResponseEntity<List<SucursalDto>> findAllSucursals() {
        List<Sucursal> sucursals = sucursalService.findAllSucursals();
        return new ResponseEntity<>(sucursalDtoConverter.convertEntityToDtos(sucursals), HttpStatus.OK);
    }


    @PostMapping(value = "tgestiona/sucursal")
    public ResponseEntity<SucursalDto> createSucursal(@RequestBody SucursalDto sucursalDto) {
        Sucursal newSucursal = sucursalDtoConverter.convertSucursalToEntity(sucursalDto);
        newSucursal = sucursalService.saveSucursal(newSucursal);
        return new ResponseEntity<>(sucursalDtoConverter.convertSucursalToDto(newSucursal), HttpStatus.CREATED);
    }

    @PutMapping(value = "tgestiona/sucursal/{id}")
    public ResponseEntity<SucursalDto> updateSucursal(@PathVariable("id") Long id, @RequestBody SucursalDto sucursalDto) {
        Sucursal sucursalUpdate = sucursalService.findSucursalById(id);

        Sucursal updatedSucursal = sucursalDtoConverter.map(sucursalDtoConverter.convertSucursalToEntity(sucursalDto), sucursalUpdate);
        updatedSucursal = sucursalService.saveSucursal(updatedSucursal);
        return new ResponseEntity<>(sucursalDtoConverter.convertSucursalToDto(updatedSucursal), HttpStatus.OK);
    }

    @DeleteMapping(value = "tgestiona/sucursal/{id}")
    public ResponseEntity<SucursalDto> deleteSucursal(@PathVariable("id") Long id) {
        Sucursal sucursal = sucursalService.findSucursalById(id);
        sucursalService.deleteSucursal(sucursal);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
