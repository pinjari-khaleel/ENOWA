package com.neom.enowa.aem.core.models;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class InfographicsModelTablist {

    @ChildResource
    private String image;
    @ChildResource
    private String imageAlternativeText;
    @ChildResource
    private String title;
    @ChildResource
    private String description;

    public String getImage() {
        return image;
    }

    public String getImageAlternativeText() {
        return imageAlternativeText;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setImageAlternativeText(String imageAlternativeText) {
        this.imageAlternativeText = imageAlternativeText;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
