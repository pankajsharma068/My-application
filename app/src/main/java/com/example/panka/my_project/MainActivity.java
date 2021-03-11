package com.example.panka.my_project;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

   /* public void gonext(View view)
    {
        Intent intent=new Intent(getApplicationContext(),PAGE_2.class);
        startActivity(intent);
    }
    public void login(View view)
    {
        Intent intent=new Intent(getApplicationContext(),LoginPageActivity.class);
        startActivity(intent);
    }
    */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(getApplicationContext(), PAGE_2.class);
                startActivity(i);
                //finish();
            }
        }, 2000);


    }
}
