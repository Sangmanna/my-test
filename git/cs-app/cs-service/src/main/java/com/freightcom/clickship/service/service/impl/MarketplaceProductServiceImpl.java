package com.freightcom.clickship.service.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceProduct;
import com.freightcom.clickship.data.rep.MarketplaceProductRepository;
import com.freightcom.clickship.service.dao.MarketplaceProductDao;
import com.freightcom.clickship.service.service.MarketplaceProductService;

@Service
public class MarketplaceProductServiceImpl implements MarketplaceProductService {

	@Autowired
	private MarketplaceProductDao marketplaceProductDao;
	
	@Autowired
	private MarketplaceProductRepository marketplaceProductRepository;
	
	@Override
	@Transactional
	public MarketplaceProduct save(MarketplaceProduct marketplaceProduct) {
		return marketplaceProductRepository.save(marketplaceProduct);
	}

	@Override
	@Transactional
	public void delete(MarketplaceProduct obj) {
		marketplaceProductRepository.delete(obj);
	}

	@Override
	@Transactional
	public void deleteAll(List<MarketplaceProduct> deleteList) {
		marketplaceProductRepository.deleteAll(deleteList);
	}

	@Override
	public String getDeletedNonVariantProductIdByExternalProductId(String marketplaceId, String externalProductId) {
		return marketplaceProductDao.getDeletedNonVariantProductIdByExternalProductId(marketplaceId, externalProductId);
	}
	
	/**
	 * For non variant product you always have one product exist with external product id  
	 * 
	 */
	@Override
	public MarketplaceProduct getActiveNonVariantProductByExternalProductId(String marketplaceId, String externalProductId) {
		String marketplaceProductId = marketplaceProductDao.checkProductIsActive(marketplaceId, externalProductId);
		
		if(StringUtils.isBlank(marketplaceProductId)) {
			return null;
		}
		
		return marketplaceProductRepository.findById(marketplaceProductId).get();
	}
	
	/**
	 * For non variant product you always have one product exist with external product id str 
	 * 
	 */
	@Override
	public MarketplaceProduct getActiveNonVariantProductByExternalProductIdStr(String marketplaceId, String externalProductStrId) {
		String marketplaceProductId = marketplaceProductDao.checkProductStrIsActive(marketplaceId, externalProductStrId);
		
		if(StringUtils.isBlank(marketplaceProductId)) {
			return null;
		}
		
		return marketplaceProductRepository.findById(marketplaceProductId).get();
	}
	
	/**
	 * 
	 * If variant is available you always get list of products with external product id
	 * 
	 */
	@Override
	public List<MarketplaceProduct> getAllProductsByMarketpalceAndExternalProductId(Marketplace marketplace, Long externalProductId) {
		return marketplaceProductRepository.findAllByMarketplaceAndExternalProductId(marketplace, externalProductId);
	}
	
	/**
	 * 
	 * If variant is available you always get list of products with external product id str
	 * 
	 */
	@Override
	public List<MarketplaceProduct> getAllProductsByMarketplaceAndExternalProductIdStr(Marketplace marketplace, String externalProductIdStr) {
		return marketplaceProductRepository.findAllByMarketplaceAndExternalProductIdStr(marketplace, externalProductIdStr);
	}

	@Override
	public MarketplaceProduct getActiveProductByExternalProductIdStrAndVariantId(Marketplace marketplace, String externalProductId, String variantId) {
		return marketplaceProductRepository.findByMarketplaceAndExternalProductIdStrAndVariantId(marketplace, externalProductId, variantId);
	}

	@Override
	public MarketplaceProduct getActiveProductByExternalProductIdAndVariantId(String marketplaceId, String externalProductId, String variantId) {
		String marketplaceProductId = marketplaceProductDao.checkProductVariantIsActive(marketplaceId, externalProductId, variantId);
		
		if(StringUtils.isBlank(marketplaceProductId)) {
			return null;
		}
		
		return marketplaceProductRepository.findById(marketplaceProductId).get();
	}

	@Override
	@Transactional
	public void restoreProductById(String marketplaceProductId) {
		marketplaceProductDao.restoreProductById(marketplaceProductId);
	}

}
