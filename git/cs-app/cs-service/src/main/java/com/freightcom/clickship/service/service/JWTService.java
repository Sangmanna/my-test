package com.freightcom.clickship.service.service;

import java.util.List;

import com.freightcom.clickship.data.entity.JWT;
import com.freightcom.clickship.data.rep.JWTRepository.UserJWTDTO;

/**
 * The same code in api project; com.freightcom.clickship.customer.service.JWTService
 * @author sangmann
 *
 */
public interface JWTService {
	
	public void delete(List<JWT> list);
	
	public void deleteExpired(String username);
	
	public List<JWT> findAllByUsername(String username);
	
	public void deleteAllJWTByUserName(String username);

	public void save(String username, String jwtTokenStr);
	
	public UserJWTDTO getUserJWTDTO(String username, String jwt);
	
}
