package com.freightcom.clickship.model.shippingrules;

import java.lang.reflect.Method;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ReflectionUtils;

public class EnumValueValidator implements ConstraintValidator<EnumValidate, String> {
	private Class<? extends Enum<?>> enumClass;
    private String enumMethod;

    @Override
    public void initialize(EnumValidate annotation) {
        this.enumClass = annotation.value();
        this.enumMethod = annotation.enumMethod();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            return false;
        }

        Enum<?>[] enums = enumClass.getEnumConstants();
        Method method = ReflectionUtils.findMethod(enumClass, enumMethod);

        if (method != null && enums != null) {
            for (Enum<?> en : enums) {
                Object enumValue = ReflectionUtils.invokeMethod(method, en);
                if (enumValue != null && enumValue.toString().equals(value)) {
                    return true;
                }
            }
        }

        return false;
    }
}