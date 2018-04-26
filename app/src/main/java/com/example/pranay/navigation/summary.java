package com.example.pranay.navigation;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.view.MenuItem;



public class summary extends AppCompatActivity {


    String summary,links,headlines;
    TextView sum,link,headline;
    Button b1;
    //ScrollView sc;
    //    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        ActionBar actionBar = getSupportActionBar(); //back arrow for going back to main activity.
        actionBar.setDisplayHomeAsUpEnabled(true);

//        @Override
//        public boolean onOptionsItemSelected(MenuItem item) {
//            switch (item.getItemId()) {
//                case android.R.id.home:
//                    onBackPressed();
//                    return true;
//            }
//
//            return super.onOptionsItemSelected(item);
//        }

//        //Get a reference to your WebView//
//        WebView webView = (WebView) findViewById(R.id.webview);
//
//        //Specify the URL you want to display//
//        webView.loadUrl("https://www.google.com");

        sum=(TextView)findViewById(R.id.tv_sum);
        link=(TextView)findViewById(R.id.tv_link);
        headline=(TextView)findViewById(R.id.tv_head);
       // b1=(Button)findViewById(R.id.b_share);

        sum.setMovementMethod(new ScrollingMovementMethod());


       // sc=(ScrollView)findViewById(R.id.scv);

        try{
            headlines=getIntent().getExtras().getString("headlines");
            summary=getIntent().getExtras().getString("summary");
            links=getIntent().getExtras().getString("links");
            //Log.i("pranay","link"+linkkk);
        }
        catch (Exception e)
        {
            Log.d("","");
        }
        headline.setText(headlines);
        sum.setText(summary);
        link.setText(links);
    }



}
