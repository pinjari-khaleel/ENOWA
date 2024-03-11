package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.HorizontalAccordinTablist;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HorizontalAccordinTablistTest {

    private HorizontalAccordinTablist horizontalAccordinTablist;

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private Resource resource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        // Create an instance of HorizontalAccordinTablist before each test
        horizontalAccordinTablist = new HorizontalAccordinTablist();

        // Set mock data
        horizontalAccordinTablist.setIcon("icon");
        horizontalAccordinTablist.setIconAlternative("iconAlternative");
        horizontalAccordinTablist.setTitle("title");
        horizontalAccordinTablist.setDescription("description");
        horizontalAccordinTablist.setAssetType("assetType");
        horizontalAccordinTablist.setAssetImage("assetImage");
        horizontalAccordinTablist.setImageAlt("imageAlt");
        horizontalAccordinTablist.setVideoBackgroundImage("videoBackgroundImage");
        horizontalAccordinTablist.setVideoBackgroudImageAlt("videoBackgroudImageAlt");
    }

    @Test
    void testGetters() {
        // Test the getter methods to ensure they return the expected values
        assertEquals("icon", horizontalAccordinTablist.getIcon());
        assertEquals("iconAlternative", horizontalAccordinTablist.getIconAlternative());
        assertEquals("title", horizontalAccordinTablist.getTitle());
        assertEquals("description", horizontalAccordinTablist.getDescription());
        assertEquals("assetType", horizontalAccordinTablist.getAssetType());
        assertEquals("assetImage", horizontalAccordinTablist.getAssetImage());
        assertEquals("imageAlt", horizontalAccordinTablist.getImageAlt());
        assertEquals("videoBackgroundImage", horizontalAccordinTablist.getVideoBackgroundImage());
        assertEquals("videoBackgroudImageAlt", horizontalAccordinTablist.getVideoBackgroudImageAlt());
    }

    @Test
    void testSetters() {
        // Test the setter methods to ensure they set the values correctly
        horizontalAccordinTablist.setIcon("newIcon");
        assertEquals("newIcon", horizontalAccordinTablist.getIcon());

        // Repeat this for other setter methods
    }
}
