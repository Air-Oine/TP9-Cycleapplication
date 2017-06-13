package com.example.admin.tp9_cycleapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends Traceur {

    public static final String TEXTE = "texte";
    public static final String TEXTE_PARCELABLE = "texte_parcelable";
    public static final String TP_9 = "TP9";
    public static final String PROGRESS_BAR = "progress_bar";

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get shared préférences
        sharedPreferences = getSharedPreferences(TP_9, MODE_PRIVATE);
        int progress = sharedPreferences.getInt(PROGRESS_BAR, 0);

        ProgressBar progressBarShared = (ProgressBar) findViewById(R.id.progressBarShared);
        progressBarShared.setProgress(progress);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //Set shared préférences
        ProgressBar progressBarShared = (ProgressBar) findViewById(R.id.progressBarShared);

        sharedPreferences = getSharedPreferences(TP_9, MODE_PRIVATE);
        sharedPreferences.edit()
                .putInt(PROGRESS_BAR, progressBarShared.getProgress())
                .commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Sauvegarde le texte saisi
        EditText texteET = (EditText) findViewById(R.id.texte_sauvegarde);
        outState.putString(TEXTE, texteET.getText().toString());

        //On sauvegarde grace à l'objet parcelable
        Texte texte = new Texte(texteET.getText().toString());
        outState.putParcelable(TEXTE_PARCELABLE, texte);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        //Restore le texte saisi si il existe
        EditText texteET = (EditText) findViewById(R.id.texte_sauvegarde);
        String texte = savedInstanceState.get(TEXTE).toString();

        //On restore grâce au parcelable
        Texte texteParcelable = savedInstanceState.getParcelable(TEXTE_PARCELABLE);
        texte = texteParcelable.getTexte();

        if(texte != null) {
            texteET.setText(texte);
        }
    }

    public void gotoPage2(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    /**
     * On incrémente la valeur de la progress bar, sauvegardée dans l'objet (sans avoir besoin de bundle)
     * @param view
     */
    public void incrementer(View view) {
        //Progress bar horizontale
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        int progressCourant = progressBar.getProgress();
        if(progressCourant == 100) {
            progressCourant = 0;
        }
        progressBar.setProgress(progressCourant+10);

        //Progress bar 2
        ProgressBar progressBarShared = (ProgressBar) findViewById(R.id.progressBarShared);
        int progressCourant2 = progressBarShared.getProgress();
        if(progressCourant2 == 100) {
            progressCourant2 = 0;
        }
        progressBarShared.setProgress(progressCourant2+2);
    }

}
