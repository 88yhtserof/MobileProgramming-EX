package com.example.mobileprogrammingex.ex03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogrammingex.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//메뉴가 생성되어야 할 때 자동호출됨
        getMenuInflater().inflate(R.menu.menu_main,menu);
        /*
        * inflation: XML 리소스 파일의 내용대로 Java 객체를 자동 생성해주는 기능
        * inflatior: 위 기능의 객체
        * inflate():메뉴 XML 리소스 차일에 정의된 내용대로, 메뉴 아이템 객체들을 생성해 준다.
        * */
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//메뉴항목이 클릭되면 자동호출
        int id=item.getItemId(); //클릭된 메뉴 항목 id

        //회원가입 클릭 시
        if(id==R.id.action_signUp){
                Intent intent=new Intent(this, SignupActivity.class);
                startActivity(intent);
            return true;
        }
        //메모장 클릭 시
        else if(id==R.id.action_memo){
            Toast.makeText(this,"메모장 메뉴 클릭", Toast.LENGTH_SHORT).show();
            return true;
        }
        //spinner 클리 시
        else if(id==R.id.action_spinners){
            Intent intent=new Intent(this,SpinnersActivity.class);
            startActivity(intent);
            return true;
        }
        //Alerts 클릭 시
        else if(id==R.id.action_alerts){
            Intent intent=new Intent(this,AlertsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
