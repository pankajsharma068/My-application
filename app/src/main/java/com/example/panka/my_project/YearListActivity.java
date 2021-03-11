package com.example.panka.my_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class YearListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        ListView listview1=(ListView)findViewById(R.id.listview1);
     final   String name = getIntent().getStringExtra("name");
        System.out.println(name);
      final  ArrayList<String> yearList=new ArrayList<String>();
        final ArrayList<String> sublist=new ArrayList<>();



        switch (name) {
            case "Nimcet":
                yearList.add("Nimcet Syllabus");
                yearList.add("Nimcet 2020 Paper");
                yearList.add("Nimcet 2019 Paper");
                yearList.add("Nimcet 2018 Paper");
                yearList.add("Nimcet 2017 Paper");
                yearList.add("Nimcet 2016 Paper");
                yearList.add("Nimcet 2015 Paper");
                yearList.add("Nimcet 2014 Paper");
                yearList.add("Nimcet 2013 Paper");
                yearList.add("Nimcet 2012 Paper");
                yearList.add("Nimcet 2011 Paper");
                yearList.add("Nimcet 2010 Paper");
                yearList.add("Nimcet 2009 Paper");
                yearList.add("Nimcet 2008 Paper");
                yearList.add("Nimcet 2007 Paper");

                break;
            case "BHU":
                yearList.add("Syllabus");
                yearList.add("2020");
                yearList.add("2019");
                yearList.add("2018");
                yearList.add("2017");
                yearList.add("2016");
                yearList.add("2015");
                yearList.add("2014");
                break;
            case "JNU":
                yearList.add("Syllabus");
                yearList.add("2020");
                yearList.add("2019");
                yearList.add("2018");
                yearList.add("2017");
                yearList.add("2016");
                yearList.add("2015");
                yearList.add("2014");
                break;
            case "DU":
                yearList.add("Syllabus");
                yearList.add("2020");
                yearList.add("2019");
                yearList.add("2018");
                yearList.add("2017");
                yearList.add("2016");
                yearList.add("2015");
                yearList.add("2014");
                break;
            case "CETMAH":
                yearList.add("Syllabus");
                yearList.add("2020");
                yearList.add("2019");
                yearList.add("2018");
                yearList.add("2017");
                yearList.add("2016");
                yearList.add("2015");
                yearList.add("2014");
                break;
            case "Quiz":
                yearList.add("Math Quiz");
                yearList.add("Computer Quiz");
                yearList.add("English Quiz");
                yearList.add("Resoning Quiz");

                break;

        }
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,yearList);
        listview1.setAdapter(arrayAdapter);
        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (name.equals("Quiz")) {
                    Intent intent1=new Intent(getApplicationContext(),QuizActivity.class);
                   intent1.putExtra("name",name);
                    intent1.putExtra("year",yearList.get(i));
                    startActivity(intent1);
                } else {
                    Intent intent=new Intent(getApplicationContext(),PdfViewerActivity.class);
                    intent.putExtra("name",name);
                    intent.putExtra("year",yearList.get(i));
                    startActivity(intent);
                }
            }
        });
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
