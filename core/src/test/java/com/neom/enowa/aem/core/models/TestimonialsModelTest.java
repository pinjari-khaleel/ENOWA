package com.neom.enowa.aem.core.models;


import com.neom.enowa.aem.core.models.TestimonialsModel;
import com.neom.enowa.aem.core.models.testimonials.TestimonialItemModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestimonialsModelTest {

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private Resource resource;

    private TestimonialsModel testimonialsModel;

    @BeforeEach
    public void setUp() {
        // Initialize Mockito annotations
        MockitoAnnotations.initMocks(this);

        // Create an instance of TestimonialsModel using the ModelFactory
        testimonialsModel = new TestimonialsModel();
    }

    @Test
    public void testBgColourGetterAndSetter() {
        // Set a background color and test the getter
        testimonialsModel.setBgColour("Test Color");
        assertEquals("Test Color", testimonialsModel.getBgColour());
    }

    @Test
    public void testTestItemsGetterAndSetter() {
        // Create a list of TestimonialItemModel objects
        List<TestimonialItemModel> testimonialItems = new ArrayList<>();
        testimonialItems.add(new TestimonialItemModel());
        testimonialItems.add(new TestimonialItemModel());

        // Set the list of testimonial items and test the getter
        testimonialsModel.setTestItems(testimonialItems);
        assertEquals(testimonialItems, testimonialsModel.getTestItems());
    }
}
