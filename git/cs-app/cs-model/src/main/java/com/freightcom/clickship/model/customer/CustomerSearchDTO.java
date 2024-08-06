package com.freightcom.clickship.model.customer;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.freightcom.clickship.model.marketplace.MarketplaceDTO;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerSearchDTO extends UserDTO implements Serializable {

	private static final long serialVersionUID = -5042181948802582882L;
	
	private UserDTO user;
	private CustomerDTO customer;
	private List<MarketplaceDTO> marketplaces;

	public CustomerDTO getCustomer() {
		return customer;
	}

	public CustomerSearchDTO setCustomer(CustomerDTO customer) {
		this.customer = customer;
		return this;
	}

	public UserDTO getUser() {
		return user;
	}

	public CustomerSearchDTO setUser(UserDTO user) {
		this.user = user;
		return this;
	}

	public List<MarketplaceDTO> getMarketplaces() {
		return marketplaces;
	}

	public CustomerSearchDTO setMarketplaces(List<MarketplaceDTO> marketplaces) {
		this.marketplaces = marketplaces;
		return this;
	}

}
