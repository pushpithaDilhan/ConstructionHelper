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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        final Intent past = getIntent();

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<CharSequence> catList = ArrayAdapter.createFromResource(this , R.array.category_list ,android.R.layout.simple_list_item_1);
        listView.setAdapter(catList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent concrete  = new Intent(getApplicationContext(),Concrete.class);
                    try {
                        concrete.putExtra("volume", past.getFloatExtra("volume",0));
                        startActivity(concrete);
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Volume is not valid.",Toast.LENGTH_SHORT).show();
                    }
                }
                else if (position==5){
                    Intent painting  = new Intent(getApplicationContext(),Painting.class);
                    try {
                        painting.putExtra("area", past.getFloatExtra("area",0));
                        startActivity(painting);
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Area is not valid.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
