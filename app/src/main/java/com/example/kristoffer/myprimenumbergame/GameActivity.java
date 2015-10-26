package com.example.kristoffer.myprimenumbergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    public static final int LIMIT = 999;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ArrayList<Integer> list;
        list = loadList(getIntent().getIntExtra("level", 3));

        TextView currentScore = (TextView)findViewById(R.id.score);
        currentScore.setText("0");
        int index = new Random().nextInt(list.size());
        TextView number = (TextView)findViewById(R.id.numGen);
        number.setText((list.get(index+1)).toString());
    }

    public boolean checkPrime(Integer toCheck){
        for(Integer i=2;i<=toCheck/2;i++){
            if(toCheck%i==0){
                return false;
            }
        }
        return true;
    }

    public void selectPrime(View view){
        TextView score = (TextView)findViewById(R.id.score);
        TextView number = (TextView)findViewById(R.id.numGen);
        Integer gen = Integer.parseInt(number.getText().toString());
        Integer sc = Integer.parseInt(score.getText().toString());
        boolean isRight = checkPrime(gen);

        if(isRight){        //the number is prime
            sc++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        }
        else{
            sc-=5;
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
        }
        ArrayList<Integer> list;
        list = loadList(getIntent().getIntExtra("level", 3));
        int index = new Random().nextInt(list.size());
        number.setText((list.get(index+1)).toString());
        score.setText(sc.toString());
    }

    public void selectComposite(View view){
        TextView score = (TextView)findViewById(R.id.score);
        TextView number = (TextView)findViewById(R.id.numGen);
        Integer gen = Integer.parseInt(number.getText().toString());
        Integer sc = Integer.parseInt(score.getText().toString());
        boolean isRight = checkPrime(gen);

        if(!isRight){       //the number is composite
            sc++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        }
        else{
            sc-=5;
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
        }

        ArrayList<Integer> list;
        list = loadList(getIntent().getIntExtra("level", 3));
        int index = new Random().nextInt(list.size());
        number.setText((list.get(index+1)).toString());
        score.setText(sc.toString());
    }

    private ArrayList loadList(int level){
        ArrayList<Integer> values = new ArrayList<>();
        switch (level){
            case 0:     //for easy
                for(int i=0;i<=LIMIT;i++){
                    values.add(i);
                }
                break;
            case 1:     //for medium
                for(int i=0;i<=LIMIT;i++){
                    if(i%2==0) {
                        //Does not add factors of 2 to the list
                    }
                    else {
                        values.add(i);
                    }
                }
                break;
            case 2:     //for hard
                for(int i=0;i<=LIMIT;i++){
                    if(i%2==0||i%5==0) {
                        //Does not add factors of 2 AND 5 to the list
                    }
                    else {
                        values.add(i);
                    }
                }
                break;
            default:
                Toast.makeText(this, "Error Identifying the difficulty!", Toast.LENGTH_SHORT).show();
                break;
        }
        return values;
    }
}
