package com.example.hackapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends Activity{

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
		Intent findParkingIntent = new Intent(this,FindParking.class);
		startActivity(findParkingIntent);
	}
	
	public void findEverything(final View aButton){
		Intent findEverythingIntent = new Intent(this,FindEverything.class);
		startActivity(findEverythingIntent);
	}
	
	public void topDeals(final View aButton){
		Intent topDealsIntent = new Intent(this,TopDeals.class);
		startActivity(topDealsIntent);
	}
	

	

}
