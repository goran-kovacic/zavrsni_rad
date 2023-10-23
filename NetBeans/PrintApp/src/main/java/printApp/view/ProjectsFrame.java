/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package printApp.view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import printApp.controller.ProjectController;
import printApp.model.Part;
import printApp.model.Project;
import printApp.util.PrintAppException;
import printApp.util.Util;

/**
 *
 * @author AMD
 */
public class ProjectsFrame extends javax.swing.JFrame implements ViewInterface {

    private ProjectController control;
    private DecimalFormat df;

    /**
     * Creates new form ProjectsFrame
     */
    public ProjectsFrame() {
        initComponents();

        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.of("en", "EN"));
        df = new DecimalFormat("###,##0.00", dfs);

        setTitle(Util.APP_NAME + " | Projects");
        control = new ProjectController();

        inputCreationDate();
        inputCompletionDate();

        load();
    }

    private void inputCreationDate() {

        DatePickerSettings dps = new DatePickerSettings(Locale.of("en", "EN"));
        // dps.setFormatForDatesCommonEra("dd. MM. YYYY.");
        // dps.setTranslationClear("Ocisti");
        // dps.setTranslationToday("danas");   

        dpCreationDate.setSettings(dps);
    }

    private void inputCompletionDate() {
        DatePickerSettings dps = new DatePickerSettings(Locale.of("en", "EN"));

        dpCompletionDate.setSettings(dps);

    }
    
    @Override
    public void load() {
        DefaultListModel<Project> p = new DefaultListModel<>();
        p.addAll(control.read());
        lstData.setModel(p);
        lstData.repaint();
    }

    @Override
    public void fillView() {

        var e = control.getEntitet();

        txtName.setText(e.getProjectName());
        chkCompleted.setSelected(e.isCompleted());

        txtDescription.setText(e.getProjectDescription());

        if (e.getCreationDate() == null) {
            dpCreationDate.setDate(null);
        } else {
            LocalDate ld = e.getCreationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            dpCreationDate.setDate(ld);
        }

        if (e.getCompletionDate() == null) {
            dpCompletionDate.setDate(null);
        } else {
            LocalDate ld = e.getCompletionDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            dpCompletionDate.setDate(ld);
        }

        try {
            lblTotalCost.setText(df.format(e.getTotalCost()));
        } catch (Exception ex) {
            lblTotalCost.setText(df.format(0));
        }

        lblPrintTime.setText(String.valueOf(e.getTotalPrintTime() != null ? (e.getTotalPrintTime()) : "0"));

        lblPrintCount.setText(String.valueOf(e.getTotalPrintCount() == null ? "0" : e.getTotalPrintCount()));

    }

    @Override
    public void fillModel() {

        var e = control.getEntitet();

        e.setProjectName(txtName.getText());

        if (dpCreationDate.getDate() == null) {
            e.setCreationDate(null);
        } else {

            LocalDate ld = dpCreationDate.getDate();
            LocalTime lt = LocalTime.now();
            LocalDateTime ldt = LocalDateTime.of(ld, lt);

            e.setCreationDate(Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant()));

        }

        if (dpCompletionDate.getDate() == null) {
            e.setCompletionDate(null);
        } else {

            LocalDate ld2 = dpCompletionDate.getDate();
            LocalTime lt2 = LocalTime.now();
            LocalDateTime ldt2 = LocalDateTime.of(ld2, lt2);

            e.setCompletionDate(Date.from(ldt2.atZone(ZoneId.systemDefault()).toInstant()));
        }

        e.setCompleted(chkCompleted.isSelected());

        e.setProjectDescription(txtDescription.getText());

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
        txtName = new javax.swing.JTextField();
        chkCompleted = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTotalCost = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblPrintCount = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblPrintTime = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();
        dpCreationDate = new com.github.lgooddatepicker.components.DatePicker();
        jLabel9 = new javax.swing.JLabel();
        dpCompletionDate = new com.github.lgooddatepicker.components.DatePicker();
        tglCompleted = new javax.swing.JToggleButton();
        btnDelete1 = new javax.swing.JButton();
        btnDelete2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstData.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDataValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstData);

        jLabel1.setText("Project name");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        chkCompleted.setText("Completed");

        jLabel2.setText("Description:");

        jLabel3.setText("Total cost:");

        lblTotalCost.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel5.setText("€");

        jLabel4.setText("Total print count:");

        lblPrintCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel6.setText("Total print time:");

        lblPrintTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel7.setText("hours");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txtDescription);

        jLabel8.setText("Creation date");

        jLabel9.setText("Completion date");

        tglCompleted.setText("Show unfinished / Show all");
        tglCompleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglCompletedActionPerformed(evt);
            }
        });

        btnDelete1.setText("Del. only project");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        btnDelete2.setText("Del. project and parts");
        btnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(tglCompleted, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblPrintCount, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(9, 9, 9)
                                    .addComponent(lblTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(4, 4, 4)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dpCompletionDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblPrintTime, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7))
                                    .addComponent(dpCreationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDelete1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkCompleted)
                    .addComponent(tglCompleted))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(lblTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrintCount, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrintTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(dpCreationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dpCompletionDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnEdit)
                            .addComponent(btnDelete))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete1)
                            .addComponent(btnDelete2))
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

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

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        control.setEntitet(new Project());
        fillModel();
        try {
            control.create();
            load();
        } catch (PrintAppException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getMessage());
        }


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (lstData.getSelectedValue() == null) {
            return;
        }
        Object[] buttons = {"Delete only project", "Delete projects and parts", "Cancel"};

        var e = lstData.getSelectedValue();

        switch (JOptionPane.showOptionDialog(getRootPane(),
                "Delete project and parts or only project ",
                "Delete",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons, null)) {

            case JOptionPane.YES_OPTION:
                control.setEntitet(e);

                try {
                    control.delete();
                    load();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(getRootPane(), ex.getMessage());
                }

            case JOptionPane.NO_OPTION:
                control.setEntitet(e);
                try {
                    control.deleteProjectPartPrintJob();
                    load();
                } catch (Exception ex) {
                }
                
            case JOptionPane.CANCEL_OPTION:
                return;
                

        }
        
        load();
        


    }//GEN-LAST:event_btnDeleteActionPerformed

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

    private void tglCompletedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglCompletedActionPerformed
        if (tglCompleted.isSelected()) {
            DefaultListModel<Project> p = new DefaultListModel<>();
            p.addAll(control.readByCompleted());
            lstData.setModel(p);
            lstData.repaint();
        } else {
            load();
        }


    }//GEN-LAST:event_tglCompletedActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        if (lstData.getSelectedValue() == null) {
            return;
        }
        var e = lstData.getSelectedValue();

        if (JOptionPane.showConfirmDialog(getRootPane(),
                "Are you sure you want to delete project: \n\n" + e.getProjectName(),
                "Delete project?",
                JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }
        
        try {
            control.delete();
            load();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getMessage());
        }
        
        
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete2ActionPerformed
       if (lstData.getSelectedValue() == null) {
            return;
        }
        var e = lstData.getSelectedValue();
        
        StringBuilder sb = new StringBuilder();
        sb.append("Are you sure you want to delete project and associated parts: \n");
        try {
            for(Part p : control.getEntitet().getParts()){
            sb.append(p.getPartName());
            sb.append("\n");
            
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getMessage());
        }
        
        
        sb.append("");
        
        if (JOptionPane.showConfirmDialog(getRootPane(),
                sb,
                "Delete project?",
                JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }
        
        try {
            control.deleteProjectPartPrintJob();
            load();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getMessage());
        }
        
    }//GEN-LAST:event_btnDelete2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnDelete2;
    private javax.swing.JButton btnEdit;
    private javax.swing.JCheckBox chkCompleted;
    private com.github.lgooddatepicker.components.DatePicker dpCompletionDate;
    private com.github.lgooddatepicker.components.DatePicker dpCreationDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPrintCount;
    private javax.swing.JLabel lblPrintTime;
    private javax.swing.JLabel lblTotalCost;
    private javax.swing.JList<Project> lstData;
    private javax.swing.JToggleButton tglCompleted;
    private javax.swing.JTextPane txtDescription;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
