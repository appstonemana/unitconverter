package com.appstone.unitconverter.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appstone.unitconverter.AngleActivity;
import com.appstone.unitconverter.AreaActivity;
import com.appstone.unitconverter.BloodSugarActivity;
import com.appstone.unitconverter.CookingActivity;
import com.appstone.unitconverter.DataActivity;
import com.appstone.unitconverter.DistanceActivity;
import com.appstone.unitconverter.EnergyActivity;
import com.appstone.unitconverter.ForceActivity;
import com.appstone.unitconverter.FrequencyActivity;
import com.appstone.unitconverter.NumberActivity;
import com.appstone.unitconverter.PowerActivity;
import com.appstone.unitconverter.PressureActivity;
import com.appstone.unitconverter.R;
import com.appstone.unitconverter.SpeedActivity;
import com.appstone.unitconverter.TemperatureActivity;
import com.appstone.unitconverter.TimeActivity;
import com.appstone.unitconverter.VolumeActivity;
import com.appstone.unitconverter.WeightActivity;
import com.appstone.unitconverter.model.MenuModel;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private static final String TAG = MenuAdapter.class.getSimpleName();

    private Context mContext;
    private ArrayList<MenuModel> mData;


    public MenuAdapter(Context context, ArrayList<MenuModel> data) {
        this.mContext = context;
        this.mData = data;
    }


    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cell_menu, viewGroup, false);

        return new MenuViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, final int position) {
        // include binding logic here

        MenuModel menu = mData.get(position);
        holder.mTextView.setText(menu.getText());
        holder.mImageView.setImageDrawable(mContext.getResources().getDrawable(menu.getImage()));
        holder.mRootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                switch (position) {
                    case 0:
                        mContext.startActivity(new Intent(mContext, DistanceActivity.class));
                        break;
                    case 1:
                        mContext.startActivity(new Intent(mContext, TimeActivity.class));
                        break;
                    case 2:
                        mContext.startActivity(new Intent(mContext, PowerActivity.class));
                        break;
                    case 3:
                        mContext.startActivity(new Intent(mContext, NumberActivity.class));
                        break;
                    case 4:
                        mContext.startActivity(new Intent(mContext, AngleActivity.class));
                        break;
                    case 5:
                        mContext.startActivity(new Intent(mContext, AreaActivity.class));
                        break;
                    case 6:
                        mContext.startActivity(new Intent(mContext, BloodSugarActivity.class));
                        break;
                    case 7:
                        mContext.startActivity(new Intent(mContext, CookingActivity.class));
                        break;
                    case 8:
                        mContext.startActivity(new Intent(mContext, DataActivity.class));
                        break;
                    case 9:
                        mContext.startActivity(new Intent(mContext, EnergyActivity.class));
                        break;
                    case 10:
                        mContext.startActivity(new Intent(mContext, ForceActivity.class));
                        break;
                    case 11:
                        mContext.startActivity(new Intent(mContext, FrequencyActivity.class));
                        break;
                    case 12:
                        mContext.startActivity(new Intent(mContext, PressureActivity.class));
                        break;
                    case 13:
                        mContext.startActivity(new Intent(mContext, SpeedActivity.class));
                        break;
                    case 14:
                        mContext.startActivity(new Intent(mContext, TemperatureActivity.class));
                        break;
                    case 15:
                        mContext.startActivity(new Intent(mContext, VolumeActivity.class));
                        break;
                    case 16:
                        mContext.startActivity(new Intent(mContext, WeightActivity.class));
                        break;
                    default:
                        break;


                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MenuViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView;
        LinearLayout mRootLayout;

        public MenuViewHolder(View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.img);
            mTextView = itemView.findViewById(R.id.item_name);
            mRootLayout = itemView.findViewById(R.id.ll_root);

        }
    }
}