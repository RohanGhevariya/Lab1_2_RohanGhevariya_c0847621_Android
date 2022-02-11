package com.example.lab1_2_rohanghevariya_c0847621_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lab1_2_rohanghevariya_c0847621_android.databinding.ActivityMainBinding;
import com.example.lab1_2_rohanghevariya_c0847621_android.databinding.ActivityViewProductsBinding;

import java.util.ArrayList;

public class ViewProducts extends AppCompatActivity {
    private ActivityViewProductsBinding binding;
    private ArrayList<ProductModel> productModelArrayList;
    private DBhelper dbHandler;
    private ProductRVAdapter productRVAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
this.setTitle("Product");
        productModelArrayList = new ArrayList<>();
        dbHandler = new DBhelper(ViewProducts.this);
        productModelArrayList = dbHandler.readProducts();
        productRVAdapter = new ProductRVAdapter(productModelArrayList, ViewProducts.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewProducts.this, RecyclerView.VERTICAL, false);
        binding.idRVProducts.setLayoutManager(linearLayoutManager);
        binding.idRVProducts.setAdapter(productRVAdapter);
        productRVAdapter.setOnContactClick(new ProductRVAdapter.OnContactClick() {
            @Override
            public void onContactClick(int position) {
                Intent i = new Intent(ViewProducts.this, AllProducts.class);
                startActivity(i);
            }
        });
      //  binding.idRVProducts.setOnClickListener(new View.OnClickListener() );
    }
}