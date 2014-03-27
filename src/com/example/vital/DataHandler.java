package com.example.vital;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHandler {

	//Data Name
	public static final String HR = "heartrate";
	public static final String SPO2 = "bloodoxygen";
	public static final String TEMP = "temperature";
	
	//Table Name
	public static final String TABLE_NAME = "myVitalsTable";
	
	//DataBase Name
	public static final String DATABASE_NAME = "myVitalsDatabase";
	
	//DataBase Version
	public static final int DATABASE_VERSION = 1;
	
	//Table create query
	public static final String TABLE_CREATE = "create table myVitalsTable (heartrate text not null, bloodoxygen text not null, temperature text not null)";
	
	//Create object of the DataBaseHelper and Context
	DataBaseHelper dbhelper;
	Context ctx;
	SQLiteDatabase db;
		
	//Create constructor for DataHandler class
	public DataHandler(Context ctx){
		this.ctx = ctx;
		dbhelper = new DataBaseHelper(ctx);
	}
	
	//Create Private DataBaseHandler Class
	private static class DataBaseHelper extends SQLiteOpenHelper {

		//Create constructor for DataBaseHelper class
		public DataBaseHelper (Context ctx){
			super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
		}
		
		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			//used for creating the table in the database
			try {
			db.execSQL(TABLE_CREATE);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DELETE TABLE IF EXISTS myVitalsTable"); //Delete table if previously existed
			onCreate(db); //invoke onCreate method to create DB		
		}	
	}
	
	public DataHandler open(){
		db = dbhelper.getWritableDatabase();
		return this;
	}
	
	public void close(){
		dbhelper.close();
	}
	
	public long insertData(String heartrate, String bloodoxygen, String temperature){
		ContentValues content = new ContentValues();
		content.put(HR, heartrate);
		content.put(SPO2, bloodoxygen);
		content.put(TEMP, temperature);
		return db.insertOrThrow(TABLE_NAME, null, content);
	}
	
	public Cursor returnData(){
		return db.query(TABLE_NAME, new String [] {HR, SPO2, TEMP}, null, null, null, null, null);
	}
		
	
}
