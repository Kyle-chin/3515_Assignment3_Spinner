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
        Valheros.add("Select a Character...");
        Valheros.add("Killjoy, Mechanic Controller");
        Valheros.add("Omen, Smoke and Mind Game Controller");
        Valheros.add("Phoenix, Fire Duelist");
        Valheros.add("Sage, Combat Medic");
        Valheros.add("Sova, Technological Hunter");
        Valheros.add("Yoru, Rift Walker");

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
                characterDescription.setTextSize(30);
                characterDescription.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void showPicture(int position){
        imageView.setImageResource(ValHeroesArray[position]);
    }

}