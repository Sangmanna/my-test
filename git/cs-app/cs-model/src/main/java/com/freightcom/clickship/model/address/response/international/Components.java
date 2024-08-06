
package com.freightcom.clickship.model.address.response.international;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.freightcom.clickship.model.CommonDTO;

import java.io.Serializable;

@JsonPropertyOrder({
    "administrative_area",
    "super_administrative_area",
    "sub_administrative_area",
    "dependent_locality",
    "dependent_locality_name",
    "double_dependent_locality",
    "country_iso_3",
    "locality",
    "postal_code",
    "postal_code_short",
    "postal_code_extra",
    "premise",
    "premise_extra",
    "premise_number",
    "premise_type",
    "thoroughfare",
    "thoroughfare_name",
    "thoroughfare_type",
    "thoroughfare_predirection",
    "thoroughfare_postdirection",
    "thoroughfare_trailing_type",
    "dependent_thoroughfare",
    "dependent_thoroughfare_predirection",
    "dependent_thoroughfare_postdirection",
    "dependent_thoroughfare_name",
    "dependent_thoroughfare_trailing_type",
    "dependent_thoroughfare_type",
    "building",
    "building_leading_type",
    "building_name",
    "building_trailing_type",
    "sub_building",
    "sub_building_type",
    "sub_building_number",
    "sub_building_name",
    "post_box",
    "post_box_type",
    "post_box_number"
})
public class Components extends CommonDTO implements Serializable
{
    @JsonProperty("administrative_area")
    private String administrativeArea;
    @JsonProperty("super_administrative_area")
    private String superAdministrativeArea;
    @JsonProperty("sub_administrative_area")
    private String subAdministrativeArea;
    @JsonProperty("dependent_locality")
    private String dependentLocality;
    @JsonProperty("dependent_locality_name")
    private String dependentLocalityName;
    @JsonProperty("double_dependent_locality")
    private String doubleDependentLocality;
    @JsonProperty("country_iso_3")
    private String countryIso3;
    @JsonProperty("locality")
    private String locality;
    @JsonProperty("postal_code")
    private String postalCode;
    @JsonProperty("postal_code_short")
    private String postalCodeShort;
    @JsonProperty("postal_code_extra")
    private String postalCodeExtra;
    @JsonProperty("premise")
    private String premise;
    @JsonProperty("premise_extra")
    private String premiseExtra;
    @JsonProperty("premise_number")
    private String premiseNumber;
    @JsonProperty("premise_type")
    private String premiseType;
    @JsonProperty("thoroughfare")
    private String thoroughfare;
    @JsonProperty("thoroughfare_name")
    private String thoroughfareName;
    @JsonProperty("thoroughfare_type")
    private String thoroughfareType;
    @JsonProperty("thoroughfare_predirection")
    private String thoroughfarePredirection;
    @JsonProperty("thoroughfare_postdirection")
    private String thoroughfarePostdirection;
    @JsonProperty("thoroughfare_trailing_type")
    private String thoroughfareTrailingType;
    @JsonProperty("dependent_thoroughfare")
    private String dependentThoroughfare;
    @JsonProperty("dependent_thoroughfare_predirection")
    private String dependentThoroughfarePredirection;
    @JsonProperty("dependent_thoroughfare_postdirection")
    private String dependentThoroughfarePostdirection;   
    @JsonProperty("dependent_thoroughfare_name")
    private String dependentThoroughfareName;
    @JsonProperty("dependent_thoroughfare_trailing_type")
    private String dependentThoroughfareTrailingType;
    @JsonProperty("dependent_thoroughfare_type")
    private String dependentThoroughfareType;
    @JsonProperty("building")
    private String building;
    @JsonProperty("building_leading_type")
    private String buildingLeadingType;
    @JsonProperty("building_name")
    private String buildingName;
    @JsonProperty("building_trailing_type")
    private String buildingTrailingType;
    @JsonProperty("sub_building")
    private String subBuilding;
    @JsonProperty("sub_building_type")
    private String subBuildingType;
    @JsonProperty("sub_building_number")
    private String subBuildingNumber;
    @JsonProperty("sub_building_name")
    private String subBuildingName;
    @JsonProperty("post_box")
    private String postBox;
    @JsonProperty("post_box_type")
    private String postBoxType;
    @JsonProperty("post_box_number")
    private String postBoxNumber;
    
