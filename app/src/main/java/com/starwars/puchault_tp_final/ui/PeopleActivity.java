package com.starwars.puchault_tp_final.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.starwars.puchault_tp_final.R;
import com.starwars.puchault_tp_final.models.People;

import static com.starwars.puchault_tp_final.ui.PeopleListActivity.PEOPLE_ADDRESS_KEY;

public class PeopleActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_CHARACTER = 5678;
    private static final String NOM_LUKE = "Luke Skywalker";
    private static final String NOM_EETH = "Eeth Koth";
    private static final String NOM_ADI = "Adi Gallia";
    private static final String NOM_SAESEE = "Saesee Tiin";
    private static final String NOM_YARAEL = "Yarael Poof";
    private static final String NOM_PLO = "Plo Koon";
    private static final String NOM_MAS = "Mas Amedda";
    private static final String NOM_GREGAR = "Gregar Typho";
    private static final String NOM_CORDE = "Cordé";
    private static final String NOM_CLIEGG = "Cliegg Lars";
    private static final String NOM_R2D2 = "R2-D2";
    private static final String NOM_C3PO = "C-3PO";
    private static final String NOM_YODA = "Yoda";

    private TextView name;
    private TextView mass;
    private TextView hair;
    private TextView gender;
    private TextView height;
    private TextView skin;
    private TextView birth;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        name = findViewById(R.id.name);
        mass = findViewById(R.id.mass);
        height = findViewById(R.id.height);
        skin = findViewById(R.id.skinColor);
        gender = findViewById(R.id.gender);
        birth = findViewById(R.id.birthYear);
        hair = findViewById(R.id.hairColor);
        imageView = findViewById(R.id.imageView);



        People people = getIntent().getParcelableExtra(PEOPLE_ADDRESS_KEY);


        name.setText(people.name);
        mass.setText(people.mass);
        height.setText(people.height);
        skin.setText(people.skinColor);
        birth.setText(people.birthYear);
        hair.setText(people.hairColor);
        gender.setText(people.gender);

        if(choosePicture(people.name) != 0)
            imageView.setImageResource(choosePicture(people.name));



    }

    private int choosePicture(String name){

        if(name.equals(NOM_LUKE))
             return R.drawable.image_luke;
        else if (name.equals(NOM_ADI))
            return R.drawable.adi_gallia;
        else if (name.equals(NOM_EETH))
            return R.drawable.eeth_koth;
        else if (name.equals(NOM_SAESEE))
            return R.drawable.saeseetiin;
        else if (name.equals(NOM_YARAEL))
            return R.drawable.yarael_poof;
        else if (name.equals(NOM_PLO))
            return R.drawable.plokoon;
        else if (name.equals(NOM_MAS))
            return R.drawable.mas;
        else if (name.equals(NOM_GREGAR))
            return R.drawable.panaka;
        else if (name.equals(NOM_CORDE))
            return R.drawable.sabe;
        else if (name.equals(NOM_CLIEGG))
            return R.drawable.owen_lars;
        else if (name.equals(NOM_R2D2))
            return R.drawable.rd;
        else if (name.equals(NOM_C3PO))
            return R.drawable.cpo;
        else if (name.equals(NOM_YODA))
            return R.drawable.yoda;
        return 0;
    }

    public static Intent getStartIntent(final Context context){
        return new Intent (context, PeopleActivity.class);
    }
}
