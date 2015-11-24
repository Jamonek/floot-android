package com.brentlrayjr.floot.ListControllers;

/**
 * Created by blray on 11/23/2015.
 */
import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.brentlrayjr.floot.Models.Post;
import com.brentlrayjr.floot.R;

import java.util.ArrayList;

/**
 * Created by brent on 10/21/15.
 */
public class PostListController extends RecyclerView.Adapter<PostListController.ViewHolder>{

    ArrayList<Post> posts;
    Activity activity;

    public PostListController(ArrayList<Post> posts){

        this.posts = posts;
    }

    public PostListController(Activity activity){

        posts = new ArrayList<>();

        this.activity = activity;

    }

    @Override
    public PostListController.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_view, parent, false);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int p) {

        final Post post = posts.get(p);




        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(holder.cardView.getVisibility() == View.VISIBLE){

                    holder.cardView.setVisibility(View.INVISIBLE);

                }
                else {
                    holder.cardView.setVisibility(View.VISIBLE);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void add(Post post) {
        this.posts.add(post);
        notifyItemInserted(posts.indexOf(post));
    }
    public void addAll(ArrayList<Post> posts) {
        this.posts.addAll(posts);
        notifyItemRangeInserted(this.posts.indexOf(posts.get(0)), posts.size());
    }

    public void remove(Post post) {
        int position = posts.indexOf(post);
        posts.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        View  content;
        ImageView upvoteView;
        ImageView downvoteView;


        public ViewHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.card_view);
            content = (View) v.findViewById(R.id.post_content);
            upvoteView = (ImageView) v.findViewById(R.id.upvote_view);
            downvoteView = (ImageView) v.findViewById(R.id.downvote_view);

        }
    }


}
