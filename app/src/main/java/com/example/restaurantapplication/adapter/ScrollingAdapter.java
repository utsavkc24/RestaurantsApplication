package com.example.restaurantapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapplication.R;
import com.example.restaurantapplication.pojo.ScrollingList;

import java.util.ArrayList;

public class ScrollingAdapter extends RecyclerView.Adapter<ScrollingAdapter.ScrollingAdapterViewHolder> {

    private ArrayList<ScrollingList> cuisineScrollingList;
    private final ScrollingAdapterOnClickListener listener;

    public ScrollingAdapter(@NonNull ArrayList<ScrollingList> cuisineScrollingList,
                            ScrollingAdapterOnClickListener listener) {
        this.cuisineScrollingList = cuisineScrollingList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ScrollingAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.scrolling_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);
        view.setFocusable(true);
        return new ScrollingAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScrollingAdapter.ScrollingAdapterViewHolder holder, int position) {

        position = position % 4;
        holder.getCuisineImageViewView().setImageResource(cuisineScrollingList.get(position).getmImageId());
        holder.getCuisineTextViewView().setText(cuisineScrollingList.get(position).getmTitle());
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public class ScrollingAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView cuisineImageView;
        TextView cuisineTextView;

        public ScrollingAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cuisineImageView = itemView.findViewById(R.id.image_slider);
            this.cuisineTextView = itemView.findViewById(R.id.cuisine_text);
            itemView.setOnClickListener(this);
        }

        public TextView getCuisineTextViewView() {
            return cuisineTextView;
        }

        public ImageView getCuisineImageViewView() {
            return cuisineImageView;
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            listener.onClick(adapterPosition);
        }
    }

    public interface ScrollingAdapterOnClickListener {
        void onClick(int position);
    }
}
