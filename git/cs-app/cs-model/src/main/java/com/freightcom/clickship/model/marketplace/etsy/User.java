package com.freightcom.clickship.model.marketplace.etsy;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User  implements Serializable {

	private static final long serialVersionUID = 2626530617829937692L;

	@JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("login_name")
    private String loginName;

    @JsonProperty("primary_email")
    private String primaryEmail;

    @JsonProperty("creation_tsz")
    private Float creationTsz;

    @JsonProperty("user_pub_key")
    private UserPubKey userPubKey;

    @JsonProperty("referred_by_user_id")
    private Integer referredByUserId;

    @JsonProperty("feedback_info")
    private FeedbackInfo feedbackInfo;

    @JsonProperty("awaiting_feedback_count")
    private Integer awaitingFeedbackCount;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public Float getCreationTsz() {
        return creationTsz;
    }

    public void setCreationTsz(Float creationTsz) {
        this.creationTsz = creationTsz;
    }

    public UserPubKey getUserPubKey() {
        return userPubKey;
    }

    public void setUserPubKey(UserPubKey userPubKey) {
        this.userPubKey = userPubKey;
    }

    public Integer getReferredByUserId() {
        return referredByUserId;
    }

    public void setReferredByUserId(Integer referredByUserId) {
        this.referredByUserId = referredByUserId;
    }

    public FeedbackInfo getFeedbackInfo() {
        return feedbackInfo;
    }

    public void setFeedbackInfo(FeedbackInfo feedbackInfo) {
        this.feedbackInfo = feedbackInfo;
    }

    public Integer getAwaitingFeedbackCount() {
        return awaitingFeedbackCount;
    }

    public void setAwaitingFeedbackCount(Integer awaitingFeedbackCount) {
        this.awaitingFeedbackCount = awaitingFeedbackCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", loginName='" + loginName + '\'' +
                ", primaryEmail='" + primaryEmail + '\'' +
                ", creationTsz=" + creationTsz +
                ", userPubKey=" + userPubKey +
                ", referredByUserId=" + referredByUserId +
                ", feedbackInfo=" + feedbackInfo +
                ", awaitingFeedbackCount=" + awaitingFeedbackCount +
                '}';
    }
}