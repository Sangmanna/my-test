package com.freightcom.clickship.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.freightcom.clickship.data.entity.SubTier;
import com.freightcom.clickship.data.rep.SubTierRepository;
import com.freightcom.clickship.service.service.SubTierService;

@Service
public class SubTierServiceImpl implements SubTierService {

	@Autowired
	private SubTierRepository subTierRepository;

	@Override
	public SubTier findByName(String name) {
		return subTierRepository.findByName(name);
	}
	
	@Override
	@Cacheable(cacheNames = "global", key = "#root.methodName + '_' + #subTierName")
	public boolean getSubTierLoadOwnRate(String subTierName) {
		SubTier plan = findByName(subTierName);
		return plan.getLoadOwnRate();
	}
	
	@Override
	@Cacheable(cacheNames = "global", key = "#root.methodName")
	public List<SubTier> getAllSubTiers() {
		return subTierRepository.findAll();
	}

}
