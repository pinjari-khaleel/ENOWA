package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.navigationcard.NavigationCardTabLists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NavigationCardModelTest {

    @Test
    void testBlockTitleGetterSetter() {
        // Create an instance of NavigationCardModel
        NavigationCardModel navigationCardModel = new NavigationCardModel();

        // Set the blockTitle using the setter
        navigationCardModel.setBlockTitle("Sample Block Title");

        // Verify that the blockTitle getter returns the expected value
        assertEquals("Sample Block Title", navigationCardModel.getBlockTitle());
    }

    @Test
    void testNavigationCardTabListsGetterSetter() {
        // Create an instance of NavigationCardModel
        NavigationCardModel navigationCardModel = new NavigationCardModel();

        // Create a sample list of NavigationCardTabLists
        List<NavigationCardTabLists> tabLists = new ArrayList<>();
        NavigationCardTabLists tabList1 = new NavigationCardTabLists();
        NavigationCardTabLists tabList2 = new NavigationCardTabLists();
        tabLists.add(tabList1);
        tabLists.add(tabList2);

        // Set the navigationCardTabLists using the setter
        navigationCardModel.setNavigationCardTabLists(tabLists);

        // Verify that the navigationCardTabLists getter returns a non-null list
        assertNotNull(navigationCardModel.getNavigationCardTabLists());

        // Verify that the size of the returned list matches the size of the input list
        assertEquals(2, navigationCardModel.getNavigationCardTabLists().size());
    }
}
