package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.PageHeaderModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageHeaderModelTest {

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private Resource resource;

    @Mock
    private ResourceResolver resourceResolver;

    private PageHeaderModel pageHeaderModel;

    @BeforeEach
    public void setUp() {
        // Initialize Mockito annotations
        MockitoAnnotations.initMocks(this);

        // Create an instance of PageHeaderModel using the ModelFactory
        pageHeaderModel = new PageHeaderModel();
    }

    @Test
    public void testTitleGetterAndSetter() {
        // Set a title and test the getter
        pageHeaderModel.setTitle("Test Title");
        assertEquals("Test Title", pageHeaderModel.getTitle());
    }

    @Test
    public void testDescriptionGetterAndSetter() {
        // Set a description and test the getter
        pageHeaderModel.setDescription("Test Description");
        assertEquals("Test Description", pageHeaderModel.getDescription());
    }

    @Test
    public void testBgAssetTypeGetterAndSetter() {
        // Set a background asset type and test the getter
        pageHeaderModel.setBgAssetType("Image");
        assertEquals("Image", pageHeaderModel.getBgAssetType());
    }

    @Test
    public void testSourceVideoGetterAndSetter() {
        // Set a source video URL and test the getter
        pageHeaderModel.setSourceVideo("https://example.com/video.mp4");
        assertEquals("https://example.com/video.mp4", pageHeaderModel.getSourceVideo());
    }

    @Test
    public void testAltVideoGetterAndSetter() {
        // Set an alternate video URL and test the getter
        pageHeaderModel.setAltVideo("https://example.com/alt-video.mp4");
        assertEquals("https://example.com/alt-video.mp4", pageHeaderModel.getAltVideo());
    }

    @Test
    public void testSourceImgGetterAndSetter() {
        // Set a source image URL and test the getter
        pageHeaderModel.setSourceImg("https://example.com/image.jpg");
        assertEquals("https://example.com/image.jpg", pageHeaderModel.getSourceImg());
    }

    @Test
    public void testAltImgGetterAndSetter() {
        // Set an alternate image URL and test the getter
        pageHeaderModel.setAltImg("https://example.com/alt-image.jpg");
        assertEquals("https://example.com/alt-image.jpg", pageHeaderModel.getAltImg());
    }

    @Test
    public void testCtaAssetTypeGetterAndSetter() {
        // Set CTA asset type and test the getter
        pageHeaderModel.setCtaAssetType("Video");
        assertEquals("Video", pageHeaderModel.getCtaAssetType());
    }

    @Test
    public void testCtaSourceVideoGetterAndSetter() {
        // Set CTA source video URL and test the getter
        pageHeaderModel.setCtaSourceVideo("https://www.youtube.com/watch?v=video_id");
        assertEquals("https://www.youtube.com/embed/video_id", pageHeaderModel.getCtaSourceVideo());
    }

    @Test
    public void testCtaSourceLinkGetterAndSetter() {
        // Set CTA source link and test the getter
        pageHeaderModel.setCtaSourceLink("/path/to/page");
        assertEquals("/path/to/page.html", pageHeaderModel.getCtaSourceLink());
    }

    @Test
    public void testOpenNewTabGetterAndSetter() {
        // Set open new tab value and test the getter
        pageHeaderModel.setOpenNewTab("true");
        assertEquals("true", pageHeaderModel.getOpenNewTab());
    }
}
