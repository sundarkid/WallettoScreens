package in.trydevs.sundar.walletoscreens.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import in.trydevs.sundar.walletoscreens.Fragments.FragmentLunch;
import in.trydevs.sundar.walletoscreens.R;
import in.trydevs.sundar.walletoscreens.extras.MyApplication;

/**
 * Created by Yash on 20-02-2016.
 */
public class MyFragmentAdapterTodaysMenu extends FragmentPagerAdapter {
    String tabNames[];

    public MyFragmentAdapterTodaysMenu(FragmentManager fm) {
        super(fm);
        tabNames = MyApplication.getAppContext().getResources().getStringArray(R.array.tabs_todays_menu);
        Log.d("pager adapter","fragment created");
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabNames[position];
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragmentLunch();
                Log.d("pager adapter",tabNames[0]);
                break;
            case 1:
                fragment = new FragmentLunch();
                Log.d("pager adapter",tabNames[1]);
                break;
            case 2:
                fragment = new FragmentLunch();
                Log.d("pager adapter",tabNames[2]);
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return tabNames.length;
    }
}
