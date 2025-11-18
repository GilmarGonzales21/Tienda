/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

/**
 *
 * @author Gilmar Gonzales
 */
public class validacionStock {
    private Producto cementoSol = new Producto("Cemento Sol", 30, 15);
    private Producto cementoApu = new Producto("Cemento Apu", 27.5, 20);
    private Producto cementoHolcim = new Producto("Cemento Holcim", 29, 5);

    
    public boolean validarStock(String producto, int cantidad){
        switch (producto.toLowerCase()) {
            case "cemento sol":
                return cementoSol.validarStock(cantidad);
            case "cemento apu":
                return cementoApu.validarStock(cantidad);
            case "cemento holcim":
                return cementoHolcim.validarStock(cantidad);
            default:
                System.out.println("Producto no disponible");
                return false;
        }
    }
    
    
    
    public double obtenerPrecio(String producto){
        switch (producto.toLowerCase()) {
            case "cemento sol":
                return cementoSol.getPrecio();
            case "cemento apu":
                return cementoApu.getPrecio();
            case "cemento holcim":
                return cementoHolcim.getPrecio();
            default:
                System.out.println("Producto no valido");
                return 0;
        }
    }
    
}
