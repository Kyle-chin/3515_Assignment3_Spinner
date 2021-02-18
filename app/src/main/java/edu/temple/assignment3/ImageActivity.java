package edu.temple.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ImageActivity extends AppCompatActivity {

    Spinner ValCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] Valheros = new String[]{"Dropdown...","Killjoy", "Omen", "Phoenix", "Sage", "Sova", "Yoru"};
        ArrayAdapter adapter = new ArrayAdapter( this, android.R.layout.simple_list_item_1, Valheros);

        ValCharacters = findViewById(R.id.spinner_Valorant);
        ValCharacters.setAdapter(adapter);
    }
}