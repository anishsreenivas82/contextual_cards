package com.example.contextualcards.fragments;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contextualcards.R;
import com.example.contextualcards.models.Card;
import com.example.contextualcards.models.Entity;
import com.example.contextualcards.models.FormattedText;
import com.example.contextualcards.utils.TextUtils;

public class Hc1ViewHolder extends RecyclerView.ViewHolder{
    TextView title;
    TextView description;
    public Hc1ViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.hc1_title);
        description = itemView.findViewById(R.id.hc1_description);
    }

    public View bind(Card card) {
        // Bind title
        if(card.getFormattedTitle() != null)
            title.setText(TextUtils.formatText(card.getFormattedTitle()));
        else if(card.getTitle() != null)
            title.setText(card.getTitle());
        // Bind description
        if(card.getFormattedDescription() != null)
            description.setText(TextUtils.formatText(card.getFormattedDescription()));
        else if(card.getDescription() != null)
            description.setText(card.getDescription());
        return itemView;
    }
}
