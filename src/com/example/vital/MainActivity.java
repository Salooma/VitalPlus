package com.example.vital;

//import com.example.vital.GraphView;
import com.example.vital.*;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.TextView;
import at.abraxas.amarino.Amarino;
import at.abraxas.amarino.AmarinoIntent;

public class MainActivity extends Activity  {

private static final String TAG = "Bluetooth";
private ArduinoReceiver arduinoReceiver = new ArduinoReceiver();
	
	// change this to your Bluetooth device address 
	private static final String DEVICE_ADDRESS =  "00:00:12:06:60:32"; //"00:06:66:03:73:7B";
	
	
	
	
    /** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		final Context context = this;
		
		ImageButton ib = (ImageButton)findViewById(R.id.ibMainProfile);
		ImageButton ib2 = (ImageButton)findViewById(R.id.ibMainVitals);
		ib.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context,SecondActivity.class);
				
				//start the second Activity
				startActivity(intent);
			}
		});
		
		ib2.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context,TabManager.class);
				
				//start the second Activity
				startActivity(intent);
			
			}
		});
		
//		ValueHR = (TextView) findViewById(R.id.hrvalue);
//		ValueO = (TextView) findViewById(R.id.oxygenvalue);
//		ValueT = (TextView) findViewById(R.id.tempvalue);
//		GraphHR = (GraphView)findViewById(R.id.hrgraph);
//		GraphO = (GraphView)findViewById(R.id.oxygengraph);
//		GraphT = (GraphView)findViewById(R.id.tempgraph);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		// in order to receive broadcasted intents we need to register our receiver
		registerReceiver(arduinoReceiver, new IntentFilter(AmarinoIntent.ACTION_RECEIVED));
		
		// this is how you tell Amarino to connect to a specific BT device from within your own code
		Amarino.connect(this, DEVICE_ADDRESS);
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		
		// if you connect in onStart() you must not forget to disconnect when your app is closed
		Amarino.disconnect(this, DEVICE_ADDRESS);
		
		// do never forget to unregister a registered receiver
		unregisterReceiver(arduinoReceiver);
	}
	
	public void goToProfile(View view){
		Intent i = new Intent();
		
	}
	
	public void goToVitals(View view){
		Intent i = new Intent();
	}
	
	/**
	 * ArduinoReceiver is responsible for catching broadcasted Amarino
	 * events.
	 * 
	 * It extracts data from the intent and updates the graph accordingly.
	 */
	
	public class ArduinoReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			String data = null;
			
			// the device address from which the data was sent, we don't need it here but to demonstrate how you retrieve it
			final String address = intent.getStringExtra(AmarinoIntent.EXTRA_DEVICE_ADDRESS);
			
			// the type of data which is added to the intent
			final int dataType = intent.getIntExtra(AmarinoIntent.EXTRA_DATA_TYPE, -1);
			
			// we only expect String data though, but it is better to check if really string was sent
			// later Amarino will support different data types, so far data comes always as string and
			// you have to parse the data to the type you have sent from Arduino, like it is shown below
			if (dataType == AmarinoIntent.STRING_EXTRA){
				data = intent.getStringExtra(AmarinoIntent.EXTRA_DATA);
				
//				if (data != null){
//					
//					if(0<=Integer.parseInt(data)&&Integer.parseInt(data)<=40){
//					ValueHR.setText(data);
//				
//					//mGraph.addDataPoint(Integer.parseInt(data));
//					}
//					if(410<=Integer.parseInt(data)&&Integer.parseInt(data)<=1010){
//						ValueO.setText(Integer.toString(Integer.parseInt(data)/10));
//						//mGraph1.addDataPoint(Integer.parseInt(data)/10);
//						}
//					if(10200<=Integer.parseInt(data)&&Integer.parseInt(data)<=15000){
//						ValueT.setText(Integer.toString(Integer.parseInt(data)/100));
//						//mGraph2.addDataPoint(Integer.parseInt(data)/100);
//						}
//				}
			}
		}
	}

}
