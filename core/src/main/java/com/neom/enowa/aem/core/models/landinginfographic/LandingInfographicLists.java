package com.neom.enowa.aem.core.models.landinginfographic;


import com.neom.enowa.aem.core.constants.Constants;
import com.neom.enowa.aem.core.utils.EnowaUtil;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LandingInfographicLists {

    @ChildResource
    private String title;
    @ChildResource
    private String description;
    @ChildResource
    private String cta;
    @ChildResource
    private String link;
    @ChildResource
    private String borderColor;
    @ChildResource
    private String assetType;
    @ChildResource
    private String assetImage;
    @ChildResource
    private String imageAlt;
    @ChildResource
    private String video;
    @ChildResource
    private String videoAlt;
    @ChildResource
    private String sourceGif;

    @ChildResource
    private String altGif;

    @ChildResource
    private String variation;

    @SlingObject
    private ResourceResolver resourceResolver;


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCta() {
        return cta;
    }

    public String getLink() {
        if (EnowaUtil.isPageLink(resourceResolver, link)) {
            return link + Constants.DOT_HTML;
        }
        return link;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public String getAssetType() {
        return assetType;
    }

    public String getAssetImage() {
        return assetImage;
    }

    public String getImageAlt() {
        return imageAlt;
    }

    public String getVideo() {
        if(video.startsWith(Constants.HTTP)){
            video =  convertToEmbedLinkForYoutube(video);
        }
        return video;
    }

    public String getVideoAlt() {
        return videoAlt;
    }

    public String getSourceGif() {return sourceGif; }

    public String getAltGif() {return altGif;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCta(String cta) {
        this.cta = cta;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public void setAssetImage(String assetImage) {
        this.assetImage = assetImage;
    }

    public void setImageAlt(String imageAlt) {
        this.imageAlt = imageAlt;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setVideoAlt(String videoAlt) {
        this.videoAlt = videoAlt;
    }

    public void setSourceGif(String sourceGif) {
        this.sourceGif = sourceGif;
    }

    public void setAltGif(String altGif) {
        this.altGif = altGif;
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

    public boolean isVideoURL() {
        return video.startsWith(Constants.HTTP);
    }

    public String getVariation() {
        return variation;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public void setResourceResolver(ResourceResolver resourceResolver) {
        this.resourceResolver = resourceResolver;
    }
}
