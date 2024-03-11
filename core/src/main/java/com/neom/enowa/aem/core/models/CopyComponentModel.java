package com.neom.enowa.aem.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;


@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CopyComponentModel {

    @ChildResource
    private String title;
    @ChildResource
    private String bigTitle;
    @ChildResource
    private String headerTitle;
    @ChildResource
    private String text;
    @ChildResource
    private String assetType;
    @ChildResource
    public String image;
    @ChildResource
    public String imageAlt;
    @ChildResource
    private String sourceGif;
    @ChildResource
    private String altGif;
    @ChildResource
    public String video;
    @ChildResource
    public String videoAlt;
    @ChildResource
    private String borderColor;


    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getVideoAlt() {
        return videoAlt;
    }

    public void setVideoAlt(String videoAlt) {
        this.videoAlt = videoAlt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }
    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public String getBigTitle() {
        return bigTitle;
    }

    public void setBigTitle(String bigTitle) {
        this.bigTitle = bigTitle;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getAssetType() {
        return assetType;
    }

    public String getImageAlt() {
        return imageAlt;
    }

    public String getSourceGif() {
        return sourceGif;
    }

    public String getAltGif() {
        return altGif;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public void setImageAlt(String imageAlt) {
        this.imageAlt = imageAlt;
    }

    public void setSourceGif(String sourceGif) {
        this.sourceGif = sourceGif;
    }

    public void setAltGif(String altGif) {
        this.altGif = altGif;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }
}