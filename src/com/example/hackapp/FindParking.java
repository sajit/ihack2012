package com.example.hackapp;

import java.util.ArrayList;
import java.util.List;

import com.example.hackapp.model.Facility;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.turbomanage.httpclient.BasicHttpClient;
import com.turbomanage.httpclient.HttpResponse;
import com.turbomanage.httpclient.ParameterMap;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

public class FindParking extends Activity {
	
	private LocationManager lm;
	private boolean gps_enabled=false;
	private boolean network_enabled=false;
	private static final String GET_PARKING = "/";
	private static final String SERVER_URL = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parking);
		if(lm==null)
            lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		//locationManager = (LocationManager)this.get
		//exceptions will be thrown if provider is not permitted.
        try{gps_enabled=lm.isProviderEnabled(LocationManager.GPS_PROVIDER);}catch(Exception ex){}
        try{network_enabled=lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);}catch(Exception ex){}

        //don't start listeners if no provider is enabled
        if(!gps_enabled && !network_enabled){
        	//make a Toast
        	//prompt user to enable location settings
        }
        Location location = null;
        if(gps_enabled){
        	location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }
        else if(network_enabled){
        	location = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }
        if(location != null){
        	 //make request
        	BasicHttpClient httpClient = new BasicHttpClient(SERVER_URL);
        	Gson gson = new Gson();
        	final String locationString = gson.toJson(location);
            ParameterMap params = httpClient.newParams()
                    .add("location", locationString);
                    
            //httpClient.addHeader("someheader", "value");
            httpClient.setConnectionTimeout(2000); // 2s
            HttpResponse response = httpClient.get(GET_PARKING, params);
            JsonParser parser = new JsonParser();
            JsonArray array = parser.parse(getResponseJson(response)).getAsJsonArray();
            List<Facility> availableFacilities = new ArrayList<Facility>();
            for(int i=0;i<array.size();i++){
            	//Facility facility = gson.from
            }
        }
            
	}
	private String getResponseJson(HttpResponse response) {
		final String responseString = "{"+
		    " \"Facilities\": [ " +
		        "{ \"address\" : \" abc parking lot \", \"distance\": 350, \"hrs\":[\"Weekday 9-5\",\"Weekend 10-6\"], " +
		        	"\"is_open\":true}]" +
		        	"}";
		// TODO Auto-generated method stub
		return responseString;
	}

}
