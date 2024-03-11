package com.neom.enowa.aem.core.models.tableInfotwo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TableInfoListTest {

    private TableInfoList tableInfoList;

    @BeforeEach
    void setUp() {
        tableInfoList = new TableInfoList();
    }

    @Test
    void testGettersAndSetters() {
        // Test getters initially returning null
        assertNull(tableInfoList.getSourceIcon());
        assertNull(tableInfoList.getAltIcon());
        assertEquals(0, tableInfoList.getCurrentPosition());
        assertNull(tableInfoList.getTitle());
        assertNull(tableInfoList.getDesTitle());

        // Test setters
        tableInfoList.setSourceIcon("/path/to/icon.jpg");
        tableInfoList.setAltIcon("Icon Alt Text");
        tableInfoList.setCurrentPosition(1);
        tableInfoList.setTitle("Test Title");
        tableInfoList.setDesTitle("Test Description Title");

        // Verify getters after setting values
        assertEquals("/path/to/icon.jpg", tableInfoList.getSourceIcon());
        assertEquals("Icon Alt Text", tableInfoList.getAltIcon());
        assertEquals(1, tableInfoList.getCurrentPosition());
        assertEquals("Test Title", tableInfoList.getTitle());
        assertEquals("Test Description Title", tableInfoList.getDesTitle());
    }
}
