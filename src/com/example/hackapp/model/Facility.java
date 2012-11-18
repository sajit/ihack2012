package com.example.hackapp.model;

import java.util.List;

/**
 * @author skunnumkal
 *
 */
public class Facility {
	private String address;
	private boolean has_charger;
	private float distance;
	private List<String> hrs;
	private boolean open;
    private String name;
    private double latitude;
    private double longitude;
    private String note;
    private String operator;
    private List<String> paymentTypes;
    private List<String> phones;
    private String description;
    private int numberPorts;
    private String port1_connector; //" : "CHAdeMO",
    private String port1_voltage; //" : 400,
    private String port1_current; //" : 62,
    private String port1_kw; //" : 25,
    private String port1_level; //" : 3,
    private String port2_connector; //" : "-",
    private String port2_voltage; //" : "-",
    private String port2_current; //" : "-",
    private String port2_kW; //" : "-",
    private String port2_level; //" : "-",
    private String currency; //": "USD",
    private double charging_rates; //" : 0 (float in unit of currency),
    private List<String> parkingRates;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNumberPorts() {
		return numberPorts;
	}
	public void setNumberPorts(int numberPorts) {
		this.numberPorts = numberPorts;
	}
	public String getPort1_connector() {
		return port1_connector;
	}
	public void setPort1_connector(String port1_connector) {
		this.port1_connector = port1_connector;
	}
	public String getPort1_voltage() {
		return port1_voltage;
	}
	public void setPort1_voltage(String port1_voltage) {
		this.port1_voltage = port1_voltage;
	}
	public String getPort1_current() {
		return port1_current;
	}
	public void setPort1_current(String port1_current) {
		this.port1_current = port1_current;
	}
	public String getPort1_kw() {
		return port1_kw;
	}
	public void setPort1_kw(String port1_kw) {
		this.port1_kw = port1_kw;
	}
	public String getPort1_level() {
		return port1_level;
	}
	public void setPort1_level(String port1_level) {
		this.port1_level = port1_level;
	}
	public String getPort2_connector() {
		return port2_connector;
	}
	public void setPort2_connector(String port2_connector) {
		this.port2_connector = port2_connector;
	}
	public String getPort2_voltage() {
		return port2_voltage;
	}
	public void setPort2_voltage(String port2_voltage) {
		this.port2_voltage = port2_voltage;
	}
	public String getPort2_current() {
		return port2_current;
	}
	public void setPort2_current(String port2_current) {
		this.port2_current = port2_current;
	}
	public String getPort2_kW() {
		return port2_kW;
	}
	public void setPort2_kW(String port2_kW) {
		this.port2_kW = port2_kW;
	}
	public String getPort2_level() {
		return port2_level;
	}
	public void setPort2_level(String port2_level) {
		this.port2_level = port2_level;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getCharging_rates() {
		return charging_rates;
	}
	public void setCharging_rates(double charging_rates) {
		this.charging_rates = charging_rates;
	}
	public List<String> getParkingRates() {
		return parkingRates;
	}
	public void setParkingRates(List<String> parkingRates) {
		this.parkingRates = parkingRates;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public List<String> getPaymentTypes() {
		return paymentTypes;
	}
	public void setPaymentTypes(List<String> paymentTypes) {
		this.paymentTypes = paymentTypes;
	}
	
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
	public float getDistance() {
		return distance;
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
	public List<String> getPhones() {
		return phones;
	}
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}
	public boolean isHas_charger() {
		return has_charger;
	}
	public void setHas_charger(boolean has_charger) {
		this.has_charger = has_charger;
	}
   
}
