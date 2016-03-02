package com.example.grzesiek.myapplication;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by grzesiek on 23.02.16.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView categoryName;
        TextView duration;
        ImageView categoryMarker;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.activity_card);
            categoryName = (TextView) itemView.findViewById(R.id.category_name);
            duration = (TextView) itemView.findViewById(R.id.duration);
            categoryMarker = (ImageView) itemView.findViewById(R.id.category_marker);
        }
    }

    List<Event> activities;

    RVAdapter(List<Event> persons){
        this.activities = persons;
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_card, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }


    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.categoryName.setText(activities.get(i).category.name);
        DateFormat df = new SimpleDateFormat("dd.MM HH:mm");
        DateFormat df2 = new SimpleDateFormat("HH:mm"); //handling day swift needed
        personViewHolder.duration.setText(df.format(activities.get(i).beginning).toString() + " - " + df2.format(activities.get(i).ending).toString());
        android.graphics.drawable.Drawable categoryMarker = personViewHolder.categoryMarker.getDrawable();
        if (categoryMarker != null) {
            categoryMarker.mutate();
            categoryMarker.setColorFilter(Color.parseColor(activities.get(i).category.color), android.graphics.PorterDuff.Mode.SRC_ATOP);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
