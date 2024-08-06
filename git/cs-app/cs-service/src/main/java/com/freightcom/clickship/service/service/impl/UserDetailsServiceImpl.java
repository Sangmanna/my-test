	package com.freightcom.clickship.service.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.data.rep.UserRepository;
import com.freightcom.clickship.model.enums.CS_ROLE;
import com.freightcom.clickship.service.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
    public User save(User user) {
		// TEMP logger to debug user role issue.
		logger.info("Saving user");
		
        return userRepository.save(user);
    }
	
	@Override
	public User findByCustomer(Customer customer) {
		return userRepository.findByCustomer(customer.getId());
	}

	@Override
	public List<User> findByUsernameOrEmail(String username, String email) {
		return userRepository.findByUsernameOrEmail(username, email);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void touchLastLogin(User user) {
		user.setLastLogin(Calendar.getInstance().getTime());
		save(user);
	}
	
	@Override
	public User findByUsernameAndEmail(String username, String email) {
		return userRepository.findByUsernameAndEmail(username, email);
	}

	@Override
	public List<User> getUserRolesByCustomer(Customer customer) {
		return userRepository.findByCustomerAndUserRoleIgnoreCase(customer, CS_ROLE.USER.toString());
	}
	
}