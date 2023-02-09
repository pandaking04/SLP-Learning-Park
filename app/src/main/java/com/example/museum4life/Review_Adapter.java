package com.example.museum4life;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Review_Adapter extends RecyclerView.Adapter<Review_Adapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<Comment> commentArrayList;
    Context context;

    Review_Adapter(Context context, ArrayList<Comment> data){
        this.context = context;
        this.commentArrayList = data;
    }

    @NonNull
    @Override
    public Review_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.comment_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       Comment comment = commentArrayList.get(position);
       holder.userName.setText(comment.username);
       holder.userComment.setText(comment.text);

    }

    @Override
    public int getItemCount() {
        return commentArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView userName,userComment;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.user_txt);
            userComment = itemView.findViewById(R.id.comment_txt);
            cardView = itemView.findViewById(R.id.myComment);

        }
    }
}
