package com.freightcom.clickship.service.service.impl;

import static com.freightcom.clickship.model.constants.ClickShipConstants.CS_PALLET_CARRIER;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.Carrier;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerCarrierPreference;
import com.freightcom.clickship.data.rep.CarrierRepository;
import com.freightcom.clickship.data.rep.CustomerCarrierPreferenceRepository;
import com.freightcom.clickship.model.carrier.CustomerCarrierPreferenceDTO;
import com.freightcom.clickship.service.service.CustomerCarrierPreferenceService;

@Service
public class CustomerCarrierPreferenceServiceImpl implements CustomerCarrierPreferenceService {

	@Autowired
	private CarrierRepository carrierRepository;
	
	@Autowired
	private CustomerCarrierPreferenceRepository repository;
	
	@Override
	public List<CustomerCarrierPreference> findCarrierServicesByCustomer(Customer customer) {
		return repository.findByCustomerAndStatusIsTrue(customer);
	}
	
	/**
	 * Retrieves the list of customer carrier preferences based on the provided customer.
	 * The method filters out the carrier services that are not displayable to the customer.
	 * For UI purposes, the carrier services that are not displayable to the customer are not shown.
	 *
	 * @param customer The customer for which to retrieve the carrier preferences.
	 * @return The list of customer carrier preferences.
	 */
	@Override
	public List<CustomerCarrierPreference> findCarrierServicesPreferenceByCustomer(Customer customer) {
		List<CustomerCarrierPreference> all = findCarrierServicesByCustomer(customer);
		
		List<Carrier> carriers = carrierRepository.findCarriers();
		Set<String> nonDisplayCarrierServiceIds = carriers.stream()
			.filter(c -> !c.getIsDisplayToCustomer() && StringUtils.isNotEmpty(c.getV2ServiceId()))
			.map(Carrier::getV2ServiceId)
			.collect(Collectors.toSet());

		return all.stream()
			.filter(cp -> !nonDisplayCarrierServiceIds.contains(cp.getV2ServiceId()))
			.collect(Collectors.toList());
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void savePalletPrefrences(Customer customer) {
		Carrier c = carrierRepository.findByServiceId(CS_PALLET_CARRIER);
		
		CustomerCarrierPreference ccp = repository.findByCustomerAndServiceAndServiceId(customer.getId(), c.getService(), c.getServiceId());
		
		if (ccp == null) {
			ccp = new CustomerCarrierPreference().setCustomer(customer).setStatus(true)
					.setService(c.getService()).setServiceId(c.getServiceId()).setV2ServiceId(c.getV2ServiceId())
					.setServiceGroupId(c.getServiceGroupId()).setShortName(c.getShortName())
					.setShowPickupOption(c.getShowPickupOption()).setPalletCarrier(c.isPalletCarrier());
		} else {
			ccp.setStatus(true);
		}
		
		save(ccp);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveAll(List<CustomerCarrierPreference> list) {
		repository.saveAll(list);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CustomerCarrierPreferenceDTO save(CustomerCarrierPreference customerCarrierPreference) {
		CustomerCarrierPreference preference = repository.save(customerCarrierPreference);
		return getCustomerCarrierPreferenceDTO(preference);
	}

	@Override
	public CustomerCarrierPreference getCustomerCarrierPreferenceByServiceGroupIdAndServiceId(Customer customer, String serviceGroupId, String serviceId) {
		return repository.findByCustomerAndServiceGroupIdAndServiceIdAndStatusIsTrue(customer, serviceGroupId, serviceId);
	}

	@Override
	public CustomerCarrierPreference getCustomerCarrierPreferenceByServiceGroupIdAndServiceId(String customerId, String serviceGroupId, String serviceId) {
		return repository.findByCustomerIdAndServiceGroupIdAndServiceIdAndStatusIsTrue(customerId, serviceGroupId, serviceId);
	}
	
	@Override
	public CustomerCarrierPreferenceDTO getCustomerCarrierPreferenceDTO(CustomerCarrierPreference obj) {
		CustomerCarrierPreferenceDTO dto = new CustomerCarrierPreferenceDTO();

		dto.setId(obj.getId());
		dto.setStatus(obj.getStatus());
		dto.setService(obj.getService());
		dto.setServiceId(obj.getServiceId());
		dto.setShortName(obj.getShortName());
		dto.setServiceGroupId(obj.getServiceGroupId());
		dto.setCarrierAccountNumber(obj.getCarrierAccountNumber());
		dto.setAgreeTerms(Boolean.TRUE.equals(obj.getIsAgreeTerms()));

		return dto;
	}

	@Override
	public List<CustomerCarrierPreference> getActivePackageCarriers(Customer customer) {
		return repository.findByCustomerAndStatusIsTrueAndPalletCarrierIsFalse(customer);
	}

	@Override
	public List<CustomerCarrierPreference> getActivePalletCarriers(Customer customer) {
		return repository.findByCustomerAndStatusIsTrueAndPalletCarrierIsTrue(customer);
	}

}
