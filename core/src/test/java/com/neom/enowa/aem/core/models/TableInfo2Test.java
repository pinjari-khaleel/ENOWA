package com.neom.enowa.aem.core.models;


import com.neom.enowa.aem.core.models.TableInfo2;
import com.neom.enowa.aem.core.models.tableInfotwo.TableInfoList;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TableInfo2Test {

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private Resource resource;

    private TableInfo2 tableInfo2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize the TableInfo2 model
        tableInfo2 = new TableInfo2();

        // Register the SlingHttpServletRequest and Resource
        tableInfo2.init();
    }

    @Test
    void testInitMethodWithNullTableInfoList() {
        // When tableInfoList is null
        tableInfo2.init();

        // Verify that tableInfoOne, tableInfoTwo, and tableInfoFullList are empty
        assertEquals(0, tableInfo2.getTableInfoOne().size());
        assertEquals(0, tableInfo2.getTableInfoTwo().size());
        assertEquals(0, tableInfo2.getTableInfoFullList().size());
    }

    @Test
    void testInitMethodWithTableInfoList() {
        // Mock data for tableInfoList
        List<TableInfoList> mockTableInfoList = new ArrayList<>();
        mockTableInfoList.add(new TableInfoList());
        mockTableInfoList.add(new TableInfoList());
        mockTableInfoList.add(new TableInfoList());

        // Set the mock data
        tableInfo2.setTableInfoList(mockTableInfoList);

        // Call the init method
        tableInfo2.init();

        // Verify that tableInfoOne, tableInfoTwo, and tableInfoFullList are populated correctly
        assertEquals(2, tableInfo2.getTableInfoOne().size());
        assertEquals(1, tableInfo2.getTableInfoTwo().size());
        assertEquals(mockTableInfoList.size(), tableInfo2.getTableInfoFullList().size());
    }

    @Test
    void testGettersAndSetters() {
        // Mock data for headerTitle and titleDescription
        String mockHeaderTitle = "Header Title";
        String mockTitleDescription = "Title Description";

        // Mock data for tableInfoList
        List<TableInfoList> mockTableInfoList = new ArrayList<>();
        mockTableInfoList.add(new TableInfoList());
        mockTableInfoList.add(new TableInfoList());

        // Set the mock data
        tableInfo2.setHeaderTitle(mockHeaderTitle);
        tableInfo2.setTitleDescription(mockTitleDescription);
        tableInfo2.setTableInfoList(mockTableInfoList);

        // Verify that getters return the expected values
        assertEquals(mockHeaderTitle, tableInfo2.getHeaderTitle());
        assertEquals(mockTitleDescription, tableInfo2.getTitleDescription());
        assertEquals(mockTableInfoList, tableInfo2.getTableInfoList());
    }
}
