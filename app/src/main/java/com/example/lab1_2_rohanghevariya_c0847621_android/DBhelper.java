package com.example.lab1_2_rohanghevariya_c0847621_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {


        private static final String DB_NAME = "ProductsDB";
        private static final int DB_VERSION = 1;
        private static final String TABLE_NAME = "myProducts";
        private static final String ID_COL = "pro_id";
        private static final String NAME_COL = "pro_name";
        private static final String PRICE_COL = "pro_price";
        private static final String DESCRIPTION_COL = "pro_description";
        private static final String LOCATION_COL = "pro_location";

        // creating a constructor for our database handler.
        public DBhelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {

            String query = "CREATE TABLE " + TABLE_NAME + " ("
                    + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NAME_COL + " TEXT,"
                    + DESCRIPTION_COL + " TEXT,"
                    + PRICE_COL + " TEXT,"
                    + LOCATION_COL + " TEXT)";


            db.execSQL(query);
        }


        public void addNewProduct(String productName, String productDescription,String productPrice,  String providerLocation) {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            // on below line we are passing all values
            // along with its key and value pair.
            values.put(NAME_COL, productName);
            values.put(DESCRIPTION_COL, productDescription);
            values.put(PRICE_COL, productPrice);
            values.put(LOCATION_COL, providerLocation);

            db.insert(TABLE_NAME, null, values);


            db.close();
        }
    public ArrayList<ProductModel> readProducts() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorProducts = db.rawQuery("SELECT * FROM myProducts LIMIT 1",null);

        // on below line we are creating a new array list.
        ArrayList<ProductModel> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorProducts.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new ProductModel(cursorProducts.getString(1),
                        cursorProducts.getString(2),
                        cursorProducts.getString(3),
                        cursorProducts.getString(4)));
            } while (cursorProducts.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorProducts.close();
        return courseModalArrayList;
    }
    public ArrayList<ProductModel> showProducts() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorProducts = db.rawQuery("SELECT * FROM myProducts",null);

        // on below line we are creating a new array list.
        ArrayList<ProductModel> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorProducts.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new ProductModel(cursorProducts.getString(1),
                        cursorProducts.getString(2),
                        cursorProducts.getString(3),
                        cursorProducts.getString(4)));
            } while (cursorProducts.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorProducts.close();
        return courseModalArrayList;
    }
    // method for deleting
    public void deleteProduct(String courseName) {


        SQLiteDatabase db = this.getWritableDatabase();


        db.delete(TABLE_NAME, "pro_name=?", new String[]{courseName});
        db.close();
    }
    //update
    public void updateProduct(String originalProductName,String productName, String productDescription,String productPrice,  String providerLocation) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_COL, productName);
        values.put(DESCRIPTION_COL, productDescription);
        values.put(PRICE_COL, productPrice);
        values.put(LOCATION_COL, providerLocation);


        db.update(TABLE_NAME, values, "pro_name=?", new String[]{originalProductName});
        db.close();
    }


    @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // this method is called to check if the table exists already.
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }



