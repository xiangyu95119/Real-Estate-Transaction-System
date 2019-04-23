/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.role.AgentSalesmanRole;
import business.role.Role;
import java.util.ArrayList;
/**
 *
 * @author apple
 */
public class AgentSalesmanOrganization extends Organization{
    public AgentSalesmanOrganization() {
        super(Organization.Type.Salesman.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new AgentSalesmanRole());
        return roles;
    }
}
