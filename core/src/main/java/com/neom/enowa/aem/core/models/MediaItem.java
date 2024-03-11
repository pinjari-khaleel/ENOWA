package com.neom.enowa.aem.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MediaItem {

    @ChildResource
    private String mediaTitle;
    @ChildResource
    private String mediaLink;

    public String getMediaTitle() {
        return mediaTitle;
    }

    public String getMediaLink() {
        return mediaLink;
    }

    public void setMediaTitle(String mediaTitle) {
        this.mediaTitle = mediaTitle;
    }

    public void setMediaLink(String mediaLink) {
        this.mediaLink = mediaLink;
    }
}
