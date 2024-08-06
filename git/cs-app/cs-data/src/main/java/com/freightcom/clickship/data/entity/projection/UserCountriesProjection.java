package com.freightcom.clickship.data.entity.projection;

public interface UserCountriesProjection {
	
	public static final String SELECT = "SELECT pc.value AS proviance, uc.proviance AS userProviance";

	public String getProviance();

	public String getUserProviance();

}
