package com.neom.enowa.aem.core.models.stepper;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class StepperItems {

    @ChildResource
    private String title;

    @ChildResource
    private String description;

    @ChildResource
    private String sourceImg;

    @ChildResource
    private String altImg;


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSourceImg() {
        return sourceImg;
    }

    public String getAltImg() {
        return altImg;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSourceImg(String sourceImg) {
        this.sourceImg = sourceImg;
    }

    public void setAltImg(String altImg) {
        this.altImg = altImg;
    }
}
