package in.trydevs.sundar.walletoscreens.Activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import in.trydevs.sundar.walletoscreens.Adapters.MyFragmentAdapterTodaysMenu;
import in.trydevs.sundar.walletoscreens.R;
import in.trydevs.sundar.walletoscreens.tabs.SlidingTabLayout;

public class TodaysMenu extends AppCompatActivity {


    MyFragmentAdapterTodaysMenu fragmentAdapter;
    private ViewPager viewPager;
    private SlidingTabLayout slidingTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todays_menu);

        intialize();

    }

    private void intialize(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.top_bar);
        setSupportActionBar(toolbar);
        // Setting up view pager and adapter
        viewPager = (ViewPager) findViewById(R.id.view_pager_todays_menu);
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.tab_layout_todays_menu);
        fragmentAdapter = new MyFragmentAdapterTodaysMenu(getSupportFragmentManager());
        viewPager.setAdapter(fragmentAdapter);
        slidingTabLayout.setCustomTabView(R.layout.white_tab_color_text, R.id.textView);
        slidingTabLayout.setViewPager(viewPager);
    }

}
