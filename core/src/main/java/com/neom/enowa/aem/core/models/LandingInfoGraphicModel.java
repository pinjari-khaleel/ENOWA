package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.landinginfographic.LandingInfographicLists;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.ArrayList;
import java.util.List;

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LandingInfoGraphicModel {

    @ChildResource
    private List<LandingInfographicLists> infographicLists;


    public List<LandingInfographicLists> getInfographicLists() {
        return new ArrayList<>(infographicLists);
    }

    public void setInfographicLists(List<LandingInfographicLists> infographicLists) {
        this.infographicLists = new ArrayList<>(infographicLists);
    }
}
