package com.neom.enowa.aem.core.models.latestupdates;
import com.neom.enowa.aem.core.constants.Constants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type News items.
 */
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LatestNewsItems {

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

    private boolean isVideoURL;

    public String getInnerTitle() {
        return innerTitle;
    }

    public String getDescription() {
        return description;
    }

    public Calendar getDate() {
        return date;
    }

    public String getLink() {
        return link+Constants.DOT_HTML;
    }

    public String getAssetType() {
        return assetType;
    }
    public String getSourceVideo() {
        if(sourceVideo.startsWith(Constants.HTTP)) {
            sourceVideo = convertToEmbedLinkForYoutube(sourceVideo);
        }
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
    public static String convertToEmbedLinkForYoutube(String youtubeLink) {
        String videoId = extractVideoIdForYoutube(youtubeLink);
        return Constants.YOUTUBE_EMBED_LINK + videoId;
    }

    public static String extractVideoIdForYoutube(String youtubeLink) {
        String videoId = null;

        if (youtubeLink != null && !youtubeLink.isEmpty()) {
            Pattern pattern = Pattern.compile("((?<=(v|V)/)|(?<=be/)|(?<=(\\?|\\&)v=)|(?<=embed\\/)|(?<=\\/v\\/)|(?<=youtu.be/)|(?<=\\/e\\/)|(?<=watch\\?v=)|(?<=\\?v=)|(?<=\\/videos\\/)|(?<=\\/embed\\/)|(?<=\\/v\\/)|(?<=\\/e\\/)|(?<=watch\\?v%3D)|(?<=watch\\?feature=player_embedded&v=)|(?<=embed%2F)|(?<=youtu.be%2F)|(?<=\\/v%2F)|(?<=\\/videos%2F))([^#\\&\\?\\n]*)");

            Matcher matcher = pattern.matcher(youtubeLink);
            if (matcher.find()) {
                videoId = matcher.group();
            }
        }

        return videoId;
    }

    public boolean isVideoURL() {
        return sourceVideo.startsWith(Constants.HTTP);
    }
}
