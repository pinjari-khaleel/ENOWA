package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.CopyComponentModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CopyComponentModelTest {

    private CopyComponentModel copyComponentModel;

    @BeforeEach
    void setUp() {
        copyComponentModel = new CopyComponentModel();

        // Initialize the model with test data
        copyComponentModel.setTitle("Test Title");
        copyComponentModel.setBigTitle("Test Big Title");
        copyComponentModel.setHeaderTitle("Test Header Title");
        copyComponentModel.setText("Test Text");
        copyComponentModel.setAssetType("Test Asset Type");
        copyComponentModel.setImage("Test Image");
        copyComponentModel.setImageAlt("Test Image Alt");
        copyComponentModel.setSourceGif("Test Source Gif");
        copyComponentModel.setAltGif("Test Alt Gif");
        copyComponentModel.setVideo("Test Video");
        copyComponentModel.setVideoAlt("Test Video Alt");
        copyComponentModel.setBorderColor("Test Border Color");
    }

    @Test
    void testGettersAndSetters() {
        assertEquals("Test Title", copyComponentModel.getTitle());
        assertEquals("Test Big Title", copyComponentModel.getBigTitle());
        assertEquals("Test Header Title", copyComponentModel.getHeaderTitle());
        assertEquals("Test Text", copyComponentModel.getText());
        assertEquals("Test Asset Type", copyComponentModel.getAssetType());
        assertEquals("Test Image", copyComponentModel.getImage());
        assertEquals("Test Image Alt", copyComponentModel.getImageAlt());
        assertEquals("Test Source Gif", copyComponentModel.getSourceGif());
        assertEquals("Test Alt Gif", copyComponentModel.getAltGif());
        assertEquals("Test Video", copyComponentModel.getVideo());
        assertEquals("Test Video Alt", copyComponentModel.getVideoAlt());
        assertEquals("Test Border Color", copyComponentModel.getBorderColor());
    }
}
