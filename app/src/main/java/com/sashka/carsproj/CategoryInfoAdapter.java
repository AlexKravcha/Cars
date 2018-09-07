package com.sashka.carsproj;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryInfoAdapter extends RecyclerView.Adapter<CategoryInfoAdapter.Holder> {

    private ArrayList<CategoryInfo> categoryInfo;

    public CategoryInfoAdapter(ArrayList<CategoryInfo> categoryInfos) {
        this.categoryInfo = categoryInfos;
    }

    Context context;

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_inf_item, parent, false);
        context = parent.getContext();
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final CategoryInfo categoryInfo = this.categoryInfo.get(position);
        holder.imageView_car.setImageDrawable(context.getDrawable(categoryInfo.idImageView));

        holder.textViewProdName.setText(categoryInfo.prodName);
        holder.textViewHours.setText(categoryInfo.hours);
        holder.textViewKm.setText(categoryInfo.km);
        holder.textViewPhone.setText(categoryInfo.phoneNumber);
        holder.textViewStoreName.setText(categoryInfo.storeName);
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) onItemClickListener.onClick(categoryInfo);
        });

    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    interface OnItemClickListener {
        void onClick(CategoryInfo categoryInfo);
    }

    @Override
    public int getItemCount() {
        return categoryInfo.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public ImageView imageView_car;
        public TextView textViewProdName;
        public TextView textViewStoreName;
        public TextView textViewPhone;
        public TextView textViewKm;
        public TextView textViewHours;


        public Holder(View itemView) {

            super(itemView);
            imageView_car = itemView.findViewById(R.id.image_view_car);
            textViewProdName = itemView.findViewById(R.id.text_view_prod_name);
            textViewStoreName = itemView.findViewById(R.id.text_view_store_name);
            textViewPhone = itemView.findViewById(R.id.text_view_phone);
            textViewKm = itemView.findViewById(R.id.text_view_km);
            textViewHours = itemView.findViewById(R.id.text_view_hours);


        }
    }
}
