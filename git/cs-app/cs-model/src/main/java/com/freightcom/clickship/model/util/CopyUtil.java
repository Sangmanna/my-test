
package com.freightcom.clickship.model.util;

import java.beans.FeatureDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Wrapper class to extend BeanUtils' functionality
 * @author sangman
 *
 */
public class CopyUtil extends BeanUtils {
	private static final ModelMapper modelMapper = new ModelMapper();
	
	// This attrs comes from UserProvider which is the root entity of most entity and dtos
	private static String[] userInfoProviderAttr = {"loginCustomer", "loginUser", "loginUsername", "authentication"};
		
	public static void copyPropertiesWithoutEmpty(Object source, Object target, String[] exclusives) {
		BeanUtils.copyProperties(source, target, ArrayUtils.addAll(getNullPropertyNames(source), exclusives));
	}
	
	public static void copyPropertiesWithoutEmpty(Object source, Object target) {
		BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
	}
	
	public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
            .map(FeatureDescriptor::getName)
            .filter(name -> !Arrays.stream(userInfoProviderAttr).anyMatch(x -> x.equals(name)))
            .filter(propertyName -> {
            	Object val = wrappedSource.getPropertyValue(propertyName);
            	if(val == null) return true;
            	else if(val instanceof String && StringUtils.isEmpty((String)val)) return true;
            	else return false;
            })
            .toArray(String[]::new);
    }
	
	public static void copyProperties(Object source, Object target) {
		copyProperties(source, null, target, null);
	}
	
	public static void copyProperties(Object source, String sourcePrefix, Object target) {
		copyProperties(source, sourcePrefix, target, null);
	}
	
	public static void copyProperties(Object source, Object target, String targetPrefix) {
		copyProperties(source, null, target, targetPrefix);
	}
	
	public static void copyMapToObject(Map<String, String> sourceMap, Object target) {
		Arrays.stream(target.getClass().getMethods()).forEach(method -> {
			String methodName = method.getName();
			if(methodName.startsWith("set")) {
				String attrName = ClickshipStringUtil.firstCharLower(methodName.substring(3));
				String value = sourceMap.get(attrName);
				if (value != null) {
					try {
						method.invoke(target, value);
					} catch (Exception e) { }
				}
			}
		});
	}
	
	/**
	 * Copy object's attributes' value to map as String value
	 * 
	 * @param source
	 * @param target
	 */
	public static Map<String, String> copyObjectToMap(Object source, Map<String, String> target) {
		Arrays.stream(source.getClass().getMethods()).forEach(method -> {
			String methodName = method.getName();
			if(methodName.startsWith("get")) {
				String attrName = ClickshipStringUtil.firstCharLower(methodName.substring(3));
				
				try {
					String value = String.valueOf(method.invoke(source));
					target.put(attrName, value);
				} catch (Exception e) {}
			}
		});
		return target;
	}
	
	public static Map<String, String> copyObjectToMap(Object source) {
		return copyObjectToMap(source, new HashMap<String, String>());
	}
	
	/**
	 * Copy source object to target object based on getter methods in source
	 * @param source
	 * @param sourcePrefix
	 * @param target
	 * @param targetPrefix
	 */
	public static Object copyProperties(Object source, String sourcePrefix, Object target, String targetPrefix) {
		final String sp = StringUtils.isNotBlank(sourcePrefix) ? sourcePrefix : "";
		final String tp = StringUtils.isNotBlank(targetPrefix) ? targetPrefix : "";
		
		Consumer<Method> consumer = (method) -> {
			try {
				if (method.getParameterCount() == 0) {
					Object value = method.invoke(source);
					if(value != null && !(value instanceof Collection)) {
						String methodName = method.getName();
						if(!"getClass".equals(methodName)) {
							String attrName = ClickshipStringUtil.startsWith(methodName, "get") ? 
									ClickshipStringUtil.decapitalize(methodName.substring(3, methodName.length())) :
									ClickshipStringUtil.decapitalize(methodName.substring(2, methodName.length()));
							if(attrName.toLowerCase().startsWith(sp.toLowerCase())) {
								attrName = attrName.substring(sp.length(), attrName.length());
							}
							Method targetMethod = null;
							String setMethodName = "set" + ClickshipStringUtil.capitalize(tp) + ClickshipStringUtil.capitalize(attrName);
							try {
								if (value instanceof Double) {
									try {
										targetMethod = target.getClass().getMethod(setMethodName, double.class);
									} catch (Exception e) {
										targetMethod = target.getClass().getMethod(setMethodName, Double.class);
									}
								} else if(value instanceof Integer) { 
									try {
										targetMethod = target.getClass().getMethod(setMethodName, int.class);
									} catch (Exception e) {
										targetMethod = target.getClass().getMethod(setMethodName, Integer.class);
									}
								} else if(value instanceof Long) {
									try {
										targetMethod = target.getClass().getMethod(setMethodName, long.class);
									} catch (Exception e) {
										targetMethod = target.getClass().getMethod(setMethodName, Long.class);
									}
								} else if(value instanceof Boolean) {
									try {
										targetMethod = target.getClass().getMethod(setMethodName, Boolean.class);
									} catch (NoSuchMethodException e) {
										targetMethod = target.getClass().getMethod(setMethodName, boolean.class);
									}
								}
								else targetMethod = target.getClass().getMethod(setMethodName, value.getClass());
							} catch (NoSuchMethodException e) {
							}
							if(targetMethod!=null) targetMethod.invoke(target, value);
						}
					}
				}
			} catch (Exception e) {}
		};
		performCopy(source, target, consumer);
		return target;
	}
	
	/**
	 * Check source object's setter method and get all values and put them into target Element as attributes
	 * 
	 * @param target
	 * @param source
	 * @return
	 */
	public static Element copyAttributes(Object source, Element target) {
		Consumer<Method> consumer = (method) -> {
			try {
				Object value = method.invoke(source);
				if(value != null && !(value instanceof Collection)) {
					String name = ClickshipStringUtil.decapitalize(method.getName().substring(3, method.getName().length()));
					target.setAttribute(name, (String)value);
				}
			}catch(Exception e) {}
		};
		performCopy(source, target, consumer);
		return target;
	}

	/**
	 * 
	 * @param target
	 * @param source
	 * @param consumer
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void performCopy(Object source, Object target, Consumer consumer) {
		if (source != null) {
			Arrays.stream(source.getClass().getMethods())
				.filter(x -> x.getName().startsWith("get") || x.getName().startsWith("is"))
				.forEach(consumer::accept);
		}
	}

	public static void copyAttributesWithCamel(Element sourceWithUnderscore, Object targetWithCamel) {
		copyAttributesWithCamel(sourceWithUnderscore, targetWithCamel, null);
	}
	
	public static void copyAttributesWithCamel(Element sourceWithUnderscore, Object targetWithCamel, String targetPrefix) {
		Arrays.stream(targetWithCamel.getClass().getMethods())
			.filter(method -> method.getName().startsWith("set"))
			.forEach(method -> {
				try {
					Type type = method.getGenericParameterTypes()[0];
					String attrName = ClickshipStringUtil.camelToUnderScore(method.getName().substring(3, method.getName().length()));
					
					if(targetPrefix!=null && attrName.toLowerCase().startsWith(targetPrefix.toLowerCase())) {
						attrName = attrName.substring(targetPrefix.length() + 1, attrName.length()); //  + 1 ==> '_'
					}
					
					NodeList nodeLit = sourceWithUnderscore.getElementsByTagName(attrName);
					if(nodeLit.getLength() > 0) {
						String value = sourceWithUnderscore.getElementsByTagName(attrName).item(0).getTextContent();
						if(type.equals(Double.class)) {
							method.invoke(targetWithCamel, Double.parseDouble(value));
						} else if(type.equals(Boolean.class)) {
							method.invoke(targetWithCamel, Boolean.parseBoolean(value));
						} else if(type.equals(Integer.class)) {
							method.invoke(targetWithCamel, Integer.parseInt(value));
						} else {
							method.invoke(targetWithCamel, value);
						}
					}
				}catch(Exception e) {}
			});
	}
	
	/**
	 * Copy source object to target object based on getter methods in source
	 * @param source
	 * @param sourcePrefix
	 * @param target
	 * @param targetPrefix
	 */
	public static void copyByFieldNames(Object source, Object target, String[] onlyFieldNames) {
		Consumer<Method> consumer = (method) -> {
			try {
				if (method.getParameterCount() == 0) {
					Object value = method.invoke(source);
					if(value != null && !(value instanceof Collection)) {
						String methodName = method.getName();
						if(!"getClass".equals(methodName)) {
							String attrName = ClickshipStringUtil.startsWith(methodName, "get") ? 
									ClickshipStringUtil.decapitalize(methodName.substring(3, methodName.length())) :
									ClickshipStringUtil.decapitalize(methodName.substring(2, methodName.length()));

							if (Arrays.stream(onlyFieldNames).anyMatch(f -> StringUtils.equals(f, attrName))) {
								Method targetMethod = null;
								String setMethodName = "set" + ClickshipStringUtil.capitalize(attrName);
								try {

									if (value instanceof Double) {
										targetMethod = getTargetMethod(target, value, setMethodName, double.class, Double.class);

									} else if (value instanceof Integer) {
										targetMethod = getTargetMethod(target, value, setMethodName, int.class, Integer.class);

									} else if (value instanceof Long) {
										targetMethod = getTargetMethod(target, value, setMethodName, long.class, Long.class);

									} else if (value instanceof Boolean) {
										targetMethod = getTargetMethod(target, value, setMethodName, boolean.class, Boolean.class);

									} else {
										targetMethod = target.getClass().getMethod(setMethodName, value.getClass());
									}
								} catch (NoSuchMethodException e) {
								}
								if (targetMethod != null) {
									targetMethod.invoke(target, value);
								}
							}
						}
					}
				}
			} catch (Exception e) {}
		};
		performCopy(source, target, consumer);
	}
	
	@SuppressWarnings("rawtypes")
	private static Method getTargetMethod(Object target, Object value, String setMethodName, Class classa, Class classb) throws NoSuchMethodException {
		Method targetMethod = null;
		try {
			targetMethod = target.getClass().getMethod(setMethodName, classa);
		} catch (Exception e) {
			targetMethod = target.getClass().getMethod(setMethodName, classb);
		}
		return targetMethod;
	}


	/**
	 * Creates a shallow copy of an object. This will copy entire fields in the object in nested manner.
	 *
	 * @param <D> the type of the destination object
	 * @param source the source object to be copied
	 * @param destinationType the class of the destination object
	 * @return a shallow copy of the source object
	 * @throws IllegalArgumentException if the source object or destination type is null
	 * @throws MappingException if an error occurs during the mapping process
	 */
	public static <D> D createShallowCopyObject(Object source, Class<D> destinationType) {
		return modelMapper.map(source, destinationType);
	}
	
}
