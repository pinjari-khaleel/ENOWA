package com.neom.enowa.aem.core.models.infographics;

import com.neom.enowa.aem.core.models.infographics.InfographicsModelTabList;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InfographicsModelTabListTest {

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private Resource resource;

    private InfographicsModelTabList tabList;

    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        // Mock the SlingHttpServletRequest and Resource
        tabList = new InfographicsModelTabList();
    }

    @Test
    void testGettersAndSetters() {
        // Set values for the properties
        tabList.setImage("image");
        tabList.setImageAlternativeText("imageAlternativeText");
        tabList.setTitle("title");
        tabList.setScriptType("scriptType");
        tabList.setSuperScript("superScript");
        tabList.setSubScript("subScript");
        tabList.setScript("script");
        tabList.setDescription("description");

        // Test the getters
        assertEquals("image", tabList.getImage());
        assertEquals("imageAlternativeText", tabList.getImageAlternativeText());
        assertEquals("title", tabList.getTitle());
        assertEquals("scriptType", tabList.getScriptType());
        assertEquals("superScript", tabList.getSuperScript());
        assertEquals("subScript", tabList.getSubScript());
        assertEquals("script", tabList.getScript());
        assertEquals("description", tabList.getDescription());
    }
}
