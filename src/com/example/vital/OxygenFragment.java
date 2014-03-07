package com.example.vital;

import com.example.vital.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public class OxygenFragment extends Fragment {
	
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
        
        return rootView;
    }
}
