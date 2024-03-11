package com.neom.enowa.aem.core.models;

public class TestimonialsItem {

    private String id;
    private String content;
    private String name;
    private String profession;
    private String description;
    private String profile;
    private String splash;
    private String logo;
    private String quote;
    private String sourceType;
    private String linktext;

    // Getter and Setter methods for each key


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getSplash() {
        return splash;
    }

    public void setSplash(String splash) {
        this.splash = splash;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getLinktext() {
        return linktext;
    }

    public void setLinktext(String linktext) {
        this.linktext = linktext;
    }

    @Override
    public String toString() {
        return "TestimonialsItem{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                ", description='" + description + '\'' +
                ", profile='" + profile + '\'' +
                ", splash='" + splash + '\'' +
                ", logo='" + logo + '\'' +
                ", quote='" + quote + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", linktext='" + linktext + '\'' +
                '}';
    }
}


