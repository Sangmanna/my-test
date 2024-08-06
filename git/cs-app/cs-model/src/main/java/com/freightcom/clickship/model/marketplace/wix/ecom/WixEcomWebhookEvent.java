package com.freightcom.clickship.model.marketplace.wix.ecom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WixEcomWebhookEvent {

	@JsonProperty("id")
	private String id;

	@JsonProperty("entityFqdn")
	private String entityFqdn;

	@JsonProperty("slug")
	private String slug;

	@JsonProperty("entityId")
	private String entityId;

	@JsonProperty("updatedEvent")
	private EventData updatedEvent;

	@JsonProperty("actionEvent")
	private ActionEvent actionEvent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEntityFqdn() {
		return entityFqdn;
	}

	public void setEntityFqdn(String entityFqdn) {
		this.entityFqdn = entityFqdn;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public EventData getUpdatedEvent() {
		return updatedEvent;
	}

	public void setUpdatedEvent(EventData updatedEvent) {
		this.updatedEvent = updatedEvent;
	}

	public ActionEvent getActionEvent() {
		return actionEvent;
	}

	public void setActionEvent(ActionEvent actionEvent) {
		this.actionEvent = actionEvent;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class EventData {

		@JsonProperty("currentEntity")
		private WixEcomOrder currentEntity;

		@JsonProperty("order")
		private WixEcomOrder order;

		@JsonProperty("orderTransactions")
		private WixEcomOrderTransactions orderTransactions;

		public WixEcomOrder getCurrentEntity() {
			return currentEntity;
		}

		public void setCurrentEntity(WixEcomOrder currentEntity) {
			this.currentEntity = currentEntity;
		}

		public WixEcomOrder getOrder() {
			return order;
		}

		public void setOrder(WixEcomOrder order) {
			this.order = order;
		}

		public WixEcomOrderTransactions getOrderTransactions() {
			return orderTransactions;
		}

		public void setOrderTransactions(WixEcomOrderTransactions orderTransactions) {
			this.orderTransactions = orderTransactions;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class ActionEvent {

		@JsonProperty("body")
		private EventData body;

		public EventData getBody() {
			return body;
		}

		public void setBody(EventData body) {
			this.body = body;
		}
	}
}
