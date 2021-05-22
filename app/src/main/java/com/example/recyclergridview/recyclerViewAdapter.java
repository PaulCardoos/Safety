package com.example.recyclergridview;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.myViewHolder> {
    ArrayList<String> titles;
    //stored as integer because we will be only passing id to images
    ArrayList<Integer> images;
    private String phoneNumber;
    private String message;
    private int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;

    public recyclerViewAdapter(ArrayList<String> titles, ArrayList<Integer> images){
        this.titles = titles;
        this.images = images;
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        public ImageView gridIcon;
        public CardView cards;
        public Context context;

        public myViewHolder(final View view){
            super(view);
            title = view.findViewById(R.id.first);
            gridIcon = view.findViewById(R.id.imageHere);
            cards = view.findViewById(R.id.cards);
            context = view.getContext();
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(title.getText().equals("Location")){
                        Intent intent = new Intent(context, MapsActivity.class);
                        context.startActivity(intent);
                    }
                    if(title.getText().equals("Send Location")){
                        Intent intent = new Intent(context, SendMessage.class);
                        context.startActivity(intent);

                    }
                    if(title.getText().equals("Guardian")){
                        Intent intent = new Intent(context, AddGuardian.class);
                        context.startActivity(intent);
                    }
                    if(title.getText().equals("Settings")){
                        Intent intent = new Intent(context, MapsActivity.class);
                        context.startActivity(intent);
                    }
                    if(title.getText().equals("Message")){
                        Intent intent = new Intent(context, MapsActivity.class);
                        context.startActivity(intent);
                    }

                }

            });


        }
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public recyclerViewAdapter.myViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_grid_layout, parent, false);
        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull recyclerViewAdapter.myViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.gridIcon.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }





}
