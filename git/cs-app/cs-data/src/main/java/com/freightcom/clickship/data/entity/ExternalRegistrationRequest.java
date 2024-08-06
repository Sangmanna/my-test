package com.freightcom.clickship.data.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "external_registration_request")
public class ExternalRegistrationRequest extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -69640518210320812L;

	@Id
    @GeneratedValue(generator = "customIdGenerator")
    @GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "email")
    private String email;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "registration_source")
    private String registrationSource;

    @Column(name = "partner_id")
    private String partnerId;

    @Column(name = "activation_id")
    private String activationId;

    @Column(name = "is_consent_given")
    private Boolean isConsentGiven = false;

    @Column(name = "is_cs_to_vendasta_transformed_user")
    private Boolean isCSToVendastaTransformedUser = false;

    @Column(name = "error_message")
    private String errorMessage;

    public String getId() {
        return id;
    }

    public ExternalRegistrationRequest setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ExternalRegistrationRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ExternalRegistrationRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getBusinessName() {
        return businessName;
    }

    public ExternalRegistrationRequest setBusinessName(String businessName) {
        this.businessName = businessName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ExternalRegistrationRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getExternalId() {
        return externalId;
    }

    public ExternalRegistrationRequest setExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public String getRegistrationSource() {
        return registrationSource;
    }

    public ExternalRegistrationRequest setRegistrationSource(String registrationSource) {
        this.registrationSource = registrationSource;
        return this;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public ExternalRegistrationRequest setPartnerId(String partnerId) {
        this.partnerId = partnerId;
        return this;
    }

    public String getActivationId() { return activationId; }

    public ExternalRegistrationRequest setActivationId(String activationId) {
        this.activationId = activationId;
        return this;
    }

    public String getErrorMessage() { return errorMessage; }

    public ExternalRegistrationRequest setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public Boolean isConsentGiven() {
        return isConsentGiven;
    }

    public ExternalRegistrationRequest setConsentGiven(Boolean consentGiven) {
        isConsentGiven = consentGiven;
        return this;
    }

    public Boolean isCSToVendastaTransformedUser() {
        return isCSToVendastaTransformedUser;
    }

    public ExternalRegistrationRequest setCSToVendastaTransformedUser(Boolean CSToVendastaTransformedUser) {
        isCSToVendastaTransformedUser = CSToVendastaTransformedUser;
        return this;
    }
}
