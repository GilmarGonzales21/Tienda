/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

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
    
    public PedidoFacade(){
        vStock = new validacionStock();
        cImpuestos = new calculoImpuestos();
        rPedido = new registroPedido();
        gComprobante = new generarComprobante();
        fService = new FacturaAdapter();
        repository = new PedidoRepository();
    }
    
    public void registrarPedido(String cliente, String producto, int cantidad){
        if (vStock.validarStock(producto, cantidad)) {
            double subtotal = cImpuestos.calcularSubTotal(producto, cantidad);
            double igv = cImpuestos.calcularIGV(subtotal);
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
    
}
