package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.AccordionModel;
import com.neom.enowa.aem.core.models.accordion.AccordionItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccordionModelTest {

    private AccordionModel accordionModel;

    @BeforeEach
    void setUp() {
        accordionModel = new AccordionModel();
    }

    @Test
    void getAndSetAccordionMF() {
        List<AccordionItem> testList = new ArrayList<>();
        testList.add(new AccordionItem()); // Assuming a no-arg constructor in AccordionItem
        testList.add(new AccordionItem());

        accordionModel.setAccordionMF(testList);

        assertNotNull(accordionModel.getAccordionMF(), "AccordionMF list should not be null");
        assertEquals(2, accordionModel.getAccordionMF().size(), "AccordionMF list size should be 2");
        assertSame(testList, accordionModel.getAccordionMF(), "GetAccordionMF should return the same list as set in SetAccordionMF");
    }
}
