package com.example.kristoffer.myprimenumbergame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] difficulty = {
            "Easy",
            "Medium",
            "Hard",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.reyes_list, difficulty);
        ListView list = (ListView) findViewById(R.id.difficulty_list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent (MainActivity.this, GameActivity.class);
                i.putExtra("level", position);
                startActivity(i);
            }
        });
    }
}
