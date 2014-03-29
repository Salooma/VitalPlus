package com.example.vital;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import at.abraxas.amarino.AmarinoIntent;

public class SecondActivity extends Activity {
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.second);
	        getActionBar().setDisplayHomeAsUpEnabled(true);
	    }	        
}
