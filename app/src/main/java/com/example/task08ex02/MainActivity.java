package com.example.task08ex02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
public class MainActivity extends AppCompatActivity {
    EditText aCoef,bCoef,cCoef;
    TextView sol1,sol2;
    double a,b,c;
    String coef;
    Random rnd=new Random();
    double ans1,ans2;


    @Override
    protected void onActivityResult(int source, int good, @Nullable Intent data_back) {
        super.onActivityResult(source, good, data_back);
        if(data_back != null){
            ans1=data_back.getDoubleExtra("ansX1",1);
            ans2=data_back.getDoubleExtra("ansX2",1);
        }
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sol1=(TextView) findViewById(R.id.sol1);
        sol2=(TextView) findViewById(R.id.sol2);
        aCoef=(EditText) findViewById(R.id.aCoff);
        bCoef=(EditText) findViewById(R.id.bCoff);
        cCoef=(EditText)findViewById(R.id.cCoff);

        sol1.setText("x1= "+ans1);
        sol2.setText("x2= "+ans2);
    }


    public void Submit1(View view) {
        coef=aCoef.getText().toString();
        if(coef.equals("")){
            Toast.makeText(this,"must enter a coefficient",Toast.LENGTH_SHORT).show();
        }
        else{
            a=Double.parseDouble(coef);
        }
    }

    public void Submit2(View view) {
        coef=bCoef.getText().toString();
        if(coef.equals("")){
            Toast.makeText(this,"must enter a coefficient, else press Random", Toast.LENGTH_SHORT).show();
        }
        else{
            b=Double.parseDouble(coef);
        }
    }

    public void Submit3(View view) {
        coef=cCoef.getText().toString();
        if(coef.equals("")){
            Toast.makeText(this,"must enter a coefficient, else press Random", Toast.LENGTH_SHORT).show();
        }
        else{
            c=Double.parseDouble(coef);
        }
    }

    public void RandomSelect(View view) {
        a=rnd.nextInt(100);
        b=rnd.nextInt(100);
        c=rnd.nextInt(100);
        aCoef.setText(String.valueOf(a));
        bCoef.setText(String.valueOf(b));
        cCoef.setText(String.valueOf(c));
    }

    public void MoveToActivity(View view) {
        Intent eq=new Intent(this, Solution.class);
        eq.putExtra("a",a);
        eq.putExtra("b",b);
        eq.putExtra("c",c);
        startActivityForResult(eq,1);

    }
}