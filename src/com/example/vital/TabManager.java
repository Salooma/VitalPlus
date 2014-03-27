package com.example.vital;
 
import java.util.Locale;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TextView;

public class TabManager extends FragmentActivity implements
        ActionBar.TabListener {
 
    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    public String HRData = "TEST";
    public String SPO2Data = "TEST1";
    public String TempData = "TEST2";
    
    SectionsPagerAdapter mSectionsPagerAdapter;
    // Tab titles
    private String[] tabs = { "Heart Rate", "Temperature", "SPO2 %" };

    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabmanager);
 
        //Retrieve values from MainActivity
        Intent intent = getIntent();

        HRData = intent.getStringExtra("hr.value");
        SPO2Data = intent.getStringExtra("spo2.value");
        TempData = intent.getStringExtra("temp.value");
        
        
        
        
        //Set Textview on each of the fragments to the retrieved data
        
        
        
////        if (HRData!=null)
////        {
//        
//        HRtxt = (TextView) findViewById(R.id.hrvalue);
//        if (HRtxt == null)
//        	Log.e("error", "Null TextView");
//        HRtxt.setText(HRData);
////        }
//        
////        if (SPO2Data!=null)
////        {
//        SPO2txt = (TextView) findViewById(R.id.oxygenvalue);
//        Temptxt.setText(SPO2Data);
////        }
//        
////        if(TempData!=null){
//        Temptxt = (TextView) findViewById(R.id.tempvalue);
//        Temptxt.setText(TempData);
////        }
        
        //Intent intent = new Intent();
//        intent.setClass(getApplicationContext(), TabManager.class);
        
        Bundle HRbundle=new Bundle();
       // bundle.putInt("battery", bat);
        HRbundle.putString("Heart Rate", HRData);
        HRFragment fragInfo = new HRFragment();
        fragInfo.setArguments(HRbundle);
//        intent.putExtra("HRBundle", HRbundle);
        
//        transaction.replace(R.id.fragment_single, fragInfo);
//        transaction.commit();
//        FragmentClass fragInfo = new FragmentClass();
        //intent.putExtra("HRBundle", HRbundle);
        
        Bundle SPO2bundle=new Bundle();
        // bundle.putInt("battery", bat);
         HRbundle.putString("Blood Oxygen", SPO2Data);
         intent.putExtra("SPO2bundle", SPO2bundle);
         
         Bundle Tempbundle=new Bundle();
         // bundle.putInt("battery", bat);
         HRbundle.putString("Temperature", TempData);
         intent.putExtra("SPO2bundle", SPO2bundle);
        
        
      
        
        
        
        
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
 
        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);    
        
		mSectionsPagerAdapter = new SectionsPagerAdapter(this.getSupportFragmentManager() ,this.getApplicationContext(), viewPager);
 
//        // Adding Tabs
//        for (String tab_name : tabs) {
//            actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));}
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
		

		// public int getItemPosition(Object item) {
		//	 FragCart fragment = (FragCart)item;
		 //       String title = fragment.getTitle();
		//        int position = titles.indexOf(title);

		//        if (position >= 0) {
		//            return position;
		  //      } else {
		///            return POSITION_NONE;
		//        }
		// }
		 
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
		
	}}