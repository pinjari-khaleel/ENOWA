package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.VideoComponentModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VideoComponentModelTest {

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private Resource resource;

    private VideoComponentModel videoComponentModel;

    @BeforeEach
    public void setUp() {
        // Initialize Mockito annotations
        MockitoAnnotations.initMocks(this);

        // Create an instance of VideoComponentModel using the ModelFactory
        videoComponentModel = new VideoComponentModel();
    }

    @Test
    public void testTitleGetterAndSetter() {
        // Set a title and test the getter
        videoComponentModel.setTitle("Test Title");
        assertEquals("Test Title", videoComponentModel.getTitle());
    }

    @Test
    public void testDescriptionGetterAndSetter() {
        // Set a description and test the getter
        videoComponentModel.setDescription("Test Description");
        assertEquals("Test Description", videoComponentModel.getDescription());
    }

    @Test
    public void testVideoGetterAndSetter() {
        // Set a video URL and test the getter
        videoComponentModel.setVideo("https://example.com/video.mp4");
        assertEquals("https://example.com/video.mp4", videoComponentModel.getVideo());
    }

    @Test
    public void testVideoBackgroundAltGetterAndSetter() {
        // Set a video background alt text and test the getter
        videoComponentModel.setVideoBackgroundAlt("Alt Text");
        assertEquals("Alt Text", videoComponentModel.getVideoBackgroundAlt());
    }
}
