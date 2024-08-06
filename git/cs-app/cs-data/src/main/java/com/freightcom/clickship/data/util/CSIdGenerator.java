package com.freightcom.clickship.data.util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import com.freightcom.clickship.data.entity.common.DomainPrefix;

@Component
public class CSIdGenerator implements IdentifierGenerator, Configurable {
	
	private static final long serialVersionUID = 7289772341344316896L;

	private String serverId = "Z";
	private static int count3 = 0, count2 = 0, count1 = 0, count0 = 0;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
	private static String[] alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
	
	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
		try {
			Context ic = new InitialContext();
			serverId = (String) ic.lookup("java:comp/env/serverId");
		} catch (NamingException e) {
			
		}
	}
 
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return getNextId(DomainPrefix.getPrefix(object.getClass().getSimpleName().toUpperCase()));
	}
	
	public String getNextId(String prefix) {
		return new StringBuffer(prefix).append(getPostFix()).toString();
	}
	
	public String generate() {
		return new StringBuffer(DomainPrefix.UNDEFINED_DOMAIN).append(getPostFix()).toString();
	}
	
	public String generateForQuote() {
		return new StringBuffer(DomainPrefix.UNDEFINED_DOMAIN_QUOTE).append(getPostFix()).toString();
	}

	private StringBuffer getPostFix() {
		return new StringBuffer(serverId)
				.append(dateFormat.format(new Date()).substring(1))
				.append(getNextCount());
	}
	
	private static synchronized String getNextCount() {
		
		int length = alphabet.length;
		
		count0++;
		if (count0 == length) {
			count0 = 0;
			count1++;
			if (count1 == length) {
				count1 = 0;
				count2++;
				if (count2 == length) {
					count2 = 0;
					count3++;
					if (count3 == length) {
						count3 = 0;
					}
				}
			}
		}
		
		return new StringBuffer(alphabet[count3]).append(alphabet[count2]).append(alphabet[count1]).append(alphabet[count0]).toString();
	}
}
