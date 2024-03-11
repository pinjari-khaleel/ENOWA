package com.neom.enowa.aem.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.annotation.PostConstruct;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.sling.api.SlingHttpServletRequest;

import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = SlingHttpServletRequest.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class InfoGraphicModel {

    private static final Logger log = LoggerFactory.getLogger(InfoGraphicModel.class);

    @SlingObject
    private Resource componentResource;

    @ChildResource
    private String displayNumber;

    public String getDisplayNumber() {
        return displayNumber;
    }

    private List<Map<String, String>> tabLists = new ArrayList<>();

    public List<Map<String, String>> getTabLists() {
        return new ArrayList<>(tabLists);
    }

    @PostConstruct
    protected void init() {

        Resource support = componentResource.getChild("tabLists");

        if (support!=null){
            for (Resource supports : support.getChildren()){
                tabLists.add(getStringMultiData(supports));
            }
        }

    }

    public Map<String, String> getStringMultiData(Resource supports){
        Map<String, String> multiData = new HashMap<>();

        multiData.put("title",
                supports.getValueMap().get("title",String.class));
        multiData.put("description",
                supports.getValueMap().get("description",String.class));
        multiData.put("cta",
                supports.getValueMap().get("cta",String.class));
        multiData.put("link",
                supports.getValueMap().get("link",String.class));
        multiData.put("borderColor",
                supports.getValueMap().get("borderColor",String.class));
        multiData.put("assetType",
                supports.getValueMap().get("assetType",String.class));
        multiData.put("assetImage",
                supports.getValueMap().get("assetImage",String.class));
        multiData.put("imageAlt",
                supports.getValueMap().get("imageAlt",String.class));
        multiData.put("videoBackgroundImage",
                supports.getValueMap().get("videoBackgroundImage",String.class));
        multiData.put("videoBackgroudImageAlt",
                supports.getValueMap().get("videoBackgroudImageAlt",String.class));

       return multiData;
    }

    public void setComponentResource(Resource componentResource) {
        this.componentResource = componentResource;
    }

    public void setDisplayNumber(String displayNumber) {
        this.displayNumber = displayNumber;
    }

    public void setTabLists(List<Map<String, String>> tabLists) {
        this.tabLists = new ArrayList<>(tabLists);
    }

    public Resource getComponentResource() {
        return componentResource;
    }
}
