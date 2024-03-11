package com.neom.enowa.aem.core.models;
import com.neom.enowa.aem.core.models.header.HeaderItem;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Header model.
 */
@Model(
        adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class HeaderModel {

    @ChildResource
    private List<HeaderItem> headerItems;

    private List<HeaderItem> headerItemsModified = new ArrayList<>();

    @PostConstruct
    void init(){
        if (headerItems == null || headerItems.isEmpty()) {
            return; // Return early if the list is null or empty
        }

        for (int i = 0; i < headerItems.size(); i++) {
            HeaderItem current = headerItems.get(i);
            current.setCurrentPosition(Integer.toString(i+1));

            HeaderItem next = (i + 1 < headerItems.size()) ? headerItems.get(i + 1) : headerItems.get(0);
            current.setNextItem(next);
            headerItemsModified.add(current);
        }
    }

    public List<HeaderItem> getHeaderItems() {
        return new ArrayList<>(headerItems);
    }

    public List<HeaderItem> getHeaderItemsModified() {
        return new ArrayList<>(headerItemsModified);
    }

    public void setHeaderItems(List<HeaderItem> headerItems) {
        this.headerItems = new ArrayList<>(headerItems);
    }

    public void setHeaderItemsModified(List<HeaderItem> headerItemsModified) {
        this.headerItemsModified = new ArrayList<>(headerItemsModified);
    }
}
