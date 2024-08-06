package com.freightcom.clickship.data.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.data.entity.common.CustomerIdAssociateEntity;
import com.freightcom.clickship.data.entity.common.NotificationAlertEnum;
import com.freightcom.clickship.data.entity.common.NotificationIconEnum;

@Entity
@Table(name = "notifications")
public class Notification extends BaseEntity implements CustomerIdAssociateEntity {

	private static final long serialVersionUID = -3222313631899836144L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false)
	@JsonIgnore
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "marketplace_id", updatable = false)
	@JsonIgnore
	private Marketplace marketplace;

	@Column(name = "description")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "notification_type")
	private NotificationIconEnum notificationType;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "sub_notification_type")
	private NotificationAlertEnum subnotificationType;
	
	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Notification setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}
	
	public Marketplace getMarketplace() {
		return marketplace;
	}

	public Notification setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Notification setDescription(String description) {
		this.description = description;
		return this;
	}

	public NotificationIconEnum getNotificationType() {
		return notificationType;
	}

	public Notification setNotificationType(NotificationIconEnum notificationType) {
		this.notificationType = notificationType;
		return this;
	}

	public NotificationAlertEnum getSubnotificationType() {
		return subnotificationType;
	}

	public Notification setSubnotificationType(NotificationAlertEnum subnotificationType) {
		this.subnotificationType = subnotificationType;
		return this;
	}

	@Override
	public Notification setCreatedDatetime(Date createdDatetime) {
		super.setCreatedDatetime(createdDatetime);
		return this;
	}

	@Override
	public Notification setUpdateDatetime(Date updatedAt) {
		super.setUpdateDatetime(updatedAt);
		return this;
	}
	
}
