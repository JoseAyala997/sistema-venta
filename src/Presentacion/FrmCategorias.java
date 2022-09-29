/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vcategoria;
import Logica.LOcultarColumna;
import Logica.StyloTabla;
import Logica.fcategoria;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Ayala
 */
public class FrmCategorias extends javax.swing.JInternalFrame implements KeyListener {

    Fondopanel fondo = new Fondopanel();//declaramos una variable de tipo panel llamada fondo
    public static String x;

    public FrmCategorias() {
        this.setContentPane(fondo);//establecemos la imagen solo al jframe
        initComponents();

        //codigo para centrar internalframe
        x = "x";
        int a = frmprincipal.jDesktopPane2.getWidth() - this.getWidth();
        int b = frmprincipal.jDesktopPane2.getHeight() - this.getHeight();
        setLocation(a / 2, b / 2);
        setVisible(true);

        mostrar("");
        cancelar();

//        jPanel1.setBackground(new Color(0, 102, 100, 200));
//        jPanel2.setBackground(new Color(0, 102, 100, 200));
//        panelboton2.setBackground(new Color(0, 102, 100, 200));
        StyloTabla st = new StyloTabla();

        setSize(640, 608);
        setTitle("Categorías");
        LOcultarColumna.modjtable(tablalistado);
        eventos();
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
               nuevoRegistro();
                break;

            case 113:
                dayString = "f2";
               guardarRegistro();
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
//        JOptionPane.showConfirmDialog(null, dayString + " cod: " + codigo);
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    void eventos() {

        btneliminar.addKeyListener(this);
        btninsertar.addKeyListener(this);
        btnnuevo.addKeyListener(this);
        panelboton2.addKeyListener(this);
        tablalistado.addKeyListener(this);
        txtbuscar.addKeyListener(this);
        txtcategoria.addKeyListener(this);
        txtid.addKeyListener(this);

    }

    void nuevo() {

        txtcategoria.setEnabled(true);

        txtid.setVisible(false);

        btneliminar.setEnabled(true);

        btncancelar.setEnabled(true);

        btninsertar.setEnabled(true);

        txtcategoria.setText("");

        txtid.setText("");

        txtcategoria.setText("");
    }

    void cancelar() {
        txtid.setVisible(false);

        txtcategoria.setEnabled(false);

        btneliminar.setEnabled(false);

        btncancelar.setEnabled(false);

        btninsertar.setEnabled(false);

        txtcategoria.setText("");

        txtid.setText("");

        txtcategoria.setText("");
    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;

            fcategoria Funcion = new fcategoria();

            modelo = Funcion.mostrar(buscar);

            int total = Funcion.TotalRegistros;
            lbltotalregistros.setText("Total Registros : " + String.valueOf(total));
            tablalistado.setModel(modelo);

        } catch (Exception e) {
        }

    }
    void nuevoRegistro(){
         nuevo();
        btninsertar.setText("Guardar");
        accion = "guardar";
        txtcategoria.requestFocus();
    }
    void guardarRegistro(){
         if (txtcategoria.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR EL NOMBRE DE LA CATEGORIA");
            txtcategoria.requestFocus();
            return;
        }

        vcategoria dts = new vcategoria();
        fcategoria func = new fcategoria();

        dts.setCategoria(txtcategoria.getText());

        if (accion.equals("guardar")) {
            func.insertar(dts);
            JOptionPane.showMessageDialog(this, "CATEGORIA REGISTRADA CORRECTAMENTE");
            mostrar("");

        }
        if (accion.equals("Editar")) {

            dts.setIdcategorias(Integer.parseInt(txtid.getText()));
            func.editar(dts);
            JOptionPane.showMessageDialog(this, "CATEGORIA EDITADA CORRECTAMENTE");
            mostrar("");

        }
        cancelar();
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
        jLabel8 = new javax.swing.JLabel();
        txtcategoria = new javax.swing.JTextField();
        txtbuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        lbltotalregistros = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        panelboton2 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btninsertar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();

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
        jPanel1.setForeground(new java.awt.Color(0, 153, 153));
        jPanel1.setToolTipText("");

        jLabel8.setText("Nombre Categoría");

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        jLabel2.setText("BUSCAR POR CODIGO O POR NOMBRE");

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

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

        lbltotalregistros.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbltotalregistros.setText("jLabel9");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setText("CATEGORIAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(66, 66, 66)
                                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2)
                                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lbltotalregistros)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 580));

        panelboton2.setBackground(new java.awt.Color(0, 102, 102));
        panelboton2.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));
        panelboton2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        panelboton2.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 65, 89, -1));

        btninsertar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btninsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardar1.png"))); // NOI18N
        btninsertar.setText("Guardar");
        btninsertar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btninsertar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btninsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertarActionPerformed(evt);
            }
        });
        panelboton2.add(btninsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 181, -1, -1));

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
        panelboton2.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 449, -1, -1));

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
        panelboton2.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 307, 89, -1));

        getContentPane().add(panelboton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 150, 580));

        setBounds(0, 0, 643, 608);
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        mostrar(txtbuscar.getText()); // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarKeyTyped

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        accion = "Editar";
        btninsertar.setText("Editar");
        nuevo();
        try {
            int fila = tablalistado.rowAtPoint(evt.getPoint());
            txtid.setText(tablalistado.getValueAt(fila, 0).toString());
            txtcategoria.setText(tablalistado.getValueAt(fila, 1).toString());

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tablalistadoMouseClicked
    private String accion = "guardar";

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        nuevoRegistro();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btninsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertarActionPerformed
       guardarRegistro();
    }//GEN-LAST:event_btninsertarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        if (!txtid.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar este servicio?", "Confirmar", 2);

            if (confirmacion == 0) {
                fcategoria func = new fcategoria();
                vcategoria dts = new vcategoria();

                dts.setIdcategorias(Integer.parseInt(txtid.getText()));
                func.eliminar(dts);
                mostrar("");
                cancelar();

            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCategorias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btninsertar;
    public static javax.swing.JButton btnnuevo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JPanel panelboton2;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcategoria;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
class Fondopanel extends JPanel {

//        private Image imagen;//se declara una variable
//
//        @Override
//        public void paint(Graphics g) {
//            imagen = new ImageIcon(getClass().getResource("/Iconos/icononutricion.jpg")).getImage();//selecciona el paquete y la imagen que se quiere usar
//            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);//obtiene el tamaño del panel para ajustar la imagen
//            setOpaque(false);//sirve para que se vea la imagen
//            super.paint(g);//para mostrar todos los componentes del panel que estan estableci
//        }
    }
}
