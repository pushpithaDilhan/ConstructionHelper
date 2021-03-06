package com.example.pushpitha.constructionhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Choose_the_Shape extends AppCompatActivity {

    private ImageButton circle;
    private ImageButton rectangle;
    private ImageButton parallelogram;
    private ImageButton bulletshape;
    private ImageButton oval;
    private ImageButton houseshape;

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
                    Intent circle_next = new Intent(getApplicationContext(),circle.class);
                    startActivity(circle_next);
            }
        });

        rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rect_next = new Intent(getApplicationContext(),rect.class);
                startActivity(rect_next);
            }
        });

        parallelogram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent para_next = new Intent(getApplicationContext(),CommonActivity.class);
                para_next.putExtra("shape","parallelogram");
                startActivity(para_next);
            }
        });

        bulletshape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bullet_next = new Intent(getApplicationContext(),CommonActivity.class);
                bullet_next.putExtra("shape","bulletshape");
                startActivity(bullet_next);
            }
        });

        oval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oval_next = new Intent(getApplicationContext(),CommonActivity.class);
                oval_next.putExtra("shape","oval");
                startActivity(oval_next);
            }
        });

        houseshape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home_next = new Intent(getApplicationContext(),Homeshape.class);
                startActivity(home_next);
            }
        });
    }


}
