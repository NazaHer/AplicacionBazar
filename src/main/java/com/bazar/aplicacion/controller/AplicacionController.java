package com.bazar.aplicacion.controller;

import com.bazar.aplicacion.dto.VentaClienteDTO;
import com.bazar.aplicacion.model.Cliente;
import com.bazar.aplicacion.model.Producto;
import com.bazar.aplicacion.model.Venta;
import com.bazar.aplicacion.service.InClienteService;
import com.bazar.aplicacion.service.InProductoService;
import com.bazar.aplicacion.service.InVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AplicacionController {
    
    @Autowired
    private InProductoService produService;
    
    @Autowired
    private InClienteService clienteService;
    
    @Autowired
    private InVentaService veService;
    
    //1)
    @GetMapping("/saludo")
    public String saludoPrincipal(){
        return "Bienvenido a nuestro bazar.";
    }
    
    @PostMapping("/productos/crear")
    public String createProducto(@RequestBody Producto p){
        produService.saveProducto(p);
        return p.getNombre() + " registrado con éxito.";
    }
    
    @GetMapping("/productos")
    public List<Producto> getProductos(){
        return produService.getProductos();
    }
    
    @GetMapping("/productos/{id}")
    public Producto getProducto(@PathVariable Long id){
        return produService.findProducto(id);
    }
    
    @DeleteMapping("/productos/eliminar/{id}")
    public String deleteProducto(@PathVariable Long id){
        String nombre = produService.findProducto(id).getNombre();
        produService.deleteProducto(id);
        return nombre + " fue elimado.";
    }
    
    @PutMapping("/productos/editar/{id}")
    public Producto editProducto(@PathVariable Long id,
            @RequestParam (required = false, name = "nombre")String nuevoNombre,
            @RequestParam (required = false, name = "marca") String nuevaMarca,
            @RequestParam (required = false, name = "costo") double nuevoCosto,
            @RequestParam (required = false, name = "cantidad_disponible") double nuevaCantidad){
        produService.editProducto(id, nuevoNombre, nuevaMarca, nuevoCosto, nuevaCantidad);
        return getProducto(id);
    }
    
    //2)
    @PostMapping("/clientes/crear")
    public String createClente(@RequestBody Cliente c){
        clienteService.saveCliente(c);
        return c.getNombre() + " " + c.getApellido() + " registrado con éxito.";
    }
    
    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }
    
    @GetMapping("/clientes/{id}")
    public Cliente getCliente(@PathVariable Long id){
        return clienteService.findCliente(id);
    }
    
    @DeleteMapping("/clientes/eliminar/{id}")
    public String deleteCliente(@PathVariable Long id){
        String nombreCompleto = clienteService.findCliente(id).getNombre() + " " + clienteService.findCliente(id).getApellido();
        clienteService.deteleCliente(id);
        return nombreCompleto + " fue eliminado.";
    }
    
    @PutMapping("/clientes/editar/{id}")
    public Cliente editCliente(@PathVariable Long id,
            @RequestParam (required = false, name = "nombre") String nuevoNombre,
            @RequestParam (required = false, name = "apellido") String nuevoApellido,
            @RequestParam (required = false, name = "dni") String nuevoDni){
        clienteService.editCliente(id, nuevoNombre, nuevoApellido, nuevoDni);
        return getCliente(id);
    }
    
    //3)
    @PostMapping("/ventas/crear")
    public String createVenta(@RequestBody Venta v){
        veService.saveVenta(v);
        return "La venta n° " + v.getId_Venta() + " fue creada con éxito.";
    }
    
    @GetMapping("/ventas")
    public List<Venta> getVentas(){
        return veService.getVentas();
    }
    
    @GetMapping("/ventas/{id}")
    public Venta getVenta(@PathVariable Long id){
        return veService.findVenta(id);
    }
    
    @DeleteMapping("/ventas/eliminar/{id}")
    public String deleteVenta(@PathVariable Long id){
        String idVenta = String.valueOf(veService.findVenta(id).getId_Venta());
        veService.deleteVenta(id);
        return "La venta n°" + idVenta + " fue eliminada.";
    }
    
    @PutMapping("/ventas/editar/{id}")
    public Venta editVenta(@PathVariable Long id,
            @RequestParam (required = false, name = "fecha_Venta") LocalDate nuevaFecha,
            @RequestParam (required = false, name = "total") double nuevoTotal,
            @RequestParam (required = false, name = "productos") List<Producto> nuevosProductos,
            @RequestParam (required = false, name = "comprador") Cliente nuevoComprador){
        veService.deleteVenta(id);
        return getVenta(id);
    }
    
    //4)
    @GetMapping("/productos/falta_stock")
    public List<Producto> getProductosBajoStock(){
        return produService.getProductosBajoStock();
    }
    
    //5)
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> productosPorVenta(@PathVariable Long codigo_venta){
        return veService.productosVendidos(codigo_venta);
    }
    
    //6)
    @GetMapping("/ventas/fecha/{fecha_venta}")
    public String getMontoDeVentasPorFecha(@PathVariable LocalDate fecha_venta){
        return veService.ventalTotalDeUnDia(fecha_venta);
    }
    
    //7)
    @GetMapping("/ventas/mayor_venta")
    public VentaClienteDTO getMejorVenta(){
        return veService.mejorVenta();
    }
    
    //8)
    @GetMapping("/ventas/changuito_mas_grande")
    public String changuitoMasGrande(){
        return "El changuito mas grande tiene " + veService.changuitoMasGrande() + " items.";
    }
    
}
