package com.example.mobileprogrammingex.ex04;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mobileprogrammingex.R;

import java.util.ArrayList;
import java.util.Iterator;

public class RecyclerView3Activity extends AppCompatActivity {

    RecyclerView3Adapter recyclerView3Adapter;
    ArrayList<Memo3> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view3);

        arrayList=new ArrayList<Memo3>();

        recyclerView3Adapter=new RecyclerView3Adapter(this, arrayList);
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerView3Adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recycler_view3,menu);
        MenuItem menuItem=menu.findItem(R.id.action_remove);
        menuItem.setVisible(recyclerView3Adapter.checkCount>0); //선택되었을 때만 삭제메뉴가 보이도록
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_create){
            Intent intent=new Intent(this, Memo3Activity.class);
            startActivityForResult(intent,0); //결과 값을 기대하며 액티비티 전환
        }else if(id==R.id.action_remove){
            removeMemos();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //액티비티 결과물을 받으면 뭘 할 건지 정의
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(resultCode==RESULT_OK){
            Memo3 memo3=(Memo3) intent.getSerializableExtra("MEMO");//해당 문자열이 키인 값 저장
            arrayList.add(memo3);
            recyclerView3Adapter.notifyDataSetChanged();//어댑터에 데이터 변경 알려주기
        }
    }

    private void removeMemos() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this); //빌더 객체 생성
        builder.setTitle(R.string.confirm);
        builder.setMessage(R.string.doYouWantToDelete);

        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Iterator<Memo3> iterator=arrayList.iterator();

                while (iterator.hasNext()){
                    if (iterator.next().isChecked())
                        iterator.remove();//iterator.next()의 항목 삭제
                    recyclerView3Adapter.notifyDataSetChanged();
                }
            }
        });

        builder.setNegativeButton(R.string.no,null);
        AlertDialog dialog=builder.create(); //다이얼로그 생성
        dialog.show();
    }
}