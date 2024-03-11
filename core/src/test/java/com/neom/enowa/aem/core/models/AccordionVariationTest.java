package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.AccordionVariation;
import com.neom.enowa.aem.core.models.accordionvariation.AccordionVariationItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccordionVariationTest {

    private AccordionVariation accordionVariation;
    private List<AccordionVariationItem> faqItems;

    @BeforeEach
    void setUp() {
        accordionVariation = new AccordionVariation();
        faqItems = new ArrayList<>();
        // Initialize accordionVariation with test data
        accordionVariation.setFaqItems(faqItems);
        accordionVariation.setFaqTitle("FAQ Title");
        accordionVariation.setLimit("5");
        accordionVariation.setBgColour("#FFFFFF");
    }

    @Test
    void testGetFaqTitle() {
        assertEquals("FAQ Title", accordionVariation.getFaqTitle());
    }

    @Test
    void testGetLimit() {
        assertEquals("5", accordionVariation.getLimit());
    }

    @Test
    void testGetBgColour() {
        assertEquals("#FFFFFF", accordionVariation.getBgColour());
    }

    @Test
    void testGetFaqItems() {
        assertEquals(faqItems, accordionVariation.getFaqItems());
    }

}
