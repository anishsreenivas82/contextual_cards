package com.example.contextualcards.utils;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.contextualcards.models.Gradient;

import java.util.List;

public class BackgroundUtils {

    public static void setBackground(View view, String bgColor, Gradient bgGradient, String bgImageUrl) {
        if (bgGradient != null) {
            setGradientBackground(view, bgGradient);
        } else if (bgColor != null && !bgColor.trim().isEmpty()) {
            try {
                view.setBackgroundColor(Color.parseColor(bgColor.trim()));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                // Handle error or set a default color
            }
        } else if (bgImageUrl != null && !bgImageUrl.trim().isEmpty()) {
            Glide.with(view.getContext()).load(bgImageUrl.trim()).into(new ImageViewTarget(view));
        }
    }

    private static void setGradientBackground(View view, Gradient bgGradient) {
        if (bgGradient == null || bgGradient.getColors() == null || bgGradient.getColors().isEmpty()) {
            return;
        }

        // Convert colors from hex to int
        int[] colors = new int[bgGradient.getColors().size()];
        try {
            for (int i = 0; i < bgGradient.getColors().size(); i++) {
                colors[i] = Color.parseColor(bgGradient.getColors().get(i).trim());
            }
        } catch (IllegalArgumentException e) {
            // Handle the error: you might want to log it or use default colors
            e.printStackTrace();
            return;
        }

        // Create GradientDrawable
        GradientDrawable gradientDrawable = new GradientDrawable(
                getOrientation(bgGradient.getAngle()),
                colors
        );

        view.setBackground(gradientDrawable);
    }

    private static GradientDrawable.Orientation getOrientation(int angle) {
        switch (angle) {
            case 0:
                return GradientDrawable.Orientation.LEFT_RIGHT;
            case 45:
                return GradientDrawable.Orientation.BL_TR;
            case 90:
                return GradientDrawable.Orientation.BOTTOM_TOP;
            case 135:
                return GradientDrawable.Orientation.BR_TL;
            case 180:
                return GradientDrawable.Orientation.RIGHT_LEFT;
            case 225:
                return GradientDrawable.Orientation.TR_BL;
            case 270:
                return GradientDrawable.Orientation.TOP_BOTTOM;
            case 315:
                return GradientDrawable.Orientation.TL_BR;
            default:
                return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    private static class ImageViewTarget extends com.bumptech.glide.request.target.CustomViewTarget<View, android.graphics.drawable.Drawable> {
        ImageViewTarget(View view) {
            super(view);
        }

        @Override
        protected void onResourceCleared(@Nullable android.graphics.drawable.Drawable placeholder) {
            // TODO:Remove the background or set a default background
//            getView().setBackground(null);
        }

        @Override
        public void onLoadFailed(@Nullable android.graphics.drawable.Drawable errorDrawable) {
            //TODO: Handle error or set a default background
            Toast.makeText(getView().getContext(), "Failed to load image", Toast.LENGTH_SHORT).show();
//            getView().setBackground(null);
        }

        @Override
        public void onResourceReady(@NonNull android.graphics.drawable.Drawable resource, @Nullable com.bumptech.glide.request.transition.Transition<? super android.graphics.drawable.Drawable> transition) {
            getView().setBackground(resource);
        }
    }
}


