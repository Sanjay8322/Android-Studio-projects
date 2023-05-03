package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorId;
    public WordAdapter(Activity context, ArrayList<Word> words,int colorID){
        super(context,0,words);
        this.mColorId=colorID;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        /**
         * Get the {@link AndroidFlavor} object located at this position in the list
         */
        Word currentWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.mikow_text_view);
        miwokTextView.setText(currentWord.getmMiwokTranslation());


        TextView deafultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        deafultTextView.setText(currentWord.getmDefaultTranslation());

        ImageView iconView=(ImageView) listItemView.findViewById(R.id.imageId);
        if(currentWord.hasImage()){
            iconView.setImageResource(currentWord.getmImageResourceId());
            iconView.setVisibility(View.VISIBLE);
        }else{
            iconView.setVisibility(View.GONE);
        }

        View textContainer=listItemView.findViewById(R.id.text_container);
        int color= ContextCompat.getColor(getContext(),mColorId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }

}
