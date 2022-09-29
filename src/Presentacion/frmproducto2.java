/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Datos.vproductos;
import Logica.LOcultarColumna;
import Logica.fproductos;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Ayala
 */
public class frmproducto2 extends javax.swing.JInternalFrame {

    public static String x;
    DecimalFormat formatea = new DecimalFormat();

    public frmproducto2() {
        initComponents();

        centrar();
        mostrar("");
        cancelar();

        txtid.setVisible(false);
//        txtpulgadas.setText("0");

//        jPanel1.setBackground(new Color(0, 102, 100, 200));
//        jPanel2.setBackground(new Color(0, 102, 100, 200));
//        panelboton2.setBackground(new Color(0, 102, 100, 200));

//        StyloTabla st = new StyloTabla();
//        st.stylotabla(tablalistado);
        setSize(1331, 650);
        setTitle("PRODUCTOS");
        
        LOcultarColumna.modjtable(tablalistado);
    }

    void ocultar_columna() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(1).setMaxWidth(250);
        tablalistado.getColumnModel().getColumn(1).setMinWidth(250);
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(250);

        tablalistado.getColumnModel().getColumn(2).setMaxWidth(250);
        tablalistado.getColumnModel().getColumn(2).setMinWidth(250);
        tablalistado.getColumnModel().getColumn(2).setPreferredWidth(250);

        tablalistado.getColumnModel().getColumn(3).setMaxWidth(85);
        tablalistado.getColumnModel().getColumn(3).setMinWidth(250);
        tablalistado.getColumnModel().getColumn(3).setPreferredWidth(100);

        tablalistado.getColumnModel().getColumn(4).setMaxWidth(100);
        tablalistado.getColumnModel().getColumn(4).setMinWidth(250);
        tablalistado.getColumnModel().getColumn(4).setPreferredWidth(100);

        tablalistado.getColumnModel().getColumn(5).setMaxWidth(110);
        tablalistado.getColumnModel().getColumn(5).setMinWidth(250);
        tablalistado.getColumnModel().getColumn(5).setPreferredWidth(110);

        tablalistado.getColumnModel().getColumn(6).setMaxWidth(80);
        tablalistado.getColumnModel().getColumn(6).setMinWidth(250);
        tablalistado.getColumnModel().getColumn(6).setPreferredWidth(110);

