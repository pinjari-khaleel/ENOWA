package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.AllLatestUpdatesModel;
import com.neom.enowa.aem.core.models.latestupdates.ColumnItems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AllLatestUpdatesModelTest {

    private AllLatestUpdatesModel allLatestUpdatesModel;
    private List<com.neom.enowa.aem.core.models.latestupdates.NewsItems> newsItems;
    private List<ColumnItems> columnItems;

    @BeforeEach
    void setUp() {
        allLatestUpdatesModel = new AllLatestUpdatesModel();
        newsItems = new ArrayList<>();
        columnItems = new ArrayList<>();

        // Populate newsItems and columnItems with test data
        // Assuming NewsItems and ColumnItems have appropriate constructors or setters

        allLatestUpdatesModel.setTitle("Test Title");
        allLatestUpdatesModel.setTitleUrl("test-url");
        allLatestUpdatesModel.setLatestNews("Test News");
        allLatestUpdatesModel.setNewsItems(newsItems);
        allLatestUpdatesModel.setColumnItemsList(columnItems);
    }

    @Test
    void testInitMethod() {
        allLatestUpdatesModel.init();
        assertNotNull(allLatestUpdatesModel.getDoubleItemsList());
        // Additional assertions based on the expected structure of doubleItemsList
    }

    @Test
    void testGettersAndSetters() {
        assertEquals("Test Title", allLatestUpdatesModel.getTitle());
        assertEquals("test-url.html", allLatestUpdatesModel.getTitleUrl());
        assertEquals("Test News", allLatestUpdatesModel.getLatestNews());
        assertEquals(newsItems, allLatestUpdatesModel.getNewsItems());
        assertEquals(columnItems, allLatestUpdatesModel.getColumnItemsList());
    }


}
