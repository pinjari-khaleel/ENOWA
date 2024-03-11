package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.constants.Constants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PageHeaderModel {
    @ChildResource
    private String title;
    @ChildResource
    private String description;
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
    private String ctaBtn;
    @ChildResource
    private String ctaAssetType;

    @ChildResource
    private String ctaSourceVideo;

    @ChildResource
    private String ctaSourceLink;

    @ChildResource
    private String openNewTab;

    private String testValue;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getBgAssetType() {
        return bgAssetType;
    }

    public String getSourceVideo() {
        return sourceVideo;
    }

    public String getAltVideo() {
        return altVideo;
    }

    public String getSourceImg() {
        return sourceImg;
    }

    public String getAltImg() {
        return altImg;
    }

    public String getCtaAssetType() {
        return ctaAssetType;
    }

    public String getCtaSourceVideo() {
        if(ctaSourceVideo.startsWith("https://www.youtube.com")){
            ctaSourceVideo = convertToEmbedLinkForYoutube(ctaSourceVideo);
        }
        return ctaSourceVideo;
    }

    public String getTestValue() {
        if(ctaSourceVideo.startsWith("https://www.youtube.com")){
            testValue = convertToEmbedLinkForYoutube(ctaSourceVideo);
        }
        else{
            testValue="";
        }
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }

    public String getCtaSourceLink() {
        if (ctaSourceLink.startsWith(Constants.SLASH) && !ctaSourceLink.endsWith(Constants.DOT_HTML)) {
            ctaSourceLink =ctaSourceLink.concat(Constants.DOT_HTML);
        }
        return ctaSourceLink;
    }

    public String getOpenNewTab() {
        return openNewTab;
    }

    public String getCtaBtn() {
        return ctaBtn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setCtaBtn(String ctaBtn) {
        this.ctaBtn = ctaBtn;
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

    public void setOpenNewTab(String openNewTab) {
        this.openNewTab = openNewTab;
    }

    public static String convertToEmbedLinkForYoutube(String youtubeLink) {
        String videoId = extractVideoIdForYoutube(youtubeLink);
        return Constants.YOUTUBE_EMBED_LINK + videoId;
    }

    public static String extractVideoIdForYoutube(String youtubeLink) {
        String videoId = null;

        if (youtubeLink != null && !youtubeLink.isEmpty()) {
            Pattern pattern = Pattern.compile("((?<=(v|V)/)|(?<=be/)|(?<=(\\?|\\&)v=)|(?<=embed\\/)|(?<=\\/v\\/)|(?<=youtu.be/)|(?<=\\/e\\/)|(?<=watch\\?v=)|(?<=\\?v=)|(?<=\\/videos\\/)|(?<=\\/embed\\/)|(?<=\\/v\\/)|(?<=\\/e\\/)|(?<=watch\\?v%3D)|(?<=watch\\?feature=player_embedded&v=)|(?<=embed%2F)|(?<=youtu.be%2F)|(?<=\\/v%2F)|(?<=\\/videos%2F))([^#\\&\\?\\n]*)"); // NOSONAR

            Matcher matcher = pattern.matcher(youtubeLink);
            if (matcher.find()) {
                videoId = matcher.group();
            }
        }

        return videoId;
    }
}
