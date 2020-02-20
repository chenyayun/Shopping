package com.charein.shopping;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {
    private TextView items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ItemsDB itemsDB = ItemsDB.getInstance();

        items = (TextView) findViewById(R.id.items);
        items.setText("Shopping List:" + itemsDB.listItems());
        items.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }
}
