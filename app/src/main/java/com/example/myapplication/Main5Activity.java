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

public class Main5Activity extends AppCompatActivity {
    int []p=new int[4];
    private Long startTime,endTime;
    private int spend_time;
    private int count;
    String name;
    final String db_name="testDB";
    final String tb_name="guess_test";
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        Intent play = getIntent();
        name = play.getStringExtra("Name");
        TextView tv_Name = (TextView)findViewById(R.id.textView2);

        tv_Name.setText(name);

        Random rand =new Random();
        int B;

        B = 0;
        do{
            int passwd = rand.nextInt(8854)+1023; //產生隨機數字1023~9876
            p[0] = passwd % 10; //隨機數字的個位數
            p[1] = (passwd % 100)/10; //隨機數字的十位數
            p[2] = (passwd % 1000)/100; //隨機數字的百位數
            p[3] = passwd / 1000; //隨機數字的千位數
            for(int i = 0; i<=3 ; i++){ //看數字是否有重複
                for(int j = 0; j<=3 ; j++)
                    if(p[i]==p[j]&&i!=j)
                        B++;
            }
        }while(B!=0);
        startTime=System.currentTimeMillis();
        count =0;

    }

    public void play(View v)
    {
        count++;
        EditText et = (EditText) findViewById(R.id.editText);
        TextView tv =(TextView) findViewById(R.id.textView);
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());
        int guess;
        int B;
        int A;
        int []g=new int[4];
        guess = Integer.parseInt(et.getText().toString()); //輸入數字
        B = 0;
        g[0] = guess % 10; //輸入數字的個位數
        g[1] = (guess % 100)/10; //輸入數字的十位數
        g[2] = (guess % 1000)/100; //輸入數字的百位數
        g[3] = guess / 1000; //輸入數字的千位數
        for(int i = 0; i<=3 ; i++) { //看數字是否有重複
            for (int j = 0; j <= 3; j++)
                if (g[i] == g[j] && i != j)
                    B++;
        }
        if(B!=0){
            tv.setText(tv.getText()+"please input again.\n");
            et.setText("");
        }
        else {

                A = 0;
            for(int i= 0; i<=3 ; i++){
                if(g[i]==p[i]) //當數字對位子也對，A加1
                    A++;
                for(int j = 0; j<=3 ; j++)
                    if(g[i]==p[j] && i!=j) //當數字對位子不對，B加1
                        B++;
            }
            if(A==4){

                endTime=System.currentTimeMillis();
                spend_time=(int)(endTime-startTime)/1000;
                tv.setText(tv.getText().toString()+et.getText()+"==> get it\n"+"u spend:"+spend_time+"secs\n"+"次數"+count);
                et.setText("");
            }
            else{

                tv.setText(tv.getText().toString()+et.getText()+"-->"+A+"A"+B+"B\n");
                et.setText("");
            }

        }
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
    public void check(View v){
        Intent it = new Intent(this,Main6Activity.class);
        startActivity(it);
        }

    }






