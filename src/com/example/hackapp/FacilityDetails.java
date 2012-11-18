package com.example.hackapp;

import java.util.ArrayList;
import java.util.List;

import com.example.hackapp.model.Facility;
import com.example.location.dao.LocationDao;
import com.google.gson.Gson;
import com.turbomanage.httpclient.BasicHttpClient;
import com.turbomanage.httpclient.HttpResponse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class FacilityDetails extends Activity {
	public static final String GET_FACILITY_DETAILS = "http://api.parkcharge.us:8888/v1/";
	private double facility_latitude,facility_longitude;
	private Location location;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.facility_details);
		Intent intent = getIntent();
		int id = intent.getIntExtra("facility_id", 0);
		//make http request
		Gson gson = new Gson();
		BasicHttpClient httpClient = new BasicHttpClient(GET_FACILITY_DETAILS);
		//HttpResponse httpResponse = httpClient.get("/_ah/login", null);

//    	final String locationString = gson.toJson(location);
//        ParameterMap params = httpClient.newParams()
//                .add("location", locationString);
//    
//        httpClient.setConnectionTimeout(2000); // 2s
//        HttpResponse response = httpClient.get(GET_PARKING, params);
		Facility facility =  getMockFacility();//request.
		facility_latitude = facility.getLatitude();
		facility_longitude = facility.getLongitude();
		LocationDao locationDao = new LocationDao(this);
		LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		location = locationDao.getBestLocation(lm);
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
		TextView hrsList = (TextView)findViewById(R.id.hrs_list);
		
		hrsList.setText(concatenate(facility.getHrs()));
		
		TextView pmtypesList = (TextView)findViewById(R.id.pmt_types_list);
		pmtypesList.setText(concatenate(facility.getPaymentTypes()));
		
		TextView parkingRatesList = (TextView)findViewById(R.id.parking_rates_list);
		parkingRatesList.setText(concatenate(facility.getParkingRates()));
		
		
		TextView chargingRate = (TextView)findViewById(R.id.charging_rate_id);
		chargingRate.setText(String.valueOf(facility.getCharging_rates()));
		
		
		 Button addressButton = (Button)findViewById(R.id.get_directions);
		 
		 addressButton.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				
				
				
				String latitude_source = String.valueOf(location.getLatitude());
				String longitude_source = String.valueOf(location.getLongitude());
				String latitude_dest = String.valueOf(facility_latitude);
				String longitude_dest = String.valueOf(facility_longitude);
				latitude_dest = "41.00000";
				longitude_dest = "-74.596699";
				String url = "http://maps.google.com/maps?saddr="+latitude_source+","+
				longitude_source+"&daddr="+latitude_dest+","+longitude_dest;
				Intent intent = new Intent(android.content.Intent.ACTION_VIEW, 
						Uri.parse(url));
						startActivity(intent);
			}
			 
		 });
		
	}
	private String concatenate(List<String> items){
		StringBuffer sb = new StringBuffer();
		for(String item : items){
			sb.append(item+" ");
		}
		return sb.toString();
	}

}
