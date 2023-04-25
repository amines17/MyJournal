package com.example.journal;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journal.Models.NewsApiResponse;
import com.example.journal.Models.NewsHeadlines;

import java.util.List;


public class MainActivity extends AppCompatActivity implements SelectListener, View.OnClickListener{

    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog dialog;
    Button b1,b2,b3,b4,b5,b6,b7,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16;
    SearchView searchView;

    String cat = "";
    String coun = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search_view);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Fetching news articles of " + query);
                dialog.show();
                RequestManager manager = new RequestManager(MainActivity.this);
                manager.getNewsHeadlines(listener,"fr", "general", query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        dialog = new ProgressDialog(this);
        dialog.setTitle("Fetcching news articles..");
        dialog.show();

        b1 = findViewById(R.id.btn_1);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.btn_2);
        b2.setOnClickListener(this);
        b3 = findViewById(R.id.btn_3);
        b3.setOnClickListener(this);
        b4 = findViewById(R.id.btn_4);
        b4.setOnClickListener(this);
        b5 = findViewById(R.id.btn_5);
        b5.setOnClickListener(this);
        b6 = findViewById(R.id.btn_6);
        b6.setOnClickListener(this);
        b7 = findViewById(R.id.btn_7);
        b7.setOnClickListener(this);


        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(this);
        btn10 = findViewById(R.id.btn10);
        btn10.setOnClickListener(this);
        btn11 = findViewById(R.id.btn11);
        btn11.setOnClickListener(this);
        btn12 = findViewById(R.id.btn12);
        btn12.setOnClickListener(this);
        btn13 = findViewById(R.id.btn13);
        btn13.setOnClickListener(this);
        btn14 = findViewById(R.id.btn14);
        btn14.setOnClickListener(this);
        btn15 = findViewById(R.id.btn15);
        btn15.setOnClickListener(this);
        btn16 = findViewById(R.id.btn16);
        btn16.setOnClickListener(this);

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener,"fr",  "general", null);

    }

    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {
            if(list.isEmpty()) {
                Toast.makeText(MainActivity.this, "No data found !!", Toast.LENGTH_SHORT).show();
            } else {
                showNews(list);
                dialog.dismiss();
            }

        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this, "An error occured !!", Toast.LENGTH_SHORT).show();
        }
    };

    private void showNews(List<NewsHeadlines> list) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new CustomAdapter(this, list, this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void OnNewsClicked(NewsHeadlines headlines) {
        startActivity(new Intent(MainActivity.this, DetailsActivity.class)
        .putExtra("data", headlines));
    }

  public void onClick(View v) {

      switch (v.getId()) {
          case  R.id.btn_1: {
              Button button = (Button) v;
              String category = button.getText().toString();
              cat = category;
              dialog.setTitle("Fetching news articles of" + category);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener,coun,cat, null);
              break;
          }

          case R.id.btn_3: {
              Button button = (Button) v;
              String category = button.getText().toString();
              cat = category;
              dialog.setTitle("Fetching news articles of" + category);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener,coun,cat, null);
              break;
          }

          case R.id.btn_4: {
              Button button = (Button) v;
              String category = button.getText().toString();
              cat = category;
              dialog.setTitle("Fetching news articles of" + category);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener, coun,cat, null);
              break;
          }

          case R.id.btn_5: {
              Button button = (Button) v;
              String category = button.getText().toString();
              cat = category;
              dialog.setTitle("Fetching news articles of" + category);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener,coun,cat, null);
              break;
          }

          case R.id.btn_6: {
              Button button = (Button) v;
              String category = button.getText().toString();
              cat = category;
              dialog.setTitle("Fetching news articles of" + category);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener,coun,cat, null);
              break;
          }

          case R.id.btn_2: {
              Button button = (Button) v;
              String category = button.getText().toString();
              cat = category;
              dialog.setTitle("Fetching news articles of" + category);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener,coun,cat, null);
              break;
          }

          case R.id.btn1: {
              Button button = (Button) v;
              String country = button.getText().toString();
              coun = country;
              dialog.setTitle("Fetching news articles of" + country);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener, coun,cat, null);
              break;
          }


          case R.id.btn2: {
              Button button = (Button) v;
              String country = button.getText().toString();
              coun = country;
              dialog.setTitle("Fetching news articles of" + country);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener, coun,cat, null);
              break;
          }

          case R.id.btn3: {
              Button button = (Button) v;
              String country = button.getText().toString();
              coun = country;
              dialog.setTitle("Fetching news articles of" + country);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener, coun,cat, null);
              break;
          }


          case R.id.btn4: {
              Button button = (Button) v;
              String country = button.getText().toString();
              coun = country;
              dialog.setTitle("Fetching news articles of" + country);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener, coun,cat, null);
              break;
          }

          case R.id.btn5: {
              Button button = (Button) v;
              String country = button.getText().toString();
              coun = country;
              dialog.setTitle("Fetching news articles of" + country);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener, coun,cat, null);
              break;
          }


          case R.id.btn6: {
              Button button = (Button) v;
              String country = button.getText().toString();
              coun = country;
              dialog.setTitle("Fetching news articles of" + country);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener, coun,cat, null);
              break;
          }

          case R.id.btn7: {
              Button button = (Button) v;
              String country = button.getText().toString();
              coun = country;
              dialog.setTitle("Fetching news articles of" + country);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener, coun,cat, null);
              break;
          }


          case R.id.btn8: {
              Button button = (Button) v;
              String country = button.getText().toString();
              coun = country;
              dialog.setTitle("Fetching news articles of" + country);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener, coun,cat, null);
              break;
          }

          case R.id.btn9: {
              Button button = (Button) v;
              String country = button.getText().toString();
              coun = country;
              dialog.setTitle("Fetching news articles of" + country);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener, coun,cat, null);
              break;
          }


          case R.id.btn10: {
              Button button = (Button) v;
              String country = button.getText().toString();
              coun = country;
              dialog.setTitle("Fetching news articles of" + country);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener, coun,cat, null);
              break;
          }

          case R.id.btn11: {
              Button button = (Button) v;
              String country = button.getText().toString();
              coun = country;
              dialog.setTitle("Fetching news articles of" + country);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener, coun,cat, null);
              break;
          }


          case R.id.btn12: {
              Button button = (Button) v;
              String country = button.getText().toString();
              coun = country;
              dialog.setTitle("Fetching news articles of" + country);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener, coun,cat, null);
              break;
          }

          case R.id.btn13: {
              Button button = (Button) v;
              String country = button.getText().toString();
              coun = country;
              dialog.setTitle("Fetching news articles of" + country);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener, coun,cat, null);
              break;
          }


          case R.id.btn14: {
              Button button = (Button) v;
              String country = button.getText().toString();
              coun = country;
              dialog.setTitle("Fetching news articles of" + country);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener, coun,cat, null);
              break;
          }

          case R.id.btn15: {
              Button button = (Button) v;
              String country = button.getText().toString();
              coun = country;
              dialog.setTitle("Fetching news articles of" + country);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener, coun,cat, null);
              break;
          }


          case R.id.btn16: {
              Button button = (Button) v;
              String country = button.getText().toString();
              coun = country;
              dialog.setTitle("Fetching news articles of" + country);
              dialog.show();
              RequestManager manager = new RequestManager(this);
              manager.getNewsHeadlines(listener, coun,cat, null);
              break;
          }
      }
  }
}