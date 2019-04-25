package entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;

public class Carrito {

	
	private Date fecha;

	Hashtable<Producto,Integer> pedido; 


	public Carrito(Date fecha) {
		this.fecha = fecha;
		this.pedido =  new Hashtable<Producto,Integer>();
		
	}
		
	public void agregarProducto(Producto p, int  cantidad) {
		
		pedido.put(p, cantidad);
	}
	
	public double precioTotal() {
		double price =0;
		for(Producto p : pedido.keySet()) {
			price += pedido.get(p) * p.getPrecio();
		}
		return price;
	}
	
	public String getFecha() {
		
		return fecha.getYear()+"-"+fecha.getMonth()+"-"+fecha.getDay();
	}

	

}
