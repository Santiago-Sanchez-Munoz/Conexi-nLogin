package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
//import android.volley;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import android.widget.Button;
import android.net.Uri;
import android.content.Intent;
import android.widget.Toast;

import org.json.JSONObject;
import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    //RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //requestQueue = Volley.newRequestQueue(this);

        initUI();
    }

    private void initUI(){
        textView= findViewById(R.id.HaIniciado);
    }
    private void stringRequest(){
        stringRequest();
    }
}