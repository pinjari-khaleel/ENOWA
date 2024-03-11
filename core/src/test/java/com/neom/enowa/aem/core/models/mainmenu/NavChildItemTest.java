package com.neom.enowa.aem.core.models.mainmenu;

import com.neom.enowa.aem.core.models.mainmenu.NavChildItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NavChildItemTest {

    private NavChildItem navChildItem;

    @BeforeEach
    public void setUp() {
        navChildItem = new NavChildItem();
    }

    @Test
    public void testGetSetTitle() {
        assertNull(navChildItem.getTitle());
        navChildItem.setTitle("Child Title");
        assertEquals("Child Title", navChildItem.getTitle());
    }

    @Test
    public void testGetSetPath() {
        assertNull(navChildItem.getPath());
        navChildItem.setPath("/child-path");
        assertEquals("/child-path.html", navChildItem.getPath());
    }

    @Test
    public void testToString() {
        navChildItem.setTitle("Child Title");
        navChildItem.setPath("/child-path");

        String expectedString = "NavChildItem{" +
                "title='Child Title', " +
                "path='/child-path.html'" +
                "}";

        assertEquals(expectedString, navChildItem.toString());
    }
}
