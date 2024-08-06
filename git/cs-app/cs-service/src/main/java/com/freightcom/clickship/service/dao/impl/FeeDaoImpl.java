package com.freightcom.clickship.service.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.freightcom.clickship.model.admin.dashboard.csEarnings.CsEarningTableDTO;
import com.freightcom.clickship.service.dao.FeeDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class FeeDaoImpl implements FeeDao {
	
	@PersistenceContext
	private EntityManager em;

	private String feeTableQuery = "SELECT c.business_name as bname,  f.fee_type_name AS categ,  ROUND(f.fee_total,2) AS charge, ROUND(sum(f.fee_total),2)  FROM fee f "
			+ "LEFT JOIN customer c ON f.customer_id = c.id WHERE f.created_datetime BETWEEN :from AND :to  AND c.business_name  LIKE :customer "
			+ "GROUP BY c.id,categ ORDER BY bname";

	@SuppressWarnings("unchecked")
	@Override
	public List<CsEarningTableDTO> getEarningsTableData(String from, String to, String businessName) {
		Query query = em.createNativeQuery(feeTableQuery);
		query.setParameter("from", from);
		query.setParameter("to", to);
		query.setParameter("customer", "%"+businessName);
		List<Object[]> list = (List<Object[]>) query.getResultList();
		return list.stream().map(o -> {
			return new CsEarningTableDTO(o);
		}).collect(Collectors.toList());

	}

}
