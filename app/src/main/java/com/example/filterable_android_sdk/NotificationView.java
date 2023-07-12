package com.example.filterable_android_sdk;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

public class NotificationViewActivity extends CardView {

    private CardView cardView;
    private TextView titleText;
    private TextView descriptionText;
    private Button primaryButton;
    private Button secondaryButton;

    public NotificationViewActivity() {
        super(getContext());
        init();
    }

    public NotificationViewActivity(Context context) {
        super(context);
        init();
    }

    public NotificationViewActivity(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NotificationViewActivity(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.activity_notification_view, this);
        cardView = findViewById(R.id.card_view);
        titleText = findViewById(R.id.titleText);
        descriptionText = findViewById(R.id.descriptionText);
        primaryButton = findViewById(R.id.primaryButton);
        secondaryButton = findViewById(R.id.secondaryButton);
        this.updateValues();
    }

    public void updateValues() {

        titleText.setText("Notification");
        titleText.setTextColor(Color.parseColor("#34bf49"));
        descriptionText.setText("Description");
        cardView.setRadius(0);
//        primaryButton.setBackgroundColor(Color.parseColor("#34bf49"));

    }
}
