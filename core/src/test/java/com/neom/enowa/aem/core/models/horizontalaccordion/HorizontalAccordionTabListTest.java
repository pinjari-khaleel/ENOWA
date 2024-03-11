package com.neom.enowa.aem.core.models.horizontalaccordion;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HorizontalAccordionTabListTest {

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private Resource resource;

    private HorizontalAccordionTabList tabList;

    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        // Mock the SlingHttpServletRequest and Resource
        tabList = new HorizontalAccordionTabList();
    }

    @Test
    void testGettersAndSetters() {
        // Set values for the properties
        tabList.setIcon("icon");
        tabList.setIconAlternative("iconAlternative");
        tabList.setTitle("title");
        tabList.setDescription("description");
        tabList.setAssetType("assetType");
        tabList.setAssetImage("assetImage");
        tabList.setImageAlt("imageAlt");
        tabList.setVideo("video");
        tabList.setVideoAlt("videoAlt");

        // Test the getters
        assertEquals("icon", tabList.getIcon());
        assertEquals("iconAlternative", tabList.getIconAlternative());
        assertEquals("title", tabList.getTitle());
        assertEquals("description", tabList.getDescription());
        assertEquals("assetType", tabList.getAssetType());
        assertEquals("assetImage", tabList.getAssetImage());
        assertEquals("imageAlt", tabList.getImageAlt());
        assertEquals("video", tabList.getVideo());
        assertEquals("videoAlt", tabList.getVideoAlt());
    }
}
