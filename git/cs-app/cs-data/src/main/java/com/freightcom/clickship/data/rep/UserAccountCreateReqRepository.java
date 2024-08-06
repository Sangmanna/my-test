package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.UserAccountCreateReq;

@Repository
public interface UserAccountCreateReqRepository extends JpaRepository<UserAccountCreateReq, String> {
	
	public List<UserAccountCreateReq> findByCustomer(Customer customer);
	
	public UserAccountCreateReq findByIdAndEmailAndUuid(String id, String email, String uuid);
	
}
