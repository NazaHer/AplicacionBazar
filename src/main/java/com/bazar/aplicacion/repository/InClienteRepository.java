package com.bazar.aplicacion.repository;

import com.bazar.aplicacion.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InClienteRepository extends JpaRepository<Cliente, Long> {
    
}
