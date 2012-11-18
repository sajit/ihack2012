package com.example.hackapp;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.Settings;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hackapp.model.Facility;
import com.example.hackapp.model.FacilitySummary;
import com.example.location.dao.LocationDao;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.turbomanage.httpclient.BasicHttpClient;
import com.turbomanage.httpclient.HttpResponse;
import com.turbomanage.httpclient.ParameterMap;

public class FindParking extends ListActivity {
	
	
	
	
	private static final String SERVER_URL = "http://api.parkcharge.us:8888/v1/evppd";
	private static final String TAG = FindParking.class.getSimpleName();
	private FacilityAdapter facilityAdapter;

	private LocationDao locationDao;
	private int duration;
	private String address;
	private String dateString;
	private SharedPreferences preferences;
	
	protected void onResume(){
		super.onResume();
		//setContentView(R.layout.parking);
		doShowRows();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		StrictMode.ThreadPolicy policy = new StrictMode.
		ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy); 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parking);
		Intent intent = getIntent();
		duration = intent.getIntExtra("duration", 60);
		address = intent.getStringExtra("address");
		dateString = intent.getStringExtra("date");
		preferences = getSharedPreferences("hackapp", Context.MODE_PRIVATE);
		Editor edit = preferences.edit();
		edit.putString("date", dateString);
		edit.putString("duration", String.valueOf(duration));
		edit.commit();
		doShowRows();
            
	}
	private void doShowRows(){
		locationDao = new LocationDao(this);
		LocationManager lm = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
		Location location = locationDao.getBestLocation(lm);
        if(location != null){
        	 //make request
        	BasicHttpClient httpClient = new BasicHttpClient(SERVER_URL);
        	Gson gson = new Gson();
//        	final String locationString = gson.toJson(location);
        	
            ParameterMap params = httpClient.newParams()
                    .add("duration", String.valueOf(60))
                    .add("address","10780+Santa+Monica+Blvd,+Los+Angeles,+CA+90025,+USA")
                    .add("date","2012-11-17T16:44Z")
                    .add("action", "get_station_list");
//        
           //http://api.parkcharge.us:8888/v1/evppd/?action=get_station_list&duration=60&date=2012-11-17T16:44Z&adress=10780+Santa+Monica+Blvd,+Los+Angeles,+CA+90025,+USA

           HttpResponse response = httpClient.get("/", params);
           //Log.i(TAG,response.getBodyAsString());
           
            Type collectionType = new TypeToken<List<FacilitySummary>>(){}.getType();
            
            List<FacilitySummary> facilities = gson.fromJson(response.getBodyAsString(), collectionType);
           
            facilityAdapter = new FacilityAdapter(this,facilities.toArray(new FacilitySummary[facilities.size()]));
            ListView facilityList = (ListView)findViewById(android.R.id.list);
            facilityList.setAdapter(facilityAdapter);
          
            
        }
	}
	private List<FacilitySummary> getMockFacilities(){
		List<FacilitySummary> mockFacilities = new ArrayList<FacilitySummary>();
		for(int i=0;i<4;i++){
			FacilitySummary f = new FacilitySummary();
			f.setParking(true);
			f.setCharging(i%2==0);
			f.setRate(Double.valueOf(i));
			f.setName("Mocked up station");
			mockFacilities.add(f);
		}
		return mockFacilities;
	}
	

}
