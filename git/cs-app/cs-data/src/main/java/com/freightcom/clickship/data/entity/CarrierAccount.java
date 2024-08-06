package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;
import com.freightcom.clickship.data.entity.common.CustomerIdAssociateEntity;

@Entity
@Table(name = "carrier_account")
public class CarrierAccount extends BaseEntity implements CustomerIdAssociateEntity {
	
	private static final long serialVersionUID = -9218885151952660579L;

	@Id
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class )
	@GeneratedValue(generator = "customIdGenerator")
	@Column(name = "id", nullable = false, updatable = false)	
	private String id;

	@Column(name = "customer_id", nullable = false)
	private String customerId;
	
	@Column(name = "carrier_account_number")
	private String carrierAccountNumber;

	@Column(name = "carrier_contract_id")
	private String carrierContractId;
	
	@Column(name = "carrier_nickname")
	private String carrierNickname;

	@Column(name = "carrier_name")
	private String carrierName;

	@Column(name = "carrier_code")
	private String carrierCode;
	
	@Column(name = "carrier_token")
	private String carrierToken;

	@Column(name = "carrier_key")
	private String carrierKey;

	@Column(name = "carrier_username")
	private String carrierUsername;

	@Column(name = "carrier_password")
	private String carrierPassword;

	@Column(name = "contact_first_name")
	private String contactFirstName;

	@Column(name = "contact_last_name")
	private String contactLastName;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "address1")
	private String address1;

	@Column(name = "address2")
	private String address2;

	@Column(name = "city")
	private String city;

	@Column(name = "province_state")
	private String provinceState;

	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "country")
	private String country;

	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "method_of_payment")
	private String methodOfPayment = "Account";
	
	@Column(name = "active")
	private Boolean active = false;
	
	@Column(name = "negotiated_rates")
	private Boolean negotiatedRates = false;

	@Column(name = "transmit_shipments")
	private Boolean transmitShipments = false;

	@Column(name = "full_size_labels")
	private Boolean fullSizeLabels = false;
	
	@Column(name = "auto_request_return_labels")
	private Boolean autoRequestReturnLabels = false;
	
	@Transient
	private String image = "";
	
	@Column(name = "paperless_customs_invoice")
	private Boolean paperlessCustomsInvoice = false;
	
	@Column(name = "is_subscribed")
	private Boolean isSubscribed = false;
	
	@Column(name = "on_hold")
	private Boolean onHold = false;
	
	@Column(name = "on_hold_messasge")
	private String onHoldMessage;

	@Override
	public String getId() {		
		return id;
	}

	@Override
	public CarrierAccount setId(String id) {
		this.id = id;
		return this;
	}

	@Override
	public String getCustomerId() {		
		return customerId;
	}

	public CarrierAccount setCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}
	
	public String getCarrierAccountNumber() {
		return carrierAccountNumber;
	} 
	
	public CarrierAccount setCarrierAccountNumber(String carrierAccountNumber) {
		this.carrierAccountNumber = carrierAccountNumber;
		return this;
	} 

	public String getCarrierContractId() {
		return carrierContractId;
	} 
	
	public CarrierAccount setCarrierContractId(String carrierContractId) {
		this.carrierContractId = carrierContractId;
		return this;
	} 
	
	public String getCarrierNickname() {
		return carrierNickname;
	} 

	public CarrierAccount setCarrierNickname(String carrierNickname) {
		this.carrierNickname = carrierNickname;
		return this;
	} 

	public String getCarrierName() {
		return carrierName;
	} 

	public CarrierAccount setCarrierName(String carrierName) {
		this.carrierName = carrierName;
		return this;
	} 

	public String getCarrierCode() {
		return carrierCode;
	} 

	public CarrierAccount setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
		return this;
	} 

	public String getCarrierToken() {
		return carrierToken;
	} 

	public CarrierAccount setCarrierToken(String carrierToken) {
		this.carrierToken = carrierToken;
		return this;
	} 

	public String getCarrierKey() {
		return carrierKey;
	} 

	public CarrierAccount setCarrierKey(String carrierKey) {
		this.carrierKey = carrierKey;
		return this;
	} 

	public String getCarrierUsername() {
		return carrierUsername;
	} 

	public CarrierAccount setCarrierUsername(String carrierUsername) {
		this.carrierUsername = carrierUsername;
		return this;
	} 

	public String getCarrierPassword() {
		return carrierPassword;
	} 

	public CarrierAccount setCarrierPassword(String carrierPassword) {
		this.carrierPassword = carrierPassword;
		return this;
	} 

	public String getContactFirstName() {
		return contactFirstName;
	} 

	public CarrierAccount setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
		return this;
	} 

	public String getContactLastName() {
		return contactLastName;
	} 

	public CarrierAccount setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
		return this;
	} 
	
	public String getCompanyName() {
		return companyName;
	} 

	public CarrierAccount setCompanyName(String companyName) {
		this.companyName = companyName;
		return this;
	} 
	
	public String getAddress1() {
		return address1;
	} 

	public CarrierAccount setAddress1(String address1) {
		this.address1 = address1;
		return this;
	} 
	

	public String getAddress2() {
		return address2;
	} 

	public CarrierAccount setAddress2(String address2) {
		this.address2 = address2;
		return this;
	} 
	

	public String getCity() {
		return city;
	} 

	public CarrierAccount setCity(String city) {
		this.city = city;
		return this;
	} 
	

	public String getProvinceState() {
		return provinceState;
	} 

	public CarrierAccount setProvinceState(String provinceState) {
		this.provinceState = provinceState;
		return this;
	} 
	

	public String getPostalcode() {
		return postalCode;
	} 

	public CarrierAccount setPostalcode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	} 
	

	public String getCountry() {
		return country;
	} 

	public CarrierAccount setCountry(String country) {
		this.country = country;
		return this;
	} 
	

	public String getPhone() {
		return phone;
	} 

	public CarrierAccount setPhone(String phone) {
		this.phone = phone;
		return this;
	} 
	

	public String getEmail() {
		return email;
	} 

	public CarrierAccount setEmail(String email) {
		this.email = email;
		return this;
	} 

	public Boolean getActive() {
		return active;
	} 

	public CarrierAccount setActive(Boolean active) {
		this.active = active != null && active;
		return this;
	} 

	public Boolean getNegotiatedRates() {
		return negotiatedRates;
	}

	public CarrierAccount setNegotiatedRates(Boolean negotiatedRates) {
		this.negotiatedRates = negotiatedRates != null && negotiatedRates;
		return this;
	}

	public String getImage() {
		return image;
	}

	public CarrierAccount setImage(String image) {
		this.image = image;
		return this;
	}

	public Boolean getTransmitShipments() {
		if(this.transmitShipments == null) {
			this.transmitShipments = false;
		}
		return transmitShipments;
	}

	public CarrierAccount setTransmitShipments(Boolean transmitShipments) {
		this.transmitShipments = transmitShipments != null && transmitShipments;
		return this;
	}
	
	public Boolean getFullSizeLabels() {
		if(this.fullSizeLabels == null) {
			this.fullSizeLabels = false;
		}
		return fullSizeLabels;
	}

	public CarrierAccount setFullSizeLabel(Boolean fullSizeLabels) {
		this.fullSizeLabels = fullSizeLabels != null && fullSizeLabels;
		return this;
	}	

	public Boolean getAutoRequestReturnLabels() {
		if(this.autoRequestReturnLabels == null) {
			this.autoRequestReturnLabels = false;
		}
		return autoRequestReturnLabels;
	}

	public CarrierAccount setAutoRequestReturnLabels(Boolean autoRequestReturnLabels) {
		this.autoRequestReturnLabels = autoRequestReturnLabels != null && autoRequestReturnLabels;
		return this;
	}

	public String getMethodOfPayment() {
		return methodOfPayment;
	}

	public CarrierAccount setMethodOfPayment(String methodOfPayment) {
		this.methodOfPayment = methodOfPayment;
		return this;
	}
	
	public Boolean getPaperlessCustomsInvoice() {
		if(this.paperlessCustomsInvoice == null) {
			this.paperlessCustomsInvoice = false;
		}
		return paperlessCustomsInvoice;
	}

	public CarrierAccount setPaperlessCustomsInvoice(Boolean paperlessCustomsInvoice) {
		this.paperlessCustomsInvoice = paperlessCustomsInvoice != null && paperlessCustomsInvoice;
		return this;
	}

	public Boolean getIsSubscribed() {
		return isSubscribed;
	}

	public CarrierAccount setIsSubscribed(Boolean isSubscribed) {
		this.isSubscribed = isSubscribed;
		return this;
	}

	public Boolean getOnHold() {
		return onHold;
	}

	public CarrierAccount setOnHold(Boolean onHold) {
		this.onHold = onHold != null && onHold;
		return this;
	}

	public String getOnHoldMessage() {
		return onHoldMessage;
	}

	public CarrierAccount setOnHoldMessage(String onHoldMessage) {
		this.onHoldMessage = onHoldMessage;
		return this;
	}
	
}
