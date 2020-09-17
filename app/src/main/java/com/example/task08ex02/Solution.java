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
        graph();
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
            x1Disp.setText("x1= "+x1);
            x2Disp.setText("x2= "+x2);
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
        String sa=String.valueOf(a);
        String sb=String.valueOf(b);
        String sc=String.valueOf(c);
        funcDisp.loadUrl("https://www.google.com/search?safe=strict&sxsrf=ALeKk00NWRRMg_4jEa4KETb_3QMVcF8HLQ%3A1600334628838&ei=JCtjX-jWMsaE1fAP4bewgAc&q="+a+"x%5E2%2B"+b+"x%2B"+c+"&oq="+a+"x%5E2%2B"+b+"x%2B"+c+"&gs_lcp=CgZwc3ktYWIQAzIICAAQBxAeEBMyCAgAEAcQHhATMggIABAHEB4QEzIICAAQBxAeEBMyCAgAEAcQHhATMggIABAHEB4QEzIICAAQBxAeEBMyBAgAEBMyBAgAEBMyBAgAEBM6BAgAEEdQ0x5Y0x5gryhoAHACeACAAasBiAGrAZIBAzAuMZgBAKABAaoBB2d3cy13aXrIAQbAAQE&sclient=psy-ab&ved=0ahUKEwjo-MqI7-_rAhVGQhUIHeEbDHAQ4dUDCA0&uact=5");
    }

    public void goBack(View view) {
        equation.putExtra("ansX1",x1);
        equation.putExtra("ansX2",x2);
        setResult(RESULT_OK,equation);
        finish();
    }

}