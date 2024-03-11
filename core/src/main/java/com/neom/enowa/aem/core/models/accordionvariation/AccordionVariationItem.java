package com.neom.enowa.aem.core.models.accordionvariation;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AccordionVariationItem {

    @ChildResource
    private String questionTitle;

    @ChildResource
    private String faqDescription;

    public String getQuestionTitle() {
        return questionTitle;
    }

    public String getFaqDescription() {
        return faqDescription;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public void setFaqDescription(String faqDescription) {
        this.faqDescription = faqDescription;
    }
}
