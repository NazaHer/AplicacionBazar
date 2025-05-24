package com.bazar.aplicacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_Producto;
    private String nombre;
    private String marca;
    private double costo;
    private double cantidad_disponible;

    public Producto() {
    }

    public Producto(long id_Producto, String nombre, String marca, double costo, double cantidad_disponible) {
        this.id_Producto = id_Producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
    }

    public void actualizarValores(String nombre, String marca, double costo, double cantidad_disponible) {
        setNombre(nombre);
        setMarca(marca);
        setCosto(costo);
        setCantidad_disponible(cantidad_disponible);
    }
    
    
    
}
