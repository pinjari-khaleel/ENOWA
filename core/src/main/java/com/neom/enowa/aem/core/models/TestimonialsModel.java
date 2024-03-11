package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.testimonials.TestimonialItemModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.ArrayList;
import java.util.List;

@Model(
        adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class TestimonialsModel {

    @ChildResource
    private String bgColour;

    @ChildResource
    List<TestimonialItemModel> testItems;

    public String getBgColour() {
        return bgColour;
    }

    public List<TestimonialItemModel> getTestItems() {
        return new ArrayList<>(testItems);
    }

    public void setBgColour(String bgColour) {
        this.bgColour = bgColour;
    }

    public void setTestItems(List<TestimonialItemModel> testItems) {
        this.testItems = new ArrayList<>(testItems);
    }
}
