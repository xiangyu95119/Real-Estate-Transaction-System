/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.role.CompanyManagerRole;
import business.role.Role;
import java.util.ArrayList;
/**
 *
 * @author apple
 */
public class CompanyManagerOrganization extends Organization{
    public CompanyManagerOrganization() {
        super(Organization.Type.CManage.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CompanyManagerRole());
        return roles;
    }
}
