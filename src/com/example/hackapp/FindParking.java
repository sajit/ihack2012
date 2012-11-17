package com.example.hackapp;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hackapp.model.Facility;
import com.example.hackapp.model.FacilitySummary;
import com.example.location.dao.LocationDao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.turbomanage.httpclient.BasicHttpClient;
import com.turbomanage.httpclient.HttpResponse;
import com.turbomanage.httpclient.ParameterMap;

public class FindParking extends ListActivity {
	
	
	
	private static final String GET_PARKING = "/";
	private static final String SERVER_URL = "";
	
	private FacilityAdapter facilityAdapter;

	private LocationDao locationDao;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parking);
		locationDao = new LocationDao(this);
		Location location = locationDao.getBestLocation();
        if(location != null){
        	 //make request
//        	BasicHttpClient httpClient = new BasicHttpClient(SERVER_URL);
        	Gson gson = new Gson();
//        	final String locationString = gson.toJson(location);
//            ParameterMap params = httpClient.newParams()
//                    .add("location", locationString);
//        
//            httpClient.setConnectionTimeout(2000); // 2s
//            HttpResponse response = httpClient.get(GET_PARKING, params);
            //JsonParser parser = new JsonParser();
            //JsonArray array = parser.parse(getResponseJson(response)).getAsJsonArray();
            //Type collectionType = new TypeToken<List<Facility>>(){}.getType();
            //TODO fix me
            //List<Facility> facilities = gson.fromJson(getResponseJson(null), collectionType);
            //facilityAdapter = new FacilityAdapter(this,facilities.toArray(new Facility[facilities.size()]));
            facilityAdapter = new FacilityAdapter(this,getMockFacilities().toArray(new FacilitySummary[4]));
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
