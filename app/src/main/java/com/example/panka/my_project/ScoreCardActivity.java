package com.example.panka.my_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreCardActivity extends AppCompatActivity {

     private TextView score;
    private Button btn5;
    public  void  playagain(View view)
    {
        Intent intent2=new Intent(getApplicationContext(),PAGE_2.class);
         startActivity(intent2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);
        String scoreed=getIntent().getStringExtra("score");
        String totalquestion=getIntent().getStringExtra("totalquestion");
        System.out.println(scoreed+" "+ totalquestion);



    }
}
