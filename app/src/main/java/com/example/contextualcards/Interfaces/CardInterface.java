package com.example.contextualcards.Interfaces;

import com.example.contextualcards.models.BgImage;
import com.example.contextualcards.models.Cta;
import com.example.contextualcards.models.FormattedText;
import com.example.contextualcards.models.Gradient;
import com.example.contextualcards.models.Icon;

import java.util.List;

public interface CardInterface {
    int getId();
    String getName();
    String getSlug();
    String getTitle();
    FormattedText getFormattedTitle();
    String getDescription();
    FormattedText getFormattedDescription();
    Icon getIcon();
    String getUrl();
    BgImage getBgImage();
    String getBgColor();
    Gradient getBgGradient();
    List<Cta> getCta();
    boolean isDisabled();
    boolean isShareable();
    boolean isInternal();
}
