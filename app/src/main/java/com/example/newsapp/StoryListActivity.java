package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.newsapp.data.Story;

import java.util.ArrayList;

public class StoryListActivity extends AppCompatActivity implements StoryClickListener {

    RecyclerView storyListRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storylist);
        storyListRv = findViewById(R.id.story_list_rv);

        StoryAdapter storyAdapter = new StoryAdapter(this,new ArrayList<>(),this);

        ArrayList<Story> stories = StoryUtils.fetchStories(StoryUtils.STORY_JSON);
        if (stories!=null){
            storyAdapter.addAll(stories);
        }
        storyListRv.setAdapter(storyAdapter);

        storyListRv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onStoryClicked(String webUrl) {
        Uri uri = Uri.parse(webUrl);
        Intent openDetailStoryIntent = new Intent(Intent.ACTION_VIEW);
        openDetailStoryIntent.setData(uri);
        startActivity(openDetailStoryIntent);
    }
}