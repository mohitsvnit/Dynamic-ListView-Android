package com.example.mohit.excersice_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bt;
    ArrayList list;
    EditText et;
    ArrayAdapter<String> arrayAdapter;
    ListView lv;
    int cnt = 0;
    AdapterView.OnItemClickListener onItemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt = (Button) findViewById(R.id.button);
        et = (EditText) findViewById(R.id.editText);


        list = new ArrayList();
        list.add("Mohit");

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);



        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(arrayAdapter);

        onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lv, View view, int position, long id) {
                          Toast.makeText(getBaseContext(),list.get(position).toString(),Toast.LENGTH_SHORT).show();
            }
        };

        lv.setOnItemClickListener(onItemClickListener);

    }



    @Override
    public void onClick(View v) {
        cnt++;
        if(v == bt) {
            String name = et.getText().toString();
            if(name.isEmpty()){
                Toast.makeText(getBaseContext(),"Lol",Toast.LENGTH_SHORT).show();
            }
            else {

                list.add(name);
                //Toast.makeText(getBaseContext(),"Khupach " + Integer.toString(cnt) +" "+ Integer.toString(list.size()) ,Toast.LENGTH_SHORT).show();
                //Log.d("list", String.valueOf(list));
                arrayAdapter.notifyDataSetChanged();


            }

        }
    }


}
