package com.freightcom.clickship.model.marketplace.squarespace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareSpaceInventoryRequest {

    @JsonProperty("incrementOperations")
    private List<SquareSpaceInventoryUpdate> incrementOperations;

    @JsonProperty("decrementOperations")
    private List<SquareSpaceInventoryUpdate> decrementOperations;

    @JsonProperty("setFiniteOperations")
    private List<SquareSpaceInventoryUpdate> setFiniteOperations;

    @JsonProperty("setUnlimitedOperations")
    private List<String> setUnlimitedOperations;

    public List<SquareSpaceInventoryUpdate> getIncrementOperations() {
        return incrementOperations;
    }

    public SquareSpaceInventoryRequest setIncrementOperations(List<SquareSpaceInventoryUpdate> incrementOperations) {
        this.incrementOperations = incrementOperations;
        return this;
    }

    public List<SquareSpaceInventoryUpdate> getDecrementOperations() {
        return decrementOperations;
    }

    public SquareSpaceInventoryRequest setDecrementOperations(List<SquareSpaceInventoryUpdate> decrementOperations) {
        this.decrementOperations = decrementOperations;
        return this;
    }

    public List<SquareSpaceInventoryUpdate> getSetFiniteOperations() {
        return setFiniteOperations;
    }

    public SquareSpaceInventoryRequest setSetFiniteOperations(List<SquareSpaceInventoryUpdate> setFiniteOperations) {
        this.setFiniteOperations = setFiniteOperations;
        return this;
    }

    public List<String> getSetUnlimitedOperations() {
        return setUnlimitedOperations;
    }

    public SquareSpaceInventoryRequest setSetUnlimitedOperations(List<String> setUnlimitedOperations) {
        this.setUnlimitedOperations = setUnlimitedOperations;
        return this;
    }
}
