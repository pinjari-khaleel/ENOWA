package com.neom.enowa.aem.core.models.navigationcard;

import com.neom.enowa.aem.core.models.navigationcard.NavigationCardTabLists;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigationCardTabListsTest {

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private Resource resource;

    @Mock
    private ResourceResolver resourceResolver;

    private NavigationCardTabLists tabLists;

    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        // Mock the SlingHttpServletRequest and ResourceResolver
        tabLists = new NavigationCardTabLists();
        tabLists.setResourceResolver(resourceResolver);
    }

    @Test
    void testGettersAndSetters() {
        // Set values for the properties
        tabLists.setTitle("title");
        tabLists.setDescription("description");
        tabLists.setLinkURL("/page");
        tabLists.setAssetType("assetType");
        tabLists.setAssetImage("assetImage");
        tabLists.setImageAlt("imageAlt");
        tabLists.setVideoBackgroundImage("videoBackgroundImage");
        tabLists.setVideoBackgroundImageAlt("videoBackgroundImageAlt");

        // Mock the isPageLink method to return true
//        when(isPageLink(resourceResolver, "/page")).thenReturn(true);

        // Test the getters
        assertEquals("title", tabLists.getTitle());
        assertEquals("description", tabLists.getDescription());
        assertEquals("/page", tabLists.getLinkURL());
        assertEquals("assetType", tabLists.getAssetType());
        assertEquals("assetImage", tabLists.getAssetImage());
        assertEquals("imageAlt", tabLists.getImageAlt());
        assertEquals("videoBackgroundImage", tabLists.getVideoBackgroundImage());
        assertEquals("videoBackgroundImageAlt", tabLists.getVideoBackgroundImageAlt());
    }

    public static boolean isPageLink(ResourceResolver resourceResolver, String link) {
        // Implement the logic for checking if it's a page link in this custom method.
        // For your test, you can simply return true for demonstration purposes.
        return true;
    }
}
