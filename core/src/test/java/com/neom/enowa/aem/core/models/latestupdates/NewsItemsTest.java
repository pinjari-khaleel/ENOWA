package com.neom.enowa.aem.core.models.latestupdates;

import com.neom.enowa.aem.core.models.latestupdates.NewsItems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

public class NewsItemsTest {

    private NewsItems newsItem;

    @BeforeEach
    void setUp() {
        // Initialize a NewsItems object before each test
        newsItem = new NewsItems();
    }

    @Test
    void testGetInnerTitle() {
        // Set an inner title for the news item
        newsItem.setInnerTitle("Test Inner Title");

        // Test the getInnerTitle() method
        assertEquals("Test Inner Title", newsItem.getInnerTitle());
    }

    @Test
    void testGetDescription() {
        // Set a description for the news item
        newsItem.setDescription("Test Description");

        // Test the getDescription() method
        assertEquals("Test Description", newsItem.getDescription());
    }

    @Test
    void testGetDate() {
        // Create a Calendar instance and set it as the date for the news item
        Calendar date = Calendar.getInstance();
        newsItem.setDate(date);

        // Test the getDate() method
        assertEquals(date, newsItem.getDate());
    }

    @Test
    void testGetLink() {
        // Set a link for the news item
        newsItem.setLink("https://example.com");

        // Test the getLink() method
        assertEquals("https://example.com.html", newsItem.getLink());
    }

    @Test
    void testGetAssetType() {
        // Set an asset type for the news item
        newsItem.setAssetType("Image");

        // Test the getAssetType() method
        assertEquals("Image", newsItem.getAssetType());
    }

    @Test
    void testGetSourceVideo() {
        // Set a source video URL for the news item
        newsItem.setSourceVideo("https://www.youtube.com/watch?v=abc123");

        // Test the getSourceVideo() method after URL conversion
        assertEquals("https://www.youtube.com/embed/abc123", newsItem.getSourceVideo());
    }

    @Test
    void testGetAltVideo() {
        // Set an alternate video URL for the news item
        newsItem.setAltVideo("https://www.example.com/video.mp4");

        // Test the getAltVideo() method
        assertEquals("https://www.example.com/video.mp4", newsItem.getAltVideo());
    }

    @Test
    void testGetSourceImg() {
        // Set a source image URL for the news item
        newsItem.setSourceImg("https://www.example.com/image.jpg");

        // Test the getSourceImg() method
        assertEquals("https://www.example.com/image.jpg", newsItem.getSourceImg());
    }

    @Test
    void testGetAltImg() {
        // Set an alternate image URL for the news item
        newsItem.setAltImg("https://www.example.com/alt-image.jpg");

        // Test the getAltImg() method
        assertEquals("https://www.example.com/alt-image.jpg", newsItem.getAltImg());
    }

    @Test
    void testIsVideoURLWithHttp() {
        // Set a source video URL starting with HTTP
        newsItem.setSourceVideo("https://www.youtube.com/watch?v=abc123");

        // Test the isVideoURL() method
        assertEquals(true, newsItem.isVideoURL());
    }

    @Test
    void testSetVideoURL() {
        // Set a source video URL starting with HTTP
        newsItem.setVideoURL(false);
        newsItem.setSourceVideo("/content/yes");

        // Test the isVideoURL() method
        assertEquals(false, newsItem.isVideoURL());
    }

    @Test
    void testIsVideoURLWithoutHttp() {
        // Set a source video URL without HTTP
        newsItem.setSourceVideo("www.youtube.com/watch?v=abc123");

        // Test the isVideoURL() method
        assertEquals(false, newsItem.isVideoURL());
    }
}
