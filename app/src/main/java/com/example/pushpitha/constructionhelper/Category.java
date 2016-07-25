package com.example.pushpitha.constructionhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<CharSequence> catList = ArrayAdapter.createFromResource(this , R.array.category_list ,android.R.layout.simple_list_item_1);
        listView.setAdapter(catList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"You have clicked "+parent.getItemAtPosition(position) , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
