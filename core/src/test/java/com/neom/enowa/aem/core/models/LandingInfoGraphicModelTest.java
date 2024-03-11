package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.landinginfographic.LandingInfographicLists;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LandingInfoGraphicModelTest {

    private LandingInfoGraphicModel landingInfoGraphicModel;
    private Resource resource;

    @BeforeEach
    void setUp() {
        landingInfoGraphicModel = new LandingInfoGraphicModel();
        resource = Mockito.mock(Resource.class);
    }

    @Test
    void testGetInfographicLists() {
        // Create a list of LandingInfographicLists
        List<LandingInfographicLists> infographicLists = new ArrayList<>();
        infographicLists.add(new LandingInfographicLists());
        infographicLists.add(new LandingInfographicLists());

        // Set the infographicLists property
        landingInfoGraphicModel.setInfographicLists(infographicLists);

        // Get the infographicLists and verify they match
        List<LandingInfographicLists> retrievedLists = landingInfoGraphicModel.getInfographicLists();
        assertEquals(infographicLists, retrievedLists);
    }

    @Test
    void testSetInfographicLists() {
        // Create a list of LandingInfographicLists
        List<LandingInfographicLists> infographicLists = new ArrayList<>();
        infographicLists.add(new LandingInfographicLists());
        infographicLists.add(new LandingInfographicLists());

        // Set the infographicLists property
        landingInfoGraphicModel.setInfographicLists(infographicLists);

        // Get the infographicLists and verify they match
        List<LandingInfographicLists> retrievedLists = landingInfoGraphicModel.getInfographicLists();
        assertEquals(infographicLists, retrievedLists);
    }
}
