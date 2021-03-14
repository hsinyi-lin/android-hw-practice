package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

 public class Main4Activity extends AppCompatActivity {
        int A,L=1,r=99,passwd;
          private Long startTime,endTime;
         private int spend_time;
         private int count;
         String name;
         final String db_name="testDB2";
     final String tb_name="guess_test2";
     SQLiteDatabase db;
        @Override

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main4);
            Random pass=new Random();
            passwd=pass.nextInt(97)+2;
            Intent play = getIntent();
            name = play.getStringExtra("Name");
            TextView tv_Name = (TextView)findViewById(R.id.textView4);

            tv_Name.setText(name);
            startTime=System.currentTimeMillis();
            count =0;
        }
        public void click_me(View v){
            count++;
            EditText et=(EditText) findViewById(R.id.editText);
            TextView tv=(TextView) findViewById(R.id.textView);
            tv.setMovementMethod(ScrollingMovementMethod.getInstance());
            A=Integer.parseInt(et.getText().toString());
            if(A!=passwd){
                if(A<passwd)
                    L=A;
                else
                    r=A;
                tv.setText(tv.getText()+"請輸入"+L+"~"+r+"\n");
                et.setText("");
            }
            else{
                endTime=System.currentTimeMillis();
                spend_time=(int)(endTime-startTime)/1000;
                tv.setText(tv.getText()+"end\n"+"u spend:"+spend_time+"secs\n"+"次數"+count);
            }


        }
     private void addData(String name, String count, String time){
         ContentValues cv = new ContentValues(3);
         cv.put("name",name);
         cv.put("count",count);
         cv.put("time",time);
         db.insert(tb_name,null,cv);
     }
     public void back(View v)
     {

         db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE,null);
         String createTable = "CREATE TABLE IF NOT EXISTS "+
                 tb_name+
                 "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                 "name VARCHAR(32), "+
                 "count VARCHAR(2), "+
                 "time VARCHAR(5))";
         db.execSQL(createTable);
         ContentValues cv = new ContentValues(3);
         cv.put("name",name);
         cv.put("count",Integer.toString(count));
         cv.put("time",Integer.toString(spend_time));
         db.insert(tb_name,null,cv);
         db.close();
         finish();
     }
     public void check(View v) {
            Intent it = new Intent(this,Main7Activity.class);
            startActivity(it);


     }}
