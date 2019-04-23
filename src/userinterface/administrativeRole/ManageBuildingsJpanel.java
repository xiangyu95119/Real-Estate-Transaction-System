/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.administrativeRole;
import business.EcoSystem;
import business.building.Building;
import business.building.BuildingDirectory;
import business.employee.Employee;
import business.enterprise.Enterprise;
import business.enterprise.EnterpriseDirectory;
import business.network.Network;
import business.useraccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author apple
 */

public class ManageBuildingsJpanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageBuildingsJpanel
     */
    private EnterpriseDirectory enterprisedirectory;
    private BuildingDirectory buildingDir;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private EcoSystem system;
    //private Building building;
    public ManageBuildingsJpanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprisedirectory = enterprisedirectory;
        this.enterprise = enterprise;
        this.system = system;
        buildingDir = enterprise.getBuildingDirectory();
        populateTable();
    }
    
    public void populateTable(){
        DefaultTableModel dtm=(DefaultTableModel)tbBuildings.getModel();
        dtm.setRowCount(0);
        
        for(Building building: buildingDir.getBuildinglist()){
    
            Object row[]= new Object[dtm.getColumnCount()];
            
            row[0] = building.getName();
            row[1] = building;
            row[2] = building.getCost();
            row[3] = building.getLevel();
            row[4] = building.getNpl();
            dtm.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbBuildings = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        CreateJBtn = new javax.swing.JButton();
        DelJBtn = new javax.swing.JButton();
        BackJBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(166, 166, 234));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbBuildings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Address", "Cost", "Level", "Num of room"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbBuildings);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 90, 591, 200));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Manage Buildings' Information");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 25, 285, 31));

        CreateJBtn.setText("Create Buildings");
        CreateJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateJBtnActionPerformed(evt);
            }
        });
        add(CreateJBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 326, 150, -1));

        DelJBtn.setText("Delete Building");
        DelJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelJBtnActionPerformed(evt);
            }
        });
        add(DelJBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 373, 150, -1));

        BackJBtn.setText("<<<Back");
        BackJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackJBtnActionPerformed(evt);
            }
        });
        add(BackJBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 353, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void CreateJBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateJBtnActionPerformed
        // TODO add your handling code here:
        
        AddBuildingsJpanel addBuildingsJpanel = new AddBuildingsJpanel(userProcessContainer, buildingDir, system);
        userProcessContainer.add("addBuildingsJPanel", addBuildingsJpanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_CreateJBtnActionPerformed

    private void BackJBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackJBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_BackJBtnActionPerformed

    private void DelJBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelJBtnActionPerformed
        // TODO add your handling code here:
        int selectedrow=tbBuildings.getSelectedRow();
        
        if(selectedrow>=0){
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete??","Warning",selectionButton);
            if(selectionResult == JOptionPane.YES_OPTION){
                
                Building building = (Building)tbBuildings.getValueAt(selectedrow, 1);
                if(building.getAgent().length()==0){
                    buildingDir.delBuilding(building);
                    JOptionPane.showMessageDialog(null,"Delete successfully");
                    populateTable();
                }
                else{
                    JOptionPane.showMessageDialog(null,"This building can't be deleted beacause of ownership");  
                }

        }
        
    }else 
            JOptionPane.showMessageDialog(null,"Please select any row");                      
        
    }//GEN-LAST:event_DelJBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackJBtn;
    private javax.swing.JButton CreateJBtn;
    private javax.swing.JButton DelJBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbBuildings;
    // End of variables declaration//GEN-END:variables
}
