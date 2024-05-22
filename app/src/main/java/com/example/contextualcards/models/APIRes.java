package com.example.contextualcards.models;

import com.example.contextualcards.Interfaces.APIResInterface;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class APIRes implements APIResInterface {
    @SerializedName("id")
    private int id;
    @SerializedName("slug")
    private String slug;
    @SerializedName("title")
    private String title;
    @SerializedName("formatted_title")
    private String formattedTitle;
    @SerializedName("description")
    private String description;
    @SerializedName("formatted_description")
    private String formattedDescription;
    @SerializedName("assets")
    private List<Asset> assets;
    @SerializedName("hc_groups")
    private List<CardGroup> hcGroups;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getFormattedTitle() {
        return formattedTitle;
    }

    public void setFormattedTitle(String formattedTitle) {
        this.formattedTitle = formattedTitle;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getFormattedDescription() {
        return formattedDescription;
    }

    public void setFormattedDescription(String formattedDescription) {
        this.formattedDescription = formattedDescription;
    }

    @Override
    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    @Override
    public List<CardGroup> getHcGroups() {
        return hcGroups;
    }

    public void setHcGroups(List<CardGroup> hcGroups) {
        this.hcGroups = hcGroups;
    }
}

