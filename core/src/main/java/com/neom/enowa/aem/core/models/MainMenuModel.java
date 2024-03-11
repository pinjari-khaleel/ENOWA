package com.neom.enowa.aem.core.models;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.neom.enowa.aem.core.constants.Constants;
import com.neom.enowa.aem.core.models.mainmenu.NavChildItem;
import com.neom.enowa.aem.core.models.mainmenu.NavItem;
import com.neom.enowa.aem.core.utils.EnowaUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Model(adaptables = { SlingHttpServletRequest.class,
        Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MainMenuModel {

    private static final Logger LOG = LoggerFactory.getLogger(MainMenuModel.class);

    @SlingObject
    ResourceResolver resourceResolver;

    @ValueMapValue
    public String rootPath;

    @ChildResource
    private String logoPath;

    @ChildResource
    private String homePagePath;

    @Inject
    Page currentPage;

    private String templateTheme;

    List<NavItem> navItems = new ArrayList<>();

    @PostConstruct
    protected void init() {

        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        Page homepage = pageManager.getPage(rootPath);
        if (homepage == null) {
            LOG.error("cannot load page with given path [{}]", rootPath);
            return;
        }

        Iterator<Page> childPages = homepage.listChildren();
        while (childPages.hasNext()) {
            Page childPage = childPages.next();
            NavItem navItem = new NavItem();
            navItem.setTitle(childPage.getTitle());
            navItem.setPath(childPage.getPath());

            String path = childPage.getPath() + "/jcr:content";
            Resource resource = resourceResolver.getResource(path);
            if (resource == null) {
                LOG.error("cannot load resource with given path [{}]", path);
                continue;
            }

            ValueMap valueMap = resource.getValueMap();
            String hideInNav = valueMap.get("hideInNav", String.class);
            if ("true".equalsIgnoreCase(hideInNav)) { // Hide in Navigation: ignore this page
                return;
            }

            navItem.setInnerTitle(valueMap.get("innerTitle", String.class));
            navItem.setAssetImage(valueMap.get("assetImage", String.class));
            navItem.setImageAlt(valueMap.get("imageAlt", String.class));
            String pathPage = valueMap.get("pathPage", String.class);
            if (StringUtils.isBlank(pathPage)) {
                pathPage = Constants.HASH;
            } else if (EnowaUtil.isPageLink(resourceResolver, pathPage)) {
                pathPage = pathPage.concat(Constants.DOT_HTML);
            }
            navItem.setPathPage(pathPage);

            Page children = pageManager.getPage(childPage.getPath());
            if (children != null) {
                Iterator<Page> childItem = children.listChildren();
                List<NavChildItem> navChildItems = new ArrayList<>();
                while (childItem.hasNext()) {
                    Page childItemPage = childItem.next();
                    NavChildItem navChildItem = new NavChildItem();
                    navChildItem.setTitle(childItemPage.getTitle());
                    navChildItem.setPath(childItemPage.getPath());
                    navChildItems.add(navChildItem);
                }
                navItem.setChildItem(navChildItems);
            }
            navItems.add(navItem);
        }
    }

    public List<NavItem> getNavItems() {
        return navItems;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public String getTemplate() {
        return currentPage.getTemplate().getPath();
    }

    public void setTemplateTheme(String templateTheme) {
        this.templateTheme = templateTheme;
    }

    public String getTemplateTheme() {
        if (getTemplate().equals(Constants.SUB_PAGE_TEMPLATE)) {
            templateTheme = Constants.LIGHT_THEME;
        } else {
            templateTheme = Constants.DARK_THEME;
        }
        return templateTheme;
    }

    public String getHomePagePath() {
        if (EnowaUtil.isPageLink(resourceResolver, homePagePath)) {
            return homePagePath + Constants.DOT_HTML;
        }
        return homePagePath;
    }

    public void setResourceResolver(ResourceResolver resourceResolver) {
        this.resourceResolver = resourceResolver;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public void setHomePagePath(String homePagePath) {
        this.homePagePath = homePagePath;
    }

    public void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
    }

    public void setNavItems(List<NavItem> navItems) {
        this.navItems = navItems;
    }
}
