/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vpacientes;
import Datos.vpermisos;
import Datos.vusuarios;
import Logica.LOcultarColumna;
import Logica.StyloTabla;
import Logica.fpacientes;
import Logica.fpermisos;
import Logica.fusuarios;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Ayala
 */
public class frmusuario extends javax.swing.JInternalFrame {

    public static String x;
    int venta = 0, compras = 0, apertura = 0, cierre = 0, usuarios = 0, pago_deudas = 0, ing_egre = 0, historial_ven = 0, ventas_dia = 0
            , venta_cliente = 0, historial_compras = 0, historial_ingre_egre = 0, resumen_ingre_egre = 0,respaldo=0,rptusuario=0;

    public frmusuario() {
        initComponents();

        x = "x";
        int a = frmprincipal.jDesktopPane2.getWidth() - this.getWidth();
        int b = frmprincipal.jDesktopPane2.getHeight() - this.getHeight();
        setLocation(a / 2, b / 2);
        setVisible(true);

        mostrar("");
        inhabilitar();
//          jPanel1.setBackground(new Color(0, 102, 100, 200));
//         jPanel2.setBackground(new Color(0, 102, 100, 200));
//        jPanel3.setBackground(new Color(0, 102, 100, 200));
//        jPanel4.setBackground(new Color(0, 102, 100, 200));
//          jPanel5.setBackground(new Color(0, 102, 100, 200));
        StyloTabla st = new StyloTabla();
//        st.stylotabla(tablaventas);
        LOcultarColumna.modjtable(tablalistado);
    }
    private String accion = "guardar";

    void inhabilitar() {
        txtidpersona.setVisible(false);

        txtnombre.setEnabled(false);
        txtapellido.setEnabled(false);
        txtlogin.setEnabled(false);
        txtcontraseña.setEnabled(false);
        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(false);
        cboacceso.setEnabled(false);

        chbventas.setEnabled(false);
        chbcompras.setEnabled(false);
        chbapertura.setEnabled(false);
        chbcierre.setEnabled(false);
        chbusuario.setEnabled(false);
        chbpagodeudas.setEnabled(false);
        chbingre_egre.setEnabled(false);
        chbhistorial_ventas.setEnabled(false);
        chbventas_dia.setEnabled(false);
        chbventas_cliente.setEnabled(false);
        chbhistorial_compras.setEnabled(false);
        chbhistorial_ingre_egre.setEnabled(false);
        chbresumen_ingre_egre.setEnabled(false);
        chbReporteUsu.setEnabled(false);
        chbrespaldo.setEnabled(false);

        txtidpersona.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtlogin.setText("");
        txtcontraseña.setText("");
        cboacceso.setSelectedItem("ADMINISTRADOR");

        chbventas.setSelected(false);
        chbcompras.setSelected(false);
        chbapertura.setSelected(false);
        chbcierre.setSelected(false);
        chbusuario.setSelected(false);
        chbpagodeudas.setSelected(false);
        chbingre_egre.setSelected(false);
        chbhistorial_ventas.setSelected(false);
        chbventas_dia.setSelected(false);
        chbventas_cliente.setSelected(false);
        chbhistorial_compras.setSelected(false);
        chbhistorial_ingre_egre.setSelected(false);
        chbresumen_ingre_egre.setSelected(false);
        chbReporteUsu.setSelected(false);
        chbrespaldo.setSelected(false);

    }

