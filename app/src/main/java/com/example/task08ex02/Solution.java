package com.example.task08ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Solution extends AppCompatActivity {
    double x1,x2,a,b,c,root;
    ImageView function;
    TextView x1Disp,x2Disp;
    WebView funcDisp;
    Intent equation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);

        x1Disp=(TextView)findViewById(R.id.x1Display);
        x2Disp=(TextView)findViewById(R.id.x2Display);
        function=(ImageView)findViewById(R.id.function);
        funcDisp=(WebView)findViewById(R.id.funcDisp);

        equation= getIntent();

        a=equation.getDoubleExtra("a",1);
        b=equation.getDoubleExtra("b",1);
        c=equation.getDoubleExtra("c", 1);

        funcDisp.getSettings().setJavaScriptEnabled(true);
        funcDisp.setWebViewClient(new MyWebViewClient());

        Math();
        function();
    }


    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverdriveUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }

    private void Math(){
        root=b*b-4*a*c;
        x1=(-b+(Math.sqrt(root)))/2;
        x2=(-b-(Math.sqrt(root)))/2;
        if(root<0){
            x1Disp.setText("no answer");
            x2Disp.setText("no answer");
        }
        else{
            x1Disp.setText(""+x1);
            x2Disp.setText(""+x2);
        }
    }

    public void function(){
        if(a<0){
            function.setImageResource(R.drawable.sad);
        }
        else{
            function.setImageResource(R.drawable.smiling);
        }
    }

   public void graph(){



    }

    public void goBack(View view) {
        equation.putExtra("ans1",x1);
        equation.putExtra("ans2",x2);
        setResult(RESULT_OK,equation);
        finish();

    }

}