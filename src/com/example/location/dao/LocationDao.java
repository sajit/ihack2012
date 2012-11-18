package com.example.location.dao;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;

public class LocationDao {
	

	private Context context;
	private boolean gps_enabled=false;
	private boolean network_enabled=false;
	
	public LocationDao(final Context aContext){
		this.context = aContext;

	}
	
	public Location getBestLocation(LocationManager lm){
		//LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		//locationManager = (LocationManager)this.get
		//exceptions will be thrown if provider is not permitted.
        try{gps_enabled=lm.isProviderEnabled(LocationManager.GPS_PROVIDER);}catch(Exception ex){}
        try{network_enabled=lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);}catch(Exception ex){}

        //don't start listeners if no provider is enabled
        if(!gps_enabled && !network_enabled){
        	//make a Toast
        	//prompt user to enable location settings
        	 //Toast.makeText(context, "Please turn on GPS", Toast.LENGTH_LONG).show();
	            Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
	            
	            context.startActivity(myIntent);
        }
        Location location = null;
        if(gps_enabled){
        	location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }
        else if(network_enabled){
        	location = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }
        return location;
	}
	
	

}
