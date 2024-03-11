package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.latestupdates.LatestNewsItems;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.jcr.*;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import java.util.*;

/**
 * The type Latest updates model.
 */
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LatestNewsUpdatesModel {

    private static final Logger logger = LoggerFactory.getLogger(LatestNewsUpdatesModel.class);    
    private static final String JCR_CONTENT = "/jcr:content";
    
    @SlingObject
    ResourceResolver resourceResolver;
    @ChildResource
    private String title;
    @ChildResource
    private String titleUrl;
    private List<LatestNewsItems> latestNewsItems = new ArrayList<>();
    @ChildResource
    private String targetPageType;
    @ChildResource
    private int lastIndexCount;

    @PostConstruct
    protected void init() {
        try {
            String[] newsTypes = { "isAboutNews", "isWaterNews", "isEnergyNews", "isHydrogenNews", "isInvestNews", "isLandingPageNews" };
            Session session = resourceResolver.adaptTo(Session.class);
            String allUpdatedNewsPagePath = getLatestNewsMainPage(session);
            logger.debug("All updated news page path: {}", allUpdatedNewsPagePath);
            if (allUpdatedNewsPagePath == null || StringUtils.isBlank(allUpdatedNewsPagePath)) {
                logger.debug("Main page not found at path: {}", allUpdatedNewsPagePath);
                return;
            }

            ValueMap valueMap = resourceResolver.getResource(allUpdatedNewsPagePath).getValueMap();
            title = valueMap.get("title", String.class);
            titleUrl = allUpdatedNewsPagePath.substring(0, allUpdatedNewsPagePath.lastIndexOf(JCR_CONTENT));

            Resource newsItemsResource = resourceResolver.getResource(allUpdatedNewsPagePath + "/newsItems");
            if (newsItemsResource != null) {
                Iterable<Resource> newsItemResources = newsItemsResource.getChildren();
                for (Resource childResource : newsItemResources) {
                    for (String newsType : newsTypes) {
                        boolean isValidPage = isCurrentPageContainsAllNewsPage(childResource, newsType);
                        if (isValidPage) {
                            LatestNewsItems latestNewsItem = new LatestNewsItems();
                            assignPropertiesToLatestNewsItem(childResource, latestNewsItem);
                            latestNewsItems.add(latestNewsItem);
                        }
                    }
                }
            } else {
                logger.debug("Resource is null or empty");
            }

        } catch (RepositoryException e) {
            logger.error("Error in init() method", e);
        }
    }

    boolean isCurrentPageContainsAllNewsPage(Resource itemResource, String property) {
        boolean isContainsLatestNews = false;
        ValueMap valueMap = itemResource.getValueMap();
        String pageType = String.valueOf(valueMap.get(property));

        if (pageType != null && pageType.equals(targetPageType)) {
            isContainsLatestNews = true;
        }

        return isContainsLatestNews;
    }
    void assignPropertiesToLatestNewsItem(Resource itemResource, LatestNewsItems latestNewsItem) {
        ValueMap valueMap = itemResource.getValueMap();
        latestNewsItem.setInnerTitle(valueMap.get("innerTitle", String.class));
        latestNewsItem.setDescription(valueMap.get("description", String.class));
//        latestNewsItem.setDate(valueMap.get("date", Calendar.class));
        latestNewsItem.setLink(valueMap.get("link", String.class));
        latestNewsItem.setAssetType(valueMap.get("assetType", String.class));
        latestNewsItem.setSourceVideo(valueMap.get("sourceVideo", String.class));
        latestNewsItem.setAltVideo(valueMap.get("altVideo", String.class));
        latestNewsItem.setSourceImg(valueMap.get("sourceImg", String.class));
        latestNewsItem.setAltImg(valueMap.get("altImg", String.class));

    }

    public String getLatestNewsMainPage(Session session) throws RepositoryException {
        String sqlQuery = "SELECT * FROM [nt:base] AS s WHERE ISDESCENDANTNODE(s, '/content/enowa') AND s.[sling:resourceType] = 'enowa/components/newsroom'";
        logger.debug("sqlQuery: {}", sqlQuery);
        Workspace workspace = session.getWorkspace();
        QueryManager queryManager = workspace.getQueryManager();
        javax.jcr.query.Query query = queryManager.createQuery(sqlQuery, Query.JCR_SQL2);
        QueryResult queryResult = query.execute();
        NodeIterator nodeIterator = queryResult.getNodes();
        if (nodeIterator.hasNext()) {
            Node node = nodeIterator.nextNode();
            logger.debug("News Rooms Contains only Single Page and It will return first newsroom URL. So we did not do the loop");
            return node.getPath();
        }

        return StringUtils.EMPTY;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleUrl() {
        return titleUrl;
    }

    public void setTitleUrl(String titleUrl) {
        this.titleUrl = titleUrl;
    }

    public List<LatestNewsItems> getLatestNewsItems() {
        return new ArrayList<>(latestNewsItems);
    }

    public void setLatestNewsItems(List<LatestNewsItems> latestNewsItems) {
        this.latestNewsItems = new ArrayList<>(latestNewsItems);
    }

    public String getTargetPageType() {
        return targetPageType;
    }

    public void setTargetPageType(String targetPageType) {
        this.targetPageType = targetPageType;
    }
    public int getLastIndexCount() {
        lastIndexCount = latestNewsItems.size() - 1;
        return lastIndexCount;
    }

    public void setResourceResolver(ResourceResolver resourceResolver) {
        this.resourceResolver = resourceResolver;
    }

    public void setLastIndexCount(int lastIndexCount) {
        this.lastIndexCount = lastIndexCount;
    }
}
