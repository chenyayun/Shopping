package com.charein.shopping;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class UIFragment extends Fragment {
    // GUI variables
    private Button listItems;
    private Button addItem;
    private Button delItem;

    private EditText editWhat;
    private EditText editWhere;

    // Model: Database of items
    private ItemsDB itemsDB;

    public UIFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ui, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemsDB = ItemsDB.getInstance();
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editWhat = (EditText) view.findViewById(R.id.editWhat);
        editWhere = (EditText) view.findViewById(R.id.editWhere);

        listItems = (Button) view.findViewById(R.id.listItems);
        listItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ListActivity.class);
                startActivity(intent);
            }
        });

        addItem = (Button) view.findViewById(R.id.addItem);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });

        delItem = (Button) view.findViewById(R.id.delItem);
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
            Toast.makeText(getActivity(), "what is empty", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        if (where.isEmpty()) {
            Toast.makeText(getActivity(), "where is empty", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        itemsDB.addItem(new Item(what, where));
        Toast.makeText(getActivity(), "add item success", Toast.LENGTH_SHORT)
                .show();
    }

    private void del() {
        String what = editWhat.getText().toString();
        String where = editWhere.getText().toString();
        if (what.isEmpty()) {
            Toast.makeText(getActivity(), "what is empty", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        if (where.isEmpty()) {
            Toast.makeText(getActivity(), "where is empty", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        boolean ret = itemsDB.delItem(new Item(what, where));
        Toast.makeText(getActivity(), ret ? "delete item success" : "delete item fail",
                Toast.LENGTH_SHORT).show();
    }
}
