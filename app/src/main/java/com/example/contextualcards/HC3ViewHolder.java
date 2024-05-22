package com.example.contextualcards;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.contextualcards.models.Card;
import com.example.contextualcards.models.Entity;
import com.example.contextualcards.models.FormattedText;

public class HC3ViewHolder extends RecyclerView.ViewHolder {
    ImageView icon;
    TextView title;
    TextView description;
    Button actionButton;

    public HC3ViewHolder(@NonNull View itemView) {
        super(itemView);
        icon = itemView.findViewById(R.id.icon);
        title = itemView.findViewById(R.id.title);
        description = itemView.findViewById(R.id.description);
        actionButton = itemView.findViewById(R.id.actionButton);
    }

    public void bind(Card card) {
        // Bind title
        if (card.getFormattedTitle() != null) {
            title.setText(formatText(card.getFormattedTitle()));
        } else {
            title.setText(card.getTitle());
        }

        // Bind description
        if (card.getFormattedDescription() != null) {
            description.setText(formatText(card.getFormattedDescription()));
        } else {
            description.setText(card.getDescription());
        }

        // Bind icon
        if (card.getIcon() != null) {
            Glide.with(icon.getContext()).load(card.getIcon().getImageUrl()).into(icon);
            icon.setVisibility(View.VISIBLE);
        } else {
            icon.setVisibility(View.GONE);
        }

        // Bind CTA
//        if (card.getCta() != null && card.getCta().size()>0) {
//            actionButton.setText(card.getCta().get(0).getText());
//            actionButton.setBackgroundColor(Color.parseColor(card.getCta().get(0).getBgColor()));
//            actionButton.setVisibility(View.VISIBLE);
//            actionButton.setOnClickListener(v -> {
//                // Handle CTA click
//                // e.g., open URL or perform action
//            });
//        } else {
//            actionButton.setVisibility(View.GONE);
//        }

        // Bind background color or image
        if (!TextUtils.isEmpty(card.getBgColor())) {
            itemView.setBackgroundColor(Color.parseColor(card.getBgColor()));
        } else if (card.getBgImage() != null) {
            Glide.with(itemView.getContext()).load(card.getBgImage().getImageUrl()).into(new ImageViewTarget(itemView));
        }
    }
    private CharSequence formatText(FormattedText formattedText) {
        // Combine entities into a single formatted string
        StringBuilder formattedString = new StringBuilder();
        for (Entity entity : formattedText.getEntities()) {
            formattedString.append(entity.getText());
        }
        return formattedString.toString();
    }
    private static class ImageViewTarget extends com.bumptech.glide.request.target.CustomViewTarget<View, android.graphics.drawable.Drawable> {
        ImageViewTarget(View view) {
            super(view);
        }

        @Override
        protected void onResourceCleared(@Nullable android.graphics.drawable.Drawable placeholder) {
            getView().setBackground(null);
        }

        @Override
        public void onLoadFailed(@Nullable android.graphics.drawable.Drawable errorDrawable) {
            getView().setBackground(null);
        }

        @Override
        public void onResourceReady(@NonNull android.graphics.drawable.Drawable resource, @Nullable com.bumptech.glide.request.transition.Transition<? super android.graphics.drawable.Drawable> transition) {
            getView().setBackground(resource);
        }
    }
}
