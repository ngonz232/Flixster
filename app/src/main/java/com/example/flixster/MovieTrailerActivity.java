package com.example.flixster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MovieTrailerActivity extends YouTubeBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_trailer);
        // video id to pass into Youtube
        final String videoId = MovieDetailsActivity.getVideoID();

        // resolve the player view from the layout
        YouTubePlayerView playerView = (YouTubePlayerView) findViewById(R.id.player);

        String youtube_api_key = BuildConfig.YOUTUBE_KEY;
        // initialize with API key stored in secrets.xml
        playerView.initialize(youtube_api_key, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                YouTubePlayer youTubePlayer, boolean b) {
//                 do any work here to cue video, play video, etc.
                youTubePlayer.loadVideo(videoId);

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                YouTubeInitializationResult youTubeInitializationResult) {
                // log the error
                Log.e("MovieTrailerActivity", "Error initializing YouTube player");
            }
        });

        //binds backButton and initializes it
        Button backButton2 = findViewById(R.id.backButton2);

        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MovieTrailerActivity.this, MovieDetailsActivity.class));
            }
        });

    }
}