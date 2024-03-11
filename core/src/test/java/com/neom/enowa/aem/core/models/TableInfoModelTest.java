package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.TableInfoModel;
import com.neom.enowa.aem.core.models.tableinfo.TableInfoModelTabLists;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class TableInfoModelTest {

    @Mock
    private SlingHttpServletRequest slingRequest;

    @Mock
    private Resource resource;

    private TableInfoModel tableInfoModel;

    @BeforeEach
    void setUp() {
        tableInfoModel = new TableInfoModel();
    }

    @Test
    void testGettersAndSetters() {
        // Set values
        tableInfoModel.setHeaderTitle("Header Title");
        tableInfoModel.setHeaderDescription("Header Description");
        tableInfoModel.setTitle("Title");
        tableInfoModel.setDescription("Description");

        // Verify getters
        assertEquals("Header Title", tableInfoModel.getHeaderTitle());
        assertEquals("Header Description", tableInfoModel.getHeaderDescription());
        assertEquals("Title", tableInfoModel.getTitle());
        assertEquals("Description", tableInfoModel.getDescription());
    }

    @Test
    void testListTab() {

        List<TableInfoModelTabLists> tableInfoModelTabLists = new ArrayList<>();

        TableInfoModelTabLists sampleTableInfo = new TableInfoModelTabLists();

        // Set sample values for the properties
        sampleTableInfo.setDescription("Sample Description");
        sampleTableInfo.setImage("/path/to/sample/image.jpg");
        sampleTableInfo.setImageAlternativeText("Sample Image Alt Text");
        sampleTableInfo.setRows("Sample Rows");
        sampleTableInfo.setColumns("Sample Columns");

        tableInfoModelTabLists.add(sampleTableInfo);

        tableInfoModel.setTableInfoModelTabLists(tableInfoModelTabLists);

        assertNotNull(tableInfoModel.getTableInfoModelTabLists());

    }
}
