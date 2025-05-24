package com.bazar.aplicacion.repository;

import com.bazar.aplicacion.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InVentaRepository extends JpaRepository<Venta, Long> {
    
}
