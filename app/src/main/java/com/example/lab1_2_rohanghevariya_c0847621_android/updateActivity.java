package com.example.lab1_2_rohanghevariya_c0847621_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lab1_2_rohanghevariya_c0847621_android.databinding.ActivityMainBinding;
import com.example.lab1_2_rohanghevariya_c0847621_android.databinding.ActivityUpdateBinding;
import com.example.lab1_2_rohanghevariya_c0847621_android.databinding.ActivityViewProductsBinding;

public class updateActivity extends AppCompatActivity {
    private ActivityUpdateBinding binding;
    private DBhelper dbHandler;
    String prodName, prodDesc, prodPrice, prodLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.setTitle("Edit Products");
        dbHandler = new DBhelper(updateActivity.this);
        prodName = getIntent().getStringExtra("pro_name");
        prodDesc = getIntent().getStringExtra("pro_description");
        prodPrice = getIntent().getStringExtra("pro_price");
        prodLocation = getIntent().getStringExtra("pro_location");
        binding.idProductName.setText(prodName);
        binding.idProductDescription.setText(prodDesc);
        binding.idEdtProductPrice.setText(prodPrice);
        binding.idEdtProductLocation.setText(prodLocation);
        binding.idBtnUpdateProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.updateProduct(prodName, binding.idProductName.getText().toString(), binding.idProductDescription.getText().toString(), binding.idEdtProductPrice.getText().toString(), binding.idEdtProductLocation.getText().toString());

                // displaying a toast message that our course has been updated.
                Toast.makeText(updateActivity.this, "Product Updated..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(updateActivity.this, AllProducts.class);
                startActivity(i);
            }
        });

        binding.idBtnDeleteProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.deleteProduct(prodName);
                Toast.makeText(updateActivity.this, "Deleted the Product", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(updateActivity.this, AllProducts.class);
                startActivity(i);
            }
        });
    }
}