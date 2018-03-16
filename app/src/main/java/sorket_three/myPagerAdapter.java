package sorket_three;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import com.example.liuqi.project_three.R;

import frament_three.H5_data;
import frament_three.android_data;
import frament_three.javaEE_data;

/**
 * Created by liuqi on 2017/12/20.
 */

public class myPagerAdapter extends FragmentPagerAdapter {
    String[] title = { "Android", "W3", "JavaEE" };
    private android_data android_data;
    private H5_data H5_data;
    private javaEE_data javaEE_data;
    private FragmentManager fragmentManager;
    public myPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentManager=fm;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if(android_data==null)
                    android_data = new android_data();
                return android_data;
            case 1:
                if( H5_data==null)
                    H5_data = new H5_data();
                return H5_data;
            case 2:
                if( javaEE_data==null)
                    javaEE_data = new javaEE_data();
                return javaEE_data;

            default:
                return null;
        }
    }


    @Override
    public int getCount() {

        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

}
