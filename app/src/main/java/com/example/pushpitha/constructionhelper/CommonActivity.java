package com.example.pushpitha.constructionhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CommonActivity extends AppCompatActivity {

    private EditText m_in , n_in ,t_in;
    private float m_value, n_value , t_value , area , volume ;
    private String shape;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        Intent newer = getIntent();
        shape = newer.getStringExtra("shape");

        ImageView common = (ImageView) findViewById(R.id.image_common);
        if(shape.equals("parallelogram")){
            common.setImageResource(R.drawable.parallelogram2);
        }else if(shape.equals("bulletshape")){
            common.setImageResource(R.drawable.bulletshape2);
        }else if(shape.equals("oval")){
            common.setImageResource(R.drawable.oval2);
        }else if(shape.equals("homeshape")){
            common.setImageResource(R.drawable.houseshape2);
        }

        m_in = (EditText) findViewById(R.id.editText_mc);
        n_in = (EditText) findViewById(R.id.editText_nc);
        t_in = (EditText) findViewById(R.id.editText_tc);

        Button area_c = (Button) findViewById(R.id.button_areac);
        Button volume_c = (Button) findViewById(R.id.button_volumec);
        Button next_c = (Button) findViewById(R.id.button_nextc);

        area_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_value = Float.parseFloat(m_in.getText().toString());
                n_value = Float.parseFloat(n_in.getText().toString());

            }
        });

        volume_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_value = Float.parseFloat(m_in.getText().toString());
                n_value = Float.parseFloat(n_in.getText().toString());
                t_value = Float.parseFloat(t_in.getText().toString());
            }
        });

        next_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(true){                                                      // attention need "hasFuture" variable
                    Intent category = new Intent(getApplicationContext(),Category.class);
                    startActivity(category);
                }else{
                    Toast.makeText(getApplicationContext(),"Area or Volume is needed.",Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
