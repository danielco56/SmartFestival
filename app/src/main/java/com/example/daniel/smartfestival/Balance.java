package com.example.daniel.smartfestival;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.daniel.smartfestival.com.example.daniel.smartfestival.services.StaticDataService;

import java.util.ArrayList;



public class Balance extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);

        ArrayList<String> listFromFirstPage = StaticDataService.List;
        // process list

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listFromFirstPage);

        GridView listView = (GridView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);


      //  ImageView ac = (ImageView) findViewById(R.id.account1);

     //   ac.setOnClickListener(new View.OnClickListener() {
    //        @Override
     //       public void onClick(View v) {
      //          Intent ac = new Intent(Balance.this, PaymentMethod.class);
       //         startActivity(ac);
       //     }
      //  });








    }


}
