package com.neom.enowa.aem.core.models;


import com.neom.enowa.aem.core.models.TeamCardsModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamCardsModelTest {

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private Resource resource;

    private TeamCardsModel teamCardsModel;

    @BeforeEach
    public void setUp() {
        // Initialize Mockito annotations
        MockitoAnnotations.initMocks(this);

        // Create an instance of TeamCardsModel using the ModelFactory
        teamCardsModel = new TeamCardsModel();
    }

    @Test
    public void testThemeGetterAndSetter() {
        // Set a theme and test the getter
        teamCardsModel.setTheme("Test Theme");
        assertEquals("Test Theme", teamCardsModel.getTheme());
    }

    @Test
    public void testImageGetterAndSetter() {
        // Set an image URL and test the getter
        teamCardsModel.setImage("https://example.com/image.jpg");
        assertEquals("https://example.com/image.jpg", teamCardsModel.getImage());
    }

    @Test
    public void testImageAlternativeTextGetterAndSetter() {
        // Set image alternative text and test the getter
        teamCardsModel.setImageAlternativeText("Alt Text");
        assertEquals("Alt Text", teamCardsModel.getImageAlternativeText());
    }

    @Test
    public void testNameGetterAndSetter() {
        // Set a name and test the getter
        teamCardsModel.setName("John Doe");
        assertEquals("John Doe", teamCardsModel.getName());
    }

    @Test
    public void testTitleGetterAndSetter() {
        // Set a title and test the getter
        teamCardsModel.setTitle("Test Title");
        assertEquals("Test Title", teamCardsModel.getTitle());
    }

    @Test
    public void testDescriptionGetterAndSetter() {
        // Set a description and test the getter
        teamCardsModel.setDescription("Test Description\nLine 2\nLine 3");
        assertEquals("Test Description<p>Line 2</p><p>Line 3</p>", teamCardsModel.getDescription());
    }

    @Test
    public void testShortDescriptionGetterAndSetter() {
        // Set a short description and test the getter
        teamCardsModel.setShortDescription("Short Description");
        assertEquals("Short Description", teamCardsModel.getShortDescription());
    }
}
