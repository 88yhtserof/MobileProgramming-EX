package com.example.mobileprogrammingex.ex04;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

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

    public void btnMemo3_clicked(View view){
        Intent intent=new Intent(this, Memo3Activity.class);
        startActivityForResult(intent,0);
        //작업 결과 데이터를 전달받기 기대하면서, 다른 액티비티를 호출할 때  startActivityForResult()사용
        //startActivityForResult를 호출하는 액티비티가 부모 액티비티(Ex04MainActivity),
        //그로인해 호출된 액티비티는 자식 액티비티(Memo3Activity)
    }


    //결과 데이터(result) 받기
    //결과 데이터를 리턴받으려면 부모 액티비티는 OnActivityResult 메소드를 구현해야한다.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(resultCode==RESULT_OK){
            Memo3 memo3= (Memo3) intent.getSerializableExtra("MEMO");
            String str=String.format(
                    "<h1>%s</h><p>%s</p><p style='color:blue'>%s</p>",
                    memo3.getTitle(),memo3.getDateFormatted(), memo3.getContent()
            );
            TextView textView=findViewById(R.id.textView);
            textView.setText(Html.fromHtml(str));
        }
    }
}