    private final static long serialVersionUID = -5837229446415571531L;

    public String getAdministrativeArea() {
        return administrativeArea;
    }

    public Components setAdministrativeArea(String administrativeArea) {
        this.administrativeArea = administrativeArea;
        return this;
    }

    public String getSuperAdministrativeArea() {
        return superAdministrativeArea;
    }

    public Components setSuperAdministrativeArea(String superAdministrativeArea) {
        this.superAdministrativeArea = superAdministrativeArea;
        return this;
    }

    public String getSubAdministrativeArea() {
        return subAdministrativeArea;
    }

    public Components setSubAdministrativeArea(String subAdministrativeArea) {
        this.subAdministrativeArea = subAdministrativeArea;
        return this;
    }

    public String getDependentLocality() {
        return dependentLocality;
    }

    public Components setDependentLocalityName(String dependentLocalityName) {
        this.dependentLocalityName = dependentLocalityName;
        return this;
    }
    
    public String getDependentLocalityName() {
        return dependentLocalityName;
    }

    public Components setDependentLocality(String dependentLocality) {
        this.dependentLocality = dependentLocality;
        return this;
    }

    public String getCountryIso3() {
        return countryIso3;
    }

    public Components setCountryIso3(String countryIso3) {
        this.countryIso3 = countryIso3;
        return this;
    }

    public String getLocality() {
        return locality;
    }

