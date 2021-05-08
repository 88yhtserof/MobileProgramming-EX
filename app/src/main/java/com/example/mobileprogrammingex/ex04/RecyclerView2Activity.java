package com.example.mobileprogrammingex.ex04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mobileprogrammingex.R;

import java.util.ArrayList;
import java.util.Date;

public class RecyclerView2Activity extends AppCompatActivity {
    RecyclerView2Adapter recyclerView2Adapter;
    ArrayList<Memo2> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view2);

        arrayList=new ArrayList<Memo2>();
        arrayList.add(new Memo2("one", new Date())); //Memo2 객체를 만들어서 ArrayList의 원소로 저장
        arrayList.add(new Memo2("two", new Date()));

        recyclerView2Adapter=new RecyclerView2Adapter(this, arrayList);//Adapter 객체 생성
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(
                this,DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerView2Adapter); //recyclerView에 Adapter 설정

        Button button=findViewById(R.id.btnAdd);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText editText=findViewById(R.id.editText);
                String str=editText.getText().toString();
                editText.setText("");
                arrayList.add(new Memo2(str, new Date()));
                recyclerView2Adapter.notifyDataSetChanged(); //Adapter에 데이터 변경 알려주기기
            }
        });
   }
}