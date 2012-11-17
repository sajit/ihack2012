package com.example.hackapp;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class HomeActivity extends Activity{

	private static final String TAG = HomeActivity.class.getSimpleName();
	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * current dropdown position.
	 */
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		
	}

	

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// Serialize the current dropdown position.
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
				.getSelectedNavigationIndex());
	}
	
	
	public void findParking(final View aButton){
		DatePicker datePicker = (DatePicker)findViewById(R.id.date_picker_id);
		
		TimePicker timepicker = (TimePicker)findViewById(R.id.timePicker1);
		
		EditText addressText = (EditText)findViewById(R.id.editText1);
		String address = addressText.getText().toString();
		EditText durationText = (EditText)findViewById(R.id.editText2);
		String duration = durationText.getText().toString();
		Intent findParkingIntent = new Intent(this,FindParking.class);
		findParkingIntent.putExtra("address", address);
		findParkingIntent.putExtra("duration", Integer.valueOf(duration));
		Date date = new Date(datePicker.getYear() - 1900, datePicker.getMonth(), datePicker.getDayOfMonth(),
				timepicker.getCurrentHour(),timepicker.getCurrentMinute(),0);
		findParkingIntent.putExtra("date", date);
		Log.i(TAG,date.toString());
		startActivity(findParkingIntent);
	}
	

}
