package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.R;

import java.sql.ResultSet;

public class MainActivity2 extends AppCompatActivity {

    float dollar;
    float pound;
    float euro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        dollar = intent.getFloatExtra("dollar_rate", 0.0f);
        pound = intent.getFloatExtra("pound_rate", 0.0f);
        euro = intent.getFloatExtra("euro_rate", 0.0f);
        EditText ett1 = findViewById(R.id.ett1);
        EditText ett2 = findViewById(R.id.ett2);
        EditText ett3 = findViewById(R.id.ett3);
        ett1.setText("" + dollar);
        ett2.setText("" + pound);
        ett3.setText("" + euro);
    }

    public void btn_save(View v){
        EditText ett1 = findViewById(R.id.ett1);
        dollar = Float.parseFloat(ett1.getText().toString());
        EditText ett2 = findViewById(R.id.ett2);
        pound = Float.parseFloat(ett2.getText().toString());
        EditText ett3 = findViewById(R.id.ett3);
        euro = Float.parseFloat(ett3.getText().toString());
        Intent config = getIntent();
        Bundle rate = new Bundle();
        rate.putFloat("dollar_rate", dollar);
        rate.putFloat("pound_rate", pound);
        rate.putFloat("euro_rate", euro);
        config.putExtras(rate);
        setResult(2,config);

        SharedPreferences sp = getSharedPreferences("rate", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat("dollar_rate", dollar);
        editor.putFloat("pound_rate", pound);
        editor.putFloat("euro_rate", euro);
        editor.apply();
        finish();
    }
}