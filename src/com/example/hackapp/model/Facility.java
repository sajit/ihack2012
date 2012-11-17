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
	private boolean is_open;
    private String name;
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
		return is_open;
	}
	public void setIs_open(boolean is_open) {
		this.is_open = is_open;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
   
}
