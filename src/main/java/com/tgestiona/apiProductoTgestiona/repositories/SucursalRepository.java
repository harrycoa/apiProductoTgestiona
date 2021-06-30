package com.tgestiona.apiProductoTgestiona.repositories;


import com.tgestiona.apiProductoTgestiona.entities.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
}
