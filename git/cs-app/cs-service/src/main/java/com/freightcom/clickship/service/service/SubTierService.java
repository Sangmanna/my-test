package com.freightcom.clickship.service.service;

import java.util.List;

import com.freightcom.clickship.data.entity.SubTier;

public interface SubTierService {

	public List<SubTier> getAllSubTiers();
	
	public SubTier findByName(String subTier);
	
	public boolean getSubTierLoadOwnRate(String subTierName);
	
}
