package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main7Activity extends AppCompatActivity {
    final String db_name="testDB2";
    final String tb_name="guess_test2";
    SQLiteDatabase db;
    private void addData(String name, String count, String time){
        ContentValues cv = new ContentValues(3);
        cv.put("name",name);
        cv.put("count",count);
        cv.put("time",time);
        db.insert(tb_name,null,cv);
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM " + tb_name + " ORDER BY time DESC", null);
        if (c.getCount() == 0) {
            addData("Agust", "2", "3");
            c = db.rawQuery("SELECT * FROM " + tb_name, null);
        }
        if (c.moveToFirst()) {
            String str = "總共有" + c.getCount() + "筆資料\n";
            str += "--------\n";
            do {
                str += "id:" + c.getString(0) + "\n";
                str += "name:" + c.getString(1) + "\n";
                str += "count:" + c.getString(2) + "\n";
                str += "time:" + c.getString(3) + "\n";
                str += "-------\n";
            } while (c.moveToNext());
            TextView txv = (TextView) findViewById(R.id.textView6);
            txv.setMovementMethod(ScrollingMovementMethod.getInstance());
            txv.setText(str);

        }
    }
    public void update(View v){
        ContentValues cv = new ContentValues(3);
        int idno;
        EditText DL = (EditText) findViewById(R.id.editText);
        idno = Integer.parseInt(DL.getText().toString());
        EditText Tname = (EditText)findViewById(R.id.editText2);
        EditText Tcount = (EditText)findViewById(R.id.editText3);
        EditText Ttime = (EditText)findViewById(R.id.editText4);
        cv.put("name",Tname.getText().toString());
        cv.put("count",Tcount.getText().toString());
        cv.put("time",Ttime.getText().toString());
        db.update(tb_name,cv,"_id="+idno,null);

    }
    public  void delete(View v){
        int idno;
        EditText DL = (EditText) findViewById(R.id.editText);
        idno = Integer.parseInt(DL.getText().toString());
        db.delete(tb_name,"_id="+idno,null);
    }
    public void back(View v){
        finish();
    }
}