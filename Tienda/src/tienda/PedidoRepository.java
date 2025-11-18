/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author Gilmar Gonzales
 */
public class PedidoRepository {
    private final List<Pedido> pedidos = new ArrayList<>();
    private final String archivoPedidos = "Pedidos.txt";
    public void guardar(Pedido pedido) {
        pedidos.add(pedido);
        guardarEnArchivo(pedido);
        System.out.println("Pedido guardado: " + pedido);
    }
    private void guardarEnArchivo(Pedido pedido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoPedidos, true))) {
            writer.write(pedido.toString());
            writer.newLine();  // Añadir nueva línea para cada pedido
        } catch (IOException e) {
            System.out.println("Error al guardar el pedido en el archivo.");
            e.printStackTrace();
        }
    }
    private void cargarDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoPedidos))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Aquí necesitamos analizar la línea para crear un pedido
                // Suponiendo que cada línea está formateada como en el método toString de Pedido
                String[] partes = line.replace("Pedido{", "").replace("}", "").split(", ");
                String cliente = partes[0].split("=")[1];
                String producto = partes[1].split("=")[1];
                int cantidad = Integer.parseInt(partes[2].split("=")[1]);
                double subtotal = Double.parseDouble(partes[3].split("=")[1]);
                double igv = Double.parseDouble(partes[4].split("=")[1]);
                double total = Double.parseDouble(partes[5].split("=")[1]);
                pedidos.add(new Pedido(cliente, producto, cantidad, subtotal, igv, total));
            }
        } catch (IOException e) {
            System.out.println("Error al leer los pedidos del archivo.");
            e.printStackTrace();
        }
    }
    public List<Pedido> listarTodos() {
        cargarDesdeArchivo();
        return Collections.unmodifiableList(pedidos);
    }
}
