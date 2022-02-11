package com.example.lab1_2_rohanghevariya_c0847621_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lab1_2_rohanghevariya_c0847621_android.databinding.ActivityAllProductsBinding;
import com.example.lab1_2_rohanghevariya_c0847621_android.databinding.ActivityViewProductsBinding;

import java.util.ArrayList;

public class AllProducts extends AppCompatActivity {
    private ActivityAllProductsBinding binding;
    private ArrayList<ProductModel> productModelArrayList;
    private DBhelper dbHandler;
    private AllProRVAdapter allProRVAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.setTitle("All Products");
        productModelArrayList = new ArrayList<>();
        dbHandler = new DBhelper(AllProducts.this);
        productModelArrayList = dbHandler.showProducts();
        allProRVAdapter = new AllProRVAdapter(productModelArrayList, AllProducts.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AllProducts.this, RecyclerView.VERTICAL, false);
        binding.idRVAllProducts.setLayoutManager(linearLayoutManager);
        binding.idRVAllProducts.setAdapter(allProRVAdapter);
        allProRVAdapter.setOnContactClick(new ProductRVAdapter.OnContactClick() {
            @Override
            public void onContactClick(int position) {
                Intent i = new Intent(AllProducts.this, updateActivity.class);
                startActivity(i);
            }
        });
        binding.btnAddNewProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AllProducts.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}