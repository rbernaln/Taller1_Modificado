/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1.Procesamiento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import taller1.Clases.Bebida;
import taller1.Clases.Combo;
import taller1.Clases.Ingrediente;
import taller1.Clases.Pedido;
import taller1.Clases.ProductoMenu;

/**
 *
 * @author perzi
 */
public class Aplicacion {
    Restaurante abismoLamentos = new Restaurante();
    List<Bebida> bebidasMenu = new ArrayList<>();
    List<ProductoMenu> productoMenu = new ArrayList<>();
    List<Combo> combos = new ArrayList<>();
    List<Ingrediente> ingredientes = new ArrayList<>();
    List<Bebida> bebidaPedido= new ArrayList<>();
    List<ProductoMenu> productoPedido= new ArrayList<>();
    List<Combo> combosPedido = new ArrayList<>();
    List<Ingrediente> ingredientePedido= new ArrayList<>();
    List<Bebida> bebidaPedidoAgregar = new ArrayList<>();
    List<ProductoMenu> productoPedidoAgregar= new ArrayList<>();
    List<Combo> combosPedidoAgregar = new ArrayList<>();
    List<Ingrediente> ingredientePedidoAgregar= new ArrayList<>();
    List<Pedido> pedidos= new ArrayList<>();
    //CreaciÃ³n del restaurante
    
