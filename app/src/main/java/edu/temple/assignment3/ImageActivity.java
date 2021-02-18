package edu.temple.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {

    Spinner ValCharacters;
    ImageView imageView;
    int[] ValHeroesArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ValCharacters = findViewById(R.id.spinner_Valorant);
        imageView = findViewById(R.id.imageViewID);

        ArrayList Valheros = new ArrayList<String>();
        Valheros.add("Killjoy");
        Valheros.add("Omen");
        Valheros.add("Phoenix");
        Valheros.add("Sage");
        Valheros.add("Sova");
        Valheros.add("Yoru");

        ValHeroesArray = new  int[]{R.drawable.killjoy, R.drawable.omen, R.drawable.phoenix_artwork, R.drawable.sage, R.drawable.sova, R.drawable.yoru};

        ArrayAdapter adapter = new ArrayAdapter( this, android.R.layout.simple_list_item_1, Valheros);


        ValCharacters.setAdapter(adapter);

        ValCharacters.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                showPicture(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }
    /*
    public class ImageAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 0;
        }
        @Override
        public Object getItem(int i) {
            return null;
        }
        @Override
        public long getItemId(int i) {
            return 0;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }*/
    private void showPicture(int position){
        imageView.setImageResource(ValHeroesArray[position]);
    }
}