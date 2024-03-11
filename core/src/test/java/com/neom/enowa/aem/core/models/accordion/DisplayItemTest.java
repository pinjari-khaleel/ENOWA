package com.neom.enowa.aem.core.models.accordion;

import com.neom.enowa.aem.core.models.accordion.DisplayItem;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DisplayItemTest {

    @Mock
    private SlingHttpServletRequest slingRequest;

    @Mock
    private Resource resource;

    private DisplayItem displayItem;

    @BeforeEach
    void setUp() {
        displayItem = new DisplayItem();
    }

    @Test
    void testGettersAndSetters() {
        // Set a description
        displayItem.setDescription("Sample Description");

        // Verify that the getDescription method returns the set description
        assertEquals("Sample Description", displayItem.getDescription());

        // Set a new description
        displayItem.setDescription("New Description");

        // Verify that the getDescription method returns the new description
        assertEquals("New Description", displayItem.getDescription());
    }
}
