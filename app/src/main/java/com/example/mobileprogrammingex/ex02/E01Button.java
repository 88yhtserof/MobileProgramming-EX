package com.example.mobileprogrammingex.ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mobileprogrammingex.R;

//모든 클래스의 부모 클래스는 Activity 클래스이다
public class E01Button extends AppCompatActivity {// 이 클래스의 부모클래스는 AppCompatActivity 클래스

    static final String TAG="logcat";

    //on~ :~할 때 자동으로 생성되는 메서드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*onCreate():
        안드로이드 앱의 화면이 시작될 때, 해당 액티비티 클래스의 onCreate() 메소드가 자동호출
        따라서 화면이 처음 시작될 때 해야할 일은 onCreate 에 재정의하여 구현
        */
        super.onCreate(savedInstanceState);//첫 줄 필수
        setContentView(R.layout.activity_e01_button); //뷰 객체 자동 생성

        Button button=(Button)findViewById(R.id.button);
        //이 Button 객체는 setContentView 호출로 자동 생성됨
        //findViewById:setContentView 메소드에 의해서 자동 생성된 객체들의 참조를 반환하는 메소드

        Log.d(TAG,"클릭 리스너 시작");
        View.OnClickListener listenerObj= new View.OnClickListener(){//객체 생성(리스너 객체)
            /*
            * 리스너 객체에 대한 참조(주소)를 지역변수 listenerObj 에 저장하여
            * Button 객체의 setOnClickListener 의 파라미터로 전달
            * 자바에서 저장, 반환되는 것은 객체 자체가 아니라 객체를 가리키는 참조이다.
            * */
            @Override
            public void onClick(View v) {//해당 리스너 객체가 등록된 view 가 클릭될 때 실행됨
                /*이벤트 핸들러 메소드:
                *  특정한 상황이나 사건 발생과 동시에 자동호출되는 메소드
                * 예) onCreate 메소드, onClick 메소드
                * 액티비티 클래스의 이벤트 핸들러는 액티비티의 자식 클래스를 만들어서 구현,
                * 뷰 클래스의 이벤트 리스너는 리스너 클래스를 만들어 구현
                * 이벤트 핸들러 메소드인 onClick 를 구현할 리스너 인터페이스는 onClickListener 이다.
                * */
                EditText editText=(EditText)findViewById(R.id.editText);
                CharSequence sequence=editText.getText();
                TextView textView=(TextView)findViewById(R.id.text_hello_world);
                textView.setText(sequence);
            }
        };

        Log.d(TAG, "button 에 리스너 객체 등록");
        button.setOnClickListener(listenerObj);//리스너 객체 listenerObj 를 버튼 button 에 등록
        //button 이 클릭되면 listenerObj 의 onClick 이벤트 핸들러 메소드가 자동 호출
    }
}