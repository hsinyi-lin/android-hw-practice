package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Go2View2(View v){
        Intent it = new Intent(this,Main2Activity.class);
        startActivity(it);
    }
    public void Go2View3(View v){
        Intent it = new Intent(this,Main3Activity.class);
        startActivity(it);
    }
    public void Go2View4(View v){
        EditText edit = (EditText) findViewById(R.id.editText3);
        Intent it = new Intent(this,Main4Activity.class);
        it.putExtra("Name",edit.getText().toString());
        startActivity(it);
    }
    public void Go2View5(View v){
        EditText edit = (EditText) findViewById(R.id.editText3);
        Intent it = new Intent(this,Main5Activity.class);
        it.putExtra("Name",edit.getText().toString());
        startActivity(it);
    }

}
