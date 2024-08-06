package com.freightcom.clickship.model.v2;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class Weight   {
  /**
   * Unit that the weight is in.
   */
  public enum UnitEnum {
    KG("kg"),
    
    LB("lb"),
    
    G("g"),
    
    OZ("oz");

    private String value;

    UnitEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static UnitEnum fromValue(String text) {
      for (UnitEnum b : UnitEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("unit")
  private UnitEnum unit = null;

  @JsonProperty("value")
  private BigDecimal value = null;

  public Weight unit(UnitEnum unit) {
    this.unit = unit;
    return this;
  }

  /**
   * Unit that the weight is in.
   * @return unit
   **/
  
    public UnitEnum getUnit() {
    return unit;
  }

  public void setUnit(UnitEnum unit) {
    this.unit = unit;
  }

  public Weight value(BigDecimal value) {
    this.value = value;
    return this;
  }

  /**
   * Weight value in the unit.
   * @return value
   **/
      public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Weight weight = (Weight) o;
    return Objects.equals(this.unit, weight.unit) &&
        Objects.equals(this.value, weight.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unit, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Weight {\n");
    
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
