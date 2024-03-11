package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.StepperModel;
import com.neom.enowa.aem.core.models.stepper.StepperItems;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class StepperModelTest {

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private Resource resource;

    private final StepperModel stepperModel = new StepperModel();

    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        // Mock the SlingHttpServletRequest and Resource
        when(request.getResource()).thenReturn(resource);


    }

    @Test
    void testStepperModel() {
        // Prepare sample data
        String blockTitle = "Block Title";
        String blockDescription = "Block Description";
        String assetType = "Asset Type";
        String videoSource = "Video Source";
        String videoAlt = "Video Alt";
        String imageSource = "Image Source";
        String imageAlt = "Image Alt";
        String assetImage = "Asset Image";
        String videoBackground = "Video Background";
        String videoBackgroundAlt = "Video Background Alt";

        List<StepperItems> stepperItems = new ArrayList<>();
        StepperItems stepperItem1 = new StepperItems();
        stepperItem1.setTitle("Step 1");
        stepperItem1.setDescription("Description 1");
        stepperItems.add(stepperItem1);

        // Set the values for the StepperModel
        stepperModel.setBlockTitle(blockTitle);
        stepperModel.setBlockDescription(blockDescription);
        stepperModel.setAssetType(assetType);
        stepperModel.setVideoSource(videoSource);
        stepperModel.setVideoAlt(videoAlt);
        stepperModel.setImageSource(imageSource);
        stepperModel.setImageAlt(imageAlt);
        stepperModel.setAssetImage(assetImage);
        stepperModel.setVideoBackground(videoBackground);
        stepperModel.setVideoBackgroundAlt(videoBackgroundAlt);
        stepperModel.setStepperItems(stepperItems);

        // Test getter methods
        assertEquals(blockTitle, stepperModel.getBlockTitle());
        assertEquals(blockDescription, stepperModel.getBlockDescription());
        assertEquals(assetType, stepperModel.getAssetType());
        assertEquals(videoSource, stepperModel.getVideoSource());
        assertEquals(videoAlt, stepperModel.getVideoAlt());
        assertEquals(imageSource, stepperModel.getImageSource());
        assertEquals(imageAlt, stepperModel.getImageAlt());
        assertEquals(assetImage, stepperModel.getAssetImage());
        assertEquals(videoBackground, stepperModel.getVideoBackground());
        assertEquals(videoBackgroundAlt, stepperModel.getVideoBackgroundAlt());
        assertEquals(stepperItems, stepperModel.getStepperItems());
    }
}
