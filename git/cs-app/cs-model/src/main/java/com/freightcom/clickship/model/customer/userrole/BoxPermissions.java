package com.freightcom.clickship.model.customer.userrole;

public enum BoxPermissions {
	
	BOXES("boxes"),
	ADD_BOX("addBox"),
	SHOW_BOXES_PAGE("showBoxesPage");
	
    private String value;

	BoxPermissions (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

	@Override
	public String toString() {                                          
		return value;
	}

}
