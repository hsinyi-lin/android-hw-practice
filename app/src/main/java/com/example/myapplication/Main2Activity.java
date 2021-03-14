package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void click_me(View v){
        EditText et = (EditText) findViewById(R.id.editText); //建立一個物件
        TextView tv = (TextView) findViewById(R.id.textView); //建立一個物件來接
        int a = Integer.parseInt(et.getText().toString()); //將et這個EditText
        int i = 1; //除數為1
        int count = 0; //可以整除的次數預設為0
        while(i<=a){ //當i(除數)小於a(et裡面的值)就一直執行
            if(a%i==0) //如果i可以整除a
                count++;//除的次數加一
            i++; //i加一
        }
        if(count==2) //如果次數兩次
            tv.setText(a+"為質數"); //印出a為質數
else //否則
        tv.setText(a+"不為質數");//印出a不為質數
    }
    public void back(View v){
        finish();
    }
}
