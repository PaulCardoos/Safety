package com.example.recyclergridview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView dataList;
    ArrayList<String> titles;
    ArrayList<Integer> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataList = findViewById(R.id.dataList);

        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("Construction");
        titles.add("Wine");
        titles.add("Edit");
        titles.add("Electrical");
        titles.add("Music");
        titles.add("Cashier");
        titles.add("Location");
        titles.add("Wifi");

        images.add(R.drawable.construction);
        images.add(R.drawable.drinks);
        images.add(R.drawable.edit_red);
        images.add(R.drawable.electrical);
        images.add(R.drawable.music);
        images.add(R.drawable.sales);
        images.add(R.drawable.send_me_ur_location);
        images.add(R.drawable.wifi);

        setAdapter();

    }

    private void setAdapter(){
        recyclerViewAdapter adapter = new recyclerViewAdapter(titles, images);
        //set layout manager, item animator, and adapter
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),
               2 , GridLayoutManager.VERTICAL, false);

        dataList.setLayoutManager(layoutManager);
        dataList.setAdapter(adapter);

    }
}