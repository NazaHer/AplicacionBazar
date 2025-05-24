package com.bazar.aplicacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_Cliente;
    private String nombre;
    private String apellido;
    private String dni;

    public Cliente() {
    }

    public Cliente(long id_Cliente, String nombre, String apellido, String dni) {
        this.id_Cliente = id_Cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public void actualizarValores(String nombre, String apellido, String dni) {
        setNombre(nombre);
        setApellido(apellido);
        setDni(dni);
    }
    
    
    
}
