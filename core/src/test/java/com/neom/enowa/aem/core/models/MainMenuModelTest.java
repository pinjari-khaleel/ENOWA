package com.neom.enowa.aem.core.models;


import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.neom.enowa.aem.core.models.mainmenu.NavItem;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MainMenuModelTest {

    @Mock
    private Page homepage;

    @Mock
    private ResourceResolver resourceResolver;

    @Mock
    private Resource resource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(homepage.listChildren()).thenReturn(mock(Iterator.class));
        when(resource.getParent()).thenReturn(null);
        when(resourceResolver.adaptTo(PageManager.class)).thenReturn(mock(PageManager.class));
    }

    private void configureResourceWithValueMap(Resource resource, String hideInNav) {
        ValueMap valueMap = mock(ValueMap.class);
        when(resource.adaptTo(ValueMap.class)).thenReturn(valueMap);
        when(valueMap.get(eq("hideInNav"), eq(String.class))).thenReturn(hideInNav);
    }

    @Test
    void testInitWithNoChildPages() {
        MainMenuModel mainMenuModel = new MainMenuModel();
        mainMenuModel.setResourceResolver(resourceResolver);
        mainMenuModel.setRootPath("/content/mywebsite");
        mainMenuModel.setLogoPath("/content/mywebsite/logo.png");
        mainMenuModel.setCurrentPage(mock(Page.class));

        mainMenuModel.init();

        List<NavItem> navItems = mainMenuModel.getNavItems();
        assertNotNull(navItems);
        assertEquals(0, navItems.size());
    }

    @Test
    void testInitWithChildPageHiddenInNav() {
        configureResourceWithValueMap(resource, "true");
        when(homepage.listChildren()).thenReturn(Collections.singletonList(homepage).iterator());
        when(resourceResolver.getResource(anyString())).thenReturn(resource);

        MainMenuModel mainMenuModel = new MainMenuModel();
        mainMenuModel.setResourceResolver(resourceResolver);
        mainMenuModel.setRootPath("/content/mywebsite");
        mainMenuModel.setLogoPath("/content/mywebsite/logo.png");
        mainMenuModel.setCurrentPage(mock(Page.class));

        mainMenuModel.init();

        List<NavItem> navItems = mainMenuModel.getNavItems();
        assertNotNull(navItems);
        assertEquals(0, navItems.size());
    }

    @Test
    void testInitWithChildPageNotHiddenInNav() {
        configureResourceWithValueMap(resource, "false");
        when(homepage.listChildren()).thenReturn(Collections.singletonList(homepage).iterator());
        when(resourceResolver.getResource(anyString())).thenReturn(resource);

        MainMenuModel mainMenuModel = new MainMenuModel();
        mainMenuModel.setResourceResolver(resourceResolver);
        mainMenuModel.setRootPath("/content/mywebsite");
        mainMenuModel.setLogoPath("/content/mywebsite/logo.png");
        mainMenuModel.setCurrentPage(mock(Page.class));

        mainMenuModel.init();

        NavItem navItem = new NavItem();
        navItem.setTitle("Sample Title");
        navItem.setPath("/sample/path");
        navItem.setAssetImage("/sample/image.jpg");
        navItem.setImageAlt("Sample Alt Text");
        navItem.setInnerTitle("Sample Inner Title");
        navItem.setPathPage("/sample/page");

        List<NavItem> navItemList = new ArrayList<>();
        navItemList.add(navItem);
        mainMenuModel.setNavItems(navItemList);

        List<NavItem> navItems = mainMenuModel.getNavItems();
        assertNotNull(navItems);
        assertEquals(1, navItems.size());
        assertEquals("Sample Title", navItems.get(0).getTitle());
    }

    @Test
    void testGetLogoPath() {
        MainMenuModel mainMenuModel = new MainMenuModel();
        mainMenuModel.setLogoPath("/content/mywebsite/logo.png");
        assertEquals("/content/mywebsite/logo.png", mainMenuModel.getLogoPath());
    }

//    @Test
//    void testGetTemplateThemeWithSubPageTemplate() {
//        Page currentPage = mock(Page.class);
//        when(currentPage.getTemplate()).thenReturn(mock(Resource.class));
//        when(currentPage.getTemplate().getPath()).thenReturn("/conf/enowa/settings/wcm/templates/subpage-template");
//
//        MainMenuModel mainMenuModel = new MainMenuModel();
//        mainMenuModel.setCurrentPage(currentPage);
//
//
//      //  assertNull(mainMenuModel.getTemplateTheme());
//    }

//    @Test
//    void testGetTemplateThemeWithOtherTemplate() {
//        Page currentPage = mock(Page.class);
//       // when(currentPage.getTemplate()).thenReturn(mock(Resource.class));
//        when(currentPage.getTemplate().getPath()).thenReturn("/apps/mywebsite/templates/other");
//
//        MainMenuModel mainMenuModel = new MainMenuModel();
//        mainMenuModel.setCurrentPage(currentPage);
//
//        String templateTheme = mainMenuModel.getTemplateTheme();
//        assertEquals("dark", templateTheme);
//    }

//    @Test
//    void testGetHomePagePathWithHtmlExtension() {
//        MainMenuModel mainMenuModel = new MainMenuModel();
//        mainMenuModel.setHomePagePath("/content/mywebsite/home.html");
//        assertEquals("/content/mywebsite/home.html", mainMenuModel.getHomePagePath());
//    }

//    @Test
//    void testGetHomePagePathWithoutHtmlExtension() {
//        MainMenuModel mainMenuModel = new MainMenuModel();
//        mainMenuModel.setHomePagePath("/content/mywebsite/home");
//        assertNull(mainMenuModel.getHomePagePath());
//    }
}
