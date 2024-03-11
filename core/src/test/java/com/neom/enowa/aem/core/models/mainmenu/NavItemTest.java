package com.neom.enowa.aem.core.models.mainmenu;

import com.neom.enowa.aem.core.models.mainmenu.NavChildItem;
import com.neom.enowa.aem.core.models.mainmenu.NavItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NavItemTest {

    private NavItem navItem;

    @BeforeEach
    public void setUp() {
        navItem = new NavItem();
    }

    @Test
    public void testGetSetTitle() {
        assertNull(navItem.getTitle());
        navItem.setTitle("Test Title");
        assertEquals("Test Title", navItem.getTitle());
    }

    @Test
    public void testGetSetPath() {
        assertNull(navItem.getPath());
        navItem.setPath("/test-path");
        assertEquals("/test-path", navItem.getPath());
    }

    @Test
    public void testGetSetAssetImage() {
        assertNull(navItem.getAssetImage());
        navItem.setAssetImage("image.jpg");
        assertEquals("image.jpg", navItem.getAssetImage());
    }

    @Test
    public void testGetSetImageAlt() {
        assertNull(navItem.getImageAlt());
        navItem.setImageAlt("Image Alt Text");
        assertEquals("Image Alt Text", navItem.getImageAlt());
    }

    @Test
    public void testGetSetInnerTitle() {
        assertNull(navItem.getInnerTitle());
        navItem.setInnerTitle("Inner Title");
        assertEquals("Inner Title", navItem.getInnerTitle());
    }

    @Test
    public void testGetSetChildItem() {
        assertNull(navItem.getChildItem());

        // Create a list of child items
        List<NavChildItem> childItems = new ArrayList<>();
        NavChildItem childItem1 = new NavChildItem("Child 1", "/child1");
        NavChildItem childItem2 = new NavChildItem("Child 2", "/child2");
        childItems.add(childItem1);
        childItems.add(childItem2);

        navItem.setChildItem(childItems);
        assertEquals(childItems, navItem.getChildItem());
    }

    @Test
    public void testGetSetPathPage() {
        assertNull(navItem.getPathPage());
        navItem.setPathPage("/page");
        assertEquals("/page", navItem.getPathPage());
    }

    @Test
    public void testToString() {
        navItem.setTitle("Test Title");
        navItem.setPath("/test-path");
        navItem.setAssetImage("image.jpg");
        navItem.setImageAlt("Image Alt Text");

        String expectedString = "NavItem{" +
                "title='Test Title', " +
                "path='/test-path', " +
                "assetImage='image.jpg', " +
                "imageAlt='Image Alt Text', " +
                "childItem=null" +
                "}";

        assertEquals(expectedString, navItem.toString());
    }
}
