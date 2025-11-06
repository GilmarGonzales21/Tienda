/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

/**
 *
 * @author Gilmar Gonzales
 */
public class registroPedido {
    public void registrarPedido(String tienda, String producto, int cantidad, double subtotal, double igv, double total){
        System.out.println("----Registro----");
        System.out.println("Pedido registrado para: " + tienda);
        System.out.println("Producto: " + producto + " | Cantidad: " + cantidad);
        System.out.println("Subtotal: " + subtotal + " | IGV: " + igv + " | Total: " + total);
    }
}
