package com.sashka.carsproj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView imageView = findViewById(R.id.image_view_background);
        TextView textViewPhone = findViewById(R.id.number_textView);
        TextView textViewKm = findViewById(R.id.km);
        TextView textViewHours = findViewById(R.id.hours);

        Intent intent = getIntent();
        CategoryInfo obj = (CategoryInfo) intent.getSerializableExtra("categoryInfo");

        imageView.setImageDrawable(getDrawable(obj.idImageView));

        textViewPhone.setText(obj.phoneNumber);
        textViewKm.setText(obj.km);
        textViewHours.setText(obj.hours);




    }
}
