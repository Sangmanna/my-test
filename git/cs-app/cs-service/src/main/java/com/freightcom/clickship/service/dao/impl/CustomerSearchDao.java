package com.freightcom.clickship.service.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.model.customer.CustomerRowMapper;
import com.freightcom.clickship.model.customer.SearchCriteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class CustomerSearchDao {

	private Logger logger = LogManager.getLogger(this.getClass());

	private static final String BUSINESS_NAME = "businessName";
	private static final String EQUALS_OPERATOR = "equals";
	private static final String LIKE_OPERATOR = "like";

	@PersistenceContext
	private EntityManager entityManager;

	public List<CustomerRowMapper> search(SearchCriteria searchCriteria) {

		// Create query
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<CustomerRowMapper> cq = cb.createQuery(CustomerRowMapper.class);

		// Define FROM clause
		Root<User> user = cq.from(User.class);
		Join<User, Customer> customer = user.join("customer", JoinType.INNER);

		// Define DTO projection
		cq.select(cb.construct(CustomerRowMapper.class, user.get("username"), user.get("password"),

				customer.get("id"), customer.get(BUSINESS_NAME), customer.get("firstName"), customer.get("lastName"),
				customer.get("email"), customer.get("phone"), customer.get("fcBillingType"),
				customer.get("chargebeeId"), customer.get("chargebeeSubscriptionId"),
				customer.get("registrationSource")));

		// Define WHERE clause
		List<Predicate> predicates = new ArrayList<>();
		if (StringUtils.equalsIgnoreCase(searchCriteria.getKey(), BUSINESS_NAME)) {
			if (StringUtils.equalsIgnoreCase(searchCriteria.getOperator(), LIKE_OPERATOR)) {
				predicates.add(cb.like(customer.get(BUSINESS_NAME), "%" + searchCriteria.getValue() + "%"));
			} else if (StringUtils.equalsIgnoreCase(searchCriteria.getOperator(), EQUALS_OPERATOR)) {
				predicates.add(cb.equal(customer.get(BUSINESS_NAME), searchCriteria.getValue()));
			} else {
				logger.warn("Search operator: [{}] is not supported", searchCriteria.getOperator());
			}
		} else {
			logger.warn("Currently search customer by businessName supported");
		}

		cq.where(predicates.stream().toArray(Predicate[]::new));
		// Execute query
		TypedQuery<CustomerRowMapper> q = entityManager.createQuery(cq);
		return q.getResultList();
	}

}
