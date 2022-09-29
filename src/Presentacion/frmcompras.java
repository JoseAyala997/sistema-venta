/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vcompras;
import Datos.vdetalle_compra;
import Datos.vdeudas;
import Datos.vventas;
import Logica.LOcultarColumna;
import Logica.StyloTabla;
import Logica.fcompra;
import Logica.fdeudas;
import Logica.fproductos;
import Logica.fventa;
import java.awt.Color;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Ayala
 */
//comentario
public class frmcompras extends javax.swing.JInternalFrame {

    public static DefaultTableModel modelo = new DefaultTableModel();
    public static String x;

    public frmcompras() {
        initComponents();
        x = "x";
        NroFactura();
//        setSize(1076, 652);
        centrar_frm();
        txtestado.setText("FINALIZADO");

        cliente();

        Calendar mifecha = new GregorianCalendar();
        dcfecha.setCalendar(mifecha);

        lblidproducto.setVisible(false);
        idproveedor.setVisible(false);
//        txtcodcliente.setVisible(false);
//        txtpulgadas.requestFocus();
//        txtpulgadas.setText("0");
//        txtdescuento.setText("0");
        idproveedor.setVisible(false);

        StyloTabla st = new StyloTabla();
        st.stylotabla(tablaventas);

        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("PRECIO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("SUB TOTAL");
        modelo.addColumn("ID PROV");
        modelo.addColumn("DESC.");

        this.tablaventas.setModel(modelo);
        txtcantidad.requestFocus();

        LOcultarColumna.modjtable(tablaventas);
        LOcultarColumna.ocultar_esta_columna1(tablaventas, 0, 1, 5);
    }

    void estado() {

        if (cbotipo.getSelectedItem().equals("CONTADO")) {
            txtestado.setText("FINALIZADO");

        } else {
            txtestado.setText("PENDIENTE");
        }
    }

//      public void LocalDate() {        
//        LocalDateTime date = LocalDateTime.now();
//        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
//         String dateStr = date.format(fmt);
//                 System.out.println ("LocalDate a String:" + dateStr);
//                 txtfecha.setText(dateStr);
//   }
    public static void cliente() {
        //asignamos un cliente general
//        txtcodcliente.setText("3");
//        txtcliente.setText("CLIENTE GENERAL");
//        txtpulgadas.setText("0");
    }

    public static void vaciartabla() {
        try {
            int fila = tablaventas.getRowCount();
            for (int i = 0; fila > i; i++) {
                frmcompras.modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void centrar_frm() {
        int a = frmprincipal.jDesktopPane2.getWidth() - this.getWidth();
        int b = frmprincipal.jDesktopPane2.getHeight() - this.getHeight();
        setLocation(a / 2, b / 2);
        setVisible(true);
    }

    public static DecimalFormat formateador = new DecimalFormat("0000000");//damos formato al numero de factura

    public static void insertarCompra() {
        vcompras datos = new vcompras();
        fcompra funcion = new fcompra();

        datos.setIdusuarios(Integer.parseInt(frmprincipal.lblcodusuario.getText()));

        datos.setTotal(Long.parseLong(txttotal.getText().replaceAll("\\.", "")));

        Calendar cal = dcfecha.getCalendar();
        int a, m, d;
        a = cal.get(cal.YEAR) - 1900;
        m = cal.get(cal.MONTH);
        d = cal.get(cal.DAY_OF_MONTH);
        datos.setFecha(new Date(a, m, d));

        datos.setNro_factura(txtnum_compra.getText());
        datos.setTipo(cbotipo.getSelectedItem().toString());
        datos.setEstado(txtestado.getText());

//        datos.setIdpaciente(Integer.parseInt(txtcodcliente.getText()));
        //datos.setIdusuarios(Integer.parseInt(FRMPRINCIPAL.lblCod_Usuario.getText()));
        datos.setDescuento(Long.parseLong(txtdescuento.getText().replaceAll("\\.", "")));
        datos.setIdmovimiento(Integer.parseInt(frmprincipal.idcaja1));
        datos.setIdcliente(Integer.parseInt(lblidcliente.getText()));

        if (funcion.insertarVentas(datos)) {

        }
        imsertarDetalle();

    }

    public static void imsertarDetalle() {
        vdetalle_compra datos = new vdetalle_compra();
        fcompra funcion = new fcompra();
        fproductos cd = new fproductos();
//        freserva rs = new freserva();
//        if (true) {
//
//        }
        for (int i = 0; i < tablaventas.getRowCount(); i++) {

//        modelo.addColumn("ID");
//        modelo.addColumn("PRODUCTO");
//        modelo.addColumn("PRECIO");
//        modelo.addColumn("CANTIDAD");
//        modelo.addColumn("SUB TOTAL");
//        modelo.addColumn("ID PROV");
//        modelo.addColumn("DESC.");
            datos.setIdservicios(Integer.parseInt(tablaventas.getValueAt(i, 0).toString()));
            datos.setIdproveedor(Integer.parseInt(tablaventas.getValueAt(i, 5).toString()));
            datos.setCantidad(Integer.parseInt(tablaventas.getValueAt(i, 3).toString()));
            datos.setPrecio(Long.parseLong(tablaventas.getValueAt(i, 2).toString().replaceAll("\\.", "")));
            datos.setSub_total(Long.parseLong(tablaventas.getValueAt(i, 4).toString().replaceAll("\\.", "")));

//            cd.sumarpulgadas(Double.parseDouble(tablaventas.getValueAt(i, 3).toString()), Integer.parseInt(tablaventas.getValueAt(i, 0).toString()));
            cd.sumarStock(Double.parseDouble(tablaventas.getValueAt(i, 3).toString()), Integer.parseInt(tablaventas.getValueAt(i, 0).toString()));

            funcion.insertarDetalle(datos);

        }
        vaciartabla();

//         func.ingresohoycierre(frmprincipal.lblidmovimiento2.getText());
        txttotal.setText("0");
        txtiva.setText("0");
        txtdescuento.setText("0");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        frmprincipal.mostrarhoy(dtf.format(LocalDateTime.now()));
        JOptionPane.showMessageDialog(null, "Compra Finalizada");
    }

    //funcion para agregar productos a la tabla
    void agregar() {
        String[] agregar = new String[7];
        if (txtproducto.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar el Producto");
//            btn.requestFocus();
            return;
        }
        if (txtcantidad.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes poner la cantidad");
            txtcantidad.requestFocus();
            return;
        }
        if (txtsubtotal.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "El subtotal no puede estar vacio");
            txtsubtotal.setText("0");
            return;
        }
        if (txtredondeo.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "El descuento no puede estar vacio");
            txtredondeo.setText("0");
            return;
        }

//        
        agregar[0] = lblidproducto.getText();
        agregar[1] = txtproducto.getText();
        agregar[2] = String.valueOf(format.format(Integer.parseInt(txtprecio.getText().replaceAll("\\.", ""))));
//        agregar[3] = txtpulgadas.getText();
        agregar[3] = txtcantidad.getText();
        int subttotal = (Integer.parseInt(txtcantidad.getText()) * Integer.parseInt(txtprecio.getText().replaceAll("\\.", ""))) - Integer.parseInt(txtredondeo.getText().replaceAll("\\.", ""));
        agregar[4] = String.valueOf(format.format(Integer.parseInt("" + subttotal)));
        agregar[5] = idproveedor.getText();
        agregar[6] = String.valueOf(format.format(Integer.parseInt(txtredondeo.getText().replaceAll("\\.", ""))));
        modelo.addRow(agregar);
        sumarsubtotalC();

        txtprecio.setText("");
        txtcantidad.setText("");
        lblidproducto.setText("");
        txtproducto.setText("");
        txtprecio.setText("");
//        txtpulgadas.setText("0");
        txtproveedor.setText("");
        idproveedor.setText("");
        txtredondeo.setText("0");
        txtsubtotal.setText("0");
    }

    public static void NroFactura() {

        fcompra funcion = new fcompra();

        int NroFactura = funcion.NroFactura();//llamamos la funcion nrofactura
        txtnum_compra.setText(formateador.format(NroFactura));//asignamos el numero de factura al txt

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnquitar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaventas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtcantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtproducto = new javax.swing.JTextField();
        idproveedor = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtredondeo = new javax.swing.JTextField();
        lblidproducto = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        btnb_Cliente = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        lblidcliente = new javax.swing.JLabel();
        txtnum_compra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbotipo = new javax.swing.JComboBox<>();
        dcfecha = new com.toedter.calendar.JDateChooser();
        txtestado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtproveedor = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtiva = new javax.swing.JTextField();
        txtdescuento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setBackground(new java.awt.Color(255, 255, 255));
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

        txttotal.setEnabled(false);
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, 130, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("IVA:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 575, 30, 20));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("AÑADIR F2");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnquitar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnquitar.setText("QUITAR");
        btnquitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("FINALIZAR COMPRA F3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(btnquitar))))
                    .addComponent(jButton3))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnquitar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 140, 210, 480));

        tablaventas.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaventas.getTableHeader().setResizingAllowed(false);
        tablaventas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaventas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 1010, 340));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel5.setText("COMPRAS");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 189, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("PRECIO");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 55, 60, 20));

        txtprecio.setEnabled(false);
        txtprecio.setMinimumSize(new java.awt.Dimension(6, 30));
        jPanel4.add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 110, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar32.png"))); // NOI18N
        jButton2.setText("F1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 75, -1, 36));

        txtcantidad.setMinimumSize(new java.awt.Dimension(6, 30));
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });
        jPanel4.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 110, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CANTIDAD");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 55, 80, 20));

        txtproducto.setEnabled(false);
        txtproducto.setMinimumSize(new java.awt.Dimension(6, 30));
        jPanel4.add(txtproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 245, 30));

        idproveedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        idproveedor.setText("IDPROV");
        jPanel4.add(idproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, 80, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("PRODUCTO");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 80, 20));

        txtsubtotal.setEnabled(false);
        txtsubtotal.setPreferredSize(null);
        txtsubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubtotalActionPerformed(evt);
            }
        });
        jPanel4.add(txtsubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, 110, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("SUB-TOTAL");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 55, 100, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("DESCUENTO");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 55, 124, 20));

        txtredondeo.setEnabled(false);
        txtredondeo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtredondeoKeyReleased(evt);
            }
        });
        jPanel4.add(txtredondeo, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 80, 110, 30));

        lblidproducto.setText("IDPROD");
        jPanel4.add(lblidproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 50, 24));

        txtcliente.setEnabled(false);
        txtcliente.setPreferredSize(null);
        jPanel4.add(txtcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 230, 30));

        btnb_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar1 - copia.png"))); // NOI18N
        btnb_Cliente.setMnemonic('1');
        btnb_Cliente.setText("F1");
        btnb_Cliente.setToolTipText("");
        btnb_Cliente.setBorder(null);
        btnb_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnb_ClienteActionPerformed(evt);
            }
        });
        jPanel4.add(btnb_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 75, 80, 35));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("CLIENTE");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 55, -1, -1));

        lblidcliente.setText("IDCLIENTE");
        jPanel4.add(lblidcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 11, 50, 24));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 140));

        txtnum_compra.setEnabled(false);
        txtnum_compra.setMinimumSize(new java.awt.Dimension(6, 30));
        getContentPane().add(txtnum_compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 100, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("FECHA");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("TIPO");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 58, -1));

        cbotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONTADO", "CREDITO" }));
        cbotipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbotipoItemStateChanged(evt);
            }
        });
        cbotipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipoActionPerformed(evt);
            }
        });
        getContentPane().add(cbotipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 124, 30));

        dcfecha.setEnabled(false);
        getContentPane().add(dcfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 147, 30));

        txtestado.setEnabled(false);
        txtestado.setMinimumSize(new java.awt.Dimension(6, 30));
        getContentPane().add(txtestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 100, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("ESTADO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 79, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("N° FACTURA");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 90, 20));

        txtproveedor.setEnabled(false);
        txtproveedor.setMinimumSize(new java.awt.Dimension(6, 30));
        getContentPane().add(txtproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 230, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("PROVEEDOR");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 80, 20));

        txtiva.setEnabled(false);
        getContentPane().add(txtiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 570, 130, 30));

        txtdescuento.setEnabled(false);
        getContentPane().add(txtdescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 570, 130, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("TOTAL:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 575, 60, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("DESCUENTO:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 575, 80, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int fila = tablaventas.getRowCount();//creamos una variable para determinar si no hay filas en el jtable

//        if (txtcodcliente.getText().length() == 0) {
//            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR EL CLIENTE");//validamos que el codcliente no este vacio
//        }
        if (txtcliente.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR EL NOMBRE DEL CLIENTE");//validamos que el num de factura no este vacio

            return;
        }
        if (fila == 0) {//validamos si el jtable viene vacio 
            JOptionPane.showMessageDialog(rootPane, "La tabla no puede estar vacia");

        } else {

            if (cbotipo.getSelectedItem().equals("CREDITO")) {
                //mandamos los datos al frm factura
                FrmFactura_Entrega frm = new FrmFactura_Entrega();
                FrmFactura_Entrega.txttipo.setText("compra");
                FrmFactura_Entrega.txtFactura.setText(txtnum_compra.getText());
                FrmFactura_Entrega.txtMonto.setText(txttotal.getText());
                FrmFactura_Entrega.txtdescuento.setText(txtdescuento.getText());
                FrmFactura_Entrega.txtsaldo.setText(txttotal.getText());
                frm.setVisible(true);
//                insertarVenta();
            } else {
                //mandamos los datos al frm factura
                FrmFactura frm = new FrmFactura();
                FrmFactura.txttipo.setText("compra");
                FrmFactura.txtFactura.setText(txtnum_compra.getText());
                FrmFactura.txtMonto.setText(txttotal.getText());
                FrmFactura.txtdescuento.setText(txtdescuento.getText());
                frm.setVisible(true);
//                insertarVenta();
            }

//            insertarCompra();
//            NroFctura();
//            imprimirfactura
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnquitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarActionPerformed
        int fila = tablaventas.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes Seleccionar el Producto");

        } else {
            int confirmacion = JOptionPane.showConfirmDialog(null, "?Deseas Eliminar el Producto de la lista?");
            if (JOptionPane.OK_OPTION == confirmacion) {
                modelo.removeRow(fila);
                sumarsubtotalC();

            }
        }
    }//GEN-LAST:event_btnquitarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        agregar();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnvistaclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvistaproducto1ActionPerformed


    }//GEN-LAST:event_btnvistaproducto1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FrmVista_Servicios form = new FrmVista_Servicios();
        form.setVisible(true);
        form.toFront();
        form.dondebuscar = 3;
        form.buscador();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
