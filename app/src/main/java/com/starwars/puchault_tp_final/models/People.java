package com.starwars.puchault_tp_final.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by puch on 17/01/2018.
 */

public class People implements Serializable, Parcelable {

        public String name;

        @SerializedName("birth_year")
        public String birthYear;

        public String gender;

        @SerializedName("hair_color")
        public String hairColor;

        public String height;


        public String mass;

        @SerializedName("skin_color")
        public String skinColor;





    public static final Parcelable.Creator<People> CREATOR = new Parcelable.Creator<People>() {
        public People createFromParcel(Parcel in) {
            return new People(in);
        }

        public People[] newArray(int size) {
            return new People[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(name);
        out.writeString(mass);
        out.writeString(height);
        out.writeString(gender);
        out.writeString(birthYear);
        out.writeString(hairColor);
        out.writeString(skinColor);
        //out.writeString(eyeColor);

    }

    private People(Parcel in) {
        name = in.readString();
        mass = in.readString();
        height = in.readString();
        gender = in.readString();
        birthYear = in.readString();
        hairColor = in.readString();
        skinColor = in.readString();
        //eyeColor = in.readString();
    }
}
