package com.neom.enowa.aem.core.models.tableinfo;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TableInfoModelTabLists {
    private static final Logger LOGGER = LoggerFactory.getLogger(TableInfoModelTabLists.class);

    @ChildResource
    private String description;
    @ChildResource
    private String image;
    @ChildResource
    private String imageAlternativeText;
    @ChildResource
    private String rows;
    @ChildResource
    private String columns;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageAlternativeText() {
        return imageAlternativeText;
    }

    public String getRows() { return rows;}

    public String getColumns() { return columns; }

    public void setImageAlternativeText(String imageAlternativeText) {
        this.imageAlternativeText = imageAlternativeText;
    }
    public TableInfoModelTabLists() {
        // do something
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }
}
