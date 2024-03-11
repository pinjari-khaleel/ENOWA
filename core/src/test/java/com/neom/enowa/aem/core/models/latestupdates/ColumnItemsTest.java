package com.neom.enowa.aem.core.models.latestupdates;

import com.neom.enowa.aem.core.models.latestupdates.ColumnItems;
import com.neom.enowa.aem.core.models.latestupdates.NewsItems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class ColumnItemsTest {

    private ColumnItems columnItems;

    @BeforeEach
    public void setUp() {
        // Create an instance of ColumnItems
        columnItems = new ColumnItems();
    }

    @Test
    public void testRightColumnItemGetterAndSetter() {
        // Create a mock NewsItems object for the right column item
        NewsItems rightColumnItem = mock(NewsItems.class);

        // Set the right column item and test the getter
        columnItems.setRightColumnItem(rightColumnItem);
        assertEquals(rightColumnItem, columnItems.getRightColumnItem());
    }

    @Test
    public void testLeftColumnItemGetterAndSetter() {
        // Create a mock NewsItems object for the left column item
        NewsItems leftColumnItem = mock(NewsItems.class);

        // Set the left column item and test the getter
        columnItems.setLeftColumnItem(leftColumnItem);
        assertEquals(leftColumnItem, columnItems.getLeftColumnItem());
    }
}
