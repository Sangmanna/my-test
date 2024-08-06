package com.freightcom.clickship.service.service;

import java.util.List;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.User;

public interface UserDetailsService {
	
	public List<User> findAll();
	
	public User save(User user);
	
	public void touchLastLogin(User user);
	
	public User findByCustomer(Customer customer);
	
	public List<User> getUserRolesByCustomer(Customer customer);

	public User findByUsernameAndEmail(String userName, String email);

	public List<User> findByUsernameOrEmail(String userName, String email);
	
}