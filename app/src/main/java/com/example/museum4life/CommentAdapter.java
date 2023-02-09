package com.example.museum4life;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> {
    private Context context;
    private List<Comment> commentList;

    public CommentAdapter(Context context) {
        this.context = context;
        this.commentList = new ArrayList<>();
    }

    public void add(Comment comment){
        commentList.add(comment);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Comment comment = commentList.get(position);
        holder.name.setText(comment.getName());
        holder.user_comment.setText(comment.getComment_txt());

    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView user_comment;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.user_txt);
            user_comment = itemView.findViewById(R.id.comment_txt);
        }
    }
}
