package com.neom.enowa.aem.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.*;
import org.apache.sling.api.wrappers.ValueMapDecorator;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.osgi.framework.Constants;

import java.util.Collections;

public class PageModelTest {
    private static final String FAVICON = "favicon"; // Define the FAVICON constant

    @InjectMocks
    private PageModel pageModel;

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private Resource resource;

    @Mock
    private ResourceResolver resourceResolver;

    @Mock
    private Resource parentResource;

    @Mock
    private PageManager pageManager;

    @Mock
    private Page rootPage;

    @Mock
    private ModifiableValueMap modifiableValueMap;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pageModel.setResource(resource);
    }

    @Test
    void testInitWithFavicon() throws PersistenceException {
        // Arrange
        when(resource.getParent()).thenReturn(parentResource);
        when(parentResource.getPath()).thenReturn("/content/mysite/en");
        when(resource.getResourceResolver()).thenReturn(resourceResolver);
        when(resourceResolver.adaptTo(PageManager.class)).thenReturn(pageManager);
        when(pageManager.getPage("/content/mysite")).thenReturn(rootPage);
        when(rootPage.getProperties()).thenReturn(new ValueMapDecorator(Collections.singletonMap(FAVICON, "favicon.png")));
        when(resource.adaptTo(ModifiableValueMap.class)).thenReturn(modifiableValueMap);

        // Act
        pageModel.init();

        // Assert
        verify(modifiableValueMap).put(FAVICON, "favicon.png");
        verify(resourceResolver).commit();
        assertEquals("favicon.png", pageModel.getFavicon());
    }

    @Test
    void testInitWithoutFavicon() throws PersistenceException {
        // Arrange
        when(resource.getParent()).thenReturn(parentResource);
        when(parentResource.getPath()).thenReturn("/content/mysite/en");
        when(resource.getResourceResolver()).thenReturn(resourceResolver);
        when(resourceResolver.adaptTo(PageManager.class)).thenReturn(pageManager);
        when(pageManager.getPage("/content/mysite")).thenReturn(rootPage);
        when(rootPage.getProperties()).thenReturn(new ValueMapDecorator(Collections.emptyMap()));

        // Act
        pageModel.init();

        // Assert
        assertEquals(null, pageModel.getFavicon());
    }
}
