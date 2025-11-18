/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

/**
 *
 * @author Gilmar Gonzales
 */
public class LogObserver implements PedidoObserver{

    @Override
    public void actualizar(Pedido pedido) {
        System.out.println(" Nuevo pedido registrado: " + pedido);
    }
    
}
