package com.example.admin.tp9_cycleapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Air-Oine on 13/06/2017.
 */

public abstract class Traceur extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showState("create");
    }

    @Override
    protected void onResume() {
        super.onResume();

        showState("resume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        showState("pause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        showState("restart");
    }

    @Override
    protected void onStart() {
        super.onStart();

        showState("start");
    }

    @Override
    protected void onStop() {
        super.onStop();

        showState("stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        showState("destroy");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        showState("restore instance");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        showState("save instance");
    }

    private void showState(String state) {
        Toast.makeText(this, "On " + state, Toast.LENGTH_SHORT).show();
    }
}
