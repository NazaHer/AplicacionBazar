package com.bazar.aplicacion.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaClienteDTO {
    
    private long id_Venta;
    private double total;
    private int cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;

    public VentaClienteDTO(long id_Venta, double total, int cantidadProductos, String nombreCliente, String apellidoCliente) {
        this.id_Venta = id_Venta;
        this.total = total;
        this.cantidadProductos = cantidadProductos;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }
    
}
