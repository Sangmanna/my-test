package com.freightcom.clickship.model.marketplace.vendasta;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VendastaActivity {

    @JsonProperty("account_id")
    private String accountId;
    @JsonProperty("activity_type")
    private String activityType;
    private String title;
    private String link;
    private String content;
    @JsonProperty("media_url")
    private String mediaURL;
    @JsonProperty("settings_tags")
    private String settingTags;
    @JsonProperty("requires_platform_auth")
    private boolean requiresPlatformAuth;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMediaURL() {
        return mediaURL;
    }

    public void setMediaURL(String mediaURL) {
        this.mediaURL = mediaURL;
    }

    public String getSettingTags() {
        return settingTags;
    }

    public void setSettingTags(String settingTags) {
        this.settingTags = settingTags;
    }

    public boolean isRequiresPlatformAuth() {
        return requiresPlatformAuth;
    }

    public void setRequiresPlatformAuth(boolean requiresPlatformAuth) {
        this.requiresPlatformAuth = requiresPlatformAuth;
    }
}
