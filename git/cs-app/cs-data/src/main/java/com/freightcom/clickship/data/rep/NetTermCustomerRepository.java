package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.NetTermCustomer;

@Repository
public interface NetTermCustomerRepository extends JpaRepository<NetTermCustomer, String> {

}
