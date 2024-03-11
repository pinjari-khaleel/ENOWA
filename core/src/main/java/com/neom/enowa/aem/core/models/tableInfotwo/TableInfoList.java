package com.neom.enowa.aem.core.models.tableInfotwo;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TableInfoList {

    private int currentPosition;
    @ChildResource
    private String sourceIcon;
    @ChildResource
    private String altIcon;
    @ChildResource
    private String title;
    @ChildResource
    private String desTitle;

    public String getSourceIcon() {
        return sourceIcon;
    }
    public String getAltIcon() {
        return altIcon;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getTitle() {
        return title;
    }
    public String getDesTitle() {
        return desTitle;
    }

    public void setSourceIcon(String sourceIcon) {
        this.sourceIcon = sourceIcon;
    }

    public void setAltIcon(String altIcon) {
        this.altIcon = altIcon;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesTitle(String desTitle) {
        this.desTitle = desTitle;
    }
}