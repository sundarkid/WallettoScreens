package in.trydevs.sundar.walletoscreens.Adapters;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import in.trydevs.sundar.walletoscreens.DataClasses.MenuItem;
import in.trydevs.sundar.walletoscreens.R;

public class MyAdapterTodaysMenuItems extends RecyclerView.Adapter<MyAdapterTodaysMenuItems.MyViewHolder> {

    FragmentActivity context;
    List<MenuItem> data;
    LayoutInflater inflater;

    public MyAdapterTodaysMenuItems(FragmentActivity context, List<MenuItem> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
        Log.d("got data", "" + data.size());
        Log.d("data 1", data.get(1).getName() + data.get(1).getImage());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row_food_order, parent, false);
        return (new MyViewHolder(view));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MenuItem current = data.get(position);
        if (!current.getImage().equals("")) {
            Glide.with(context)
                    .load(current.getImage())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .crossFade()
                    .into(holder.image);
        } else {
            holder.image.setImageDrawable(null);
        }
        holder.name.setText(current.getName());
        holder.price.setText(current.getPrice());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, price;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.imageView);
            name = (TextView) itemView.findViewById(R.id.itemname);
            price = (TextView) itemView.findViewById(R.id.itemprice);
        }
    }

}
