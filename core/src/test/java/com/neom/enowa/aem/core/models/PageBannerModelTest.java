package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.PageBannerModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageBannerModelTest {

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private Resource resource;

    @Mock
    private ResourceResolver resourceResolver;

    private PageBannerModel pageBannerModel;

    @BeforeEach
    public void setUp() {
        // Initialize Mockito annotations
        MockitoAnnotations.initMocks(this);

        // Create an instance of PageBannerModel using the ModelFactory
        pageBannerModel = new PageBannerModel();
        pageBannerModel.setResourceResolver(resourceResolver);
    }

    @Test
    public void testTitleGetterAndSetter() {
        // Set a title and test the getter
        pageBannerModel.setTitle("Test Title");
        assertEquals("Test Title", pageBannerModel.getTitle());
    }

    @Test
    public void testDescriptionGetterAndSetter() {
        // Set a description and test the getter
        pageBannerModel.setDescription("Test Description");
        assertEquals("Test Description", pageBannerModel.getDescription());
    }

    @Test
    public void testBgAssetTypeGetterAndSetter() {
        // Set a background asset type and test the getter
        pageBannerModel.setBgAssetType("Image");
        assertEquals("Image", pageBannerModel.getBgAssetType());
    }

    @Test
    public void testSourceVideoGetterAndSetter() {
        // Set a source video URL and test the getter
        pageBannerModel.setSourceVideo("https://example.com/video.mp4");
        assertEquals("https://example.com/video.mp4", pageBannerModel.getSourceVideo());
    }

    @Test
    public void testAltVideoGetterAndSetter() {
        // Set an alternate video URL and test the getter
        pageBannerModel.setAltVideo("https://example.com/alt-video.mp4");
        assertEquals("https://example.com/alt-video.mp4", pageBannerModel.getAltVideo());
    }

    @Test
    public void testSourceImgGetterAndSetter() {
        // Set a source image URL and test the getter
        pageBannerModel.setSourceImg("https://example.com/image.jpg");
        assertEquals("https://example.com/image.jpg", pageBannerModel.getSourceImg());
    }

    @Test
    public void testAltGifGetterAndSetter() {
        // Set an alternate GIF URL and test the getter
        pageBannerModel.setAltGif("https://example.com/alt-gif.gif");
        assertEquals("https://example.com/alt-gif.gif", pageBannerModel.getAltGif());
    }

    @Test
    public void testCtaAssetTypeGetterAndSetter() {
        // Set CTA asset type and test the getter
        pageBannerModel.setCtaAssetType("Video");
        assertEquals("Video", pageBannerModel.getCtaAssetType());
    }

    @Test
    public void testCtaSourceVideoGetterAndSetter() {
        // Set CTA source video URL and test the getter
        pageBannerModel.setCtaSourceVideo("https://www.youtube.com/watch?v=video_id");
        assertEquals("https://www.youtube.com/embed/video_id", pageBannerModel.getCtaSourceVideo());
    }

    @Test
    public void testCtaSourceLinkGetterAndSetter() {
        // Set CTA source link and test the getter
        pageBannerModel.setCtaSourceLink("/path/to/page");
        assertEquals("/path/to/page", pageBannerModel.getCtaSourceLink());
    }

    @Test
    public void testOpenNewTabGetterAndSetter() {
        // Set open new tab value and test the getter
        pageBannerModel.setOpenNewTab("true");
        assertEquals("true", pageBannerModel.getOpenNewTab());
    }
}
