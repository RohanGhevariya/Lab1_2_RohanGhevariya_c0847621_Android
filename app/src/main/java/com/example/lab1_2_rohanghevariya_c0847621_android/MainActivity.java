package com.example.lab1_2_rohanghevariya_c0847621_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lab1_2_rohanghevariya_c0847621_android.databinding.ActivityMainBinding;

//testing
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private DBhelper dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
this.setTitle("Add Product");
        dbHandler=new DBhelper(MainActivity.this);
        binding.idBtnAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pname=  binding.idProductName.getText().toString();
                String pdesc= binding.idProductDescription.getText().toString();
                String pprice= binding.idEdtProductPrice.getText().toString();
                String plocation= binding.idEdtProductLocation.getText().toString();
                if (pname.isEmpty() && pdesc.isEmpty() && plocation.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addNewProduct(pname,pdesc,pprice,plocation);

                Toast.makeText(MainActivity.this, "Product has been added.", Toast.LENGTH_SHORT).show();
                binding.idProductName.setText("");
                binding.idProductDescription.setText("");
                binding.idEdtProductPrice.setText("");
                binding.idEdtProductLocation.setText("");
                Intent i = new Intent(MainActivity.this, AllProducts.class);
                startActivity(i);
            }
        });
        binding.idBtnAllProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AllProducts.class);
                startActivity(i);
            }
        });
    }
}