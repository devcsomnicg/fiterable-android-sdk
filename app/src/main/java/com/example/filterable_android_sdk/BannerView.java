package com.example.filterable_android_sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;


import androidx.cardview.widget.CardView;


import com.squareup.picasso.Picasso;

public class BannerView extends CardView {

    private TextView titleText;
    private TextView descriptionText;
    private ImageView logoImageView;
    private CardView cardView;
    private Button primaryButton;
    private Button secondaryButton;

    public BannerView(Context context) {
        super(context);
        init();
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BannerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.banner_view, this);
        titleText = findViewById(R.id.titleText);
        descriptionText = findViewById(R.id.descriptionText);
        logoImageView = findViewById(R.id.logoImageView);
        cardView = findViewById(R.id.banner_view);
        primaryButton = findViewById(R.id.primaryButton);
        secondaryButton = findViewById(R.id.secondaryButton);
        this.updateValues();
    }

    public void setTitle(String title) {
        titleText.setText(title);
    }

    public void setDescription(String description) {
        descriptionText.setText(description);
    }

    public void setLogoImageUrl(String imageUrl) {
        Picasso.get().load(imageUrl).into(logoImageView);
    }

    public void updateValues() {

        // Retrieve the passed values from the intent
        Intent intent = ((Activity) getContext()).getIntent();

        //card config
        cardView.setRadius(intent.getIntExtra("cardRadius", 4));
        cardView.setCardBackgroundColor(intent.getIntExtra("cardBackgroundColor", Color.parseColor("#ffffff")));

        //title of the card
        titleText.setText(intent.getStringExtra("titleText"));
        titleText.setTextSize(intent.getIntExtra("titleTextSize", 20));
        titleText.setTextColor(intent.getIntExtra("titleTextColor", Color.parseColor("#000000")));

        //description of the card
        descriptionText.setText(intent.getStringExtra("descriptionText"));
        descriptionText.setTextSize(intent.getIntExtra("descriptionTextSize", 16));
        descriptionText.setTextColor(intent.getIntExtra("descriptionTextColor", Color.parseColor("#000000")));

        //primary button of the card
        primaryButton.setText(intent.getStringExtra("primaryButtonText"));
        primaryButton.setTextColor(intent.getIntExtra("primaryButtonTextColor", Color.parseColor("#ffffff")));

        //secondary button of the card
        secondaryButton.setText(intent.getStringExtra("secondaryButtonText"));
        secondaryButton.setTextColor(intent.getIntExtra("secondaryButtonTextColor", Color.parseColor("#000000")));

        //secondary button visibility
        if (intent.getBooleanExtra("secondaryButtonVisible", true)) {
            secondaryButton.setVisibility(View.VISIBLE);
        } else {
            secondaryButton.setVisibility(View.GONE);
        }

        // Get the current background drawable of the button
        GradientDrawable backgroundDrawable = (GradientDrawable) primaryButton.getBackground();
        backgroundDrawable.setCornerRadius(intent.getIntExtra("primaryButtonRadius", 50));
        primaryButton.getBackground().setColorFilter((intent.getIntExtra("primaryButtonBackgroundColor", Color.parseColor("#FF4081"))), PorterDuff.Mode.SRC);
        primaryButton.setBackground(backgroundDrawable);

        // logo image of the card
        String logoImageUrl = intent.getStringExtra("logoImageUrl");
        Picasso.get().load(logoImageUrl).into(logoImageView);

        // Get the current layout params of the logoImageView
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) logoImageView.getLayoutParams();
        layoutParams.width = intent.getIntExtra("logoWidth", LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.height = intent.getIntExtra("logoHeight", LinearLayout.LayoutParams.WRAP_CONTENT);
        logoImageView.setLayoutParams(layoutParams);

    }
}