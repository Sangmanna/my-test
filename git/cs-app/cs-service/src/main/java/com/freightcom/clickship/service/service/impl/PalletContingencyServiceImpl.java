package com.freightcom.clickship.service.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.Box;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.MarketplaceSetting;
import com.freightcom.clickship.data.entity.PalletContingencyRates;
import com.freightcom.clickship.data.rep.BoxRepository;
import com.freightcom.clickship.data.rep.PalletContingencyRatesRepository;
import com.freightcom.clickship.model.constants.ClickShipConstants;
import com.freightcom.clickship.model.enums.PackageType;
import com.freightcom.clickship.model.exception.BoxNotFoundException;
import com.freightcom.clickship.model.rates.PalletContingencyRatesDTO;
import com.freightcom.clickship.service.service.PalletContingencyService;

@Service
public class PalletContingencyServiceImpl implements PalletContingencyService {
	
	@Autowired
	private BoxRepository boxRepository; 
	
	@Autowired
	private PalletContingencyRatesRepository palletContingencyRatesRepository;
	
	@Override
	@Transactional
	public void savePalletContingencyRates(List<PalletContingencyRatesDTO> list) {
		palletContingencyRatesRepository.saveAll(list.stream().map(p -> {
			PalletContingencyRates rate = palletContingencyRatesRepository.findById(p.getId()).get();
			rate.setRate(p.getRate());
			rate.setCurrency(p.getCurrency());
			return rate;
		}).collect(Collectors.toList()));
	}

	@Override
	@Transactional
	public List<PalletContingencyRatesDTO> getByMarketplaceSetting(Customer customer, MarketplaceSetting setting) {
		if (!setting.isPalletRatesCheckout()) {
			return Collections.emptyList();
		}
			
		List<PalletContingencyRates> rates = palletContingencyRatesRepository.findAllByMarketplaceSetting(setting);
		
		// Since we don't enable the PALLET rates by default for every customer while saving new PALLET we are not saving default
		// PALLET contingency rate. So we should save default PALLET contingency rate for missing PALLETS before we provide the list.  
		List<Box> pallets = getBoxesByCustomer(customer, PackageType.PALLET.getValue());
		
		rates.addAll(pallets.stream().filter(b -> palletContingencyRatesRepository.findByMarketplaceSettingAndBox(setting, b) == null).map(b ->
			palletContingencyRatesRepository.save(new PalletContingencyRates(b, setting.getMarketplace(), setting))
		).collect(Collectors.toList()));
		
		return CollectionUtils.isNotEmpty(rates) ? rates.stream().map(this::getPalletContingencyRateDTO).collect(Collectors.toList()) : Collections.emptyList();
	}
	
	@Override
	public PalletContingencyRatesDTO getByMarketplaceSettingAndBox(MarketplaceSetting setting, String boxId) {
		Box box = getBox(boxId);
		return getPalletContingencyRateDTO(palletContingencyRatesRepository.findByMarketplaceSettingAndBox(setting, box));
	}

    private PalletContingencyRatesDTO getPalletContingencyRateDTO(PalletContingencyRates obj) {
    	Box box = getBox(obj.getBox().getId());
    	
    	PalletContingencyRatesDTO dto = new PalletContingencyRatesDTO();
    	
    	dto.setId(obj.getId());
    	dto.setRate(obj.getRate());
    	dto.setName(getBoxName(box));
    	dto.setCurrency(obj.getCurrency());
    	
        return dto;
    }
    
    private String getBoxName(Box box) {
    	String format = "%s - %s * %s * %s(%s)";
    	
    	if (ClickShipConstants.UNIT_METRIC.equals(box.getUnitOfMeasure())) {
    		return String.format(format, box.getName(), box.getLengthMetric(), box.getWidthMetric(), box.getHeightMetric(), "cm");	
    	} else {
    		return String.format(format, box.getName(), box.getLengthImperial(), box.getWidthImperial(), box.getHeightImperial(), "inch");
    	}
    }
    
    private Box getBox(String boxId) {
		Optional<Box> optionalBox = boxRepository.findById(boxId);

		if (!optionalBox.isPresent()) {
			throw new BoxNotFoundException("Invalid box id provided");
		}

		Box box = optionalBox.get();
		setDimentionsAndWeight(box);
		return box;
	}
    
	private List<Box> getBoxesByCustomer(Customer customer, String packageType) {
		List<Box> list = boxRepository.findAllByCustomerAndPackageType(customer, packageType);
		list.forEach(this::setDimentionsAndWeight);
		
		return list;
	}
	
	private void setDimentionsAndWeight(Box box) {
		setDimensionsAndWeight(box, Arrays.asList(box::setWidth, box::setLength, box::setHeight, box::setWeight, box::setMaxWeight));
	}
	
	private void setDimensionsAndWeight(Box box, List<Consumer<Double>> cons) {
		if (ClickShipConstants.UNIT_IMPERIAL.equals(box.getUnitOfMeasure())) {
			cons.get(0).accept(box.getWidthImperial());
			cons.get(1).accept(box.getLengthImperial());
			cons.get(2).accept(box.getHeightImperial());
			cons.get(3).accept(box.getEmptyWeightImperial());
			cons.get(4).accept(box.getMaxWeightImperial());
		} else {
			cons.get(0).accept(box.getWidthMetric());
			cons.get(1).accept(box.getLengthMetric());
			cons.get(2).accept(box.getHeightMetric());
			cons.get(3).accept(box.getEmptyWeightMetric());
			cons.get(4).accept(box.getMaxWeightMetric());
		}
	}

}
