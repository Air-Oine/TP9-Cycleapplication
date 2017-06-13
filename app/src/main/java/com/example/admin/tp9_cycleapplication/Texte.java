package com.example.admin.tp9_cycleapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by admin on 13/06/2017.
 */

public class Texte implements Parcelable {
    private String texte;

    protected Texte(Parcel in) {
        texte = in.readString();
    }

    public static final Creator<Texte> CREATOR = new Creator<Texte>() {
        @Override
        public Texte createFromParcel(Parcel in) {
            return new Texte(in);
        }

        @Override
        public Texte[] newArray(int size) {
            return new Texte[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(texte);
    }

    public Texte(String texte) {
        this.texte = texte;
    }

    public String getTexte() {
        return texte;
    }
}
