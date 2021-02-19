package com.example.restaurantapplication;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.restaurantapplication.Fragments.DishFragment;
import com.example.restaurantapplication.Fragments.CartFragment;
import com.example.restaurantapplication.Fragments.CuisineFragment;
import com.example.restaurantapplication.Fragments.SettingsFragment;
import com.example.restaurantapplication.pojo.Dish;

import java.util.ArrayList;

class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    SimpleFragmentPagerAdapter(@NonNull FragmentManager fm, int behavior, Context context) {
        super(fm, behavior);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        ArrayList<Dish> list = new ArrayList<>();
        list.add(new Dish(R.drawable.pizza, "15", "4", mContext.getResources().getString(R.string.pizza)));
        list.add(new Dish(R.drawable.cake, "20", "3", mContext.getResources().getString(R.string.blueberry_cheesecake)));
        list.add(new Dish(R.drawable.chicken, "10", "5", mContext.getResources().getString(R.string.roasted_chicken)));

        if (position == 0) return new CuisineFragment();
        else if (position == 1) return new DishFragment(list);
        else if (position == 2) return new CartFragment();
        else return new SettingsFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }
}
