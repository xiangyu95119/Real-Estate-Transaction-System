/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.customer;

import java.util.ArrayList;

/**
 *
 * @author wenhaofeng
 */
public class CustomerAccDirectory {
    private ArrayList<CustomerAccount> customerAccountList;
    public CustomerAccDirectory(){
        customerAccountList = new ArrayList();
    }

    public ArrayList<CustomerAccount> getCustomerAccountList() {
        return customerAccountList;
    }
    public CustomerAccount authenticateUser(String username, String password){
        for (CustomerAccount ua : customerAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    public CustomerAccount createUserAccount(String username, String password){
        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setUsername(username);
        customerAccount.setPassword(password);
        customerAccountList.add(customerAccount);
        return customerAccount;
    }
    public boolean checkIfUsernameIsUnique(String username){
        for (CustomerAccount ua : customerAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
}
