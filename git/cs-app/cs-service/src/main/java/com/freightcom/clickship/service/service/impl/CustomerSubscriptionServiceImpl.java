package com.freightcom.clickship.service.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freightcom.clickship.chargebee.dto.ChargebeeAddon;
import com.freightcom.clickship.chargebee.dto.ChargebeeSubscription;
import com.freightcom.clickship.chargebee.service.ChargebeeSubscriptionService;
import com.freightcom.clickship.data.entity.CarrierAccount;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerPreferences;
import com.freightcom.clickship.data.entity.CustomerSubPlan;
import com.freightcom.clickship.data.entity.ShopifySubscription;
import com.freightcom.clickship.data.entity.SubTier;
import com.freightcom.clickship.data.rep.CustomerSubPlanRepository;
import com.freightcom.clickship.data.rep.ShopifySubscriptionRepository;
import com.freightcom.clickship.model.enums.ChargebeeAddons;
import com.freightcom.clickship.model.enums.ChargebeePlans;
import com.freightcom.clickship.service.service.CarrierAccountService;
import com.freightcom.clickship.service.service.CustomerDataService;
import com.freightcom.clickship.service.service.CustomerPreferencesService;
import com.freightcom.clickship.service.service.CustomerSubscriptionService;
import com.freightcom.clickship.service.service.SubTierService;

import jakarta.transaction.Transactional;

@Service
public class CustomerSubscriptionServiceImpl implements CustomerSubscriptionService {

	private static final String SUBSCRIPTION_DELETED = "subscription_deleted";

	private SubTierService subTierService;

	private CustomerDataService customerService;

	private CarrierAccountService carrierAccountService;

	private CustomerSubPlanRepository customerSubPlanRepository;
	
	private CustomerPreferencesService customerPreferencesService;
	
	private ChargebeeSubscriptionService chargebeeSubscriptionService;
	
	private ShopifySubscriptionRepository shopifySubscriptionRepository;
	
	@Autowired
	public void setSubTierService(SubTierService subTierService) {
		this.subTierService = subTierService;
	}
	
	@Autowired
	public void setCustomerService(CustomerDataService customerService) {
		this.customerService = customerService;
	}

	@Autowired
	public void setCarrierAccountService(CarrierAccountService carrierAccountService) {
		this.carrierAccountService = carrierAccountService;
	}

	@Autowired
	public void setCustomerSubPlanRepository(CustomerSubPlanRepository customerSubPlanRepository) {
		this.customerSubPlanRepository = customerSubPlanRepository;
	}

	@Autowired
	public void setCustomerPreferencesService(CustomerPreferencesService customerPreferencesService) {
		this.customerPreferencesService = customerPreferencesService;
	}

	@Autowired
	public void setChargebeeSubscriptionService(ChargebeeSubscriptionService chargebeeSubscriptionService) {
		this.chargebeeSubscriptionService = chargebeeSubscriptionService;
	}

	@Autowired
	public void setShopifySubscriptionRepository(ShopifySubscriptionRepository shopifySubscriptionRepository) {
		this.shopifySubscriptionRepository = shopifySubscriptionRepository;
	}

	@Override
	public CustomerSubPlan findCustomerActivePlan(Customer customer) {
		return customerSubPlanRepository.findByCustomerAndStatusIsTrue(customer);
	}

	@Override
	public CustomerSubPlan saveCustomerSubscriptionPlan(CustomerSubPlan plan) {
		return customerSubPlanRepository.save(plan);
	}

	@Override
	@Transactional
	public CustomerSubPlan saveSubtierPlanForCustomer(Customer customer) {
		SubTier subTier = subTierService.findByName(customer.getSubTier());
		
		if (subTier != null) {
			CustomerSubPlan subPlan = new CustomerSubPlan().setCustomer(customer).setSubTire(subTier)
				.setMarketplaceRemain(subTier.getNumMarketplace()).setUserAccountsRemain(subTier.getNumUsers())
				.setShippementsRemain(subTier.getShipmentAllowed()).setLoadOwnRate(subTier.getLoadOwnRate())
				.setStatus(true);

			return saveCustomerSubscriptionPlan(subPlan);
		}
		
		return null;
	}

	@Override
	@Transactional
	public void updateSubscriptionPlanInCs(Customer customer, String eventType, ChargebeeSubscription subscription) {
		// update customer subscription plan table
		updateCustomerAndSubscriptionPlan(customer, eventType, subscription);

		if (!canLoadOwnCarrierRate(customer)) {
			List<CarrierAccount> list = carrierAccountService.getActiveCarrierAccountsByCustomer(customer);

			list.stream().forEach(ca -> {
				ca.setActive(false);
				ca.setOnHold(false);
				ca.setIsSubscribed(false);
				
				carrierAccountService.save(ca);
			});
		}
	}

	@Override
	public boolean canLoadOwnCarrierRate(Customer customer) {
		Map<String, String> map = new HashMap<>();
		map.put("ups-carrier-addon", ChargebeeAddons.UPS_CARRIER_ADDON.name());
		map.put("canpar-carrier-addon", ChargebeeAddons.CANPAR_CARRIER_ADDON.name());
		map.put("midland-carrier-addon", ChargebeeAddons.MIDLAND_CARRIER_ADDON.name());
		map.put("canadapost-carrier-addon", ChargebeeAddons.CANADAPOST_CARRIER_ADDON.name());
		
		CustomerPreferences preferences = customerPreferencesService.getCustomerPreferencesByCustomer(customer);
		
		if (StringUtils.equalsIgnoreCase(preferences.getSubscriptionBillingChannel(), "Shopify")) {
			List<String> values = map.values().stream().collect(Collectors.toList());
			List<ShopifySubscription> list = shopifySubscriptionRepository.findByCustomerAndAddonTypeAndAddonIdInAndStatus(customer, "CLICKSHIP", values, "ACTIVE");
			
			return CollectionUtils.isNotEmpty(list);
		} else if (StringUtils.equalsIgnoreCase(customer.getSubTier(), ChargebeePlans.CLICKSHIP_LITE.getValue())) {
			ChargebeeSubscription chargebeeSubscription = chargebeeSubscriptionService.getSubscription(customer.getChargebeeSubscriptionId());

			List<ChargebeeAddon> list = chargebeeSubscription.getAddons();
			
			if (CollectionUtils.isEmpty(list)) {
				return false;
			}
			
			return list.stream().anyMatch(a -> map.containsKey(a.getId()));
		} else {
			return subTierService.getSubTierLoadOwnRate(customer.getSubTier());
		}
	}
	
