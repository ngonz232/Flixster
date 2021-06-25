package com.example.flixster.models;

//imports
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {

    //variables for data
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    Double voteAverage;
    int movieId;

    //gets JSON data we need
    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        voteAverage = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");
    }

    //visualizes data to array and passes in data
    public static List<Movie> FromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    // no-arg, empty constructor required for Parceler
    public Movie() {}

    //getters for our data
    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public String getMovieId(){
        String movieUrl = "https://api.themoviedb.org/3/movie/" + movieId + "/videos?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed&language=en-US";
        return movieUrl;
    }
}