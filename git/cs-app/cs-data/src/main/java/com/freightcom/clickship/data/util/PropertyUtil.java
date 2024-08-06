package com.freightcom.clickship.data.util;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.stereotype.Component;

import com.freightcom.clickship.model.db.QueryBindingInfo;
import com.freightcom.clickship.model.enums.QUERY_BINDING_TYPE;

@Component
public class PropertyUtil {
	
	@PersistenceContext
	protected EntityManager em;

	private final String getPropertiesQuery = " SELECT name, value FROM properties WHERE name = ? ";

	/**
	 * The method to pull the realtime application configuration in properties table
	 * in DB This will enable us to apply configuration change with service stop.
	 * Developers needs to understand pros/cons of this before use this. performance
	 * vs operation
	 * 
	 * @param name
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String readPropertiesInRealtime(String name) throws Exception {
		Query nativeQuery = em.createNativeQuery(getPropertiesQuery);
		
		List<QueryBindingInfo> bindingValues = new ArrayList<>();
		bindingValues.add(new QueryBindingInfo(name, QUERY_BINDING_TYPE.EQUAL));
		bindValues(bindingValues, nativeQuery);
		
		List<Object[]> props = nativeQuery.getResultList();
		return props.stream().map(objects -> (String) objects[1]).findFirst().get();
	}
	
	public static void bindValues(List<QueryBindingInfo> list, Query nativeQuery) {
		for (int i = 0; i < list.size(); i++) {
			QueryBindingInfo bindingInfo = list.get(i);
			Object value = bindingInfo.getValue();
			nativeQuery.setParameter(i + 1, bindingInfo.isEqualBinding() ? value : "%" + value + "%");
		}
	}
}
