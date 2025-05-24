package com.bazar.aplicacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_Venta;
    private LocalDate fecha_Venta;
    private double total;
    @OneToMany
    private List<Producto> productos;
    @OneToOne
    private Cliente comprador;

    public Venta() {
    }

    public Venta(long id_Venta, LocalDate fecha_Venta, double total, List<Producto> productos, Cliente comprador) {
        this.id_Venta = id_Venta;
        this.fecha_Venta = fecha_Venta;
        this.total = total;
        this.productos = productos;
        this.comprador = comprador;
    }

    public void actualizarValores(LocalDate fecha_Venta, double total, List<Producto> productos, Cliente comprador) {
        setFecha_Venta(fecha_Venta);
        setTotal(total);
        setProductos(productos);
        setComprador(comprador);
    }
    
}
