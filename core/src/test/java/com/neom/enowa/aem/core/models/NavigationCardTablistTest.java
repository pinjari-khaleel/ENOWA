package com.neom.enowa.aem.core.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigationCardTablistTest {

    @Test
    void testTitleGetterSetter() {
        NavigationCardTablist navigationCardTablist = new NavigationCardTablist();
        navigationCardTablist.setTitle("Sample Title");
        assertEquals("Sample Title", navigationCardTablist.getTitle());
    }

    @Test
    void testDescriptionGetterSetter() {
        NavigationCardTablist navigationCardTablist = new NavigationCardTablist();
        navigationCardTablist.setDescription("Sample Description");
        assertEquals("Sample Description", navigationCardTablist.getDescription());
    }

    @Test
    void testLinkURLGetterSetter() {
        NavigationCardTablist navigationCardTablist = new NavigationCardTablist();
        navigationCardTablist.setLinkURL("https://example.com");
        assertEquals("https://example.com", navigationCardTablist.getLinkURL());
    }

    @Test
    void testAssetTypeGetterSetter() {
        NavigationCardTablist navigationCardTablist = new NavigationCardTablist();
        navigationCardTablist.setAssetType("Sample Asset Type");
        assertEquals("Sample Asset Type", navigationCardTablist.getAssetType());
    }

    @Test
    void testAssetImageGetterSetter() {
        NavigationCardTablist navigationCardTablist = new NavigationCardTablist();
        navigationCardTablist.setAssetImage("sample.jpg");
        assertEquals("sample.jpg", navigationCardTablist.getAssetImage());
    }

    @Test
    void testImageAltGetterSetter() {
        NavigationCardTablist navigationCardTablist = new NavigationCardTablist();
        navigationCardTablist.setImageAlt("Image Alt Text");
        assertEquals("Image Alt Text", navigationCardTablist.getImageAlt());
    }

    @Test
    void testVideoBackgroundImageGetterSetter() {
        NavigationCardTablist navigationCardTablist = new NavigationCardTablist();
        navigationCardTablist.setVideoBackgroundImage("video.jpg");
        assertEquals("video.jpg", navigationCardTablist.getVideoBackgroundImage());
    }

    @Test
    void testVideoBackgroudImageAltGetterSetter() {
        NavigationCardTablist navigationCardTablist = new NavigationCardTablist();
        navigationCardTablist.setVideoBackgroudImageAlt("Video Background Alt Text");
        assertEquals("Video Background Alt Text", navigationCardTablist.getVideoBackgroudImageAlt());
    }
}
