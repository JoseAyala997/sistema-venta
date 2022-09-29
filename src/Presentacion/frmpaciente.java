/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vpacientes;
import Logica.LOcultarColumna;
import Logica.StyloTabla;
import Logica.fpacientes;
import static Presentacion.frmventas.x;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Ayala
 */
public class frmpaciente extends javax.swing.JInternalFrame implements KeyListener {

    public static String x;

    public frmpaciente() {
        initComponents();
        //codigo para centrar internalframe
        x = "x";
        int a = frmprincipal.jDesktopPane2.getWidth() - this.getWidth();
        int b = frmprincipal.jDesktopPane2.getHeight() - this.getHeight();
        setLocation(a / 2, b / 2);
        setVisible(true);

        mostrar("");
        inhabilitar();
        jPanel1.setBackground(new Color(0, 102, 100, 200));
        jPanel2.setBackground(new Color(0, 102, 100, 200));

        StyloTabla st = new StyloTabla();

        LOcultarColumna.modjtable(tablalistado);
        eventos();
    }
    private String accion = "guardar";

    void ocultar_columnas() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    void inhabilitar() {
        txtidpersona.setVisible(false);

        txtnombre.setEnabled(false);
        txtapellido.setEnabled(false);
        txtn_documento.setEnabled(false);
        txttelefono.setEnabled(false);
        txtdireccion.setEnabled(false);
        cmbgenero.setEnabled(false);

        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
        btneliminar.setEnabled(false);

        txtidpersona.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtn_documento.setText("");
        txttelefono.setText("");
        txtdireccion.setText("");

    }

    void habilitar() {
        txtidpersona.setVisible(false);

        txtnombre.setEnabled(true);
        txtapellido.setEnabled(true);
        txtn_documento.setEnabled(true);
        txttelefono.setEnabled(true);
        txtdireccion.setEnabled(true);
        cmbgenero.setEnabled(true);

        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true);
        btneliminar.setEnabled(true);

        txtidpersona.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtn_documento.setText("");
        txttelefono.setText("");
        txtdireccion.setText("");

    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fpacientes func = new fpacientes();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Registros: " + Integer.toString(func.totalregistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
    String dayString;
    int codigo;

    @Override
    public void keyPressed(KeyEvent ke) {
        codigo = ke.getKeyCode();
        switch (codigo) {
            case 112:
                dayString = "f1";
                nuevo();
                break;

            case 113:
                dayString = "f2";
                guardar();
                break;

            case 114:
                dayString = "f3";
                break;

            case 115:
                dayString = "f4";
                break;

            case 116:
                dayString = "f5";
                break;

            case 117:
                dayString = "f6";
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    void nuevo() {
        habilitar();
        btnguardar.setText("Guardar");
        accion = "guardar";
        txtnombre.requestFocus();
    }

    void guardar() {
        if (txtnombre.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un Nombre para el Cliente");
            txtnombre.requestFocus();
            return;
        }
        if (txtapellido.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un apellido para el Cliente");
            txtapellido.requestFocus();
            return;
        }

        if (txtn_documento.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un Número de Documento para el Cliente");
            txtn_documento.requestFocus();
            return;
        }

        if (txttelefono.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un telefono para el Cliente");
            txttelefono.requestFocus();
            return;
        }

        vpacientes dts = new vpacientes();
        fpacientes func = new fpacientes();

        dts.setNombre(txtnombre.getText());

        dts.setApellido(txtapellido.getText());
        dts.setNumDocumento(txtn_documento.getText());
        dts.setTelefono(txttelefono.getText());
        dts.setDireccion(txtdireccion.getText());
        int seleccionado = cmbgenero.getSelectedIndex();
        dts.setGenero((String) cmbgenero.getItemAt(seleccionado));

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Cliente fue registrado satisfactoriamente");
                mostrar("");
                inhabilitar();

            }

        } else if (accion.equals("editar")) {
            dts.setIdpersona(Integer.parseInt(txtidpersona.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Cliente fue Editado satisfactoriamente");
                mostrar("");
                inhabilitar();
            }
        }
    }

    void eventos() {
        btncancelar.addKeyListener(this);
        btneliminar.addKeyListener(this);
        btnguardar.addKeyListener(this);
        btnnuevo.addKeyListener(this);
        cmbgenero.addKeyListener(this);

        jScrollPane1.addKeyListener(this);
        tablalistado.addKeyListener(this);
        txtapellido.addKeyListener(this);
        txtbuscar.addKeyListener(this);
        txtdireccion.addKeyListener(this);
        txtidpersona.addKeyListener(this);
        txtn_documento.addKeyListener(this);
        txtnombre.addKeyListener(this);
        txttelefono.addKeyListener(this);
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
        txtidpersona = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtn_documento = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        cmbgenero = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        lbltotalregistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btneliminar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Clientes"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtidpersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 35, 33, 30));
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 76, 161, 30));
        jPanel1.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 161, 30));
        jPanel1.add(txtn_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 161, 30));
        jPanel1.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 161, 30));
        jPanel1.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 161, 30));

        cmbgenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO\t", "FEMENINO" }));
        jPanel1.add(cmbgenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 161, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("N. Docu.:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Apellido:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Telefono:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Direccion:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Genero:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Nombre:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 76, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 570));

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablalistado.getTableHeader().setResizingAllowed(false);
        tablalistado.getTableHeader().setReorderingAllowed(false);
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablalistado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 648, 313));

        lbltotalregistros.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbltotalregistros.setText("REGISTROS");
        getContentPane().add(lbltotalregistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, 230, 26));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btneliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar1.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btneliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 16, 95, -1));

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar1.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 16, 97, -1));

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardar1.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 16, 95, -1));

        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevocopia.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnnuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 16, 95, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("F2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 95, -1, 19));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("F1");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 95, -1, 19));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 450, 670, 120));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Genero:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 65, 220, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Buscar:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 65, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        btnguardar.setText("Editar");
        habilitar();
        btneliminar.setEnabled(true);
        accion = "editar";

        int fila = tablalistado.rowAtPoint(evt.getPoint());

        txtidpersona.setText(tablalistado.getValueAt(fila, 0).toString());
        txtnombre.setText(tablalistado.getValueAt(fila, 1).toString());

        txtapellido.setText(tablalistado.getValueAt(fila, 2).toString());
        txtn_documento.setText(tablalistado.getValueAt(fila, 3).toString());
        txttelefono.setText(tablalistado.getValueAt(fila, 4).toString());
        txtdireccion.setText(tablalistado.getValueAt(fila, 5).toString());
        cmbgenero.setSelectedItem(tablalistado.getValueAt(fila, 6).toString());


    }//GEN-LAST:event_tablalistadoMouseClicked

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        if (!txtidpersona.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar el Cliente?", "Confirmar", 2);

            if (confirmacion == 0) {
                fpacientes func = new fpacientes();
                vpacientes dts = new vpacientes();

                dts.setIdpersona(Integer.parseInt(txtidpersona.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();

            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        inhabilitar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        mostrar(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmpaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmpaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmpaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmpaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmpaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    public static javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> cmbgenero;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtidpersona;
    private javax.swing.JTextField txtn_documento;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
