package com.example.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.newsapp.data.Story;

import java.util.List;

public class StoryLoader extends AsyncTaskLoader<List<Story>> {

    String urlString;
    public StoryLoader(@NonNull Context context,String urlString) {
        super(context);
        this.urlString = urlString;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<Story> loadInBackground() {
        if (urlString!=null){
            return StoryUtils.fetchStories(urlString);
        }
       return null;
    }
}
