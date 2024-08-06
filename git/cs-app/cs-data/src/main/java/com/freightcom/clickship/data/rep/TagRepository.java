package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {
	
	public List<Tag> findByCustomer(Customer customer);
	
}
