package com.example.vital;
 
import java.util.Locale;


import android.app.ActionBar;
import android.app.ActionBar.Tab;
//import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import at.abraxas.amarino.Amarino;
import at.abraxas.amarino.AmarinoIntent;

public class TabManager extends FragmentActivity implements
        ActionBar.TabListener {
	
	private static final String TAG = "Bluetooth";
	ArduinoReceiver arduinoReceiver = new ArduinoReceiver();
		
		// change this to your Bluetooth device address 
		private static final String DEVICE_ADDRESS =  "00:00:12:06:60:32"; //"00:06:66:03:73:7B";
		
		//Create object of DataHandler
		DataHandler handler;
		
		public String HRValue = "heart";
		public String SPO2Value = "oxygen";
		public String TempValue = "temp";
 
    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    
    SectionsPagerAdapter mSectionsPagerAdapter;
    // Tab titles
    private String[] tabs = { "Heart Rate", "Temperature", "SPO2 %" };
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabmanager);
 
        //Set Vital Values here - call from ArduinoReceiver class
//        HRValue = arduinoReceiver.getHRData();
//        SPO2Value = arduinoReceiver.getSPO2Data();
//        TempValue = arduinoReceiver.getTempData();
        
        
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
 
        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);    
        
		mSectionsPagerAdapter = new SectionsPagerAdapter(this.getSupportFragmentManager() ,this.getApplicationContext(), viewPager);

        viewPager.setOffscreenPageLimit(mSectionsPagerAdapter.getCount() - 1);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
        	 
            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }
        });
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
//			 Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}    
	}
	

	
	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public  class SectionsPagerAdapter extends FragmentPagerAdapter {

		Context context;
		
		public SectionsPagerAdapter(FragmentManager fragmentManager, Context context, ViewPager mViewPager) {
			super(fragmentManager);
			this.context = context;
		}
		


		@Override
		public Fragment getItem(int position) {
			android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
			// getItem is called to instantiate the fragment for the given page.
			// Return a FragMainMenu (defined as a static inner class
			// below) with the page number as its lone argument.
			
			switch (position) {
			case 0:
				
				return HRFragment.init(position);
			
			case 1:
				return OxygenFragment.init(position);
			
			case 2:
			return TempFragment.init(position);
			
			default:
				return null;
			}
			}
		
		
		 @Override
         public CharSequence getPageTitle(int position) {
                 Locale l = Locale.getDefault();
                 
                 switch (position) {
                 case 0:
                         return "HEART RATE".toUpperCase(l);
                         
                 case 1:
                	   return "TEMPERATURE".toUpperCase(l);
                		//return Integer.toString(++j);
                 case 2:
                         return "SPO2 %".toUpperCase(l);
                 }
                 return null;
         }	
		 
		@Override
		public int getItemPosition(Object object) {
		    return POSITION_NONE;
		}
			@Override
			public int getCount() {
				// Show 3 total pages.
				return  3;
			}
	}

	@Override
	public void onTabReselected(Tab arg0, android.app.FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab arg0, android.app.FragmentTransaction arg1) {
		viewPager.setCurrentItem(arg0.getPosition());
		
	}

	@Override
	public void onTabUnselected(Tab arg0, android.app.FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		//Context context;
		
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_profile:
	        	Intent intent = new Intent(this, SecondActivity.class);
	        	startActivity(intent);
	        	//openSearch();
	            return true;
//	        case R.id.action_settings:
//	            openSettings();
//	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		// in order to receive broadcasted intents we need to register our receiver
//		registerReceiver(arduinoReceiver, new IntentFilter(AmarinoIntent.ACTION_RECEIVED));
		
		// this is how you tell Amarino to connect to a specific BT device from within your own code
//		Amarino.connect(this, DEVICE_ADDRESS);
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		
		// if you connect in onStart() you must not forget to disconnect when your app is closed
//		Amarino.disconnect(this, DEVICE_ADDRESS);
		
		// do never forget to unregister a registered receiver
//		unregisterReceiver(arduinoReceiver);
	}

}