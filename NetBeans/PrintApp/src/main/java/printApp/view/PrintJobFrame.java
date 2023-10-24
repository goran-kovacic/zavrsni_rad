/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package printApp.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import printApp.controller.MaterialController;
import printApp.controller.PartController;
import printApp.controller.PrintJobController;
import printApp.controller.PrinterController;
import printApp.model.Material;
import printApp.model.Part;
import printApp.model.PrintJob;
import printApp.model.Printer;
import printApp.util.PrintAppException;
import printApp.util.Util;

/**
 *
 * @author AMD
 */
public class PrintJobFrame extends javax.swing.JFrame implements ViewInterface {

    private PrintJobController control;
    private DecimalFormat df;

    /**
     * Creates new form PrintJobFrame
     */
    public PrintJobFrame() {
        initComponents();

        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.of("en", "EN"));
        df = new DecimalFormat("####.##", dfs);

        setTitle(Util.APP_NAME + " | Print Jobs");
        control = new PrintJobController();

        loadParts();
        loadPrinters();
        loadMaterials();

        load();

    }
    
    private void showPartsByStatus() {
        
        DefaultComboBoxModel<Part> m = new DefaultComboBoxModel<>();
        Part p = new Part();
        
        
    }

    private void loadMaterials() {

        DefaultComboBoxModel<Material> m = new DefaultComboBoxModel<>();

        Material p = new Material();
        p.setId(0);
        p.setMaterialName("Select resin");
        m.addElement(p);
        m.addAll(new MaterialController().read());

        cmbMaterials.setModel(m);
        cmbMaterials.repaint();

    }

    private void loadPrinters() {
        DefaultComboBoxModel<Printer> m = new DefaultComboBoxModel<>();

        Printer p = new Printer();
        p.setId(0);
        p.setPrinterName("Select printer");
        m.addElement(p);
        m.addAll(new PrinterController().read());

        cmbPrinters.setModel(m);
        cmbPrinters.repaint();
    }

    private void loadParts() {

        DefaultComboBoxModel<Part> m = new DefaultComboBoxModel<>();

        Part p = new Part();
        p.setId(0);
        p.setPartName("Select part");
        m.addElement(p);
        m.addAll(new PartController().read());

        cmbParts.setModel(m);
        cmbParts.repaint();

    }

    @Override
    public void load() {

        DefaultListModel<PrintJob> p = new DefaultListModel<>();
        p.addAll(control.read());
        lstData.setModel(p);
        lstData.repaint();

    }
    
    private BigDecimal cost(){
        
        var e = control.getEntitet();
        
        BigDecimal cpu = e.getMaterial().getCostPerUnit();

        BigDecimal volume = e.getVolume().divide(BigDecimal.valueOf(1000));

       return cpu.multiply(volume);
        
    }

    @Override
    public void fillView() {

        var e = control.getEntitet();

        cmbPrinters.setSelectedItem(e.getPrinter());
        cmbParts.setSelectedItem(control.getEntitet().getPart());
        cmbMaterials.setSelectedItem(e.getMaterial());

        try {
            txtVolume.setText(df.format(e.getVolume()));
        } catch (Exception ex) {
            txtVolume.setText(df.format(0));
        }

        chkResult.setSelected(e.isResult());

        txtTime.setText(String.valueOf(e.getPrintTime()));

        

        try {
            lblCost.setText(df.format(cost()));

        } catch (Exception ex) {
            lblCost.setText(df.format(0));
        }

    }

    @Override
    public void fillModel() {

        var e = control.getEntitet();

        if (cmbPrinters.getSelectedIndex() == 0) {
            e.setPrinter(null);
        } else {
            e.setPrinter((Printer) cmbPrinters.getSelectedItem());
        }

        if (cmbParts.getSelectedIndex() == 0) {
            e.setPart(null);
        } else {
            e.setPart((Part) cmbParts.getSelectedItem());
        }

        if (cmbMaterials.getSelectedIndex() == 0) {
            e.setMaterial(null);
        } else {
            e.setMaterial((Material) cmbMaterials.getSelectedItem());
        }

        try {
            e.setVolume(BigDecimal.valueOf(Double.parseDouble(txtVolume.getText())));
        } catch (Exception ex) {
            e.setVolume(BigDecimal.ZERO);
        }
        
        try {
            e.setCost(cost());
        } catch (Exception ex) {
            e.setCost(BigDecimal.ZERO);
        }

        try {
            e.setPrintTime(Integer.valueOf(txtTime.getText()));
        } catch (Exception ex) {
            e.setPrintTime(0);
        }

        e.setResult(chkResult.isSelected());

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
        lstData = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        cmbParts = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbPrinters = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbMaterials = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtVolume = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        chkResult = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblCost = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cmbShowPrints = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstData.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDataValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstData);

        jLabel1.setText("Part:");

        jLabel2.setText("Printer:");

        jLabel3.setText("Resin:");

        cmbMaterials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMaterialsActionPerformed(evt);
            }
        });

        jLabel4.setText("Volume");

        jLabel5.setText("mL");

        chkResult.setText("Result");

        jLabel6.setText("Print time:");

        jLabel7.setText("min");

        lblCost.setText("Cost:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel8.setText("Cost (€):");

        cmbShowPrints.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Show all prints", "Show successful prints", "Show failed prints" }));
        cmbShowPrints.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbShowPrints.setName(""); // NOI18N
        cmbShowPrints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbShowPrintsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(cmbShowPrints, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(cmbParts, 0, 121, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(cmbPrinters, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbMaterials, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTime, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVolume, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(chkResult))
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCost, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbParts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbShowPrints, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbPrinters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMaterials, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(chkResult))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCost)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnEdit)
                            .addComponent(btnDelete))
                        .addContainerGap(67, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        control.setEntitet(new PrintJob());
        fillModel();
        try {
            control.create();
            load();
        } catch (PrintAppException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getMessage());
        }
        
        

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        if (lstData.getSelectedValue() == null) {
            return;
        }

        var e = lstData.getSelectedValue();
        control.setEntitet(e);

        fillModel();
        try {
            control.update();
            load();
        } catch (PrintAppException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getMessage());
        }

        control.refresh();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (lstData.getSelectedValue() == null) {
            return;
        }

        var e = lstData.getSelectedValue();

        if (JOptionPane.showConfirmDialog(getRootPane(),
                "Are you sure you want to delete this print job ", "Delete print job?",
                JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            control.delete();
            load();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cmbMaterialsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMaterialsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMaterialsActionPerformed

    private void lstDataValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstDataValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }
        if (lstData.getSelectedValue() == null) {
            return;
        }
        control.setEntitet(lstData.getSelectedValue());

        fillView();
    }//GEN-LAST:event_lstDataValueChanged

    private void cmbShowPrintsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbShowPrintsActionPerformed

        switch (cmbShowPrints.getSelectedIndex()) {
            case 0:
                DefaultListModel<PrintJob> p = new DefaultListModel<>();
                p.addAll(control.read());
                lstData.setModel(p);
                lstData.repaint();
                break;
            case 1:
                DefaultListModel<PrintJob> m = new DefaultListModel<>();
                m.addAll(control.readBySuccessfulPrint());
                lstData.setModel(m);
                lstData.repaint();
                break;
            case 2:
                DefaultListModel<PrintJob> n = new DefaultListModel<>();
                n.addAll(control.readByFailedPrint());
                lstData.setModel(n);
                lstData.repaint();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_cmbShowPrintsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JCheckBox chkResult;
    private javax.swing.JComboBox<Material> cmbMaterials;
    private javax.swing.JComboBox<Part> cmbParts;
    private javax.swing.JComboBox<Printer> cmbPrinters;
    private javax.swing.JComboBox<String> cmbShowPrints;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCost;
    private javax.swing.JList<PrintJob> lstData;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtVolume;
    // End of variables declaration//GEN-END:variables
}