    public Components setLocality(String locality) {
        this.locality = locality;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Components setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getPostalCodeShort() {
        return postalCodeShort;
    }

    public Components setPostalCodeShort(String postalCodeShort) {
        this.postalCodeShort = postalCodeShort;
        return this;
    }
    
    public String getPostalCodeExtra() {
        return postalCodeExtra;
    }

    public Components setPostalCodeExtra(String postalCodeExtra) {
        this.postalCodeExtra = postalCodeExtra;
        return this;
    }

    public String getPremise() {
        return premise;
    }

    public Components setPremise(String premise) {
        this.premise = premise;
        return this;
    }

    public String getPremiseExtra() {
        return premiseExtra;
    }

    public Components setPremiseExtra(String premiseExtra) {
        this.premiseExtra = premiseExtra;
        return this;
    }

    public String getPremiseNumber() {
        return premiseNumber;
    }

    public Components setPremiseNumber(String premiseNumber) {
        this.premiseNumber = premiseNumber;
        return this;
    }
    
    public String getPremiseType() {
        return premiseType;
    }

    public Components setPremiseType(String premiseType) {
        this.premiseType = premiseType;
        return this;
    }

    public String getThoroughfare() {
        return thoroughfare;
    }

    public Components setThoroughfare(String thoroughfare) {
        this.thoroughfare = thoroughfare;
        return this;
    }

    public String getThoroughfareName() {
        return thoroughfareName;
    }

    public Components setThoroughfareName(String thoroughfareName) {
        this.thoroughfareName = thoroughfareName;
        return this;
    }

    public String getThoroughfareType() {
        return thoroughfareType;
    }

    public Components setThoroughfareType(String thoroughfareType) {
        this.thoroughfareType = thoroughfareType;
        return this;
    }

    public String getThoroughfarePredirection() {
        return thoroughfarePredirection;
    }

    public Components setThoroughfarePredirection(String thoroughfarePredirection) {
        this.thoroughfarePredirection = thoroughfarePredirection;
        return this;
    }
    
    public String getThoroughfarePostdirection() {
        return thoroughfarePostdirection;
    }

    public Components setThoroughfarePostdirection(String thoroughfarePostdirection) {
        this.thoroughfarePostdirection = thoroughfarePostdirection;
        return this;
    }
    
    public String getThoroughfareTrailingType() {
        return thoroughfareTrailingType;
    }

    public Components setThoroughfareTrailingType(String thoroughfareTrailingType) {
        this.thoroughfareTrailingType = thoroughfareTrailingType;
        return this;
    }

    public String getDependentThoroughfare() {
        return dependentThoroughfare;
    }

    public Components setDependentThoroughfare(String dependentThoroughfare) {
        this.dependentThoroughfare = dependentThoroughfare;
        return this;
    }

    public String getDependentThoroughfarePredirection() {
        return dependentThoroughfarePredirection;
    }

    public Components setDependentThoroughfarePredirection(String dependentThoroughfarePredirection) {
        this.dependentThoroughfarePredirection =dependentThoroughfarePredirection;
        return this;
    }
    
    public String getDependentThoroughfarePostdirection() {
        return dependentThoroughfarePostdirection;
    }

    public Components setDependentThoroughfarePostdirection(String dependentThoroughfarePostdirection) {
        this.dependentThoroughfarePostdirection = dependentThoroughfarePostdirection;
        return this;
    }
    
    public String getDependentThoroughfareName() {
        return dependentThoroughfareName;
    }

    public Components setDependentThoroughfareName(String dependentThoroughfareName) {
        this.dependentThoroughfareName = dependentThoroughfareName;
        return this;
    }
    
    public String getDependentThoroughfareTrailingType() {
        return dependentThoroughfareTrailingType;
    }

    public Components setDependentThoroughfareTrailingType(String dependentThoroughfareTrailingType) {
        this.dependentThoroughfareTrailingType = dependentThoroughfareTrailingType;
        return this;
    }
    
    public String getDependentThoroughfareType() {
        return dependentThoroughfareType;
    }

    public Components setDependentThoroughfareType(String dependentThoroughfareType) {
        this.dependentThoroughfareType = dependentThoroughfareType;
        return this;
    }
    
    public String getBuilding() {
        return building;
    }

    public Components setBuilding(String building) {
        this.building = building;
        return this;
    }
    
    public String getBuildingLeadingType() {
        return buildingLeadingType;
    }

    public Components setBuildingLeadingType(String buildingLeadingType) {
        this.buildingLeadingType = buildingLeadingType;
        return this;
    }
    
    public String getBuildingName() {
        return buildingName;
    }

    public Components setBuildingName(String buildingName) {
        this.buildingName = buildingName;
        return this;
    }
    
    public String getBuildingTrailingType() {
        return buildingTrailingType;
    }

    public Components getBuildingTrailingType(String buildingTrailingType) {
        this.buildingTrailingType = buildingTrailingType;
        return this;
    }
    
    public String getSubBuilding() {
        return subBuilding;
    }

    public Components setSubBuilding(String subBuilding) {
        this.subBuilding = subBuilding;
        return this;
    }
    
    public String getSubBuildingType() {
        return subBuildingType;
    }

    public Components setSubBuildingType(String subBuildingType) {
        this.subBuildingType = subBuildingType;
        return this;
    }

    public String getSubBuildingNumber() {
        return subBuildingNumber;
    }

    public Components setSubBuildingNumber(String subBuildingNumber) {
        this.subBuildingNumber = subBuildingNumber;
        return this;
    }

    public String getSubBuildingName() {
        return subBuildingName;
    }

    public Components setSubBuildingName(String subBuildingName) {
        this.subBuildingName = subBuildingName;
        return this;
    }

    public String getPostBox() {
        return postBox;
    }

    public Components setPostBox(String postBox) {
        this.postBox = postBox;
        return this;
    }

    public String getPostBoxNumber() {
        return postBoxNumber;
    }

    public Components getPostBoxNumber(String postBoxNumber) {
        this.postBoxNumber = postBoxNumber;
        return this;
    }

    public String getPostBoxType() {
        return postBoxType;
    }

    public Components setPostBoxType(String postBoxType) {
        this.postBoxType = postBoxType;
        return this;
    }

}
