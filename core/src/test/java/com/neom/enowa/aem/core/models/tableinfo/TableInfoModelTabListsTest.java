package com.neom.enowa.aem.core.models.tableinfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TableInfoModelTabListsTest {

    private TableInfoModelTabLists tableInfoModelTabLists;

    @BeforeEach
    void setUp() {
        tableInfoModelTabLists = new TableInfoModelTabLists();
    }

    @Test
    void testGettersAndSetters() {
        // Test getters initially returning null
        assertNull(tableInfoModelTabLists.getDescription());
        assertNull(tableInfoModelTabLists.getImage());
        assertNull(tableInfoModelTabLists.getImageAlternativeText());
        assertNull(tableInfoModelTabLists.getRows());
        assertNull(tableInfoModelTabLists.getColumns());

        // Test setters
        tableInfoModelTabLists.setDescription("Test Description");
        tableInfoModelTabLists.setImage("/path/to/image.jpg");
        tableInfoModelTabLists.setImageAlternativeText("Image Alt Text");
        tableInfoModelTabLists.setRows("5");
        tableInfoModelTabLists.setColumns("3");

        // Verify getters after setting values
        assertEquals("Test Description", tableInfoModelTabLists.getDescription());
        assertEquals("/path/to/image.jpg", tableInfoModelTabLists.getImage());
        assertEquals("Image Alt Text", tableInfoModelTabLists.getImageAlternativeText());
        assertEquals("5", tableInfoModelTabLists.getRows());
        assertEquals("3", tableInfoModelTabLists.getColumns());
    }
}
