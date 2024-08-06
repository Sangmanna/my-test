package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "carrier")
public class Carrier extends BaseEntity {

	private static final long serialVersionUID = -7067686467682712259L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@Column(name = "service")
	private String service;

	@Column(name = "service_id")
	private String serviceId;
	
	@Column(name = "v2_service_id")
	private String v2ServiceId;

	@Column(name = "service_group_id")
	private String serviceGroupId;

	@Column(name = "short_name")
	private String shortName;

	@Column(name = "service_identifier")
	private String serviceIdentifier;

	@Column(name = "is_display_to_customer")
	private boolean isDisplayToCustomer;

	@Column(name = "show_pickup_option")
	private boolean showPickupOption;

	@Column(name = "show_insurance_option")
	private boolean showInsuranceOption;

	@Column(name = "show_pickup_instructions")
	private boolean showPickupInstructions;

	@Column(name = "is_paperless_customs_invoice")
	private boolean isPaperlessCustomsInvoice;
	
	@Column(name = "pallet_carrier")
	private boolean palletCarrier;

	@Column(name = "image_name")
	private String imageName;

	@Column(name = "v2_image_name")
	private String v2ImageName;

	@Column(name = "note")
	private String note;

	@Column(name = "white_glove_delivery")
	private Boolean whiteGloveDelivery;

	public Carrier() {
		super();
	}

	public Carrier(String serviceGroupId, String shortName, boolean showPickupOption,
			boolean showInsuranceOption, String serviceIdentifier, boolean isDisplayToCustomer,
			String imageName, boolean palletCarrier) {
		super();
		this.serviceGroupId = serviceGroupId;
		this.shortName = shortName;
		this.showPickupOption = showPickupOption;
		this.showInsuranceOption = showInsuranceOption;
		this.serviceIdentifier = serviceIdentifier;
		this.isDisplayToCustomer = isDisplayToCustomer;
		this.imageName = imageName;
		this.palletCarrier = palletCarrier;
	}
	
	public Carrier(String serviceGroupId, String shortName, boolean showPickupOption,
			boolean showInsuranceOption, String serviceIdentifier, boolean isDisplayToCustomer,
			String imageName, boolean palletCarrier, String v2ImageName) {
		super();
		this.serviceGroupId = serviceGroupId;
		this.shortName = shortName;
		this.showPickupOption = showPickupOption;
		this.showInsuranceOption = showInsuranceOption;
		this.serviceIdentifier = serviceIdentifier;
		this.isDisplayToCustomer = isDisplayToCustomer;
		this.imageName = imageName;
		this.palletCarrier = palletCarrier;
		this.v2ImageName = v2ImageName;
	}
	
	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		this.id = id;
		return this;
	}

	public String getShortName() {
		return shortName;
	}

	public Carrier setShortName(String shortName) {
		this.shortName = shortName;
		return this;
	}

	public String getService() {
		return service;
	}

	public Carrier setService(String service) {
		this.service = service;
		return this;
	}

	public String getServiceId() {
		return serviceId;
	}

	public Carrier setServiceId(String string) {
		this.serviceId = string;
		return this;
	}

	public String getServiceGroupId() {
		return serviceGroupId;
	}

	public Carrier setServiceGroupId(String serviceGroupId) {
		this.serviceGroupId = serviceGroupId;
		return this;
	}

	public String getServiceIdentifier() {
		return serviceIdentifier;
	}

	public Carrier setServiceIdentifier(String serviceIdentifier) {
		this.serviceIdentifier = serviceIdentifier;
		return this;
	}

	public boolean getIsDisplayToCustomer() {
		return isDisplayToCustomer;
	}

	public Carrier setIsDisplayToCustomer(boolean isDisplayToCustomer) {
		this.isDisplayToCustomer = isDisplayToCustomer;
		return this;
	}

	public boolean getShowPickupOption() {
		return showPickupOption;
	}

	public Carrier setShowPickupOption(boolean showPickupOption) {
		this.showPickupOption = showPickupOption;
		return this;
	}

	public boolean getShowInsuranceOption() {
		return showInsuranceOption;
	}

	public Carrier setShowInsuranceOption(boolean showInsuranceOption) {
		this.showInsuranceOption = showInsuranceOption;
		return this;
	}

	public String getImageName() {
		return imageName;
	}

	public Carrier setImageName(String imageName) {
		this.imageName = imageName;
		return this;
	}
	
	public String getV2ImageName() {
		return v2ImageName;
	}

	public Carrier setV2ImageName(String v2ImageName) {
		this.v2ImageName = v2ImageName;
		return this;
	}

	public boolean isPalletCarrier() {
		return palletCarrier;
	}

	public void setPalletCarrier(boolean palletCarrier) {
		this.palletCarrier = palletCarrier;
	}

	public String getNote() {
		return note;
	}

	public Carrier setNote(String note) {
		this.note = note;
		return this;
	}

	public boolean isPaperlessCustomsInvoice() {
		return isPaperlessCustomsInvoice;
	}

	public Carrier setPaperlessCustomsInvoice(boolean isPaperlessCustomsInvoice) {
		this.isPaperlessCustomsInvoice = isPaperlessCustomsInvoice;
		return this;
	}

	public String getV2ServiceId() {
		return v2ServiceId;
	}

	public Carrier setV2ServiceId(String v2ServiceId) {
		this.v2ServiceId = v2ServiceId;
		return this;
	}

	public Boolean getWhiteGloveDelivery() {
		return whiteGloveDelivery;
	}

	public void setWhiteGloveDelivery(Boolean whiteGloveDelivery) {
		this.whiteGloveDelivery = whiteGloveDelivery;
	}

	public boolean isShowPickupInstructions() {
		return showPickupInstructions;
	}

	public void setShowPickupInstructions(boolean showPickupInstructions) {
		this.showPickupInstructions = showPickupInstructions;
	}
}