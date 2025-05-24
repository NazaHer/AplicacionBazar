package com.bazar.aplicacion.service;

import com.bazar.aplicacion.dto.VentaClienteDTO;
import com.bazar.aplicacion.model.Cliente;
import com.bazar.aplicacion.model.Producto;
import com.bazar.aplicacion.model.Venta;
import com.bazar.aplicacion.repository.InVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements InVentaService{
    
    @Autowired
    private InVentaRepository ventaRepo;

    @Override
    public List<Venta> getVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public void saveVenta(Venta v) {
        ventaRepo.save(v);
    }

    @Override
    public Venta findVenta(Long id) {
        return ventaRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public Venta editVenta(long id_Venta, LocalDate fecha_Venta, double total, List<Producto> productos, Cliente comprador) {
        Venta v = findVenta(id_Venta);
        v.actualizarValores(fecha_Venta, total, productos, comprador);
        ventaRepo.save(v);
        return findVenta(id_Venta);
    }

    @Override
    public List<Producto> productosVendidos(Long idVenta) {
        return findVenta(idVenta).getProductos();
    }

    @Override
    public String ventalTotalDeUnDia(LocalDate fecha) {
        double montoTotal = 0;
        double cantidadVentas = 0;
        for (Venta v : getVentas()) {
            if(fecha.isEqual(v.getFecha_Venta()) ){
                montoTotal = montoTotal + v.getTotal();
                cantidadVentas++;
            }
        }
        return "El día " + fecha + " se vendió " + "$" + montoTotal + ". Hubo " + cantidadVentas + " ventas.";
    }

    @Override
    public VentaClienteDTO mejorVenta() {
        Venta venta = null;
        double maximo = 0;
        Cliente cliente = null;
        for (Venta v : getVentas()) {
            if(v.getTotal() > maximo){
                maximo = v.getTotal();
                venta = v;
                cliente = v.getComprador();
            }
        }
        return new VentaClienteDTO(venta.getId_Venta(), venta.getTotal(), venta.getProductos().size(), cliente.getNombre(), cliente.getApellido());
    }

    @Override
    public int changuitoMasGrande() {
        int cantidadMaxima = 0;
        for (Venta v : getVentas()) {
            if(v.getProductos().size() > cantidadMaxima){
                cantidadMaxima = v.getProductos().size();
            }
        }
        return cantidadMaxima;
    }

    
    
}
