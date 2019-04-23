/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import business.building.Building;
import business.enterprise.Enterprise;

/**
 *
 * @author haowenchang
 */
public class ManagerManagerRequest extends WorkRequest{
    private String result;
    private Building building;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
    
}
