package com.neom.enowa.aem.core.models.stepper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StepperItemsTest {

    private StepperItems stepperItems;

    @BeforeEach
    void setUp() {
        stepperItems = new StepperItems();
    }

    @Test
    void testGettersAndSetters() {
        // Test getters initially returning null
        assertNull(stepperItems.getTitle());
        assertNull(stepperItems.getDescription());
        assertNull(stepperItems.getSourceImg());
        assertNull(stepperItems.getAltImg());

        // Test setters
        stepperItems.setTitle("Test Title");
        stepperItems.setDescription("Test Description");
        stepperItems.setSourceImg("/path/to/image.jpg");
        stepperItems.setAltImg("Image Alt Text");

        // Verify getters after setting values
        assertEquals("Test Title", stepperItems.getTitle());
        assertEquals("Test Description", stepperItems.getDescription());
        assertEquals("/path/to/image.jpg", stepperItems.getSourceImg());
        assertEquals("Image Alt Text", stepperItems.getAltImg());
    }
}
