package com.neom.enowa.aem.core.models;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

/**
 * The type Header items.
 */
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeaderItems {
    @ChildResource
    private String bgAssetType;
    @ChildResource
    private String sourceVideo;
    @ChildResource
    private String altVideo;
    @ChildResource
    private String sourceImg;
    @ChildResource
    private String altImg;
    @ChildResource
    private String sourceGif;
    @ChildResource
    private String altGif;
    @ChildResource
    private String title;
    @ChildResource
    private String titleSmall;
    @ChildResource
    private String btnLabel;
    @ChildResource
    private String ctaAssetType;
    @ChildResource
    private String ctaSourceVideo;
    @ChildResource
    private String ctaSourceLink;
    @ChildResource
    private Boolean openNewTab;

    /**
     * Gets bg asset type.
     *
     * @return the bg asset type
     */
    public String getBgAssetType() {
        return bgAssetType;
    }

    /**
     * Gets source video.
     *
     * @return the source video
     */
    public String getSourceVideo() {
        return sourceVideo;
    }

    /**
     * Gets alt video.
     *
     * @return the alt video
     */
    public String getAltVideo() {
        return altVideo;
    }

    /**
     * Gets source img.
     *
     * @return the source img
     */
    public String getSourceImg() {
        return sourceImg;
    }

    /**
     * Gets alt img.
     *
     * @return the alt img
     */
    public String getAltImg() {
        return altImg;
    }

    /**
     * Gets source gif.
     *
     * @return the source gif
     */
    public String getSourceGif() {
        return sourceGif;
    }

    /**
     * Gets alt gif.
     *
     * @return the alt gif
     */
    public String getAltGif() {
        return altGif;
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
     * Gets title small.
     *
     * @return the title small
     */
    public String getTitleSmall() {
        return titleSmall;
    }

    /**
     * Gets btn label.
     *
     * @return the btn label
     */
    public String getBtnLabel() {
        return btnLabel;
    }

    /**
     * Gets cta asset type.
     *
     * @return the cta asset type
     */
    public String getCtaAssetType() {
        return ctaAssetType;
    }

    /**
     * Gets cta source video.
     *
     * @return the cta source video
     */
    public String getCtaSourceVideo() {
        return ctaSourceVideo;
    }

    /**
     * Gets cta source link.
     *
     * @return the cta source link
     */
    public String getCtaSourceLink() {
        return ctaSourceLink;
    }

    /**
     * Gets open new tab.
     *
     * @return the open new tab
     */
    public Boolean getOpenNewTab() {
        return openNewTab;
    }


    public void setBgAssetType(String bgAssetType) {
        this.bgAssetType = bgAssetType;
    }

    public void setSourceVideo(String sourceVideo) {
        this.sourceVideo = sourceVideo;
    }

    public void setAltVideo(String altVideo) {
        this.altVideo = altVideo;
    }

    public void setSourceImg(String sourceImg) {
        this.sourceImg = sourceImg;
    }

    public void setAltImg(String altImg) {
        this.altImg = altImg;
    }

    public void setSourceGif(String sourceGif) {
        this.sourceGif = sourceGif;
    }

    public void setAltGif(String altGif) {
        this.altGif = altGif;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitleSmall(String titleSmall) {
        this.titleSmall = titleSmall;
    }

    public void setBtnLabel(String btnLabel) {
        this.btnLabel = btnLabel;
    }

    public void setCtaAssetType(String ctaAssetType) {
        this.ctaAssetType = ctaAssetType;
    }

    public void setCtaSourceVideo(String ctaSourceVideo) {
        this.ctaSourceVideo = ctaSourceVideo;
    }

    public void setCtaSourceLink(String ctaSourceLink) {
        this.ctaSourceLink = ctaSourceLink;
    }

    public void setOpenNewTab(Boolean openNewTab) {
        this.openNewTab = openNewTab;
    }
}
