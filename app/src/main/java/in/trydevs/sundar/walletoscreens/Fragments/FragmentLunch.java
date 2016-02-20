package in.trydevs.sundar.walletoscreens.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import in.trydevs.sundar.walletoscreens.Adapters.MyAdapterTodaysMenuItems;
import in.trydevs.sundar.walletoscreens.DataClasses.MenuItem;
import in.trydevs.sundar.walletoscreens.R;
import in.trydevs.sundar.walletoscreens.extras.MyApplication;

public class FragmentLunch extends Fragment {


    MyAdapterTodaysMenuItems adapter;
    RecyclerView recyclerView;
    View view;

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
        recyclerView.setLayoutManager(new LinearLayoutManager(MyApplication.getAppContext()));
        //recyclerView.addItemDecoration(new SpacesItemDecoration(5));
        recyclerView.setAdapter(adapter);
    }

    public List<MenuItem> getMenuItems() {
        List<MenuItem> data = new ArrayList<>();
        data.add(new MenuItem("Chicken Briyani", "230", "http://orsimages.unileversolutions.com/ORS_Images/Knorr_en-IN/Hyderabadi%20Chicken%20Biryani%20%20Recipe%20Knorr%20India_29_3.1.16_326X580.Jpeg"));
        data.add(new MenuItem("Burger", "190", "http://cocosoutback.com/wp-content/uploads/2014/05/Burgers.jpg"));
        data.add(new MenuItem("Nuggets", "100", "http://www.thekidsclubphuket.com/wp-content/uploads/2014/11/nuggets.jpg"));
        return data;
    }
}
