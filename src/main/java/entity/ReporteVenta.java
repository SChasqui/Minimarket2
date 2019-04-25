package entity;

import java.util.ArrayList;

public class ReporteVenta {

	
	private ArrayList<Carrito> carrito;

	public ReporteVenta() {
		super();
		this.carrito = new ArrayList<Carrito>();
	}

	public void agregarCarrito(Carrito car) {
		
		carrito.add(car);
	}
	
	public ArrayList<Carrito> getCarrito() {
		return carrito;
	}


	
	
	
	
}
