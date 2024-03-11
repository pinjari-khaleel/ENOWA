package com.neom.enowa.aem.core.models.infographics;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class InfographicsModelTabList {

    @ChildResource
    private String image;
    @ChildResource
    private String imageAlternativeText;
    @ChildResource
    private String title;
    @ChildResource
    private String scriptType;
    @ChildResource
    private String superScript;
    @ChildResource
    private String subScript;

    @ChildResource
    private String script;

    public String getSuperScript() {
        return superScript;
    }

    public String getSubScript() {
        return subScript;
    }

    public String getScript() {
        return script;
    }

    @ChildResource
    private String description;

    public String getImage() {
        return image;
    }

    public String getImageAlternativeText() {
        return imageAlternativeText;
    }

    public String getTitle() {
        if (title == null) {
            return "";
        }
        return title;
    }

    public String getScriptType() {
        return scriptType;
    }

    public String getDescription() {
        return description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setImageAlternativeText(String imageAlternativeText) {
        this.imageAlternativeText = imageAlternativeText;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setScriptType(String scriptType) {
        this.scriptType = scriptType;
    }

    public void setSuperScript(String superScript) {
        this.superScript = superScript;
    }

    public void setSubScript(String subScript) {
        this.subScript = subScript;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
