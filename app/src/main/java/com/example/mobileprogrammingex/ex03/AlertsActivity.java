package com.example.mobileprogrammingex.ex03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mobileprogrammingex.R;

import java.util.List;

public class AlertsActivity extends AppCompatActivity {
    //dialog : 대화상자

    int selectedAnimalIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);
    }

    public void button1_clicked(View button){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setMessage(R.string.saveSuccess);
        builder.setNeutralButton(R.string.close,null);//파라미터1 text, 파라미터2 클릭리스너
        AlertDialog dialog=builder.create();//builder의 arguments로 AlertDialog 객체 생성
        dialog.show();
    }

    public void button2_clicked(View button){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setTitle(R.string.confirm);
        builder.setMessage(R.string.doYouWantToDelete);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //삭제 작업 실행
                Toast.makeText(AlertsActivity.this,"삭제성공",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.no,null);//클릭리스너 설정 안 함

        AlertDialog dialog=builder.create();//builder의 arguments로 AlertDialog 객체 생성
        dialog.show();
    }

    public void button3_clicked(View button){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(R.string.selectAnimal);
        builder.setSingleChoiceItems(R.array.animals,selectedAnimalIndex,null);//클릭 리스너 null
        builder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //선택된 항목에 대한 작업 실행
                ListView listView=((AlertDialog)dialog).getListView();//해당 dialog에 사용될 listView 얻기
                selectedAnimalIndex=listView.getCheckedItemPosition();//선택된 아이템의 위치 반환
                String msg=selectedAnimalIndex+"번째 항목이 선택되었습니다.";
                Toast.makeText(AlertsActivity.this, msg, Toast.LENGTH_SHORT).show();

                int drawableId=0;
                switch(selectedAnimalIndex){
                    case 0: drawableId=R.drawable.animal_cat_large; break;
                    case 1: drawableId=R.drawable.animal_dog_large; break;
                    case 2: drawableId=R.drawable.animal_owl_large; break;
                }
                ImageView imageView1=(ImageView) findViewById(R.id.imageView1);
                imageView1.setImageResource(drawableId);
            }
        });

        builder.setNegativeButton(R.string.cancel,null);
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}