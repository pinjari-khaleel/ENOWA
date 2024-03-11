package com.neom.enowa.aem.core.models.horizontalaccordion;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HorizontalAccordionTabList {

    @ChildResource
    private String icon;
    @ChildResource
    private String iconAlternative;
    @ChildResource
    private String title;
    @ChildResource
    private String description;

    @ChildResource
    private String assetType;

    @ChildResource
    private String assetImage;
    @ChildResource
    private String imageAlt;
    @ChildResource
    private String video;
    @ChildResource
    private String videoAlt;

    public String getIcon() {
        return icon;
    }

    public String getIconAlternative() {
        return iconAlternative;
    }

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

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setIconAlternative(String iconAlternative) {
        this.iconAlternative = iconAlternative;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
