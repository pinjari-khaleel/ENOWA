package com.neom.enowa.aem.core.models;

import com.google.gson.Gson;
import com.neom.enowa.aem.core.models.accordionvariation.AccordionVariationItem;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.ArrayList;
import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AccordionVariation {

    @ChildResource
    private String faqTitle;

    @ChildResource
    private String limit;

    @ChildResource
    private String bgColour;

    @ChildResource
    List<AccordionVariationItem> faqItems;


    List<AccordionVariationItems> variationItems = new ArrayList<>();



    public String getFaqTitle() {
        return faqTitle;
    }

    public String getLimit() {
        return limit;
    }

    public String getBgColour() {
        return bgColour;
    }

    public List<AccordionVariationItem> getFaqItems() {
        return faqItems;
    }

    public List<AccordionVariationItems> getVariationItems() {
        for (int i = 0; i < faqItems.size(); i++) {
            variationItems.add(new AccordionVariationItems(faqItems.get(i).getQuestionTitle(),faqItems.get(i).getFaqDescription(),Integer.toString(i+1)));
        }
        return variationItems;
    }


    public String getFaqItemsString() {
        return new Gson().toJson(faqItems);
    }

    public void setFaqTitle(String faqTitle) {
        this.faqTitle = faqTitle;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public void setBgColour(String bgColour) {
        this.bgColour = bgColour;
    }

    public void setFaqItems(List<AccordionVariationItem> faqItems) {
        this.faqItems = faqItems;
    }

    public void setVariationItems(List<AccordionVariationItems> variationItems) {
        this.variationItems = variationItems;
    }
}