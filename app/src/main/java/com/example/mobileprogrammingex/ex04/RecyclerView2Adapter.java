package com.example.mobileprogrammingex.ex04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileprogrammingex.R;

import java.util.ArrayList;

public class RecyclerView2Adapter extends
        RecyclerView.Adapter<RecyclerView2Adapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textView1);
            textView2=itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(this);
            //뷰 객체에 리스너 객체 설정->뷰 객체에 리스너를 설정하지 않으면 재정의를 했다고 해서
            // onClick 메소드가 호출되지 않는다.
        }
        public void setData(int position){
            Memo2 memo2=arrayList.get(position);
            textView1.setText(memo2.getTitle());
            textView2.setText(memo2.getDateFormatted());
        }

        @Override
        public void onClick(View view) {
            int position=super.getAdapterPosition();//ViewHolder 객체에 채워진 데이터 항목의 index 반환
            Memo2 memo=arrayList.get(position);
            String str=String.format("index:%d, title: %s", position,memo.getTitle());
            Toast.makeText(view.getContext(),str,Toast.LENGTH_SHORT).show();
        }
    }

    //layout inflation 기능은 layout resource XML 파일의 내용대로 뷰 객체들을 자동으로 생성해주는 기능이다.
    LayoutInflater layoutInflater;
    ArrayList<Memo2> arrayList;

    //RecyclerView2Adapter 생성자
    public RecyclerView2Adapter(Context context,ArrayList<Memo2> arrayList){
        this.layoutInflater=LayoutInflater.from(context);
        this.arrayList=arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //뷰 객체를 담은 뷰홀더 객체 반환
        View view=layoutInflater.inflate(R.layout.memo2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //onCreateViewHolder를 통해 생성된 뷰 홀더 개체 내 뷰 객체에 데이터 채우기
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
