/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

/**
 *
 * @author Gilmar Gonzales
 */
public class FacturaAdapter implements FacturaService{

    private LegacyBillingSystem System;
    public FacturaAdapter(){
        System = new LegacyBillingSystem();
    }
    
    @Override
    public void generarFactura(String cliente, String producto, double subtotal, double igv, double total) {
        System.emitirFactura(cliente, producto, subtotal, igv, total);
    }
    
}
