package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.infographics.InfographicsModelTabList;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InfographicsModelTest {

    @Mock
    private Logger logger;

    @Mock
    private Resource supports;

    @Mock
    private ValueMap valueMap;

    @BeforeEach
    public void setUp() {
        // Initialize Mockito annotations
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testApplyFontSize() {
        InfographicsModel infographicsModel = new InfographicsModel();
        infographicsModel.applyFontSize("h2");
        assertEquals("cmp-title--title-level-2", infographicsModel.getCssStyle());
    }

    @Test
    public void testApplyFontSizeWithDefault() {
        InfographicsModel infographicsModel = new InfographicsModel();
        infographicsModel.applyFontSize("invalidType");
        assertEquals("cmp-title--title-level-1", infographicsModel.getCssStyle());
    }

    @Test
    public void testGetterAndSetterMethods() {
        InfographicsModel infographicsModel = new InfographicsModel();

        infographicsModel.setHeaderTitle("Test Title");
        assertEquals("Test Title", infographicsModel.getHeaderTitle());

        infographicsModel.setHeaderDescription("Test Description");
        assertEquals("Test Description", infographicsModel.getHeaderDescription());

        infographicsModel.sethType("h3");
        assertEquals("h3", infographicsModel.gethType());

        infographicsModel.setImage("image.jpg");
        assertEquals("image.jpg", infographicsModel.getImage());

        infographicsModel.setImageAlternativeText("Alt Text");
        assertEquals("Alt Text", infographicsModel.getImageAlternativeText());

        List<InfographicsModelTabList> tabLists = new ArrayList<>();
        infographicsModel.setInfographicsModelTabLists(tabLists);
        assertEquals(tabLists, infographicsModel.getInfographicsModelTabLists());
    }

    @Test
    public void testGetMapForMultiData() {
        // Define sample data for testing
        Mockito.when(supports.getValueMap()).thenReturn(valueMap);
        Mockito.when(valueMap.get("title", String.class)).thenReturn("Title");
        Mockito.when(valueMap.get("description", String.class)).thenReturn("Description");
        Mockito.when(valueMap.get("cta", String.class)).thenReturn("CTA");
        Mockito.when(valueMap.get("link", String.class)).thenReturn("Link");
        Mockito.when(valueMap.get("borderColor", String.class)).thenReturn("BorderColor");
        Mockito.when(valueMap.get("assetType", String.class)).thenReturn("AssetType");
        Mockito.when(valueMap.get("assetImage", String.class)).thenReturn("AssetImage");
        Mockito.when(valueMap.get("imageAlt", String.class)).thenReturn("ImageAlt");
        Mockito.when(valueMap.get("videoBackgroundImage", String.class)).thenReturn("VideoBackgroundImage");
        Mockito.when(valueMap.get("videoBackgroudImageAlt", String.class)).thenReturn("VideoBackgroundImageAlt");


        // Create an instance of the class containing the getMapForMultiData method
        InfoGraphicModel infographicsModel = new InfoGraphicModel();
        // Call the method under test
        Map<String, String> result = infographicsModel.getStringMultiData(supports);

        // Verify the result
        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("title", "Title");
        expectedMap.put("description", "Description");
        expectedMap.put("cta", "CTA");
        expectedMap.put("link", "Link");
        expectedMap.put("borderColor", "BorderColor");
        expectedMap.put("assetType", "AssetType");
        expectedMap.put("assetImage", "AssetImage");
        expectedMap.put("imageAlt", "ImageAlt");
        expectedMap.put("videoBackgroundImage", "VideoBackgroundImage");
        expectedMap.put("videoBackgroudImageAlt", "VideoBackgroundImageAlt");

        assertEquals(expectedMap, result);
    }

}
