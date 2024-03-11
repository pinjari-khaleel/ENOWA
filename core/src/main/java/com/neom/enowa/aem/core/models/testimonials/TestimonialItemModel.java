package com.neom.enowa.aem.core.models.testimonials;

import com.neom.enowa.aem.core.constants.Constants;
import com.neom.enowa.aem.core.utils.EnowaUtil;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

@Model(
        adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class TestimonialItemModel {

    @ChildResource
    private String titleText;

    @ChildResource
    private String sideImage;

    @ChildResource
    private String quotation;

    @ChildResource
    private String name;

    @ChildResource
    private String jobTitle;

    @ChildResource
    @Default(values = "")
    private String ctaLabel;

    @ChildResource
    private String btnRedirect;

    @SlingObject
    private ResourceResolver resourceResolver;

    public String getTitleText() {
        return titleText;
    }

    public String getSideImage() {
        return sideImage;
    }

    public String getQuotation() {
        return quotation;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getCtaLabel() {
        return ctaLabel;
    }

    public String getBtnRedirect() {
        if (EnowaUtil.isPageLink(resourceResolver, btnRedirect)) {
            return btnRedirect.concat(Constants.DOT_HTML);
        }
        return btnRedirect;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public void setSideImage(String sideImage) {
        this.sideImage = sideImage;
    }

    public void setQuotation(String quotation) {
        this.quotation = quotation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setCtaLabel(String ctaLabel) {
        this.ctaLabel = ctaLabel;
    }

    public void setBtnRedirect(String btnRedirect) {
        this.btnRedirect = btnRedirect;
    }

    public void setResourceResolver(ResourceResolver resourceResolver) {
        this.resourceResolver = resourceResolver;
    }
}
