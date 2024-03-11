package com.neom.enowa.aem.core.models.mainmenu;

public class NavChildItem {

    private String title;
    private String path;

    public NavChildItem() {
    }

    public NavChildItem(String title, String path) {
        this.title = title;
        this.path = path+".html";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path+".html";
    }


    @Override
    public String toString() {
        return "NavChildItem{" +
                "title='" + title + '\'' +
                ", path='" + path + '\'' +
                '}';
    }

}
