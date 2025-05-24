package com.bazar.aplicacion.service;

import com.bazar.aplicacion.model.Cliente;
import com.bazar.aplicacion.repository.InClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements InClienteService{
    
    @Autowired
    private InClienteRepository clienteRepo;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public void saveCliente(Cliente c) {
        clienteRepo.save(c);
    }

    @Override
    public Cliente findCliente(Long id) {
        return clienteRepo.findById(id).orElse(null);
    }

    @Override
    public void deteleCliente(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public Cliente editCliente(Long id, String nombre, String apellido, String dni) {
        Cliente c = findCliente(id);
        c.actualizarValores(nombre, apellido, dni);
        clienteRepo.save(c);
        return findCliente(id);
    }
    
}
