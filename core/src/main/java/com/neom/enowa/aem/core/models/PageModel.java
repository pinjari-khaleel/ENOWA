package com.neom.enowa.aem.core.models;

import com.day.cq.wcm.api.PageManager;
import com.neom.enowa.aem.core.constants.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.*;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;

/**
 * The type Page model.
 */
@Model(
        adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class PageModel {

    @ChildResource
    private String favicon;

    @ChildResource
    private String googleTagManagerScript;

    @SlingObject
    private Resource resource;

    @PostConstruct
    void init() throws PersistenceException {
        if (StringUtils.isNotBlank(favicon) && StringUtils.isNotBlank(googleTagManagerScript)) {
            return;
        }
        final Resource resourceParent = resource.getParent();
        if (resourceParent == null) {
            return;
        }
        final ResourceResolver resolver = resource.getResourceResolver();
        final String path = resource.getParent().getPath();
        final String pathRoot = path.substring(0, path.lastIndexOf(Constants.SLASH));
        final PageManager pageManager = resolver.adaptTo(PageManager.class);
        if (pageManager != null) {
            final ValueMap valueMapRoot = pageManager.getPage(pathRoot).getProperties();
            final String faviconRoot = valueMapRoot.get(Constants.FAVICON, String.class);
            final String googleTagManagerScriptRoot = valueMapRoot.get(Constants.GOOGLE_TAG_MANAGER_SCRIPT, String.class);
            if (StringUtils.isNotBlank(faviconRoot)) {
                favicon = faviconRoot;
                googleTagManagerScript = googleTagManagerScriptRoot;
                final ModifiableValueMap mValueMap = resource.adaptTo(ModifiableValueMap.class);
                if (mValueMap != null) {
                    mValueMap.put(Constants.FAVICON, faviconRoot);
                    mValueMap.put(Constants.GOOGLE_TAG_MANAGER_SCRIPT, googleTagManagerScriptRoot);
                    resolver.commit();
                }
            }
        }
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Resource getResource() {
        return resource;
    }

    public String getGoogleTagManagerScript() {
        return googleTagManagerScript;
    }
}
