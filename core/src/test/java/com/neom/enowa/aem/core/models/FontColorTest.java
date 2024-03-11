package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.constants.Constants;
import com.neom.enowa.aem.core.models.FontColor;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class FontColorTest {

    @InjectMocks
    private FontColor fontColor;

    @Mock
    private Resource resource;

    @Mock
    private Resource resourceParent;

    @Mock
    private Resource resourceParentGeneralCopy;

    @Mock
    private ValueMap valueMap;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(resource.getParent()).thenReturn(resourceParent);
        when(resourceParent.getParent()).thenReturn(resourceParentGeneralCopy);
        when(resourceParentGeneralCopy.getValueMap()).thenReturn(valueMap);
    }

    @Test
    void testInitDefaultColor() {
        fontColor.init();
        assertEquals(Constants.CYAN_BLUE, fontColor.getColor());
    }

    @Test
    void testInitColorChange() {
        when(valueMap.get(Constants.SLING_RESOURCE_TYPE, String.class)).thenReturn(Constants.RESOURCE_TYPE_GENERAL_COPY);
        when(valueMap.get("bgColor", String.class)).thenReturn(Constants.CYAN_BLUE);

        fontColor.init();
        assertEquals(Constants.LIGHT_BLUE, fontColor.getColor());
    }
}
