package com.example.hackapp;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.example.hackapp.model.Facility;
import com.example.location.dao.LocationDao;
import com.google.gson.Gson;
import com.turbomanage.httpclient.BasicHttpClient;
import com.turbomanage.httpclient.HttpResponse;
import com.turbomanage.httpclient.ParameterMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class FacilityDetails extends Activity {
	public static final String SERVER_URL = "http://api.parkcharge.us:8888/v1/evppd";
	//http://api.parkcharge.us:8888/v1/evppd/
	private double facility_latitude,facility_longitude;
	private Location location;
	private static final String TAG = FacilityDetails.class.getSimpleName();
	private SharedPreferences preferences;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		StrictMode.ThreadPolicy policy = new StrictMode.
		ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy); 
				
				
		super.onCreate(savedInstanceState);
		setContentView(R.layout.facility_details);
		Intent intent = getIntent();
		String id = intent.getStringExtra("facility_id");
		
		//make http request
		Gson gson = new Gson();
		//URL url = new URL(GET_FACILITY_DETAILS+"/evppd");
		ConnectivityManager cm = (ConnectivityManager) 
			      getSystemService(Context.CONNECTIVITY_SERVICE);
			    NetworkInfo networkInfo = cm.getActiveNetworkInfo();
			    // if no network is available networkInfo will be null
			    // otherwise check if we are connected
			    if (networkInfo != null && networkInfo.isConnected()) {
			        Log.i(TAG, "We have network");
			    }
		BasicHttpClient httpClient = new BasicHttpClient(SERVER_URL);
		Log.i(TAG, httpClient.toString());
		preferences = getSharedPreferences("hackapp", Context.MODE_PRIVATE);
		
		ParameterMap params  = httpClient.newParams().add("x", id)
				.add("duration", preferences.getString("duration", "120"))
				.add("date", preferences.getString("date","2012-11-18T14:50Z" ))
				.add("action", "get_station_detail");
		HttpResponse httpResponse = httpClient.get("/",params);
		//HttpResponse httpResponse = httpClient.get(String.valueOf(id), null);
		Facility facility = gson.fromJson(httpResponse.getBodyAsString(), Facility.class);

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
		//fa.setPaymentTypes(hrs);
		//fa.setParkingRates(hrs);
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
		pmtypesList.setText(concatenate(facility.getPmt_types()));
		
		TextView station_name = (TextView)findViewById(R.id.station_name);
		station_name.setText(facility.getDisplay_name());
		TextView parkingRatesList = (TextView)findViewById(R.id.parking_rates_list);
		parkingRatesList.setText(concatenate(facility.getParking_rates()));
		
		
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
