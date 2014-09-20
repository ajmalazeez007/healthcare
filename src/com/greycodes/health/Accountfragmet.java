package com.greycodes.health;

import com.greycodes.health.misc.MedicineAdd;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



public class Accountfragmet extends Fragment {
TextView tvname,tvage;
ImageView addmed;
ListView medicine;
SharedPreferences sharedPreferences;



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootview = inflater.inflate(R.layout.accountfragment, container, false);
		sharedPreferences = getActivity().getSharedPreferences("login",Context.MODE_PRIVATE);
		tvname = (TextView) rootview.findViewById(R.id.account_name);
		tvage = (TextView) rootview.findViewById(R.id.account_age);
		
		medicine = (ListView) rootview.findViewById(R.id.account_list);
		tvname.setText(sharedPreferences.getString("name", "Name"));
		tvage.setText(sharedPreferences.getString("age", "Error"));
		addmed = (ImageView) rootview.findViewById(R.id.account_scanner);
		addmed.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), MedicineAdd.class);
				startActivity(intent);
			}
		});
	return rootview;
	}
	

	
}
