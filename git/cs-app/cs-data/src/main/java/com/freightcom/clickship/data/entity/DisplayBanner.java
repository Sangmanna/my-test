package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "display_banner")
public class DisplayBanner extends BaseEntity {

	private static final long serialVersionUID = -7428975393893201322L;

	@Id
    @GeneratedValue(generator = "customIdGenerator")
    @GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private String id;

    @Column(name = "app_page_name")
    private String appPageName;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "banner_header")
    private String bannerHeader;

    @Column(name = "banner_text")
    private String bannerText;

    @Column(name = "icon_class")
    private String iconClass;

    @Column(name = "banner_class")
    private String bannerClass;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public BaseEntity setId(String id) {
        return this;
    }

    public String getAppPageName() {
        return appPageName;
    }

    public DisplayBanner setAppPageName(String appPageName) {
        this.appPageName = appPageName;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public DisplayBanner setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public String getBannerHeader() {
        return bannerHeader;
    }

    public DisplayBanner setBannerHeader(String bannerHeader) {
        this.bannerHeader = bannerHeader;
        return this;
    }

    public String getBannerText() {
        return bannerText;
    }

    public DisplayBanner setBannerText(String bannerText) {
        this.bannerText = bannerText;
        return this;
    }

    public String getIconClass() {
        return iconClass;
    }

    public DisplayBanner setIconClass(String iconClass) {
        this.iconClass = iconClass;
        return this;
    }

    public String getBannerClass() {
        return bannerClass;
    }

    public DisplayBanner setBannerClass(String bannerClass) {
        this.bannerClass = bannerClass;
        return this;
    }
}
