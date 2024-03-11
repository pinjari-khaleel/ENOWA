package com.neom.enowa.aem.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

/**
 * The type VideoComponent model.
 */
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class VideoComponentModel {

    @ChildResource
    private String title;
    @ChildResource
    private String description;
    @ChildResource
    private String video;
    @ChildResource
    private String videoBackgroundAlt;

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets video.
     *
     * @return the video
     */
    public String getVideo() {
        return video;
    }

    /**
     * Gets video background alt.
     *
     * @return the video background alt
     */
    public String getVideoBackgroundAlt() {
        return videoBackgroundAlt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setVideoBackgroundAlt(String videoBackgroundAlt) {
        this.videoBackgroundAlt = videoBackgroundAlt;
    }
}
