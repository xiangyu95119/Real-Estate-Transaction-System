/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import business.EcoSystem;
import business.building.Apartment;
import business.building.Building;
import business.building.BuildingDirectory;
import business.customer.CustomerAccount;
import business.employee.Employee;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.AgentSalesmanOrganization;
import business.organization.Organization;
import business.useraccount.UserAccount;
import business.workqueue.ManagerSalesmanRequest;
import business.workqueue.SalesmanCustomerRequest;
import business.workqueue.WorkRequest;
import com.sun.org.apache.xml.internal.dtm.DTM;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wenhaofeng
 */
public class CustomerBuy extends javax.swing.JPanel {
    private EcoSystem system;
    //private UserAccount userAccount;
    //private Building building;
    //private Apartment apt;
    private CustomerAccount customerAccount;
    //private Apartment apt;
    
    /**
     * Creates new form CustomerBuy
     */
    public CustomerBuy(EcoSystem system,CustomerAccount customerAccount) {
        initComponents();
        this.system = system;
        this.customerAccount = customerAccount;
        populateComboBox();
        populateTable();
        title.setText("Order your apartment");
        TxtScore.setEnabled(false);
    }
    private void populateComboBox() {
        jComboBox1.removeAllItems();
        for (Network network : system.getNetworkList()) {
            jComboBox1.addItem(network);
        }

    }
    public void populateSearchTable(){
        DefaultTableModel dtm=(DefaultTableModel)jTable1.getModel();
        dtm.setRowCount(0);
        for(Network network:system.getNetworkList()){
            //System.out.println(network);
            for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
                //System.out.println(enterprise);
                for(Organization organization :enterprise.getOrganizationDirectory().getOrganizationList()){
                    //System.out.println(organization);
                    if(organization instanceof AgentSalesmanOrganization){
                        for(UserAccount salesmanaccount: organization.getUserAccountDirectory().getUserAccountList()){
                            //System.out.println(salesmanaccount);
                            for(WorkRequest request : salesmanaccount.getWorkqueue().getWorkRequestList()){
                                
                                if(request instanceof ManagerSalesmanRequest&&((ManagerSalesmanRequest)request).getApartment().getOwner().length()==0){
                                    //System.out.println(((ManagerSalesmanRequest)request).getBuilding());
                                    Object row[]= new Object[dtm.getColumnCount()];
                                    Building building = ((ManagerSalesmanRequest)request).getBuilding();
                                    Apartment apt = ((ManagerSalesmanRequest)request).getApartment();
                                    //System.out.println(jComboBox1.getSelectedItem());
                                    String tmp = jComboBox1.getSelectedItem().toString();
                                    //System.out.println(network.getCityName());
                                    if(tmp.equals(network.getCityName()) & apt.getOwner().length()==0 && apt.getPrice() > 0 ){
                                    row[0] = apt;
                                    row[1] = building;
                                    row[2] = apt.getPrice();
                                    row[3] = apt.getLel();
                                    row[4] = apt.getNum();
                                    row[5] = salesmanaccount;
                                    row[6] = building.getName();
                                    row[7] = salesmanaccount.getScore();
                                    dtm.addRow(row);
                                    }
                                }
          
                            }
                        }
                    }
                }}}
        
    }
    public void populateCheckOrderTable(){
        DefaultTableModel dtm=(DefaultTableModel)jTable1.getModel();
        dtm.setRowCount(0);
        for(Network network:system.getNetworkList()){
            //System.out.println(network);
            for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
                //System.out.println(enterprise);
                for(Organization organization :enterprise.getOrganizationDirectory().getOrganizationList()){
                    //System.out.println(organization);
                    if(organization instanceof AgentSalesmanOrganization){
                        for(UserAccount salesmanaccount: organization.getUserAccountDirectory().getUserAccountList()){
                            //System.out.println(salesmanaccount);
                            for(WorkRequest request : salesmanaccount.getWorkqueue().getWorkRequestList()){
                                
                                if(request instanceof ManagerSalesmanRequest){
                                    //System.out.println(((ManagerSalesmanRequest)request).getBuilding());
                                    Object row[]= new Object[dtm.getColumnCount()];
                                    Building building = ((ManagerSalesmanRequest)request).getBuilding();
                                    Apartment apt = ((ManagerSalesmanRequest)request).getApartment();
                                    if(apt.getOwner().equals(customerAccount.getUsername())){
                                    row[0] = apt;
                                    row[1] = building;
                                    row[2] = apt.getPrice();
                                    row[3] = apt.getLel();
                                    row[4] = apt.getNum();
                                    row[5] = salesmanaccount;
                                    row[6] = building.getName();
                                    row[7] = salesmanaccount.getScore();
                                    dtm.addRow(row);
                                    }
                                }
          
                            }
                        }
                    }
                }}}
        
    }
    public void populateTable(){
        DefaultTableModel dtm=(DefaultTableModel)jTable1.getModel();
        dtm.setRowCount(0);
        
        for(Network network:system.getNetworkList()){
            //System.out.println(network);
            for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
                //System.out.println(enterprise);
                for(Organization organization :enterprise.getOrganizationDirectory().getOrganizationList()){
                    //System.out.println(organization);
                    if(organization instanceof AgentSalesmanOrganization){
                        for(UserAccount salesmanaccount: organization.getUserAccountDirectory().getUserAccountList()){
                            //System.out.println(salesmanaccount);
                            for(WorkRequest request : salesmanaccount.getWorkqueue().getWorkRequestList()){
                                
                                if(request instanceof ManagerSalesmanRequest){
                                    //System.out.println(((ManagerSalesmanRequest)request).getBuilding());
                                    Object row[]= new Object[dtm.getColumnCount()];
                                    Building building = ((ManagerSalesmanRequest)request).getBuilding();
                                    Apartment apt = ((ManagerSalesmanRequest)request).getApartment();
                                    if(apt.getOwner().length()==0 && apt.getPrice() > 0 ){
                                    row[0] = apt;
                                    row[1] = building;
                                    row[2] = apt.getPrice();
                                    row[3] = apt.getLel();
                                    row[4] = apt.getNum();
                                    row[5] = salesmanaccount;
                                    row[6] = building.getName();
                                    row[7] = salesmanaccount.getScore();
                                    dtm.addRow(row);
                                    }
                                }
          
                            }
                        }
                    }
                }
                /*for(Building building : enterprise.getBuildingDirectory().getBuildinglist()){
                    for(Apartment apt : building.getApartmentlist()){
                        if(apt.getSalesman().length()!=0){
                            Object row[]= new Object[dtm.getColumnCount()];
                            row[0] = apt;
                            row[1] = building;
                            row[2] = apt.getPrice();
                            row[3] = apt.getLel();
                            row[4] = apt.getNum();
                            
                            //row[5] = 
                            row[6] = building.getName();
                        }
                    }
                }*/
                    /*boolean[][] tmp = building.getAvailability();
                        for(int i =0;i < tmp.length;i++){
                            for(int j = 0;j < tmp[0].length;j++){
                                if(!tmp[i][j]){
                                    Object row[]= new Object[dtm.getColumnCount()];
                                    row[1] = building;
                                    row[2] = building.getCost();
                                    row[3] = i+1;
                                    row[4] = j+1;
                                    row[6] = building.getName();
                    for(Apartment apt : building.getApartmentlist()){
                                    row[0] = apt;
                                    row[5] = apt.getSalesman(); 
                            }
                    dtm.addRow(row);
                        }
                        }
                    }*/
                
                
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

        title = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        searchBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        OrderBtn = new javax.swing.JButton();
        checkBtn = new javax.swing.JButton();
        EvaluateBtn = new javax.swing.JButton();
        TxtScore = new javax.swing.JTextField();

        setBackground(new java.awt.Color(166, 166, 234));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("<Value>");
        add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 285, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, -1, -1));

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 96, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Adress", "Price", "Level", "Num", "Saleman", "Building", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Long.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 69, 570, 260));

        OrderBtn.setText("Order");
        OrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderBtnActionPerformed(evt);
            }
        });
        add(OrderBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 96, -1));

        checkBtn.setText("Check your acceptted apt");
        checkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBtnActionPerformed(evt);
            }
        });
        add(checkBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        EvaluateBtn.setText("Evaluate:(1-10)");
        EvaluateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvaluateBtnActionPerformed(evt);
            }
        });
        add(EvaluateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, -1));
        add(TxtScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 90, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void OrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderBtnActionPerformed
        // TODO add your handling code here:
        int selectedrow = jTable1.getSelectedRow();
        if(selectedrow >= 0){
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to request this apartment??","Warning",selectionButton);
            if(selectionResult == JOptionPane.YES_OPTION){
                
                SalesmanCustomerRequest request = new SalesmanCustomerRequest();
                Building build = (Building)jTable1.getValueAt(selectedrow,1);
                request.setBuilding(build);
                Apartment apart =(Apartment)jTable1.getValueAt(selectedrow,0);
                request.setApt(apart);
                request.setCustomerAccount(customerAccount);
                request.setStatus("Pending");
                UserAccount salesmanacc = (UserAccount)jTable1.getValueAt(selectedrow, 5);
                salesmanacc.getWorkqueue().getWorkRequestList().add(request);
                /*for(Network network:system.getNetworkList()){
            for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
                for(Building building : enterprise.getBuildingDirectory().getBuildinglist()){
                    for(Apartment apt : building.getApartmentlist()){
                            if(apt.getSalesman() == (String)jTable1.getValueAt((selectedrow), 5)){
                                enterprise.getWorkQueue().getWorkRequestList().add(request);
                            }
                            
                        }
                        }
                    }
        }*/
                JOptionPane.showMessageDialog(null,"Send successfully");
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null,"Please select any row");}
        
    }//GEN-LAST:event_OrderBtnActionPerformed

    private void checkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBtnActionPerformed
        // TODO add your handling code here:
        title.setText("Check your ordered apartment");
        populateCheckOrderTable();
        TxtScore.setEnabled(true);
    }//GEN-LAST:event_checkBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        populateSearchTable();
    }//GEN-LAST:event_searchBtnActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void EvaluateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvaluateBtnActionPerformed
        // TODO add your handling code here:
        int selectedrow = jTable1.getSelectedRow();
        if(selectedrow >= 0){
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to evaluate this Salesman??","Warning",selectionButton);
            if(selectionResult == JOptionPane.YES_OPTION){
                UserAccount salesmanaccount =(UserAccount)jTable1.getValueAt(selectedrow,5);
                try{
                if(Integer.parseInt(TxtScore.getText())<=10&&Integer.parseInt(TxtScore.getText())>=0){
                salesmanaccount.getScoreList().add(Integer.parseInt(TxtScore.getText()));
                JOptionPane.showMessageDialog(null,"Evaluate successfully");
                TxtScore.setEnabled(false);}
                else{
                    JOptionPane.showMessageDialog(null,"The Score should be less than 10 more than 0");
                }
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Please enter a number less than 10 more than 0");
                }
            }

        }
        else{
            JOptionPane.showMessageDialog(null,"Please select any row");
        }

    }//GEN-LAST:event_EvaluateBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EvaluateBtn;
    private javax.swing.JButton OrderBtn;
    private javax.swing.JTextField TxtScore;
    private javax.swing.JButton checkBtn;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton searchBtn;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
