package logic;

import java.util.ArrayList;

import data.ProductData;
import entity.Product;

public class ProductABMC {
	private ProductData prodData = new ProductData();
	
	public void create(Product prod) {
		this.prodData.create(prod);
	}
	public void delete(int id) {
		this.prodData.delete(id);
	}
	public ArrayList<Product> traerTodos(){
		return this.prodData.findAll();
	}
	public Product traerPorId(int id) {
		return this.prodData.getOne(id);
	}
	public void edit(Product prod, int id) {
		this.prodData.edit(id,prod);
	}
	
	
	/*
	 * ID ni ShippingIncluded hace falta que esten validado
	 */
	
}
