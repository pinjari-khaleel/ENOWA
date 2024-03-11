package com.neom.enowa.aem.core.models;


import com.neom.enowa.aem.core.models.navigationcard.NavigationCardTabLists;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NavigationCardModel {

    public String getBlockTitle() {
        return blockTitle;
    }

    public List<NavigationCardTabLists> getNavigationCardTabLists() {
        return navigationCardTabLists;
    }

    @ChildResource
    private String blockTitle;


    @ChildResource
    public  List<NavigationCardTabLists> navigationCardTabLists;

    public void setBlockTitle(String blockTitle) {
        this.blockTitle = blockTitle;
    }

    public void setNavigationCardTabLists(List<NavigationCardTabLists> navigationCardTabLists) {
        this.navigationCardTabLists = navigationCardTabLists;
    }
}
