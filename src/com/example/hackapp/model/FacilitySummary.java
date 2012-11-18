package com.example.hackapp.model;

public class FacilitySummary {
	
	private boolean has_parking;
	private boolean has_charging;
	private String station_id;
	private double total_rate;
	private String station_name;
	
	public boolean isParking() {
		return has_parking;
	}
	public void setParking(boolean isParking) {
		this.has_parking = isParking;
	}
	public boolean isCharging() {
		return has_charging;
	}
	public void setCharging(boolean isCharging) {
		this.has_charging = isCharging;
	}
	
	
	public double getRate() {
		return total_rate;
	}
	public void setRate(double rate) {
		this.total_rate = rate;
	}
	public String getName() {
		return station_name;
	}
	public void setName(String name) {
		this.station_name = name;
	}
	public String getStation_id() {
		return station_id;
	}
	public void setStation_id(String station_id) {
		this.station_id = station_id;
	}

}
