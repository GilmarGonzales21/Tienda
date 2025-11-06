/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tienda;
import java.util.Scanner;
/**
 *
 * @author Gilmar Gonzales
 */
public class Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre, producto;
        int cantidad;
        System.out.println("Ingrese su nombre: ");
        nombre = sc.nextLine();
        System.out.println("Ingrese el producto (cemento sol, cemento apu, cemento holcim: ");
        producto = sc.nextLine();
        System.out.println("Ingrese la cantidad que desea: ");
        cantidad = sc.nextInt();
        
        if (!producto.equalsIgnoreCase("cemento sol") &&!producto.equalsIgnoreCase("cemento apu")&&!producto.equalsIgnoreCase("cemento holcim")) {
            System.out.println("No disponible");
        }
        else {
            PedidoFacade pFacade = new PedidoFacade();
            pFacade.registrarPedido(nombre, producto, cantidad);
        }
    }
    
}
