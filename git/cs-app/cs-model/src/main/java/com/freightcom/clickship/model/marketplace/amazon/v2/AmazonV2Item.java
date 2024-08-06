package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmazonV2Item {

    @JsonProperty("Identifiers")
    private IdentifierType identifiers;

    @JsonProperty("AttributeSets")
    private List<AttributeSetList> attributeSets;

    public IdentifierType getIdentifiers() {
        return identifiers;
    }

    public AmazonV2Item setIdentifiers(IdentifierType identifiers) {
        this.identifiers = identifiers;
        return this;
    }

    public List<AttributeSetList> getAttributeSets() {
        return attributeSets;
    }

    public AmazonV2Item setAttributeSets(List<AttributeSetList> attributeSets) {
        this.attributeSets = attributeSets;
        return this;
    }
}
