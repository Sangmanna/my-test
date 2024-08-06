package com.freightcom.clickship.model.v2;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
/**
* OneOfShippingDetailsPackagingProperties
*/
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = PackagingPallet.class, name = "PackagingPallet"),
  @JsonSubTypes.Type(value = PackagingPackage.class, name = "PackagingPackage"),
  @JsonSubTypes.Type(value = PackagingCourierPak.class, name = "PackagingCourierPak"),
  @JsonSubTypes.Type(value = PackagingEnvelope.class, name = "PackagingEnvelope")
})
@JsonDeserialize(using = ShippingReponseDeserializer.class)
public interface OneOfShippingDetailsPackagingProperties {

}
