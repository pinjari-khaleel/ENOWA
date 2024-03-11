package com.neom.enowa.aem.core.models.footer;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import javax.annotation.PostConstruct;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MediaItem {

    @ChildResource
    private String mediaTitle;
    @ChildResource
    private String mediaLink;



@PostConstruct
        protected String init(){

    if (!mediaLink.startsWith("http://") && !mediaLink.startsWith("https://")) {
        mediaLink = "https://" + mediaLink;
    }
    return mediaLink;
}
    public String getMediaTitle() {

        return mediaTitle;
    }
    public void setMediaLink(String mediaLink) {
        this.mediaLink = mediaLink;
    }

    public String getMediaLink() {
        return mediaLink;
    }

    public MediaItem(String mediaTitle) {
        this.mediaTitle = mediaTitle;
    }

    public MediaItem() {
    }

    public void setMediaTitle(String mediaTitle) {
        this.mediaTitle = mediaTitle;
    }


}
