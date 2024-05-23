package com.example.contextualcards.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CardGroup {
    private int id;
    private String name;
    @SerializedName("design_type")
    private String designType;
    @SerializedName("card_type")
    private int cardType;
    private List<Card> cards;
    @SerializedName("is_scrollable")
    private boolean isScrollable;
    private int height;
    @SerializedName("is_full_width")
    private boolean isFullWidth;
    private String slug;
    private int level;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignType() {
        return designType;
    }

    public void setDesignType(String designType) {
        this.designType = designType;
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public boolean isScrollable() {
        return isScrollable;
    }

    public void setScrollable(boolean scrollable) {
        isScrollable = scrollable;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isFullWidth() {
        return isFullWidth;
    }

    public void setFullWidth(boolean fullWidth) {
        isFullWidth = fullWidth;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