//        permitir solo hasta 4 numeros

    
        char key = evt.getKeyChar();
        if (txtcantidad.getText().length() > 3) {
            evt.consume();
        }
        if (!Character.isDigit(key)) {

            evt.consume();
        }
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void cbotipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbotipoActionPerformed

    private void cbotipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbotipoItemStateChanged
        estado();
    }//GEN-LAST:event_cbotipoItemStateChanged

    private void txtsubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubtotalActionPerformed

    private void txtredondeoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtredondeoKeyReleased
        if (txtredondeo.getText().length() >= 0) {
            txtredondeo.setText(txtredondeo.getText().replace(".", ""));
            int c = Integer.parseInt(txtredondeo.getText());
            txtredondeo.setText(format.format(c) + "");
        }
    }//GEN-LAST:event_txtredondeoKeyReleased

    private void btnb_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnb_ClienteActionPerformed
        frmvistapa_venta form = new frmvistapa_venta();
        form.setVisible(true);
        form.toFront();
        form.dondebuscar = 2;
        form.buscador();
    }//GEN-LAST:event_btnb_ClienteActionPerformed

    private void txtcantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyReleased
        //sumar subtotal
        
  int precio = 0;
        int cantidad = 1;
        int sub = 0;
        precio = Integer.parseInt(txtprecio.getText().replaceAll("\\.", ""));
        cantidad = Integer.parseInt(txtcantidad.getText().replaceAll("\\.", ""));
        sub = precio * cantidad;
        txtsubtotal.setText(String.valueOf(format.format(sub)));
