package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.TableInfoModelTablist;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TableInfoModelTablistTest {

    @Mock
    private SlingHttpServletRequest slingRequest;

    @Mock
    private Resource resource;

    private TableInfoModelTablist tablist;

    @BeforeEach
    void setUp() {
        tablist = new TableInfoModelTablist();
    }

    @Test
    void testGettersAndSetters() {
        // Set values
        tablist.setDisplayOrder("1");
        tablist.setDescription("Tablist Description");
        tablist.setImage("image.jpg");
        tablist.setImageAlternativeText("Alt Text");

        // Verify getters
        assertEquals("1", tablist.getDisplayOrder());
        assertEquals("Tablist Description", tablist.getDescription());
        assertEquals("image.jpg", tablist.getImage());
        assertEquals("Alt Text", tablist.getImageAlternativeText());
    }
}
