    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.salesmanRole;
import business.building.Apartment;
import business.building.Building;
import business.building.BuildingDirectory;
import business.employee.Employee;
import business.enterprise.Enterprise;
import business.enterprise.EnterpriseDirectory;
import business.useraccount.UserAccount;
import business.workqueue.ManagerSalesmanRequest;
import business.workqueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author apple
 */

public class ASManageApartmentsJpanel extends javax.swing.JPanel {

    /**
     * Creates new form ASManageApartmentsJpanel
     */
    private EnterpriseDirectory enterprisedirectory;
    private BuildingDirectory buildingDir;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private Building building;
    private UserAccount useraccount;
    public ASManageApartmentsJpanel(JPanel userProcessContainer, UserAccount useraccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprisedirectory = enterprisedirectory;
        this.enterprise = enterprise;
        this.useraccount = useraccount;
        //buildingDir = enterprise.getBuildingDirectory();
        
        //Building building = new Building(2,3);
        populateTable();
    }
    public void populateTable(){
        DefaultTableModel dtm=(DefaultTableModel)tbApartments.getModel();
        dtm.setRowCount(0);
        
        //for(Building building: buildingDir.getBuildinglist()){
        for(WorkRequest request: useraccount.getWorkqueue().getWorkRequestList()){
            if(request instanceof ManagerSalesmanRequest){
                Apartment apartment = ((ManagerSalesmanRequest)request).getApartment();
            //for(Apartment apartment: building.getApartmentlist()){
                
                    Object row[]= new Object[dtm.getColumnCount()];
                    row[0] = apartment;
                    row[1] = apartment.getBath();
                    row[2] = apartment.getBed();
                    row[3] = apartment.getPrice();
                    row[4] = apartment.getLel();
                    row[5] = apartment.getNum();
                    row[6] = apartment.getOwner();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbApartments = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        EditInfoJBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(166, 166, 234));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbApartments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Bath", "Bed", "Price", "Level", "Number", "Owner"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbApartments);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 570, 190));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Apartments' Information");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jButton1.setText("<<<Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));

        EditInfoJBtn.setText("EditInfo");
        EditInfoJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditInfoJBtnActionPerformed(evt);
            }
        });
        add(EditInfoJBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void EditInfoJBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditInfoJBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbApartments.getSelectedRow();
        if(selectedRow>=0){
            Apartment apt=(Apartment)tbApartments.getValueAt(selectedRow,0);
            if(apt.getOwner().length() == 0){
            EditAptInformationJpanel edit=new EditAptInformationJpanel(userProcessContainer, apt);

            this.userProcessContainer.add("EditAptInformationJpanel",edit);
            CardLayout layout= (CardLayout)this.userProcessContainer.getLayout();
            layout.next(userProcessContainer);
            }
            else{
                JOptionPane.showMessageDialog(null, "This apartment has been ordered");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a Row");
        }
    }//GEN-LAST:event_EditInfoJBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditInfoJBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbApartments;
    // End of variables declaration//GEN-END:variables
}
