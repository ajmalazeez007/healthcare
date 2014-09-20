package com.greycodes.health.misc;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.greycodes.health.Accountfragmet;
import com.greycodes.health.MainActivity;
import com.greycodes.health.R;




public class LoginFragment extends Fragment {
EditText etname,etphone,etage,etsex,etpass;
SharedPreferences sharedPreferences;
Editor editor;
ImageView signup;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		sharedPreferences = getActivity().getSharedPreferences("login",Context.MODE_PRIVATE);
		editor = sharedPreferences.edit();
		View rootview = inflater.inflate(R.layout.signup_fragment, container, false);
	etname = (EditText) rootview.findViewById(R.id.signup_name);
	etphone = (EditText) rootview.findViewById(R.id.signup_phone);
	etage = (EditText) rootview.findViewById(R.id.signup_age);
	etsex = (EditText) rootview.findViewById(R.id.signup_sex);
	etpass = (EditText) rootview.findViewById(R.id.signup_pass);
	signup = (ImageView) rootview.findViewById(R.id.signup_image);
	
	signup.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			editor.putString("name", etname.getText().toString());
			editor.putString("phone", etphone.getText().toString());
			editor.putString("age", etage.getText().toString());
			editor.putBoolean("register", true);
			editor.commit();
			Intent intent = new Intent(getActivity(), MainActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
		        
		}
	});
		
		return rootview;
	}



}
