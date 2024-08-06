package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.AddressBook;
import com.freightcom.clickship.data.entity.Customer;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, String> {

	public List<AddressBook> findAllByCustomer(Customer customer);

	public AddressBook findByIdAndCustomer(String id, Customer customer);

	public List<AddressBook> findAllByCustomer(Customer customer, Pageable pageable);

	@Query("SELECT a FROM AddressBook a WHERE a.contactId LIKE %:contactId% AND a.customer = :customer")
	List<AddressBook> findByContactIdLikeAndCustomer(@Param("contactId") String contactId, @Param("customer") Customer customer);
}
