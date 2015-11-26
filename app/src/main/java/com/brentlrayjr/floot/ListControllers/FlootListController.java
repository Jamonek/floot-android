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
import android.widget.ImageView;

import com.brentlrayjr.floot.Models.Floot;
import com.brentlrayjr.floot.R;

import java.util.ArrayList;

/**
 * Created by brent on 10/21/15.
 */
public class FlootListController extends RecyclerView.Adapter<FlootListController.ViewHolder> {

    ArrayList<Floot> floots;
    Activity activity;

    public FlootListController(ArrayList<Floot> floots) {

        this.floots = floots;
    }

    public FlootListController(Activity activity) {

        floots = new ArrayList<>();

        this.activity = activity;

    }

    @Override
    public FlootListController.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_view, parent, false);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int p) {

        final Floot floot = floots.get(p);




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

    public void add(Floot floot) {
        this.floots.add(floot);
        notifyItemInserted(floots.indexOf(floot));
    }

    public void addAll(ArrayList<Floot> floots) {
        this.floots.addAll(floots);
        notifyItemRangeInserted(this.floots.indexOf(floots.get(0)), floots.size());
    }

    public void remove(Floot floot) {
        int position = floots.indexOf(floot);
        floots.remove(position);
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
            content = v.findViewById(R.id.post_content);
            upvoteView = (ImageView) v.findViewById(R.id.upvote_view);
            downvoteView = (ImageView) v.findViewById(R.id.downvote_view);

        }
    }


}
