package com.codeforfood.mapfood.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Integer ID_Cliente;
	private double Longitude;
	private double Latitude;
	private ShoppingCart shoppingCart;

	public Client() {
	}

	public Client(int iD_Cliente, double longitude, double latitude) {
		super();
		ID_Cliente = iD_Cliente;
		Longitude = longitude;
		Latitude = latitude;
		shoppingCart = new ShoppingCart();
	}

	public int getID_Cliente() {
		return ID_Cliente;
	}

	public void setID_Cliente(int iD_Cliente) {
		ID_Cliente = iD_Cliente;
	}

	public double getLongitude() {
		return Longitude;
	}

	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

	public double getLatitude() {
		return Latitude;
	}

	public void setLatitude(double latitude) {
		Latitude = latitude;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_Cliente;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (ID_Cliente != other.ID_Cliente)
			return false;
		return true;
	}
}
