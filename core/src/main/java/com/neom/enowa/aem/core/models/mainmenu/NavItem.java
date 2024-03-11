package com.neom.enowa.aem.core.models.mainmenu;

import java.util.List;

public class NavItem {
    private String title;
    private String path;

    private String innerTitle;
    private String assetImage;
    private String imageAlt;
    private String pathPage;

    List<NavChildItem> childItem;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public NavItem(String title, String path, List<NavChildItem> childItem) {
        this.title = title;
        this.path = path;
        this.childItem = childItem;
    }

    public NavItem() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAssetImage() {
        return assetImage;
    }

    public void setAssetImage(String assetImage) {
        this.assetImage = assetImage;
    }

    public String getImageAlt() {
        return imageAlt;
    }

    public void setImageAlt(String imageAlt) {
        this.imageAlt = imageAlt;
    }

    public String getInnerTitle() {
        return innerTitle;
    }

    public void setInnerTitle(String innerTitle) {
        this.innerTitle = innerTitle;
    }


    public List<NavChildItem> getChildItem() {
        return childItem;
    }

    public void setChildItem(List<NavChildItem> childItem) {
        this.childItem = childItem;
    }

    public String getPathPage() {
        return pathPage;
    }

    public void setPathPage(String pathPage) {
        this.pathPage = pathPage;
    }

    @Override
    public String toString() {
        return "NavItem{" +
                "title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", assetImage='" + assetImage + '\'' +
                ", imageAlt='" + imageAlt + '\'' +
                ", childItem=" + childItem +
                '}';
    }
}
