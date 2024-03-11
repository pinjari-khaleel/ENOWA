package com.neom.enowa.aem.core.models;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.neom.enowa.aem.core.models.FooterItem;
import com.neom.enowa.aem.core.models.FooterModel;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FooterModelTest {

    @InjectMocks
    private FooterModel footerModel;

    @Mock
    private ResourceResolver resourceResolver;

    @Mock
    private Page currentPage;

    @Mock
    private Page absoluteParentPage;

    @Mock
    private Resource resource;

    @Mock
    private ValueMap valueMap;

    @Mock
    private Resource pageResource;

    @Mock
    private PageManager pageManager;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(currentPage.getAbsoluteParent(3)).thenReturn(absoluteParentPage);
        when(absoluteParentPage.getPath()).thenReturn("/content/site");
        when(currentPage.getPath()).thenReturn("/content/site/en/home");

        when(resourceResolver.getResource(anyString())).thenReturn(pageResource);

        // Mock the behavior of resourceResolver.adaptTo(PageManager.class)
        when(resourceResolver.adaptTo(PageManager.class)).thenReturn(pageManager);

        // Mock the behavior of pageManager.getContainingPage(pageResource)
        when(pageManager.getContainingPage(pageResource)).thenReturn(currentPage);

        // Mock the behavior of page.getProperties()
        when(currentPage.getProperties()).thenReturn(valueMap);
    }

    @Test
    void testInitMethod() {
        // Mocking the resource hierarchy
        when(currentPage.getAbsoluteParent(3)).thenReturn(absoluteParentPage);
        when(absoluteParentPage.getPath()).thenReturn("/content/site");
        when(currentPage.getPath()).thenReturn("/content/site/en/home");

        // Mocking the resource resolver and page manager
        PageManager pageManager = mock(PageManager.class);
        when(resourceResolver.adaptTo(PageManager.class)).thenReturn(pageManager);
        when(pageManager.getContainingPage(any(Resource.class))).thenReturn(absoluteParentPage);

        // Mocking page properties for title retrieval
        ValueMap pageProperties = mock(ValueMap.class);
        when(absoluteParentPage.getProperties()).thenReturn(pageProperties);
        when(pageProperties.get("hideInNav", String.class)).thenReturn("false");
        when(absoluteParentPage.getTitle()).thenReturn("Home");

        footerModel.init();

        // Assertions
        List<FooterItem> footerItems = footerModel.getFooterItems();
        assertEquals(0,footerItems.size());
    }

    @Test
    void testGettersAndSetters() {
        // Test each getter and setter method
        String testPolicyText = "Policy Text";
        footerModel.setPolicyText(testPolicyText);
        assertEquals(testPolicyText, footerModel.getPolicyText());

        // Repeat for other fields
    }

    @Test
    void testLinkFormatting() {
        footerModel.setPolicyLink("/policy");
        assertEquals("/policy.html", footerModel.getPolicyLink());

        footerModel.setTermsLink("/terms");
        assertEquals("/terms.html", footerModel.getTermsLink());

        footerModel.setCookieLink("/cookie");
        assertEquals("/cookie.html", footerModel.getCookieLink());
    }

    @Test
    void testGetResourcePageTitle() {
        // Set up a sample pagePath
        String pagePath = "/content/sample/page";

        // Set up a sample value for hideInNav
        when(valueMap.get(eq("hideInNav"), eq(String.class))).thenReturn("false");


        // Call the getResourcePageTitle method
        String pageTitle = footerModel.getResourcePageTitle(pagePath);

        // Verify that the pageResource is retrieved correctly
        verify(resourceResolver).getResource(eq(pagePath));

        // Verify that the PageManager is used to get the containing page
        verify(resourceResolver).adaptTo(eq(PageManager.class));
        verify(pageManager).getContainingPage(eq(pageResource));

        // Verify that the page properties are accessed
        verify(currentPage).getProperties();

        // Verify that hideInNav is checked and pageTitle is set accordingly
        assertNull(pageTitle);
    }

    @Test
    void testFooterItems(){

        List<FooterItem> footerItemList = new ArrayList<>();
        footerItemList.add(new FooterItem("http:","Heading"));
        footerItemList.add(new FooterItem("http:","Heading"));
        footerItemList.add(new FooterItem("http:","Heading"));
        footerItemList.add(new FooterItem("http:","Heading"));

        footerModel.setFooterItems(footerItemList);

        assertNotNull(footerModel.getFooterItems());
        assertNotEquals(0,footerModel.getFooterItemSize());
        footerModel.setFooterItemSize(footerItemList.size());
        assertEquals(4,footerModel.getFooterItemSize());

        footerModel.setCookieText("cookie");
        footerModel.setCookieLink("cookieLink");
        footerModel.setCopyRight("copyRight");
        footerModel.setTermsText("terms");
        footerModel.setTermsLink("termsLink");

        assertEquals("cookie",footerModel.getCookieText());
        assertEquals("cookieLink",footerModel.getCookieLink());
        assertEquals("copyRight",footerModel.getCopyRight());
        assertEquals("terms",footerModel.getTermsText());
        assertEquals("termsLink",footerModel.getTermsLink());


    }

}
