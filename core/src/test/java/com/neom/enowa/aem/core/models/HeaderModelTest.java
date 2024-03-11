package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.HeaderModel;
import com.neom.enowa.aem.core.models.header.HeaderItem;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class HeaderModelTest {

    private HeaderModel headerModel;

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private Resource resource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        // Create an instance of HeaderModel before each test
        headerModel = new HeaderModel();

        // Mock the headerItems data
        List<HeaderItem> headerItems = new ArrayList<>();
        HeaderItem item1 = new HeaderItem();
        // Initialize item1 with data
        HeaderItem item2 = new HeaderItem();
        // Initialize item2 with data
        headerItems.add(item1);
        headerItems.add(item2);

        when(request.getResource()).thenReturn(resource);
        when(resource.adaptTo(HeaderModel.class)).thenReturn(headerModel);
        headerModel.setHeaderItems(headerItems);
    }

    @Test
    void testHeaderItemsInitialization() {
        // Ensure that headerItems are initialized correctly
        List<HeaderItem> headerItems = headerModel.getHeaderItems();
        assertNotNull(headerItems);
        assertEquals(2, headerItems.size()); // Assuming you have 2 items
    }


    @Test
    void testHeaderItemsModification() {
        // Assuming you have logic in HeaderModel to modify header items (as shown in your init method)
        // Test the modification logic here and assert the modified items
        headerModel.init();
        List<HeaderItem> headerItemsModified = headerModel.getHeaderItemsModified();
        assertNotNull(headerItemsModified);
        assertEquals(2, headerItemsModified.size()); // Assuming you have 2 items
        // Add assertions to check modifications
    }
}
