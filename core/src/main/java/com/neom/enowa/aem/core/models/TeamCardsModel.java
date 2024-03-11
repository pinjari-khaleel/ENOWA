package com.neom.enowa.aem.core.models;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
/**
 * The type TeamCards model.
 */
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TeamCardsModel {
    @ChildResource
    private String theme;
    @ChildResource
    private String image;
    @ChildResource
    private String imageAlternativeText;
    @ChildResource
    private String name;
    @ChildResource
    private String title;
    @ChildResource
    private String description;
    @ChildResource
    private String shortDescription;


    /**
     * Gets short description.
     *
     * @return the short description
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Gets theme.
     *
     * @return the theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * Gets image alternative text.
     *
     * @return the image alternative text
     */
    public String getImageAlternativeText() {
        return imageAlternativeText;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
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
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {

        if (StringUtils.isNotBlank(description)) {
            String[] lines = description.split("\n");
            // Initialize a StringBuilder to build the result
            StringBuilder result = new StringBuilder();
            // Process each line and add <p></p> tags
            for (int i = 0; i < lines.length; i++) {
                if (i == 0) {
                    // For the first line, no opening <p> tag is added
                    result.append(lines[i]);
                } else {
                    // For subsequent lines, add <p></p> tags
                    result.append("<p>").append(lines[i]).append("</p>");
                }
            }

            description = result.toString();
        }

        return description;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setImageAlternativeText(String imageAlternativeText) {
        this.imageAlternativeText = imageAlternativeText;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
