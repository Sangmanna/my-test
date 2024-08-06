package com.freightcom.clickship.model.marketplace.bestbuy;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BestBuyOrders {

	@JsonProperty("acceptance_decision_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date acceptanceDecisionDate;

	@JsonProperty("can_cancel")
	private boolean canCancel;

	@JsonProperty("can_shop_ship")
	private boolean canShopShip;

	@JsonProperty("channel")
	private Channel channel;

	@JsonProperty("commercial_id")
	private String commercialId;

	@JsonProperty("created_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date createdDate;

	@JsonProperty("currency_iso_code")
	private String currencyIsoCode;

	@JsonProperty("customer")
	private Customer customer;

	@JsonProperty("customer_debited_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private String customerDebitedDate;

	@JsonProperty("customer_directly_pays_seller")
	private boolean customerDirectlyPaysSeller;

	@JsonProperty("customer_notification_email")
	private String customerNotificationEmail;

	@JsonProperty("delivery_date")
	private DeliveryDate deliveryDate;

	@JsonProperty("has_customer_message")
	private boolean hasCustomerMessage;

	@JsonProperty("has_incident")
	private boolean hasIncident;

	@JsonProperty("has_invoice")
	private boolean hasInvoice;

	@JsonProperty("fulfillment")
	private Fulfillment fulfillment;

	@JsonProperty("last_updated_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date lastUpdatedDate;

	@JsonProperty("leadtime_to_ship")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date leadtimeToShip;

	@JsonProperty("order_id")
	private String orderId;

	@JsonProperty("order_lines")
	private List<OrderLines> orderLines;

	@JsonProperty("order_state")
	private String orderState;

	@JsonProperty("order_state_reason_code")
	private String orderStateReasonCode;

	@JsonProperty("order_state_reason_label")
	private String orderStateReasonLabel;

	@JsonProperty("order_tax_mode")
	private String orderTaxMode;

	@JsonProperty("payment_duration")
	private int paymentDuration;

	@JsonProperty("payment_type")
	private String paymentType;

	@JsonProperty("payment_workflow")
	private String payment_workflow;

	@JsonProperty("price")
	private double price;

	@JsonProperty("quote_id")
	private String quoteId;

	@JsonProperty("shipping_carrier_code")
	private String shippingCarrierCode;

	@JsonProperty("shipping_company")
	private String shippingCompany;

	@JsonProperty("shipping_deadline")
	private String shippingDeadline;

	@JsonProperty("shipping_price")
	private double shippingPrice;

	@JsonProperty("shipping_pudo_id")
	private String shippingPudoId;

	@JsonProperty("shipping_tracking")
	private String shippingTracking;

	@JsonProperty("shipping_tracking_url")
	private String shippingTrackingUrl;

	@JsonProperty("shipping_type_code")
	private String shippingTypeCode;

	@JsonProperty("shipping_type_label")
	private String shippingTypeLabel;

	@JsonProperty("shipping_zone_code")
	private String shippingZoneCode;

	@JsonProperty("shipping_zone_label")
	private String shippingZoneLabel;

	@JsonProperty("total_commission")
	private double totalCommission;

	@JsonProperty("total_price")
	private double totalPrice;

	@JsonProperty("transaction_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private String transactionDate;

	@JsonProperty("transaction_number")
	private String transactionNumber;


	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public String getCommercialId() {
		return commercialId;
	}

	public void setCommercialId(String commercialId) {
		this.commercialId = commercialId;
	}

	public String getCurrencyIsoCode() {
		return currencyIsoCode;
	}

	public void setCurrencyIsoCode(String currencyIsoCode) {
		this.currencyIsoCode = currencyIsoCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Fulfillment getFulfillment() {
		return fulfillment;
	}

	public void setFulfillment(Fulfillment fulfillment) {
		this.fulfillment = fulfillment;
	}

	public List<OrderLines> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLines> orderLines) {
		this.orderLines = orderLines;
	}

	public String getPayment_workflow() {
		return payment_workflow;
	}

	public void setPayment_workflow(String payment_workflow) {
		this.payment_workflow = payment_workflow;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getAcceptanceDecisionDate() {
		return acceptanceDecisionDate;
	}

	public void setAcceptanceDecisionDate(Date acceptanceDecisionDate) {
		this.acceptanceDecisionDate = acceptanceDecisionDate;
	}

	public boolean isCanCancel() {
		return canCancel;
	}

	public void setCanCancel(boolean canCancel) {
		this.canCancel = canCancel;
	}

	public boolean isCanShopShip() {
		return canShopShip;
	}

	public void setCanShopShip(boolean canShopShip) {
		this.canShopShip = canShopShip;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCustomerDebitedDate() {
		return customerDebitedDate;
	}

	public void setCustomerDebitedDate(String customerDebitedDate) {
		this.customerDebitedDate = customerDebitedDate;
	}

	public boolean isCustomerDirectlyPaysSeller() {
		return customerDirectlyPaysSeller;
	}

	public void setCustomerDirectlyPaysSeller(boolean customerDirectlyPaysSeller) {
		this.customerDirectlyPaysSeller = customerDirectlyPaysSeller;
	}

	public String getCustomerNotificationEmail() {
		return customerNotificationEmail;
	}

	public void setCustomerNotificationEmail(String customerNotificationEmail) {
		this.customerNotificationEmail = customerNotificationEmail;
	}

	public DeliveryDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(DeliveryDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public boolean isHasCustomerMessage() {
		return hasCustomerMessage;
	}

	public void setHasCustomerMessage(boolean hasCustomerMessage) {
		this.hasCustomerMessage = hasCustomerMessage;
	}

	public boolean isHasIncident() {
		return hasIncident;
	}

	public void setHasIncident(boolean hasIncident) {
		this.hasIncident = hasIncident;
	}

	public boolean isHasInvoice() {
		return hasInvoice;
	}

	public void setHasInvoice(boolean hasInvoice) {
		this.hasInvoice = hasInvoice;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Date getLeadtimeToShip() {
		return leadtimeToShip;
	}

	public void setLeadtimeToShip(Date leadtimeToShip) {
		this.leadtimeToShip = leadtimeToShip;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getOrderStateReasonCode() {
		return orderStateReasonCode;
	}

	public void setOrderStateReasonCode(String orderStateReasonCode) {
		this.orderStateReasonCode = orderStateReasonCode;
	}

	public String getOrderStateReasonLabel() {
		return orderStateReasonLabel;
	}

	public void setOrderStateReasonLabel(String orderStateReasonLabel) {
		this.orderStateReasonLabel = orderStateReasonLabel;
	}

	public String getOrderTaxMode() {
		return orderTaxMode;
	}

	public void setOrderTaxMode(String orderTaxMode) {
		this.orderTaxMode = orderTaxMode;
	}

	public int getPaymentDuration() {
		return paymentDuration;
	}

	public void setPaymentDuration(int paymentDuration) {
		this.paymentDuration = paymentDuration;
	}

	public String getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(String quoteId) {
		this.quoteId = quoteId;
	}

	public String getShippingCarrierCode() {
		return shippingCarrierCode;
	}

	public void setShippingCarrierCode(String shippingCarrierCode) {
		this.shippingCarrierCode = shippingCarrierCode;
	}

	public String getShippingCompany() {
		return shippingCompany;
	}

	public void setShippingCompany(String shippingCompany) {
		this.shippingCompany = shippingCompany;
	}

	public String getShippingDeadline() {
		return shippingDeadline;
	}

	public void setShippingDeadline(String shippingDeadline) {
		this.shippingDeadline = shippingDeadline;
	}

	public double getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(double shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public String getShippingPudoId() {
		return shippingPudoId;
	}

	public void setShippingPudoId(String shippingPudoId) {
		this.shippingPudoId = shippingPudoId;
	}

	public String getShippingTracking() {
		return shippingTracking;
	}

	public void setShippingTracking(String shippingTracking) {
		this.shippingTracking = shippingTracking;
	}

	public String getShippingTrackingUrl() {
		return shippingTrackingUrl;
	}

	public void setShippingTrackingUrl(String shippingTrackingUrl) {
		this.shippingTrackingUrl = shippingTrackingUrl;
	}

	public String getShippingTypeCode() {
		return shippingTypeCode;
	}

	public void setShippingTypeCode(String shippingTypeCode) {
		this.shippingTypeCode = shippingTypeCode;
	}

	public String getShippingTypeLabel() {
		return shippingTypeLabel;
	}

	public void setShippingTypeLabel(String shippingTypeLabel) {
		this.shippingTypeLabel = shippingTypeLabel;
	}

	public String getShippingZoneCode() {
		return shippingZoneCode;
	}

	public void setShippingZoneCode(String shippingZoneCode) {
		this.shippingZoneCode = shippingZoneCode;
	}

	public String getShippingZoneLabel() {
		return shippingZoneLabel;
	}

	public void setShippingZoneLabel(String shippingZoneLabel) {
		this.shippingZoneLabel = shippingZoneLabel;
	}

	public double getTotalCommission() {
		return totalCommission;
	}

	public void setTotalCommission(double totalCommission) {
		this.totalCommission = totalCommission;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Channel {
		@JsonProperty("code")
		private String code;

		@JsonProperty("label")
		private String label;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class DeliveryDate {
		@JsonProperty("earliest")
		private String earliest;

		@JsonProperty("latest")
		private String latest;

		public String getEarliest() {
			return earliest;
		}

		public void setEarliest(String earliest) {
			this.earliest = earliest;
		}

		public String getLatest() {
			return latest;
		}

		public void setLatest(String latest) {
			this.latest = latest;
		}

	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Fulfillment {
		@JsonProperty("center")
		private Center center;

		public Center getCenter() {
			return center;
		}

		public void setCenter(Center center) {
			this.center = center;
		}
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Center {
		@JsonProperty("code")
		private String code;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Customer {

		@JsonProperty("accounting_contact")
		private AccountingContact accounting_contact;

		@JsonProperty("billing_address")
		private BillingAddress billing_address;

		@JsonProperty("civility")
		private String civility;

		@JsonProperty("customer_id")
		private String customer_id;

		@JsonProperty("delivery_contact")
		private DeliveryContact delivery_contact;

		@JsonProperty("firstname")
		private String firstname;

		@JsonProperty("lastname")
		private String lastname;

		@JsonProperty("locale")
		private String locale;

		@JsonProperty("organization")
		private Organization organization;

		@JsonProperty("shipping_address")
		private ShippingAddress shipping_address;

		public AccountingContact getAccounting_contact() {
			return accounting_contact;
		}

		public void setAccounting_contact(AccountingContact accounting_contact) {
			this.accounting_contact = accounting_contact;
		}

		public BillingAddress getBilling_address() {
			return billing_address;
		}

		public void setBilling_address(BillingAddress billing_address) {
			this.billing_address = billing_address;
		}

		public String getCivility() {
			return civility;
		}

		public void setCivility(String civility) {
			this.civility = civility;
		}

		public String getCustomer_id() {
			return customer_id;
		}

		public void setCustomer_id(String customer_id) {
			this.customer_id = customer_id;
		}

		public DeliveryContact getDelivery_contact() {
			return delivery_contact;
		}

		public void setDelivery_contact(DeliveryContact delivery_contact) {
			this.delivery_contact = delivery_contact;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getLocale() {
			return locale;
		}

		public void setLocale(String locale) {
			this.locale = locale;
		}

		public Organization getOrganization() {
			return organization;
		}

		public void setOrganization(Organization organization) {
			this.organization = organization;
		}

		public ShippingAddress getShipping_address() {
			return shipping_address;
		}

		public void setShipping_address(ShippingAddress shipping_address) {
			this.shipping_address = shipping_address;
		}
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class AccountingContact {

		@JsonProperty("civility")
		private String civility;

		@JsonProperty("customer_id")
		private String customer_id;

		@JsonProperty("firstname")
		private String firstname;

		@JsonProperty("lastname")
		private String lastname;

		@JsonProperty("locale")
		private String locale;

		public String getCivility() {
			return civility;
		}

		public void setCivility(String civility) {
			this.civility = civility;
		}

		public String getCustomer_id() {
			return customer_id;
		}

		public void setCustomer_id(String customer_id) {
			this.customer_id = customer_id;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getLocale() {
			return locale;
		}

		public void setLocale(String locale) {
			this.locale = locale;
		}

	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class BillingAddress {

		@JsonProperty("city")
		private String city;

		@JsonProperty("civility")
		private String civility;

		@JsonProperty("company")
		private String company;

		@JsonProperty("country")
		private String country;

		@JsonProperty("country_iso_code")
		private String country_iso_code;

		@JsonProperty("firstname")
		private String firstname;

		@JsonProperty("lastname")
		private String lastname;

		@JsonProperty("phone")
		private String phone;

		@JsonProperty("phone_secondary")
		private String phone_secondary;

		@JsonProperty("state")
		private String state;

		@JsonProperty("street_1")
		private String street_1;

		@JsonProperty("street_2")
		private String street_2;

		@JsonProperty("zip_code")
		private String zip_code;

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCivility() {
			return civility;
		}

		public void setCivility(String civility) {
			this.civility = civility;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getCountry_iso_code() {
			return country_iso_code;
		}

		public void setCountry_iso_code(String country_iso_code) {
			this.country_iso_code = country_iso_code;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getPhone_secondary() {
			return phone_secondary;
		}

		public void setPhone_secondary(String phone_secondary) {
			this.phone_secondary = phone_secondary;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getStreet_1() {
			return street_1;
		}

		public void setStreet_1(String street_1) {
			this.street_1 = street_1;
		}

		public String getStreet_2() {
			return street_2;
		}

		public void setStreet_2(String street_2) {
			this.street_2 = street_2;
		}

		public String getZip_code() {
			return zip_code;
		}

		public void setZip_code(String zip_code) {
			this.zip_code = zip_code;
		}
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class DeliveryContact {

		@JsonProperty("civility")
		private String civility;

		@JsonProperty("customer_id")
		private String customer_id;

		@JsonProperty("firstname")
		private String firstname;

		@JsonProperty("lastname")
		private String lastname;

		@JsonProperty("locale")
		private String locale;

		public String getCivility() {
			return civility;
		}

		public void setCivility(String civility) {
			this.civility = civility;
		}

		public String getCustomer_id() {
			return customer_id;
		}

		public void setCustomer_id(String customer_id) {
			this.customer_id = customer_id;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getLocale() {
			return locale;
		}

		public void setLocale(String locale) {
			this.locale = locale;
		}
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Shippings {

		@JsonProperty("additional_fields")
		private List<String> additionalFields;

		@JsonProperty("shipping_free_amount")
		private float shippingFreeAmount;

		@JsonProperty("shipping_type_code")
		private String shippingTypeCode;

		@JsonProperty("shipping_type_label")
		private String shippingTypeLabel;

		@JsonProperty("shipping_zone_code")
		private String shippingZoneCode;

		@JsonProperty("shipping_zone_label")
		private String shippingZoneLabel;

		public List<String> getAdditionalFields() {
			return additionalFields;
		}

		public void setAdditionalFields(List<String> additionalFields) {
			this.additionalFields = additionalFields;
		}

		public float getShippingFreeAmount() {
			return shippingFreeAmount;
		}

		public void setShippingFreeAmount(float shippingFreeAmount) {
			this.shippingFreeAmount = shippingFreeAmount;
		}

		public String getShippingTypeCode() {
			return shippingTypeCode;
		}

		public void setShippingTypeCode(String shippingTypeCode) {
			this.shippingTypeCode = shippingTypeCode;
		}

		public String getShippingTypeLabel() {
			return shippingTypeLabel;
		}

		public void setShippingTypeLabel(String shippingTypeLabel) {
			this.shippingTypeLabel = shippingTypeLabel;
		}

		public String getShippingZoneCode() {
			return shippingZoneCode;
		}

		public void setShippingZoneCode(String shippingZoneCode) {
			this.shippingZoneCode = shippingZoneCode;
		}

		public String getShippingZoneLabel() {
			return shippingZoneLabel;
		}

		public void setShippingZoneLabel(String shippingZoneLabel) {
			this.shippingZoneLabel = shippingZoneLabel;
		}

	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ShopAdditionalFields {

		@JsonProperty("code")
		private String code;

		@JsonProperty("type")
		private boolean type;

		@JsonProperty("value")
		private String value;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public boolean isType() {
			return type;
		}

		public void setType(boolean type) {
			this.type = type;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Organization {

		@JsonProperty("address")
		private Address address;

		@JsonProperty("identification_number")
		private String identification_number;

		@JsonProperty("name")
		private String name;

		@JsonProperty("organization_id")
		private String organization_id;

		@JsonProperty("tax_identification_number")
		private String tax_identification_number;

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public String getIdentification_number() {
			return identification_number;
		}

		public void setIdentification_number(String identification_number) {
			this.identification_number = identification_number;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getOrganization_id() {
			return organization_id;
		}

		public void setOrganization_id(String organization_id) {
			this.organization_id = organization_id;
		}

		public String getTax_identification_number() {
			return tax_identification_number;
		}

		public void setTax_identification_number(String tax_identification_number) {
			this.tax_identification_number = tax_identification_number;
		}

	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Address {

		@JsonProperty("city")
		private String city;

		@JsonProperty("country_iso_code")
		private String country_iso_code;

		@JsonProperty("state")
		private String state;

		@JsonProperty("street_1")
		private String street_1;

		@JsonProperty("street_2")
		private String street_2;

		@JsonProperty("zip_code")
		private String zip_code;

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCountry_iso_code() {
			return country_iso_code;
		}

		public void setCountry_iso_code(String country_iso_code) {
			this.country_iso_code = country_iso_code;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getStreet_1() {
			return street_1;
		}

		public void setStreet_1(String street_1) {
			this.street_1 = street_1;
		}

		public String getStreet_2() {
			return street_2;
		}

		public void setStreet_2(String street_2) {
			this.street_2 = street_2;
		}

		public String getZip_code() {
			return zip_code;
		}

		public void setZip_code(String zip_code) {
			this.zip_code = zip_code;
		}

	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ShippingAddress {

		@JsonProperty("additional_info")
		private String additional_info;

		@JsonProperty("city")
		private String city;

		@JsonProperty("civility")
		private String civility;

		@JsonProperty("company")
		private String company;

		@JsonProperty("country")
		private String country;

		@JsonProperty("country_iso_code")
		private String country_iso_code;

		@JsonProperty("firstname")
		private String firstname;

		@JsonProperty("lastname")
		private String lastname;

		@JsonProperty("phone")
		private String phone;

		@JsonProperty("phone_secondary")
		private String phone_secondary;

		@JsonProperty("state")
		private String state;

		@JsonProperty("street_1")
		private String street_1;

		@JsonProperty("street_2")
		private String street_2;

		@JsonProperty("zip_code")
		private String zip_code;

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCountry_iso_code() {
			return country_iso_code;
		}

		public void setCountry_iso_code(String country_iso_code) {
			this.country_iso_code = country_iso_code;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getStreet_1() {
			return street_1;
		}

		public void setStreet_1(String street_1) {
			this.street_1 = street_1;
		}

		public String getStreet_2() {
			return street_2;
		}

		public void setStreet_2(String street_2) {
			this.street_2 = street_2;
		}

		public String getZip_code() {
			return zip_code;
		}

		public void setZip_code(String zip_code) {
			this.zip_code = zip_code;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getAdditional_info() {
			return additional_info;
		}

		public void setAdditional_info(String additional_info) {
			this.additional_info = additional_info;
		}

		public String getCivility() {
			return civility;
		}

		public void setCivility(String civility) {
			this.civility = civility;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getPhone_secondary() {
			return phone_secondary;
		}

		public void setPhone_secondary(String phone_secondary) {
			this.phone_secondary = phone_secondary;
		}

	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class OrderLines {
		@JsonProperty("category_code")
		private String categoryCode;

		@JsonProperty("can_refund")
		private boolean canRefund;

		@JsonProperty("category_label")
		private String categoryLabel;

		@JsonProperty("commission_fee")
		private String commissionFee;

		@JsonProperty("commission_rate_vat")
		private String commissionRateVat;

		@JsonProperty("commission_vat")
		private String commissionVat;

		@JsonProperty("created_date")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
		private String createdDate;

		@JsonProperty("debited_date")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
		private String debitedDate;

		@JsonProperty("description")
		private String description;

		@JsonProperty("last_updated_date")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
		private String lastUpdatedDate;

		@JsonProperty("measurement")
		private Measurement measurement;

		@JsonProperty("offer_id")
		private int offerId;

		@JsonProperty("offer_sku")
		private String offerSku;

		@JsonProperty("offer_state_code")
		private String offerStateCode;

//	@JsonProperty("order_line_additional_fields")
//	private List<Object> order_line_additional_fields;

		@JsonProperty("order_line_id")
		private String orderLineId;

		@JsonProperty("order_line_index")
		private int orderLineindex;

		@JsonProperty("order_line_state")
		private String orderLineState;

		@JsonProperty("order_line_state_reason_code")
		private String orderLineStateReasonCode;

		@JsonProperty("order_line_state_reason_label")
		private String orderLineStateReasonLabel;

		@JsonProperty("price")
		private double price;

		@JsonProperty("price_additional_info")
		private String priceAdditionalInfo;

		@JsonProperty("price_unit")
		private float priceUnit;

		@JsonProperty("product_sku")
		private String productSku;

		@JsonProperty("product_title")
		private String productTitle;

		@JsonProperty("quantity")
		private int quantity;

		@JsonProperty("recieved_date")
		private String recievedDate;

		@JsonProperty("shipped_date")
		private String shippedDate;

		@JsonProperty("shipping_price")
		private double orderLineShippingPrice;

		@JsonProperty("total_commission")
		private double totalCommission;

		@JsonProperty("total_price")
		private double totalPrice;

		@JsonProperty("cancellations")
		private List<Cancellations> cancellations;
		
		@JsonProperty("refunds")
		private List<Refunds> refunds;
		

		public List<Refunds> getRefunds() {
			return refunds;
		}

		public void setRefunds(List<Refunds> refunds) {
			this.refunds = refunds;
		}

		public String getCategoryCode() {
			return categoryCode;
		}

		public void setCategoryCode(String categoryCode) {
			this.categoryCode = categoryCode;
		}

		public boolean isCanRefund() {
			return canRefund;
		}

		public void setCanRefund(boolean canRefund) {
			this.canRefund = canRefund;
		}

		public String getCategoryLabel() {
			return categoryLabel;
		}

		public void setCategoryLabel(String categoryLabel) {
			this.categoryLabel = categoryLabel;
		}

		public String getCommissionFee() {
			return commissionFee;
		}

		public void setCommissionFee(String commissionFee) {
			this.commissionFee = commissionFee;
		}

		public String getCommissionRateVat() {
			return commissionRateVat;
		}

		public void setCommissionRateVat(String commissionRateVat) {
			this.commissionRateVat = commissionRateVat;
		}

		public String getCommissionVat() {
			return commissionVat;
		}

		public void setCommissionVat(String commissionVat) {
			this.commissionVat = commissionVat;
		}

		public String getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}

		public String getDebitedDate() {
			return debitedDate;
		}

		public void setDebitedDate(String debitedDate) {
			this.debitedDate = debitedDate;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getLastUpdatedDate() {
			return lastUpdatedDate;
		}

		public void setLastUpdatedDate(String lastUpdatedDate) {
			this.lastUpdatedDate = lastUpdatedDate;
		}

		public Measurement getMeasurement() {
			return measurement;
		}

		public void setMeasurement(Measurement measurement) {
			this.measurement = measurement;
		}

		public int getOfferId() {
			return offerId;
		}

		public void setOfferId(int offerId) {
			this.offerId = offerId;
		}

		public String getOfferSku() {
			return offerSku;
		}

		public void setOfferSku(String offerSku) {
			this.offerSku = offerSku;
		}

		public String getOfferStateCode() {
			return offerStateCode;
		}

		public void setOfferStateCode(String offerStateCode) {
			this.offerStateCode = offerStateCode;
		}

		public String getOrderLineId() {
			return orderLineId;
		}

		public void setOrderLineId(String orderLineId) {
			this.orderLineId = orderLineId;
		}

		public int getOrderLineindex() {
			return orderLineindex;
		}

		public void setOrderLineindex(int orderLineindex) {
			this.orderLineindex = orderLineindex;
		}

		public String getOrderLineState() {
			return orderLineState;
		}

		public void setOrderLineState(String orderLineState) {
			this.orderLineState = orderLineState;
		}

		public String getOrderLineStateReasonCode() {
			return orderLineStateReasonCode;
		}

		public void setOrderLineStateReasonCode(String orderLineStateReasonCode) {
			this.orderLineStateReasonCode = orderLineStateReasonCode;
		}

		public String getOrderLineStateReasonLabel() {
			return orderLineStateReasonLabel;
		}

		public void setOrderLineStateReasonLabel(String orderLineStateReasonLabel) {
			this.orderLineStateReasonLabel = orderLineStateReasonLabel;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getPriceAdditionalInfo() {
			return priceAdditionalInfo;
		}

		public void setPriceAdditionalInfo(String priceAdditionalInfo) {
			this.priceAdditionalInfo = priceAdditionalInfo;
		}

		public float getPriceUnit() {
			return priceUnit;
		}

		public void setPriceUnit(float priceUnit) {
			this.priceUnit = priceUnit;
		}

		public String getProductSku() {
			return productSku;
		}

		public void setProductSku(String productSku) {
			this.productSku = productSku;
		}

		public String getProductTitle() {
			return productTitle;
		}

		public void setProductTitle(String productTitle) {
			this.productTitle = productTitle;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getRecievedDate() {
			return recievedDate;
		}

		public void setRecievedDate(String recievedDate) {
			this.recievedDate = recievedDate;
		}

		public String getShippedDate() {
			return shippedDate;
		}

		public void setShippedDate(String shippedDate) {
			this.shippedDate = shippedDate;
		}

		public double getOrderLineShippingPrice() {
			return orderLineShippingPrice;
		}

		public void setOrderLineShippingPrice(double orderLineShippingPrice) {
			this.orderLineShippingPrice = orderLineShippingPrice;
		}

		public double getTotalCommission() {
			return totalCommission;
		}

		public void setTotalCommission(double totalCommission) {
			this.totalCommission = totalCommission;
		}

		public double getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}

		public List<Cancellations> getCancellations() {
			return cancellations;
		}

		public void setCancellations(List<Cancellations> cancellations) {
			this.cancellations = cancellations;
		}
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Measurement {
		@JsonProperty("actual_measurement")
		private double actualMeasurement;

		@JsonProperty("adjustment_limit")
		private double adjustmentLimit;

		@JsonProperty("measurement_unit")
		private float measurementUnit;

		@JsonProperty("commission_fee")
		private double commissionFee;

		@JsonProperty("ordered_measurement")
		private double orderedMeasurement;

		@JsonProperty("commission_vat")
		private double commissionVat;

		public double getActualMeasurement() {
			return actualMeasurement;
		}

		public void setActualMeasurement(double actualMeasurement) {
			this.actualMeasurement = actualMeasurement;
		}

		public double getAdjustmentLimit() {
			return adjustmentLimit;
		}

		public void setAdjustmentLimit(double adjustmentLimit) {
			this.adjustmentLimit = adjustmentLimit;
		}

		public float getMeasurementUnit() {
			return measurementUnit;
		}

		public void setMeasurementUnit(float measurementUnit) {
			this.measurementUnit = measurementUnit;
		}

		public double getCommissionFee() {
			return commissionFee;
		}

		public void setCommissionFee(double commissionFee) {
			this.commissionFee = commissionFee;
		}

		public double getOrderedMeasurement() {
			return orderedMeasurement;
		}

		public void setOrderedMeasurement(double orderedMeasurement) {
			this.orderedMeasurement = orderedMeasurement;
		}

		public double getCommissionVat() {
			return commissionVat;
		}

		public void setCommissionVat(double commissionVat) {
			this.commissionVat = commissionVat;
		}

	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Cancellations {
		@JsonProperty("amount")
		private double amount;

		@JsonProperty("commission_amount")
		private double commissionAmount;

		@JsonProperty("commission_total_amount")
		private double commissionTotalAmount;

		@JsonProperty("created_date")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
		private Date createdDate;

		@JsonProperty("id")
		private String id;

		@JsonProperty("quantity")
		private int quantity;

		@JsonProperty("reason_code")
		private String reasonCode;

		@JsonProperty("shipping_amount")
		private double shippingAmount;

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public double getCommissionAmount() {
			return commissionAmount;
		}

		public void setCommissionAmount(double commissionAmount) {
			this.commissionAmount = commissionAmount;
		}

		public double getCommissionTotalAmount() {
			return commissionTotalAmount;
		}

		public void setCommissionTotalAmount(double commissionTotalAmount) {
			this.commissionTotalAmount = commissionTotalAmount;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getReasonCode() {
			return reasonCode;
		}

		public void setReasonCode(String reasonCode) {
			this.reasonCode = reasonCode;
		}

		public double getShippingAmount() {
			return shippingAmount;
		}

		public void setShippingAmount(double shippingAmount) {
			this.shippingAmount = shippingAmount;
		}

	}
	
	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Refunds {
		@JsonProperty("amount")
		private double amount;

		@JsonProperty("commission_amount")
		private double commissionAmount;
		
		@JsonProperty("commission_taxes")
		private List<ComissionTaxes> commissionTaxes;
		
		@JsonProperty("commission_total_amount")
		private double commissionTotalAmount;

		@JsonProperty("created_date")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
		private Date createdDate;

		@JsonProperty("id")
		private String id;

		@JsonProperty("quantity")
		private int quantity;

		@JsonProperty("reason_code")
		private String reasonCode;

		@JsonProperty("shipping_amount")
		private double shippingAmount;
		
		@JsonProperty("state")
		private String refundSate;
		
		@JsonProperty("transaction_date")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
		private Date transactionDate;
		
		@JsonProperty("transaction_number")
		private String transaction_number;

		public List<ComissionTaxes> getCommissionTaxes() {
			return commissionTaxes;
		}

		public void setCommissionTaxes(List<ComissionTaxes> commissionTaxes) {
			this.commissionTaxes = commissionTaxes;
		}

		public String getRefundSate() {
			return refundSate;
		}

		public void setRefundSate(String refundSate) {
			this.refundSate = refundSate;
		}

		public Date getTransactionDate() {
			return transactionDate;
		}

		public void setTransactionDate(Date transactionDate) {
			this.transactionDate = transactionDate;
		}

		public String getTransaction_number() {
			return transaction_number;
		}

		public void setTransaction_number(String transaction_number) {
			this.transaction_number = transaction_number;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public double getCommissionAmount() {
			return commissionAmount;
		}

		public void setCommissionAmount(double commissionAmount) {
			this.commissionAmount = commissionAmount;
		}

		public double getCommissionTotalAmount() {
			return commissionTotalAmount;
		}

		public void setCommissionTotalAmount(double commissionTotalAmount) {
			this.commissionTotalAmount = commissionTotalAmount;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getReasonCode() {
			return reasonCode;
		}

		public void setReasonCode(String reasonCode) {
			this.reasonCode = reasonCode;
		}

		public double getShippingAmount() {
			return shippingAmount;
		}

		public void setShippingAmount(double shippingAmount) {
			this.shippingAmount = shippingAmount;
		}

	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class AmountRefund{
		
		@JsonProperty("amount")
		private double amount;
		
		@JsonProperty("code")
		private String code;

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}
	}
	
	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ComissionTaxes{
		
		@JsonProperty("amount")
		private double amount;
		
		@JsonProperty("code")
		private String code;

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}
	}
}
