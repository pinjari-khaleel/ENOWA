package com.neom.enowa.aem.core.models.navigationcard;

import com.neom.enowa.aem.core.constants.Constants;
import com.neom.enowa.aem.core.utils.EnowaUtil;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NavigationCardTabLists {
    private static final Logger LOGGER = LoggerFactory.getLogger(NavigationCardTabLists.class);


    @ChildResource
    private String title;
    @ChildResource
    private String description;
    @ChildResource
    private String linkURL;

    @ChildResource
    private String assetType;

    @ChildResource
    public String assetImage;

    @ChildResource
    public String imageAlt;

    @ChildResource
    private String videoBackgroundImage;
    @ChildResource
    private String videoBackgroundImageAlt;

    @SlingObject
    private ResourceResolver resourceResolver;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description ;
    }

    public String getAssetType() {
        return assetType;
    }

    public String getAssetImage() {
        return assetImage;
    }

    public String getImageAlt() {
        return imageAlt;
    }

    public String getVideoBackgroundImage() {
        return videoBackgroundImage;
    }


    public String getLinkURL() {

        if (EnowaUtil.isPageLink(resourceResolver, linkURL)) {
            return linkURL + Constants.DOT_HTML;
        }
        return linkURL;

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLinkURL(String linkURL) {
        this.linkURL = linkURL;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public void setAssetImage(String assetImage) {
        this.assetImage = assetImage;
    }

    public void setImageAlt(String imageAlt) {
        this.imageAlt = imageAlt;
    }

    public void setVideoBackgroundImage(String videoBackgroundImage) {
        this.videoBackgroundImage = videoBackgroundImage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoBackgroundImageAlt() {
        return videoBackgroundImageAlt;
    }

    public void setVideoBackgroundImageAlt(String videoBackgroundImageAlt) {
        this.videoBackgroundImageAlt = videoBackgroundImageAlt;
    }

    public void setResourceResolver(ResourceResolver resourceResolver) {
        this.resourceResolver = resourceResolver;
    }
}