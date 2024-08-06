package com.freightcom.clickship.service.dao.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.model.product.ProductUpdateDTO;
import com.freightcom.clickship.service.dao.MarketplaceProductDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class MarketplaceProductDaoImpl implements MarketplaceProductDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void restoreProductById(String marketplaceProductId) {
		String query = "UPDATE marketplace_product mp SET mp.delete_flag = 0 WHERE mp.id= ? ";
		
		Query nativeQuery = em.createNativeQuery(query);
		nativeQuery.setParameter(1, marketplaceProductId);
		
		nativeQuery.executeUpdate();
	}

	@Override
	public String checkProductIsActive(String marketplaceId, String externalProductId) {
		String query = "SELECT mp.id FROM marketplace_product mp " + 
				" WHERE mp.delete_flag=0 AND mp.marketplace_id = ? " +
				" AND mp.external_product_id= ? ";
		
		try {
			Query nativeQuery = em.createNativeQuery(query);
			nativeQuery.setParameter(1, marketplaceId);
			nativeQuery.setParameter(2, externalProductId);
			
			return (String) nativeQuery.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
	
	@Override
	public String checkProductStrIsActive(String marketplaceId, String externalProductIdStr) {
		String query = "SELECT mp.id FROM marketplace_product mp " + 
				" WHERE mp.delete_flag=0 AND mp.marketplace_id = ? " +
				" AND mp.external_product_id_str= ? ";
		
		try {
			Query nativeQuery = em.createNativeQuery(query);
			
			nativeQuery.setParameter(1, marketplaceId);
			nativeQuery.setParameter(2, externalProductIdStr);
			
			return (String) nativeQuery.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
	
	@Override
	public String checkProductVariantIsActive(String marketplaceId, String externalProductId, String variantId) {
		String query = "SELECT mp.id FROM marketplace_product mp " + 
				" WHERE mp.delete_flag=0 AND mp.marketplace_id = ? " +
				" AND mp.external_product_id= ? " +
				" AND mp.variant_id = ? ";
		
		try {
			Query nativeQuery = em.createNativeQuery(query);
			
			nativeQuery.setParameter(1, marketplaceId);
			nativeQuery.setParameter(2, externalProductId);
			nativeQuery.setParameter(3, variantId);
			
			return (String) nativeQuery.getSingleResult();
			
		} catch(NoResultException e) {
			return null;
		}
	}

	@Override
	public String getDeletedNonVariantProductIdByExternalProductId(String marketplaceId, String externalProductId) {
		String query = " SELECT mp.id FROM marketplace_product mp"
				+ " WHERE mp.delete_flag=1 AND mp.external_product_id= ? "
				+ " AND mp.marketplace_id = ? ";
		
		try {
			Query nativeQuery = em.createNativeQuery(query);
			
			nativeQuery.setParameter(1, externalProductId);
			nativeQuery.setParameter(2, marketplaceId);
			
			return (String) nativeQuery.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProductUpdateDTO> getMarketplaceProducts(String customerId, String marketplaceId) {
		 String query = " SELECT mp.id, "
				+ " IFNULL(mp.external_product_id, 0),"
				+ " mp.external_product_id_str, mp.title,"
				+ " IFNULL(mp.length, 0) AS length,"
				+ " IFNULL(mp.width, 0) AS width,"
				+ " IFNULL(mp.height, 0) AS height,"
				+ " IFNULL(mp.weight, 0) AS weight," 
				+ " IFNULL(mp.length_metric, 0) AS length_metric,"
				+ " IFNULL(mp.width_metric, 0) AS width_metric,"
				+ " IFNULL(mp.height_metric, 0) AS height_metric, "
				+ " IFNULL(mp.weight_metric, 0) AS weight_metric, "
				+ " IFNULL(ms.unit_of_measure, 'Imperial') AS unit_of_measure,"
				+ " mp.custom_box, "
				+ " IFNULL(mp.variant_id, '') AS variant_id,"
				+ " IFNULL(mp.sku,'') AS sku, "
				+ " IFNULL(mp.hs_code,'') AS hsCode, "
				+ " IFNULL(mp.custom_description,'') AS customDescription, "
				+ " IFNULL(mp.origin,'') AS countryOfOrigin, "
				+ " mp.stackable AS stackable,"
				+ " mp.can_rotate AS canRotate,"
				+ " mp.is_multi_box AS multiBox,"
				+ " mp.multi_box_quantity AS multiBoxQuantity"
				+ " FROM marketplace_product mp"
				+ " LEFT JOIN marketplace mps ON mps.id = mp.marketplace_id AND mps.integration_success = 1 AND mps.active = 1 AND mps.is_deleted = 0"
				+ " LEFT JOIN marketplace_setting ms ON ms.marketplace_id = mps.id"
				+ " WHERE mp.delete_flag = 0 AND mp.is_hidden = 0 AND mp.customer_id = :customerId AND mp.marketplace_id = :marketplaceId";

		
		Query nativeQuery = em.createNativeQuery(query);

		nativeQuery.setParameter("customerId", customerId);
		nativeQuery.setParameter("marketplaceId", marketplaceId);

		List<Object[]> list = (List<Object[]>) nativeQuery.getResultList();

		return list.stream().map(o -> {
			Object[] results = (Object[])o;
			
			ProductUpdateDTO dto =  new ProductUpdateDTO();
			dto.setId(getString(results[0]));
			dto.setExternalProductId((BigInteger)results[1]);
			dto.setExternalProductIdStr(getString(results[2]));
			dto.setTitle(getString(results[3]));
			dto.setLength(getDouble(results[4]));
			dto.setWidth(getDouble(results[5]));
			dto.setHeight(getDouble(results[6]));
			dto.setWeight(getDouble(results[7]));
			dto.setLengthMetric(getDouble(results[8]));
			dto.setWidthMetric(getDouble(results[9]));
			dto.setHeightMetric(getDouble(results[10]));
			dto.setWeightMetric(getDouble(results[11]));
			dto.setUnitOfMeasure(getString(results[12]));
			dto.setCustomBox((boolean) (results[13]));
			dto.setVariantId(getString(results[14]));
			dto.setSku(getString(results[15]));
			dto.setHsCode(getString(results[16]));
			dto.setCustomDescription(getString(results[17]));
			dto.setCountryOfOrigin(getString(results[18]));
			dto.setStackable((boolean) results[19]);
			dto.setCanRotate((boolean) results[20]);
			dto.setMultiBox((boolean) results[21]);
			dto.setMultiBoxQuantity(getInteger(results[22]));
			
			return dto;
		}).collect(Collectors.toList());
	}
	
	private String getString(Object value) {
		return value != null ? (String) value : "";
	}
	
	private double getDouble(Object value) {
		return value != null ? (Double) value : 0.0;
	}
	
	private int getInteger(Object value) {
		return value != null ? (Integer) value : 0;
	}

}
