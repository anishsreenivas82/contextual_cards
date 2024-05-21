package com.example.contextualcards.models;

public class Cta {
    private String text;
    private String type;
    private String bgColor;
    private boolean isCircular;
    private boolean isSecondary;
    private int strokeWidth;

    // Getters and Setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public boolean isCircular() {
        return isCircular;
    }

    public void setCircular(boolean isCircular) {
        this.isCircular = isCircular;
    }

    public boolean isSecondary() {
        return isSecondary;
    }

    public void setSecondary(boolean isSecondary) {
        this.isSecondary = isSecondary;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }
}
