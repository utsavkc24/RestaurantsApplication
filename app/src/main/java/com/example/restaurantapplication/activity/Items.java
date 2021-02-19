package com.example.restaurantapplication.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.restaurantapplication.Fragments.DishFragment;
import com.example.restaurantapplication.MainActivity;
import com.example.restaurantapplication.R;
import com.example.restaurantapplication.pojo.Dish;

import java.util.ArrayList;

public class Items extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_activity);
        Bundle bundle = getIntent().getExtras();
        int position = bundle.getInt("position");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (position){
            case 0:
                fragmentTransaction.replace(R.id.items, new DishFragment(getList(2))).commit();
                this.setTitle(R.string.indian);
                break;
            case 1:
                fragmentTransaction.replace(R.id.items, new DishFragment(getList(0))).commit();
                this.setTitle(R.string.american);
                break;
            case 2:
                fragmentTransaction.replace(R.id.items, new DishFragment(getList(3))).commit();
                this.setTitle(R.string.mexican);
                break;
            case 3:
                fragmentTransaction.replace(R.id.items, new DishFragment(getList(1))).commit();
                this.setTitle(R.string.chinese);
                break;
        }
    }

    public ArrayList<Dish> getList(int id){

        ArrayList<Dish> american = new ArrayList<>();
        american.add(new Dish(R.drawable.chicken_fajitas, "15", "4", getBaseContext().getResources().getString(R.string.chicken_fajitas)));
        american.add(new Dish(R.drawable.pizza, "10", "5", getBaseContext().getResources().getString(R.string.pizza)));
        american.add(new Dish(R.drawable.burger, "20", "3", getBaseContext().getResources().getString(R.string.burger)));

        ArrayList<Dish> chinese = new ArrayList<>();
        chinese.add(new Dish(R.drawable.kung_pao, "20", "3", getBaseContext().getResources().getString(R.string.kung_pao_chicken)));
        chinese.add(new Dish(R.drawable.chicken, "10", "5", getBaseContext().getResources().getString(R.string.roasted_chicken)));
        chinese.add(new Dish(R.drawable.ramen, "15", "4", getBaseContext().getResources().getString(R.string.ramen)));

        ArrayList<Dish> indian = new ArrayList<>();
        indian.add(new Dish(R.drawable.butter_chicken, "10", "5", getBaseContext().getResources().getString(R.string.butter_chicken)));
        indian.add(new Dish(R.drawable.shawarma, "20", "3", getBaseContext().getResources().getString(R.string.shawarma)));
        indian.add(new Dish(R.drawable.biryani, "15", "4", getBaseContext().getResources().getString(R.string.biryani)));

        ArrayList<Dish> mexican = new ArrayList<>();
        mexican.add(new Dish(R.drawable.nacho, "10", "5", getBaseContext().getResources().getString(R.string.nachos)));
        mexican.add(new Dish(R.drawable.cake, "20", "3", getBaseContext().getResources().getString(R.string.cake)));
        mexican.add(new Dish(R.drawable.tacos, "15", "4", getBaseContext().getResources().getString(R.string.taco)));

        switch (id){
            case 0 :
                return american;
            case 1:
                return chinese;
            case 2:
                return indian;
            default:
                return mexican;
        }
    }
}
