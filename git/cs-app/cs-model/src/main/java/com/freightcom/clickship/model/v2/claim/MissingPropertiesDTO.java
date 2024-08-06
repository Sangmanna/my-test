package com.freightcom.clickship.model.v2.claim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MissingPropertiesDTO {
    @JsonProperty("additional_notes")
    String additionalNotes;

    @JsonProperty("manual_trace_conducted")
    boolean manualTraceConducted;

    @JsonProperty("trace_state")
    String traceState;

    @JsonProperty("value_of_goods")
    ValueDTO valueOfGoods;

    @JsonProperty("value_of_missing_goods")
    ValueDTO valueOfMissingGoods;

    @JsonProperty("description_of_goods")
    String descriptionOfGoods;

    @JsonProperty("order_number")
    String orderNumber;

    @JsonProperty("replacement_will_be_shipped")
    String replacementWillBeShipped;  // "yes", "no", "undetermined"

    @JsonProperty("replacement_tracking_number")
    String replacementTrackingNumber;

    @JsonProperty("num_pallets")
    int numPallets;
}
