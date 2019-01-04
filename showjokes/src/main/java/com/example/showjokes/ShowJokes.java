package com.example.showjokes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShowJokes extends AppCompatActivity {

    private TextView showjoke_textView;
    private static final String OWARAI = "JOKE";
    private String joke_string;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showjoke);
        Intent intent = getIntent();
        if (intent.getExtras() != null){
            joke_string = intent.getStringExtra(OWARAI);
        }
        showjoke_textView = findViewById(R.id.joke_textview);
        showjoke_textView.setText(joke_string);
    }
}
