package com.bazar.aplicacion.repository;

import com.bazar.aplicacion.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InProductoRepository extends JpaRepository<Producto, Long>{
    
}
