package com.neom.enowa.aem.core.models.latestupdates;

import com.neom.enowa.aem.core.models.latestupdates.LatestNewsItems;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LatestNewsItemsTest {

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private Resource resource;

    private LatestNewsItems latestNewsItems;

    @BeforeEach
    public void setUp() {
        // Initialize Mockito annotations
        MockitoAnnotations.initMocks(this);

        // Create an instance of LatestNewsItems
        latestNewsItems = new LatestNewsItems();
    }

    @Test
    public void testInnerTitleGetterAndSetter() {
        // Set inner title and test the getter
        latestNewsItems.setInnerTitle("Test Inner Title");
        assertEquals("Test Inner Title", latestNewsItems.getInnerTitle());
    }

    @Test
    public void testDescriptionGetterAndSetter() {
        // Set description and test the getter
        latestNewsItems.setDescription("Test Description");
        assertEquals("Test Description", latestNewsItems.getDescription());
    }

    @Test
    public void testDateGetterAndSetter() {
        // Create a Calendar instance and set it as the date
        Calendar calendar = Calendar.getInstance();
        latestNewsItems.setDate(calendar);
        assertEquals(calendar, latestNewsItems.getDate());
    }

    @Test
    public void testLinkGetter() {
        // Set the link and test the getter with the expected format
        latestNewsItems.setLink("/test/link");
        assertEquals("/test/link.html", latestNewsItems.getLink());
    }

    @Test
    public void testAssetTypeGetterAndSetter() {
        // Set asset type and test the getter
        latestNewsItems.setAssetType("Image");
        assertEquals("Image", latestNewsItems.getAssetType());
    }

    @Test
    public void testSourceVideoGetter() {
        // Set source video URL and test the getter with conversion to embed link
        latestNewsItems.setSourceVideo("https://www.youtube.com/watch?v=video_id");
        assertEquals("https://www.youtube.com/embed/video_id", latestNewsItems.getSourceVideo());
    }

    @Test
    public void testAltVideoGetterAndSetter() {
        // Set alternate video URL and test the getter
        latestNewsItems.setAltVideo("https://example.com/alt-video.mp4");
        assertEquals("https://example.com/alt-video.mp4", latestNewsItems.getAltVideo());
    }

    @Test
    public void testSourceImgGetterAndSetter() {
        // Set source image URL and test the getter
        latestNewsItems.setSourceImg("https://example.com/image.jpg");
        assertEquals("https://example.com/image.jpg", latestNewsItems.getSourceImg());
    }

    @Test
    public void testAltImgGetterAndSetter() {
        // Set alternate image URL and test the getter
        latestNewsItems.setAltImg("https://example.com/alt-image.jpg");
        assertEquals("https://example.com/alt-image.jpg", latestNewsItems.getAltImg());
    }

    @Test
    public void testIsVideoURL() {
        // Set source video URL starting with "https" and test isVideoURL
        latestNewsItems.setSourceVideo("https://www.youtube.com/watch?v=video_id");
        assertEquals(true, latestNewsItems.isVideoURL());

        // Set source video URL starting with "http" and test isVideoURL
        latestNewsItems.setSourceVideo("http://www.example.com/video.mp4");
        assertEquals(true, latestNewsItems.isVideoURL());

        // Set source video URL without "http" or "https" and test isVideoURL
        latestNewsItems.setSourceVideo("www.example.com/video.mp4");
        assertEquals(false, latestNewsItems.isVideoURL());
    }
}
