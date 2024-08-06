package com.freightcom.clickship.model.marketplace.amazon.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestrictedResource {

    @JsonProperty("method")
    private String method;

    @JsonProperty("path")
    private String path;

    @JsonProperty("dataElements")
    private List<String> dataElements;

    public String getMethod() {
        return method;
    }

    public RestrictedResource setMethod(String method) {
        this.method = method;
        return this;
    }

    public String getPath() {
        return path;
    }

    public RestrictedResource setPath(String path) {
        this.path = path;
        return this;
    }

    public List<String> getDataElements() {
        return dataElements;
    }

    public RestrictedResource setDataElements(List<String> dataElements) {
        this.dataElements = dataElements;
        return this;
    }
}
