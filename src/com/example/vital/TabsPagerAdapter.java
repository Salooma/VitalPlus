package com.example.vital;
 
import com.example.vital.HRFragment;
import com.example.vital.OxygenFragment;
import com.example.vital.TempFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
 
public class TabsPagerAdapter extends FragmentPagerAdapter {
 
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            // Top Rated fragment activity
            return new HRFragment();
        case 1:
            // Games fragment activity
            return new TempFragment();
        case 2:
            // Movies fragment activity
            return new OxygenFragment();
        }
 
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }
 
}