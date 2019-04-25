package services;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import db.SQLConnection;
import entity.Carrito;



@Stateless
@Path("carrito")
public class carritoResources {
	
//	private Gson gson =  new Gson();
//
//	@POST
//	@Consumes("application/json")
//	public Carrito  create(Carrito carrito) {
////		SQLConnection conexion = new SQLConnection();
////		conexion.insertCarrito(carrito);
////		Carrito out = conexion.getLastInsertedCarrito();
////		conexion.close();
////		return out;
//	}
//	
//	@POST
//	@Consumes("application/json")
//	@Path("gson")
//	public String createGson(String json) {
//		
//		
//		Carrito carrito = gson.fromJson(json, Carrito.class);
//		SQLConnection conexion = new SQLConnection();
//		conexion.insertCarrito(carrito);
//		Carrito out = conexion.getLastInsertedCarrito();
//		conexion.close();
//		return gson.toJson(out);
//	}

	
}
