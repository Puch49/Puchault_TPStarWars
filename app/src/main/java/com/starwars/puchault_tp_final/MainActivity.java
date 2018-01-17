package com.starwars.puchault_tp_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.starwars.puchault_tp_final.ui.PeopleListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(R.string.activity_main);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        initUI();
    }


    private void initUI(){
        final Button listCharacters = findViewById(R.id.list_character);
        final Button listPlanet = findViewById(R.id.list_planet);
        listCharacters.setOnClickListener(onShowListCharactersButtonClicked);
        listPlanet.setOnClickListener(onShowListPlanetButtonClicked);

    }

    public final View.OnClickListener onShowListPlanetButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, R.string.not_implemented, Toast.LENGTH_SHORT).show();

        }
    };

    public final View.OnClickListener onShowListCharactersButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final Intent intent = PeopleListActivity.getStartIntent(MainActivity.this);
            startActivityForResult(intent, PeopleListActivity.REQUEST_CODE_CHARACTER);
        }
    };




}
