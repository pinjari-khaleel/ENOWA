package com.neom.enowa.aem.core.models.header;

import com.neom.enowa.aem.core.constants.Constants;
import com.neom.enowa.aem.core.models.header.HeaderItem;
import com.neom.enowa.aem.core.utils.EnowaUtil;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class HeaderItemTest {

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private Resource resource;

    private HeaderItem headerItem;

    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        // Mock the SlingHttpServletRequest and Resource
        when(request.getResource()).thenReturn(resource);

        // Initialize the HeaderItem
        headerItem = new HeaderItem();
    }

    @Test
    void testGetTestUrlWithYouTubeLink() {
        // Prepare sample data
        String ctaSourceVideo = Constants.LINK_YOUTUBE + "VIDEO_ID";

        // Set the value for ctaSourceVideo
        headerItem.setCtaSourceVideo(ctaSourceVideo);

        // Test getTestUrl method
        String expectedTestUrl = EnowaUtil.convertToEmbedLinkForYoutube(ctaSourceVideo);
        String actualTestUrl = headerItem.getTestUrl();

        assertEquals(expectedTestUrl, actualTestUrl);
    }

    @Test
    void testGetTestUrlWithNonYouTubeLink() {
        // Prepare sample data
        String ctaSourceVideo = "https://example.com/video";

        // Set the value for ctaSourceVideo
        headerItem.setCtaSourceVideo(ctaSourceVideo);

        // Test getTestUrl method
        String expectedTestUrl = Constants.BLANK;
        String actualTestUrl = headerItem.getTestUrl();

        assertEquals(expectedTestUrl, actualTestUrl);
    }

    @Test
    void testGetCurrentPositionWithSingleDigit() {
        // Prepare sample data
        String currentPosition = "5";

        // Set the value for currentPosition
        headerItem.setCurrentPosition(currentPosition);

        // Test getCurrentPosition method
        String expectedCurrentPosition = "05";
        String actualCurrentPosition = headerItem.getCurrentPosition();

        assertEquals(expectedCurrentPosition, actualCurrentPosition);
    }

    @Test
    void testGetCurrentPositionWithDoubleDigit() {
        // Prepare sample data
        String currentPosition = "15";

        // Set the value for currentPosition
        headerItem.setCurrentPosition(currentPosition);

        // Test getCurrentPosition method
        String expectedCurrentPosition = "15";
        String actualCurrentPosition = headerItem.getCurrentPosition();

        assertEquals(expectedCurrentPosition, actualCurrentPosition);
    }

    @Test
    void testGettersAndSetters() {
        // Test getters and setters for the remaining properties
        headerItem.setAssetType("assetType");
        headerItem.setVideoBackgroundURL("videoBackgroundURL");
        headerItem.setVideoBackgroundURLAlt("videoBackgroundURLAlt");
        headerItem.setAssetImage("assetImage");
        headerItem.setImageAlt("imageAlt");
        headerItem.setTitle("title");
        headerItem.setTitleSmall("titleSmall");
        headerItem.setBtnLabel("btnLabel");
        headerItem.setCtaAssetType("ctaAssetType");
        headerItem.setCtaSourceLink("ctaSourceLink");

        assertEquals("assetType", headerItem.getAssetType());
        assertEquals("videoBackgroundURL", headerItem.getVideoBackgroundURL());
        assertEquals("videoBackgroundURLAlt", headerItem.getVideoBackgroundURLAlt());
        assertEquals("assetImage", headerItem.getAssetImage());
        assertEquals("imageAlt", headerItem.getImageAlt());
        assertEquals("title", headerItem.getTitle());
        assertEquals("titleSmall", headerItem.getTitleSmall());
        assertEquals("btnLabel", headerItem.getBtnLabel());
        assertEquals("ctaAssetType", headerItem.getCtaAssetType());
        assertEquals("ctaSourceLink", headerItem.getCtaSourceLink());
    }
}
