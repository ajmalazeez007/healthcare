package com.greycodes.health.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.greycodes.health.R;

public class HomeNDadapter extends BaseAdapter {
Context context;
int[] options;
LayoutInflater homeinflator;
	public HomeNDadapter(Context context,int[] options) {
		// TODO Auto-generated constructor stub
		this.options = options;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return options.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView tv;
		homeinflator=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = homeinflator.inflate(R.layout.drawer_list_item, parent, false);
		tv=(ImageView) itemView.findViewById(R.id.nav_listitems);
		//tv.setText(option[position]);
		tv.setImageResource(options[position]);
		return itemView;
	}

}
