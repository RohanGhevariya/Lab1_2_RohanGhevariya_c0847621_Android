package com.example.lab1_2_rohanghevariya_c0847621_android;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab1_2_rohanghevariya_c0847621_android.databinding.ProductsViewBinding;

import java.util.ArrayList;

    public class AllProRVAdapter extends RecyclerView.Adapter<AllProRVAdapter.ViewHolder> {

        // variable for our array list and context
        private ArrayList<ProductModel> productModelArrayList;
        private Context context;
        ProductsViewBinding binding;
        private LinearLayout lr;

        // constructor
        public AllProRVAdapter(ArrayList<ProductModel> courseModalArrayList, Context context) {
            this.productModelArrayList = courseModalArrayList;
            this.context = context;
        }
        public interface OnContactClick {
            public void onContactClick(int position);
        }
        ProductRVAdapter.OnContactClick onContactClick;
        public void setOnContactClick(ProductRVAdapter.OnContactClick onContactClick) {
            this.onContactClick = onContactClick;
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            binding = ProductsViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new ViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

            ProductModel model = productModelArrayList.get(position);
            binding.idTVProdName.setText(model.getProductName());
            binding.idTVProductDescription.setText(model.getProductDescription());
            binding.idTVProductPrice.setText(model.getProductPrice());
            binding.idTVProductLocation.setText(model.getProduct_Location());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onContactClick != null) {
                        onContactClick.onContactClick(position);

                    Intent i = new Intent(context, updateActivity.class);

                    // below we are passing all our values.
                    i.putExtra("pro_name", model.getProductName());
                    i.putExtra("pro_description", model.getProductDescription());
                    i.putExtra("pro_price", model.getProductPrice());
                    i.putExtra("pro_location", model.getProduct_Location());

                    // starting our activity.
                    context.startActivity(i);}
                }
            });
        }

        @Override
        public int getItemCount() {
            return productModelArrayList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public ViewHolder(@NonNull ProductsViewBinding binding) {
                super(binding.getRoot());
            }


        }





}
