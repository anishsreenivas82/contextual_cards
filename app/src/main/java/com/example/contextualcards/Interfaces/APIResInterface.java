package com.example.contextualcards.Interfaces;

import com.example.contextualcards.models.Asset;
import com.example.contextualcards.models.CardGroup;

import java.util.List;

public interface APIResInterface {
    int getId();
    String getSlug();
    String getTitle();
    String getFormattedTitle();
    String getDescription();
    String getFormattedDescription();
    List<Asset> getAssets();
    List<CardGroup> getHcGroups();
}

