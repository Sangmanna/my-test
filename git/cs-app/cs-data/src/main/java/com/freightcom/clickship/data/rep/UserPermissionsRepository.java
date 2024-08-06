package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.data.entity.UserPermissions;
import com.freightcom.clickship.data.entity.projection.UserPermissionProjection;

@Repository
public interface UserPermissionsRepository extends JpaRepository<UserPermissions, String> {
	
	public List<UserPermissions> findByUser(User user);
	
	@Transactional
	public void deleteByCustomerAndUser(Customer customer, User user);
	
	@Transactional
	public void deleteByCustomerAndUserAndPermissionType(Customer customer, User user, String permissionType);
	
	@Transactional
	public void deleteByCustomerAndUserAndPermissionValue(Customer customer, User user, String permissionValue);
	
	public UserPermissions findByCustomerAndUserAndPermissionValue(Customer customer, User user, String permissionValue);
	
	public List<UserPermissions> findByCustomerAndUserAndPermissionType(Customer customer, User user, String permissionType);
	
	@Query(UserPermissionProjection.SELECT
			+ " FROM UserPermissions up"
			+ " RIGHT JOIN Permissions pp ON pp.id = up.permission.id AND up.user.username=:username AND up.customer.id = :customerId")
	public List<UserPermissionProjection> getPermissionsByType(String customerId, String username);
	
}
