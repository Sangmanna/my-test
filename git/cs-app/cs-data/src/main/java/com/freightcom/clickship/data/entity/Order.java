package com.freightcom.clickship.data.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.data.entity.common.ClickShipOrderStatus;
import com.freightcom.clickship.data.entity.common.CustomerAssociateEntity;
import com.freightcom.clickship.model.constants.ClickShipConstants;
import com.freightcom.clickship.model.util.ClickshipStringUtil;
import com.freightcom.clickship.model.util.NumberUtility;
import com.freightcom.clickship.model.util.Security;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity implements CustomerAssociateEntity {
	
	private static final long serialVersionUID = -1891645458377208275L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private Customer customer;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "marketplace_id")
	private Marketplace marketplace;

	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "order_number")
	private String orderNumber;

	@Column(name = "internal_order_number")
	private String internalOrderNumber;

	@Column(name = "original_total")
	private Double originalTotal;
	
	@Column(name = "total")
	private Double total;
	
	@Column(name = "shipto_company")
	private String shiptoCompany;

	@Column(name = "shipto_contact")
	private String shiptoContact;

	@Column(name = "shipto_email")
	private String shiptoEmail;

	@Column(name = "shipto_phone")
	private String shiptoPhone;

	@Column(name = "shipto_phone_ext")
	private String shiptoPhoneExt;

	@Column(name = "shipto_address1")
	private String shiptoAddress1;

	@Column(name = "shipto_address2")
	private String shiptoAddress2;

	@Column(name = "shipto_address3")
	private String shiptoAddress3;

	@Column(name = "shipto_city")
	private String shiptoCity;

	@Column(name = "shipto_province_state")
	private String shiptoProvinceState;

	@Column(name = "shipto_country")
	private String shiptoCountry;

	@Column(name = "shipto_postalcode")
	private String shiptoZip;

	@Column(name = "billto_contact")
	private String billtoContact;

	@Column(name = "billto_address1")
	private String billtoAddress1;

	@Column(name = "billto_address2")
	private String billtoAddress2;

	@Column(name = "billto_address3")
	private String billtoAddress3;

	@Column(name = "billto_city")
	private String billtoCity;

	@Column(name = "billto_province_state")
	private String billtoProvinceState;

	@Column(name = "billto_country")
	private String billtoCountry;

	@Column(name = "billto_postalcode")
	private String billtoPostalcode;

	@Column(name = "billto_phone")
	private String billtoPhone;

	@Column(name = "billto_email")
	private String billtoEmail;

	@Column(name = "status")
	private String status;

	@ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_order_id")
	private Order parentOrder;

	@Column(name = "external_order_id")
	private String externalOrderId;
	
	@Column(name = "shipfrom_contact")
	private String shipfromContact;

	@Column(name = "shipfrom_company")
	private String shipfromCompany;

	@Column(name = "shipfrom_email")
	private String shipfromEmail;

	@Column(name = "shipfrom_phone")
	private String shipfromPhone;

	@Column(name = "notes")
	private String note;

	@Column(name = "external_fulfillment_id")
	private String externalFulfillmentId;

	@Column(name = "total_discounts")
	private Double totalDiscounts;

	@Column(name = "subtotal")
	private Double subtotal;

	@Column(name = "taxes")
	private Double taxes;

	@Column(name = "est_ship_date")
	private Date estShipDate;

	@Column(name = "cancelled_datetime")
	private Date cancelledDatetime;

	@Column(name = "cancel_reason")
	private String cancelReason;

	@Column(name = "service_type")
	private String serviceType;

	@Column(name = "service_type_code")
	private String serviceTypeCode;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "carrier_code")
	@JsonIgnore
	private Carrier carrier;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rtr_carrier_code")
	@JsonIgnore
	private Carrier rtrCarrier;

	@Column(name = "delivery_date")
	private Date deliveryDate;

	@Column(name = "delivered_to")
	private String deliveredTo;

	@Column(name = "ship_date")
	private Date shipDate;

	@Column(name = "shipping_cost")
	private Double shippingCost;

	@Column(name = "shipping_currency")
	private String shippingCurrency;
	
	@Column(name = "original_shipping_cost")
	private Double originalShippingCost;

	@Column(name = "original_shipping_currency")
	private String originalShippingCurrency;

	@Column(name = "cost_currency")
	private String costCurrency;

	@Column(name = "adult_signature_required")
	private boolean adultSignatureRequired;

	@Column(name = "signature_required")
	private boolean signatureRequired;

	@Column(name = "residential_delivery")
	private boolean residentialDelivery;

	@Column(name = "saturday_delivery")
	private boolean saturdayDelivery;

	@Column(name = "saturday_pickup")
	private boolean saturdayPickup;

	@Column(name = "scheduled_pickup")
	private boolean schedulePickUp;
	
	@Column(name = "order_rel_type")
	private String orderRelType;
	
	@Column(name = "has_return_label")
	private boolean hasReturnLabel = false;

	@Transient
	private boolean preSelectedCarrierEnabled;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<Orderline> orderlines;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<Shipment> shipments;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<Tax> taxList;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<Discount> discounts;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Invoice> invoices;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.REMOVE)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<OrderNotes> orderNotes;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<OrderShippingRule> orderShippingRules;
	
	@Column(name = "archived")
	private boolean archived = false;
	
	@Column(name = "tracking_number")
	private String trackingNumber;
	
	@Column(name = "tracking_url")
	private String trackingUrl;

	@Column(name = "is_encrypted")
	private boolean isEncrypted;

	@Column(name = "externally_fulfilled_date")
	private Date externallyFulfilledDate;
	
	@ColumnTransformer(
			  read = "CONVERT(aes_decrypt(unhex(shipto_contact_enc), 'enc$cs!k#y') using utf8)", 
		      write = "hex(aes_encrypt(?, 'enc$cs!k#y'))"
		)  
	@Column(name="shipto_contact_enc") 
	private String shiptoContactEnc;

	@Column(name = "cs_address_id")
	private String csAddressId;

	@Column(name = "external_location_id")
	private String externalLocationId;

	@Column(name = "ext_fulfillment_order_id")
	private String extFulfillmentOrderId;

	@Column(name = "ext_fulfillment_status")
	private String extFulfillmentStatus;

	@Column(name = "ext_fulfillment_order_type")
	private String extFulfillmentOrderType;
	
	@Column(name = "ext_fulfillment_info_collected")
	private boolean extFulfillmentInfoCollected;
	
	@Column(name = "auto_fulfilled")
	private boolean autoFulfilled;
	
	@Column(name = "label_accessed")
	private boolean labelAccessed;
	
	@Column(name = "shipping_rule_in_progress")
	private boolean shippingRuleInProgress = false;

	public Shipment getShipment() {
		if (this.getShipments() != null) {
			Optional<Shipment> optionalShipment = this.getShipments().stream()
					.filter(x -> x.getActive() && !ClickshipStringUtil.equalsIgnoreCase(ClickShipConstants.RETURN_SHIPMENT_TYPE, x.getShipmentType()))
					.findFirst();
			if (optionalShipment.isPresent()) {
				return optionalShipment.get();
			}
		}
		
		return null;
	}
	
	public Shipment getReturnLabelShipment() {
		if (this.getShipments() != null) {
			Optional<Shipment> optionalShipment = this.getShipments().stream()
					.filter(x -> x.getActive() && ClickshipStringUtil.equalsIgnoreCase(ClickShipConstants.RETURN_SHIPMENT_TYPE, x.getShipmentType()))
					.findFirst();
			if (optionalShipment.isPresent()) {
				return optionalShipment.get();
			}
		}
		return null;
	}

	public Order setOrderlines(List<Orderline> orderlines) {
		this.orderlines = orderlines;
		return this;
	}
	
	public Order addOrderline(Orderline orderline) {
		orderline.setOrder(this);
		if (orderlines == null) {
			orderlines = new ArrayList<>();
		}
		orderlines.add(orderline);
		return this;
	}

	public Order addShipment(Shipment shipment) {
		if (this.shipments == null) {
			this.shipments = new ArrayList<>();
		}
		shipment.setOrder(this);
		shipments.add(shipment);
		return this;
	}

	public String getId() {
		return id;
	}

	public Order setId(String id) {
		this.id = id;
		return this;
	}

	@Override
	public Customer getCustomer() {
		return customer;
	}

	public Order setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public Order setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
		return this;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Order setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
		return this;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public Order setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	public String getInternalOrderNumber() {
		return internalOrderNumber;
	}

	public Order setInternalOrderNumber(String internalOrderNumber) {
		this.internalOrderNumber = internalOrderNumber;
		return this;
	}

	public Double getTotal() {
		return total;
	}

	public Order setTotal(Double total) {
		this.total = total;
		return this;
	}

	public String getShiptoCompany() {
		return checkAndReturnDecryptedData(this.shiptoCompany);
	}

	public Order setShiptoCompany(String shiptoCompany) {
		String truncatedShipToCompany = ClickshipStringUtil.truncateString(shiptoCompany, 255);
		this.shiptoCompany = ClickshipStringUtil.getStringStripAccents(truncatedShipToCompany);
		return this;
	}

	public String getShiptoContact() {
		return checkAndReturnDecryptedData(this.shiptoContact);
	}

	public Order setShiptoContact(String shiptoContact) {
		String truncatedShipToContact = ClickshipStringUtil.truncateString(shiptoContact, 255);
		this.shiptoContact = ClickshipStringUtil.getStringStripAccents(truncatedShipToContact);
		return this;
	}

	public String getShiptoEmail() {
		return checkAndReturnDecryptedData(this.shiptoEmail);
	}

	public Order setShiptoEmail(String shiptoEmail) {
		this.shiptoEmail = shiptoEmail;
		return this;
	}

	public String getShiptoPhone() {
		return checkAndReturnDecryptedData(this.shiptoPhone);
	}

	public Order setShiptoPhone(String shiptoPhone) {
		this.shiptoPhone = shiptoPhone;
		return this;
	}

	public String getShiptoAddress1() {
		return checkAndReturnDecryptedData(this.shiptoAddress1);
	}

	public Order setShiptoAddress1(String shiptoAddress1) {
		this.shiptoAddress1 = ClickshipStringUtil.getStringStripAccents(shiptoAddress1);
		return this;
	}

	public String getShiptoAddress2() {
		return shiptoAddress2;
	}

	public Order setShiptoAddress2(String shiptoAddress2) {
		this.shiptoAddress2 = ClickshipStringUtil.getStringStripAccents(shiptoAddress2);
		return this;
	}

	public String getShiptoAddress3() {
		return shiptoAddress3;
	}

	public Order setShiptoAddress3(String shiptoAddress3) {
		this.shiptoAddress3 = shiptoAddress3;
		return this;
	}

	public String getShiptoCity() {
		return shiptoCity;
	}

	public Order setShiptoCity(String shiptoCity) {
		this.shiptoCity = shiptoCity;
		return this;
	}

	public String getShiptoProvinceState() {
		return shiptoProvinceState;
	}

	public Order setShiptoProvinceState(String shiptoProvinceState) {
		this.shiptoProvinceState = shiptoProvinceState;
		return this;
	}

	public String getShiptoCountry() {
		return shiptoCountry;
	}

	public Order setShiptoCountry(String shiptoCountry) {
		this.shiptoCountry = shiptoCountry;
		return this;
	}

	public String getShiptoZip() {
		return checkAndReturnDecryptedData(this.shiptoZip);
	}

	public Order setShiptoZip(String shiptoZip) {
		this.shiptoZip = shiptoZip;
		return this;
	}

	public String getBilltoContact() {
		return billtoContact;
	}

	public Order setBilltoContact(String billtoContact) {
		this.billtoContact = billtoContact;
		return this;
	}

	public String getBilltoAddress1() {
		return billtoAddress1;
	}

	public Order setBilltoAddress1(String billtoAddress1) {
		this.billtoAddress1 = billtoAddress1;
		return this;
	}

	public String getBilltoAddress2() {
		return billtoAddress2;
	}

	public Order setBilltoAddress2(String billtoAddress2) {
		this.billtoAddress2 = billtoAddress2;
		return this;
	}

	public String getBilltoAddress3() {
		return billtoAddress3;
	}

	public Order setBilltoAddress3(String billtoAddress3) {
		this.billtoAddress3 = billtoAddress3;
		return this;
	}

	public String getBilltoCity() {
		return billtoCity;
	}

	public Order setBilltoCity(String billtoCity) {
		this.billtoCity = billtoCity;
		return this;
	}

	public String getBilltoProvinceState() {
		return billtoProvinceState;
	}

	public Order setBilltoProvinceState(String billtoProvinceState) {
		this.billtoProvinceState = billtoProvinceState;
		return this;
	}

	public String getBilltoCountry() {
		return billtoCountry;
	}

	public Order setBilltoCountry(String billtoCountry) {
		this.billtoCountry = billtoCountry;
		return this;
	}

	public String getBilltoPostalcode() {
		return billtoPostalcode;
	}

	public Order setBilltoPostalcode(String billtoPostalcode) {
		this.billtoPostalcode = billtoPostalcode;
		return this;
	}

	public String getBilltoPhone() {
		return billtoPhone;
	}

	public Order setBilltoPhone(String billtoPhone) {
		this.billtoPhone = billtoPhone;
		return this;
	}

	public String getBilltoEmail() {
		return billtoEmail;
	}

	public Order setBilltoEmail(String billtoEmail) {
		this.billtoEmail = billtoEmail;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public Order setStatus(String status) {
		this.status = status;
		return this;
	}

	public Order setStatus(ClickShipOrderStatus status) {
		this.status = status.getValue();
		return this;
	}

	public Order getParentOrder() {
		return parentOrder;
	}

	public Order setParentOrder(Order parentOrder) {
		this.parentOrder = parentOrder;
		return this;
	}

	public String getExternalOrderId() {
		return StringUtils.equals(this.orderRelType, "SC") ? this.parentOrder.getExternalOrderId()
				: externalOrderId;
	}

	public Order setExternalOrderId(String externalOrderId) {
		this.externalOrderId = externalOrderId;
		return this;
	}

	public String getShipfromContact() {
		return shipfromContact;
	}

	public Order setShipfromContact(String shipfromContact) {
		this.shipfromContact = ClickshipStringUtil.getStringStripAccents(shipfromContact);
		return this;
	}

	public String getShipfromCompany() {
		return shipfromCompany;
	}

	public Order setShipfromCompany(String shipfromCompany) {
		this.shipfromCompany = ClickshipStringUtil.getStringStripAccents(shipfromCompany);
		return this;
	}

	public String getShipfromEmail() {
		return shipfromEmail;
	}

	public Order setShipfromEmail(String shipfromEmail) {
		this.shipfromEmail = shipfromEmail;
		return this;
	}

	public String getShipfromPhone() {
		return shipfromPhone;
	}

	public Order setShipfromPhone(String shipfromPhone) {
		this.shipfromPhone = shipfromPhone;
		return this;
	}

	public String getNote() {
		return note;
	}

	public Order setNote(String note) {
		this.note = note;
		return this;
	}

	public String getExternalFulfillmentId() {
		return externalFulfillmentId;
	}

	public Order setExternalFulfillmentId(String externalFulfillmentId) {
		this.externalFulfillmentId = externalFulfillmentId;
		return this;
	}

	public Double getTotalDiscounts() {
		return totalDiscounts;
	}

	public Order setTotalDiscounts(Double totalDiscounts) {
		if (totalDiscounts == null) {
			totalDiscounts = 0d;
		}
		this.totalDiscounts = totalDiscounts;
		return this;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public Order setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
		return this;
	}

	public Double getTaxes() {
		return taxes;
	}

	public Order setTaxes(Double taxes) {
		this.taxes = taxes;
		return this;
	}

	public Date getEstShipDate() {
		return estShipDate;
	}

	public Order setEstShipDate(Date estShipDate) {
		this.estShipDate = estShipDate;
		return this;
	}

	public Date getCancelledDatetime() {
		return cancelledDatetime;
	}

	public Order setCancelledDatetime(Date cancelledDatetime) {
		this.cancelledDatetime = cancelledDatetime;
		return this;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public Order setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
		return this;
	}

	public String getServiceType() {
		return serviceType;
	}

	public Order setServiceType(String serviceType) {
		this.serviceType = serviceType;
		return this;
	}

	public String getServiceTypeCode() {
		return serviceTypeCode;
	}

	public Order setServiceTypeCode(String serviceTypeCode) {
		this.serviceTypeCode = serviceTypeCode;
		return this;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public Order setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
		return this;
	}

	public String getDeliveredTo() {
		return deliveredTo;
	}

	public Order setDeliveredTo(String deliveredTo) {
		this.deliveredTo = deliveredTo;
		return this;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public Order setShipDate(Date shipDate) {
		this.shipDate = shipDate;
		return this;
	}

	public Double getShippingCost() {
		return shippingCost;
	}

	public Order setShippingCost(Double shippingCost) {
		if (shippingCost == null) {
			shippingCost = 0d;
		}
		this.shippingCost = shippingCost;
		return this;
	}

	public String getShippingCurrency() {
		return shippingCurrency;
	}

	public Order setShippingCurrency(String shippingCurrency) {
		this.shippingCurrency = shippingCurrency;
		return this;
	}

	public String getCostCurrency() {
		return costCurrency;
	}

	public Order setCostCurrency(String costCurrency) {
		this.costCurrency = costCurrency;
		return this;
	}

	public boolean getAdultSignatureRequired() {
		return adultSignatureRequired;
	}

	public Order setAdultSignatureRequired(boolean adultSignatureRequired) {
		this.adultSignatureRequired = adultSignatureRequired;
		return this;
	}

	public boolean getSignatureRequired() {
		return signatureRequired;
	}

	public Order setSignatureRequired(boolean signatureRequired) {
		this.signatureRequired = signatureRequired;
		return this;
	}

	public boolean getResidentialDelivery() {
		return residentialDelivery;
	}

	public Order setResidentialDelivery(boolean residentialDelivery) {
		this.residentialDelivery = residentialDelivery;
		return this;
	}

	public boolean getSaturdayDelivery() {
		return saturdayDelivery;
	}

	public Order setSaturdayDelivery(boolean saturdayDelivery) {
		this.saturdayDelivery = saturdayDelivery;
		return this;
	}

	public boolean getSaturdayPickup() {
		return saturdayPickup;
	}

	public Order setSaturdayPickup(boolean saturdayPickup) {
		this.saturdayPickup = saturdayPickup;
		return this;
	}

	public boolean getSchedulePickUp() {
		return schedulePickUp;
	}

	public Order setSchedulePickUp(boolean schedulePickUp) {
		this.schedulePickUp = schedulePickUp;
		return this;
	}

	public List<Shipment> getShipments() {
		return shipments;
	}

	public Order setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
		return this;
	}

	public List<Orderline> getOrderlines() {
		return orderlines;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public Order setCarrier(Carrier carrier) {
		this.carrier = carrier;
		return this;
	}

	public Carrier getRtrCarrier() {
		return rtrCarrier;
	}

	public Order setRtrCarrier(Carrier rtrCarrier) {
		this.rtrCarrier = rtrCarrier;
		return this;		
	}

	public String getShiptoPhoneExt() {
		return shiptoPhoneExt;
	}

	public Order setShiptoPhoneExt(String shiptoPhoneExt) {
		this.shiptoPhoneExt = shiptoPhoneExt;
		return this;
	}

	public List<Tax> getTaxList() {
		return taxList;
	}

	public Order setTaxList(List<Tax> taxList) {
		this.taxList = taxList;
		return this;
	}
	
	public Order addTax(Tax tax) {
		if (this.taxList == null) {
			this.taxList = new ArrayList<>();
		}

		this.taxList.add(tax);

		return this;
	}

	public List<Discount> getDiscounts() {
		return discounts;
	}

	public Order setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
		return this;
	}
	
	public Order addDiscount(Discount discount) {
		if (this.discounts == null) {
			this.discounts = new ArrayList<>();
		}
		if (discount != null) {
			discount.setOrder(this);
		}
		this.discounts.add(discount);
		return this;
	}
	
	public Double getOriginalShippingCost() {
		return NumberUtility.getSafeCheckDoubleValue(originalShippingCost);
	}

	public Order setOriginalShippingCost(Double originalShippingCost) {
		if (originalShippingCost == null) {
			originalShippingCost = 0d;
		}
		
		this.originalShippingCost = originalShippingCost;
		return this;
	}

	public String getOriginalShippingCurrency() {
		return originalShippingCurrency;
	}

	public Order setOriginalShippingCurrency(String originalShippingCurrency) {
		this.originalShippingCurrency = originalShippingCurrency;
		return this;
	}

	public Double getOriginalTotal() {
		return originalTotal;
	}

	public Order setOriginalTotal(Double originalTotal) {
		this.originalTotal = originalTotal;
		return this;
	}

	public String getOrderRelType() {
		return orderRelType;
	}

	public Order setOrderRelType(String orderRelType) {
		this.orderRelType = orderRelType;
		return this;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public Order setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
		return this;
	}

	public boolean isPreSelectedCarrierEnabled() {
		return preSelectedCarrierEnabled;
	}

	public Order setPreSelectedCarrierEnabled(boolean preSelectedCarrierEnabled) {
		this.preSelectedCarrierEnabled = preSelectedCarrierEnabled;
		return this;
	}

	public boolean isHasReturnLabel() {
		return hasReturnLabel;
	}

	public Order setHasReturnLabel(boolean hasReturnLabel) {
		this.hasReturnLabel = hasReturnLabel;
		return this;
	}

	public boolean isArchived() {
		return archived;
	}

	public Order setArchived(boolean archived) {
		this.archived = archived;
		return this;
	}

	public boolean isEncrypted() {
		return isEncrypted;
	}
	
	public String getTrackingNumber() {
		return trackingNumber;
	}

	public Order setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
		return this;
	}

	public String getTrackingUrl() {
		return trackingUrl;
	}

	public Order setTrackingUrl(String trackingUrl) {
		this.trackingUrl = trackingUrl;
		return this;
	}

	public Order setEncrypted(boolean isEncrypted) {
		this.isEncrypted = isEncrypted;
		return this;
	}

	private String checkAndReturnDecryptedData(String data) {
		if (this.isEncrypted) {
			return Security.decryptPII(data);
		}
		return data;
	}

	public Date getExternallyFulfilledDate() {
		return externallyFulfilledDate;
	}

	public Order setExternallyFulfilledDate(Date externallyFulfilledDate) {
		this.externallyFulfilledDate = externallyFulfilledDate;
		return this;
	}

	public String getShiptoContactEnc() {
		return shiptoContactEnc;
	}

	public Order setShiptoContactEnc(String shiptoContactEnc) {
		this.shiptoContactEnc = shiptoContactEnc;
		return this;
	}

	public String getCsAddressId() {
		return csAddressId;
	}

	public Order setCsAddressId(String csAddressId) {
		this.csAddressId = csAddressId;
		return this;
	}

	public String getExternalLocationId() {
		return externalLocationId;
	}

	public Order setExternalLocationId(String externalLocationId) {
		this.externalLocationId = externalLocationId;
		return this;
	}

	public String getExtFulfillmentOrderId() {
		return extFulfillmentOrderId;
	}

	public Order setExtFulfillmentOrderId(String extFulfillmentOrderId) {
		this.extFulfillmentOrderId = extFulfillmentOrderId;
		return this;
	}

	public String getExtFulfillmentStatus() {
		return extFulfillmentStatus;
	}

	public Order setExtFulfillmentStatus(String extFulfillmentStatus) {
		this.extFulfillmentStatus = extFulfillmentStatus;
		return this;
	}

	public String getExtFulfillmentOrderType() {
		return extFulfillmentOrderType;
	}

	public Order setExtFulfillmentOrderType(String extFulfillmentOrderType) {
		this.extFulfillmentOrderType = extFulfillmentOrderType;
		return this;
	}

	public boolean isExtFulfillmentInfoCollected() {
		return extFulfillmentInfoCollected;
	}

	public Order setExtFulfillmentInfoCollected(boolean extFulfillmentInfoCollected) {
		this.extFulfillmentInfoCollected = extFulfillmentInfoCollected;
		return this;
	}

	public List<OrderShippingRule> getOrderShippingRules() {
		return orderShippingRules;
	}

	public void setOrderShippingRules(List<OrderShippingRule> orderShippingRules) {
		this.orderShippingRules = orderShippingRules;
	}

	public boolean isAutoFulfilled() {
		return autoFulfilled;
	}

	public Order setAutoFulfilled(boolean autoFulfilled) {
		this.autoFulfilled = autoFulfilled;
		return this;
	}

	public boolean isLabelAccessed() {
		return labelAccessed;
	}

	public void setLabelAccessed(boolean labelAccessed) {
		this.labelAccessed = labelAccessed;
	}

	public boolean isShippingRuleInProgress() {
		return shippingRuleInProgress;
	}

	public void setShippingRuleInProgress(boolean shippingRuleInProgress) {
		this.shippingRuleInProgress = shippingRuleInProgress;
	}	

}