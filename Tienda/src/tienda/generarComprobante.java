/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

/**
 *
 * @author Gilmar Gonzales
 */
public class generarComprobante {
    public void generarComprobante(String Cliente, String producto, double subtotal, double igv, double total){
        System.out.println("----Comprobante----");
        System.out.println("Comprobante para: " + Cliente);
        System.out.println("Producto: " + producto);
        System.out.println("Subtotal: " + subtotal);
        System.out.println("IGV: " + igv);
        System.out.println("Total: " + total);
    }
}
