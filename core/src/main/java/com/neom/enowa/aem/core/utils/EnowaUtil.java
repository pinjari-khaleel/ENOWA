package com.neom.enowa.aem.core.utils;

import com.neom.enowa.aem.core.constants.Constants;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnowaUtil {

    private EnowaUtil(){
    }

    public static boolean isPageLink(final ResourceResolver resourceResolver, final String linkPath) {
        final Resource linkedResource = resourceResolver.getResource(linkPath);

        if (linkedResource != null) {
            final String resourceType = linkedResource.getResourceType();
            return resourceType.equals("cq:Page");
        }
        return false;
    }

    public static String convertToEmbedLinkForYoutube(String youtubeLink) {
        String videoId = extractVideoIdForYoutube(youtubeLink);
        return Constants.YOUTUBE_EMBED_LINK + videoId;
    }

    private static String extractVideoIdForYoutube(String youtubeLink) {
        String videoId = null;

        if (youtubeLink != null && !youtubeLink.isEmpty()) {
            Pattern pattern = Pattern.compile(
                "((?<=(v|V)/)|(?<=be/)|(?<=(\\?|\\&)v=)|(?<=embed\\/)|(?<=\\/v\\/)|(?<=youtu.be/)|(?<=\\/e\\/)|(?<=watch\\?v=)|(?<=\\?v=)|(?<=\\/videos\\/)|(?<=\\/embed\\/)|(?<=\\/v\\/)|(?<=\\/e\\/)|(?<=watch\\?v%3D)|(?<=watch\\?feature=player_embedded&v=)|(?<=embed%2F)|(?<=youtu.be%2F)|(?<=\\/v%2F)|(?<=\\/videos%2F))([^#\\&\\?\\n]*)"); // NOSONAR

            Matcher matcher = pattern.matcher(youtubeLink);
            if (matcher.find()) {
                videoId = matcher.group();
            }
        }

        return videoId;
    }

}
