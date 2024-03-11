package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.HeaderItems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeaderItemsTest {

    private HeaderItems headerItems;

    @BeforeEach
    void setUp() {
        // Create an instance of HeaderItems before each test
        headerItems = new HeaderItems();
    }

    @Test
    void testGetSetBgAssetType() {
        // Set and assert the bgAssetType using setter and getter
        headerItems.setBgAssetType("Background");
        assertEquals("Background", headerItems.getBgAssetType());
    }

    @Test
    void testGetSetSourceVideo() {
        // Set and assert the sourceVideo using setter and getter
        headerItems.setSourceVideo("video.mp4");
        assertEquals("video.mp4", headerItems.getSourceVideo());
    }

    @Test
    void testGetSetAltVideo() {
        // Set and assert the altVideo using setter and getter
        headerItems.setAltVideo("alt_video.mp4");
        assertEquals("alt_video.mp4", headerItems.getAltVideo());
    }

    @Test
    void testGetSetSourceImg() {
        // Set and assert the sourceImg using setter and getter
        headerItems.setSourceImg("image.jpg");
        assertEquals("image.jpg", headerItems.getSourceImg());
    }

    @Test
    void testGetSetAltImg() {
        // Set and assert the altImg using setter and getter
        headerItems.setAltImg("alt_image.jpg");
        assertEquals("alt_image.jpg", headerItems.getAltImg());
    }

    @Test
    void testGetSetSourceGif() {
        // Set and assert the sourceGif using setter and getter
        headerItems.setSourceGif("animation.gif");
        assertEquals("animation.gif", headerItems.getSourceGif());
    }

    @Test
    void testGetSetAltGif() {
        // Set and assert the altGif using setter and getter
        headerItems.setAltGif("alt_animation.gif");
        assertEquals("alt_animation.gif", headerItems.getAltGif());
    }

    @Test
    void testGetSetTitle() {
        // Set and assert the title using setter and getter
        headerItems.setTitle("Header Title");
        assertEquals("Header Title", headerItems.getTitle());
    }

    @Test
    void testGetSetTitleSmall() {
        // Set and assert the titleSmall using setter and getter
        headerItems.setTitleSmall("Small Title");
        assertEquals("Small Title", headerItems.getTitleSmall());
    }

    @Test
    void testGetSetBtnLabel() {
        // Set and assert the btnLabel using setter and getter
        headerItems.setBtnLabel("Click Me");
        assertEquals("Click Me", headerItems.getBtnLabel());
    }

    @Test
    void testGetSetCtaAssetType() {
        // Set and assert the ctaAssetType using setter and getter
        headerItems.setCtaAssetType("CTA Type");
        assertEquals("CTA Type", headerItems.getCtaAssetType());
    }

    @Test
    void testGetSetCtaSourceVideo() {
        // Set and assert the ctaSourceVideo using setter and getter
        headerItems.setCtaSourceVideo("cta_video.mp4");
        assertEquals("cta_video.mp4", headerItems.getCtaSourceVideo());
    }

    @Test
    void testGetSetCtaSourceLink() {
        // Set and assert the ctaSourceLink using setter and getter
        headerItems.setCtaSourceLink("/cta-link");
        assertEquals("/cta-link", headerItems.getCtaSourceLink());
    }

    @Test
    void testGetSetOpenNewTab() {
        // Set and assert the openNewTab using setter and getter
        headerItems.setOpenNewTab(true);
        assertTrue(headerItems.getOpenNewTab());
    }
}
