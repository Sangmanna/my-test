package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DamagedPropertiesDTO {
    @JsonProperty("description_of_damage")
    String descriptionOfDamage;

    @JsonProperty("value_of_damaged_goods")
    ValueDTO valueOfDamagedGoods;
}