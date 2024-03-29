package com.example.filterable_android_sdk;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.function.Function;

public class MainActivity extends AppCompatActivity {

    private Button cardViewLaunchButton;
    private Button bannerViewLaunchButton;
    private Button notificationViewLaunchButton;
    private Messenger messenger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the messenger
        messenger = new Messenger(new Handler() {
            @Override
            public void handleMessage(Message message) {
                // Take appropriate action
                // Take appropriate action
                String data = (String) message.obj;
                Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });

        // Find the button in the layout
        cardViewLaunchButton = findViewById(R.id.card_view_launch_button);
        bannerViewLaunchButton = findViewById(R.id.banner_view_launch_button);
        notificationViewLaunchButton = findViewById(R.id.notification_view_launch_button);

        //button action handler
        this.onCardViewLaunchButton();
        this.onBannerViewLaunchButton();
        this.onNotificationViewLaunchButton();
    }

    public void onCardViewLaunchButton() {

        cardViewLaunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to launch the second activity
                Intent intent = new Intent(MainActivity.this, CardViewActivity.class);

                intent.putExtra("messenger", messenger);

                //card image param
                intent.putExtra("imageUrl", "");

                //card params
                intent.putExtra("cardRadius", 20);
                intent.putExtra("cardBackgroundColor", Color.parseColor("#ffffff"));

                //title params
                intent.putExtra("titleText", "Turn on notifications");
                intent.putExtra("titleTextSize", 14);
                intent.putExtra("titleTextColor", Color.parseColor("#000000"));

                //description text params
                intent.putExtra("descriptionText", "Get updates on scheduled and trending classes.");
                intent.putExtra("descriptionTextSize", 14);
                intent.putExtra("descriptionTextColor", Color.parseColor("#000000"));

                //primary button params
                intent.putExtra("primaryButtonText", "Turn on");
                intent.putExtra("primaryButtonTextColor", Color.parseColor("#0045c6"));

                //secondary button params
                intent.putExtra("secondaryButtonText", "Not now");
                intent.putExtra("secondaryButtonTextColor", Color.parseColor("#0045c6"));
                intent.putExtra("secondaryButtonVisible", true);

                //start the activity
                startActivity(intent);
            }
        });
    }

    public void onBannerViewLaunchButton() {

        bannerViewLaunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to launch the second activity
                Intent intent = new Intent(MainActivity.this, BannerViewActivity.class);

                intent.putExtra("messenger", messenger);

                //card image params
                intent.putExtra("imageUrl", "");
                intent.putExtra("imageWidth", "");
                intent.putExtra("imageHeight", "");

                //card params
                intent.putExtra("cardRadius", 20);
                intent.putExtra("cardBackgroundColor", Color.parseColor("#ffffff"));

                //title params
                intent.putExtra("titleText", "Turn on notifications");
                intent.putExtra("titleTextSize", 14);
                intent.putExtra("titleTextColor", Color.parseColor("#000000"));

                //description text params
                intent.putExtra("descriptionText", "Get updates on scheduled and trending classes.");
                intent.putExtra("descriptionTextSize", 14);
                intent.putExtra("descriptionTextColor", Color.parseColor("#000000"));

                //primary button params
                intent.putExtra("primaryButtonText", "Turn on");
                intent.putExtra("primaryButtonRadius", 50);
                intent.putExtra("primaryButtonTextColor", Color.parseColor("#ffffff"));
                intent.putExtra("primaryButtonBackgroundColor", Color.parseColor("#0045c6"));

                //secondary button params
                intent.putExtra("secondaryButtonText", "Not now");
                intent.putExtra("secondaryButtonTextColor", Color.parseColor("#0045c6"));
                intent.putExtra("secondaryButtonVisible", true);

                //start the activity
                startActivity(intent);
            }
        });
    }

    public void onNotificationViewLaunchButton() {

        notificationViewLaunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to launch the second activity
                Intent intent = new Intent(MainActivity.this, NotificationViewActivity.class);

                intent.putExtra("messenger", messenger);

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


                //start the activity
                startActivity(intent);
            }
        });
    }


}

