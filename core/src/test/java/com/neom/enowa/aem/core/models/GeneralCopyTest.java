package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.constants.Constants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GeneralCopyTest {

    private GeneralCopy generalCopy;
    private SlingHttpServletRequest request;
    private Resource resource;
    private ValueMap valueMap;

    @BeforeEach
    void setUp() {
        generalCopy = new GeneralCopy();
        request = Mockito.mock(SlingHttpServletRequest.class);
        resource = Mockito.mock(Resource.class);
        valueMap = Mockito.mock(ValueMap.class);

        // Mock behavior
        when(request.getResource()).thenReturn(resource);
        when(resource.getValueMap()).thenReturn(valueMap);
    }

    @Test
    void testInit(){
        generalCopy.init();
        assertEquals(Constants.CYAN_BLUE, generalCopy.getColor());
    }
    @Test
    void testInit2(){

        generalCopy.setBgColor(Constants.CYAN_BLUE);
        generalCopy.init();

        // Assert that color remains CYAN_BLUE when bgColor is not CYAN_BLUE
        assertEquals(Constants.LIGHT_BLUE, generalCopy.getColor());
    }

    @Test
    void testSetAndGetColor() {
        // Set the color
        generalCopy.setColor("custom-color");

        // Verify that getColor returns the correct value
        assertEquals("custom-color", generalCopy.getColor());
    }

    @Test
    void testSetAndGetBgColor() {
        // Set the bg color
        generalCopy.setBgColor("custom-bg-color");

        // Verify that getBgColor returns the correct value
        assertEquals("custom-bg-color", generalCopy.getBgColor());
    }
}
