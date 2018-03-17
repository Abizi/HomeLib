package com.turkeytech.homelib.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.turkeytech.homelib.R;
import com.turkeytech.homelib.Activities.MainActivity.MainActivity;

public class DefaultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);
        startActivity(new Intent(this, MainActivity.class));
    }
}
