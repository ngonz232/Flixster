package com.example.flixster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.bumptech.glide.util.LogTime;
import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.flixster.databinding.ActivityMovieDetailsBinding;
import com.example.flixster.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import okhttp3.Headers;

public class MovieDetailsActivity extends AppCompatActivity {
    private static final String TAG = "MovieDetailsActivity";
    // the movie to display
    Movie movie;

    //content variables
    TextView tvTitle;
    TextView tvOverview;
    RatingBar rbVoteAverage;
    ImageView ivMoviePoster;
    ImageView playButton;
    public static String videoID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_movie_details);
        ActivityMovieDetailsBinding binding = ActivityMovieDetailsBinding.inflate(getLayoutInflater());
        //ActivityMovieDetailsBinding binding = new ActivityMovieDetailsBinding().inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // unwrap the movie passed in via intent, using its simple name as a key
        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Showing details for '%s'", movie.getTitle()));

//        // initialize the widgets
        tvTitle = binding.tvTitle;
        tvOverview = binding.tvOverview;
        rbVoteAverage = binding.rbVoteAverage;
        ivMoviePoster = binding.ivMoviePoster;
//
//        View view = binding.getRoot();
//        setContentView(view);

        // set the title, overview, rating, and movieUrl
        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());
        String movieUrl = movie.getMovieId();


        // vote average is 0..10, convert to 0..5 by dividing by 2
        float voteAverage = movie.getVoteAverage().floatValue();
        rbVoteAverage.setRating(voteAverage / 2.0f);

        //Defining image url
        String imageUrl;
        //if phone is in landscape mode
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //then use backdrop image
            imageUrl = movie.getBackdropPath();
        } else {
            //else imageUrl = posterImage
            imageUrl = movie.getPosterPath();
            //Placeholder image for when poster is loading
        }

        //variables for rounded image transformation
        int radius = 30;
        int margin = 0;

        //poster image with its tranformations using glide
        Glide.with(this).load(imageUrl)
                .fitCenter()
                .placeholder(R.drawable.placeholder)
                .transform(new RoundedCornersTransformation(radius, margin))
                .into(ivMoviePoster);

        //binds backButton and initializes it
        Button backButton = (Button) binding.backButton;

        //OnClickListener to be taken back to main screen using back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MovieDetailsActivity.this, MainActivity.class));
            }
        });

        //binds playButton and initializes it
        playButton = binding.playButton;

        //OnClickListener to play movie trailer using playButton
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MovieDetailsActivity.this, MovieTrailerActivity.class));
            }
        });


        //Creates new instance of our Async client to retrieve YouTube videoID
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(movieUrl, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Headers headers, JSON json) {
                Log.d(TAG, "onSuccess");
                //returns jSON object
                JSONObject jsonObject = json.jsonObject;
                try {
                    JSONArray results = jsonObject.getJSONArray("results");
                    String videoString = results.getString(0);
                    JSONObject videoObject = new JSONObject(videoString);
                    videoID = videoObject.getString("key");
                    Log.d(TAG, "onSuccess: " + videoID);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.i(TAG, "Results: " + jsonObject.toString());


            }

            @Override
            public void onFailure(int i, Headers headers, String s, Throwable throwable) {
                Log.d(TAG, "onFailure");
            }
        });

        }
        //method for to pass videoID to MovieTrailerActivity
        public static String getVideoID(){
        videoID = videoID;
        return videoID;
    }
}