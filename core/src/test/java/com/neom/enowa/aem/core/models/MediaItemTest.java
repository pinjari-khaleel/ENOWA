package com.neom.enowa.aem.core.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MediaItemTest {

    @Test
    void testMediaTitleGetterSetter() {
        // Create an instance of MediaItem
        MediaItem mediaItem = new MediaItem();

        // Set the mediaTitle using the setter
        mediaItem.setMediaTitle("Sample Media Title");

        // Verify that the mediaTitle getter returns the expected value
        assertEquals("Sample Media Title", mediaItem.getMediaTitle());
    }

    @Test
    void testMediaLinkGetterSetter() {
        // Create an instance of MediaItem
        MediaItem mediaItem = new MediaItem();

        // Set the mediaLink using the setter
        mediaItem.setMediaLink("https://example.com/sample-media-link");

        // Verify that the mediaLink getter returns the expected value
        assertEquals("https://example.com/sample-media-link", mediaItem.getMediaLink());
    }
}
