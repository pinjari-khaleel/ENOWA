package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.constants.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import javax.annotation.PostConstruct;


@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class GeneralCopy {

    @ChildResource
    private String bgColor;

    private String color;

    @PostConstruct
    protected void init() {
        color = Constants.CYAN_BLUE;
        if (StringUtils.equals(bgColor, Constants.CYAN_BLUE)) {
            color = Constants.LIGHT_BLUE;
        }
    }

    public String getColor() {
        return color;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBgColor() {
        return bgColor;
    }
}
