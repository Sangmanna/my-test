package com.freightcom.clickship.service.service;

import java.util.List;

import com.freightcom.clickship.data.entity.Carrier;

public interface CarrierService {
	
	public List<Carrier> getFcCarriers();
	
	public List<Carrier> getOwnCarriers();
	
	public Carrier getCarrierById(String id);
	
	public Carrier getCarrierByServiceId(String serviceId);
	
	public Carrier getFcCarrierByServiceId(String serviceId);
	
	public Carrier getOwnCarrierByServiceGroupIdAndServiceId(String groupId, String serviceId);

	@SuppressWarnings("rawtypes")
	public List getCarriers();
	
	public List<Carrier> getPalletCarriers();
}
