package com.example.contextualcards.fragments;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contextualcards.R;
import com.example.contextualcards.models.Card;
import com.example.contextualcards.utils.BackgroundUtils;
import com.example.contextualcards.utils.CtaUtils;

public class Hc9ViewHolder extends RecyclerView.ViewHolder{
    CardView cardContainer;
    public Hc9ViewHolder(@NonNull View itemView) {
        super(itemView);
        cardContainer = itemView.findViewById(R.id.hc9_card);
    }
    public View bind(Card card) {
        // Bind background
        if(card.getBgImage()!=null){
            float aspectRatio = card.getBgImage().getAspectRatio();
            if(aspectRatio!=0){
                cardContainer.getLayoutParams().width = (int) (cardContainer.getLayoutParams().height * aspectRatio);
                cardContainer.setLayoutParams(cardContainer.getLayoutParams());
            }

        }
        BackgroundUtils.setBackground(cardContainer, card.getBgColor(), card.getBgGradient(), card.getUrl());
        cardContainer.setOnClickListener(v->{
            if(card.getUrl()!=null)
                CtaUtils.openUrl(card.getUrl(),v.getContext());
        });
        return itemView;
    }
}
