package com.freightcom.clickship.data.entity.projection;

public interface UserPermissionProjection {
	
	public static final String SELECT = "SELECT pp.type AS type, pp.name AS permissionName, pp.value AS permissionValue, up.permissionValue as userPermissionValue";

	public String getId();
	
	public String getType();

	public String getPermissionName();

	public String getPermissionValue();
	
	public String getUserPermissionValue();

}


