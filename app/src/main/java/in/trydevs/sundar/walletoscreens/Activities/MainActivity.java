package in.trydevs.sundar.walletoscreens.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import in.trydevs.sundar.walletoscreens.R;


public class MainActivity extends AppCompatActivity {


    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button todaysmenu = (Button) findViewById(R.id.btn_todays_menu);
        Button openDialog = (Button) findViewById(R.id.btn_dialog);

        todaysmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TodaysMenu.class);
                startActivity(intent);
                finish();
            }
        });

        openDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = MainActivity.this.getLayoutInflater();

                dialogView = inflater.inflate(R.layout.custom_dialog_item_recipie, null);
                dialogBuilder.setView(dialogView);

                dialogBuilder.setCancelable(true).setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = dialogBuilder.create();
                dialog.show();
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
