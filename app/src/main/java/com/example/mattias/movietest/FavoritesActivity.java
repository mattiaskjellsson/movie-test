package com.example.mattias.movietest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.mattias.movietest.dal.DbAdapter;

public class FavoritesActivity extends AppCompatActivity {
    private DbAdapter dbAdapter;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        dbAdapter = new DbAdapter(this);

        String s = dbAdapter.getData();
        textView = findViewById(R.id.favorites_textView);
        textView.setText(s);
    }

}
