package com.freightcom.clickship.service.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.JWT;
import com.freightcom.clickship.data.rep.JWTRepository;
import com.freightcom.clickship.data.rep.JWTRepository.UserJWTDTO;
import com.freightcom.clickship.service.service.JWTService;

/**
 * The same code in api project; com.freightcom.clickship.customer.service.JWTServiceImpl
 * @author sangmann
 */
@Service
public class JWTServiceImpl implements JWTService {
	@Autowired
	JWTRepository jwtRepository;

	@Override
	@Transactional
	public void deleteAllJWTByUserName(String username) {
		jwtRepository.deleteAllByUsername(username);
	}
	
	@Override
	@Transactional
	public void delete(List<JWT> list) {
		jwtRepository.deleteAll(list);
	}
	
	@Override
	@Transactional
	public void save(String username, String jwtStr) {
		jwtRepository.save(new JWT(username, jwtStr));
	}

	@Override
	public UserJWTDTO getUserJWTDTO(String username, String jwt) {
		return jwtRepository.findUserAndJWTByUsernameAndJwt(username, jwt);
	}

	@Override
	public List<JWT> findAllByUsername(String username) {
		return jwtRepository.findAllByUsername(username);
	}
	
	@Override
	@Transactional
	public void deleteExpired(String username) {
		findAllByUsername(username).stream().filter(jwt -> jwt.getExpireDatetime().getTime() <= new Date().getTime()).forEach(jwtRepository::delete);
	}
}
