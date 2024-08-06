package com.freightcom.clickship.model.box;

import java.io.Serializable;
import java.util.List;

import com.freightcom.clickship.model.CommonDTO;
import com.freightcom.clickship.model.product.MarketplaceProductDTO;

public class SBAFrontEndPlayRequestDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = 7532599650603028218L;

	private List<MarketplaceProductDTO> items;

	public List<MarketplaceProductDTO> getItems() {
		return items;
	}

	public SBAFrontEndPlayRequestDTO setItems(List<MarketplaceProductDTO> items) {
		this.items = items;
		return this;
	}
	
}