package com.example.pushpitha.constructionhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class circle extends AppCompatActivity {

    private TextView areaAnswer,volAnswer;
    private float radius ,thick , area_answer , volume;
    private EditText r,t;
    private Boolean hasFuture = false;                           // to indicate whether there are future events

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        r = (EditText) findViewById(R.id.txt_radius);
        t = (EditText) findViewById(R.id.txt_thick);
        Button area = ( Button) findViewById(R.id.button_area1);
        Button vol = ( Button) findViewById(R.id.button_volume);
        Button next = ( Button) findViewById(R.id.button_next);
        areaAnswer = (TextView) findViewById(R.id.area_ans);
        volAnswer = (TextView) findViewById(R.id.volume_ans);

        //when area button is pressed
        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    radius = Float.parseFloat(r.getText().toString().trim());
                    System.out.println(radius);
                    area_answer = (float) Math.PI*radius*radius ;
                    hasFuture = true ;
                    areaAnswer.setText(area_answer+"");
                    volAnswer.setText("");
                }catch(Exception e){
                    Toast.makeText(getApplicationContext() ,"R value is not acceptable",Toast.LENGTH_SHORT).show();
                    hasFuture  =false ;
                }
            }
        });

        //when volume button is pressed
        vol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String thick_s = t.getText().toString();
                if(thick_s.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Thickness is needed.",Toast.LENGTH_SHORT).show();
                }
                else{
                    try{
                        thick = Float.parseFloat(thick_s);
                        radius = Float.parseFloat(r.getText().toString().trim());
                        area_answer = (float) Math.PI*radius*radius;
                        volume = thick*area_answer ;
                        volAnswer.setText(volume+"");
                        areaAnswer.setText(area_answer+"");
                        hasFuture = true;
                    }catch(Exception e){
                        Toast.makeText(getApplicationContext(),"Thickness or R is not acceptable.",Toast.LENGTH_SHORT).show();
                        hasFuture = false ;
                    }
                }
            }
        });

        //when next button is pressed
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasFuture){
                    Intent category = new Intent(getApplicationContext(),Category.class);
                    startActivity(category);
                }else{
                    Toast.makeText(getApplicationContext(),"Area or Volume is needed.",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
