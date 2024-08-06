package com.freightcom.clickship.model.marketplace.bestbuy;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BestBuyResponse {

	@JsonProperty("applicable_taxes")
	private List<ApplicableTaxes> applicableTaxes;

	@JsonProperty("approval_delay")
	private int approvalDelay;

	@JsonProperty("approval_rate")
	private float approvalRate;

	@JsonProperty("banner")
	private String banner;

	@JsonProperty("billing_info")
	private BillingInfo billinginfo;

	@JsonProperty("channels")
	private List<String> channels;

	@JsonProperty("closed_from")
	private String closedFrom;

	@JsonProperty("closed_to")
	private String closedTo;

	@JsonProperty("contact_informations")
	private ContactInformations contactInformations;

	@JsonProperty("currency_iso_code")
	private String currencyIsoCode;

	@JsonProperty("date_created")
	private String dateCreated;

	@JsonProperty("description")
	private String description;

	@JsonProperty("domains")
	private List<String> domains;

	@JsonProperty("evaluations_count")
	private String evaluationsCount;

	@JsonProperty("free_shipping")
	private String freeShipping;

	@JsonProperty("grade")
	private String grade;

	@JsonProperty("is_professional")
	private String isProfessional;

	@JsonProperty("last_updated_date")
	private String lastUpdatedDate;

	@JsonProperty("logo")
	private String logo;

	@JsonProperty("offers_count")
	private String offersCount;

	@JsonProperty("order_messages_response_delay")
	private String orderMessagesSesponseDelay;

	@JsonProperty("orders_count")
	private String ordersCount;

	@JsonProperty("payment_details")
	private PaymentDetails paymentDetails;

	@JsonProperty("premium")
	private String premium;

	@JsonProperty("pro_details")
	private ProDetails proDetails;

	@JsonProperty("return_policy")
	private String returnPolicy;

	@JsonProperty("shipping_country")
	private String shippingCountry;

	@JsonProperty("shipping_types")
	private List<String> shippingTypes;

	@JsonProperty("shipping_zones")
	private List<String> shippingZones;

	@JsonProperty("shippings")
	private List<Shippings> shippings;

	@JsonProperty("shop_id")
	private String shopId;

	@JsonProperty("shop_name")
	private String shopName;

	@JsonProperty("shop_state")
	private String shopState;

	@JsonProperty("suspension_type")
	private String suspensionType;

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ApplicableTaxes {
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
	public static class ContactInformations {
		@JsonProperty("city")
		private String city;

		@JsonProperty("civility")
		private String civility;

		@JsonProperty("country")
		private String country;

		@JsonProperty("email")
		private String email;

		@JsonProperty("fax")
		private String fax;

		@JsonProperty("firstname")
		private String firstname;

		@JsonProperty("lastname")
		private String lastname;

		@JsonProperty("phone")
		private String phone;

		@JsonProperty("phone_secondary")
		private String phoneSecondary;

		@JsonProperty("state")
		private String state;

		@JsonProperty("street1")
		private String street1;

		@JsonProperty("street2")
		private String street2;

		@JsonProperty("web_site")
		private String webSite;

		@JsonProperty("zip_code")
		private String zipCode;

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

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFax() {
			return fax;
		}

		public void setFax(String fax) {
			this.fax = fax;
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

		public String getPhoneSecondary() {
			return phoneSecondary;
		}

		public void setPhoneSecondary(String phoneSecondary) {
			this.phoneSecondary = phoneSecondary;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getStreet1() {
			return street1;
		}

		public void setStreet1(String street1) {
			this.street1 = street1;
		}

		public String getStreet2() {
			return street2;
		}

		public void setStreet2(String street2) {
			this.street2 = street2;
		}

		public String getWebSite() {
			return webSite;
		}

		public void setWebSite(String webSite) {
			this.webSite = webSite;
		}

		public String getZipCode() {
			return zipCode;
		}

		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}

	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class PaymentDetails {

		@JsonProperty("paid_balance")
		private float paidBalance;

		@JsonProperty("payable_balance")
		private float payableBalance;

		@JsonProperty("pending_balance")
		private float pendingBalance;

		public float getPaidBalance() {
			return paidBalance;
		}

		public void setPaidBalance(float paidBalance) {
			this.paidBalance = paidBalance;
		}

		public float getPayableBalance() {
			return payableBalance;
		}

		public void setPayableBalance(float payableBalance) {
			this.payableBalance = payableBalance;
		}

		public float getPendingBalance() {
			return pendingBalance;
		}

		public void setPendingBalance(float pendingBalance) {
			this.pendingBalance = pendingBalance;
		}

	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ProDetails {

		@JsonProperty("VAT_number")
		private String VatNumber;

		@JsonProperty("corporate_name")
		private String corporateName;

		@JsonProperty("identification_number")
		private String identificationNumber;

		@JsonProperty("tax_identification_number")
		private String taxIdentificationNumber;

		public String getVatNumber() {
			return VatNumber;
		}

		public void setVatNumber(String vatNumber) {
			VatNumber = vatNumber;
		}

		public String getCorporateName() {
			return corporateName;
		}

		public void setCorporateName(String corporateName) {
			this.corporateName = corporateName;
		}

		public String getIdentificationNumber() {
			return identificationNumber;
		}

		public void setIdentificationNumber(String identificationNumber) {
			this.identificationNumber = identificationNumber;
		}

		public String getTaxIdentificationNumber() {
			return taxIdentificationNumber;
		}

		public void setTaxIdentificationNumber(String taxIdentificationNumber) {
			this.taxIdentificationNumber = taxIdentificationNumber;
		}
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class BillingInfo {

		@JsonProperty("bank_city")
		private String bankCity;

		@JsonProperty("bank_name")
		private int bankName;

		@JsonProperty("bank_street")
		private String bankStreet;

		@JsonProperty("bic")
		private String bic;

		@JsonProperty("iban")
		private String iban;

		@JsonProperty("owner")
		private String owner;

		@JsonProperty("zip_code")
		private String zipCode;

		public String getBankCity() {
			return bankCity;
		}

		public void setBankCity(String bankCity) {
			this.bankCity = bankCity;
		}

		public int getBankName() {
			return bankName;
		}

		public void setBankName(int bankName) {
			this.bankName = bankName;
		}

		public String getBankStreet() {
			return bankStreet;
		}

		public void setBankStreet(String bankStreet) {
			this.bankStreet = bankStreet;
		}

		public String getBic() {
			return bic;
		}

		public void setBic(String bic) {
			this.bic = bic;
		}

		public String getIban() {
			return iban;
		}

		public void setIban(String iban) {
			this.iban = iban;
		}

		public String getOwner() {
			return owner;
		}

		public void setOwner(String owner) {
			this.owner = owner;
		}

		public String getZipCode() {
			return zipCode;
		}

		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
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

	public List<ApplicableTaxes> getApplicableTaxes() {
		return applicableTaxes;
	}

	public void setApplicableTaxes(List<ApplicableTaxes> applicableTaxes) {
		this.applicableTaxes = applicableTaxes;
	}

	public int getApprovalDelay() {
		return approvalDelay;
	}

	public void setApprovalDelay(int approvalDelay) {
		this.approvalDelay = approvalDelay;
	}

	public float getApprovalRate() {
		return approvalRate;
	}

	public void setApprovalRate(float approvalRate) {
		this.approvalRate = approvalRate;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public BillingInfo getBillinginfo() {
		return billinginfo;
	}

	public void setBillinginfo(BillingInfo billinginfo) {
		this.billinginfo = billinginfo;
	}

	public List<String> getChannels() {
		return channels;
	}

	public void setChannels(List<String> channels) {
		this.channels = channels;
	}

	public String getClosedFrom() {
		return closedFrom;
	}

	public void setClosedFrom(String closedFrom) {
		this.closedFrom = closedFrom;
	}

	public String getClosedTo() {
		return closedTo;
	}

	public void setClosedTo(String closedTo) {
		this.closedTo = closedTo;
	}

	public ContactInformations getContactInformations() {
		return contactInformations;
	}

	public void setContactInformations(ContactInformations contactInformations) {
		this.contactInformations = contactInformations;
	}

	public String getCurrencyIsoCode() {
		return currencyIsoCode;
	}

	public void setCurrencyIsoCode(String currencyIsoCode) {
		this.currencyIsoCode = currencyIsoCode;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getDomains() {
		return domains;
	}

	public void setDomains(List<String> domains) {
		this.domains = domains;
	}

	public String getEvaluationsCount() {
		return evaluationsCount;
	}

	public void setEvaluationsCount(String evaluationsCount) {
		this.evaluationsCount = evaluationsCount;
	}

	public String getFreeShipping() {
		return freeShipping;
	}

	public void setFreeShipping(String freeShipping) {
		this.freeShipping = freeShipping;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getIsProfessional() {
		return isProfessional;
	}

	public void setIsProfessional(String isProfessional) {
		this.isProfessional = isProfessional;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getOffersCount() {
		return offersCount;
	}

	public void setOffersCount(String offersCount) {
		this.offersCount = offersCount;
	}

	public String getOrderMessagesSesponseDelay() {
		return orderMessagesSesponseDelay;
	}

	public void setOrderMessagesSesponseDelay(String orderMessagesSesponseDelay) {
		this.orderMessagesSesponseDelay = orderMessagesSesponseDelay;
	}

	public String getOrdersCount() {
		return ordersCount;
	}

	public void setOrdersCount(String ordersCount) {
		this.ordersCount = ordersCount;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public ProDetails getProDetails() {
		return proDetails;
	}

	public void setProDetails(ProDetails proDetails) {
		this.proDetails = proDetails;
	}

	public String getReturnPolicy() {
		return returnPolicy;
	}

	public void setReturnPolicy(String returnPolicy) {
		this.returnPolicy = returnPolicy;
	}

	public String getShippingCountry() {
		return shippingCountry;
	}

	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}

	public List<String> getShippingTypes() {
		return shippingTypes;
	}

	public void setShippingTypes(List<String> shippingTypes) {
		this.shippingTypes = shippingTypes;
	}

	public List<String> getShippingZones() {
		return shippingZones;
	}

	public void setShippingZones(List<String> shippingZones) {
		this.shippingZones = shippingZones;
	}

	public List<Shippings> getShippings() {
		return shippings;
	}

	public void setShippings(List<Shippings> shippings) {
		this.shippings = shippings;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopState() {
		return shopState;
	}

	public void setShopState(String shopState) {
		this.shopState = shopState;
	}

	public String getSuspensionType() {
		return suspensionType;
	}

	public void setSuspensionType(String suspensionType) {
		this.suspensionType = suspensionType;
	}

}
