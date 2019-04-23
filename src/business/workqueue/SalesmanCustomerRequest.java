/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import business.building.Apartment;
import business.building.Building;
import business.customer.CustomerAccount;

/**
 *
 * @author wenhaofeng
 */
public class SalesmanCustomerRequest extends WorkRequest{
    private Building building;
    private Apartment apt;
    private CustomerAccount customerAccount;

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }
    

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Apartment getApt() {
        return apt;
    }

    public void setApt(Apartment apt) {
        this.apt = apt;
    }

    
   
    
    
}
