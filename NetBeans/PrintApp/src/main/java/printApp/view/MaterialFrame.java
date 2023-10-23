/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package printApp.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import printApp.controller.MaterialController;
import printApp.model.Material;
import printApp.util.PrintAppException;

/**
 *
 * @author AMD
 */
public class MaterialFrame extends javax.swing.JFrame implements ViewInterface {

    private MaterialController control;
    private DecimalFormat df;

    /**
     * Creates new form MaterialForm
     */
    public MaterialFrame() {
        initComponents();

        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.of("en", "EN"));
        df = new DecimalFormat("####.##", dfs);

        setTitle("Resins");
        control = new MaterialController();

        load();

    }

    @Override
    public void load() {
        DefaultListModel<Material> m = new DefaultListModel<>();
        m.addAll(control.read());
        lstData.setModel(m);
        lstData.repaint();

    }

    @Override
    public void fillModel() {
        var e = control.getEntitet();
        e.setMaterialName(txtName.getText());
        e.setManufacturer(txtManufacturer.getText());

        try {
            e.setLayerHeight(BigDecimal.valueOf(Double.parseDouble(txtLayerHeight.getText())));

        } catch (Exception ex) {
            e.setLayerHeight(BigDecimal.ZERO);
        }

        try {
            e.setLiftDistance(Integer.valueOf(txtLiftDistance.getText()));
        } catch (Exception ex) {
            e.setLiftDistance(0);
        }

        try {
            e.setLiftSpeed(BigDecimal.valueOf(Double.parseDouble(txtLiftSpeed.getText())));
        } catch (Exception ex) {
            e.setLiftSpeed(BigDecimal.ZERO);
        }

        try {
            e.setLightOffDelay(BigDecimal.valueOf(Double.parseDouble(txtLightOffDelay.getText())));
        } catch (Exception ex) {
            e.setLightOffDelay(BigDecimal.ZERO);
        }

        try {
            e.setRetractSpeed(BigDecimal.valueOf(Double.parseDouble(txtRetractSpeed.getText())));
        } catch (Exception ex) {
            e.setRetractSpeed(BigDecimal.ZERO);
        }

        //slati BigDecimal.ZERO preko preko parseDouble 
        try {
//          ovo izbacuje iz edita
//          e.setCalibratedExposure(BigDecimal.valueOf(df.parse(txtCalibratedExposure.getText()).doubleValue()));
            e.setCalibratedExposure(BigDecimal.valueOf(Double.parseDouble(txtCalibratedExposure.getText())));
        } catch (Exception ex) {
            e.setCalibratedExposure(BigDecimal.ZERO);
        }

        try {
            e.setBottomExposure(BigDecimal.valueOf(Double.parseDouble(txtBottomExposure.getText())));
        } catch (Exception ex) {
            e.setBottomExposure(BigDecimal.ZERO);
        }              
        
        try {
            e.setBottomLiftSpeed(BigDecimal.valueOf(Double.parseDouble(txtBottomLiftSpeed.getText())));
        } catch (Exception ex) {
            e.setBottomLiftSpeed(BigDecimal.ZERO);
        }
        
        try {
            e.setBottomLiftDistance(Integer.valueOf(txtBottomLiftDistance.getText()));
        } catch (Exception ex) {
            e.setBottomLiftDistance(0);
        }
        try {
            e.setBottomRetractSpeed(BigDecimal.valueOf(Double.parseDouble(txtBottomRetractSpeed.getText())));
        } catch (Exception ex) {
            e.setBottomRetractSpeed(BigDecimal.ZERO);
        }

        try {
            e.setCostPerUnit(BigDecimal.valueOf(Double.parseDouble(txtCost.getText())));
        } catch (Exception ex) {
            e.setCostPerUnit(BigDecimal.ZERO);
        }
    }

    @Override
    public void fillView() {

        var e = control.getEntitet();

        txtName.setText(e.getMaterialName());
        txtManufacturer.setText(e.getManufacturer());

        try {
            txtLayerHeight.setText(df.format(e.getLayerHeight()));
        } catch (Exception ex) {
            txtLayerHeight.setText(df.format(0));
        }

        try {
            txtLiftDistance.setText(df.format(e.getLiftDistance()));
        } catch (Exception ex) {
            txtLiftDistance.setText(df.format(0));
        }

        try {
            txtLiftSpeed.setText(df.format(e.getLiftSpeed()));
        } catch (Exception ex) {
            txtLiftSpeed.setText(df.format(0));
        }

        try {
            txtLightOffDelay.setText(df.format(e.getLightOffDelay()));
        } catch (Exception ex) {
            txtLightOffDelay.setText(df.format(0));
        }

        try {
            txtRetractSpeed.setText(df.format(e.getRetractSpeed()));
        } catch (Exception ex) {
            txtRetractSpeed.setText(df.format(0));
        }

        try {
            txtCalibratedExposure.setText(df.format(e.getCalibratedExposure()));
        } catch (Exception ex) {
            txtCalibratedExposure.setText(df.format(0));
        }
        try {
            txtBottomExposure.setText(df.format(e.getBottomExposure()));
        } catch (Exception ex) {
            txtBottomExposure.setText(df.format(0));
        }
        try {
            txtBottomLiftDistance.setText(df.format(e.getBottomLiftDistance()));
        } catch (Exception ex) {
            txtBottomLiftDistance.setText(df.format(0));
        }
        try {
            txtBottomLiftSpeed.setText(df.format(e.getBottomLiftSpeed()));
        } catch (Exception ex) {
            txtBottomLiftSpeed.setText(df.format(0));
        }
        try {
            txtBottomRetractSpeed.setText(df.format(e.getBottomRetractSpeed()));
        } catch (Exception ex) {
            txtBottomRetractSpeed.setText(df.format(0));
        }
        try {
            txtCost.setText(df.format(e.getCostPerUnit()));
        } catch (Exception ex) {
            txtCost.setText(df.format(0));
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
        lstData = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtManufacturer = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLayerHeight = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLiftDistance = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtLiftSpeed = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtLightOffDelay = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtRetractSpeed = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCalibratedExposure = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtBottomExposure = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtBottomLiftSpeed = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtBottomLiftDistance = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtBottomRetractSpeed = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCost = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstData.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDataValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstData);

        jLabel1.setText("Resin name:");

        txtName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel2.setText("Manufacturer:");

        txtManufacturer.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setText("Layer height:");

        txtLayerHeight.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel4.setText("Lift distance:");

        txtLiftDistance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel5.setText("Lift speed:");

        txtLiftSpeed.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel6.setText("Light off delay:");

        txtLightOffDelay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel7.setText("Retract speed:");

        txtRetractSpeed.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel8.setText("Calibrated exposure:");

        txtCalibratedExposure.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel9.setText("Bottom exposure:");

        txtBottomExposure.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel10.setText("Bottom lift speed:");

        txtBottomLiftSpeed.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel11.setText("Bottom lift distance:");

        txtBottomLiftDistance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel12.setText("Bottom retract speed:");

        txtBottomRetractSpeed.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel13.setText("Cost:");

        txtCost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel14.setText("€/L");

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

        jLabel15.setText("µm");

        jLabel16.setText("mm");

        jLabel17.setText("mm/s");

        jLabel18.setText("s");

        jLabel19.setText("mm/s");

        jLabel20.setText("s");

        jLabel21.setText("s");

        jLabel22.setText("mm/s");

        jLabel23.setText("mm");

        jLabel24.setText("mm/s");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(43, 54, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtLiftDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtLayerHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtLightOffDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtLiftSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17)))
                                .addGap(24, 35, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCalibratedExposure, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel20))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(txtBottomExposure, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel21))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addComponent(txtRetractSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)
                                        .addComponent(txtBottomLiftSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel12)
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(14, 14, 14)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel14)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtBottomLiftDistance)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(txtBottomRetractSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel24))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtLayerHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtLiftDistance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel17)
                            .addComponent(txtLiftSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLightOffDelay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtRetractSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCalibratedExposure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBottomExposure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtBottomLiftSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtBottomLiftDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBottomRetractSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAdd)
                                    .addComponent(btnEdit)
                                    .addComponent(btnDelete)))
                            .addComponent(jLabel12))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(88, 88, 88))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

        control.setEntitet(new Material());
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
                "Are you sure you want to delete resin: \n\n" + e.getMaterialName(),
                "Delete resin?",
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Material> lstData;
    private javax.swing.JTextField txtBottomExposure;
    private javax.swing.JTextField txtBottomLiftDistance;
    private javax.swing.JTextField txtBottomLiftSpeed;
    private javax.swing.JTextField txtBottomRetractSpeed;
    private javax.swing.JTextField txtCalibratedExposure;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtLayerHeight;
    private javax.swing.JTextField txtLiftDistance;
    private javax.swing.JTextField txtLiftSpeed;
    private javax.swing.JTextField txtLightOffDelay;
    private javax.swing.JTextField txtManufacturer;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtRetractSpeed;
    // End of variables declaration//GEN-END:variables
}
