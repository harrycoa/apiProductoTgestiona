package com.tgestiona.apiProductoTgestiona.service;

import com.tgestiona.apiProductoTgestiona.entities.Sucursal;
import com.tgestiona.apiProductoTgestiona.exceptions.SucursalNotFoundException;
import com.tgestiona.apiProductoTgestiona.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;

    public Sucursal findSucursalById(Long id) {
        Optional<Sucursal> sucursal = sucursalRepository.findById(id);
        return sucursal
                .orElseThrow(() -> new SucursalNotFoundException("Sucursal no encontrado"));
    }

    public List<Sucursal> findAllSucursals(){
        return sucursalRepository.findAll();
    }

    public Sucursal saveSucursal(Sucursal sucursal){
        return sucursalRepository.save(sucursal);
    }

    public void deleteSucursal(Sucursal sucursal){
        sucursalRepository.delete(sucursal);
    }
}
