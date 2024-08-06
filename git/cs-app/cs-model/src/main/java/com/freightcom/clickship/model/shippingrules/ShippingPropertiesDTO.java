package com.freightcom.clickship.model.shippingrules;

import java.util.List;

public class ShippingPropertiesDTO {

    private String id;
    private String groupName;
    private String name;
    private String value;
    private List<ShippingPropertiesDTO> conditions;
    private Long orderBy;

    public String getId() {
        return id;
    }

    public ShippingPropertiesDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShippingPropertiesDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public ShippingPropertiesDTO setValue(String value) {
        this.value = value;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public ShippingPropertiesDTO setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public List<ShippingPropertiesDTO> getConditions() {
        return conditions;
    }

    public ShippingPropertiesDTO setConditions(List<ShippingPropertiesDTO> conditions) {
        this.conditions = conditions;
        return this;
    }

    public Long getOrderBy() {
        return orderBy;
    }

    public ShippingPropertiesDTO setOrderBy(Long orderBy) {
        this.orderBy = orderBy;
        return this;
    }
}
