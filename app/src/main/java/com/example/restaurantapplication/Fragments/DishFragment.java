package com.example.restaurantapplication.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapplication.R;
import com.example.restaurantapplication.adapter.DishAdapter;
import com.example.restaurantapplication.pojo.Dish;

import java.util.ArrayList;

public class DishFragment extends Fragment {

    private ArrayList<Dish> list;

    public DishFragment(ArrayList<Dish> list){
        this.list = list;
    }

    public RecyclerView recyclerView;
    public DishAdapter dishAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        recyclerView =  rootView.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        dishAdapter = new DishAdapter(list);
        recyclerView.setAdapter(dishAdapter);
        return rootView;
    }
}
