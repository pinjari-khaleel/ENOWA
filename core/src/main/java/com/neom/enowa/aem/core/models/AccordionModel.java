package com.neom.enowa.aem.core.models;
import com.neom.enowa.aem.core.models.accordion.AccordionItem;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.List;


@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AccordionModel {

    @ChildResource
    List<AccordionItem> accordionMF;

    public List<AccordionItem> getAccordionMF() {
        return accordionMF;
    }

    public void setAccordionMF(List<AccordionItem> accordionMF) {
        this.accordionMF = accordionMF;
    }
}
