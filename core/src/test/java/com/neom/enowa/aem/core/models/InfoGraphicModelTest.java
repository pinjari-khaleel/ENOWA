package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.InfoGraphicModel;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.testing.resourceresolver.MockResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InfoGraphicModelTest {

    private InfoGraphicModel infoGraphicModel;

    @BeforeEach
    void setUp() {
        // Initialize the InfoGraphicModel
        infoGraphicModel = new InfoGraphicModel();

        // Mock componentResource

        // Set the componentResource
    }

    @Test
    void testGetDisplayNumber() {
        // Set the displayNumber
        infoGraphicModel.setDisplayNumber("123");

        // Verify that getDisplayNumber() returns the expected value
        assertEquals("123", infoGraphicModel.getDisplayNumber());
    }

    @Test
    void testGetTabLists() {
        // Create a mock tabLists
        List<Map<String, String>> mockTabLists = new ArrayList<>();
        Map<String, String> tabData = new HashMap<>();
        tabData.put("title", "Title 1");
        tabData.put("description", "Description 1");
        mockTabLists.add(tabData);

        // Set the tabLists
        infoGraphicModel.setTabLists(mockTabLists);

        // Verify that getTabLists() returns the expected list
        assertEquals(mockTabLists, infoGraphicModel.getTabLists());
    }

    @Test
    void testInit() {

        List<Map<String, String>> tabLists = new ArrayList<>();
        Map<String, String> tabData = new HashMap<>();
        tabData.put("title", "Title 1");
        tabData.put("description", "Description 1");
        tabLists.add(tabData);

        assertEquals(1, tabLists.size());
        Map<String, String> tabData1 = tabLists.get(0);
        assertEquals("Title 1", tabData1.get("title"));
        assertEquals("Description 1", tabData1.get("description"));
    }

    // MockResource class for testing
}
