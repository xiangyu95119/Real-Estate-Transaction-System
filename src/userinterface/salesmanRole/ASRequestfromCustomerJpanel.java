/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.salesmanRole;
import business.EcoSystem;
import business.building.Apartment;
import business.building.Building;
import business.building.BuildingDirectory;
import business.customer.CustomerAccount;
import business.employee.Employee;
import business.enterprise.Enterprise;
import business.enterprise.EnterpriseDirectory;
import business.useraccount.UserAccount;
import business.workqueue.ManagerSalesmanRequest;
import business.workqueue.SalesmanCustomerRequest;
import business.workqueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author wenhaofeng
 */

public class ASRequestfromCustomerJpanel extends javax.swing.JPanel {
    
    /**
     * Creates new form salesmanRoleJpanel
     */
    private EnterpriseDirectory enterprisedirectory;
    private BuildingDirectory buildingDir;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private Building building;
    private UserAccount useraccount;
    private EcoSystem business;
    private CustomerAccount customerAccount;
    public ASRequestfromCustomerJpanel(JPanel userProcessContainer, UserAccount useraccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprisedirectory = enterprisedirectory;
        this.enterprise = enterprise;
        this.useraccount = useraccount;
        this.customerAccount = customerAccount;
        populateTable();   
    }
 public void populateTable(){
        DefaultTableModel dtm=(DefaultTableModel)CustomersRequestAptJTable.getModel();
        dtm.setRowCount(0);
        
        //for(Building building: buildingDir.getBuildinglist()){
        for(WorkRequest request: useraccount.getWorkqueue().getWorkRequestList()){
            if(request instanceof SalesmanCustomerRequest){
            Building building = ((SalesmanCustomerRequest) request).getBuilding();
            Apartment apt = ((SalesmanCustomerRequest) request).getApt();
            Object row[]= new Object[dtm.getColumnCount()];
            row[0] = apt;
            row[1] = building;
            row[2] = apt.getPrice();
            row[3] = building.getName();
            row[4] = ((SalesmanCustomerRequest) request);
            row[5] = ((SalesmanCustomerRequest)request).getCustomerAccount();
            dtm.addRow(row);
            
        }
    }
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        refreshTestJButton = new javax.swing.JButton();
        AcceptJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CustomersRequestAptJTable = new javax.swing.JTable();
        enterpriseLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(166, 166, 234));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(refreshTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 48, -1, -1));

        AcceptJButton.setText("Accept");
        AcceptJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AcceptJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, -1, -1));

        CustomersRequestAptJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Address", "Price", "Building", "Status", "Customer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(CustomersRequestAptJTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 490, 240));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setForeground(new java.awt.Color(255, 255, 255));
        enterpriseLabel.setText("Customers' Requests");
        jPanel1.add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 44, 260, 30));

        jButton1.setText("<<Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

        

    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void AcceptJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptJButtonActionPerformed
        int selectedRow = CustomersRequestAptJTable.getSelectedRow();

        if (selectedRow >= 0) {
            SalesmanCustomerRequest request = (SalesmanCustomerRequest) CustomersRequestAptJTable.getValueAt(selectedRow, 4);
                Apartment apt = ((SalesmanCustomerRequest) request).getApt();
             if(request.getStatus().equals("Pending") && ((SalesmanCustomerRequest) request).getApt().getOwner().length() == 0){
                        
                        //System.out.println(apt);
//                  SalesmanCustomerRequest request = (SalesmanCustomerRequest) CustomersRequestAptJTable.getValueAt(selectedRow, 3);
                        //if((Apartment) CustomersRequestAptJTable.getValueAt(selectedRow, 0) == apt && (String)CustomersRequestAptJTable.getValueAt(selectedRow, 4) == "Sent"){
//                      request.setCustomerAccount(CustomersRequestAptJTable.getValueAt(selectedRow,6));
                        request.setStatus("Finished");
                        apt.setOwner(((SalesmanCustomerRequest) request).getCustomerAccount().toString());
                        //apt.setOwner(customerAccount.getUsername());
                        populateTable();
                        JOptionPane.showMessageDialog(null, "Successfully Accepted.");
                        
                        //}
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "This one has finished.");
                        }
                 
                    
             
             
             
        } else {
            JOptionPane.showMessageDialog(null, "Choose a request to process.");
            return;
         }
        
        

    }//GEN-LAST:event_AcceptJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceptJButton;
    private javax.swing.JTable CustomersRequestAptJTable;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshTestJButton;
    // End of variables declaration//GEN-END:variables
}
