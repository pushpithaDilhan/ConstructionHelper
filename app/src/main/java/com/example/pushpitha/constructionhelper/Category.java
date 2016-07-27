package com.example.pushpitha.constructionhelper;

import android.content.Intent;
import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Category extends AppCompatActivity {

    EditText area,volume ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Intent past = getIntent();

        area = (EditText) findViewById(R.id.editText_areaforward);
        volume = (EditText) findViewById(R.id.editText_volforward);

        area.setText(Float.toString(past.getFloatExtra("area", 0)));
        volume.setText(Float.toString(past.getFloatExtra("volume",0)));

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<CharSequence> catList = ArrayAdapter.createFromResource(this , R.array.category_list ,android.R.layout.simple_list_item_1);
        listView.setAdapter(catList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent concrete  = new Intent(getApplicationContext(),Concrete.class);
                    try {
                        concrete.putExtra("volume", Float.parseFloat(volume.getText().toString()));
                        startActivity(concrete);
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Volume is not valid.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
