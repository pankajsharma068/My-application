package com.example.panka.my_project;

import android.animation.Animator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {




private TextView question,numindicator;
    private LinearLayout optioncontainer;
    private Button next;
    private int count=0;
  private List<QuestionModel> list;
  private int position=0;
    private int score=0;
 // TextView textView;
    //pageno = 0
    //question [1, 20]
    // ans map<pageno, list<String>>
    // correct ans map<pageno, ansno>
    // correct count = 0
    //response map<pageno, ansno>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
       question=(TextView)findViewById(R.id.question);
        numindicator=(TextView)findViewById(R.id.numindecator);
        optioncontainer=(LinearLayout) findViewById(R.id.optioncontainer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        final   String year = getIntent().getStringExtra("year");
        System.out.println(year);
        next=(Button) findViewById(R.id.next);
         list=new ArrayList<>();
       /* list.add(new QuestionModel("The smallest integer that can be represented by an 8 bit number in 2’s complement form is ", "pqnkqj", "qqqq", "qqqq", "qqqq", "pqnkqj"));
        list.add(new QuestionModel("math", "qqq", "qqqq", "a", "a", "qqqq"));
        list.add(new QuestionModel("math", "a", "a", "a", "a", "b"));
        list.add(new QuestionModel("math", "a", "a", "a", "a", "b"));
        list.add(new QuestionModel("math", "a", "a", "a", "a", "b"));
        list.add(new QuestionModel("math", "a", "a", "a", "a", "b"));
        list.add(new QuestionModel("math", "a", "a", "a", "a", "b")); */
         switch (year) {
             case "Math Quiz": {

                 list.add(new QuestionModel("  ","qqq", "qqqq", "a", "a", "b"));
                 list.add(new QuestionModel("math", "a", "a", "a", "a", "b"));
                 list.add(new QuestionModel("math", "a", "a", "a", "a", "b"));
                 list.add(new QuestionModel("math", "a", "a", "a", "a", "b"));
                 list.add(new QuestionModel("math", "a", "a", "a", "a", "b"));
                 list.add(new QuestionModel("math", "a", "a", "a", "a", "b"));

                 break;
             }
             case "Reasoning Quiz": {
                 list.add(new QuestionModel("Reasoning Question ","pqnkqj", "qqqq", "qqqq", "qqqq", "b"));
                 list.add(new QuestionModel("math", "qqq", "qqqq", "a", "a", "b"));
                 list.add(new QuestionModel("math", "a", "a", "a", "a", "b"));
                 list.add(new QuestionModel("math", "a", "a", "a", "a", "b"));
                 list.add(new QuestionModel("math", "a", "a", "a", "a", "b"));
                 list.add(new QuestionModel("math", "a", "a", "a", "a", "b"));
                 list.add(new QuestionModel("math", "a", "a", "a", "a", "b"));

                 break;
             }
             case "Computer Quiz": {
                 list.add(new QuestionModel("The smallest integer that can be represented by an 8 bit number in 2’s complement form is\n", "-256", "-128", "127", "255", "-128"));
                 list.add(new QuestionModel(". Consider the equation ( \uF03D (132) in some bases x and y . Then a possible set of values of x and y\n" +
                         "are\n", "qqq", "qqqq", "a", "a", "b"));
                 list.add(new QuestionModel("Let the memory access time is 10 milliseconds and cache hit ratio 15 % .The effective memory access time is \n", "2 milli second", "15.5 milli second", "18.5 micro second", "18.5 milli second", "18.5 milli second "));
                 list.add(new QuestionModel("math", "a", "a", "as", "c", "as"));
                 list.add(new QuestionModel("math", "a", "a", "a", "b", "b"));
                 list.add(new QuestionModel("math", "a", "a", "b", "a", "b"));
                 list.add(new QuestionModel("math", "a", "b", "a", "a", "b"));

                 break;
             }
             case "English Quiz": {
                 list.add(new QuestionModel(". The smallest integer that can be represented by an 8-\n" +
                         "bit number in 2’s complement form is\n", "pqnkqj", "qqqq", "qqqq", "qqqq", "b"));
                 list.add(new QuestionModel("math", "qqq", "qqqq", "a", "a", "b"));
                 list.add(new QuestionModel("math", "a", "a", "a", "a", "b"));
                 list.add(new QuestionModel("math", "a", "a", "a", "a", "b"));
                 list.add(new QuestionModel("math", "a", "a", "a", "a", "b"));
                 list.add(new QuestionModel("math", "a", "a", "a", "a", "b"));
                 list.add(new QuestionModel("math", "a", "a", "a", "a", "b"));

                 break;
             }
                 default:
                 {
                     break;
                 }

         }

        for(int j=0;j<4;j++)
        {
            optioncontainer.getChildAt(j).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer((Button)v);
                }
            });

        }

        playanimation(question,0,list.get(position).getQuestion());
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               next.setEnabled(false);
                enableoption(true);
                next.setAlpha(0.7f);
                position++;
                if(position==list.size()-1)
                {
                    Log.i("Reason","Last Question");
                    Intent intent=new Intent(getApplicationContext(),ScoreCardActivity.class);
                      intent.putExtra("score",score);
                       intent.putExtra("totalquestion",list.size());
                    startActivity(intent);
                }
                count=0;

                playanimation(question,0,list.get(position).getQuestion());
            }
        });
    }

    private void playanimation(final View view,final int value,final String data)
    {

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100).setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

                if(value==0 && count<4)
                {
                    String option="";
                    if (count==0)
                    {
                            option=list.get(position).getOptionA();
                            //option=list.set(position).setOptionA();

                    }else if(count==1){
                        option=list.get(position).getOptionB();
                    }else if(count==2)
                    {
                        option=list.get(position).getOptionC();
                    }else if(count==3)
                    {
                        option=list.get(position).getOptionD();

                    }
                    playanimation(optioncontainer.getChildAt(count),0,option);
                    count++;
                    System.out.println(count +"-"+position+" "+ option);
                }

            }

            @Override
            public void onAnimationEnd(Animator animator) {
               if(value==0)
               {
                   try{

                       ((TextView) view).setText(data);
                       numindicator.setText(position+1+"/"+list.size());
                   }
                   catch (ClassCastException ex)
                   {
                       ((Button) view).setText(data);
                   }
                   view.setTag(data);
                   playanimation(view,1,data);
               }
            }


            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    private void checkAnswer(Button selectedOption)
    {
      enableoption(false);
        next.setEnabled(true);
        next.setAlpha(1);
        System.out.println(list.get(position).getCorrectAns()+", "+ selectedOption.getText().toString());
        if(selectedOption.getText().toString().equals(list.get(position).getCorrectAns()))
        {
            score++;
            //correct
            selectedOption.setBackground(getDrawable(R.drawable.optionbut_correctans));
        }
        else
        {
            selectedOption.setBackground(getDrawable(R.drawable.optionbut_wrongans));
            String correctAns = list.get(position).getCorrectAns();
            int index = 0;
            if (correctAns.equals(list.get(position).getOptionA()))
            {
               index = 0;

            }else if(correctAns.equals(list.get(position).getOptionB())){
                index = 1;
            }else if(correctAns.equals(list.get(position).getOptionC()))
            {
                index = 2;
            }else if(correctAns.equals(list.get(position).getOptionD()))
            {
                index = 3;
            }

           //Button correctoption=(Button) optioncontainer.findViewWithTag(list.get(position).getCorrectAns());
            optioncontainer.getChildAt(index).setBackground(getDrawable(R.drawable.optionbut_correctans));
           //correctoption.setBackground(getDrawable(R.drawable.optionbut_correctans));
            //incorrect
        }
        //to show right option to user


    }
    private void enableoption(boolean enable)
    {
        for(int i=0;i<4;i++)
        {
            optioncontainer.getChildAt(i).setEnabled(enable);
            if(enable)
            {
                //optioncontainer.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
                optioncontainer.getChildAt(i).setBackground(getDrawable(R.drawable.optionbut));
            }
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
