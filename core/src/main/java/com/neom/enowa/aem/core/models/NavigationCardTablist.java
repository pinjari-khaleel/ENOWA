package com.neom.enowa.aem.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NavigationCardTablist {
    private static final Logger LOGGER = LoggerFactory.getLogger(NavigationCardTablist.class);


    @ChildResource
    private String title;
    @ChildResource
    private String description;
    @ChildResource
    private String linkURL;

    @ChildResource
    private String assetType;

    @ChildResource
    public String assetImage;
    @ChildResource
    public String imageAlt;
    @ChildResource
    public String videoBackgroundImage;
    @ChildResource
    public String videoBackgroudImageAlt;


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description ;
    }

    public String getAssetType() {
        return assetType;
    }

    public String getAssetImage() {
        return assetImage;
    }

    public String getImageAlt() {
        return imageAlt;
    }

    public String getVideoBackgroundImage() {
        return videoBackgroundImage;
    }

    public String getVideoBackgroudImageAlt() {
        return videoBackgroudImageAlt;
    }

    public String getLinkURL() {
        return linkURL;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLinkURL(String linkURL) {
        this.linkURL = linkURL;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public void setAssetImage(String assetImage) {
        this.assetImage = assetImage;
    }

    public void setImageAlt(String imageAlt) {
        this.imageAlt = imageAlt;
    }

    public void setVideoBackgroundImage(String videoBackgroundImage) {
        this.videoBackgroundImage = videoBackgroundImage;
    }

    public void setVideoBackgroudImageAlt(String videoBackgroudImageAlt) {
        this.videoBackgroudImageAlt = videoBackgroudImageAlt;
    }
}