package com.example.mobileprogrammingex.ex04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileprogrammingex.R;

import java.util.ArrayList;

public class RecyclerView1Adapter
        extends RecyclerView.Adapter<RecyclerView1Adapter.ViewHolder> {

    //static 클래스는 outer 클래스의 멤버를 사용하지 못한다->가볍다.
    //뷰홀더 객체는 택배 사장, 데이터 항목 한 개에 대한 뷰 객체가 들어있다.
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        //ViewHolder 클래스 생성자
        public ViewHolder(@NonNull View itemView) {//itemView가 뷰홀더상자에 들어갈 뷰 객체
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
        }
    }

    //layout inflation 기능은 layout resource XML 파일의 내용대로 뷰 객체들을 자동으로 생성해주는 기능이다.
    LayoutInflater layoutInflater;
    ArrayList<String> arrayList;

    //RecyclerView1Adapter 클랫스 생성자
    public RecyclerView1Adapter(Context context,ArrayList<String> arrayList){
        this.layoutInflater=LayoutInflater.from(context);
        this.arrayList=arrayList;
    }

    @Override
    public RecyclerView1Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //하나의 데이터 항목 뷰 객체를 생성하고 해당 뷰 객체를 넣은 ViewHolder 객체를 생성해서 리턴
        //ViewGroup 은 RecyclerView
        View view=layoutInflater.inflate(R.layout.memo1,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView1Adapter.ViewHolder holder, final int position) {
        //onCreateViewHolder 를 통해 만들어진 뷰 홀더 객체 내 뷰 객체에 데이터를 채우는 역할
        //ViewHolder 객체 내부의 뷰 객체에 데이터를 채우도록 구현
        holder.textView.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {//데이터 항목 수 리턴
        return arrayList.size();
    }
}
