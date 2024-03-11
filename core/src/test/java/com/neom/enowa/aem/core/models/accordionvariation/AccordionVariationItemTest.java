package com.neom.enowa.aem.core.models.accordionvariation;

import com.neom.enowa.aem.core.models.accordionvariation.AccordionVariationItem;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccordionVariationItemTest {

    @Mock
    private SlingHttpServletRequest slingRequest;

    @Mock
    private Resource resource;

    private AccordionVariationItem accordionVariationItem;

    @BeforeEach
    void setUp() {
        accordionVariationItem = new AccordionVariationItem();
    }

    @Test
    void testGettersAndSetters() {
        // Set questionTitle
        accordionVariationItem.setQuestionTitle("Question Title");

        // Verify that getQuestionTitle method returns the set questionTitle
        assertEquals("Question Title", accordionVariationItem.getQuestionTitle());

        // Set faqDescription
        accordionVariationItem.setFaqDescription("FAQ Description");

        // Verify that getFaqDescription method returns the set faqDescription
        assertEquals("FAQ Description", accordionVariationItem.getFaqDescription());
    }

    @Test
    void testGetQuestionTitleWithNullTitle() {
        // Verify that getQuestionTitle returns null when the questionTitle is not set
        assertNull(accordionVariationItem.getQuestionTitle());
    }

    @Test
    void testGetFaqDescriptionWithNullDescription() {
        // Verify that getFaqDescription returns null when the faqDescription is not set
        assertNull(accordionVariationItem.getFaqDescription());
    }
}
