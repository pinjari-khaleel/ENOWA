package com.neom.enowa.aem.core.models;

public class FooterItem {

    private String url;

    private String heading;

    public FooterItem() {
    }

    public FooterItem(String url, String heading) {
        this.url = url;
        this.heading = heading;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
}
