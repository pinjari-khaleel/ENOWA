package com.neom.enowa.aem.core.models;
import com.neom.enowa.aem.core.models.tableInfotwo.TableInfoList;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Model(
        adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class TableInfo2 {
    @ChildResource
    private String headerTitle;

    @ChildResource
    private String titleDescription;

    @ChildResource
    private List<TableInfoList> tableInfoList;

    private List<TableInfoList> tableInfoOne = new ArrayList<>();
    private List<TableInfoList> tableInfoFullList = new ArrayList<>();
    private List<TableInfoList> tableInfoTwo = new ArrayList<>();

    @PostConstruct
    protected void init() {
        if (tableInfoList != null) {
            for (int i = 0; i < tableInfoList.size(); i++) {
                if (i==0 || i%2==0) {
                    tableInfoOne.add(tableInfoList.get(i));
                } else {
                    tableInfoTwo.add(tableInfoList.get(i));
                }
                TableInfoList tableInfoList1 = tableInfoList.get(i);
                tableInfoList1.setCurrentPosition(i);
                tableInfoFullList.add(tableInfoList1);
            }
        }
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public String getTitleDescription() {
        return titleDescription;
    }

    public void setTitleDescription(String titleDescription) {
        this.titleDescription = titleDescription;
    }

    public List<TableInfoList> getTableInfoList() {
        return new ArrayList<>(tableInfoList);
    }

    public void setTableInfoList(List<TableInfoList> tableInfoList) {
        this.tableInfoList = new ArrayList<>(tableInfoList);
    }

    public List<TableInfoList> getTableInfoOne() {
        return new ArrayList<>(tableInfoOne);
    }

    public void setTableInfoOne(List<TableInfoList> tableInfoOne) {
        this.tableInfoOne = new ArrayList<>(tableInfoOne);
    }

    public List<TableInfoList> getTableInfoTwo() {
        return new ArrayList<>(tableInfoTwo);
    }

    public void setTableInfoTwo(List<TableInfoList> tableInfoTwo) {
        this.tableInfoTwo = new ArrayList<>(tableInfoTwo);
    }

    public List<TableInfoList> getTableInfoFullList() {
        return new ArrayList<>(tableInfoFullList);
    }

    public void setTableInfoFullList(List<TableInfoList> tableInfoFullList) {
        this.tableInfoFullList = new ArrayList<>(tableInfoFullList);
    }
}
