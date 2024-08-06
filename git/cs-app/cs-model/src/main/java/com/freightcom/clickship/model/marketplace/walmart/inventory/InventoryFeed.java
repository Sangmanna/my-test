
package com.freightcom.clickship.model.marketplace.walmart.inventory;

import com.freightcom.clickship.model.marketplace.walmart.Inventory;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "inventoryHeader",
    "inventory"
})
@XmlRootElement(name = "InventoryFeed")
public class InventoryFeed {

    @XmlElement(name = "InventoryHeader", required = true)
    protected InventoryHeader inventoryHeader;
    protected List<Inventory> inventory;

    public InventoryHeader getInventoryHeader() {
        return inventoryHeader;
    }

    public void setInventoryHeader(InventoryHeader value) {
        this.inventoryHeader = value;
    }

    public List<Inventory> getInventory() {
        if (inventory == null) {
            inventory = new ArrayList<Inventory>();
        }
        return this.inventory;
    }

}
