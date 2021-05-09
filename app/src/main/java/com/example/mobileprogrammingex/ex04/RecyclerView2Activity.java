package com.example.mobileprogrammingex.ex04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mobileprogrammingex.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recycler_view2,menu);
        return true;
    }

    //Java 언어의 Iterator 인터페이스의 탐색 기능과 삭제 기능 이용하여 구현
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_remove){
             removeMemo();
                return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void removeMemo() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirm);
        builder.setMessage(R.string.doYouWantToDelete);

        //클릭이벤트 리스너가 해당 builder가 PositiveButton에 설정되었을 뿐 호출된 건 아니다.
        //클릭이 되어야 onClick이 호출된다.
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Iterator<Memo2> iterator=arrayList.iterator();
                //arrayList 목록을 탐색할 수 있는 Iterator 객체가 반환된다.
            /*Iterator
            Iterator <Memo2>객체는 ArrayList<Memo2>를 탐색하기 위한 메소드가 있는 탐색 객체이다.
             */

                while (iterator.hasNext())
                    if(iterator.next().isChecked())
                        iterator.remove();//next()가 반환한 그 객체를 삭제
                recyclerView2Adapter.notifyDataSetChanged();
                //항목 삭제 후 Adapter 객체의 notifyDataSetChanged()메소드를 호출해야 화면이 다시 그려짐
            }
        });

        builder.setNegativeButton(R.string.no,null);
        AlertDialog dialog=builder.create();
        dialog.show();
        //대화상자가 보인 후는 removeMemo()메소드가 리턴된 후이다.
        //즉 대화상자를 출력하자마자 이 메소드는 리턴한다. 그리고 앱은 대기(idle)상태가 된다.
        //중요!! 화면에 무언가 출력되었다는 건, 구현한 메소드가 리턴했다는 것이다.
    }
}