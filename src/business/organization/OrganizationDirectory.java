/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author wenhaofeng
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }
    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.AManage.getValue())){
            organization = new AgentManagerOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.CManage.getValue())){
            organization = new CompanyManagerOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Salesman.getValue())){
            organization = new AgentSalesmanOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    
}
