package com.example.mobileprogrammingex.ex03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobileprogrammingex.R;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button button=findViewById(R.id.button);
        //회원가입 버튼 이벤트 리스너(listener 는 이벤트 리스너 객체)
        View.OnClickListener listener=new View.OnClickListener(){
            //여기서의 this는 context가 아니라 자기자신인 anonymous inner class 객체
            //inner class의 메소드에서 outer classdml this를 사용하려면 outer 클래스명.this
            @Override
            public void onClick(View v) {
                //로그인 아이디
                //findViewById()메소드는 액티비티 클래스의 메소드이다.
                EditText editText_loginId=findViewById(R.id.editText_loginId);
                String loginId=editText_loginId.getText().toString(); //아이디 받아오기
                //getText 메소드가 반환하는 것은 Editable 객체
                if(isEmptyOrWhiteSpace(loginId))
                    editText_loginId.setError("로그인 아이디를 입력하세요!");//입력오류 에러 메세지 표시

                //비밀번호
                EditText editText_password=findViewById(R.id.editText_password);
                String password=editText_password.getText().toString();//비밀번호 받아오기
                if(isEmptyOrWhiteSpace(password))
                    editText_password.setError("비밀번호를 입력하세요!");//입력오류 에러 메세지 표시

                //비밀번호 확인
                EditText editText_password2=findViewById(R.id.editText_password2);
                String password2=editText_password2.getText().toString();//비밀번호 확인 받아오기
                if(password2.equals(password)==false)
                    editText_password2.setError("비밀번호가 일치하지 않습니다!");//입력오류 에러 메세지 표시

                //이메일
                EditText editText_email=findViewById(R.id.editText_email);
                String email=editText_email.getText().toString();//이메일 받아오기
                if(isEmptyOrWhiteSpace(password2))
                    editText_email.setError("이메일을 입력하세요!");//입력오류 에러 메세지 표시

                //회원 가입 데이터를 서버에 전송하는 코드를 구현해야 함

                String msg="회원가입 성공"+loginId+" "+email;
                Toast.makeText(SignupActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        };
        button.setOnClickListener(listener); //버튼에 이벤트 리스너 등록
    }

    private static boolean isEmptyOrWhiteSpace(String str) {
        if(str==null) return true;
        return str.trim().length()==0; //빈 문자열 또는 공백이면 true 반환
    }
}