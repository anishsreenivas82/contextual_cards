package com.example.contextualcards.fragments;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contextualcards.R;
import com.example.contextualcards.models.Card;
import com.example.contextualcards.models.Cta;
import com.example.contextualcards.models.Entity;
import com.example.contextualcards.models.FormattedText;
import com.example.contextualcards.utils.CtaUtils;
import com.example.contextualcards.utils.TextUtils;

public class Hc6ViewHolder extends RecyclerView.ViewHolder{
    TextView title;
    CardView cardContainer;
    public Hc6ViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.hc6_title);
        cardContainer = itemView.findViewById(R.id.hc6_card);
    }
    public View bind(Card card) {
        // Bind title
        if(card.getFormattedTitle() != null)
            title.setText(TextUtils.formatText(card.getFormattedTitle()));
        else if(card.getTitle() != null)
            title.setText(card.getTitle());
        // Bind background
        if(card.getBgColor()!="" && card.getBgColor()!=null)
            cardContainer.setCardBackgroundColor(android.graphics.Color.parseColor(card.getBgColor()));

        cardContainer.setOnClickListener(v->{
            if(card.getUrl()!=null)
                CtaUtils.openUrl(card.getUrl(),v.getContext());
        });

        return itemView;
    }
}
