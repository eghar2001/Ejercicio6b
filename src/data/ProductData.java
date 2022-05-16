package data;

import java.sql.*;
import java.util.ArrayList;
import entity.Product;


public class ProductData {
	public ArrayList<Product> findAll() {
		Connection conn = null;
		Statement stat = null;
		ResultSet resultSet = null;
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/javamarket","root","43840925@Rc1");
			stat =  conn.createStatement();
			resultSet = stat.executeQuery("SELECT * from product ");
			while(resultSet.next()) {
				Product prod = new Product();
				prod.setId(resultSet.getInt("id"));
				prod.setName(resultSet.getString("name"));
				prod.setDescription(resultSet.getString("description"));
				prod.setPrice(resultSet.getDouble("price"));
				prod.setStock(resultSet.getInt("stock"));
				prod.setShippingIncluded(resultSet.getBoolean("shipping_included"));
				products.add(prod);
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		    
		}finally {
			try {
			if(resultSet!=null) {
				resultSet.close();
			}
			if(stat!=null) {
				stat.close();
			}
			conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return products;	
		
	}
	public Product getOne(int id) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet resultSet = null;
		Product prod = null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/javamarket","root","43840925@Rc1");
			stat =  conn.prepareStatement("SELECT * FROM product WHERE id = ? ");
			stat.setInt(1, id);
			resultSet= stat.executeQuery();
			if(resultSet.next()) {			
				prod = new Product();
				prod.setId(resultSet.getInt("id"));
				prod.setName(resultSet.getString("name"));
				prod.setDescription(resultSet.getString("description"));
				prod.setPrice(resultSet.getDouble("price"));
				prod.setStock(resultSet.getInt("stock"));
				prod.setShippingIncluded(resultSet.getBoolean("shipping_included"));
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		    
		}finally {
			try {
			if(resultSet!=null) {
				resultSet.close();
			}
			if(stat!=null) {
				stat.close();
			}
			conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return prod;	
	}
	public void create(Product prod) {
		Connection conn = null;
		PreparedStatement stat = null;		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/javamarket","root","43840925@Rc1");
			stat =  conn.prepareStatement("INSERT INTO product (name,description,price,stock,shipping_included) VALUES (?,?,?,?,?)");
			stat.setString(1, prod.getName());
			stat.setString(2, prod.getDescription());
			stat.setDouble(3, prod.getPrice());
			stat.setInt(4,prod.getStock());
			stat.setBoolean(5,prod.isShippingIncluded());
			stat.executeUpdate();		
			
		}catch(SQLException e) {
			e.printStackTrace();
		    
		}finally {
			try {
				if(stat!=null) {
					stat.close();
				}
				conn.close();
				}
			
			
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
			
	}
	public  void delete(int id) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/javamarket","root","43840925@Rc1");
			stat = conn.prepareStatement("DELETE FROM product WHERE id = ?");
			stat.setInt(1, id);
			stat.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		    
		}finally {
			try {
				if(stat!=null) {
					stat.close();
				}
				conn.close();
				}
			
			
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public  void edit(Product prod,int idAEditar) {
		Connection conn = null;
		PreparedStatement stat = null;		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/javamarket","root","43840925@Rc1");
			stat =  conn.prepareStatement("UPDATE product SET name = ? ,description = ?,price = ?,stock = ?,shipping_included = ? WHERE id = ?");
			stat.setString(1, prod.getName());
			stat.setString(2, prod.getDescription());
			stat.setDouble(3, prod.getPrice());
			stat.setInt(4,prod.getStock());
			stat.setBoolean(5,prod.isShippingIncluded());
			stat.setInt(6, idAEditar);
			stat.executeUpdate();		
			
		}catch(SQLException e) {
			e.printStackTrace();
		    
		}finally {
			try {
				if(stat!=null) {
					stat.close();
				}
				conn.close();
				}
			
			
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
			
	}
}
