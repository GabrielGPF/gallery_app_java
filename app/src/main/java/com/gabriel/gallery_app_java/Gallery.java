package com.gabriel.gallery_app_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Gallery extends AppCompatActivity {
    int currentImageIndex = 0;

    private void changeContent(int newIndex){
        currentImageIndex = newIndex;

        ImageView imageView = findViewById(R.id.imageView);
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView countTextView = findViewById(R.id.countTextView);

        switch (newIndex){
            case 0:
                changeImage(imageView, R.drawable.spongebob);
                titleTextView.setText(R.string.spongebob);
                countTextView.setText("1/4");
                break;
            case 1:
                changeImage(imageView, R.drawable.patrick);
                titleTextView.setText(R.string.patrick);
                countTextView.setText("2/4");
                break;
            case 2:
                changeImage(imageView, R.drawable.sandy);
                titleTextView.setText(R.string.sandy);
                countTextView.setText("3/4");
                break;
            case 3:
                changeImage(imageView, R.drawable.krabs);
                titleTextView.setText(R.string.mr_krabs);
                countTextView.setText("4/4");
                break;
        }
    }

    private void changeImage(ImageView imageView, int image){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imageView.setImageDrawable(getResources().getDrawable(image, getApplicationContext().getTheme()));
        } else {
            imageView.setImageDrawable(getResources().getDrawable(image));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        //get extra data
        String sessionUsername = getIntent().getStringExtra("EXTRA_USERNAME");
//        Log.i("text", "sessionUsername: " + sessionUsername);

        //Set username title
        TextView usernameTextView = findViewById(R.id.usernameTextView);
        usernameTextView.setText(sessionUsername);

        //Initialize Spongebob image
        changeContent(0);
    }

    public void previousCharacter(View view) {
//        Log.i("text", "PREVIOUS");
        changeContent(currentImageIndex > 0 ? currentImageIndex - 1 : 3);
    }

    public void nextCharacter(View view) {
//        Log.i("text", "NEXT");
        changeContent(currentImageIndex < 3 ? currentImageIndex + 1 : 0);
    }
}