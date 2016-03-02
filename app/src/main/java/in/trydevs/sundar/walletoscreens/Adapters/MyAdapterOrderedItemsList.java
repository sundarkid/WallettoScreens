package in.trydevs.sundar.walletoscreens.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.LinkedList;

import in.trydevs.sundar.walletoscreens.DataClasses.MenuItem;
import in.trydevs.sundar.walletoscreens.DataClasses.Order;
import in.trydevs.sundar.walletoscreens.R;

/**
 * Created by jmprathab on 27/02/16.
 */

public class MyAdapterOrderedItemsList extends RecyclerView.Adapter<MyAdapterOrderedItemsList.ViewHolder> {
    LinkedList<Order> data = new LinkedList<>();
    Context context;

    public MyAdapterOrderedItemsList(Context context, LinkedList<Order> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyAdapterOrderedItemsList.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_order_list, parent, false);
        return (new ViewHolder(v));
    }

    @Override
    public void onBindViewHolder(MyAdapterOrderedItemsList.ViewHolder holder, int position) {
        Order currentOrder = data.get(position);
        MenuItem menuItem = currentOrder.getItem();
        holder.time.setText(currentOrder.getTimeForTextView());
        holder.itemName.setText(menuItem.getName());
        holder.itemPrice.setText("₹" + menuItem.getPrice());
        holder.itemQuantity.setText("x" + currentOrder.getQuantity());

        if (!menuItem.getImage().equals("")) {
            Glide.with(context).load(currentOrder.getItem().getImage()).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(holder.itemImage);
        } else {
            holder.itemImage.setImageDrawable(null);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView time, itemName, itemPrice, itemQuantity;
        ImageView itemImage;

        public ViewHolder(View itemView) {
            super(itemView);
            time = (TextView) itemView.findViewById(R.id.time);
            itemName = (TextView) itemView.findViewById(R.id.item_name);
            itemPrice = (TextView) itemView.findViewById(R.id.item_price);
            itemQuantity = (TextView) itemView.findViewById(R.id.item_quantity);
            itemImage = (ImageView) itemView.findViewById(R.id.item_image);
        }
    }
}
