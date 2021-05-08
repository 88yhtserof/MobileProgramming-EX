package com.example.mobileprogrammingex.ex04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mobileprogrammingex.R;

public class Ex04MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex04_main);
    }

    public void btnRecyclerView1_clicked(View view){
        Intent intent=new Intent(this, RecyclerView1Activity.class);
        startActivity(intent);
    }

    public void btnRecyclerView2_clicked(View view){
        Intent intent=new Intent(this, RecyclerView2Activity.class);
        startActivity(intent);
    }
}