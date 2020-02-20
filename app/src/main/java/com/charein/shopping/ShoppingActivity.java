package com.charein.shopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ShoppingActivity extends AppCompatActivity {
    // GUI variables
    private Button listItems;
    private Button addItem;
    private Button delItem;

    private EditText editWhat;
    private EditText editWhere;

    // Model: Database of items
    private ItemsDB itemsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping);
        itemsDB = ItemsDB.getInstance();

        editWhat = (EditText) findViewById(R.id.editWhat);
        editWhere = (EditText) findViewById(R.id.editWhere);

        listItems = (Button) findViewById(R.id.listItems);
        listItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
            }
        });

        addItem = (Button) findViewById(R.id.addItem);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });

        delItem = (Button) findViewById(R.id.delItem);
        delItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                del();
            }
        });
    }

    private void add() {
        String what = editWhat.getText().toString();
        String where = editWhere.getText().toString();
        if (what.isEmpty()) {
            Toast.makeText(getApplicationContext(), "what is empty", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        if (where.isEmpty()) {
            Toast.makeText(getApplicationContext(), "where is empty", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        itemsDB.addItem(new Item(what, where));
        Toast.makeText(getApplicationContext(), "add item success", Toast.LENGTH_SHORT)
                .show();
    }

    private void del() {
        String what = editWhat.getText().toString();
        String where = editWhere.getText().toString();
        if (what.isEmpty()) {
            Toast.makeText(getApplicationContext(), "what is empty", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        if (where.isEmpty()) {
            Toast.makeText(getApplicationContext(), "where is empty", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        boolean ret = itemsDB.delItem(new Item(what, where));
        Toast.makeText(getApplicationContext(), ret ? "delete item success" : "delete item fail",
                Toast.LENGTH_SHORT).show();
    }
}
