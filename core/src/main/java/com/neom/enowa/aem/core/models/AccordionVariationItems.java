package com.neom.enowa.aem.core.models;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;


@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AccordionVariationItems {
    public AccordionVariationItems(String questionTitle, String faqDescription, String count) {
        this.questionTitle = questionTitle;
        this.faqDescription = faqDescription;
        this.count = count;
    }
    private String questionTitle;
    private String faqDescription;
    private String count;

    public String getQuestionTitle() {

        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public void setFaqDescription(String faqDescription) {
        this.faqDescription = faqDescription;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getFaqDescription() {

        return faqDescription;
    }
    public String getCount() {
        count = (Integer.parseInt(count) < 10) ? ('0' + count) : count;
        return count;
    }
}