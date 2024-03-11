package com.neom.enowa.aem.core.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;

import javax.inject.Inject;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NewsItemsTest {

    @Inject
    private ModelFactory modelFactory;

    @BeforeEach
    void setUp() {
        modelFactory = mock(ModelFactory.class);
        // Initialize the AemContext to simulate an AEM environment.
    }

    @Test
    void testGettersAndSetters() {
        // Create a mock SlingHttpServletRequest and Resource.
        SlingHttpServletRequest request = mock(SlingHttpServletRequest.class);
        Resource resource = mock(Resource.class);

        // Create an instance of NewsItems using its constructor.
        NewsItems newsItems = new NewsItems();

        // Set values using setter methods.
        newsItems.setInnerTitle("Test Inner Title");
        newsItems.setDescription("Test Description");
        Calendar testDate = Calendar.getInstance();
        newsItems.setDate(testDate);
        newsItems.setLink("https://example.com");
        newsItems.setAssetType("Image");
        newsItems.setSourceVideo("https://youtube.com/video");
        newsItems.setAltVideo("Alt Video");
        newsItems.setSourceImg("https://example.com/image.jpg");
        newsItems.setAltImg("Alt Image");

        // Test getter methods.
        assertEquals("Test Inner Title", newsItems.getInnerTitle());
        assertEquals("Test Description", newsItems.getDescription());
        assertEquals(testDate, newsItems.getDate());
        assertEquals("https://example.com", newsItems.getLink());
        assertEquals("Image", newsItems.getAssetType());
        assertEquals("https://youtube.com/video", newsItems.getSourceVideo());
        assertEquals("Alt Video", newsItems.getAltVideo());
        assertEquals("https://example.com/image.jpg", newsItems.getSourceImg());
        assertEquals("Alt Image", newsItems.getAltImg());
    }
}
