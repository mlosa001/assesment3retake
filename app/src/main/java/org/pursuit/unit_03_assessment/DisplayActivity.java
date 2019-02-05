package org.pursuit.unit_03_assessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.unit_03_assessment.R;
import org.pursuit.unit_03_assessment.view.ZodiacViewHolder;

public class DisplayActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView numberTextView;
    private ImageView pictureImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        Intent intent = getIntent();
        numberTextView = findViewById(R.id.zodiac_number);
        nameTextView = findViewById(R.id.zodiac_name);
        nameTextView.setText(intent.getStringExtra("NAME"));
        numberTextView.setText(intent.getStringExtra(ZodiacViewHolder.NUMBER));


        pictureImageView = findViewById(R.id.zodiac_image);

        Picasso.get()
                .load(intent.getStringExtra(ZodiacViewHolder.IMAGE))
                .into(pictureImageView);
    }
}