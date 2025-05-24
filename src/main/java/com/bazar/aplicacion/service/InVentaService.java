package com.bazar.aplicacion.service;

import com.bazar.aplicacion.dto.VentaClienteDTO;
import com.bazar.aplicacion.model.Cliente;
import com.bazar.aplicacion.model.Producto;
import com.bazar.aplicacion.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface InVentaService {
    
    public List<Venta> getVentas();
    
    public void saveVenta(Venta v);
    
    public Venta findVenta(Long id);
    
    public void deleteVenta(Long id);
    
    public Venta editVenta(long id_Venta, LocalDate fecha_Venta, double total, List<Producto> productos, Cliente comprador);
    
    public List<Producto> productosVendidos(Long idVenta); 
    
    public String ventalTotalDeUnDia(LocalDate fecha);
    
    public VentaClienteDTO mejorVenta();
    
    public int changuitoMasGrande();
    
}
