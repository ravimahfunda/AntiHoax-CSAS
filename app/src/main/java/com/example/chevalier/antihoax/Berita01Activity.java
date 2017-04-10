package com.example.chevalier.antihoax;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Berita01Activity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita01);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String newString;
        String newString2;
        int newString3;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
                newString2= null;
                newString3= 0;
            } else {
                newString= extras.getString("berita");
                newString2= extras.getString("judul");
                newString3= extras.getInt("gambar");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("berita");
            newString2= (String) savedInstanceState.getSerializable("judul");
            newString3= (int) savedInstanceState.getSerializable("gambar");
        }

        TextView berita = (TextView) findViewById(R.id.news_content);
        berita.setText(newString);
        setTitle(newString2);
        android.support.design.widget.CollapsingToolbarLayout ini =
                (android.support.design.widget.CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);

        Drawable gambar2 = getDrawable(newString3);
        ini.setBackground(gambar2);

    }
}
