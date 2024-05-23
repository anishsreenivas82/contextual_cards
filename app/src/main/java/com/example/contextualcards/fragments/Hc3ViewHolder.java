package com.example.contextualcards.fragments;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contextualcards.R;
import com.example.contextualcards.models.Card;
import com.example.contextualcards.utils.BackgroundUtils;
import com.example.contextualcards.utils.TextUtils;

public class Hc3ViewHolder extends RecyclerView.ViewHolder {
    ImageView icon;
    TextView title;
    TextView description;
    View cardContainer;
    Button actionButton;

    public Hc3ViewHolder(@NonNull View itemView) {
        super(itemView);
//        icon = itemView.findViewById(R.id.icon);
        cardContainer = itemView.findViewById(R.id.hc3_card);
        title = itemView.findViewById(R.id.hc3_title);
        description = itemView.findViewById(R.id.hc3_description);
        actionButton = itemView.findViewById(R.id.hc3_action_button);
    }

    public View bind(Card card) {
        // Bind title
        if (card.getFormattedTitle() != null) {
            title.setText(TextUtils.formatText(card.getFormattedTitle()));
        } else {
            title.setText(card.getTitle());
        }

        // Bind description
        if (card.getFormattedDescription() != null) {
            description.setText(TextUtils.formatText(card.getFormattedDescription()));
        } else {
            description.setText(card.getDescription());
        }

        // Bind icon
//        if (card.getIcon() != null) {
//            Glide.with(icon.getContext()).load(card.getIcon().getImageUrl()).into(icon);
//            icon.setVisibility(View.VISIBLE);
//        } else {
//            icon.setVisibility(View.GONE);
//        }

        // Bind CTA
        if (card.getCta() != null && card.getCta().size()>0) {
            actionButton.setText(card.getCta().get(0).getText());
            actionButton.setBackgroundColor(Color.parseColor(card.getCta().get(0).getBgColor()));
            actionButton.setVisibility(View.VISIBLE);
            actionButton.setOnClickListener(v -> {
                // Handle CTA click
                // e.g., open URL or perform action
            });
        } else {
            actionButton.setVisibility(View.GONE);
        }

        // Bind background color or image
        BackgroundUtils.setBackground(cardContainer, card.getBgColor(), card.getBgGradient(), card.getUrl());
        return itemView;
    }

}
