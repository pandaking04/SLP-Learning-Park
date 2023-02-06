package com.example.museum4life;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AncientAdapter extends RecyclerView.Adapter<AncientAdapter.ancientViewHolder> {

    Context context;
    ArrayList<Item> ancientItemList;




    public AncientAdapter(Context context, ArrayList<Item> ancientItemList ) {
        this.context = context;
        this.ancientItemList = ancientItemList;

    }



    @NonNull
    @Override
    public AncientAdapter.ancientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new ancientViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AncientAdapter.ancientViewHolder holder, int position) {

        Item item = ancientItemList.get(position);
        holder.name.setText(item.Name);
        //holder.description.setText(item.Description);
        //Glide.with(holder.image.getContext()).load(item.imageUrl).into(holder.image);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ancient_detail.class);

            }
        });


    }

    @Override
    public int getItemCount() {
        return ancientItemList.size();
    }

    public  class ancientViewHolder extends RecyclerView.ViewHolder {
        TextView name,description;
        ImageView image;
        CardView cardView;



        public ancientViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.ancient_item_name);
            //description = itemView.findViewById(R.id.ancient_item_des);
            image = itemView.findViewById(R.id.image_list);
            cardView = itemView.findViewById(R.id.myRow);




        }



    }



}
