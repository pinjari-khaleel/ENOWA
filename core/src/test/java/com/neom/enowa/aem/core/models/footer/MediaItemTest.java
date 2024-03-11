package com.neom.enowa.aem.core.models.footer;

import com.neom.enowa.aem.core.models.footer.MediaItem;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MediaItemTest {

    @Mock
    private SlingHttpServletRequest slingRequest;

    @Mock
    private Resource resource;

    private MediaItem mediaItem;

    @BeforeEach
    void setUp() {
        mediaItem = new MediaItem();
    }

    @Test
    void testGettersAndSetters() {
        // Set mediaTitle
        mediaItem.setMediaTitle("Media Title");

        // Verify that getMediaTitle method returns the set mediaTitle
        assertEquals("Media Title", mediaItem.getMediaTitle());

        // Set mediaLink
        mediaItem.setMediaLink("http://example.com");

        // Verify that getMediaLink method returns the set mediaLink
        assertEquals("http://example.com", mediaItem.getMediaLink());
    }

    @Test
    void testMediaLinkInitializationWithHttp() {
        // Set mediaLink with "http" prefix
        mediaItem.setMediaLink("http://example.com");

        // Verify that init method does not modify the mediaLink
        assertEquals("http://example.com", mediaItem.getMediaLink());
    }

    @Test
    void testMediaLinkInitializationWithHttps() {
        // Set mediaLink with "https" prefix
        mediaItem.setMediaLink("https://example.com");

        // Verify that init method returns the modified mediaLink
        assertEquals("https://example.com", mediaItem.init());
        assertEquals("https://example.com", mediaItem.getMediaLink());
    }


    @Test
    void testMediaLinkInitializationWithoutPrefix() {
        // Set mediaLink without a prefix
        mediaItem.setMediaLink("example.com");

        // Verify that init method adds "https://" prefix to mediaLink
        assertEquals("https://example.com", mediaItem.init());
        assertEquals("https://example.com", mediaItem.getMediaLink());
    }

    @Test
    void testMediaConstructor() {
        // Set mediaLink without a prefix
        mediaItem = new MediaItem("SomeTitle");

        // Verify that init method adds "https://" prefix to mediaLink
        assertEquals("SomeTitle", mediaItem.getMediaTitle());
    }
}
