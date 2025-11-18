/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

/**
 *
 * @author Gilmar Gonzales
 */
public class ClienteObserver implements PedidoObserver{

    @Override
    public void actualizar(Pedido pedido) {
        System.out.println("Se notifico al cleinte: " + pedido.getCliente()+" por el pedido de " + pedido.getProducto() + " \n Total: " + pedido.getTotal());
    }
    
}
