package in.trydevs.sundar.walletoscreens.Activities;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

import in.trydevs.sundar.walletoscreens.Adapters.MyAdapterOrderedItemsList;
import in.trydevs.sundar.walletoscreens.DataClasses.MenuItem;
import in.trydevs.sundar.walletoscreens.DataClasses.Order;
import in.trydevs.sundar.walletoscreens.R;

public class ReviewOrder extends AppCompatActivity {
    Toolbar toolbar;
    Button placeOrder;
    Button applyPromoCode;
    RecyclerView recyclerView;
    TextView totalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_order);
        initialize();
        //Preparing Sample Data
        LinkedList<Order> data = new LinkedList<>();
        MenuItem item1 = new MenuItem("Chicken Briyani", "230", "http://orsimages.unileversolutions.com/ORS_Images/Knorr_en-IN/Hyderabadi%20Chicken%20Biryani%20%20Recipe%20Knorr%20India_29_3.1.16_326X580.Jpeg");
        Order order1 = new Order(item1, 2, Order.OrderTime.LUNCH);
        data.add(order1);

        MenuItem item2 = new MenuItem("Burger", "190", "http://cocosoutback.com/wp-content/uploads/2014/05/burgers.jpg");
        Order order2 = new Order(item2, 1, Order.OrderTime.BREAKFAST);
        data.add(order2);

        MenuItem item3 = new MenuItem("Nuggets", "100", "http://www.thekidsclubphuket.com/wp-content/uploads/2014/11/nuggets.jpg");
        Order order3 = new Order(item3, 1, Order.OrderTime.DINNER);
        data.add(order3);

        MyAdapterOrderedItemsList myAdapterOrderedItemsList = new MyAdapterOrderedItemsList(this, data);
        recyclerView.setAdapter(myAdapterOrderedItemsList);

        //Calculating Total Order Amount
        //Calculating Total can be done efficiently while adding data to the List
        totalAmount.setText("₹" + getTotalAmount(data));
    }

    private int getTotalAmount(LinkedList<Order> data) {
        int total = 0;
        for (int i = 0; i < data.size(); i++) {
            total += data.get(i).getOrderAmount();
        }
        return total;
    }

    private void initialize() {
        toolbar = (Toolbar) findViewById(R.id.top_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Review Order");
        placeOrder = (Button) findViewById(R.id.place_order);
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Mechanism to Place Order of Listed items Goes Here
                Toast.makeText(ReviewOrder.this, "Order has been Placed :-)", Toast.LENGTH_SHORT).show();
            }
        });
        applyPromoCode = (Button) findViewById(R.id.apply_promo_code);
        applyPromoCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Mechanism to apply Promo Code goes here
                Toast.makeText(ReviewOrder.this, "Promo Code Applied :-)", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.order_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        totalAmount = (TextView) findViewById(R.id.total_amount);
    }

    @Override
    public void onBackPressed() {
        NavUtils.navigateUpFromSameTask(this);
    }
}
