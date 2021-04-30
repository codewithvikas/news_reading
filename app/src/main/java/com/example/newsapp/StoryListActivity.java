package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newsapp.data.Story;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class StoryListActivity extends AppCompatActivity implements StoryClickListener, LoaderManager.LoaderCallbacks<List<Story>> {

    RecyclerView storyListRv;
    StoryAdapter storyAdapter;
    static final int STORY_LOADER_ID = 1;
    TextView errorView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storylist);
        storyListRv = findViewById(R.id.story_list_rv);
        errorView = findViewById(R.id.error_tv);
        progressBar = findViewById(R.id.progress_status);
         storyAdapter = new StoryAdapter(this,new ArrayList<>(),this);
        storyListRv.setAdapter(storyAdapter);

        storyListRv.setLayoutManager(new LinearLayoutManager(this));
        if (isInternetAvailable()){
            android.app.LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(STORY_LOADER_ID,null,this);
        }
        else {
            hideProgressBar();
           errorView.setText(R.string.no_internet);
           showErrorView();
        }


    }

    @Override
    public void onStoryClicked(String webUrl) {
        Uri uri = Uri.parse(webUrl);
        Intent openDetailStoryIntent = new Intent(Intent.ACTION_VIEW);
        openDetailStoryIntent.setData(uri);
        startActivity(openDetailStoryIntent);
    }

    @NonNull
    @Override
    public Loader<List<Story>> onCreateLoader(int id, @Nullable Bundle args) {
            Uri baseUri = Uri.parse(StoryUtils.NEWS_BASE_URL);
            Uri.Builder uriBuilder = baseUri.buildUpon();
            uriBuilder.appendQueryParameter("tag","politics/politics");
            uriBuilder.appendQueryParameter("from-date","2014-01-01");
            uriBuilder.appendQueryParameter("api-key","test");
            uriBuilder.appendQueryParameter("q","debate");
        return new StoryLoader(this,uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Story>> loader, List<Story> data) {
        hideProgressBar();
            if (data!=null){
                storyAdapter.clean();
                storyAdapter.addAll(data);
                hideErrorView();
            }
            else {
                Toast.makeText(this,"Somwthing Wrong!!!",Toast.LENGTH_SHORT).show();
                errorView.setText(R.string.error_msg);
                showErrorView();
            }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Story>> loader) {
        storyAdapter.clean();

    }

   void showErrorView(){
            errorView.setVisibility(View.VISIBLE);
            storyListRv.setVisibility(View.GONE);
    }

    void hideErrorView(){
        errorView.setVisibility(View.GONE);
        storyListRv.setVisibility(View.VISIBLE);
    }

    void hideProgressBar(){
        progressBar.setVisibility(View.GONE);
    }

    boolean isInternetAvailable(){
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}