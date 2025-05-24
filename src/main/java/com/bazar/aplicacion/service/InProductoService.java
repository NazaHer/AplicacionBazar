package com.bazar.aplicacion.service;

import com.bazar.aplicacion.model.Producto;
import java.util.List;

public interface InProductoService {
    
    public List<Producto> getProductos();
    
    public void saveProducto(Producto p);
    
    public Producto findProducto(Long id);
    
    public void deleteProducto(Long id);
    
    public Producto editProducto(Long id, String nombre, String marca, double costo, double cantidad_disponible);
    
    public List<Producto> getProductosBajoStock();
    
}
