/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;


import business.role.AgentAdminRole;
import business.role.Role;
import java.util.ArrayList;
/**
 *
 * @author apple
 */
public class AgentAdminOrganization extends Organization{
    public AgentAdminOrganization() {
        super(Type.Admin.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new AgentAdminRole());
        return roles;
    }
}
