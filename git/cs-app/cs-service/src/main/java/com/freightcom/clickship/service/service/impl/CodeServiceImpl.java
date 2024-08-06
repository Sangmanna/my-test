package com.freightcom.clickship.service.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freightcom.clickship.data.entity.Code;
import com.freightcom.clickship.data.rep.CodeRepository;
import com.freightcom.clickship.model.system.CodeDTO;
import com.freightcom.clickship.model.util.CopyUtil;
import com.freightcom.clickship.service.service.CodeService;

@Service
public class CodeServiceImpl implements CodeService {
	
	private final String G_NAME = "groupName";
	private final String P_CODE = "parentCodeId";
	
	@Autowired
	private CodeRepository codeRepository;

	@Override
	public List<Code> getCodes(Map<String, String> map) {
		
		List<Code> list = new ArrayList<>();
		
		if (hasValue(map, P_CODE) && hasValue(map, G_NAME)) {
			list = codeRepository.findAllByParentCodeIdAndGroupName(map.get(P_CODE), map.get(G_NAME));
		} else if (hasValue(map, P_CODE)) {
			list = codeRepository.findAllByParentCodeId(map.get(P_CODE));
		} else if (hasValue(map, G_NAME)) {
			list = codeRepository.findAllByGroupName(map.get(G_NAME));
		}
				
		if ("PROVINCE".equalsIgnoreCase(map.get(G_NAME))) {
			// sort the state or province code by name
			list.stream().sorted((x, y) -> x.getName().compareTo(y.getName()));
		} else {
			list.stream().sorted((x, y) -> x.getOrderby().compareTo(y.getOrderby()));
		}

		return list;
	}
	
	@Override
	public List<String> getCodeNames(Map<String, String> map) {
		return codeRepository.findNamesByGroupName(map.get(G_NAME));
	}
	
	@Override
	public List<Code> getCodes(String groupName) {
		return getCodes(groupName, null);
	}
	
	@Override
	public List<CodeDTO> getCodeDTOs(String groupName) {
		return getCodes(groupName, null).stream().map(code -> {
			CodeDTO dto = new CodeDTO();
			CopyUtil.copyProperties(code, dto);
			return dto;
			
		}).sorted((a, b) -> {
			Long orderbyA = a.getOrderby();
			Long orderbyB = b.getOrderby();

			if (orderbyA == null || orderbyB == null) {
				return 0;
			} else {
				return orderbyA.compareTo(orderbyB);
			}
		}).collect(Collectors.toList());
	}

	@Override
	public List<Code> getCodes(String groupName, String parentCodeId) {
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("groupName", groupName);
		condition.put("parentCodeId", parentCodeId);
		return getCodes(condition);
	}
	
	@Override
	public Code getCodeByName(String groupName, String name) {
		return codeRepository.findByGroupNameAndName(groupName, name);
	}

	@Override
	public Code getCodeByValue(String groupName, String value) {
		return codeRepository.findByGroupNameAndValue(groupName, value);
	}
	
	@Override
	public Code getSingleCodeByGroupNameAndNameOrValue(String groupName, String name, String value) {
		List<Code> list = codeRepository.findByGroupNameAndNameOrValue(groupName, name, value);
		return CollectionUtils.isNotEmpty(list) ? list.get(0) : null;
	}
	
	@Override
	public Code getSingleCodeByParentCodeAndGroupNameAndNameOrValue(Code code, String groupName, String name, String value) {
		return codeRepository.findByParentCodeIdAndGroupNameAndNameOrValue(code.getId(), groupName, name, value);
	}
	
	private boolean hasValue(Map<String, String> map, String key) {
		return map.containsKey(key) && StringUtils.isNotEmpty(map.get(key));
	}

	@Override
	public Code getCodeByNameIgnoreCase(String groupName, String name) {
    return codeRepository.findByGroupNameIgnoreCaseAndNameIgnoreCase(groupName, name);
  }

	@Override
	public String getCountryCode(String countryOrCode) {
		return getAddressCodeValue("COUNTRY", countryOrCode);
	}

	@Override
	public String getProvinceCode(String provinceOrCode) {
		return getAddressCodeValue("PROVINCE", provinceOrCode);
	}

	private String getAddressCodeValue(String groupName, String nameOrCode) {
		if (nameOrCode == null) {
			return null;
		}

		if (nameOrCode.length() == 2) {
			// If the string is 2 characters, treat it as a code
			return nameOrCode.toUpperCase();
		} else {
			// If the string is more than 2 characters, treat it as a name
			Code code = getCodeByNameIgnoreCase(groupName, nameOrCode);
			return code != null ? code.getValue() : null;
		}
	}
}
