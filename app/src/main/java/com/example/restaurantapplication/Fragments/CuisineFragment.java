package com.example.restaurantapplication.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.restaurantapplication.R;
import com.example.restaurantapplication.activity.Items;
import com.example.restaurantapplication.adapter.ScrollingAdapter;
import com.example.restaurantapplication.pojo.ScrollingList;

import java.util.ArrayList;

public class CuisineFragment extends Fragment implements ScrollingAdapter.ScrollingAdapterOnClickListener {

    public ScrollingAdapter scrollingAdapter;
    public RecyclerView recyclerView;

    public CuisineFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list, container, false);
        recyclerView =  rootView.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        SnapHelper snapHelper = new PagerSnapHelper();
        recyclerView.setLayoutManager(layoutManager);
        snapHelper.attachToRecyclerView(recyclerView);

        ArrayList<ScrollingList> scrollingListArrayList = new ArrayList<>();
        scrollingListArrayList.add(new ScrollingList(R.drawable.biryani, R.string.indian));
        scrollingListArrayList.add(new ScrollingList(R.drawable.burger, R.string.american));
        scrollingListArrayList.add(new ScrollingList(R.drawable.tacos, R.string.mexican));
        scrollingListArrayList.add(new ScrollingList(R.drawable.ramen, R.string.chinese));

        scrollingAdapter = new ScrollingAdapter(scrollingListArrayList, this);
        recyclerView.setAdapter(scrollingAdapter);
        return rootView;
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(getActivity(), Items.class);
        position %= 4;
        intent.putExtra("position", position);
        startActivity(intent);
    }
}
