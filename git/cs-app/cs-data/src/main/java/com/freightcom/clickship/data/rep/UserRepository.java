package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.model.customer.UpdateUserDTO;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	public User findByUsername(String username);
	
	@Query("Select c from User c where trim(c.username) = trim(:username)")
	public User findByUsernameTrim(String username);

	@Query("Select u from User u where u.customer.id =:customerId AND u.userRole='CUSTOMER'")
	public User findByCustomer(String customerId);

	@Query("Select c from User c where trim(lower(c.email)) like %:email%")
	public User findByEmailLike(String email);
	
	@Query(value = "SELECT * FROM user WHERE trim(username) = trim(:username) AND deleted = 1", nativeQuery = true)
	public User findDeletedUserByUsernameTrim(String username);
	
	public User findByUsernameAndEmail(String username, String email);
	
	@Query(value = "SELECT * FROM user WHERE trim(username) = trim(:username) OR trim(lower(email)) = trim(:email)", nativeQuery = true)
	public List<User> findByUsernameOrEmail(String username, String email);

	public List<User> findByCustomerAndUserRoleIgnoreCase(Customer customer, String userRole);
	
	@Query("SELECT new com.freightcom.clickship.model.customer.UpdateUserDTO(u.username, u.username, u.email, u.firstName, u.lastName, u.userRole, false, cp.fcApiPreference) " +
			"FROM User u, CustomerPreferences cp WHERE u.customer.id = :customerId and cp.customer.id = :customerId ")
    List<UpdateUserDTO> findUpdateUserDTOsByCustomerId(String customerId);
	
	public List<User> findByCustomer(Customer customer);
}