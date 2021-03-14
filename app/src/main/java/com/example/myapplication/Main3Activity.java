package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void click_me(View v) {
        EditText et = (EditText) findViewById(R.id.editText);
        EditText et2 = (EditText) findViewById(R.id.editText2);
        TextView tv = (TextView) findViewById(R.id.textView);

        int a = Integer.parseInt(et.getText().toString());
        int b = Integer.parseInt(et2.getText().toString());
        int c ;
        do{
            c = a % b;
            a = b;
            b = c;
        }while(c!=0);
        tv.setText("GCD" +a);
    }
    public void back(View v){
        finish();
    }

}



