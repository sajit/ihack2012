package com.example.hackapp;



import com.example.hackapp.model.FacilitySummary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class FacilityAdapter extends ArrayAdapter<FacilitySummary>{

	private Context context;
	private FacilitySummary[] facilities;
	public FacilityAdapter(Context aContext,FacilitySummary[] facilities){
		super(aContext,R.layout.list_item,facilities);
		this.context = aContext;
		this.facilities = facilities;
	}
	
	 @Override
	  public View getView(final int position, View convertView, ViewGroup parent) {
		 LayoutInflater inflater = (LayoutInflater) context
			        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		 View rowView = inflater.inflate(R.layout.list_item,parent,false);
		 ImageView parkingImage = (ImageView)rowView.findViewById(R.id.parkView1);
		 ImageView chargingImage = (ImageView)rowView.findViewById(R.id.chargeView2);
		 if(facilities[position].isParking()){
			 parkingImage.setImageResource(R.drawable.parking_p_50);
		 }
		 if(facilities[position].isCharging()){
			 chargingImage.setImageResource(R.drawable.electric_plug_50);
		 }
		 Button facilityRowButton = (Button)rowView.findViewById(R.id.facility_id);
		 facilityRowButton.setText(facilities[position].getName());
		 facilityRowButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent facilityDetailsIntent = new Intent(context,FacilityDetails.class);
				facilityDetailsIntent.putExtra("facility_id", facilities[position].getStation_id());
				//facilityDetailsIntent.putExtra("is_open", facilities[position].isIs_open());
				//facilityDetailsIntent.putExtra("station_name", facilities[position].getName());
				//facilityDetailsIntent.putExtra("distance", facilities[position].getDistance());
				//facilityDetailsIntent.putExtra("distance", facilities[position].getDistance());
				context.startActivity(facilityDetailsIntent);
				
			}
			 
		 });
		 TextView facilityRate = (TextView)rowView.findViewById(R.id.facility_rate);
		 facilityRate.setText(String.valueOf(facilities[position].getRate()));
		 

		 return rowView;
	 }
}
