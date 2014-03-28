package com.example.vital;

import com.example.vital.R;


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
 
public class OxygenFragment extends Fragment {
	
//	private ArduinoReceiver arduinoReceiver = new ArduinoReceiver();
	TextView SPO2txt;
	
	static OxygenFragment init (int pos)
	{
		OxygenFragment oxFrag = new OxygenFragment();
		Bundle args = new Bundle ();
		args.putInt("pos", pos);
		oxFrag.setArguments(args);
		return oxFrag;
		
	}
 
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.oxygen_tab, container, false);
        
        SPO2txt = (TextView)rootView.findViewById(R.id.oxygenvalue);
        String value = ((TabManager)getActivity()).SPO2Value;
        SPO2txt.setText(value);
        
        
        return rootView;
    }
	
//	public class ArduinoReceiver extends BroadcastReceiver {
//
//		@Override
//		public void onReceive(Context context, Intent intent) {
//			String data = null;
//			
//			// the device address from which the data was sent, we don't need it here but to demonstrate how you retrieve it
//			final String address = intent.getStringExtra(AmarinoIntent.EXTRA_DEVICE_ADDRESS);
//			
//			// the type of data which is added to the intent
//			final int dataType = intent.getIntExtra(AmarinoIntent.EXTRA_DATA_TYPE, -1);
//			
//			// we only expect String data though, but it is better to check if really string was sent
//			// later Amarino will support different data types, so far data comes always as string and
//			// you have to parse the data to the type you have sent from Arduino, like it is shown below
//			if (dataType == AmarinoIntent.STRING_EXTRA){
//				data = intent.getStringExtra(AmarinoIntent.EXTRA_DATA);
//				
////				if (data != null){
////					
////					if(0<=Integer.parseInt(data)&&Integer.parseInt(data)<=40){
////					ValueHR.setText(data);
////				
////					//mGraph.addDataPoint(Integer.parseInt(data));
////					}
////					if(410<=Integer.parseInt(data)&&Integer.parseInt(data)<=1010){
////						ValueO.setText(Integer.toString(Integer.parseInt(data)/10));
////						//mGraph1.addDataPoint(Integer.parseInt(data)/10);
////						}
////					if(10200<=Integer.parseInt(data)&&Integer.parseInt(data)<=15000){
////						ValueT.setText(Integer.toString(Integer.parseInt(data)/100));
////						//mGraph2.addDataPoint(Integer.parseInt(data)/100);
////						}
////				}
//			}
//		}
//	}
}
