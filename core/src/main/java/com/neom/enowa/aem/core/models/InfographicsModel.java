package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.infographics.InfographicsModelTabList;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.annotation.PostConstruct;
import java.util.List;


@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class InfographicsModel {
    private static final Logger LOGGER = LoggerFactory.getLogger(InfographicsModel.class);

    @ChildResource
    private String headerTitle;
    @ChildResource
    private String headerDescription;

    @ChildResource
    @Default(values = "h1")
    private String hType;

    @ChildResource
    private String cssStyle;

    @ChildResource
    private String image;
    @ChildResource
    private String imageAlternativeText;

    @ChildResource
    public List<InfographicsModelTabList> infographicsModelTabLists;


    @PostConstruct
    protected void init() {
        applyFontSize(hType);
    }

    protected void applyFontSize(String type) {
        switch (type) {
            case "h2":
                cssStyle = "cmp-title--title-level-2";
                break;
            case "h3":
                cssStyle = "cmp-title--title-level-3";
                break;
            case "h4":
                cssStyle = "cmp-title--title-level-4";
                break;
            case "h5":
                cssStyle = "cmp-title--title-level-5";
                break;
            case "h6":
                cssStyle = "cmp-title--title-level-6";
                break;
            default:
                cssStyle = "cmp-title--title-level-1";
        }
    }

    public String getImage() {
        return image;
    }

    public String getImageAlternativeText() {
        return imageAlternativeText;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public String getHeaderDescription() {
        return headerDescription;
    }

    public String gethType() {
        return hType;
    }

    public String getCssStyle() {
        return cssStyle;
    }

    public List<InfographicsModelTabList> getInfographicsModelTabLists() {
        return infographicsModelTabLists;
    }

    public void sethType(String hType) {
        this.hType = hType;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public void setHeaderDescription(String headerDescription) {
        this.headerDescription = headerDescription;
    }

    public void setCssStyle(String cssStyle) {
        this.cssStyle = cssStyle;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setImageAlternativeText(String imageAlternativeText) {
        this.imageAlternativeText = imageAlternativeText;
    }

    public void setInfographicsModelTabLists(List<InfographicsModelTabList> infographicsModelTabLists) {
        this.infographicsModelTabLists = infographicsModelTabLists;
    }
}
