package com.example.mobileprogrammingex.ex04;

import java.text.SimpleDateFormat;
import java.util.Date;

//데이터 항목에 해당하는 클래스
public class Memo2 {
    final static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
    String title;
    Date date;

    //Memo2 생성자
    public Memo2(String title,Date date){
        this.title=title;
        this.date=date;
    }
    public void setTitle(String title){
        this.title=title;
    }

    public String getTitle(){
        return title;
    }

    public void setDate(Date date){
        this.date=date;
    }

    public Date getDate(){
        return date;
    }

    public String getDateFormatted(){
        //패턴 형태로 변환한 문자열
        return format.format(date);
    }
}
