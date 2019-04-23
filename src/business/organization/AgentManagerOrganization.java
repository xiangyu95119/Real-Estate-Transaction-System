/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.role.AgentManagerRole;
import business.role.Role;
import java.util.ArrayList;
/**
 *
 * @author apple
 */
public class AgentManagerOrganization extends Organization{
    public AgentManagerOrganization() {
        super(Organization.Type.AManage.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new AgentManagerRole());
        return roles;
    }
}
