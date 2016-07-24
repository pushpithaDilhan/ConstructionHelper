package com.example.pushpitha.constructionhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Choose_the_Shape extends AppCompatActivity {

    ImageButton circle;
    ImageButton rectangle;
    ImageButton parallelogram;
    ImageButton bulletshape;
    ImageButton oval;
    ImageButton houseshape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_the__shape);
        circle = (ImageButton) findViewById(R.id.circle);
        rectangle = (ImageButton) findViewById(R.id.rectangle);
        parallelogram = (ImageButton) findViewById(R.id.parallelogram);
        bulletshape = (ImageButton) findViewById(R.id.bulletshape);
        oval = (ImageButton) findViewById(R.id.oval);
        houseshape = (ImageButton) findViewById(R.id.houseshape);
        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Clicked");
                if(v.getId()==R.id.circle){
                    Intent circle_next = new Intent(getApplicationContext(),circle.class);
                    startActivity(circle_next);
                }
            }
        });
    }


}
