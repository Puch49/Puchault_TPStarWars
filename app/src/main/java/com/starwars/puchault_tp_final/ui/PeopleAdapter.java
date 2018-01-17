package com.starwars.puchault_tp_final.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.starwars.puchault_tp_final.R;
import com.starwars.puchault_tp_final.models.People;

import java.util.List;

/**
 * Created by puchault on 17/01/2018.
 */

public class PeopleAdapter extends ArrayAdapter<People> {

    /**
     * Declare an inner interface to listen click event on device items
     */
    public interface OnCharacterSelectedListener {
        void handle(final People people);
    }

    private final OnCharacterSelectedListener onCharacterSelectedListener;

    PeopleAdapter(@NonNull final Context context, final List<People> characters, final OnCharacterSelectedListener listener) {
        super(context, R.layout.personnage_list_item, characters);
        onCharacterSelectedListener = listener;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull final ViewGroup parent) {
        View holder = convertView;
        if (convertView == null) {
            final LayoutInflater vi = LayoutInflater.from(getContext());
            holder = vi.inflate(R.layout.personnage_list_item, null);
        }

        final People character = getItem(position);
        if (character == null) {
            return holder;
        }

        // display the name
        final TextView characterName = holder.findViewById(R.id.personnageName);
        if (characterName != null) {
            characterName.setText(character.name);
        }

        // When this device item is clicked, trigger the listener
        holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (onCharacterSelectedListener != null) {
                    onCharacterSelectedListener.handle(character);
                }
            }
        });

        return holder;
    }
}