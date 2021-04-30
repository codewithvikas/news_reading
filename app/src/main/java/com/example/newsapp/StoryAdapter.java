package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.data.Story;

import java.util.ArrayList;
import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {

    ArrayList<Story> stories;
    Context context;
    StoryClickListener storyClickListener;

    public StoryAdapter(Context context, ArrayList<Story> stories,StoryClickListener storyClickListener) {
        this.stories = stories;
        this.context = context;
        this.storyClickListener = storyClickListener;
    }

    public void addAll(List<Story> s){
        stories.clear();
        stories.addAll(s);
        notifyDataSetChanged();
    }
    public void clean(){
        stories.clear();
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.story_list_item,parent,false);
        return new StoryViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {

        Story story = stories.get(position);

        holder.sectionView.setText(story.getSection());
        holder.titleView.setText(story.getTitle());

        if (story.getSection()!=null){
            holder.sectionView.setText(story.getSection());
        }

        if (story.hasAuthor()){
            holder.authorView.setText(story.getAuthor());
        }
        if (story.hasPublishedDate()){
            holder.publishedDateView.setText(story.getPublishedDate());
        }
        if (story.hasType()){
            holder.typeView.setText(story.getType());
        }

        holder.itemView.setOnClickListener(view -> storyClickListener.onStoryClicked(story.getWebUrl()));
    }

    @Override
    public int getItemCount() {
        if (stories!=null){
            return stories.size();
        }
        return 0;
    }

    class StoryViewHolder extends RecyclerView.ViewHolder{

            TextView sectionView;
            TextView titleView;
            TextView authorView;
            TextView publishedDateView;
            TextView typeView;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            sectionView = itemView.findViewById(R.id.section_tv);
            titleView = itemView.findViewById(R.id.title_tv);
            authorView = itemView.findViewById(R.id.author_tv);
            publishedDateView = itemView.findViewById(R.id.published_date_tv);
            typeView = itemView.findViewById(R.id.type_tv);


        }

    }
}