    //Ejecutar AplicaciÃ³n
    public void ejecutarAplicacion() throws IOException{
        System.out.println("Cajero del restaurante el Abismo de los Lamentos\n");
        bebidasMenu=abismoLamentos.cargarBebidas("bebidas");
        productoMenu=abismoLamentos.cargarMenu("menu");
        combos=abismoLamentos.cargarCombos("combos");
        ingredientes=abismoLamentos.cargarIngredientes("ingredientes");
        boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
                                Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                                System.out.println("Seleccione una opciÃ³n: ");
                                String userName = myObj.nextLine();
                                int opcion_seleccionada = Integer.parseInt(userName);
                                if (opcion_seleccionada == 1)
					ejecutarMostrarMenu();
                                else if (opcion_seleccionada==2)
                                    ejecutarIniciarPedido();
                                else if (opcion_seleccionada==3)
                                    ejecutarAgregarProducto();
                                else if(opcion_seleccionada==4)
                                    ejecutarBuscarPedido();
                                else if (opcion_seleccionada==5)
                                       ejecutarCerrarPedido();
                                else if (opcion_seleccionada == 6)
				{
					System.out.println("Saliendo de la aplicaciÃ³n ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
    public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Consultar nuestro menú");
		System.out.println("2. Iniciar un pedido");
		System.out.println("3. Agregar un producto, combo o ingrediente a un pedido");
                System.out.println("4. Consultar un pedido por id");
		System.out.println("5. Cerrar un pedido");
		System.out.println("6.  Salir de la aplicación\n");
	}
    public void ejecutarMostrarMenu() throws IOException{
        System.out.println("*******Nuestros productos*******");
       for (int i=0;i<productoMenu.size();i++){
            System.out.println("Nombre del producto: "+productoMenu.get(i).getNombre());
            System.out.println("Precio del producto: "+productoMenu.get(i).getPrecioBase());
            System.out.println("Calorias del producto: "+productoMenu.get(i).getCalorias());
       }
        System.out.println("*******Combos*******");
        for (int i=0;i<combos.size();i++){
            System.out.println("Nombre del combo: "+combos.get(i).getNombreCombo());
            System.out.println("Descuento del combo: "+combos.get(i).getDescuento());
            System.out.println("Calorias del combo: "+combos.get(i).getCalorias());
            System.out.println("Los productos del combo son: ");
            for (int z=0;z<combos.get(i).getIngredientesCombo().size();z++){
                System.out.println(combos.get(i).getIngredientesCombo().get(z));
            }
        }
        System.out.println("*******Bebidas disponibles*******");
        for (int i=0;i<bebidasMenu.size();i++){
            System.out.println("Nombre de la bebida: "+bebidasMenu.get(i).getNombreBebida());
            System.out.println("Precio de la bebida: "+bebidasMenu.get(i).getPrecioBebida());
            System.out.println("Calorias de la bebida: "+bebidasMenu.get(i).getCalorias());
        }
        System.out.println("*******Ingredientes adicionales*******");
        for (int i=0;i<ingredientes.size();i++){
            System.out.println("Nombre del ingrediente: "+ingredientes.get(i).getNombre());
            System.out.println("Precio del ingrediente: "+ingredientes.get(i).getCostoAdicional());
            System.out.println("Calorias del ingrediente: "+ingredientes.get(i).getCalorias());
        }
    }
    public void ejecutarIniciarPedido(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Escriba su nombre: ");
        String userName = myObj.nextLine();
        System.out.println("Escriba su direccion: ");
        String direccion=myObj.nextLine();
        int randomNum = ThreadLocalRandom.current().nextInt(0, 100 + 1);
        productoPedido=abismoLamentos.productosPedidoLista((ArrayList<ProductoMenu>) productoMenu);
        combosPedido=abismoLamentos.combosPedidoLista((ArrayList<Combo>) combos);
        System.out.println(bebidaPedido=abismoLamentos.bebidasPedidoLista((ArrayList<Bebida>) bebidasMenu));
        ingredientePedido=abismoLamentos.ingredientesPedidoLista((ArrayList<Ingrediente>) ingredientes);
        this.pedidos.add(new Pedido(randomNum, userName, direccion, productoPedido, combosPedido, ingredientePedido,bebidaPedido));
        for (int i=0;i<pedidos.size();i++){
            System.out.println("--------------------------");
            System.out.println("Pedido número: "+pedidos.get(i).getIdPedidos());
            System.out.println("A nombre de la persona: "+pedidos.get(i).getNombreCliente());
            System.out.println("Con la dirección: "+pedidos.get(i).getDireccionCliente());
            System.out.println("--------------------------");
            for (int j=0;j<pedidos.get(i).getProductosPedido().size();j++){
                System.out.println("Producto: "+pedidos.get(i).getProductosPedido().get(j).getNombre());
            }
            for (int g=0;g<pedidos.get(i).getCombosPedido().size();g++){
                System.out.println("Combo: "+pedidos.get(i).getCombosPedido().get(g).getNombreCombo());
            }
            for (int h=0;h<pedidos.get(i).getIngredientesPedido().size();h++){
                System.out.println("Ingrediente: "+pedidos.get(i).getIngredientesPedido().get(h).getNombre());
            }
            for (int k=0;k<pedidos.get(i).getBebidasPedido().size();k++){
                System.out.println("Bebida: "+pedidos.get(i).getBebidasPedido().get(k).getNombreBebida());
            }
        }
    }
    public void ejecutarAgregarProducto(){
        System.out.println("Para agregar un producto a su pedido digite el id del mismo");
        Scanner myObj = new Scanner(System.in);
        System.out.println("Id del pedido: ");
        String userName = myObj.nextLine();
        int id=Integer.parseInt(userName);
        if (id==pedidos.get(0).getIdPedidos()){
                productoPedidoAgregar=abismoLamentos.productosPedidoLista((ArrayList<ProductoMenu>) productoMenu);
                combosPedidoAgregar=abismoLamentos.combosPedidoLista((ArrayList<Combo>) combos);
                ingredientePedidoAgregar=abismoLamentos.ingredientesPedidoLista((ArrayList<Ingrediente>) ingredientes);
                bebidaPedidoAgregar=abismoLamentos.bebidasPedidoLista((ArrayList<Bebida>) bebidasMenu);
        }
        pedidos.set(0, new Pedido(id,pedidos.get(0).getNombreCliente(),pedidos.get(0).getDireccionCliente(), productoPedidoAgregar, combosPedidoAgregar, ingredientePedidoAgregar,bebidaPedidoAgregar));
        for (int i=0;i<pedidos.size();i++){
            System.out.println("--------------------------");
            System.out.println("Pedido número: "+pedidos.get(i).getIdPedidos());
            System.out.println("A nombre de la persona: "+pedidos.get(i).getNombreCliente());
            System.out.println("Con la dirección: "+pedidos.get(i).getDireccionCliente());
            System.out.println("--------------------------");
            for (int j=0;j<pedidos.get(i).getProductosPedido().size();j++){
                System.out.println("Producto: "+pedidos.get(i).getProductosPedido().get(j).getNombre());
            }
            for (int g=0;g<pedidos.get(i).getCombosPedido().size();g++){
                System.out.println("Combo: "+pedidos.get(i).getCombosPedido().get(g).getNombreCombo());
            }
            for (int h=0;h<pedidos.get(i).getIngredientesPedido().size();h++){
                System.out.println("Ingrediente: "+pedidos.get(i).getIngredientesPedido().get(h).getNombre());
            }
            for (int k=0;k<pedidos.get(i).getBebidasPedido().size();k++){
                System.out.println("Bebida: "+pedidos.get(i).getBebidasPedido().get(k).getNombreBebida());
            }
        }
    
    }
    public void ejecutarCerrarPedido() throws IOException{
        List<List<String>> records = new ArrayList<>();
        String currentDirectory = new File("").getAbsolutePath();
        try (BufferedReader br = new BufferedReader(new FileReader(currentDirectory+"\\data\\Facturas.csv"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            records.add(Arrays.asList(values));
        }
        }
        records.remove(0);
        int precioTotal=abismoLamentos.cerrarPedido(pedidos, combos,productoMenu,ingredientes,bebidasMenu);
        System.out.println("Su total es de: "+precioTotal);
        Scanner myObj = new Scanner(System.in);
        System.out.println("Con cuanto dinero va a pagar: ");
        String userName = myObj.nextLine();
        int pago=Integer.parseInt(userName);
        ArrayList<ArrayList<String>> listaProductos = new ArrayList<>();
        listaProductos.add(new ArrayList<>());
        int calorias=0;
        if (pago>=precioTotal){
            FileWriter myWriter = new FileWriter(currentDirectory +"\\data\\"+pedidos.get(0).getIdPedidos()+".txt");
            myWriter.write("ID del pedido: "+pedidos.get(0).getIdPedidos());
            myWriter.write("\n");
            myWriter.write("Nombre del cliente: "+pedidos.get(0).getNombreCliente());
            myWriter.write("\n");
            myWriter.write("Dirección del cliente: "+pedidos.get(0).getDireccionCliente());
            myWriter.write("\n");
            myWriter.write("Precio Total: "+precioTotal);
            myWriter.write("\n");
            myWriter.write("Devuelta: "+(pago-precioTotal));
            myWriter.write("\n");
            for (int i=0;i<pedidos.get(0).getProductosPedido().size();i++){
                myWriter.write("Producto: "+pedidos.get(0).getProductosPedido().get(i).getNombre());
                listaProductos.get(0).add(pedidos.get(0).getProductosPedido().get(i).getNombre());
                myWriter.write("\n");
                myWriter.write("Calorias: "+pedidos.get(0).getProductosPedido().get(i).getCalorias());
                myWriter.write("\n");
                calorias=calorias+pedidos.get(0).getProductosPedido().get(i).getCalorias();
            }
            for (int g=0;g<pedidos.get(0).getCombosPedido().size();g++){
                myWriter.write("Combo: "+pedidos.get(0).getCombosPedido().get(g).getNombreCombo());
                listaProductos.get(0).add(pedidos.get(0).getCombosPedido().get(g).getNombreCombo());
                myWriter.write("\n");
                myWriter.write("Calorias: "+pedidos.get(0).getCombosPedido().get(g).getCalorias());
                myWriter.write("\n");
                calorias=calorias+pedidos.get(0).getCombosPedido().get(g).getCalorias();
            }
            for (int h=0;h<pedidos.get(0).getIngredientesPedido().size();h++){
                myWriter.write("Ingrediente: "+pedidos.get(0).getIngredientesPedido().get(h).getNombre());
                listaProductos.get(0).add(pedidos.get(0).getIngredientesPedido().get(h).getNombre());
                myWriter.write("\n");
                myWriter.write("Calorias: "+pedidos.get(0).getIngredientesPedido().get(h).getCalorias());
                myWriter.write("\n");
                calorias=calorias+pedidos.get(0).getIngredientesPedido().get(h).getCalorias();
            }
            for (int k=0;k<pedidos.get(0).getBebidasPedido().size();k++){
                myWriter.write("Bebida: "+pedidos.get(0).getBebidasPedido().get(k).getNombreBebida());
                listaProductos.get(0).add(pedidos.get(0).getBebidasPedido().get(k).getNombreBebida());
                myWriter.write("\n");
                myWriter.write("Calorias: "+pedidos.get(0).getBebidasPedido().get(k).getCalorias());
                myWriter.write("\n");
                calorias=calorias+pedidos.get(0).getBebidasPedido().get(k).getCalorias();
            }
            myWriter.write("Cantida de calorías total: "+calorias);
            myWriter.write("\n");
            myWriter.write("FELIZ DÍA");
            myWriter.write("\n");
            myWriter.close();
            FileWriter csvWriter;
            csvWriter =new FileWriter(currentDirectory +"\\data\\Facturas.csv");
            csvWriter.append("Pedido");
            csvWriter.append("\n");
            for (ArrayList<String> rowData : listaProductos) {
                    csvWriter.append(String.join(",", rowData));
                    csvWriter.append("\n");
                    }
            for (List<String> rowData : records) {
                    csvWriter.append(String.join(",", rowData));
                    csvWriter.append("\n");
                    }
            csvWriter.flush();
            csvWriter.close();
            for (int i=0;i<records.size();i++){
                listaProductos.get(0).removeAll(records.get(i));
                if (listaProductos.get(0).size()==0){
                    System.out.println("Se realizó un pedido idéntico antes");
                }
            }
            System.out.println("Factura impresa, Gracias por su compra");
        }else{
            System.out.println("Pago insuficiente intente de nuevo");
        }
    }
    public void ejecutarBuscarPedido(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Id del pedido: ");
        String userName = myObj.nextLine();
        int id=Integer.parseInt(userName);
        if (id==pedidos.get(0).getIdPedidos()){
            System.out.println("--------------------------");
            System.out.println("Pedido nÃºmero: "+pedidos.get(0).getIdPedidos());
            System.out.println("A nombre de la persona: "+pedidos.get(0).getNombreCliente());
            System.out.println("Con la direcciÃ³n: "+pedidos.get(0).getDireccionCliente());
            System.out.println("--------------------------");
            for (int j=0;j<pedidos.get(0).getProductosPedido().size();j++){
                System.out.println("Producto: "+pedidos.get(0).getProductosPedido().get(j).getNombre());
            }
            for (int g=0;g<pedidos.get(0).getCombosPedido().size();g++){
                System.out.println("Combo: "+pedidos.get(0).getCombosPedido().get(g).getNombreCombo());
            }
            for (int h=0;h<pedidos.get(0).getIngredientesPedido().size();h++){
                System.out.println("Ingrediente: "+pedidos.get(0).getIngredientesPedido().get(h).getNombre());
            }
            for (int k=0;k<pedidos.get(0).getBebidasPedido().size();k++){
                System.out.println("Bebida: "+pedidos.get(0).getBebidasPedido().get(k).getNombreBebida());
            }
            
        }
        
    }
    public static void main(String[] args) throws IOException{
        Aplicacion aplicacion= new Aplicacion();
        aplicacion.ejecutarAplicacion();
        // TODO code application logic here
    }
    
}
