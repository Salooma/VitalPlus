package com.example.vital;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import at.abraxas.amarino.AmarinoIntent;

public class ProfileActivity extends Activity {
	
	private static String userFirstName, userLastName, userAge, userWeight, userHeight, userGender;
	
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.second);
	        getActionBar().setDisplayHomeAsUpEnabled(true);
	        
	        final Button button = (Button) findViewById(R.id.save_button);
	         button.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	                 // Perform action on click
	            	 saveUserInfo(v);
	            	 //resetTextFields();
	            	 
	             }
	         });
	        
	    }
	    
	    public void saveUserInfo(View v){
	    	 	
	        EditText firstname = (EditText) findViewById(R.id.user_firstname);
	        userFirstName = firstname.getText().toString();
	        
	        EditText lastname = (EditText) findViewById(R.id.user_lastname);
	        userLastName = lastname.getText().toString();
	        
	        EditText age = (EditText) findViewById(R.id.user_age);
	        userAge = age.getText().toString();
	        
	        EditText weight = (EditText) findViewById(R.id.user_weight);
	        userWeight = weight.getText().toString();
	        
	        EditText height = (EditText) findViewById(R.id.user_height);
	        userHeight = height.getText().toString();
	        
	        EditText gender = (EditText) findViewById(R.id.user_gender);
	        userGender = gender.getText().toString();
	    	
	    }
	    
	    public void resetTextFields(){
	    	
	    	EditText firstname = (EditText) findViewById(R.id.user_firstname);
	        firstname.getText().clear();
	        
	        EditText lastname = (EditText) findViewById(R.id.user_lastname);
	        lastname.getText().clear();
	        
	        EditText age = (EditText) findViewById(R.id.user_age);
	        age.getText().clear();
	        
	        EditText weight = (EditText) findViewById(R.id.user_weight);
	        weight.getText().clear();
	        
	        EditText height = (EditText) findViewById(R.id.user_height);
	        height.getText().clear();
	        
	        EditText gender = (EditText) findViewById(R.id.user_gender);
	        gender.getText().clear(); 
	    }
}
