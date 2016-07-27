package com.example.pushpitha.constructionhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CommonActivity extends AppCompatActivity {

    private EditText m_in , n_in ,t_in;
    private float m_value, n_value , t_value , area , volume ;
    private String shape;
    private TextView area_view , volume_view ;


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
        }

        m_in = (EditText) findViewById(R.id.editText_mc);
        n_in = (EditText) findViewById(R.id.editText_nc);
        t_in = (EditText) findViewById(R.id.editText_tc);

        area_view = (TextView) findViewById(R.id.textView_areac);
        volume_view = (TextView) findViewById(R.id.textView_volumeh);

        Button area_c = (Button) findViewById(R.id.button_areac);
        Button volume_c = (Button) findViewById(R.id.button_volumec);
        Button next_c = (Button) findViewById(R.id.button_nextc);

        area_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    m_value = Float.parseFloat(m_in.getText().toString());
                    n_value = Float.parseFloat(n_in.getText().toString());
                    if (shape.equals("parallelogram")) {
                        area = m_value * n_value;
                    } else if (shape.equals("oval")) {
                        area = (float) (m_value * n_value + Math.PI * n_value * n_value / 4.0);
                    } else if (shape.equals("bulletshape")) {
                        area = (float) (m_value * n_value + Math.PI * m_value * m_value / 4.0);
                    }
                    area_view.setText(Float.toString(area ));
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"m or n values is not valid.",Toast.LENGTH_SHORT).show();
                }

            }
        });

        volume_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    m_value = Float.parseFloat(m_in.getText().toString());
                    n_value = Float.parseFloat(n_in.getText().toString());
                    t_value = Float.parseFloat(t_in.getText().toString());
                    if (shape.equals("parallelogram")) {
                        area = m_value * n_value;
                        volume = area * t_value;
                    } else if (shape.equals("oval")) {
                        area = (float) (m_value * n_value + Math.PI * n_value * n_value / 4.0);
                        volume = area * t_value;
                    } else if (shape.equals("bulletshape")) {
                        area = (float) (m_value * n_value + Math.PI * m_value * m_value / 4.0);
                        volume = area * t_value;
                    }
                    area_view.setText(Float.toString(area));
                    volume_view.setText(Float.toString(volume));

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"m ,Thickness or n values is not valid.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        next_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                                                     // attention need "hasFuture" variable
                    Intent category = new Intent(getApplicationContext(),Category.class);
                    category.putExtra("area",area);
                    category.putExtra("volume",volume);
                    startActivity(category);

            }
        });



    }
}
