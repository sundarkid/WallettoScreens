package in.trydevs.sundar.walletoscreens.Fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.trydevs.sundar.walletoscreens.Adapters.MyAdapterTodaysMenuItems;
import in.trydevs.sundar.walletoscreens.DataClasses.MenuItem;
import in.trydevs.sundar.walletoscreens.R;
import in.trydevs.sundar.walletoscreens.extras.MyApplication;
import in.trydevs.sundar.walletoscreens.interfaces.DialogTodaysMenuListener;

public class FragmentLunch extends Fragment {


    MyAdapterTodaysMenuItems adapter;
    View dialogView;
    RecyclerView recyclerView;
    View view;
    TextView recipe, itemName;
    Button ok;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment_lunch, container, false);

        initialize();

        return view;

    }

    private void initialize() {
        // Setting up Recycler View
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        adapter = new MyAdapterTodaysMenuItems(getActivity(), getMenuItems());
        // Setting alert Dialog listener


        LayoutInflater inflater = getActivity().getLayoutInflater();

        dialogView = inflater.inflate(R.layout.custom_dialog_item_recipie, null);

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder.setView(dialogView);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        adapter.setDialogTodaysMenuListener(new DialogTodaysMenuListener() {
            @Override
            public void onDialogCall(MenuItem menuItem) {

                recipe = (TextView) dialogView.findViewById(R.id.foodRecipe);
                itemName = (TextView) dialogView.findViewById(R.id.item_name);
                ok = (Button) dialogView.findViewById(R.id.btn_ok);
                recipe.setText(menuItem.getRecipe());
                itemName.setText(menuItem.getName());

                // dialogBuilder.setTitle(menuItem.getName()).setMessage(menuItem.getRecipe());

                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        alertDialog.cancel();
                    }
                });
                alertDialog.show();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(MyApplication.getAppContext()));
        //recyclerView.addItemDecoration(new SpacesItemDecoration(5));
        recyclerView.setAdapter(adapter);
    }


    public List<MenuItem> getMenuItems() {
        List<MenuItem> data = new ArrayList<>();
        data.add(new MenuItem("Chicken Briyani", "230", "http://orsimages.unileversolutions.com/ORS_Images/Knorr_en-IN/Hyderabadi%20Chicken%20Biryani%20%20Recipe%20Knorr%20India_29_3.1.16_326X580.Jpeg", "Add fried onions, green chilies, ½ of the mint, coriander leaves and pour in the oil or melted ghee. Mix well and level the surface. Layer the cooked rice evenly, add fried onions, mint and coriander leaves over the chicken. Sprinkle ¼ tsp to ½ tsp. biryani masala powder."));
        data.add(new MenuItem("Burger", "190", "http://cocosoutback.com/wp-content/uploads/2014/05/burgers.jpg", "8 cups finely shredded green cabbage, baby arugula, Freshly ground pepper, sweet smoked paprika"));
        data.add(new MenuItem("Nuggets", "100", "http://www.thekidsclubphuket.com/wp-content/uploads/2014/11/nuggets.jpg", "3 skinless, boneless chicken breasts, 1 cup Italian seasoned bread crumbs, Parmesan cheese"));
        return data;
    }
}
