package com.example.hackapp;



import com.example.hackapp.model.Facility;
import com.example.hackapp.model.FacilitySummary;
import com.example.location.dao.LocationDao;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
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
				facilityDetailsIntent.putExtra("facility_id", facilities[position].getFacilityId());
				//facilityDetailsIntent.putExtra("is_open", facilities[position].isIs_open());
				//facilityDetailsIntent.putExtra("station_name", facilities[position].getName());
				//facilityDetailsIntent.putExtra("distance", facilities[position].getDistance());
				//facilityDetailsIntent.putExtra("distance", facilities[position].getDistance());
				context.startActivity(facilityDetailsIntent);
				
			}
			 
		 });
		 TextView facilityRate = (TextView)rowView.findViewById(R.id.facility_rate);
		 facilityRate.setText(String.valueOf(facilities[position].getRate()));
		 
//		 Button addressButton = (Button)rowView.findViewById(R.id.address_id);
//		 //addressButton.setText(facilities[position].getAddress());
//		 addressButton.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				//Uri.parse("http://maps.google.com/maps?saddr="+latitude_source+","+longitude_source+"&daddr="+latitude_dest+","+longitude_dest));
//				LocationDao locationDao = new LocationDao(context);
//				Location location = locationDao.getBestLocation();
//				String latitude_source = String.valueOf(location.getLatitude());
//				String longitude_source = String.valueOf(location.getLongitude());
//				String latitude_dest = String.valueOf(facilities[position].getLatitude());
//				String longitude_dest = String.valueOf(facilities[position].getLatitude());
//				latitude_dest = "41.00000";
//				longitude_dest = "-74.596699";
//				String url = "http://maps.google.com/maps?saddr="+latitude_source+","+
//				longitude_source+"&daddr="+latitude_dest+","+longitude_dest;
//				Intent intent = new Intent(android.content.Intent.ACTION_VIEW, 
//						Uri.parse(url));
//						context.startActivity(intent);
//			}
//			 
//		 });
		 return rowView;
	 }
}
