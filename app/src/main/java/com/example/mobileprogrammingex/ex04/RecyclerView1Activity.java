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

public class RecyclerView1Activity extends AppCompatActivity {

    RecyclerView1Adapter recyclerView1Adapter;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view1);

        arrayList=new ArrayList<String>();
        arrayList.add("One");
        arrayList.add("Two");

        recyclerView1Adapter=new RecyclerView1Adapter(this,arrayList);
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        //목록의 항목들 사이에 가로선을 그림
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //목록의 배치를 세로 한 열로 한다, 여러 열로 하고 싶으면 다릉 manager(클래스) 사용
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //항목들이 스크롤/추가/삭제될 때 애니메이션
        recyclerView.setAdapter(recyclerView1Adapter);//recyclerView 뷰 객체에 Adapter 설정

        Button button=findViewById(R.id.btnAdd);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText editText=findViewById(R.id.editText);
                String str=editText.getText().toString();
                editText.setText("");
                arrayList.add(str);
                recyclerView1Adapter.notifyDataSetChanged();//데이터 변경 여부를 어댑터에게 알려줌
                /*어댑터.notify 메소드
                * There are two different classes of data change events, item changes and structural
                 * changes. Item changes are when a single item has its data updated but no positional
                 * changes have occurred. Structural changes are when items are inserted, removed or moved
                 * within the data set.
                * */
            }
        });

    }
}