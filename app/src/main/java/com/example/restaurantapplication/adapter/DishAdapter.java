package com.example.restaurantapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapplication.MainActivity;
import com.example.restaurantapplication.pojo.Dish;
import com.example.restaurantapplication.R;
import com.example.restaurantapplication.pojo.ScrollingList;

import java.util.ArrayList;
import java.util.List;

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishAdapterViewHolder> {
    private ArrayList<Dish> dishList;
    private MainActivity mainActivity;

    public DishAdapter(@NonNull ArrayList<Dish> dishList) {
        this.dishList = dishList;
    }
    int [] i = new int [3];

    @NonNull
    @Override
    public DishAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.cuisine_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, parent, false);
        view.setFocusable(true);
        return new DishAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DishAdapterViewHolder holder, int position) {

        holder.getDishImageViewView().setImageResource(dishList.get(position).getmImageId());
        holder.getTitleTextViewView().setText(dishList.get(position).getName());
        holder.getPriceTextViewView().setText(dishList.get(position).getPrice());
        holder.getRatingTextViewView().setText(dishList.get(position).getRating());
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.quantityTextView.setText(String.valueOf(i[position]++));
                //Toast.makeText(v.getContext(), "clicked", Toast.LENGTH_SHORT).show();
            }
        });
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i[position] >= 0)
                holder.quantityTextView.setText(String.valueOf(i[position]--));
                //Toast.makeText(v.getContext(), "clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dishList.size();
    }

    public class DishAdapterViewHolder extends RecyclerView.ViewHolder{

        ImageView dishImage;
        TextView titleTextView;
        TextView priceTextView;
        TextView ratingTextView;
        TextView quantityTextView;
        Button minus;
        Button plus;

        public DishAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            this.titleTextView = itemView.findViewById(R.id.titleTextView);
            this.priceTextView = itemView.findViewById(R.id.priceTextView);
            this.ratingTextView = itemView.findViewById(R.id.ratingTextView);
            this.dishImage = itemView.findViewById(R.id.photoImageView);
            this.quantityTextView = itemView.findViewById(R.id.amount);
            this.minus = itemView.findViewById(R.id.minus);
            this.plus = itemView.findViewById(R.id.add);
        }

        public TextView getTitleTextViewView() {
            return titleTextView;
        }

        public TextView getPriceTextViewView() {
            return priceTextView;
        }

        public TextView getRatingTextViewView() {
            return ratingTextView;
        }

        public ImageView getDishImageViewView() {
            return dishImage;
        }
    }
}
