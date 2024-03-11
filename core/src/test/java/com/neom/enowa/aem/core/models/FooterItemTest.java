package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.FooterItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FooterItemTest {

    private FooterItem footerItem;

    @BeforeEach
    void setUp() {
        footerItem = new FooterItem();
    }

    @Test
    void testDefaultConstructor() {
        assertNull(footerItem.getUrl());
        assertNull(footerItem.getHeading());
    }

    @Test
    void testParameterizedConstructor() {
        String testUrl = "https://example.com";
        String testHeading = "Example Heading";
        FooterItem paramFooterItem = new FooterItem(testUrl, testHeading);

        assertEquals(testUrl, paramFooterItem.getUrl());
        assertEquals(testHeading, paramFooterItem.getHeading());
    }

    @Test
    void testUrlGetterAndSetter() {
        String testUrl = "https://example.com";
        footerItem.setUrl(testUrl);
        assertEquals(testUrl, footerItem.getUrl());
    }

    @Test
    void testHeadingGetterAndSetter() {
        String testHeading = "Example Heading";
        footerItem.setHeading(testHeading);
        assertEquals(testHeading, footerItem.getHeading());
    }
}
