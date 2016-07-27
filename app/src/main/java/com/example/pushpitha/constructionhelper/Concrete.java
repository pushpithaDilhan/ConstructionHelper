package com.example.pushpitha.constructionhelper;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Concrete extends AppCompatActivity {

    TextView vol_forward ,c_out ,s_out,m_out ;
    float volumef,cr,sr,mr , rtotal;
    float ca,sa,ma ;                                 // amounts
    EditText c_in,s_in,m_in;
    Button calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concrete);
        Intent past = getIntent();
        volumef  = past.getFloatExtra("volume",0);
        vol_forward = (TextView) findViewById(R.id.textView_vol);
        vol_forward.setText(Float.toString(volumef));

        c_in = (EditText) findViewById(R.id.txt_cr);
        s_in = (EditText) findViewById(R.id.txt_sr);
        m_in = (EditText) findViewById(R.id.txt_mr);

        calc = (Button) findViewById(R.id.button_calc);

        c_out = (TextView) findViewById(R.id.view_cement);
        s_out = (TextView) findViewById(R.id.view_sand);
        m_out = (TextView) findViewById(R.id.view_metal);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cr = Float.parseFloat(c_in.getText().toString());
                    sr = Float.parseFloat(s_in.getText().toString());
                    mr = Float.parseFloat(m_in.getText().toString());
                    rtotal = cr + sr + mr;
                    ca = cr * volumef / rtotal;
                    sa = sr * volumef / rtotal;
                    ma = mr * volumef / rtotal;
                    c_out.setText(Float.toString(ca));
                    s_out.setText(Float.toString(sa));
                    m_out.setText(Float.toString(ma));
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"ratios are not valid",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
