/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

/**
 *
 * @author Gilmar Gonzales
 */
public class calculoImpuestos {
    public double calcularSubTotal(String producto, int cantidad){
        validacionStock validacion = new validacionStock();
        double precio = validacion.obtenerPrecio(producto);
        return precio * cantidad;
    }
    
    public double calcularIGV(double subtotal){
        return subtotal * 0.18;
    }
    
}
