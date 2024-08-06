package com.freightcom.clickship.service.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceSetting;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.data.rep.MarketplaceRepository;
import com.freightcom.clickship.data.rep.MarketplaceSettingRepository;
import com.freightcom.clickship.model.customer.CustomerAddressDTO;
import com.freightcom.clickship.model.exception.CSInvalidAccessRuntimeException;
import com.freightcom.clickship.model.marketplace.MarketplaceDTO;
import com.freightcom.clickship.model.marketplace.MarketplaceSettingDTO;
import com.freightcom.clickship.service.service.MarketplaceSettingService;
import com.freightcom.clickship.service.service.PalletContingencyService;

@Service
public class MarketplaceSettingServiceImpl implements MarketplaceSettingService {
	
	private Logger logger = LogManager.getLogger(MarketplaceSettingServiceImpl.class);
	
	@Autowired
	private MarketplaceRepository marketplaceRepository;
	
	@Autowired
	private PalletContingencyService palletContingencyService;
	
	@Autowired
	private MarketplaceSettingRepository marketplaceSettingRepository;
	
	@Override
	public MarketplaceSetting getMarketplaceSettingById(String id) {
		Optional<MarketplaceSetting> optional = marketplaceSettingRepository.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}

	@Override
	public MarketplaceSetting getMarketplaceSettingByMarketplaceId(String marketplaceId) {
		Optional<Marketplace> optionalMarketplace = marketplaceRepository.findById(marketplaceId);
		if (optionalMarketplace.isPresent()) {
			return getMarketplaceSettingByMarketplace(optionalMarketplace.get());
		} else {
			return null;
		}
	}

	@Override
	public MarketplaceSetting getMarketplaceSettingByMarketplace(Marketplace marketplace) {
		try {
			MarketplaceSetting marketplaceSetting = marketplaceSettingRepository.findByMarketplace(marketplace);
			if (marketplaceSetting == null) {
				marketplaceSetting = getDefaultMarketplaceSetting(marketplace);
			}
			return marketplaceSetting;
		} catch (Exception e) {
			logger.error("Exception while getting marketplace settings - marketplace:[{}]", marketplace.getStoreUrl(), e);
			throw e;
		}
	}

	@Override
	public MarketplaceSettingDTO getMarketplaceSettingDTOByMarketplaceId(String marketplaceId, User user) {
		MarketplaceSetting setting = getMarketplaceSettingByMarketplaceId(marketplaceId);

		Customer marketplaceCustomer = setting.getMarketplace().getCustomer();

		if (!StringUtils.equalsIgnoreCase(marketplaceCustomer.getId(), user.getCustomer().getId())) {
			throw new CSInvalidAccessRuntimeException();
		}

		return getDTO(setting);
	}

	@Override
	public List<MarketplaceSettingDTO> getMarketplaceSettingByCustomer(Customer customer) {
		try {
			List<Marketplace> list = marketplaceRepository.findByCustomerAndActiveTrue(customer);
			return list.stream().map(m -> getDTO(getMarketplaceSettingByMarketplace(m))).collect(Collectors.toList());
		} catch (Exception e) {
			logger.error("Exception while getting marketplace settings - customer:[{}]", customer.getId(), e);
			throw e;
		}
	}

	private MarketplaceSettingDTO getDTO(MarketplaceSetting setting) {
		Marketplace marketplace = setting.getMarketplace();
		Customer customer = marketplace.getCustomer();

		MarketplaceDTO marketplaceDTO = new MarketplaceDTO().setId(marketplace.getId())
				.setName(marketplace.getAliasName()).setType(marketplace.getMarketplaceType().getName());

		CustomerAddressDTO addressDTO = new CustomerAddressDTO();

		if (marketplace.getDefaultAddress() != null) {
			BeanUtils.copyProperties(marketplace.getDefaultAddress(), addressDTO);
		}

		MarketplaceSettingDTO result = new MarketplaceSettingDTO().setMarketplace(marketplaceDTO)
				.setDefaultShippingFromAddress(addressDTO);
		result.setPalletContingencyRates(palletContingencyService.getByMarketplaceSetting(customer, setting));
		BeanUtils.copyProperties(setting, result);

		result.setLocationSplit(setting.isLocationSplit());
		
		return result;
	}
	
	private MarketplaceSetting getDefaultMarketplaceSetting(Marketplace marketplace) {
		return new MarketplaceSetting(marketplace).setAutoUpdateStatusInMarketplace(true).setAutoSendShippingToCustomer(true).setLocationSplit(false);
	}


}
