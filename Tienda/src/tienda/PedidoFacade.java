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
            repository.guardar(pedido);
            
            rPedido.registrarPedido(cliente, producto, cantidad, subtotal, igv, total);
            gComprobante.generarComprobante(cliente, producto, subtotal, igv, total);
            fService.generarFactura(cliente, producto, subtotal, igv, total);
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
    
    private void notificar(Pedido pedido){
        for(PedidoObserver o : observers){
            o.actualizar(pedido);
        }
    }
    
}
