package com.example.recycleviewapp_byself;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<MyModel> myModelList;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayItems();
    }

    private void displayItems() {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        myModelList = new ArrayList<>();
        myModelList.add(new MyModel( "Evan",  26));
        myModelList.add(new MyModel( "Ngoc",  29));
        myModelList.add(new MyModel( "Hoang",  32));
        myModelList.add(new MyModel( "Do",  29));
        myModelList.add(new MyModel( "Tung",  18));
        myModelList.add(new MyModel( "Thu",  20));
        myModelList.add(new MyModel( "Ngan",  39));
        myModelList.add(new MyModel( "Van",  36));
        myModelList.add(new MyModel( "Chien",  46));
        myModelList.add(new MyModel( "John",  42));
        myModelList.add(new MyModel( "Jack",  29));
        customAdapter = new CustomAdapter(this, myModelList);
        recyclerView.setAdapter(customAdapter);


    }

}