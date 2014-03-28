package com.example.vital;
import at.abraxas.amarino.Amarino;
import at.abraxas.amarino.AmarinoIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


	public class ArduinoReceiver extends BroadcastReceiver {
		
		public String lala, lala1, lala2;

		@Override
		public void onReceive(Context context, Intent intent) {
			
			//handler = new DataHandler(getBaseContext());
			//open the DB
			//handler.open();
			String data = null;
			long id;
			
			// the device address from which the data was sent, we don't need it here but to demonstrate how you retrieve it
			final String address = intent.getStringExtra(AmarinoIntent.EXTRA_DEVICE_ADDRESS);
			
			// the type of data which is added to the intent
			final int dataType = intent.getIntExtra(AmarinoIntent.EXTRA_DATA_TYPE, -1);
			
			// we only expect String data though, but it is better to check if really string was sent
			// later Amarino will support different data types, so far data comes always as string and
			// you have to parse the data to the type you have sent from Arduino, like it is shown below
			if (dataType == AmarinoIntent.STRING_EXTRA){
				data = intent.getStringExtra(AmarinoIntent.EXTRA_DATA);
				
				if (data != null){
				if(0<=Integer.parseInt(data)&&Integer.parseInt(data)<=40)
					setHRData(data);
				
				if(410<=Integer.parseInt(data)&&Integer.parseInt(data)<=1010)
					//divide by 10 and add data to SPO2 column of table in database
					setSPO2Data(Integer.toString(Integer.parseInt(data)/10));
					
				if(10200<=Integer.parseInt(data)&&Integer.parseInt(data)<=15000)
					//divide by 100 and add data to TEMP columb of table in database
					setTempData(Integer.toString(Integer.parseInt(data)/100));			
				}	
			}
		}
		
		public void setHRData(String HRdata){
			lala=HRdata;
		}
		
		public String getHRData(){
			return lala;
		}
		
		public void setSPO2Data(String SPO2data){
			lala1=SPO2data;
		}
		
		public String getSPO2Data(){
			return lala1;
		}
		
		public void setTempData(String Tempdata){
			lala2=Tempdata;
		}
		
		public String getTempData(){
			return lala2;
		}
		
	}
	
	
	

