package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.StepperModelTablist;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class StepperModelTablistTest {

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private Resource resource;

    private StepperModelTablist stepperModelTablist;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize the StepperModelTablist model
        stepperModelTablist = new StepperModelTablist("Test Title");

        // Register the SlingHttpServletRequest and Resource
    }

    @Test
    void testGettersAndSetters() {
        // Mock data
        String mockDescription = "Test Description";
        String mockAssetType = "Test Asset Type";
        String mockAssetImage = "Test Asset Image";
        String mockImageAlt = "Test Image Alt";
        String mockVideoBackgroundImage = "Test Video Background Image";
        String mockVideoBackgroudImageAlt = "Test Video Background Image Alt";

        // Set the mock data
        stepperModelTablist.setDescription(mockDescription);
        stepperModelTablist.setAssetType(mockAssetType);
        stepperModelTablist.setAssetImage(mockAssetImage);
        stepperModelTablist.setImageAlt(mockImageAlt);
        stepperModelTablist.setVideoBackgroundImage(mockVideoBackgroundImage);
        stepperModelTablist.setVideoBackgroudImageAlt(mockVideoBackgroudImageAlt);

        // Verify that getters return the expected values
        assertEquals("Test Title", stepperModelTablist.getTitle());
        assertEquals(mockDescription, stepperModelTablist.getDescription());
        assertEquals(mockAssetType, stepperModelTablist.getAssetType());
        assertEquals(mockAssetImage, stepperModelTablist.getAssetImage());
        assertEquals(mockImageAlt, stepperModelTablist.getImageAlt());
        assertEquals(mockVideoBackgroundImage, stepperModelTablist.getVideoBackgroundImage());
        assertEquals(mockVideoBackgroudImageAlt, stepperModelTablist.getVideoBackgroudImageAlt());
    }
}
