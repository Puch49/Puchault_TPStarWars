package com.starwars.puchault_tp_final.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.starwars.puchault_tp_final.R;
import com.starwars.puchault_tp_final.models.SWModelList;
import com.starwars.puchault_tp_final.models.People;
import com.starwars.puchault_tp_final.remote.StarWarsApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit.RetrofitError;


public class PeopleListActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_CHARACTER = 1234;
    public static final int NUMBER_PAGE_PEOPLE = 9;
    public static String PEOPLE_ADDRESS_KEY = "PEOPLE_ADDRESS_KEY";
    private TextView noCharactersFound;
    private final List<People> listOfCharacters = new ArrayList<>();
    private PeopleAdapter peopleAdapter;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_list);
        Log.d("present", "onCreate: ");
        noCharactersFound = findViewById(R.id.emptyCharacters);
        final ListView characters = findViewById(R.id.charactersListView);
        imageView =findViewById(R.id.imageView);
        listOfCharacters.clear();
        peopleAdapter = new PeopleAdapter(this, listOfCharacters, characterSelectedListener);
        characters.setAdapter(peopleAdapter);
        StarWarsApiService.init();
        for (int i = 0; i<NUMBER_PAGE_PEOPLE; i++) {
            StarWarsApiService.getApi().getAllPeople(i, new retrofit.Callback<SWModelList<People>>() {
                @Override
                public void success(SWModelList<People> peopleSWModelList, retrofit.client.Response response) {
                    updatePeople(peopleSWModelList);
                }

                @Override
                public void failure(RetrofitError error) {

                }
            });
        }



    }

    public static Intent getStartIntent(final Context context){
        return new Intent (context, PeopleListActivity.class);
    }


    private final PeopleAdapter.OnCharacterSelectedListener characterSelectedListener = new PeopleAdapter.OnCharacterSelectedListener(){
        @Override
        public void handle(final People character) {
            final Intent data = PeopleActivity.getStartIntent(PeopleListActivity.this);
            data.putExtra(PEOPLE_ADDRESS_KEY, (Parcelable) character);
            startActivity(data);
        }
    };




    private void updatePeople(final SWModelList<People> characters) {
        if (characters != null && characters.count > 0) {
            noCharactersFound.setVisibility(View.GONE);
            listOfCharacters.addAll(characters.results);
            peopleAdapter.notifyDataSetChanged();
            Log.d("dans le update", "updatePeople: ");
        } else {
            noCharactersFound.setVisibility(View.VISIBLE); // display the noPeople TextView
        }
    }

}
