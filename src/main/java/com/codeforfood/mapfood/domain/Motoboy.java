package com.codeforfood.mapfood.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "motoboys")
public class Motoboy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private int ID_Motoboy;
	private Double Longitude;
	private Double Latitude;

	public Motoboy() {
	}

	public Motoboy(String id, int iD_Motoboy, Double longitude, Double latitude) {
		super();
		this.id = id;
		ID_Motoboy = iD_Motoboy;
		Longitude = longitude;
		Latitude = latitude;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getID_Motoboy() {
		return ID_Motoboy;
	}

	public void setID_Motoboy(int iD_Motoboy) {
		ID_Motoboy = iD_Motoboy;
	}

	public Double getLongitude() {
		return Longitude;
	}

	public void setLongitude(Double longitude) {
		Longitude = longitude;
	}

	public Double getLatitude() {
		return Latitude;
	}

	public void setLatitude(Double latitude) {
		Latitude = latitude;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Motoboy other = (Motoboy) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
