package com.example.pushpitha.constructionhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Painting extends AppCompatActivity {

    float area,sq_ltr,litres;
    EditText area_txt,sqltr,txt_costlt;
    Button calc,cost_calc;
    TextView txtvw_l , txtvw_c ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painting);
        Intent past = getIntent() ;
        area = past.getFloatExtra("area",0);
        area_txt=(EditText) findViewById(R.id.txt_area);
        area_txt.setText(Float.toString(area));
        txtvw_l = (TextView) findViewById(R.id.txtvw_litres);
        txtvw_c = (TextView) findViewById(R.id.txtvw_cost);

        cost_calc = (Button) findViewById(R.id.button_cost);
        txt_costlt = (EditText) findViewById(R.id.txt_costlt);
        sqltr = (EditText) findViewById(R.id.txt_sqlt);
        calc = (Button) findViewById(R.id.button_calc);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                area = Float.parseFloat(area_txt.getText().toString()) ;
                sq_ltr = Float.parseFloat(sqltr.getText().toString()) ;
                txtvw_l.setText(Float.toString(litres = area/sq_ltr));
            }
        });

        cost_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtvw_c.setText(Float.toString(Float.parseFloat(txt_costlt.getText().toString())*litres)) ;
            }
        });



    }
}
