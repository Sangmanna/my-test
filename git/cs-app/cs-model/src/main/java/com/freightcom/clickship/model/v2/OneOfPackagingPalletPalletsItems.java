package com.freightcom.clickship.model.v2;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
/**
* OneOfPackagingPalletPalletsItems
*/
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = LTLPallet.class, name = "LTLPallet")
})
public interface OneOfPackagingPalletPalletsItems {

}
