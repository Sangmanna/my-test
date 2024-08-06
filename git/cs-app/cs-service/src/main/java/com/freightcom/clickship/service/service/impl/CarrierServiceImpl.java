package com.freightcom.clickship.service.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freightcom.clickship.data.entity.Carrier;
import com.freightcom.clickship.data.rep.CarrierRepository;
import com.freightcom.clickship.service.service.CarrierService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class CarrierServiceImpl implements CarrierService {
	
	@Autowired
	private CarrierRepository carrierRepository;

	@PersistenceContext
	protected EntityManager em;
	
	@Override
	public Carrier getCarrierById(String id) {
		Optional<Carrier> optional = carrierRepository.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}
	
	@Override
	public List<Carrier> getFcCarriers() {
		return carrierRepository.findDistinctCarriers("CS");
	}

	@Override
	public List<Carrier> getOwnCarriers() {
		return carrierRepository.findDistinctCarriers("OC");
	}

	@Override
	public Carrier getCarrierByServiceId(String serviceId) {
		return carrierRepository.findByServiceId(serviceId);
	}
	
	@Override
	public Carrier getFcCarrierByServiceId(String serviceId) {
		return carrierRepository.findByServiceIdAndServiceIdentifier(serviceId, "CS");
	}
	
	@Override
	public Carrier getOwnCarrierByServiceGroupIdAndServiceId(String groupId, String serviceId) {
		return carrierRepository.findByServiceIdAndServiceGroupIdAndServiceIdentifier(serviceId, groupId, "OC");	
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getCarriers() {
		String[] cols = { "short_name", "service", "v2_service_id" };

		Query query = em.createNativeQuery(
				"select " + String.join(",", cols) + " from carrier where service_identifier = 'CS' and is_display_to_customer = 1 and v2_service_id is not null and v2_service_id != '' order by short_name");
		
		return (List) query.getResultList().stream().map(items -> {
			Object[] str = (Object[]) items;
			Map<String, Object> map = new HashMap<>();
			for (int i = 0; i < cols.length; i++) {
				map.put(cols[i], str[i]);
			}
			return map;
		}).collect(Collectors.toList());
	}
	
	@Override
	public List<Carrier> getPalletCarriers() {
		return carrierRepository.findByPalletCarrierTrue();
	}
}
