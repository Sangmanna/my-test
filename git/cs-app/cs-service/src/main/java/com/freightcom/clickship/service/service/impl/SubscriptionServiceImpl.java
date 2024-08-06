package com.freightcom.clickship.service.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.chargebee.dto.ChargeBeePlanName;
import com.freightcom.clickship.chargebee.dto.ChargebeeCustomer;
import com.freightcom.clickship.chargebee.dto.ChargebeeInvoice;
import com.freightcom.clickship.chargebee.dto.ChargebeeSubscription;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerSubPlan;
import com.freightcom.clickship.data.entity.SubTier;
import com.freightcom.clickship.data.rep.CustomerRepository;
import com.freightcom.clickship.data.rep.CustomerSubPlanRepository;
import com.freightcom.clickship.data.rep.SubTierRepository;
import com.freightcom.clickship.model.admin.dashboard.csEarnings.CsEarningTableDTO;
import com.freightcom.clickship.model.admin.dashboard.subscription.SubscriptionTableDTO;
import com.freightcom.clickship.service.dao.SubscriptionReportsDao;
import com.freightcom.clickship.service.service.MarketplaceService;
import com.freightcom.clickship.service.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private SubscriptionReportsDao reportsDao;
	
	@Autowired
	private SubTierRepository subTierRepository;
	
	@Autowired
	private MarketplaceService marketplaceService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerSubPlanRepository customerSubPlanRepository;
	
	@Override
	public SubTier findSubscriptionPlanByName(String name) {
		return subTierRepository.findByName(name);
	}
	
	@Override
	@Transactional
	public void saveSubscription(CustomerSubPlan customerSubPlan) {
		customerSubPlanRepository.save(customerSubPlan);
	}
	
	@Override
	public CustomerSubPlan findActivePlanByCustomer(Customer customer) {
		return customerSubPlanRepository.findByCustomerAndStatusIsTrue(customer);
	}
	
	@Override
	public List<SubscriptionTableDTO> getDataforSubscriptionTable(String agentName) {
		return reportsDao.getDataforSubscriptionTable(agentName);
	}

	@Override
	public List<CsEarningTableDTO> getEarningsFromSubscription(String from, String to, String businessName) {
		return reportsDao.getEarningsFromSubscription(from,to, businessName);
	}

	@Override
	public List<SubscriptionTableDTO> getUpgradedSubsriptions(String agentName, String from, String to) {
		return reportsDao.getupgradedSubscription(agentName,from,to);
	}

	@Override
	public List<SubscriptionTableDTO> getDowngradedSubsriptions(String agentName, String from, String to) {
		return reportsDao.getDowngradedSubscription(agentName,from,to);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateSubscriptionPlanInClickship(ChargebeeSubscription subscription) {
		Customer customer = customerRepository.findByChargebeeId(subscription.getCustomerId());
		if (customer != null) {
			updateSubscriptionPlanInClickship(customer, subscription);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateSubscriptionPlanInClickship(Customer customer, ChargebeeSubscription subscription) {
		CustomerSubPlan customerSubPlan = findActivePlanByCustomer(customer);
		
		if (customerSubPlan != null) {
			customerSubPlan.setStatus(false);
			saveSubscription(customerSubPlan);
		}
		
		SubTier subTier = subTierRepository.findByName(subscription.getPlanId());
		
		if (subTier != null) {
			CustomerSubPlan customerNewSubPlan = new CustomerSubPlan().setCustomer(customer).setSubTire(subTier)
					.setShippementsRemain(subTier.getShipmentAllowed()).setUserAccountsRemain(subTier.getNumUsers())
					.setStatus(true).setLoadOwnRate(subTier.getLoadOwnRate());

			// allow only one marketplace for starter plan customer
			if (StringUtils.equals(customer.getSubTier(), ChargeBeePlanName.CLICKSHIP_LITE.getValue())
					&& CollectionUtils.isNotEmpty(marketplaceService.getMarketplacesByCustomerId(customer.getId()))) {
				customerNewSubPlan.setMarketplaceRemain(0);
			} else {
				customerNewSubPlan.setMarketplaceRemain(subTier.getNumMarketplace());
			}
			
			saveSubscription(customerNewSubPlan);
		}
		updateCustomerSubCycleDates(customer, subscription);
	}

	@Override
	public void changeSubscriptionPlan(ChargebeeSubscription subscription) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paymentSuccess(ChargebeeInvoice invoice, String customerId) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void cardAdded(ChargebeeCustomer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cardDeleted(ChargebeeCustomer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paymentFailed(ChargebeeSubscription subscription) {
		// TODO Auto-generated method stub
		
	}
	
	private void updateCustomerSubCycleDates(Customer customer, ChargebeeSubscription subscription) {
		if (customer != null) {
			customer.setSubTierChangeDatetime(subscription.getUpdatedAt())
					.setPrevSubCycleDate(customer.getSubCycleDate())
					.setSubCycleDate(getSubCyleDate(subscription))
					.setNextSubCycleDate(subscription.getNextBillingAt());

			customerRepository.save(customer);
		}
	}

	private Date getSubCyleDate(ChargebeeSubscription subscription) {
		return (StringUtils.equals(subscription.getStatus(), "in_trial")) ? subscription.getTrialStart()
				: subscription.getCurrentTermStart();
	}

	@Override
	public List<List<String>> getAllSubscriptionsWithCounts(String agentName) {
		return reportsDao.getSubscriptionsWithCounts(agentName);
	}

}
