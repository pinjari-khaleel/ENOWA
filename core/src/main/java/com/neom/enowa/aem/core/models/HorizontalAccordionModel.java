package com.neom.enowa.aem.core.models;


import com.neom.enowa.aem.core.models.horizontalaccordion.HorizontalAccordionTabList;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HorizontalAccordionModel {

    private static final Logger LOGGER = LoggerFactory.getLogger(HorizontalAccordionModel.class);



    @ChildResource
    private String title;
    @ChildResource
    private String description;
    @ChildResource
    private String itemAccordion;


    @ChildResource
    public  List<HorizontalAccordionTabList> horizontalAccordTabLists;


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    public String getItemAccordion() {
        return itemAccordion;
    }

    public List<HorizontalAccordionTabList> getHorizontalAccordTabLists() {
        return horizontalAccordTabLists;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setItemAccordion(String itemAccordion) {
        this.itemAccordion = itemAccordion;
    }
}