	@Override
	public boolean canLoadOwnUpsCarrierRate(Customer customer) {
		return canLoadOwnCarrierRate(customer, ChargebeeAddons.UPS_CARRIER_ADDON, "ups-carrier-addon");
	}

	@Override
	public boolean canLoadOwnCanparCarrierRate(Customer customer) {
		return canLoadOwnCarrierRate(customer, ChargebeeAddons.CANPAR_CARRIER_ADDON, "canpar-carrier-addon");
	}

	@Override
	public boolean canLoadOwnMidlandCarrierRate(Customer customer) {
		return canLoadOwnCarrierRate(customer, ChargebeeAddons.MIDLAND_CARRIER_ADDON, "midland-carrier-addon");
	}

	@Override
	public boolean canLoadOwnCanadaPostCarrierRate(Customer customer) {
		return canLoadOwnCarrierRate(customer, ChargebeeAddons.CANADAPOST_CARRIER_ADDON, "canadapost-carrier-addon");
	}
	
	public boolean canLoadOwnCarrierRate(Customer customer, ChargebeeAddons shopifyAddon, String chargebeeAddon) {
		CustomerPreferences preferences = customerPreferencesService.getCustomerPreferencesByCustomer(customer);

		if (StringUtils.equalsIgnoreCase(preferences.getSubscriptionBillingChannel(), "Shopify")) {
			return getShopifyAddon(customer, shopifyAddon, "ACTIVE") != null;
		} else if (StringUtils.equalsIgnoreCase(customer.getSubTier(), ChargebeePlans.CLICKSHIP_LITE.getValue())) {
			return chargebeeCarrierAddonExist(customer, chargebeeAddon);
		} else {
			return subTierService.getSubTierLoadOwnRate(customer.getSubTier());
		}
	}
	
	private ShopifySubscription getShopifyAddon(Customer customer, ChargebeeAddons addon, String status) {
		return shopifySubscriptionRepository.findByCustomerAndAddonTypeAndAddonIdAndStatus(customer, "CLICKSHIP", addon.name(), status);
	}
	
	private boolean chargebeeCarrierAddonExist(Customer customer, String addon) {
		ChargebeeSubscription chargebeeSubscription = chargebeeSubscriptionService.getSubscription(customer.getChargebeeSubscriptionId());

		List<ChargebeeAddon> list = chargebeeSubscription.getAddons();
		
		if (CollectionUtils.isEmpty(list)) {
			return false;
		}
		
		return list.stream().anyMatch(a -> StringUtils.equalsIgnoreCase(a.getId(), addon));
	}

	private void updateCustomerAndSubscriptionPlan(Customer customer, String eventType, ChargebeeSubscription subscription) {
		CustomerSubPlan subPlan = findCustomerActivePlan(customer);

		if (subPlan != null) {
			subPlan.setStatus(false);
			saveCustomerSubscriptionPlan(subPlan);
		}

		// create new entry with latest plan
		SubTier subTier = subTierService.findByName(subscription.getPlanId());

		if (subTier != null) {
			CustomerSubPlan newPlan = new CustomerSubPlan().setCustomer(customer).setSubTire(subTier)
					.setShippementsRemain(subTier.getShipmentAllowed()).setLoadOwnRate(subTier.getLoadOwnRate())
					.setStatus(true).setMarketplaceRemain(subTier.getNumMarketplace())
					.setUserAccountsRemain(subTier.getNumUsers());

			saveCustomerSubscriptionPlan(newPlan);
			subscription.setLoadOwnRate(subTier.getLoadOwnRate());
		}

		customer.setPrevSubtier(customer.getSubTier());
		customer.setSubTier(subscription.getPlanId());

		customer.setPrevSubCycleDate(customer.getSubCycleDate());
		customer.setSubCycleDate(getSubCyleDate(subscription));

		customer.setNextSubCycleDate(subscription.getNextBillingAt());
		customer.setSubTierChangeDatetime(subscription.getUpdatedAt());

		customer.setSubscriptionStatus(getSubscriptionStatus(eventType, subscription));
		customer.setHasCustomBranding(hasCustomerBranding(subscription));
		customerService.save(customer);
	}

	private Date getSubCyleDate(ChargebeeSubscription s) {
		return StringUtils.equals(s.getStatus(), "in_trial") ? s.getTrialStart() : s.getCurrentTermStart();
	}

	private boolean hasCustomerBranding(ChargebeeSubscription subscription) {
		List<ChargebeeAddon> list = subscription.getAddons();
		return CollectionUtils.isNotEmpty(list) && list.stream()
				.anyMatch(x -> StringUtils.equals(x.getId(), ChargebeeAddons.CUSTOM_BRANDING.toString()));
	}

	private String getSubscriptionStatus(String eventType, ChargebeeSubscription subscription) {
		return StringUtils.equalsIgnoreCase(SUBSCRIPTION_DELETED, eventType) ? "deleted" : subscription.getStatus();
	}

}
