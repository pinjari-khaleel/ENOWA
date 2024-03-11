package com.neom.enowa.aem.core.models.header;


import com.neom.enowa.aem.core.constants.Constants;
import com.neom.enowa.aem.core.utils.EnowaUtil;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeaderItem {

    private String currentPosition ;
     @ChildResource
     private String assetType;
     @ChildResource
     private String videoBackgroundURL;

     @ChildResource
     private String videoBackgroundURLAlt;

     @ChildResource
     private String assetImage;

     @ChildResource
     private String imageAlt;

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

     private String testUrl;

     private HeaderItem nextItem;

    public String getAssetType() {
        return assetType;
    }

    public String getVideoBackgroundURL() {
        return videoBackgroundURL;
    }

    public String getVideoBackgroundURLAlt() {
        return videoBackgroundURLAlt;
    }

    public String getAssetImage() {
        return assetImage;
    }

    public String getImageAlt() {
        return imageAlt;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleSmall() {
        return titleSmall;
    }

    public String getBtnLabel() {
        return btnLabel;
    }

    public String getCtaAssetType() {
        return ctaAssetType;
    }


    public String getTestUrl() {
        if (ctaSourceVideo.startsWith(Constants.LINK_YOUTUBE)) {
          testUrl = EnowaUtil.convertToEmbedLinkForYoutube(ctaSourceVideo);
        } else {
          testUrl = Constants.BLANK;
        }
        return testUrl;
    }

    public void setTestUrl(String testUrl) {
      this.testUrl = testUrl;
    }

    public String getCtaSourceVideo() {
        return ctaSourceVideo;
    }

    public String getCtaSourceLink() {
        return ctaSourceLink;
    }

    public HeaderItem getNextItem() {
        return nextItem;
    }

    public void setNextItem(HeaderItem nextItem) {
        this.nextItem = nextItem;
    }

    public String getCurrentPosition() {
        currentPosition = (Integer.parseInt(currentPosition) < 10) ? ('0' + currentPosition) : currentPosition;
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public void setVideoBackgroundURL(String videoBackgroundURL) {
        this.videoBackgroundURL = videoBackgroundURL;
    }

    public void setVideoBackgroundURLAlt(String videoBackgroundURLAlt) {
        this.videoBackgroundURLAlt = videoBackgroundURLAlt;
    }

    public void setAssetImage(String assetImage) {
        this.assetImage = assetImage;
    }

    public void setImageAlt(String imageAlt) {
        this.imageAlt = imageAlt;
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
}


