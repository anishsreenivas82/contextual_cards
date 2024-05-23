package com.example.contextualcards.models;

import com.example.contextualcards.Interfaces.CardInterface;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Card implements CardInterface {
    private int id;
    private String name;
    private String slug;
    private String title;
    @SerializedName("formatted_title")
    private FormattedText formattedTitle;
    private String description;
    @SerializedName("formatted_description")
    private FormattedText formattedDescription;
    private Icon icon;
    private String url;
    @SerializedName("bg_image")
    private BgImage bgImage;
    @SerializedName("bg_color")
    private String bgColor;
    @SerializedName("bg_gradient")
    private Gradient bgGradient;
    private List<Cta> cta;
    @SerializedName("is_disabled")
    private boolean isDisabled;
    @SerializedName("is_shareable")
    private boolean isShareable;
    @SerializedName("is_internal")
    private boolean isInternal;
    private String designType;
    private boolean isScrollable;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isScrollable() {
        return isScrollable;
    }
    public void setScrollable(boolean scrollable) {
        isScrollable = scrollable;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public FormattedText getFormattedTitle() {
        return formattedTitle;
    }

    public void setFormattedTitle(FormattedText formattedTitle) {
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
    public FormattedText getFormattedDescription() {
        return formattedDescription;
    }

    public void setFormattedDescription(FormattedText formattedDescription) {
        this.formattedDescription = formattedDescription;
    }

    @Override
    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public BgImage getBgImage() {
        return bgImage;
    }

    public void setBgImage(BgImage bgImage) {
        this.bgImage = bgImage;
    }

    @Override
    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    @Override
    public Gradient getBgGradient() {
        return bgGradient;
    }

    public void setBgGradient(Gradient bgGradient) {
        this.bgGradient = bgGradient;
    }

    @Override
    public List<Cta> getCta() {
        return cta;
    }


    public String getDesignType() {
        return designType;
    }

    public void setDesignType(String designType) {
        this.designType = designType;
    }

    public void setCta(List<Cta> cta) {
        this.cta = cta;
    }

    @Override
    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    @Override
    public boolean isShareable() {
        return isShareable;
    }

    public void setShareable(boolean shareable) {
        isShareable = shareable;
    }

    @Override
    public boolean isInternal() {
        return isInternal;
    }

    public void setInternal(boolean internal) {
        isInternal = internal;
    }
}

