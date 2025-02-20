package com.example.zdorovieappshop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zdorovieappshop.Activity.DetailActivity;
import com.example.zdorovieappshop.Domain.ItemsDomain;
import com.example.zdorovieappshop.R;

import java.util.ArrayList;

public class BestDealAdapter extends RecyclerView.Adapter<BestDealAdapter.viewholder> {
    ArrayList<ItemsDomain> items;
    Context context;
    public BestDealAdapter(ArrayList<ItemsDomain> items) {
        if (items != null) {
            this.items = items;
        } else {
            this.items = new ArrayList<>();
        }
    }
    @NonNull
    @Override
    public BestDealAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_best_deal, parent, false);
        return new viewholder(inflate);
    }
    @Override
    public void onBindViewHolder(@NonNull BestDealAdapter.viewholder holder, int position) {

        holder.titleTxt.setText(items.get(position).getTitle());
        holder.priceTxt.setText(items.get(position).getPrice() + "₽/кг");

        int drawableResourceId = holder.itemView.getResources()
                .getIdentifier(items.get(position).getImgPath(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.pic);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("object", items.get(position));
            context.startActivity(intent);
        });
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public class viewholder extends RecyclerView.ViewHolder {
        TextView titleTxt, priceTxt;
        ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.titleTxt);
            priceTxt = itemView.findViewById(R.id.priceTxt);
            pic = itemView.findViewById(R.id.img34);
        }
    }
}
