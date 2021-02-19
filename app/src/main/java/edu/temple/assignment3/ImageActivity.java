package edu.temple.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {

    Spinner ValCharacters;
    ImageView imageView;
    TextView characterDescription;
    int[] ValHeroesArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ValCharacters = findViewById(R.id.spinner_Valorant);
        imageView = findViewById(R.id.imageViewID);
        characterDescription = findViewById(R.id.textViewID);
        ArrayList Valheros = new ArrayList<String>();
        Valheros.add("Select a Charecter...");
        Valheros.add("Killjoy");
        Valheros.add("Omen");
        Valheros.add("Phoenix");
        Valheros.add("Sage");
        Valheros.add("Sova");
        Valheros.add("Yoru");

        ValHeroesArray = new  int[]{R.drawable.ic_launcher_foreground,R.drawable.killjoy, R.drawable.omen, R.drawable.phoenix_artwork, R.drawable.sage, R.drawable.sova, R.drawable.yoru};

        //ArrayAdapter adapter = new ArrayAdapter( this, android.R.layout.simple_list_item_1, Valheros);
        ImageAdapter imageAdapter = new ImageAdapter( this, Valheros, ValHeroesArray);

        ValCharacters.setAdapter(imageAdapter);

        ValCharacters.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ImageActivity.this, "Character Selected", Toast.LENGTH_SHORT).show();
                showPicture(position);
                characterDescription.setText((parent.getItemAtPosition(position)).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void showPicture(int position){
        imageView.setImageResource(ValHeroesArray[position]);
    }

}