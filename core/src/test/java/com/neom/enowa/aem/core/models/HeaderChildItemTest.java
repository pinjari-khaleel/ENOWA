package com.neom.enowa.aem.core.models;


import com.neom.enowa.aem.core.models.HeaderChildItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeaderChildItemTest {

    private HeaderChildItem headerChildItem;

    @BeforeEach
    void setUp() {
        // Create an instance of HeaderChildItem before each test
        headerChildItem = new HeaderChildItem();
    }

    @Test
    void testSetAndGetBgAssetType() {
        // Set the bgAssetType
        headerChildItem.setBgAssetType("Background");

        // Get and assert the bgAssetType
        assertEquals("Background", headerChildItem.getBgAssetType());
    }

    @Test
    void testSetAndGetSourceVideo() {
        // Set the sourceVideo
        headerChildItem.setSourceVideo("video.mp4");

        // Get and assert the sourceVideo
        assertEquals("video.mp4", headerChildItem.getSourceVideo());
    }

    @Test
    void testSetAndGetAltVideo() {
        // Set the altVideo
        headerChildItem.setAltVideo("alt_video.mp4");

        // Get and assert the altVideo
        assertEquals("alt_video.mp4", headerChildItem.getAltVideo());
    }

    @Test
    void testSetAndGetSourceImg() {
        // Set the sourceImg
        headerChildItem.setSourceImg("image.jpg");

        // Get and assert the sourceImg
        assertEquals("image.jpg", headerChildItem.getSourceImg());
    }

    @Test
    void testSetAndGetAltImg() {
        // Set the altImg
        headerChildItem.setAltImg("alt_image.jpg");

        // Get and assert the altImg
        assertEquals("alt_image.jpg", headerChildItem.getAltImg());
    }

    @Test
    void testSetAndGetSourceGif() {
        // Set the sourceGif
        headerChildItem.setSourceGif("animation.gif");

        // Get and assert the sourceGif
        assertEquals("animation.gif", headerChildItem.getSourceGif());
    }

    @Test
    void testSetAndGetAltGif() {
        // Set the altGif
        headerChildItem.setAltGif("alt_animation.gif");

        // Get and assert the altGif
        assertEquals("alt_animation.gif", headerChildItem.getAltGif());
    }

    @Test
    void testSetAndGetTitle() {
        // Set the title
        headerChildItem.setTitle("Header Title");

        // Get and assert the title
        assertEquals("Header Title", headerChildItem.getTitle());
    }

    @Test
    void testSetAndGetTitleSmall() {
        // Set the titleSmall
        headerChildItem.setTitleSmall("Small Title");

        // Get and assert the titleSmall
        assertEquals("Small Title", headerChildItem.getTitleSmall());
    }

    @Test
    void testSetAndGetBtnLabel() {
        // Set the btnLabel
        headerChildItem.setBtnLabel("Click Me");

        // Get and assert the btnLabel
        assertEquals("Click Me", headerChildItem.getBtnLabel());
    }

    @Test
    void testSetAndGetCtaAssetType() {
        // Set the ctaAssetType
        headerChildItem.setCtaAssetType("CTA Type");

        // Get and assert the ctaAssetType
        assertEquals("CTA Type", headerChildItem.getCtaAssetType());
    }

    @Test
    void testSetAndGetCtaSourceVideo() {
        // Set the ctaSourceVideo
        headerChildItem.setCtaSourceVideo("cta_video.mp4");

        // Get and assert the ctaSourceVideo
        assertEquals("cta_video.mp4", headerChildItem.getCtaSourceVideo());
    }

    @Test
    void testSetAndGetCtaSourceLink() {
        // Set the ctaSourceLink
        headerChildItem.setCtaSourceLink("/cta-link");

        // Get and assert the ctaSourceLink
        assertEquals("/cta-link", headerChildItem.getCtaSourceLink());
    }

    @Test
    void testSetAndGetOpenNewTab() {
        // Set the openNewTab
        headerChildItem.setOpenNewTab(true);

        // Get and assert the openNewTab
        assertTrue(headerChildItem.getOpenNewTab());
    }

    @Test
    void testSetAndGetCount() {
        // Set the count
        headerChildItem.setCount("5");

        // Get and assert the count
        assertEquals("5", headerChildItem.getCount());
    }

    @Test
    void testSetAndGetTitleChild() {
        // Set the titleChild
        headerChildItem.setTitleChild("Child Title");

        // Get and assert the titleChild
        assertEquals("Child Title", headerChildItem.getTitleChild());
    }

    @Test
    void testSetAndGetBgAssetTypeChild() {
        // Set the bgAssetTypeChild
        headerChildItem.setBgAssetTypeChild("Child Background");

        // Get and assert the bgAssetTypeChild
        assertEquals("Child Background", headerChildItem.getBgAssetTypeChild());
    }

    @Test
    void testSetAndGetSourceVideoChild() {
        // Set the sourceVideoChild
        headerChildItem.setSourceVideoChild("child_video.mp4");

        // Get and assert the sourceVideoChild
        assertEquals("child_video.mp4", headerChildItem.getSourceVideoChild());
    }

    @Test
    void testSetAndGetAltVideoChild() {
        // Set the altVideoChild
        headerChildItem.setAltVideoChild("alt_child_video.mp4");

        // Get and assert the altVideoChild
        assertEquals("alt_child_video.mp4", headerChildItem.getAltVideoChild());
    }

    @Test
    void testSetAndGetSourceImgChild() {
        // Set the sourceImgChild
        headerChildItem.setSourceImgChild("child_image.jpg");

        // Get and assert the sourceImgChild
        assertEquals("child_image.jpg", headerChildItem.getSourceImgChild());
    }

    @Test
    void testSetAndGetAltImgChild() {
        // Set the altImgChild
        headerChildItem.setAltImgChild("alt_child_image.jpg");

        // Get and assert the altImgChild
        assertEquals("alt_child_image.jpg", headerChildItem.getAltImgChild());
    }

    @Test
    void testSetAndGetSourceGifChild() {
        // Set the sourceGifChild
        headerChildItem.setSourceGifChild("child_animation.gif");

        // Get and assert the sourceGifChild
        assertEquals("child_animation.gif", headerChildItem.getSourceGifChild());
    }

    @Test
    void testSetAndGetAltGifChild() {
        // Set the altGifChild
        headerChildItem.setAltGifChild("alt_child_animation.gif");

        // Get and assert the altGifChild
        assertEquals("alt_child_animation.gif", headerChildItem.getAltGifChild());
    }
}

