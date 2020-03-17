package com.appstone.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.appstone.unitconverter.adapter.MenuAdapter;
import com.appstone.unitconverter.model.MenuModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRvMenu = findViewById(R.id.recycler_menu);
        mRvMenu.setHasFixedSize(true);
        mRvMenu.setLayoutManager(new GridLayoutManager(this,2));

        ArrayList<MenuModel> menuList = new ArrayList<>();

            menuList.add(new MenuModel(R.drawable.distance_length_icon,"Distance"));
            menuList.add(new MenuModel(R.drawable.time_icon,"Time"));
            menuList.add(new MenuModel(R.drawable.power_icon,"Power"));
            menuList.add(new MenuModel(R.drawable.num_icon,"Number"));
            menuList.add(new MenuModel(R.drawable.angle_icon,"Angle"));
            menuList.add(new MenuModel(R.drawable.area_icon,"Area"));
            menuList.add(new MenuModel(R.drawable.bloodsugar_icon,"Blood Sugar"));
            menuList.add(new MenuModel(R.drawable.cooking_icon,"Cooking"));
            menuList.add(new MenuModel(R.drawable.data_icon,"Data"));
            menuList.add(new MenuModel(R.drawable.energy_icon,"Energy"));
            menuList.add(new MenuModel(R.drawable.force_icon,"Force"));
            menuList.add(new MenuModel(R.drawable.frequency_icon,"Frequency"));
            menuList.add(new MenuModel(R.drawable.pressure_icon,"Pressure"));
            menuList.add(new MenuModel(R.drawable.speed_icon,"Speed"));
            menuList.add(new MenuModel(R.drawable.temp_icon,"Temperature"));
            menuList.add(new MenuModel(R.drawable.volume_icon,"Volume"));
            menuList.add(new MenuModel(R.drawable.weight_icon,"Weight"));


        MenuAdapter adapter = new MenuAdapter(this, menuList);
        mRvMenu.setAdapter(adapter);

    }
}
