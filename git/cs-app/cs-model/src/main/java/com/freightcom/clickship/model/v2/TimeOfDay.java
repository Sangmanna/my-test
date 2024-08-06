package com.freightcom.clickship.model.v2;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Time of day in 24 hour time.
 */

public class TimeOfDay   {
  @JsonProperty("hour")
  private Integer hour = null;

  @JsonProperty("minute")
  private Integer minute = null;

  public TimeOfDay hour(Integer hour) {
    this.hour = hour;
    return this;
  }

  /**
   * Get hour
   * @return hour
   **/
 
    public Integer getHour() {
    return hour;
  }

  public void setHour(Integer hour) {
    this.hour = hour;
  }

  public TimeOfDay minute(Integer minute) {
    this.minute = minute;
    return this;
  }

  /**
   * Get minute
   * @return minute
   **/

    public Integer getMinute() {
    return minute;
  }

  public void setMinute(Integer minute) {
    this.minute = minute;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeOfDay timeOfDay = (TimeOfDay) o;
    return Objects.equals(this.hour, timeOfDay.hour) &&
        Objects.equals(this.minute, timeOfDay.minute);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hour, minute);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeOfDay {\n");
    
    sb.append("    hour: ").append(toIndentedString(hour)).append("\n");
    sb.append("    minute: ").append(toIndentedString(minute)).append("\n");
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
