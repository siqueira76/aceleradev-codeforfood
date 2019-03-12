package com.codeforfood.mapfood.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "motoboys")
public class Motoboy {
	@Id
	private String id;
	private int ID_Motoboy;

	@GeoSpatialIndexed
	private double Latitude;
	private double Longitude;

	private GeoJsonPoint location;

	public Motoboy() {
	}

	public Motoboy(String id, int iD_Motoboy, double Latitude, double Longitude) {
		super();
		this.id = id;
		this.ID_Motoboy = iD_Motoboy;
		this.location = new GeoJsonPoint(Latitude, Longitude);
		this.Latitude = Latitude;
		this.Longitude = Longitude;
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

	public GeoJsonPoint getLocation() {
		return this.location;
	}

	public void setLocation(GeoJsonPoint location) {
		this.location = location;
	}

	public double getLatitude() {
		return Latitude;
	}

	public void setLatitude(double latitude) {
		Latitude = latitude;
	}

	public double getLongitude() {
		return Longitude;
	}

	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

	@Override
	public String toString() {
		return "Motoby{" +
				"id='" + id + '\'' +
				", location="  +
				'}';
	}
}
