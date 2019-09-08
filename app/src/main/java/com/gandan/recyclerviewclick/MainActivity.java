package com.gandan.recyclerviewclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickAdapter.ClickListener {

    ArrayList<DummyModel> dummyList = new ArrayList<>();
    RecyclerViewClickAdapter recyclerViewClickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        for(int i = 0; i < 50; i++){
            DummyModel model = new DummyModel();
            model.setCount(0);
            switch(i%3){
                case 0:
                    model.setName("호랑이");
                    break;
                case 1:
                    model.setName("강아지");
                    break;
                case 2:
                    model.setName("고양이");
                    break;
            }
            dummyList.add(model);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewClickAdapter = new RecyclerViewClickAdapter(dummyList, this);
        recyclerView.setAdapter(recyclerViewClickAdapter);

    }

    @Override
    public void clicked(int position, int value) {
        dummyList.get(position).setCount(value);
        Toast.makeText(this, dummyList.get(position).getName()+" : "+value+"마리", Toast.LENGTH_SHORT).show();
        recyclerViewClickAdapter.setList(dummyList);
    }
}
