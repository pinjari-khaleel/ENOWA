package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.DisplayItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DisplayItemTest {

    private DisplayItem displayItem;

    @BeforeEach
    void setUp() {
        displayItem = new DisplayItem();
    }

    @Test
    void testDescriptionGetterAndSetter() {
        String testDescription = "Test Description";
        displayItem.setDescription(testDescription);
        assertEquals(testDescription, displayItem.getDescription());
    }
}
