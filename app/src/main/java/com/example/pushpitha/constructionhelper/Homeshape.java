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

public class Homeshape extends AppCompatActivity {

    private EditText m_inh , n_inh ,t_inh,h_inh;
    private float m_value, n_value , t_value ,h_value , area , volume ;
    private String shape;
    private TextView area_view , volume_view ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeshape);
        ImageView common = (ImageView) findViewById(R.id.image_common);
        common.setImageResource(R.drawable.houseshape2);

        m_inh = (EditText) findViewById(R.id.editText_mch);
        n_inh = (EditText) findViewById(R.id.editText_nch);
        t_inh = (EditText) findViewById(R.id.editText_tch);
        h_inh = (EditText) findViewById(R.id.editText_hch);

        area_view = (TextView) findViewById(R.id.textView_areah);
        volume_view = (TextView) findViewById(R.id.textView_volumeh);

        Button area_c = (Button) findViewById(R.id.button_areac);
        Button volume_c = (Button) findViewById(R.id.button_volumec);
        Button next_c = (Button) findViewById(R.id.button_nextc);

        area_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    m_value = Float.parseFloat(m_inh.getText().toString());
                    n_value = Float.parseFloat(n_inh.getText().toString());
                    h_value = Float.parseFloat(h_inh.getText().toString());
                    area = m_value * n_value + m_value * h_value;
                    area_view.setText(area + "");
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"m ,h or n values is not valid.",Toast.LENGTH_SHORT).show();
                }
            }
        });



        volume_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    m_value = Float.parseFloat(m_inh.getText().toString());
                    n_value = Float.parseFloat(n_inh.getText().toString());
                    t_value = Float.parseFloat(t_inh.getText().toString());
                    h_value = Float.parseFloat(h_inh.getText().toString());
                    area = m_value * n_value + m_value * h_value;
                    volume = area * t_value;
                    area_view.setText(area + "");
                    volume_view.setText(volume + "");
                }catch(Exception e){
                    Toast.makeText(getApplicationContext()," m, h, thickness or n values is not valid.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        next_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(true){                                                      // attention need "hasFuture" variable
                    Intent category = new Intent(getApplicationContext(),Category.class);
                    startActivity(category);
                }else{
                    Toast.makeText(getApplicationContext(),"Area or Volume is needed.", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
