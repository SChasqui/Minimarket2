package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			ResultSet resultados = statement.executeQuery("SELECT nombre,precio FROM productos");
			while (resultados.next()) {
				output.add(  new Producto(resultados.getString(2) , resultados.getInt(1) ));
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
			
			statement.execute("INSERT INTO carrito(fecha) VALUES ('"+carrito.getFecha()+"')");
			statement.execute("INSERT INTO carrito(fecha) VALUES ('"+carrito.getFecha()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}