    void habilitar() {
        txtidpersona.setVisible(false);

        txtnombre.setEnabled(true);
        txtapellido.setEnabled(true);
        txtlogin.setEnabled(true);
        txtcontraseña.setEnabled(true);
        cboacceso.setEnabled(true);

        chbventas.setEnabled(true);
        chbcompras.setEnabled(true);
        chbapertura.setEnabled(true);
        chbcierre.setEnabled(true);
        chbusuario.setEnabled(true);
        chbpagodeudas.setEnabled(true);
        chbingre_egre.setEnabled(true);
        chbhistorial_ventas.setEnabled(true);
        chbventas_dia.setEnabled(true);
        chbventas_cliente.setEnabled(true);
        chbhistorial_compras.setEnabled(true);
        chbhistorial_ingre_egre.setEnabled(true);
        chbresumen_ingre_egre.setEnabled(true);
        chbReporteUsu.setEnabled(true);
        chbrespaldo.setEnabled(true);

        btnguardar.setEnabled(true);
        btnnuevo.setEnabled(true);
        btneliminar.setEnabled(true);
        btncancelar.setEnabled(true);

        txtidpersona.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtlogin.setText("");
        txtcontraseña.setText("");
        cboacceso.setSelectedItem("ADMINISTRADOR");

        chbventas.setSelected(false);
        chbcompras.setSelected(false);
        chbapertura.setSelected(false);
        chbcierre.setSelected(false);
        chbusuario.setSelected(false);
        chbpagodeudas.setSelected(false);
        chbingre_egre.setSelected(false);
        chbhistorial_ventas.setSelected(false);
        chbventas_dia.setSelected(false);
        chbventas_cliente.setSelected(false);
        chbhistorial_compras.setSelected(false);
        chbhistorial_ingre_egre.setSelected(false);
        chbresumen_ingre_egre.setSelected(false);
        chbReporteUsu.setSelected(false);
        chbrespaldo.setSelected(false);
    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            for (int c = 0; c < tablalistado.getColumnCount(); c++) {

                Class<?> col_class = tablalistado.getColumnClass(c);

                tablalistado.setDefaultEditor(col_class, null); // remove editor
            }
            fusuarios func = new fusuarios();
            modelo = func.mostrarPermisos(buscar);

            tablalistado.setModel(modelo);
             ocultar_columnas();
            lbltotalregistros.setText("Total Registros: " + Integer.toString(func.totalregistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
      void ocultar_columnas() {
          
         tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0); 
          
        tablalistado.getColumnModel().getColumn(18).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(18).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(18).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(6).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(6).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(6).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(7).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(7).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(7).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(8).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(8).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(8).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(9).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(9).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(9).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(10).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(10).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(10).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(11).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(11).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(11).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(12).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(12).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(12).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(13).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(13).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(13).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(14).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(14).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(14).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(15).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(15).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(15).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(16).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(16).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(16).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(17).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(17).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(17).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(18).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(18).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(18).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(19).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(19).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(19).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(20).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(20).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(20).setPreferredWidth(0);
        
       
        
    }

    void guardar() {
        if (txtnombre.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un Nombre para el Usuario");
            txtnombre.requestFocus();
            return;
        }
        if (txtapellido.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un apellido para el Usuario");
            txtapellido.requestFocus();
            return;
        }

        vusuarios dts = new vusuarios();
        fusuarios func = new fusuarios();

        dts.setNombre(txtnombre.getText());
        dts.setAcceso(cboacceso.getSelectedItem().toString());
        dts.setApellido(txtapellido.getText());
        dts.setLogin(txtlogin.getText());
        dts.setPassword(txtcontraseña.getText());

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Usuario fue registrado satisfactoriamente");
                guardar_perimisos();
                mostrar("");
                inhabilitar();

            }

        } else if (accion.equals("editar")) {
            dts.setIdpersona(Integer.parseInt(txtidpersona.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Usuario fue Editado satisfactoriamente");
                guardar_perimisos();
                mostrar("");
                inhabilitar();
            }
        }
    }

    void guardar_perimisos() {

        if (chbventas.isSelected()) {
            venta = 1;
        } else {
            venta = 0;
        }

        //------------------
        if (chbcompras.isSelected()) {
            compras = 1;
        } else {
            compras = 0;
        }
        //------------------
        if (chbapertura.isSelected()) {
            apertura = 1;
        } else {
            apertura = 0;
        }
        //
        //------------------
        if (chbcierre.isSelected()) {
            cierre = 1;
        } else {
            cierre = 0;
        }
        //------------------
        if (chbusuario.isSelected()) {
            usuarios = 1;
        } else {
            usuarios = 0;
        }
        //------------------
        if (chbpagodeudas.isSelected()) {
            pago_deudas = 1;
        } else {
            pago_deudas = 0;
        }
        //------------------
        if (chbingre_egre.isSelected()) {
            ing_egre = 1;
        } else {
            ing_egre = 0;

        }  //------------------
        if (chbhistorial_ventas.isSelected()) {
            historial_ven = 1;
        } else {
            historial_ven = 0;
        }
        //------------------
        if (chbventas_dia.isSelected()) {
            ventas_dia = 1;
        } else {
            ventas_dia = 0;
        }
        //------------------
        if (chbventas_cliente.isSelected()) {
            venta_cliente = 1;
        } else {
            venta_cliente = 0;
        }
        //------------------
        if (chbhistorial_compras.isSelected()) {
            historial_compras = 1;
        } else {
            historial_compras = 0;
        }
        //------------------
        if (chbhistorial_ingre_egre.isSelected()) {
            historial_ingre_egre = 1;
        } else {
            historial_ingre_egre = 0;
        }
        //------------------
        if (chbresumen_ingre_egre.isSelected()) {
            resumen_ingre_egre = 1;
        } else {
            resumen_ingre_egre = 0;
        }
         //------------------
        if (chbrespaldo.isSelected()) {
            respaldo = 1;
        } else {
            respaldo = 0;
        }
        //------------------
        if (chbReporteUsu.isSelected()) {
            rptusuario = 1;
        } else {
            rptusuario = 0;
        }

        vpermisos dts = new vpermisos();
        fpermisos func = new fpermisos();

        dts.setVenta(venta);
        dts.setCompras(compras);
        dts.setApertura_caja(apertura);
        dts.setCierre_caja(cierre);
        dts.setUsuarios(usuarios);
        dts.setPago_deudas(pago_deudas);
        dts.setIng_egre(ing_egre);
        dts.setHistorial_ven(historial_ven);
        dts.setVentas_dia(ventas_dia);
        dts.setVenta_cliente(venta_cliente);
        dts.setHistorial_compras(historial_compras);
        dts.setHistorial_ingre_egre(historial_ingre_egre);
        dts.setResumen_ingre_egre(resumen_ingre_egre);
        dts.setRespaldo(respaldo);
        dts.setRptusuario(rptusuario);

        if (accion.equals("guardar")) {
            if (func.insertarPermisos(dts)) {
                mostrar("");
                inhabilitar();

            }

        } else if (accion.equals("editar")) {
            dts.setIdusuarios(Integer.parseInt(txtidpersona.getText()));

            if (func.editar(dts)) {
//                JOptionPane.showMessageDialog(rootPane, "El Permiso fue Editado satisfactoriamente");
                mostrar("");
                inhabilitar();
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtcontraseña = new javax.swing.JTextField();
        txtlogin = new javax.swing.JTextField();
        txtidpersona = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        lbltotalregistros = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        chbresumen_ingre_egre = new javax.swing.JCheckBox();
        chbusuario = new javax.swing.JCheckBox();
        chbcierre = new javax.swing.JCheckBox();
        chbventas_dia = new javax.swing.JCheckBox();
        chbhistorial_ingre_egre = new javax.swing.JCheckBox();
        chbhistorial_ventas = new javax.swing.JCheckBox();
        chbapertura = new javax.swing.JCheckBox();
        chbcompras = new javax.swing.JCheckBox();
        chbingre_egre = new javax.swing.JCheckBox();
        chbhistorial_compras = new javax.swing.JCheckBox();
        chbventas_cliente = new javax.swing.JCheckBox();
        chbpagodeudas = new javax.swing.JCheckBox();
        chbventas = new javax.swing.JCheckBox();
        chbReporteUsu = new javax.swing.JCheckBox();
        chbrespaldo = new javax.swing.JCheckBox();
        cboacceso = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btncancelar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();

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

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 71, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Apellido");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 71, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Usuario");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 80, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Acceso");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 70, -1));
        jPanel2.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 161, 30));
        jPanel2.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 174, 30));
        jPanel2.add(txtcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 152, 30));

        txtlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtloginActionPerformed(evt);
            }
        });
        jPanel2.add(txtlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 165, 30));
        jPanel2.add(txtidpersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 24, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Buscar");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 277, -1, 30));

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        jPanel2.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 190, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("USUARIOS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 11, 170, 19));

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablalistadoMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tablalistado);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 910, 220));

        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltotalregistros.setText("Registros:");
        jPanel2.add(lbltotalregistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 554, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255)), "PERMISOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        chbresumen_ingre_egre.setText("Resumen Ing. Egr.");

        chbusuario.setText("Usuarios");

        chbcierre.setText("Ciere caja");
        chbcierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbcierreActionPerformed(evt);
            }
        });

        chbventas_dia.setText("Ventas del dia");

        chbhistorial_ingre_egre.setText("Historial Ingre y E");

        chbhistorial_ventas.setText("Historial de ventas");
        chbhistorial_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbhistorial_ventasActionPerformed(evt);
            }
        });

        chbapertura.setText("Apertura caja");
        chbapertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbaperturaActionPerformed(evt);
            }
        });

        chbcompras.setText("Compras");
        chbcompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbcomprasActionPerformed(evt);
            }
        });

        chbingre_egre.setText("Ingr. y Egre.");

        chbhistorial_compras.setText("Historial de compras");

        chbventas_cliente.setText("Ventas por cliente");

        chbpagodeudas.setText("Pago deudas");

        chbventas.setText("Ventas");

        chbReporteUsu.setText("Reporte Usuarios");

        chbrespaldo.setText("Respaldo");
        chbrespaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbrespaldoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbventas)
                    .addComponent(chbpagodeudas)
                    .addComponent(chbventas_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbcompras)
                    .addComponent(chbingre_egre)
                    .addComponent(chbhistorial_compras))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbapertura)
                    .addComponent(chbhistorial_ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbhistorial_ingre_egre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbcierre)
                    .addComponent(chbventas_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbresumen_ingre_egre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbusuario)
                    .addComponent(chbReporteUsu)
                    .addComponent(chbrespaldo))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chbusuario)
                        .addGap(7, 7, 7)
                        .addComponent(chbrespaldo)
                        .addGap(7, 7, 7)
                        .addComponent(chbReporteUsu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chbventas)
                            .addComponent(chbcompras)
                            .addComponent(chbapertura)
                            .addComponent(chbcierre))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chbpagodeudas)
                            .addComponent(chbingre_egre)
                            .addComponent(chbhistorial_ventas)
                            .addComponent(chbventas_dia))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chbventas_cliente)
                            .addComponent(chbhistorial_compras)
                            .addComponent(chbhistorial_ingre_egre)
                            .addComponent(chbresumen_ingre_egre))))
                .addGap(43, 43, 43))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 780, 120));

        cboacceso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "CAJA" }));
        cboacceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboaccesoActionPerformed(evt);
            }
        });
        jPanel2.add(cboacceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 140, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Contraseña");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 590));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguardar)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancelar))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnnuevo)
                .addGap(23, 23, 23)
                .addComponent(btnguardar)
                .addGap(23, 23, 23)
                .addComponent(btneliminar)
                .addGap(23, 23, 23)
                .addComponent(btncancelar)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, -1, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidpersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidpersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidpersonaActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        btnguardar.setText("Editar");
        habilitar();
        btneliminar.setEnabled(true);
        accion = "editar";

        int fila = tablalistado.rowAtPoint(evt.getPoint());
        venta = Integer.parseInt(tablalistado.getValueAt(fila, 6).toString());
        compras = Integer.parseInt(tablalistado.getValueAt(fila, 7).toString());
        apertura = Integer.parseInt(tablalistado.getValueAt(fila, 8).toString());
        cierre = Integer.parseInt(tablalistado.getValueAt(fila, 9).toString());
        usuarios = Integer.parseInt(tablalistado.getValueAt(fila, 10).toString());
        pago_deudas = Integer.parseInt(tablalistado.getValueAt(fila, 11).toString());
        ing_egre = Integer.parseInt(tablalistado.getValueAt(fila, 12).toString());
        historial_ven = Integer.parseInt(tablalistado.getValueAt(fila, 13).toString());
        ventas_dia = Integer.parseInt(tablalistado.getValueAt(fila, 14).toString());
        venta_cliente = Integer.parseInt(tablalistado.getValueAt(fila, 15).toString());
        historial_compras = Integer.parseInt(tablalistado.getValueAt(fila, 16).toString());
        historial_ingre_egre = Integer.parseInt(tablalistado.getValueAt(fila, 17).toString());
        resumen_ingre_egre = Integer.parseInt(tablalistado.getValueAt(fila, 18).toString());
        respaldo = Integer.parseInt(tablalistado.getValueAt(fila, 19).toString());
        rptusuario = Integer.parseInt(tablalistado.getValueAt(fila, 20).toString());

//                
        txtidpersona.setText(tablalistado.getValueAt(fila, 0).toString());
        txtnombre.setText(tablalistado.getValueAt(fila, 1).toString());
        txtapellido.setText(tablalistado.getValueAt(fila, 2).toString());
        txtlogin.setText(tablalistado.getValueAt(fila, 3).toString());
        txtcontraseña.setText(tablalistado.getValueAt(fila, 4).toString());
        cboacceso.setSelectedItem(tablalistado.getValueAt(fila, 5).toString());
//===============================
        if (venta == 1) {
            chbventas.setSelected(true);
        } else {
            chbventas.setSelected(false);
        }
        //===============================
        if (compras == 1) {
            chbcompras.setSelected(true);
        } else {
            chbcompras.setSelected(false);
        }
        //===============================
        if (apertura == 1) {
            chbapertura.setSelected(true);
        } else {
            chbapertura.setSelected(false);
        }
        //===============================
        if (cierre == 1) {
            chbcierre.setSelected(true);
        } else {
            chbcierre.setSelected(false);
        }
        //===============================
        if (usuarios == 1) {
            chbusuario.setSelected(true);
        } else {
            chbusuario.setSelected(false);
        }
        if (pago_deudas == 1) {
            chbpagodeudas.setSelected(true);
        } else {
            chbpagodeudas.setSelected(false);
        }
        //===============================
        if (ing_egre == 1) {
            chbingre_egre.setSelected(true);
        } else {
            chbingre_egre.setSelected(false);
        }
        //===============================
        if (historial_ven == 1) {
            chbhistorial_ventas.setSelected(true);
        } else {
            chbhistorial_ventas.setSelected(false);
        }
        //===============================
        if (ventas_dia == 1) {
            chbventas_dia.setSelected(true);
        } else {
            chbventas_dia.setSelected(false);
        }
        //===============================
        if (venta_cliente == 1) {
            chbventas_cliente.setSelected(true);
        } else {
            chbventas_cliente.setSelected(false);
        }
        //===============================
        if (historial_compras == 1) {
            chbhistorial_compras.setSelected(true);
        } else {
            chbhistorial_compras.setSelected(false);
        }
        //===============================
        if (historial_ingre_egre == 1) {
            chbhistorial_ingre_egre.setSelected(true);
        } else {
            chbhistorial_ingre_egre.setSelected(false);
        }
        //===============================
        if (resumen_ingre_egre == 1) {
            chbresumen_ingre_egre.setSelected(true);
        } else {
            chbresumen_ingre_egre.setSelected(false);
        }
        //===============================
        if (respaldo == 1) {
            chbrespaldo.setSelected(true);
        } else {
            chbrespaldo.setSelected(false);
        }
        //===============================
        if (rptusuario == 1) {
            chbReporteUsu.setSelected(true);
        } else {
            chbReporteUsu.setSelected(false);
        }


    }//GEN-LAST:event_tablalistadoMouseClicked

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        guardar();
//        guardar_perimisos();


    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        habilitar();
        txtnombre.requestFocus();
        btnguardar.setText("Guardar");
        accion = "guardar";


    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        inhabilitar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        if (!txtidpersona.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar el Usuario?", "Confirmar", 2);

            if (confirmacion == 0) {
                fusuarios func = new fusuarios();
                vusuarios dts = new vusuarios();

                dts.setIdpersona(Integer.parseInt(txtidpersona.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();

            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        mostrar(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void chbcomprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbcomprasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbcomprasActionPerformed

    private void chbaperturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbaperturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbaperturaActionPerformed

    private void chbcierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbcierreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbcierreActionPerformed

    private void chbhistorial_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbhistorial_ventasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbhistorial_ventasActionPerformed

    private void txtloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtloginActionPerformed

    private void tablalistadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistadoMouseEntered

    private void cboaccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboaccesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboaccesoActionPerformed

    private void chbrespaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbrespaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbrespaldoActionPerformed

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
            java.util.logging.Logger.getLogger(frmusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmusuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> cboacceso;
    private javax.swing.JCheckBox chbReporteUsu;
    private javax.swing.JCheckBox chbapertura;
    private javax.swing.JCheckBox chbcierre;
    private javax.swing.JCheckBox chbcompras;
    private javax.swing.JCheckBox chbhistorial_compras;
    private javax.swing.JCheckBox chbhistorial_ingre_egre;
    private javax.swing.JCheckBox chbhistorial_ventas;
    private javax.swing.JCheckBox chbingre_egre;
    private javax.swing.JCheckBox chbpagodeudas;
    private javax.swing.JCheckBox chbrespaldo;
    private javax.swing.JCheckBox chbresumen_ingre_egre;
    private javax.swing.JCheckBox chbusuario;
    private javax.swing.JCheckBox chbventas;
    private javax.swing.JCheckBox chbventas_cliente;
    private javax.swing.JCheckBox chbventas_dia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcontraseña;
    private javax.swing.JTextField txtidpersona;
    private javax.swing.JTextField txtlogin;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
