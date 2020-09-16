package com.example.task08ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText aCoff,bCoff,cCoff;
    double a,b,c;
    String coff;
    Random rnd=new Random();
    int sym=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aCoff=(EditText)findViewById(R.id.aCoff);
        bCoff=(EditText)findViewById(R.id.bCoff);
        cCoff=(EditText)findViewById(R.id.cCoff);
    }

    public void Submit1(View view) {
        coff=aCoff.getText().toString();
        if(coff.equals("")){
            Toast.makeText(this,"must enter a coefficient",Toast.LENGTH_SHORT).show();
        }
        else{
            a=Double.parseDouble(coff);
        }
    }

    public void Submit2(View view) {
        coff=bCoff.getText().toString();
        if(coff.equals("")){
            Toast.makeText(this,"must enter a coefficient, else press Random", Toast.LENGTH_SHORT).show();
        }
        else{
            b=Double.parseDouble(coff);
        }
    }

    public void Submit3(View view) {
        coff=cCoff.getText().toString();
        if(coff.equals("")){
            Toast.makeText(this,"must enter a coefficient, else press Random", Toast.LENGTH_SHORT).show();
        }
        else{
            c=Double.parseDouble(coff);
        }
    }

    public void RandomSelect(View view) {
        sym=1;
        a=rnd.nextInt(100);
        b=rnd.nextInt(100);
        c=rnd.nextInt(100);
    }

    public void MoveToActivity(View view) {

    }
}