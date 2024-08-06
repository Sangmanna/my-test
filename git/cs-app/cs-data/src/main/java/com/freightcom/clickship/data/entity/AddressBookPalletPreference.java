package com.freightcom.clickship.data.entity;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address_book_pallet_preference")
public class AddressBookPalletPreference extends BaseEntity {

	private static final long serialVersionUID = 2246959739729702666L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_book_id", nullable = false, updatable = false)
	@JsonIgnore
	private AddressBook addressBook;

	@Column(name = "default_instructions")
	private String defaultInstructions;

	@Column(name = "ready_time_24")
	private String readyTime24;

	@Column(name = "close_time_24")
	private String closeTime24;

	@Column(name = "location_type")
	private String locationType;

	public String getId() {
		return id;
	}

	public BaseEntity setId(String id) {
		return this;
	}

	public AddressBook getAddressBook() {
		return addressBook;
	}

	public void setAddressBook(AddressBook addressBook) {
		this.addressBook = addressBook;
	}

	public String getDefaultInstructions() {
		return defaultInstructions;
	}

	public void setDefaultInstructions(String defaultInstructions) {
		this.defaultInstructions = defaultInstructions;
	}

	public String getReadyTime24() {
		return readyTime24;
	}

	public void setReadyTime24(String readyTime24) {
		this.readyTime24 = readyTime24;
	}

	public String getCloseTime24() {
		return closeTime24;
	}

	public void setCloseTime24(String closeTime24) {
		this.closeTime24 = closeTime24;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
}
