package com.example.panka.my_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginPageActivity extends AppCompatActivity {


    public void gonext1(View view)
    {
        Intent intent=new Intent(getApplicationContext(),PAGE_2.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
    }
}
