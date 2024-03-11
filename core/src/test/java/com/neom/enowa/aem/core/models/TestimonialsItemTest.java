package com.neom.enowa.aem.core.models;


import com.neom.enowa.aem.core.models.TestimonialsItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestimonialsItemTest {

    private TestimonialsItem testimonialsItem;

    @BeforeEach
    public void setUp() {
        // Create an instance of TestimonialsItem
        testimonialsItem = new TestimonialsItem();
    }

    @Test
    public void testIdGetterAndSetter() {
        // Set an ID and test the getter
        testimonialsItem.setId("Test ID");
        assertEquals("Test ID", testimonialsItem.getId());
    }

    @Test
    public void testContentGetterAndSetter() {
        // Set content and test the getter
        testimonialsItem.setContent("Test Content");
        assertEquals("Test Content", testimonialsItem.getContent());
    }

    @Test
    public void testNameGetterAndSetter() {
        // Set a name and test the getter
        testimonialsItem.setName("Test Name");
        assertEquals("Test Name", testimonialsItem.getName());
    }

    @Test
    public void testProfessionGetterAndSetter() {
        // Set a profession and test the getter
        testimonialsItem.setProfession("Test Profession");
        assertEquals("Test Profession", testimonialsItem.getProfession());
    }

    @Test
    public void testDescriptionGetterAndSetter() {
        // Set a description and test the getter
        testimonialsItem.setDescription("Test Description");
        assertEquals("Test Description", testimonialsItem.getDescription());
    }

    @Test
    public void testProfileGetterAndSetter() {
        // Set a profile and test the getter
        testimonialsItem.setProfile("Test Profile");
        assertEquals("Test Profile", testimonialsItem.getProfile());
    }

    @Test
    public void testSplashGetterAndSetter() {
        // Set a splash and test the getter
        testimonialsItem.setSplash("Test Splash");
        assertEquals("Test Splash", testimonialsItem.getSplash());
    }

    @Test
    public void testLogoGetterAndSetter() {
        // Set a logo and test the getter
        testimonialsItem.setLogo("Test Logo");
        assertEquals("Test Logo", testimonialsItem.getLogo());
    }

    @Test
    public void testQuoteGetterAndSetter() {
        // Set a quote and test the getter
        testimonialsItem.setQuote("Test Quote");
        assertEquals("Test Quote", testimonialsItem.getQuote());
    }

    @Test
    public void testSourceTypeGetterAndSetter() {
        // Set a source type and test the getter
        testimonialsItem.setSourceType("Test Source Type");
        assertEquals("Test Source Type", testimonialsItem.getSourceType());
    }

    @Test
    public void testLinktextGetterAndSetter() {
        // Set a link text and test the getter
        testimonialsItem.setLinktext("Test Link Text");
        assertEquals("Test Link Text", testimonialsItem.getLinktext());
    }

    @Test
    public void testToStringMethod() {
        // Set values for the properties
        testimonialsItem.setId("1");
        testimonialsItem.setContent("Test Content");
        testimonialsItem.setName("John Doe");
        testimonialsItem.setProfession("Developer");

        // Test the toString method
        assertEquals("TestimonialsItem{id='1', content='Test Content', name='John Doe', profession='Developer', description='null', profile='null', splash='null', logo='null', quote='null', sourceType='null', linktext='null'}", testimonialsItem.toString());
    }


}
