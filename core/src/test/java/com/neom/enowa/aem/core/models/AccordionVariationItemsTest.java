package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.AccordionVariationItems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccordionVariationItemsTest {

    private AccordionVariationItems accordionVariationItem;

    @BeforeEach
    void setUp() {
        accordionVariationItem = new AccordionVariationItems("Test Question", "Test Answer", "1");
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("Test Question", accordionVariationItem.getQuestionTitle());
        assertEquals("Test Answer", accordionVariationItem.getFaqDescription());
        assertEquals("01", accordionVariationItem.getCount()); // Assuming count formatting logic
    }

    @Test
    void testSetters() {
        accordionVariationItem.setQuestionTitle("New Question");
        accordionVariationItem.setFaqDescription("New Answer");
        accordionVariationItem.setCount("10");

        assertEquals("New Question", accordionVariationItem.getQuestionTitle());
        assertEquals("New Answer", accordionVariationItem.getFaqDescription());
        assertEquals("10", accordionVariationItem.getCount());
    }

    @Test
    void testCountFormatting() {
        accordionVariationItem.setCount("5");
        assertEquals("05", accordionVariationItem.getCount());

        accordionVariationItem.setCount("12");
        assertEquals("12", accordionVariationItem.getCount());
    }
}
