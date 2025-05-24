package com.bazar.aplicacion.service;

import com.bazar.aplicacion.model.Producto;
import com.bazar.aplicacion.repository.InProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements InProductoService {
    
    @Autowired
    private InProductoRepository productoRepo;

    @Override
    public List<Producto> getProductos() {
        return productoRepo.findAll();
    }

    @Override
    public void saveProducto(Producto p) {
        productoRepo.save(p);
    }

    @Override
    public Producto findProducto(Long id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepo.deleteById(id);
    }

    @Override
    public Producto editProducto(Long id, String nombre, String marca, double costo, double cantidad_disponible) {
        Producto p = findProducto(id);
        p.actualizarValores(nombre, marca, costo, cantidad_disponible);
        productoRepo.save(p);
        return findProducto(id);
    }

    @Override
    public List<Producto> getProductosBajoStock() {
        List<Producto> lista = new ArrayList<Producto>();
        for (Producto p : getProductos()) {
            if(p.getCantidad_disponible() <= 5){
                lista.add(p);
            }
        }
        return lista;
    }

}
