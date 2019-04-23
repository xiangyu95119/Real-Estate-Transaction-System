/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.network;

import business.enterprise.EnterpriseDirectory;

/**
 *
 * @author wenhaofeng
 */
public class Network {
    private String cityName;
    private EnterpriseDirectory enterpriseDirectory;

    public Network() {
        enterpriseDirectory =  new EnterpriseDirectory();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    @Override
    public String toString() {
        return cityName;
    }
    
    
    
}
