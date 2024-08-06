package com.freightcom.clickship.event.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.freightcom.clickship.model.enums.CSSignupTypes;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Onboarding {
	
	public CSSignupTypes signup();
	
}