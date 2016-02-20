package in.trydevs.sundar.walletoscreens.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import in.trydevs.sundar.walletoscreens.R;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button todaysmenu = (Button) findViewById(R.id.btn_todays_menu);

        todaysmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TodaysMenu.class);
                startActivity(intent);
                finish();
            }
        });


    }


    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("checking flow", "on post resume");
        //LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver, new IntentFilter(QuickstartPreferences.REGISTRATION_COMPLETE));
    }

    @Override
    protected void onPause() {
        Log.d("checking flow", "on pause");
        super.onPause();
    }



}
