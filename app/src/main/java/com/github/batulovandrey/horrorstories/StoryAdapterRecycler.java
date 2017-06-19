package com.github.batulovandrey.horrorstories;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * @author Batulov Andrey on 19.06.17.
 */

public class StoryAdapterRecycler extends RecyclerView.Adapter<StoryAdapterRecycler.NumberViewHolder> {
    private final ListItemClickListener mOnClickListener;
    private int mNumberItems;
    private List<Story> storiesAdapter;

    public StoryAdapterRecycler(int numberItems, ListItemClickListener onClickListener) {
        mNumberItems = numberItems;
        mOnClickListener = onClickListener;
    }

    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    public void setStoriesList(List<Story> stories) {
        storiesAdapter = stories;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView listItemStoryName;
        TextView listItemStoryText;

        public NumberViewHolder(View itemView) {
            super(itemView);

            listItemStoryName = (TextView) itemView.findViewById(R.id.list_item_story_name);
            listItemStoryText = (TextView) itemView.findViewById(R.id.list_item_story_text);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }

        void bind(int indexOfStory) {
            Story story = StoryAdapter.getStoryById(indexOfStory);

            listItemStoryName.setText(story.getName());
            listItemStoryText.setText(story.getText());
        }
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}
