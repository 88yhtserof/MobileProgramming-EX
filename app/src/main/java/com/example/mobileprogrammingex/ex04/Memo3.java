package com.example.mobileprogrammingex.ex04;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Memo3 implements Serializable {
    final static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
    String title;
    String content;
    Date date;
    boolean checked;

    //Memo2 생성자
    public Memo3(String title, String content, Date date){
        this.title=title;
        this.content = content;
        this.date=date;
    }
    public void setTitle(String title){
        this.title=title;
    }

    public String getTitle(){
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    //메뉴 Code/Generate/Constructor 사용하면 편하다.
    //boolean 타입의 get메소드 이름은 is로 시작하는 것이 바람직하다.
    public boolean isChecked(){
        return checked;
    }

    public void setChecked(boolean checked){
        this.checked=checked;
    }
}

