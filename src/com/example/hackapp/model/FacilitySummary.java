package com.example.hackapp.model;

public class FacilitySummary {
	
	private boolean isParking;
	private boolean isCharging;
	private int facilityId;
	private double rate;
	private String name;
	
	public boolean isParking() {
		return isParking;
	}
	public void setParking(boolean isParking) {
		this.isParking = isParking;
	}
	public boolean isCharging() {
		return isCharging;
	}
	public void setCharging(boolean isCharging) {
		this.isCharging = isCharging;
	}
	public int getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
