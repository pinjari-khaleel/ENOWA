package com.neom.enowa.aem.core.models;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import java.util.Calendar;

/**
 * The type News items.
 */
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NewsItems {

    @ChildResource
    private String innerTitle;

    @ChildResource
    private String description;

    @ChildResource
    private Calendar date;

    @ChildResource
    private String link;

    @ChildResource
    private String assetType;

    @ChildResource
    private String sourceVideo;

    @ChildResource
    private String altVideo;

    @ChildResource
    private String sourceImg;

    @ChildResource
    private String altImg;

    /**
     * Gets inner title.
     *
     * @return the inner title
     */
    public String getInnerTitle() {
        return innerTitle;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }


    /**
     * Gets date.
     *
     * @return the date
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * Gets link.
     *
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * Gets asset type.
     *
     * @return the asset type
     */
    public String getAssetType() {
        return assetType;
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

    public void setInnerTitle(String innerTitle) {
        this.innerTitle = innerTitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
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
}
