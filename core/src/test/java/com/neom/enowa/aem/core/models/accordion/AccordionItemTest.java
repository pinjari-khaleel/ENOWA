package com.neom.enowa.aem.core.models.accordion;

import com.neom.enowa.aem.core.models.accordion.AccordionItem;
import com.neom.enowa.aem.core.models.accordion.DisplayItem;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccordionItemTest {

    @Mock
    private SlingHttpServletRequest slingRequest;

    @Mock
    private Resource resource;

    private AccordionItem accordionItem;

    @BeforeEach
    void setUp() {
        accordionItem = new AccordionItem();
    }

    @Test
    void testGettersAndSetters() {
        // Set title
        accordionItem.setTitle("Accordion Title");

        // Verify that getTitle method returns the set title
        assertEquals("Accordion Title", accordionItem.getTitle());

        // Create a list of DisplayItem objects
        List<DisplayItem> displayItems = new ArrayList<>();
        DisplayItem item1 = new DisplayItem();
        item1.setDescription("Description 1");
        DisplayItem item2 = new DisplayItem();
        item2.setDescription("Description 2");
        displayItems.add(item1);
        displayItems.add(item2);

        // Set the list of DisplayItem objects
        accordionItem.setDescriptionMF(displayItems);

        // Verify that getDescriptionMF method returns the set list
        assertEquals(displayItems, accordionItem.getDescriptionMF());
    }

    @Test
    void testDefaultConstructor() {
        // Verify that the default constructor initializes the title as null
        assertNull(accordionItem.getTitle());
    }

    @Test
    void testConstructorWithTitle() {
        // Create an AccordionItem with a title
        AccordionItem item = new AccordionItem("Custom Title");

        // Verify that the constructor with a title sets the title correctly
        assertEquals("Custom Title", item.getTitle());
    }

    @Test
    void testGetTitleWithNullTitle() {
        // Verify that getTitle returns null when the title is not set
        assertNull(accordionItem.getTitle());
    }

    @Test
    void testGetDescriptionMFWithEmptyList() {


        // Set the list of DisplayItem objects
        // Verify that getDescriptionMF returns an empty list when the list is not set
        assertNull( accordionItem.getDescriptionMF());
    }
}