//            txtredondeo.requestFocus();
        txtredondeo.setEnabled(true);
    }//GEN-LAST:event_txtcantidadKeyReleased

    public static DecimalFormat format = new DecimalFormat("###,###.###");
    public static float sumatoria;
    public static float sumador;
    public static float pulgadas;
    public static float des1;
    public static float des2;
    public static float iva;

    public static void sumarsubtotalC() {
        //modelo.addColumn("ID");
//        modelo.addColumn("PRODUCTO");
//        modelo.addColumn("PRECIO");
//        modelo.addColumn("CANTIDAD");
//        modelo.addColumn("SUB TOTAL");
//        modelo.addColumn("ID PROV");
//        modelo.addColumn("DESC.");

        int totalrow = tablaventas.getRowCount();
        totalrow -= 1;
        sumatoria = 0;
        pulgadas = 0;
        des1 = 0;
        des2 = 0;
        for (int i = 0; i <= (totalrow); i++) {
            sumador = Float.valueOf(tablaventas.getValueAt(i, 4).toString().replaceAll("\\.", ""));
            sumatoria += sumador;
            des1 = Float.valueOf(tablaventas.getValueAt(i, 6).toString().replaceAll("\\.", ""));
            des2 += des1;

        }
        txttotal.setText(String.valueOf(format.format(sumatoria)));
        iva = sumatoria / 11;
        txtiva.setText(String.valueOf(format.format(iva)));

        txtdescuento.setText(String.valueOf(format.format(des2)));

//        int totalrow = tablaventas.getRowCount();
    }

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
            java.util.logging.Logger.getLogger(frmcompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmcompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmcompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmcompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmcompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnb_Cliente;
    public static javax.swing.JButton btnquitar;
    public static javax.swing.JComboBox<String> cbotipo;
    public static com.toedter.calendar.JDateChooser dcfecha;
    public static javax.swing.JLabel idproveedor;
    public static javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    public static javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    public static javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel14;
    public static javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel17;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField jTextField1;
    public static javax.swing.JLabel lblidcliente;
    public static javax.swing.JLabel lblidproducto;
    public static javax.swing.JTable tablaventas;
    public static javax.swing.JTextField txtcantidad;
    public static javax.swing.JTextField txtcliente;
    public static javax.swing.JTextField txtdescuento;
    public static javax.swing.JTextField txtestado;
    public static javax.swing.JTextField txtiva;
    public static javax.swing.JTextField txtnum_compra;
    public static javax.swing.JTextField txtprecio;
    public static javax.swing.JTextField txtproducto;
    public static javax.swing.JTextField txtproveedor;
    public static javax.swing.JTextField txtredondeo;
    public static javax.swing.JTextField txtsubtotal;
    public static javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables

    static String iddeuda;
    static String total;

    public static void insertar_deudaCompra() {

        vdeudas dts = new vdeudas();
        fdeudas func = new fdeudas();
        String[] registro = new String[3];

//        String idcliente = txtcodcliente.getText();
//        func.id_cliente(idcliente);
//        int sal= Integer.parseInt(fegresos.saldo);
        registro = func.id_cliente(lblidcliente.getText());
        iddeuda = registro[0];
        total = registro[2];
        int entrega = Integer.parseInt(FrmFactura_Entrega.txtentrega.getText().replaceAll("\\.", ""));
//if (iddeuda == null) {
        if (iddeuda.equals("")) {

            if (entrega > 0) {
//                  JOptionPane.showMessageDialog(null, "esta vacio "+total);
//            iddeuda total_deuda saldo estado fecha_deuda fecha_pago idcliente
                dts.setIdcliente(Integer.parseInt(lblidcliente.getText()));
                dts.setTotal_deuda(Long.parseLong(FrmFactura_Entrega.txtsaldo.getText().replaceAll("\\.", "")));

                dts.setEstado("PENDIENTE");

                Calendar cal = dcfecha.getCalendar();
                int a, m, d;
                a = cal.get(cal.YEAR) - 1900;
                m = cal.get(cal.MONTH);
                d = cal.get(cal.DAY_OF_MONTH);

                dts.setFecha_deuda(new Date(a, m, d));

                dts.setSaldo(Long.parseLong("0"));

                func.insertarDeuda(dts);
                frmventas.insertarpago2();

            } else {
//                  JOptionPane.showMessageDialog(null, "esta vacio "+total);
//            iddeuda total_deuda saldo estado fecha_deuda fecha_pago idcliente
                dts.setIdcliente(Integer.parseInt(lblidcliente.getText()));
                dts.setTotal_deuda(Long.parseLong(FrmFactura_Entrega.txtsaldo.getText().replaceAll("\\.", "")));

                dts.setEstado("PENDIENTE");

                Calendar cal = dcfecha.getCalendar();
                int a, m, d;
                a = cal.get(cal.YEAR) - 1900;
                m = cal.get(cal.MONTH);
                d = cal.get(cal.DAY_OF_MONTH);

                dts.setFecha_deuda(new Date(a, m, d));

                dts.setSaldo(Long.parseLong(txttotal.getText().replaceAll("\\.", "")));

                func.insertarDeuda(dts);
            }

        } else {
            if (entrega > 0) {
//            JOptionPane.showMessageDialog(null, "no vacio" + total);
//            saldo= Long.parseLong(registro[3]);
                dts.setIddeuda(Integer.parseInt(iddeuda));
                dts.setIdcliente(Integer.parseInt(lblidcliente.getText()));
                dts.setTotal_deuda(Long.parseLong(FrmFactura_Entrega.txtsaldo.getText().replaceAll("\\.", "")) + Long.parseLong(total));
                dts.setEstado("PENDIENTE");

                Calendar cal = dcfecha.getCalendar();
                int a, m, d;
                a = cal.get(cal.YEAR) - 1900;
                m = cal.get(cal.MONTH);
                d = cal.get(cal.DAY_OF_MONTH);

                dts.setFecha_deuda(new Date(a, m, d));
                func.editarDeuda(dts);
                insertarpagocompra2();
            } else {
                dts.setIddeuda(Integer.parseInt(iddeuda));
                dts.setIdcliente(Integer.parseInt(lblidcliente.getText()));
                dts.setTotal_deuda(Long.parseLong(FrmFactura_Entrega.txtsaldo.getText().replaceAll("\\.", "")) + Long.parseLong(total));
                dts.setEstado("PENDIENTE");

                Calendar cal = dcfecha.getCalendar();
                int a, m, d;
                a = cal.get(cal.YEAR) - 1900;
                m = cal.get(cal.MONTH);
                d = cal.get(cal.DAY_OF_MONTH);

                dts.setFecha_deuda(new Date(a, m, d));
                func.editarDeuda(dts);
            }
//           
        }

//        if () {
//
//        }
//        System.out.println("deuda insertada");
    }

    //FUNCION PARA INSERTAR EL PAGO
    public static void insertarpagocompra2() {
        vventas datos = new vventas();
        fventa funcion = new fventa();

        datos.setEstado("PAGADO");
        datos.setIdusuarios(Integer.parseInt(frmprincipal.lblcodusuario.getText()));
        datos.setIdpaciente(Integer.parseInt(lblidcliente.getText()));
        datos.setSaldo(Long.parseLong("0"));
        datos.setTotal(Long.parseLong(FrmFactura_Entrega.txtentrega.getText().replaceAll("\\.", "")));
        datos.setDescuento(Long.parseLong(FrmFactura_Entrega.txtdescuento.getText().replaceAll("\\.", "")));
        datos.setIdmovimiento(Integer.parseInt(frmprincipal.idcaja1));

        Calendar cal = dcfecha.getCalendar();
        int a, m, d;
        a = cal.get(cal.YEAR) - 1900;
        m = cal.get(cal.MONTH);
        d = cal.get(cal.DAY_OF_MONTH);

        datos.setFecha(new Date(a, m, d));
        datos.setNro_factura(FrmFactura_Entrega.txtnropago.getText());
        datos.setTipo("DEUDA");

        if (funcion.insertarVentas(datos)) {

        }
//            funcion.insertarVentas(datos);
//            frmprincipal.mostrarhoy(frmprincipal.lblidmovimiento2.getText());
//            imsertarDetalle();
//        System.out.println("pagado");
//        funcion.insertarVentas(datos);
    }

    //funcion para hacer una entrega del pago a credito
    void entrega() {

        vdeudas dts = new vdeudas();
        fdeudas func = new fdeudas();
        String[] registro = new String[3];
        Long entrega = Long.parseLong(FrmFactura_Entrega.txtentrega.getText());

//        String idcliente = txtcodcliente.getText();
//        func.id_cliente(idcliente);
//        int sal= Integer.parseInt(fegresos.saldo);
        registro = func.id_cliente(lblidcliente.getText());
        iddeuda = registro[0];
        total = registro[2];

        dts.setIddeuda(Integer.parseInt(iddeuda));
        dts.setTotal_deuda(Long.parseLong(total) - entrega);

        dts.setEstado("PENDIENTE");

        Calendar cal = dcfecha.getCalendar();
        int a, m, d;
        a = cal.get(cal.YEAR) - 1900;
        m = cal.get(cal.MONTH);
        d = cal.get(cal.DAY_OF_MONTH);

        dts.setFecha_pago(new Date(a, m, d));

//              dts.setIdmovimiento(Integer.parseInt(txtidmovimiento.getText()));
        func.editar(dts);//editamos el saldo de la deuda

        insertarpagocompra2();
//                mostrar("");
//                cancelar();
        NroPagoEntrega();
        //funcion para obtener datos en frmprincipal
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        frmprincipal.mostrarhoy(dtf.format(LocalDateTime.now()));
    }

//    funciona para agregar el numero del pago
    public static void NroPagoEntrega() {

        fventa funcion = new fventa();

        int NroPago = funcion.NroPago();//llamamos la funcion nrofactura
        FrmFactura_Entrega.txtnropago.setText(formateador.format(NroPago));//asignamos el numero de factura al txt

    }

}
