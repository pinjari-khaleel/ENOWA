package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.HorizontalAccordionModel;
import com.neom.enowa.aem.core.models.horizontalaccordion.HorizontalAccordionTabList;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HorizontalAccordionModelTest {

    private HorizontalAccordionModel horizontalAccordionModel;

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private Resource resource;

    @Mock
    private HorizontalAccordionTabList horizontalAccordionTabList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        // Create an instance of HorizontalAccordionModel before each test
        horizontalAccordionModel = new HorizontalAccordionModel();

        // Set mock data
        horizontalAccordionModel.setTitle("title");
        horizontalAccordionModel.setDescription("description");
        horizontalAccordionModel.setItemAccordion("itemAccordion");
        List<HorizontalAccordionTabList> accordionTabLists = Collections.singletonList(horizontalAccordionTabList);
        horizontalAccordionModel.horizontalAccordTabLists = accordionTabLists;
    }

    @Test
    void testGetters() {
        // Test the getter methods to ensure they return the expected values
        assertEquals("title", horizontalAccordionModel.getTitle());
        assertEquals("description", horizontalAccordionModel.getDescription());
        assertEquals("itemAccordion", horizontalAccordionModel.getItemAccordion());
        assertEquals(Collections.singletonList(horizontalAccordionTabList), horizontalAccordionModel.getHorizontalAccordTabLists());
    }

    @Test
    void testSetters() {
        // Test the setter methods to ensure they set the values correctly
        horizontalAccordionModel.setTitle("newTitle");
        assertEquals("newTitle", horizontalAccordionModel.getTitle());

        // Repeat this for other setter methods
    }

}
