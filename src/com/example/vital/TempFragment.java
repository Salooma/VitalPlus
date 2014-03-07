package com.example.vital;

import com.example.vital.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public class TempFragment extends Fragment {
 
	
	static TempFragment init (int pos)
	{
		TempFragment tempFrag = new TempFragment();
		Bundle args = new Bundle ();
		args.putInt("pos", pos);
		tempFrag.setArguments(args);
		return tempFrag;
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.temp_tab, container, false);
         
        return rootView;
    }
}
