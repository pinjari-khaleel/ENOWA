package com.neom.enowa.aem.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class InfographicsModelTablistTest {

    private InfographicsModelTablist infographicsModelTablist;
    private SlingHttpServletRequest request;
    private Resource resource;

    @BeforeEach
    void setUp() {
        infographicsModelTablist = new InfographicsModelTablist();
        request = Mockito.mock(SlingHttpServletRequest.class);
        resource = Mockito.mock(Resource.class);

        // Mock behavior
        when(request.getResource()).thenReturn(resource);
    }

    @Test
    void testGettersAndSetters() {
        // Set values
        infographicsModelTablist.setImage("image.jpg");
        infographicsModelTablist.setImageAlternativeText("Alt text");
        infographicsModelTablist.setTitle("Infographic Title");
        infographicsModelTablist.setDescription("Description of the infographic");

        // Verify getters return the correct values
        assertEquals("image.jpg", infographicsModelTablist.getImage());
        assertEquals("Alt text", infographicsModelTablist.getImageAlternativeText());
        assertEquals("Infographic Title", infographicsModelTablist.getTitle());
        assertEquals("Description of the infographic", infographicsModelTablist.getDescription());
    }
}
