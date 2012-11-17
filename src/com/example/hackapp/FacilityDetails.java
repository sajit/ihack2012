package com.example.hackapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FacilityDetails extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.facility_details);
		
		
		storeData(getIntent());

		
	}

	private void storeData(Intent intent) {
		TextView nameText = (TextView)findViewById(R.id.station_name);
		//intent.getstr
		nameText.setText(intent.getStringExtra("station_name"));
		TextView openText = (TextView)findViewById(R.id.is_open);
		openText.setText(String.valueOf(intent.getBooleanExtra("is_open", false)));
		
		TextView distanceText = (TextView)findViewById(R.id.distance);
		distanceText.setText(String.valueOf(intent.getIntExtra("distance",0)));
		
		
		// TODO Auto-generated method stub
		
	}

}
