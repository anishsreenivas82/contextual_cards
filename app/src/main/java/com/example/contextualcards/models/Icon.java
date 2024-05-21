package com.example.contextualcards.models;

public class Icon {
    private String imageType;
    private String imageUrl;
    private String webpImageUrl;
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

