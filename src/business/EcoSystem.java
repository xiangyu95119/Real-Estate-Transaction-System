/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.customer.CustomerAccount;
import business.network.Network;
import business.organization.Organization;
import business.role.Role;
import business.role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author haowenchang
 */
public class EcoSystem extends Organization{
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private ArrayList<CustomerAccount> customerAccountList;

    public ArrayList<CustomerAccount> getCustomerAccountList() {
        return customerAccountList;
    }
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    public CustomerAccount createCustomerAccount(String username, String password){
        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setUsername(username);
        customerAccount.setPassword(password);
        customerAccountList.add(customerAccount);
        return customerAccount;
    }
    public CustomerAccount authenticateUser(String username, String password){
        for (CustomerAccount ca : customerAccountList)
            if (ca.getUsername().equals(username) && ca.getPassword().equals(password)){
                return ca;
            }
        return null;
    }
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    private EcoSystem(){
        super(null);
        networkList=new ArrayList<Network>();
        customerAccountList = new ArrayList<CustomerAccount>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public boolean checkIfUserIsUnique(String userName){
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
            return false;
        }
        for(Network network:networkList){
            
        }
        return true;
    }
}
