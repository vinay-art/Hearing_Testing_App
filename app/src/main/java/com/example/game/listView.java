package com.example.game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class listView extends AppCompatActivity {

    ListView listview;
    ArrayList<String> list1;
    static ArrayAdapter arrayAdapter;
    TextView name,gender,age,history;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            Intent intent2 = new Intent(getApplicationContext(),register.class);
            startActivity(intent2);

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        name = findViewById(R.id.name);
        gender = findViewById(R.id.gender);
        age = findViewById(R.id.age);
        history = findViewById(R.id.history);
        list1 = new ArrayList<>();
        Intent intent1 = getIntent();
        list1 = intent1.getStringArrayListExtra("ank");

        name.setText("Name: "+ register.uName);
        age.setText("Age: "+ register.uAge);
        gender.setText("Gender: "+ register.uGender);
        history.setText("Pre Hearing Loss: "+ register.uHistory);
        listview = findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list1);
        listview.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();

    }
}