package com.example.filterable_android_sdk;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ButtonClickHandler {

    private Button launchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the button in the layout
        launchButton = findViewById(R.id.launch_button);

        // Set a click listener for the button
        launchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to launch the second activity
                Intent intent = new Intent(MainActivity.this, BannerViewActivity.class);

                //card params
                intent.putExtra("cardRadius", 20);
                intent.putExtra("cardBackgroundColor", Color.parseColor("#f5f5ff"));

                //title params
                intent.putExtra("titleText", "Turn on notifications");
                intent.putExtra("titleTextSize", 14);
                intent.putExtra("titleTextColor", Color.parseColor("#0045c6"));

                //description text params
                intent.putExtra("descriptionText", "Get updates on scheduled and trending classes.");
                intent.putExtra("descriptionTextSize", 14);
                intent.putExtra("descriptionTextColor", Color.parseColor("#0045c6"));

                //primary button params
                intent.putExtra("primaryButtonText", "Turn on");
                intent.putExtra("primaryButtonRadius", 50);
                intent.putExtra("primaryButtonTextColor", Color.parseColor("#ffffff"));
                intent.putExtra("primaryButtonBackgroundColor", Color.parseColor("#0045c6"));

                //secondary button params
                intent.putExtra("secondaryButtonText", "Not now");
                intent.putExtra("secondaryButtonTextColor", Color.parseColor("#0045c6"));
                intent.putExtra("secondaryButtonVisible", true);

                //logo image params
                intent.putExtra("logoImageUrl", "https://example.com/logo.png");
                intent.putExtra("logoWidth", 48);
                intent.putExtra("logoHeight", 48);

                // Start the activity
                startActivity(intent);
            }
        });
    }

    @Override
    public void execute() {
        Toast.makeText(getApplicationContext(), "Your message here", Toast.LENGTH_SHORT).show();
    }
}
