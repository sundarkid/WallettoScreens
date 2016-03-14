package in.trydevs.sundar.walletoscreens.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import in.trydevs.sundar.walletoscreens.R;

public class SelectAddress extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_address);
        initialize();
    }

    protected void initialize() {
        // Setting toolbar
        toolbar = (Toolbar) findViewById(R.id.top_bar);
        setSupportActionBar(toolbar);
    }
}
