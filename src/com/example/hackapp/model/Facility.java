package com.example.hackapp.model;

import java.util.List;

/**
 * @author skunnumkal
 *
 */
public class Facility {
	private String address;
	private int distance;
	private List<String> hrs;
	private boolean open;
    private String name;
    private double latitude;
    private double longitude;
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public List<String> getHrs() {
		return hrs;
	}
	public void setHrs(List<String> hrs) {
		this.hrs = hrs;
	}
	public boolean isIs_open() {
		return open;
	}
	public void setIs_open(boolean is_open) {
		this.open = is_open;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
   
}
