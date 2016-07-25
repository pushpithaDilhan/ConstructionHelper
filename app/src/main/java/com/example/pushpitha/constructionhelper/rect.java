package com.example.pushpitha.constructionhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class rect extends AppCompatActivity {

    private TextView area_ans,volume_ans;
    private float m=0,n=0,t=0,area,volume;
    private EditText m_edt,n_edt,t_edt;               // edit text fields
    private Button areabtn,volbtn,nextbtn ;
    private Boolean hasFuture = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rect);

        m_edt = (EditText) findViewById(R.id.editText_m);
        n_edt = (EditText) findViewById(R.id.editText_n);
        t_edt = (EditText) findViewById(R.id.editText_t);

        area_ans = (TextView) findViewById(R.id.textView_area);
        volume_ans = (TextView) findViewById(R.id.textView_volume);

        areabtn = (Button) findViewById(R.id.button_area1);
        volbtn = (Button) findViewById(R.id.button_vol1);
        nextbtn = (Button) findViewById(R.id.button_next1);

        areabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    m = Float.parseFloat(m_edt.getText().toString());
                    n = Float.parseFloat(n_edt.getText().toString());
                    area = m * n;
                    hasFuture = true ;
                    area_ans.setText(area + "");
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"m or n value is not valid",Toast.LENGTH_SHORT).show();
                    area_ans.setText("");
                    hasFuture = false ;
                }
            }
        });

        volbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    m = Float.parseFloat(m_edt.getText().toString());
                    n = Float.parseFloat(n_edt.getText().toString());
                    t = Float.parseFloat(t_edt.getText().toString());
                    area = m * n;
                    volume = t*area ;
                    hasFuture = true ;
                    area_ans.setText(area + "");
                    volume_ans.setText(volume+"");
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"m , n or t value is not valid",Toast.LENGTH_SHORT).show();
                    area_ans.setText("");
                    volume_ans.setText("");
                    hasFuture = false ;
                }
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
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
