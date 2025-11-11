/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

/**
 *
 * @author Gilmar Gonzales
 */
public class Pedido {
    private final String cliente;
    private final String producto;
    private final int cantidad;
    private final double subtotal;
    private final double igv;
    private final double total;

    public Pedido(String cliente, String producto, int cantidad, double subtotal, double igv, double total) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
    }

    public String getCliente() {
        return cliente;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getIgv() {
        return igv;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Pedido{" + "cliente=" + cliente + ", producto=" + producto + ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", igv=" + igv + ", total=" + total + '}';
    }
    
    
    
}
