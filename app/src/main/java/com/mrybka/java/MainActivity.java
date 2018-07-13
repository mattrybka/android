package com.mrybka.java;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Locale;
import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setTitle("Web & Java");
        }
    }

    @OnClick(R.id.button)
    public void clickOnButton() {
        Intent intent = new Intent(this, SlideActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button2)
    public void clickOnButton2() {
        Intent intent = new Intent(this, ListLabActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button3)
    public void clickOnButton3() {
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }

}
