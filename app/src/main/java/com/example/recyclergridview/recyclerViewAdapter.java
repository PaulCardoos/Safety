package com.example.recyclergridview;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.myViewHolder> {
    ArrayList<String> titles;
    //stored as integer because we will be only passing id to images
    ArrayList<Integer> images;

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
                        CharSequence text = "Location sent to guardian";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                    }
                    if(title.getText().equals("Guardians")){
                        Intent intent = new Intent(context, MapsActivity.class);
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
