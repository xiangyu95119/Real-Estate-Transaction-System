/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;
import business.EcoSystem;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.CompanyManagerOrganization;
import business.organization.Organization;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.managerRole.CompanyManagerRoleJpanel;
/**
 *
 * @author apple
 */
public class CompanyManagerRole extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new CompanyManagerRoleJpanel(userProcessContainer, account, (CompanyManagerOrganization)organization, network, enterprise);
    }
    
}
