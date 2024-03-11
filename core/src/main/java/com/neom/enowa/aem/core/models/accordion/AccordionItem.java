package com.neom.enowa.aem.core.models.accordion;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AccordionItem {

    @ChildResource
    private String title;

    @ChildResource
    List<DisplayItem> descriptionMF;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DisplayItem> getDescriptionMF() {
        return descriptionMF;
    }

    public void setDescriptionMF(List<DisplayItem> descriptionMF) {
        this.descriptionMF = descriptionMF;
    }

    public AccordionItem() {
    }

    public AccordionItem(String title) {
        this.title = title;

    }
}

