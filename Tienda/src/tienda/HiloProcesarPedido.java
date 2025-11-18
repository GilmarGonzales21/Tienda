/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

/**
 *
 * @author Gilmar Gonzales
 */
public class HiloProcesarPedido {
    private PedidoRepository repository;
    private registroPedido rPedido;
    private Pedido pedido;

    public HiloProcesarPedido(PedidoRepository repository, registroPedido rPedido, Pedido pedido) {
        this.repository = repository;
        this.rPedido = rPedido;
        this.pedido = pedido;
    }

    public void run() {
        try {

        repository.guardar(pedido);
        rPedido.registrarPedido(
                    pedido.getCliente(),
                    pedido.getProducto(),
                    pedido.getCantidad(),
                    pedido.getSubtotal(),
                    pedido.getIgv(),
                    pedido.getTotal()
            );
        System.out.println("notificado");
            Thread.sleep(3000);  
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
}

class HiloGenerarFactura extends Thread {

    private generarComprobante gComprobante;
    private FacturaService fService;
    private Pedido pedido;

    public HiloGenerarFactura(generarComprobante gComprobante, FacturaService fService, Pedido pedido) {
        this.gComprobante = gComprobante;
        this.fService = fService;
        this.pedido = pedido;
    }

    @Override
    public void run() {
        try {
            
        
        gComprobante.generarComprobante(
                pedido.getCliente(),
                pedido.getProducto(),
                pedido.getSubtotal(),
                pedido.getIgv(),
                pedido.getTotal()
        );
        fService.generarFactura(
                pedido.getCliente(),
                pedido.getProducto(),
                pedido.getSubtotal(),
                pedido.getIgv(),
                pedido.getTotal()
        );
        System.out.println("notificado");
        
        Thread.sleep(3000); // 3 segundos
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class HiloNotificaciones extends Thread {

    private PedidoFacade facade;
    private Pedido pedido;

    public HiloNotificaciones(PedidoFacade facade, Pedido pedido) {
        this.facade = facade;
        this.pedido = pedido;
    }

    @Override
    public void run() {
        try {
            
            facade.notificar(pedido);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
