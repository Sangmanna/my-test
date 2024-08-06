package com.freightcom.clickship.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freightcom.clickship.data.entity.MarketplaceType;
import com.freightcom.clickship.data.rep.MarketplaceTypeRepository;
import com.freightcom.clickship.service.service.MarketplaceTypeService;

@Service
public class MarketplaceTypeServiceImpl implements MarketplaceTypeService {
	
	@Autowired
	private MarketplaceTypeRepository repository;
	
	@Override
	public List<MarketplaceType> getAllMarketplaceTypes() {
		return repository.findAllByOrderBySeq();
	}

	@Override
	public MarketplaceType getMarketplaceTypeByName(String name) {
		return  repository.findByName(name);
	}

}
