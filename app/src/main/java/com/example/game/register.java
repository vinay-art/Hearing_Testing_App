package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class register extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText age,name;
    Spinner gender,history;
    static String uName,uAge,uGender,uHistory;
    Button button;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.editName);
        age = findViewById(R.id.editAge);
        gender = findViewById(R.id.editGender);
        history = findViewById(R.id.editHearing);
        button = findViewById(R.id.button);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.option1, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter1);
        gender.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.option2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        history.setAdapter(adapter2);
        history.setOnItemSelectedListener(this);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uName = name.getText().toString();
                uAge = age.getText().toString();

                if(TextUtils.isEmpty(uName)){
                    Toast.makeText(register.this, "UserName required",Toast.LENGTH_LONG).show();
                    return;
                }
                if(uName.length()>20){
                    Toast.makeText(register.this, "Name is too long",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(uAge)){
                    Toast.makeText(register.this, "Age required",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(uGender)){

                    Toast.makeText(register.this, "Gender required",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(uHistory)){
                    Toast.makeText(register.this, "History required",Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent = new Intent(getApplicationContext(),instuction.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        Spinner gender = (Spinner)parent;
        Spinner history = (Spinner)parent;

        if(i==0)
            return;
        else {
            if (gender.getId() == R.id.editGender) {
                uGender = parent.getItemAtPosition(i).toString();
            }
            if (history.getId() == R.id.editHearing) {
                uHistory = parent.getItemAtPosition(i).toString();
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}