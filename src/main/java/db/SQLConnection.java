package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

import entity.Carrito;
import entity.Producto;


public class SQLConnection {
	
	private Connection conexion;
	private Statement statement;
	
	public SQLConnection() {
		try {
			//SET GLOBAL time_zone = '-5:00';
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine", "root", "");
			statement = conexion.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void close() {
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public ArrayList<Producto> getAllProductos() {
		ArrayList<Producto> output = new ArrayList<Producto>();
		try {
			ResultSet resultados = statement.executeQuery("SELECT id,nombre,precio FROM productos");
			while (resultados.next()) {
				Producto tempProd = new Producto(resultados.getString(2) , resultados.getInt(3) );
				tempProd.setId(resultados.getInt(1));
				output.add(tempProd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	
	public void insertCarrito(Carrito carrito) {
		
		try {
			statement.execute("INSERT INTO carrito(fecha) VALUES ('"+carrito.getFecha()+"')");
			
			Hashtable<Producto, Integer> hashTemp = carrito.getPedido();
			
			for (Producto key: hashTemp.keySet()) {
				
				int cantidad = hashTemp.get(key);
				statement.execute("INSERT INTO carrito_tiene_productos(carritoID,productoID, cantidad) VALUES (LAST_INSERT_ID(), "+key.getId()+","+cantidad+"))");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}