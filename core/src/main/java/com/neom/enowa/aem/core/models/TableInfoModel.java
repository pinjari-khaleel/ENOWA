package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.tableinfo.TableInfoModelTabLists;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TableInfoModel {
    private static final Logger LOGGER = LoggerFactory.getLogger(TableInfoModel.class);

    @ChildResource
    private String headerTitle;
    @ChildResource
    private String headerDescription;
    @ChildResource
    private String title;
    @ChildResource
    private String description;

    @ChildResource
    public List<TableInfoModelTabLists> tableInfoModelTabLists;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }
    public String getHeaderDescription() {
        return headerDescription;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public void setHeaderDescription(String headerDescription) {
        this.headerDescription = headerDescription;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TableInfoModelTabLists> getTableInfoModelTabLists() {
        return tableInfoModelTabLists;
    }

    public void setTableInfoModelTabLists(List<TableInfoModelTabLists> tableInfoModelTabLists) {
        this.tableInfoModelTabLists = tableInfoModelTabLists;
    }

}
