package com.example.mobileprogrammingex.ex04;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileprogrammingex.R;

import java.util.ArrayList;

public class RecyclerView3Adapter
        extends RecyclerView.Adapter<RecyclerView3Adapter.ViewHolder> {
    class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        /*
        지금까지 anonymous inner 클래스(익명 클래스) 문법을 사용하여 Listener 클래스 구현했는데,
        클래스에 Listener 인터페이스를 구현해도 된다.
        (데이터 항목 하나에 대한 리스너는 뷰홀더에 리스너를 구현해야 좋음)
        RecyclerView에서 데이터 항목 리스너 객체는 한 항목(객체)마다 하나씩 있어야 한다.
        즉 RecyclerView에서 데이터 항목 리스너 객체 수=데이터 항목 뷰 객체 수
        (뷰홀더 객체 내 데이터 항목 뷰 객체 존재)
        뷰홀더 객체가 뷰홀더 역할도 하고 리스너 객체 역할도 수행
        */
        TextView textView1,textView2;
        CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            //뷰홀더 객체에 리스너를 구현하는 것이 바람직하다.
            super(itemView);
            textView1=itemView.findViewById(R.id.textView1);
            textView2=itemView.findViewById(R.id.textView2);
            textView1.setOnClickListener(this);
            //itemView.setOnClickListener(this);를 하면 뷰 객체 어디를 눌러도 무조건 클릭 리스너 호출
            //뷰 객체에 리스너 객체 설정->뷰 객체에 리스너를 설정하지 않으면 재정의를 했다고 해서
            // onClick 메소드가 호출되지 않는다.
            checkBox=itemView.findViewById(R.id.checkBox);
            checkBox.setOnCheckedChangeListener(this);
        }
        public void setData(int position){
            //데이터 객체에 각 뷰 객체에 대한 값이 저장되어 있기 때문에 스크롤을 해도 값이 달라지지 않는다.
            Memo3 memo3=arrayList.get(position);
            textView1.setText(memo3.getTitle());
            textView2.setText(memo3.getDateFormatted());
            checkBox.setChecked(memo3.isChecked());//초기 체크 여부 설정
        }

        @Override
        public void onClick(View view) {
            int position=super.getAdapterPosition();//ViewHolder 객체에 채워진 데이터 항목의 index 반환
            Memo3 memo=arrayList.get(position);
            String str=String.format("index:%d, title: %s", position,memo.getTitle());
            Toast.makeText(view.getContext(),str,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int position=super.getAdapterPosition();
            Memo3 memo3=arrayList.get(position);
            memo3.setChecked(isChecked);//변경된 체크 여부 설정
            //체크 여부가 데이터 객체에 설정되어 있기 때문에 스크롤 했다고 해서 체크 여부가 달라지지 않는다.
            if(isChecked) ++checkCount; else --checkCount;
            if(checkCount==0 ||checkCount==1){
                Activity activity= (Activity) textView1.getContext();
                //뷰객체는 부모 액티비티를 알고 있다. 따라서 액티비티의 context을 알고 싶으면 뷰 객체 사용
                activity.invalidateOptionsMenu();
            }
        }
    }

    //layout inflation 기능은 layout resource XML 파일의 내용대로 뷰 객체들을 자동으로 생성해주는 기능이다.
    LayoutInflater layoutInflater;
    ArrayList<Memo3> arrayList;
    int checkCount=0;

    //RecyclerView2Adapter 생성자
    public RecyclerView3Adapter(Context context, ArrayList<Memo3> arrayList){
        this.layoutInflater=LayoutInflater.from(context);
        this.arrayList=arrayList;
    }

    @Override
    public RecyclerView3Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //뷰 객체를 담은 뷰홀더 객체 반환
        View view=layoutInflater.inflate(R.layout.memo2,parent,false);
        return new RecyclerView3Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView3Adapter.ViewHolder holder, int position) {
        //onCreateViewHolder를 통해 생성된 뷰 홀더 개체 내 뷰 객체에 데이터 채우기
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
