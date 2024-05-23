package com.example.contextualcards.utils;

import static androidx.core.content.res.ResourcesCompat.getFont;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.util.Log;

import com.example.contextualcards.models.Entity;
import com.example.contextualcards.models.FormattedText;

public class TextUtils {

    public static SpannableStringBuilder formatText(FormattedText formattedText) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();

        if (formattedText != null && formattedText.getText() != null && formattedText.getEntities() != null) {
            String baseText = formattedText.getText();
            int entityIndex = 0;
            Log.d("baseText",baseText);
            if(baseText.equals(" ")){
                baseText = "{}";
            }
            while (baseText.contains("{}") && entityIndex < formattedText.getEntities().size()) {
                int start = baseText.indexOf("{}");
                int end = start + 2;
                Entity entity = formattedText.getEntities().get(entityIndex);

                // Append the text before the placeholder
                spannableStringBuilder.append(baseText.substring(0, start));

                // Create the spannable string for the entity
                SpannableString spannableString = new SpannableString(entity.getText());
                if (entity.getColor() != null) {
                    spannableString.setSpan(new ForegroundColorSpan(android.graphics.Color.parseColor(entity.getColor().trim())), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                if (entity.getFontSize() > 0) {
                    spannableString.setSpan(new AbsoluteSizeSpan(entity.getFontSize(), true), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                if (entity.getFontFamily() != null) {
                    Typeface typeface = Typeface.create(entity.getFontFamily(), Typeface.NORMAL);
                    spannableString.setSpan(new TypefaceSpan(typeface), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                if ("bold".equalsIgnoreCase(entity.getFontStyle())) {
                    spannableString.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                } else if ("italic".equalsIgnoreCase(entity.getFontStyle())) {
                    spannableString.setSpan(new StyleSpan(android.graphics.Typeface.ITALIC), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                } else if ("underline".equalsIgnoreCase(entity.getFontStyle())) {
                    spannableString.setSpan(new android.text.style.UnderlineSpan(), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }


                // Append the spannable string
                spannableStringBuilder.append(spannableString);

                // Update the base text
                baseText = baseText.substring(end);
                entityIndex++;
            }

            // Append any remaining text
            spannableStringBuilder.append(baseText);
        }

        return spannableStringBuilder;
    }
}