        tablalistado.getColumnModel().getColumn(7).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(7).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(7).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(8).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(8).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(8).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(11).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(11).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(11).setPreferredWidth(0);

    }

    void centrar() {
        //codigo para centrar internalframe
        x = "x";
        int a = frmprincipal.jDesktopPane2.getWidth() - this.getWidth();
        int b = frmprincipal.jDesktopPane2.getHeight() - this.getHeight();
        setLocation(a / 2, b / 2);
        setVisible(true);
    }



    String acceso;

    void nuevo() {
        acceso = frmprincipal.lblacceso.getText();
        if (acceso.equals("ADMINISTRADOR")) {
            txtproducto.setEnabled(true);
            txtdescripcion.setEnabled(true);
            txtprecio_costo.setEnabled(true);
            txtprecio_mayor.setEnabled(true);
            txtprecio.setEnabled(true);
            txtcantidadstock.setEnabled(true);
            txtcategoria.setEnabled(true);
            txtpulgadas.setVisible(false);
            txtid.setVisible(false);
            txtidcategoria.setVisible(false);
            txtcategoria.setEnabled(false);
            txtidproveedor.setVisible(false);
            txtproveedor.setEnabled(false);

            btnbuscar.setEnabled(true);
            btneliminar.setEnabled(true);
            btncancelar.setEnabled(true);
            btninsertar.setEnabled(true);
            btnbuscar1.setEnabled(true);
//        cbocategoria.setSelectedIndex(0);0

            txtproducto.setText("");
            txtprecio.setText("");
            txtcantidadstock.setText("0");
            txtid.setText("");
            txtdescripcion.setText("");
            txtprecio_mayor.setText("");
            txtprecio_costo.setText("");
            txtpulgadas.setText("0");
            txtcategoria.setText("");
            txtidcategoria.setText("");
            txtidproveedor.setText("");
            txtproveedor.setText("");
        } else {
            txtproducto.setEnabled(true);
            txtdescripcion.setEnabled(true);
            txtprecio_costo.setEnabled(true);
            txtprecio_mayor.setEnabled(true);
            txtprecio.setEnabled(true);
            txtcantidadstock.setEnabled(false);
            txtcategoria.setEnabled(true);
            txtpulgadas.setVisible(false);
            txtid.setVisible(false);
            txtidcategoria.setVisible(false);
            txtcategoria.setEnabled(false);
            txtidproveedor.setVisible(false);
            txtproveedor.setEnabled(false);

            btnbuscar.setEnabled(true);
            btneliminar.setEnabled(true);
            btncancelar.setEnabled(true);
            btninsertar.setEnabled(true);
            btnbuscar1.setEnabled(true);
//        cbocategoria.setSelectedIndex(0);0

            txtproducto.setText("");
            txtprecio.setText("");
            txtcantidadstock.setText("0");
            txtid.setText("");
            txtdescripcion.setText("");
            txtprecio_mayor.setText("");
            txtprecio_costo.setText("");
            txtpulgadas.setText("0");
            txtcategoria.setText("");
            txtidcategoria.setText("");
            txtidproveedor.setText("");
            txtproveedor.setText("");
        }

    }

    void cancelar() {
        txtproducto.setEnabled(false);
        txtdescripcion.setEnabled(false);
        txtprecio_costo.setEnabled(false);
        txtprecio_mayor.setEnabled(false);
        txtprecio.setEnabled(false);
        txtcantidadstock.setEnabled(false);
        txtcategoria.setEnabled(false);
        txtpulgadas.setVisible(false);
        txtcategoria.setEnabled(false);
        txtid.setVisible(false);
        txtidcategoria.setVisible(false);
        txtidproveedor.setVisible(false);
        txtproveedor.setEnabled(false);

        btnbuscar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(false);
        btninsertar.setEnabled(false);
        btnbuscar1.setEnabled(false);
//        cbocategoria.setSelectedIndex(0);0

        txtproducto.setText("");
        txtprecio.setText("");
        txtcantidadstock.setText("0");
        txtid.setText("");
        txtdescripcion.setText("");
        txtprecio_mayor.setText("");
        txtprecio_costo.setText("");
        txtpulgadas.setText("0");
        txtcategoria.setText("");
        txtidcategoria.setText("");
    }
    
   
    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            for (int c = 0; c < tablalistado.getColumnCount(); c++) {

                Class<?> col_class = tablalistado.getColumnClass(c);

                tablalistado.setDefaultEditor(col_class, null); // remove editor
            }
            fproductos func = new fproductos();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            ocultar_columna();
            lbltotalregistros.setText("Total Registros: " + Integer.toString(func.TotalRegistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

//    void mostrar(String buscar) {
//        try {
//            DefaultTableModel modelo;
//
//            fproductos Funcion = new fproductos();
//
//            modelo = Funcion.mostrar(buscar);
//
//            int total = Funcion.TotalRegistros;
//
//            lbltotalregistros.setText("Total Registros : " + String.valueOf(total));
//
//            tablalistado.setModel(modelo);
//
//        } catch (Exception e) {
//        }
//
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelboton2 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btninsertar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtid = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtproducto = new javax.swing.JTextField();
        txtbuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        lbltotalregistros = new javax.swing.JLabel();
        txtcantidadstock = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        txtprecio_mayor = new javax.swing.JTextField();
        txtprecio_costo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtpulgadas = new javax.swing.JTextField();
        txtidcategoria = new javax.swing.JTextField();
        txtcategoria = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        txtidproveedor = new javax.swing.JTextField();
        btnbuscar1 = new javax.swing.JButton();
        txtproveedor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

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

        panelboton2.setBackground(new java.awt.Color(0, 102, 102));
        panelboton2.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));
        panelboton2.setToolTipText("");

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

        javax.swing.GroupLayout panelboton2Layout = new javax.swing.GroupLayout(panelboton2);
        panelboton2.setLayout(panelboton2Layout);
        panelboton2Layout.setHorizontalGroup(
            panelboton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelboton2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelboton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelboton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btninsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btncancelar))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelboton2Layout.setVerticalGroup(
            panelboton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelboton2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(btnnuevo)
                .addGap(39, 39, 39)
                .addComponent(btninsertar)
                .addGap(49, 49, 49)
                .addComponent(btneliminar)
                .addGap(65, 65, 65)
                .addComponent(btncancelar)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        getContentPane().add(panelboton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 0, 150, 620));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 41, -1));

        jLabel8.setText("PRODUCTO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, 20));
        jPanel1.add(txtproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 182, 30));

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
        });
        jPanel1.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 239, 310, 30));

        jLabel2.setText("BUSCAR POR  NOMBRE, DESCRIPCION O CATEGORIA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 219, 394, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 275, 1170, 283));

        lbltotalregistros.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbltotalregistros.setText("jLabel9");
        jPanel1.add(lbltotalregistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 564, 210, 20));
        jPanel1.add(txtcantidadstock, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 150, 30));

        jLabel3.setText("CANTIDAD STOCK");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, 20));

        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprecioKeyReleased(evt);
            }
        });
        jPanel1.add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 150, 30));

        jLabel4.setText("PRECIO UNT.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, -1, 20));

        jLabel5.setText("CATEGORIA");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 99, 20));
        jPanel1.add(txtdescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 284, 30));

        txtprecio_mayor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprecio_mayorKeyReleased(evt);
            }
        });
        jPanel1.add(txtprecio_mayor, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 150, 30));

        txtprecio_costo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprecio_costoKeyReleased(evt);
            }
        });
        jPanel1.add(txtprecio_costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 90, 150, 30));

        jLabel9.setText("PRECIO MAYOR");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, -1, 20));

        jLabel10.setText("DESCRIPCION");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, 20));

        jLabel11.setText("PRECIO COSTO");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 70, 138, 20));
        jPanel1.add(txtpulgadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 40, 30));
        jPanel1.add(txtidcategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 15, 30));
        jPanel1.add(txtcategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 150, 30));

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar1 - copia.png"))); // NOI18N
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 34, 30));
        jPanel1.add(txtidproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 150, 39, 30));

        btnbuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar1 - copia.png"))); // NOI18N
        btnbuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnbuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 150, 34, 30));
        jPanel1.add(txtproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, 150, 30));

        jLabel7.setText("PROVEEDOR");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 99, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setText("PRODUCTOS");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents
  private String accion = "guardar";
    private void txtidpersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidpersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidpersonaActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        nuevo();
        btninsertar.setText("Guardar");
        accion = "guardar";
        txtproducto.requestFocus();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btninsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertarActionPerformed
        if (txtproducto.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR EL NOMBRE PRODUCTO");
            txtproducto.requestFocus();
            return;
        }
        if (txtcantidadstock.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR LA CANTIDAD STOCK");
            txtcantidadstock.requestFocus();
            return;
        }
        if (txtprecio.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR EL PRECIO DEL PRODUCTO");
            txtprecio.requestFocus();
            return;
        }
        if (txtcategoria.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR LA CATEGORIA DEL PRODUCTO");
            txtcategoria.requestFocus();
            return;
        }
        if (txtproveedor.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR EL PROVEEDOR DEL PRODUCTO");
            txtproveedor.requestFocus();
            return;
        }
        vproductos dts = new vproductos();
        fproductos func = new fproductos();
