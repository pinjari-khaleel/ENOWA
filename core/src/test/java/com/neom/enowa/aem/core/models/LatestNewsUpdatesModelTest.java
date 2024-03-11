package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.latestupdates.LatestNewsItems;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.jcr.*;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.mockito.Mockito.*;

public class LatestNewsUpdatesModelTest {

    private LatestNewsUpdatesModel latestNewsUpdatesModel;

    @BeforeEach
    public void setUp() {
        latestNewsUpdatesModel = new LatestNewsUpdatesModel();
        latestNewsUpdatesModel.resourceResolver = mock(ResourceResolver.class);
        latestNewsUpdatesModel.setTargetPageType("isAboutNews");
    }

    @Test
    public void testInit() throws RepositoryException {
        Session sessionMock = mock(Session.class);
        latestNewsUpdatesModel.resourceResolver = mock(ResourceResolver.class);
        Resource resourceMock = mock(Resource.class);

        when(latestNewsUpdatesModel.resourceResolver.adaptTo(Session.class)).thenReturn(sessionMock);
        when(sessionMock.getWorkspace()).thenReturn(mock(Workspace.class));
        when(sessionMock.getWorkspace().getQueryManager()).thenReturn(mock(QueryManager.class));
        when(sessionMock.getWorkspace().getQueryManager().createQuery(anyString(), anyString())).thenReturn(mock(javax.jcr.query.Query.class));
        when(sessionMock.getWorkspace().getQueryManager().createQuery(anyString(), anyString()).execute()).thenReturn(mock(QueryResult.class));
        when(sessionMock.getWorkspace().getQueryManager().createQuery(anyString(), anyString()).execute().getNodes()).thenReturn(mock(NodeIterator.class));
        when(sessionMock.getWorkspace().getQueryManager().createQuery(anyString(), anyString()).execute().getNodes().hasNext()).thenReturn(false);

        when(latestNewsUpdatesModel.resourceResolver.getResource(anyString())).thenReturn(resourceMock);
        when(resourceMock.getValueMap()).thenReturn(mock(ValueMap.class));
        when(resourceMock.getValueMap().get(anyString(), any(Class.class))).thenReturn("");

        latestNewsUpdatesModel.init();
    }

    @Test
    public void testIsCurrentPageContainsAllNewsPage() {
        Resource itemResourceMock = mock(Resource.class);
        ValueMap valueMapMock = mock(ValueMap.class);

        when(itemResourceMock.getValueMap()).thenReturn(valueMapMock);
        when(valueMapMock.get(anyString())).thenReturn("isAboutNews");

        boolean result = latestNewsUpdatesModel.isCurrentPageContainsAllNewsPage(itemResourceMock, "isAboutNews");

        assert(result);
    }

    @Test
    public void testAssignPropertiesToLatestNewsItem() {
        Resource itemResourceMock = mock(Resource.class);
        ValueMap valueMapMock = mock(ValueMap.class);

        when(itemResourceMock.getValueMap()).thenReturn(valueMapMock);
        when(valueMapMock.get(anyString(), any(Class.class))).thenReturn("");

        LatestNewsItems latestNewsItemMock = mock(LatestNewsItems.class);
        latestNewsUpdatesModel.assignPropertiesToLatestNewsItem(itemResourceMock, latestNewsItemMock);
    }

    @Test
    public void testGetLatestNewsMainPage() throws RepositoryException {
        Session sessionMock = mock(Session.class);
        Workspace workspaceMock = mock(Workspace.class);
        QueryManager queryManagerMock = mock(QueryManager.class);
        javax.jcr.query.Query queryMock = mock(javax.jcr.query.Query.class);
        QueryResult queryResultMock = mock(QueryResult.class);
        NodeIterator nodeIteratorMock = mock(NodeIterator.class);
        Node nodeMock = mock(Node.class);

        when(sessionMock.getWorkspace()).thenReturn(workspaceMock);
        when(workspaceMock.getQueryManager()).thenReturn(queryManagerMock);
        when(queryManagerMock.createQuery(anyString(), anyString())).thenReturn(queryMock);
        when(queryMock.execute()).thenReturn(queryResultMock);
        when(queryResultMock.getNodes()).thenReturn(nodeIteratorMock);
        when(nodeIteratorMock.hasNext()).thenReturn(true);
        when(nodeIteratorMock.nextNode()).thenReturn(nodeMock);
        when(nodeMock.getPath()).thenReturn("/content/enowa");

        String result = latestNewsUpdatesModel.getLatestNewsMainPage(sessionMock);

        assert(result.equals("/content/enowa"));
    }

    @Test
    public void testGettersAndSetters() {
        latestNewsUpdatesModel.setTitle("Test Title");
        assert(latestNewsUpdatesModel.getTitle().equals("Test Title"));

        latestNewsUpdatesModel.setTitleUrl("Test URL");
        assert(latestNewsUpdatesModel.getTitleUrl().equals("Test URL"));

        latestNewsUpdatesModel.setTargetPageType("Test Page Type");
        assert(latestNewsUpdatesModel.getTargetPageType().equals("Test Page Type"));

        List<LatestNewsItems> items = new ArrayList<>();
        items.add(new LatestNewsItems());
        latestNewsUpdatesModel.setLatestNewsItems(items);
        assert(latestNewsUpdatesModel.getLatestNewsItems().size() == 1);

        latestNewsUpdatesModel.setLastIndexCount(10);
        //assert(latestNewsUpdatesModel.getLastIndexCount() == 10);

        latestNewsUpdatesModel.setResourceResolver(mock(ResourceResolver.class));
    }
}
