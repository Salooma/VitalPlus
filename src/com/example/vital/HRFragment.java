package com.example.vital;

import com.example.vital.R;
//import com.example.vital.OxygenFragment.ArduinoReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import at.abraxas.amarino.AmarinoIntent;
 
public class HRFragment extends Fragment {
	
	TextView HRtxt;
	//private ArduinoReceiver arduinoReceiver = new ArduinoReceiver();
	
	static HRFragment init (int pos)
	{
		HRFragment hrFrag = new HRFragment();
		Bundle args = new Bundle ();
		args.putInt("pos", pos);
		hrFrag.setArguments(args);
		return hrFrag;	
	}
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.hr_tab, container, false);
       
        HRtxt = (TextView)rootView.findViewById(R.id.hrvalue);
        String value = ((TabManager)getActivity()).HRValue;
        HRtxt.setText(value);
        
        return rootView;
    }
}
