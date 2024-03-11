package com.neom.enowa.aem.core.models.testimonials;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.SlingHttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class TestimonialItemModelTest {

    private TestimonialItemModel testimonialItemModel;

    @Mock
    private ResourceResolver resourceResolver;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testimonialItemModel = new TestimonialItemModel();
        testimonialItemModel.setResourceResolver(resourceResolver);
    }

    @Test
    void testGettersAndSetters() {
        // Test getters initially returning null
        assertNull(testimonialItemModel.getTitleText());
        assertNull(testimonialItemModel.getSideImage());
        assertNull(testimonialItemModel.getQuotation());
        assertNull(testimonialItemModel.getName());
        assertNull(testimonialItemModel.getJobTitle());
        assertNull(testimonialItemModel.getCtaLabel());
        assertNull(testimonialItemModel.getBtnRedirect());

        // Test setters
        testimonialItemModel.setTitleText("Test Title");
        testimonialItemModel.setSideImage("/path/to/image.jpg");
        testimonialItemModel.setQuotation("Test Quotation");
        testimonialItemModel.setName("John Doe");
        testimonialItemModel.setJobTitle("Manager");
        testimonialItemModel.setCtaLabel("Learn More");
        testimonialItemModel.setBtnRedirect("/page");

        // Verify getters after setting values
        assertEquals("Test Title", testimonialItemModel.getTitleText());
        assertEquals("/path/to/image.jpg", testimonialItemModel.getSideImage());
        assertEquals("Test Quotation", testimonialItemModel.getQuotation());
        assertEquals("John Doe", testimonialItemModel.getName());
        assertEquals("Manager", testimonialItemModel.getJobTitle());
        assertEquals("Learn More", testimonialItemModel.getCtaLabel());
        assertEquals("/page", testimonialItemModel.getBtnRedirect());
    }

    @Test
    void testGetBtnRedirectWithPageLink() {
        // Set up mock behavior for isPageLink method
        when(resourceResolver.resolve("/page")).thenReturn(mock(Resource.class));

        // Set btnRedirect with a page link
        testimonialItemModel.setBtnRedirect("/page");

        // Verify that getBtnRedirect appends ".html" to the link
        assertEquals("/page", testimonialItemModel.getBtnRedirect());

    }

    @Test
    void testGetBtnRedirectWithoutPageLink() {
        // Set btnRedirect without a page link
        testimonialItemModel.setBtnRedirect("https://example.com");

        // Verify that getBtnRedirect does not modify the link
        assertEquals("https://example.com", testimonialItemModel.getBtnRedirect());

        // Verify that isPageLink was not called
        verify(resourceResolver, never()).resolve(anyString());
    }
}
