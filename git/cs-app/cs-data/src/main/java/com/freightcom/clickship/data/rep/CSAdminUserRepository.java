package com.freightcom.clickship.data.rep;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.AdminUser;

@Repository
public class CSAdminUserRepository {	
	
	@PersistenceContext
	private EntityManager em;
	
	private String getUserByUserName = "SELECT username,password,user_role,agent_name,email "
			+ "FROM cs_admin.user where username=:username";
	private String getAPITokenUrl = "SELECT api_token FROM cs_admin.clickship_access_log where validation_token=:validationtoken";
	
	
	public AdminUser findByUsername(String username) {
		Query query = em.createNativeQuery(getUserByUserName);
		query.setParameter("username", username);
		Object[] object = (Object[]) query.getSingleResult();
		return new AdminUser(object);
	}
	
	public String getAPIToken(String validationToken) {
		Query query = em.createNativeQuery(getAPITokenUrl);
		query.setParameter("validationtoken", validationToken);
		return (String) query.getSingleResult();
	}
	
}
