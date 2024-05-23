package com.example.contextualcards.fragments;

import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contextualcards.R;
import com.example.contextualcards.models.Card;
import com.example.contextualcards.utils.BackgroundUtils;
import com.example.contextualcards.utils.CtaUtils;
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

        cardContainer.setOnClickListener(v->{
            if(card.getUrl()!=null)
                CtaUtils.openUrl(card.getUrl(),v.getContext());
        });

        cardContainer.setOnLongClickListener(v->{
            final float[] start = {0.0f};
            final float[] end = {0.5f};
            Animation animation = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF, //fromXType
                    start[0],                       //fromXValue
                    Animation.RELATIVE_TO_SELF, //toXType
                    end[0],                      //toXValue
                    Animation.RELATIVE_TO_SELF, //fromYType
                    0.0f,                       //fromYValue
                    Animation.RELATIVE_TO_SELF, //toYType
                    0.0f);                      //toYValue
            animation.setDuration(500);
            animation.setFillAfter(true);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    float temp = start[0];
                    start[0] = end[0];
                    end[0] = temp;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
            cardContainer.startAnimation(animation);
            return true;
        });

        // Bind background color or image
        BackgroundUtils.setBackground(cardContainer, card.getBgColor(), card.getBgGradient(), card.getUrl());
        return itemView;
    }

}
