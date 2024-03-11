package com.neom.enowa.aem.core.models;

import com.neom.enowa.aem.core.models.stepper.StepperItems;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.ArrayList;
import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class StepperModel {

    @ChildResource
    private String blockTitle;

    @ChildResource
    private String blockDescription;

    @ChildResource
    private String assetType;

    @ChildResource
    private String videoSource;

    @ChildResource
    private String videoAlt;

    @ChildResource
    private String imageSource;


    private String source;

    public String getSource() {
        return source;
    }

    @ChildResource
    private String imageAlt;
    @ChildResource
    private String assetImage;

    @ChildResource
    private String videoBackground;

    @ChildResource
    private String videoBackgroundAlt;

    @ChildResource
    private List<StepperItems> stepperItems;


    public String getBlockTitle() {
        return blockTitle;
    }

    public void setBlockTitle(String blockTitle) {
        this.blockTitle = blockTitle;
    }

    public String getBlockDescription() {
        return blockDescription;
    }

    public void setBlockDescription(String blockDescription) {
        this.blockDescription = blockDescription;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getVideoSource() {
        return videoSource;
    }

    public void setVideoSource(String videoSource) {
        this.videoSource = videoSource;
    }

    public String getVideoAlt() {
        return videoAlt;
    }

    public void setVideoAlt(String videoAlt) {
        this.videoAlt = videoAlt;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public String getImageAlt() {
        return imageAlt;
    }

    public void setImageAlt(String imageAlt) {
        this.imageAlt = imageAlt;
    }

    public void setStepperItems(List<StepperItems> stepperItems) {
        this.stepperItems = new ArrayList<>(stepperItems);
    }

    public List<StepperItems> getStepperItems() {
        return new ArrayList<>(stepperItems);
    }

    public String getAssetImage() {
        return assetImage;
    }

    public void setAssetImage(String assetImage) {
        this.assetImage = assetImage;
    }

    public String getVideoBackground() {
        return videoBackground;
    }

    public String getVideoBackgroundAlt() {
        return videoBackgroundAlt;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setVideoBackground(String videoBackground) {
        this.videoBackground = videoBackground;
    }

    public void setVideoBackgroundAlt(String videoBackgroundAlt) {
        this.videoBackgroundAlt = videoBackgroundAlt;
    }
}
