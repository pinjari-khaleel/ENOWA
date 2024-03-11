package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.constants.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;


@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FontColor {

    private String color;

    @SlingObject
    private Resource resource;

    @PostConstruct
    protected void init() {
        color = Constants.CYAN_BLUE;
        final Resource resourceParent = resource.getParent();
        if (resourceParent != null) {
            final Resource resourceParentGeneralCopy = resourceParent.getParent();
            if (resourceParentGeneralCopy != null) {
                final ValueMap valueMap = resourceParentGeneralCopy.getValueMap();
                if (StringUtils.equals(valueMap.get(Constants.SLING_RESOURCE_TYPE, String.class),
                    Constants.RESOURCE_TYPE_GENERAL_COPY) && StringUtils.equals(
                    valueMap.get("bgColor", String.class), Constants.CYAN_BLUE)) {
                    color = Constants.LIGHT_BLUE;
                }
            }
        }
    }

    public String getColor() {
        return color;
    }
}
