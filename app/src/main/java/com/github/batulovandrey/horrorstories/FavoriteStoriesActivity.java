package com.github.batulovandrey.horrorstories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class FavoriteStoriesActivity extends AppCompatActivity implements StoryAdapterRecycler.ListItemClickListener {
    private static List<Story> favoriteStories;
    private StoryAdapterRecycler mStoryAdapterRecycler;

    private RecyclerView mNumbersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_stories);

        showBackButton();

        mNumbersList = (RecyclerView) findViewById(R.id.list_numbers);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNumbersList.setLayoutManager(layoutManager);
        mNumbersList.setHasFixedSize(true);

        mStoryAdapterRecycler = new StoryAdapterRecycler(favoriteStories.size(), this);
        mStoryAdapterRecycler.setStoriesList(favoriteStories);
        mNumbersList.setAdapter(mStoryAdapterRecycler);

    }

    private void showBackButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        //TODO: need to create intent, putExtra("name and text of story") and call start new StoryActivity
    }

    public static boolean addNewStoryToFavorite(Story story) {
        if (!favoriteStories.contains(story)) {
            favoriteStories.add(story);
            return true;
        }
        return false;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
