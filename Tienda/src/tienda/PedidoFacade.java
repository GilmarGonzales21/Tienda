/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gilmar Gonzales
 */ 
//subject
public class PedidoFacade {
    private validacionStock vStock;
    private calculoImpuestos cImpuestos;
    private registroPedido rPedido;
    private generarComprobante gComprobante;
    private FacturaService fService;
    private PedidoRepository repository;
    private ImpuestoStrategy impuestoStrateg;
    private List<PedidoObserver> observers = new ArrayList<>();

    public PedidoFacade(ImpuestoStrategy strategy){
        vStock = new validacionStock();
        cImpuestos = new calculoImpuestos();
        rPedido = new registroPedido();
        gComprobante = new generarComprobante();
        fService = new FacturaAdapter();
        repository = new PedidoRepository();
        impuestoStrateg = strategy;
    }
    
        public void setImpuestoStrategy(ImpuestoStrategy strategy) {
        impuestoStrateg = strategy;
    }
    
    public void registrarPedido(String cliente, String producto, int cantidad){
        if (vStock.validarStock(producto, cantidad)) {
            double subtotal = cImpuestos.calcularSubTotal(producto, cantidad);
            
            double igv = impuestoStrateg.calcular(subtotal);
            double total = subtotal + igv;
            
            Pedido pedido = new Pedido(cliente, producto, cantidad, subtotal, igv, total);
            
            // HILO 1: procesar/guardar pedido
            HiloProcesarPedido hilo1 = new HiloProcesarPedido(repository, rPedido, pedido);
            hilo1.run();

            // HILO 2: generar comprobante y factura
            HiloGenerarFactura hilo2 = new HiloGenerarFactura(gComprobante, fService, pedido);
            hilo2.start();

            // HILO 3: notificar observadores (cliente, inventario, log)
            HiloNotificaciones hilo3 = new HiloNotificaciones(this, pedido);
            hilo3.start();
            repository.guardar(pedido);
            
           
        } else {
            System.out.println("Stock insuficiente para "+ producto);
        }
    }
    
    public void listarPedido() {
        repository.listarTodos().forEach(System.out::println);
    }
    
    public void agregarObserver(PedidoObserver o){
        observers.add(o);
    }
    
    void notificar(Pedido pedido){
        for(PedidoObserver o : observers){
            o.actualizar(pedido);
        }
    }
    
}
