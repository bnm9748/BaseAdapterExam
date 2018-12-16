package com.example.baseadapterexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Weather> data = new ArrayList<>();
        data.add(new Weather("서울","25도","맑음"));
        data.add(new Weather("안산","23도","흐림"));
        data.add(new Weather("대전","25도","비"));
        data.add(new Weather("서산","26도","맑음"));
        data.add(new Weather("군산","22도","비"));
        data.add(new Weather("거제","25도","맑음"));
        data.add(new Weather("부산","25도","흐림"));

        MyFirstAdapter adapter = new MyFirstAdapter(data);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
