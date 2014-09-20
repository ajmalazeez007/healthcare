package com.greycodes.health.misc;


import android.content.Context;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class ExcelDataBase {
Context context;
ExcelDatabaseHelper helper;
SQLiteDatabase db;
SharedPreferences sharedPreferences;
	public ExcelDataBase(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;

		helper= new ExcelDatabaseHelper();
	}
	
	
	 public SQLiteDatabase getSQLiteDataBase(){
		 helper= new ExcelDatabaseHelper();
			SQLiteDatabase db = helper.getWritableDatabase();
			return db;
	 }
	public String getdata(){
		helper= new ExcelDatabaseHelper();
		SQLiteDatabase db = helper.getWritableDatabase();
		String[] columns = new String[]{"FORMAT"};
		String values=null;
		Cursor cursor= db.query("COMPETITION", columns, null, null, null, null, null);
		while(cursor.moveToNext()){
			values=cursor.getString(cursor.getColumnIndex("FORMAT"));
		}
		
		return values;
		
	}
	
	private class ExcelDatabaseHelper extends SQLiteOpenHelper{
		static final int Database_version=2;
		static final String Database_name= "excel.db";
		
		static final String Create_medice = "CREATE TABLE SPEAKERS (VARCHAR MEDNAME NOT NULL,VARCHAR FROM NOT NULL,VARCHAR TILL NOT NULL);";
		//static final String Create_proshow = "CREATE TABLE PROSHOW (IMAGE BLOB NOT NULL,VIDEO VARCHAR NOT NULL);";
		public ExcelDatabaseHelper() {
			super(context, Database_name, null, Database_version);
		}

		
		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			try {
			
				db.execSQL(Create_medice);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Toast.makeText(context, "error creating db", Toast.LENGTH_LONG).show();
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
		
		}
		
	}
	
	
	
}
