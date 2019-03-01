package com.codeforfood.mapfood.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estabelecimento-por-municipio")
public class Emporium {
	
	@Id
	private String id;
	private String restaurant_id;
	private String restaurant;
	private Double longitude;
	private Double latitude;
	private String dish_description;
	
	public Emporium() {
	}

	public Emporium(String id, String restaurant_id, String restaurant, Double longitude, Double latitude,
			String dish_description) {
		super();
		this.id = id;
		this.restaurant_id = restaurant_id;
		this.restaurant = restaurant;
		this.longitude = longitude;
		this.latitude = latitude;
		this.dish_description = dish_description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(String restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getDish_description() {
		return dish_description;
	}

	public void setDish_description(String dish_description) {
		this.dish_description = dish_description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Emporium other = (Emporium) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
