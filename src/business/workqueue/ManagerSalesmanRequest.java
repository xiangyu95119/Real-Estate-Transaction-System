/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import business.building.Apartment;
import business.building.Building;

/**
 *
 * @author haowenchang
 */
public class ManagerSalesmanRequest extends WorkRequest{
    private Apartment apartment;
    private Building building;

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
    
}
