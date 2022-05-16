package ui;


import java.util.ArrayList;
import java.util.Scanner;

import logic.ProductABML;
import model.Product;


public class Principal {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			Scanner lector = new Scanner(System.in);
			ProductABML prodABML=  new ProductABML();
			int ind;
			do {
				muestraMenu();
				ind = Integer.parseInt(lector.nextLine());
				switch(ind) {
				case 1:
					ArrayList<Product> productos = prodABML.findAll();
					System.out.println("Listado Productos");
					for(Product prod: productos) {
						System.out.println(prod);
					}
					break;
				case 2:
					System.out.println("Ingrese id a buscar");
					int idBuscado = Integer.parseInt(lector.nextLine());
					Product prodBuscado = prodABML.getOne(idBuscado);
					if(prodBuscado!= null) {
						System.out.println("Producto encontrado!");	
						System.out.println(prodBuscado);
					}
					
					break;
				case 3:
					Product prod = pideProduct();
					prodABML.create(prod);
					
					break;
				case 4:
					System.out.println("Ingrese id a borrar");
					int idABorrar = Integer.parseInt(lector.nextLine());
					prodABML.delete(idABorrar);
					
					break;
				case 5:
					System.out.println("Ingrese id a editar");
					int idAEditar = Integer.parseInt(lector.nextLine());
					Product edProd = pideProduct();
					edProd.setId(idAEditar);
					prodABML.edit(edProd);
					break;
				default:
					
				}
			}while (ind !=0);
			System.out.println("Programa cerrado");
			
			
			lector.close();
			
			
			
		
	}
	public static void muestraMenu() {
		
		System.out.println("Menu Principal");
		System.out.println("1- Mostrar todos los productos");
		System.out.println("2- Encontrar producto por id");
		System.out.println("3- Alta de producto");
		System.out.println("4- Borrar Producto");
		System.out.println("5- Editar Producto");
		System.out.println("0- Salir");
	}
	public static Product pideProduct() {
		Scanner lector  = new Scanner(System.in);
		Product prod = new Product();
		System.out.println("Ingrese nombre");
		prod.setName(lector.nextLine());
		System.out.println("Ingrese descripcion");
		prod.setDescription(lector.nextLine());
		System.out.println("Ingrese precio");
		prod.setPrice(Double.parseDouble(lector.nextLine()));
		System.out.println("Ingrese stock");
		prod.setStock(Integer.parseInt(lector.nextLine()));
		System.out.println("Presione S si tiene envio incluido \n Caso contrario, cualquier tecla");
		String shippingIn = lector.nextLine();
		if(shippingIn.equals("S")) {
			prod.setShippingIncluded(true);
		}
		else {
			prod.setShippingIncluded(false);
		}
		
		lector.close();
		return prod;
		
	}
	
	


}
