package com.gabriel.gallery_app_java;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private void showEmptyFieldsDialog(){
        new AlertDialog.Builder(this)
                .setTitle("Empty fields")
                .setCancelable(true)
                .setPositiveButton("ok", ((DialogInterface dialog, int which) -> {})).show();
    }

    private void showWrongCredentialsDialog(){
        new AlertDialog.Builder(this)
                .setTitle("Wrong credentials")
                .setMessage("Try creating a account")
                .setCancelable(true)
                .setPositiveButton("ok", ((DialogInterface dialog, int which) -> {})).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
//        Log.i("text", "LOG IN");

        String editTextTextPersonName = ((EditText) findViewById(R.id.editTextTextPersonName)).getText().toString();
        String editTextTextPassword = ((EditText) findViewById(R.id.editTextTextPassword)).getText().toString();

        if(editTextTextPersonName.trim().length() > 0 && !editTextTextPersonName.isEmpty() &&
                editTextTextPassword.trim().length() > 0 && !editTextTextPassword.isEmpty()){
            if(editTextTextPersonName.equals("Gabriel") && editTextTextPassword.equals("secret")){
                Intent intent = new Intent(this, Gallery.class);
                intent.putExtra("EXTRA_USERNAME", editTextTextPersonName);
                startActivity(intent);
            } else {
                showWrongCredentialsDialog();
            }
        } else {
            showEmptyFieldsDialog();
        }
    }

    public void signIn(View view) {
//        Log.i("text", "SIGN IN");

        String editTextTextPersonName = ((EditText) findViewById(R.id.editTextTextPersonName)).getText().toString();
        String editTextTextPassword = ((EditText) findViewById(R.id.editTextTextPassword)).getText().toString();

        if(editTextTextPersonName.trim().length() > 0 && !editTextTextPersonName.isEmpty() &&
        editTextTextPassword.trim().length() > 0 && !editTextTextPassword.isEmpty()){
            Intent intent = new Intent(this, Gallery.class);
            intent.putExtra("EXTRA_USERNAME", editTextTextPersonName);
            startActivity(intent);
        } else {
            showEmptyFieldsDialog();
        }
    }
}