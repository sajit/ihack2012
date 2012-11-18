package com.example.hackapp;

import java.util.ArrayList;
import java.util.List;

import com.example.hackapp.model.Facility;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FacilityDetails extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.facility_details);
		Intent intent = getIntent();
		int id = intent.getIntExtra("facility_id", 0);
		//make http request
		Facility facility =  getMockFacility();//request.
		storeData(facility);

		
	}

	private Facility getMockFacility() {
		Facility fa = new Facility();
		fa.setAddress("Address");
		List<String> hrs = new ArrayList<String>();
		hrs.add("Morning does");
		hrs.add("Evening sucks");
		hrs.add("Midday kills");
		fa.setHrs(hrs);
		fa.setPaymentTypes(hrs);
		fa.setParkingRates(hrs);
		return fa;
	}

	private void storeData(Facility facility) {
		TextView nameText = (TextView)findViewById(R.id.station_name);
		//intent.getstr
		nameText.setText("Mocked data");
		
		ImageView chargeImage = (ImageView)findViewById(R.id.is_charging);
		if(facility.isHas_charger()){
			chargeImage.setImageResource(R.drawable.electric_plug_50);
		}
		TextView distanceText = (TextView)findViewById(R.id.distance);
		distanceText.setText(String.valueOf(100));
		ListView hrsList = (ListView)findViewById(R.id.hrs_list);
		ArrayAdapter<String> hrsadapter = new ArrayAdapter<String>(this,
				  android.R.layout.simple_list_item_1, android.R.id.text1, facility.getHrs());
		hrsList.setAdapter(hrsadapter);
		
		ListView pmtypesList = (ListView)findViewById(R.id.pmt_types_list);
		ArrayAdapter<String>pmt_typesadapter = new ArrayAdapter<String>(this,
				  android.R.layout.simple_list_item_1, android.R.id.text1, facility.getPaymentTypes());
		pmtypesList.setAdapter(pmt_typesadapter);
		
		ListView parkingRatesList = (ListView)findViewById(R.id.parking_rates_list);
		ArrayAdapter<String>parkingRatesAdapter = new ArrayAdapter<String>(this,
				  android.R.layout.simple_list_item_1, android.R.id.text1, facility.getParkingRates());
		parkingRatesList.setAdapter(parkingRatesAdapter);
		
		TextView chargingRate = (TextView)findViewById(R.id.charging_rate_id);
		chargingRate.setText(String.valueOf(facility.getCharging_rates()));
		
		
		
	}

}
