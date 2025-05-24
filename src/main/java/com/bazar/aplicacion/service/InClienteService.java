package com.bazar.aplicacion.service;

import com.bazar.aplicacion.model.Cliente;
import java.util.List;

public interface InClienteService {
   
    public List<Cliente> getClientes();
    
    public void saveCliente(Cliente c);
    
    public Cliente findCliente(Long id);
    
    public void deteleCliente(Long id);
    
    public Cliente editCliente(Long id, String nombre, String apellido, String dni);
    
}
