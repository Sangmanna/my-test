package com.freightcom.clickship.model.customer.userrole;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.freightcom.clickship.model.CommonDTO;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRolesDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = 3017993517569686588L;
	
	private String id;

	private String email;

	private String phone;

	private String userRole;

	private String lastName;

	private String firstName;

	private String username;

	private String password;

	private String businessName;

	private String status;

	private String userType;
	
	private Integer usersCount = 0;
	
	private boolean showPaidUsersBanner;

	private transient Map<String, Object> orderPermissions = new HashMap<>();

	private transient Map<String, Object> boxesPermissions = new HashMap<>();

	private transient Map<String, Object> invoicePermissions = new HashMap<>();

	private transient Map<String, Object> productPermissions = new HashMap<>();

	private transient Map<String, Object> settingsPermissions = new HashMap<>();

	private transient Map<String, Object> marketplacePermissions = new HashMap<>();

	public UserRolesDTO() {
		super();
	}
	
	public UserRolesDTO(String userRole) {
		super();

		this.userRole = userRole;
		this.email = StringUtils.EMPTY;
		this.phone = StringUtils.EMPTY;		
		this.lastName = StringUtils.EMPTY;
		this.firstName = StringUtils.EMPTY;
	}

	public String getId() {
		return id;
	}

	public UserRolesDTO setId(String id) {
		this.id = id;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UserRolesDTO setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public UserRolesDTO setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getUserRole() {
		return userRole;
	}

	public UserRolesDTO setUserRole(String userRole) {
		this.userRole = userRole;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public UserRolesDTO setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public UserRolesDTO setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public UserRolesDTO setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public UserRolesDTO setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getBusinessName() {
		return businessName;
	}

	public UserRolesDTO setBusinessName(String businessName) {
		this.businessName = businessName;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public UserRolesDTO setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getUserType() {
		return userType;
	}

	public UserRolesDTO setUserType(String userType) {
		this.userType = userType;
		return this;
	}

	public Map<String, Object> getOrderPermissions() {
		return orderPermissions;
	}

	public UserRolesDTO setOrderPermissions(Map<String, Object> orderPermissions) {
		this.orderPermissions = orderPermissions;
		return this;
	}

	public Map<String, Object> getBoxesPermissions() {
		return boxesPermissions;
	}

	public UserRolesDTO setBoxesPermissions(Map<String, Object> boxesPermissions) {
		this.boxesPermissions = boxesPermissions;
		return this;
	}

	public Map<String, Object> getInvoicePermissions() {
		return invoicePermissions;
	}

	public UserRolesDTO setInvoicePermissions(Map<String, Object> invoicePermissions) {
		this.invoicePermissions = invoicePermissions;
		return this;
	}

	public Map<String, Object> getProductPermissions() {
		return productPermissions;
	}

	public UserRolesDTO setProductPermissions(Map<String, Object> productPermissions) {
		this.productPermissions = productPermissions;
		return this;
	}

	public Map<String, Object> getSettingsPermissions() {
		return settingsPermissions;
	}

	public UserRolesDTO setSettingsPermissions(Map<String, Object> settingsPermissions) {
		this.settingsPermissions = settingsPermissions;
		return this;
	}

	public Map<String, Object> getMarketplacePermissions() {
		return marketplacePermissions;
	}

	public UserRolesDTO setMarketplacePermissions(Map<String, Object> marketplacePermissions) {
		this.marketplacePermissions = marketplacePermissions;
		return this;
	}

	public void addOrderPermission(String key, Object value) {
		this.orderPermissions.put(key, value);
	}

	public void addMarketplacePermission(String key, Object value) {
		this.marketplacePermissions.put(key, value);
	}

	public void addProductPermission(String key, Object value) {
		this.productPermissions.put(key, value);
	}

	public void addBoxesPermission(String key, Object value) {
		this.boxesPermissions.put(key, value);
	}

	public void addInvoicePermission(String key, Object value) {
		this.invoicePermissions.put(key, value);
	}

	public void addSettingsPermission(String key, Object value) {
		this.settingsPermissions.put(key, value);
	}

	public Integer getUsersCount() {
		return usersCount;
	}

	public void setUsersCount(Integer usersCount) {
		this.usersCount = usersCount;
	}

	public boolean isShowPaidUsersBanner() {
		return showPaidUsersBanner;
	}

	public void setShowPaidUsersBanner(boolean showPaidUsersBanner) {
		this.showPaidUsersBanner = showPaidUsersBanner;
	}

}
