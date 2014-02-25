package com.example.vital;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity  {
	

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
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void goToProfile(View view){
		Intent i = new Intent();
		
	}
	
	public void goToVitals(View view){
		Intent i = new Intent();
	}

}
