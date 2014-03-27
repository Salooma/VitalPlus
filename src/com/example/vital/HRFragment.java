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
       
        
        //Bundle bundle = getActivity().getIntent().getExtras();
//        Bundle bundle = this.getArguments();
//        String value = bundle.getString("Heart Rate");
//        String value = "33";
       
        HRtxt = (TextView)rootView.findViewById(R.id.hrvalue);
        String value = ((TabManager)getActivity()).HRData;
        HRtxt.setText(value);
        
        
//        Bundle extras = getActivity().getIntent().getExtras();
//        if (extras != null) {
//                    String value = extras.getString("Heart Rate");
//                    HRtxt.setText(value);
//                    System.out.print(value);
//        }
        
        //String value = this.getArguments().getString("Heart Rate");
        
      //if (HRtxt == null)
     // 	Log.e("error", "Null TextView");
        
        
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
