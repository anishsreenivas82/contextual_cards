package com.example.contextualcards.models;

import com.google.gson.annotations.SerializedName;

public class Icon {
    @SerializedName("image_type")
    private String imageType;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("webp_image_url")
    private String webpImageUrl;
    @SerializedName("aspect_ratio")
    private float aspectRatio;

    // Getters and Setters
    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWebpImageUrl() {
        return webpImageUrl;
    }

    public void setWebpImageUrl(String webpImageUrl) {
        this.webpImageUrl = webpImageUrl;
    }

    public float getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(float aspectRatio) {
        this.aspectRatio = aspectRatio;
    }
}

