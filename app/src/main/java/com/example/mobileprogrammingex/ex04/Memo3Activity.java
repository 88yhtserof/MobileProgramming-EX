package com.example.mobileprogrammingex.ex04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mobileprogrammingex.R;

import java.util.Date;

public class Memo3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo3);

        Button button=findViewById(R.id.btnSave);
        //리스너 객체 생성
        View.OnClickListener listener= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText_title=findViewById(R.id.editText_title);
                String title=editText_title.getText().toString();

                //TextUtils 를 사용하면 해당 TextView 의 null 체크 및 빈값 여부를 체크합니다.
                if(TextUtils.isEmpty(title)){
                    editText_title.setError("제목을 입력하세요");
                    return;
                }

                EditText editText_content=findViewById(R.id.editText_content);
                String content=editText_content.getText().toString();
                if(TextUtils.isEmpty(content)){
                    editText_content.setError("내용을 입력하세요");
                }

                Memo3 memo3=new Memo3(title,content,new Date());
                Intent intent=new Intent();
                intent.putExtra("MEMO",memo3);
                //RESULT_CANCLED를 만들 때에는 putExtra()를 할 필요없다.
                //그냥 생성한 Intent 객체만 파라미터로 넘겨준다. setResult(RESULT_CANCLED,intent)
                setResult(RESULT_OK,intent);
                finish();
            }
        };
        button.setOnClickListener(listener);//버튼에 리스너 객체 설정
    }
}