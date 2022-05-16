package logic;

import java.util.ArrayList;

import model.Product;
import repository.ProductRepository;

public class ProductABML {
	private ProductRepository prodRepo = new ProductRepository();
	public void create(Product prod){
		prodRepo.create(prod);
	}
	
	public void edit(Product prod) {
		prodRepo.edit(prod);
	}
	public void delete(int id) {
		prodRepo.delete(id);
	}
	public ArrayList<Product> findAll(){
		return prodRepo.findAll();
	}
	public Product getOne(int id) {
		return prodRepo.getOne(id);
	}
}
