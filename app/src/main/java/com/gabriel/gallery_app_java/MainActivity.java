package com.gabriel.gallery_app_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
//        Log.i("text", "LOG IN");
        String userEditText = ((EditText) findViewById(R.id.editTextTextPersonName)).getText().toString();
        if(userEditText != null && userEditText.length() > 0 && !userEditText.isEmpty()){
            Intent intent = new Intent(this, Gallery.class);
            intent.putExtra("EXTRA_USERNAME", userEditText);
            startActivity(intent);
        }
    }

    public void signIn(View view) {
        Log.i("text", "SIGN IN");
//        Intent intent = new Intent(this, Gallery.class);
//        startActivity(intent);
    }
}