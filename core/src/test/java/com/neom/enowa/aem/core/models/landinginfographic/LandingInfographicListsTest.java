package com.neom.enowa.aem.core.models.landinginfographic;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LandingInfographicListsTest {

    private LandingInfographicLists infographicLists;

    @Mock
    private ResourceResolver resourceResolver;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        infographicLists = new LandingInfographicLists();
        infographicLists.setResourceResolver(resourceResolver);
    }

    @Test
    void testGetTitle() {
        infographicLists.setTitle("Test Title");
        assertEquals("Test Title", infographicLists.getTitle());
    }

    @Test
    void testGetDescription() {
        infographicLists.setDescription("Test Description");
        assertEquals("Test Description", infographicLists.getDescription());
    }

    @Test
    void testGetCta() {
        infographicLists.setCta("Test CTA");
        assertEquals("Test CTA", infographicLists.getCta());
    }

    @Test
    void testGetLinkWithPageLink() {
        infographicLists.setLink("/test-page");
        Mockito.when(resourceResolver.getResource("/test-page.html")).thenReturn(Mockito.mock(Resource.class));
        assertEquals("/test-page", infographicLists.getLink());
    }

    @Test
    void testGetLinkWithoutPageLink() {
        infographicLists.setLink("https://example.com");
        assertEquals("https://example.com", infographicLists.getLink());
    }

    @Test
    void testGetBorderColor() {
        infographicLists.setBorderColor("#FF0000");
        assertEquals("#FF0000", infographicLists.getBorderColor());
    }

    @Test
    void testGetAssetType() {
        infographicLists.setAssetType("Image");
        assertEquals("Image", infographicLists.getAssetType());
    }

    @Test
    void testGetAssetImage() {
        infographicLists.setAssetImage("/image.jpg");
        assertEquals("/image.jpg", infographicLists.getAssetImage());
    }

    @Test
    void testGetImageAlt() {
        infographicLists.setImageAlt("Image Alt Text");
        assertEquals("Image Alt Text", infographicLists.getImageAlt());
    }

    @Test
    void testGetVideo() {
        infographicLists.setVideo("https://www.youtube.com/watch?v=abc123");
        assertEquals("https://www.youtube.com/embed/abc123", infographicLists.getVideo());
    }

    @Test
    void testGetVideoAlt() {
        infographicLists.setVideoAlt("Video Alt Text");
        assertEquals("Video Alt Text", infographicLists.getVideoAlt());
    }

    @Test
    void testGetSourceGif() {
        infographicLists.setSourceGif("/animation.gif");
        assertEquals("/animation.gif", infographicLists.getSourceGif());
    }

    @Test
    void testGetAltGif() {
        infographicLists.setAltGif("Alt Gif Text");
        assertEquals("Alt Gif Text", infographicLists.getAltGif());
    }
}
