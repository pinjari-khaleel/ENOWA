package com.neom.enowa.aem.core.models;
import com.neom.enowa.aem.core.constants.Constants;
import com.neom.enowa.aem.core.models.latestupdates.ColumnItems;
import com.neom.enowa.aem.core.models.latestupdates.NewsItems;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The type All Latest updates model.
 */
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AllLatestUpdatesModel {

    @ChildResource
    private String title;
    @ChildResource
    private String titleUrl;

    @ChildResource
    private String latestNews;
    @ChildResource
    List<NewsItems> newsItems;

    List<List<NewsItems>> doubleItemsList;

    @ChildResource
    List<ColumnItems> columnItemsList = new ArrayList<>();

    @PostConstruct
    protected void init() {
        List<List<NewsItems>> listOfLists = new ArrayList<>();
        Collections.sort(newsItems, dateComparator);
        int index = 0;

        while (index < newsItems.size()) {
            List<NewsItems> sublist = new ArrayList<>();
            sublist.add(newsItems.get(index));
            if (index + 1 < newsItems.size()) {
                sublist.add(newsItems.get(index + 1));
            }
            listOfLists.add(sublist);
            index += 2;
        }

        doubleItemsList = listOfLists;
        for (List<NewsItems> items : doubleItemsList) {
            ColumnItems columnItems = new ColumnItems();
            if (!items.isEmpty()) {
                columnItems.setLeftColumnItem(items.get(0));
            }
            if (items.size() > 1) {
                columnItems.setRightColumnItem(items.get(1));
            }
            columnItemsList.add(columnItems);
        }
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets title url.
     *
     * @return the title url
     */
    public String getTitleUrl() {
        return titleUrl+ Constants.DOT_HTML;
    }

    /**
     * Gets news items.
     *
     * @return the news items
     */
    public List<NewsItems> getNewsItems() {
         newsItems.sort(Comparator.comparing(NewsItems::getDate).reversed());
        return newsItems;
    }

    public int getLastIndexCount() {
        return newsItems.size() - 1;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitleUrl(String titleUrl) {
        this.titleUrl = titleUrl;
    }

    public void setNewsItems(List<NewsItems> newsItems) {
        this.newsItems = newsItems;
    }

    public String getLatestNews() {
        return latestNews;
    }

    public void setLatestNews(String latestNews) {
        this.latestNews = latestNews;
    }

    public List<List<NewsItems>> getDoubleItemsList() {
        return doubleItemsList;
    }

    public void setDoubleItemsList(List<List<NewsItems>> doubleItemsList) {
        this.doubleItemsList = doubleItemsList;
    }

    public List<ColumnItems> getColumnItemsList() {
        return columnItemsList;
    }

    public void setColumnItemsList(List<ColumnItems> columnItemsList) {
        this.columnItemsList = columnItemsList;
    }

    Comparator<NewsItems> dateComparator = new Comparator<NewsItems>() {
        @Override
        public int compare(NewsItems item1, NewsItems item2) {
            // Compare the dates in reverse order (latest date first)
            return item2.getDate().compareTo(item1.getDate());
        }
    };
}
