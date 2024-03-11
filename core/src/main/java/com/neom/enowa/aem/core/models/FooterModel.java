package com.neom.enowa.aem.core.models;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.neom.enowa.aem.core.constants.Constants;
import com.neom.enowa.aem.core.models.footer.MediaItem;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FooterModel {

    @SlingObject
    ResourceResolver resourceResolver;

    @Inject
    private Page currentPage;

    public List<FooterItem> getFooterItems() {
        return footerItems;
    }

    List<FooterItem> footerItems = new ArrayList<>();


    @ChildResource
    private String policyText;

    @ChildResource
    private String policyLink;

    @ChildResource
    private String termsText;

    @ChildResource
    private String termsLink;

    @ChildResource
    private String cookieText;

    @ChildResource
    private String cookieLink;
    @ChildResource
    private String copyRight;

    @ChildResource
    private String numberLevel;

    @ChildResource
    List<MediaItem> mediaItems;



    private int footerItemSize;
    public String getPolicyText() {
        return policyText;
    }

    public String getPolicyLink() {
        if(policyLink.startsWith(Constants.SLASH) && !policyLink.endsWith(Constants.DOT_HTML)){
            policyLink = policyLink.concat(Constants.DOT_HTML);
        }
        return policyLink;
    }

    public String getTermsText() {
        return termsText;
    }

    public String getTermsLink() {
        if(termsLink.startsWith(Constants.SLASH) && !termsLink.endsWith(Constants.DOT_HTML)){
            termsLink = termsLink.concat(Constants.DOT_HTML);
        }
        return termsLink;
    }

    public String getCookieText() {
        return cookieText;
    }

    public String getCookieLink() {
        if(cookieLink.startsWith(Constants.SLASH) && !cookieLink.endsWith(Constants.DOT_HTML)){
            cookieLink = cookieLink.concat(Constants.DOT_HTML);
        }
        return cookieLink;
    }

    public String getCopyRight() {
        return copyRight;
    }

    public List<MediaItem> getMediaItems() {
        return mediaItems;
    }


    @PostConstruct
    protected void init() {
        Page page = null;

        if (StringUtils.isNotBlank(numberLevel)) {
            page = currentPage.getAbsoluteParent(Integer.parseInt(numberLevel));
        } else {
            page = currentPage.getAbsoluteParent(2);
        }

        if (page == null) {
            return;
        }

        String basePath = page.getPath();
        String fullPath = currentPage.getPath();
        String relativePath = fullPath.substring(basePath.length());
        String[] pathComponents = relativePath.split("/");
        
        StringBuilder currentPath = new StringBuilder(basePath);
        int size = pathComponents.length;
        for (int i = 0; i < size; i++) {
            if (StringUtils.isNotBlank(pathComponents[i])) { // Check if the component is not empty
                currentPath.append("/").append(pathComponents[i]);
                String title = getResourcePageTitle(currentPath.toString());
                if (StringUtils.isNotBlank(title)) {
                    if (i < size - 1) {
                        footerItems.add(
                            new FooterItem(currentPath.toString().concat(Constants.DOT_HTML),
                                title));
                    } else {
                        footerItems.add(new FooterItem("#", title));
                    }
                }
            }
        }
    }

    protected String getResourcePageTitle(String pagePath) {
        String pageTitle = "";
        Resource pageResource = resourceResolver.getResource(pagePath);
        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        Page page = pageManager.getContainingPage(pageResource);
        if (page != null) {
            ValueMap valueMap = page.getProperties();
            String hideInNav = valueMap.get("hideInNav", String.class);
            if (!"true".equalsIgnoreCase(hideInNav)) { // Hide in Navigation: ignore this page
                pageTitle = page.getTitle();
            }
        }
        return pageTitle;
    }
    
    public void setPolicyText(String policyText) {
        this.policyText = policyText;
    }

    public void setPolicyLink(String policyLink) {
        this.policyLink = policyLink;
    }

    public void setTermsText(String termsText) {
        this.termsText = termsText;
    }

    public void setTermsLink(String termsLink) {
        this.termsLink = termsLink;
    }

    public void setCookieText(String cookieText) {
        this.cookieText = cookieText;
    }

    public void setCookieLink(String cookieLink) {
        this.cookieLink = cookieLink;
    }

    public void setCopyRight(String copyRight) {
        this.copyRight = copyRight;
    }

    public void setMediaItems(List<MediaItem> mediaItems) {
        this.mediaItems = mediaItems;
    }

    public void setFooterItems(List<FooterItem> footerItems) {
        this.footerItems = footerItems;
    }

    public void setFooterItemSize(int footerItemSize) {
        this.footerItemSize = footerItemSize;
    }

    public int getFooterItemSize() {
        footerItemSize = footerItems.size();
        return footerItemSize;
    }
}
