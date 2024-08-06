package com.freightcom.clickship.service.service;

import java.util.List;
import java.util.Map;

import com.freightcom.clickship.data.entity.Code;
import com.freightcom.clickship.model.system.CodeDTO;

public interface CodeService {
	
	public List<Code> getCodes(String groupName);

	public List<CodeDTO> getCodeDTOs(String groupName);

	public String getCountryCode(String countryOrCode);
	
	public List<Code> getCodes(Map<String, String> map);

	public String getProvinceCode(String provinceOrCode);
	
	public Code getCodeByName(String groupName, String name);
	
	public List<String> getCodeNames(Map<String, String> map);

	public Code getCodeByValue(String groupName, String value);

	public List<Code> getCodes(String groupName, String parentCodeId);
	
	public Code getCodeByNameIgnoreCase(String groupName, String name);

	public Code getSingleCodeByGroupNameAndNameOrValue(String groupName, String name, String value);

	public Code getSingleCodeByParentCodeAndGroupNameAndNameOrValue(Code code, String groupName, String name, String value);

}