//"INSERT INTO productos (nombre_producto, descripcion, precio_unitario, precio_mayor, precio_costo, stock, pulgadas, estado, idcategorias,idproveedor)"
        dts.setNombre_producto(txtproducto.getText());
        dts.setDescripcion(txtdescripcion.getText());
        dts.setPrecio_unitario(Long.parseLong(txtprecio.getText().replaceAll("\\.", "")));
        dts.setPrecio_costo(Long.parseLong(txtprecio_costo.getText().replaceAll("\\.", "")));
        dts.setPrecio_mayor(Long.parseLong(txtprecio_mayor.getText().replaceAll("\\.", "")));
        dts.setStock(Double.parseDouble(txtcantidadstock.getText()));
        dts.setPulgadas(Double.parseDouble(txtpulgadas.getText()));
        dts.setIdcategorias(Integer.parseInt(txtidcategoria.getText()));
        dts.setIdproveedor(Integer.parseInt(txtidproveedor.getText()));

        if (accion.equals("guardar")) {
            func.insertar(dts);
            JOptionPane.showMessageDialog(this, "PRODUCTO REGISTRADO CORRECTAMENTE");
            mostrar("");

        }
        if (accion.equals("Editar")) {

            dts.setIdservicios(Integer.parseInt(txtid.getText()));
            func.editar(dts);
            JOptionPane.showMessageDialog(this, "PRODUCTO EDITADO CORRECTAMENTE");
            mostrar("");

        }
        cancelar();
    }//GEN-LAST:event_btninsertarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        if (!txtid.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar este producto?", "Confirmar", 2);

            if (confirmacion == 0) {
                fproductos func = new fproductos();
                vproductos dts = new vproductos();

                dts.setIdservicios(Integer.parseInt(txtid.getText()));
                func.eliminar(dts);
                mostrar("");
                cancelar();

            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        mostrar(txtbuscar.getText()); // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
        mostrar(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyTyped

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        accion = "Editar";
        btninsertar.setText("Editar");
        nuevo();
        try {

            int fila = tablalistado.rowAtPoint(evt.getPoint());
            txtid.setText(tablalistado.getValueAt(fila, 0).toString());
            txtproducto.setText(tablalistado.getValueAt(fila, 1).toString());
            txtdescripcion.setText(tablalistado.getValueAt(fila, 2).toString());
            txtprecio.setText(tablalistado.getValueAt(fila, 3).toString());
            txtprecio_mayor.setText(tablalistado.getValueAt(fila, 4).toString());
            txtprecio_costo.setText(tablalistado.getValueAt(fila, 5).toString());
            txtcantidadstock.setText(tablalistado.getValueAt(fila, 6).toString());
            txtidcategoria.setText(tablalistado.getValueAt(fila, 8).toString());
            txtcategoria.setText(tablalistado.getValueAt(fila, 9).toString());
            //            cbocategoria.setSelectedItem(tablalistado.getValueAt(fila, 8).toString());
            txtpulgadas.setText(tablalistado.getValueAt(fila, 7).toString());
            txtidproveedor.setText(tablalistado.getValueAt(fila, 11).toString());
            txtproveedor.setText(tablalistado.getValueAt(fila, 10).toString());

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        FrmVista2 form = new FrmVista2();
        form.jComboBox1.setVisible(false);
        form.setVisible(true);
        form.toFront();
        form.dondebuscar = 3;
        form.lbltitulovista.setText("CATEGORIAS");
        form.buscador();
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnbuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar1ActionPerformed
        FrmVista2 form = new FrmVista2();
        form.jComboBox1.setVisible(false);
        form.setVisible(true);
        form.toFront();
        form.dondebuscar = 4;
        form.lbltitulovista.setText("PROVEEDORES");
        form.buscador();
    }//GEN-LAST:event_btnbuscar1ActionPerformed

    private void txtprecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyReleased
        
        if (txtprecio.getText().length() >= 0) {
            txtprecio.setText(txtprecio.getText().replace(".", ""));
            int c = Integer.parseInt(txtprecio.getText());
            txtprecio.setText(formatea.format(c) + "");
        }
    }//GEN-LAST:event_txtprecioKeyReleased

    private void txtprecio_mayorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecio_mayorKeyReleased
       if (txtprecio_mayor.getText().length() >= 0) {
            txtprecio_mayor.setText(txtprecio_mayor.getText().replace(".", ""));
            int c = Integer.parseInt(txtprecio_mayor.getText());
            txtprecio_mayor.setText(formatea.format(c) + "");
        }
    }//GEN-LAST:event_txtprecio_mayorKeyReleased

    private void txtprecio_costoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecio_costoKeyReleased
        if (txtprecio_costo.getText().length() >= 0) {
            txtprecio_costo.setText(txtprecio_costo.getText().replace(".", ""));
            int c = Integer.parseInt(txtprecio_costo.getText());
            txtprecio_costo.setText(formatea.format(c) + "");
        }
    }//GEN-LAST:event_txtprecio_costoKeyReleased

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
            java.util.logging.Logger.getLogger(frmproducto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmproducto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmproducto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmproducto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmproducto2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnbuscar;
    public static javax.swing.JButton btnbuscar1;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btninsertar;
    private javax.swing.JButton btnnuevo;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JPanel panelboton2;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcantidadstock;
    public static javax.swing.JTextField txtcategoria;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtid;
    public static javax.swing.JTextField txtidcategoria;
    public static javax.swing.JTextField txtidproveedor;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txtprecio_costo;
    private javax.swing.JTextField txtprecio_mayor;
    private javax.swing.JTextField txtproducto;
    public static javax.swing.JTextField txtproveedor;
    private javax.swing.JTextField txtpulgadas;
    // End of variables declaration//GEN-END:variables
}
