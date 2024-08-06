package com.freightcom.clickship.model.shipment;

import java.io.Serializable;

import com.freightcom.clickship.model.CommonDTO;

public class DashboardScheduledPickupDTO extends CommonDTO implements Serializable {
    
	private static final long serialVersionUID = 7926688556449870276L;

	private long count;
	
	private String imageName;

    public DashboardScheduledPickupDTO(String imageName, long count) {
        super();
        this.imageName = imageName;
        this.count = count;
    }

    public String getImageName() {
        return imageName;
    }

    public DashboardScheduledPickupDTO setImageName(String imageName) {
        this.imageName = imageName;
        return this;
    }

    public long getCount() {
        return count;
    }

    public DashboardScheduledPickupDTO setCount(long count) {
        this.count = count;
        return this;
    }
}
