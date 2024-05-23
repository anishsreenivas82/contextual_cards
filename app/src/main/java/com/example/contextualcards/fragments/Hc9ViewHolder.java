package com.example.contextualcards.fragments;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contextualcards.R;
import com.example.contextualcards.models.Card;
import com.example.contextualcards.utils.BackgroundUtils;

public class Hc9ViewHolder extends RecyclerView.ViewHolder{
    CardView cardContainer;
    public Hc9ViewHolder(@NonNull View itemView) {
        super(itemView);
        cardContainer = itemView.findViewById(R.id.hc9_card);
    }
    public View bind(Card card) {
        // Bind background
        BackgroundUtils.setBackground(cardContainer, card.getBgColor(), card.getBgGradient(), card.getUrl());
        return itemView;
    }
}
