package com.example.instagram;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.parse.ParseFile;

import org.parceler.Parcels;


public class DetailsActivity extends AppCompatActivity{

    public TextView  profile;
    public ImageView pictureProfile;
    public TextView description;
    public ImageView photoUser;
    public TextView time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        profile = findViewById(R.id. profile);
        description = findViewById(R.id.description);
        time = findViewById(R.id.time);
        pictureProfile = findViewById(R.id.pictureProfile);
        photoUser = findViewById(R.id.photoUser);

        Post post = Parcels.unwrap(getIntent().getParcelableExtra("post"));



        profile.setText(post.getUser().getUsername());
        description.setText(post.getDescription());
        time.setText(TimeFormatter.getTimeStamp(post.getCreatedAt().toString()));


        ParseFile image = post.getImage();

        if (image != null) {

            Glide.with(DetailsActivity.this)
                    .load(image.getUrl())
                    .fitCenter()
                    .into(  pictureProfile);

        }

        Glide.with(DetailsActivity.this).load(post.getUser().getParseFile(User.KEY_PHOTO_USER)
                .getUrl()).into(photoUser);
    }
}