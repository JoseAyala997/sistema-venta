/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.varqueo;
import Datos.vmovimiento_caja;
import Logica.Conexion;
import Logica.farqueo;
import Logica.fmovimiento_caja;
import Logica.fproductos;
import Logica.fventa;
import static Logica.fventa.mysql;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author José Ayala
 */
public class FrmCerrarCaja extends javax.swing.JInternalFrame {

    public static String x;
    public static int a50 = 0;
    public static int a100 = 0;
    public static int a500 = 0;
    public static int a1000 = 0;
    public static int a2000 = 0;
    public static int a5000 = 0;
    public static int a10000 = 0;
    public static int a20000 = 0;
    public static int a50000 = 0;
    public static int a100000 = 0;
    public static Conexion mysql = new Conexion();
    DecimalFormat formatea = new DecimalFormat();

    public FrmCerrarCaja() {
        initComponents();
        inhabilitar();
        txtID.setVisible(false);
        txtIDCaja.setEnabled(false);
        cargarpasodefocus();
        centrar_Frm();
    }

    void centrar_Frm() {
        //codigo para centrar internalframe
        x = "x";
        int a = frmprincipal.jDesktopPane2.getWidth() - this.getWidth();
        int b = frmprincipal.jDesktopPane2.getHeight() - this.getHeight();
        setLocation(a / 2, b / 2);
        setVisible(true);
    }

    void cargarpasodefocus() {
        txtNroCaja.setNextFocusableComponent(jButton1);
        jButton1.setNextFocusableComponent(txtMontoApertura);
        txtMontoApertura.setNextFocusableComponent(txtmontocierre);
        txtmontocierre.setNextFocusableComponent(jFechaCierre);
        jFechaCierre.setNextFocusableComponent(txtDocumento);
        txtDocumento.setNextFocusableComponent(txtNroCaja);
    }
    static String opciones = "";

    public static void habilitar(boolean f) {

        txtMontoApertura.setEnabled(true);
        txtmontocierre.setEnabled(true);
        jFechaCierre.setEnabled(false);
        txtDocumento.setEnabled(true);
        txtmontoegreso.setEnabled(true);
        txtIDCaja.setText("");
        txtID.setText("");
        txtMontoApertura.setText("0");
        txtmontocierre.setText("0");
        txtDocumento.setText("");
        txtcapitalcaja.setText("0");
        txtnombreapellido.setText("");
        txtmontoventa.setText("0");
        btnguardar.setEnabled(true);

        txtbillete.setText("0");
        txtbillete1.setText("0");
        txtbillete2.setText("0");
        txtbillete3.setText("0");
        txtbillete4.setText("0");
        txtbillete5.setText("0");
        txtbillete6.setText("0");
        txtbillete7.setText("0");
        txtbillete8.setText("0");
        txtbillete9.setText("0");

        txtbillete.setText("0");
        txtbillete1.setText("0");
        txtbillete2.setText("0");
        txtbillete3.setText("0");
        txtbillete4.setText("0");
        txtbillete5.setText("0");
        txtbillete6.setText("0");
        txtbillete7.setText("0");
        txtbillete8.setText("0");
        txtbillete9.setText("0");

        txtdescripcion1.setText("sin detalle");
        txtdescripcion2.setText("sin detalle");
        txtdescripcion3.setText("sin detalle");
        txtdescripcion4.setText("sin detalle");
        txtdescripcion5.setText("sin detalle");

        txtmonto1.setText("0");
        txtmonto2.setText("0");
        txtmonto3.setText("0");
        txtmonto4.setText("0");
        txtmonto5.setText("0");

        txtdescripcion1.setEnabled(true);
        txtdescripcion2.setEnabled(true);
        txtdescripcion3.setEnabled(true);
        txtdescripcion4.setEnabled(true);
        txtdescripcion5.setEnabled(true);

        txtmonto1.setEnabled(true);
        txtmonto2.setEnabled(true);
        txtmonto3.setEnabled(true);
        txtmonto4.setEnabled(true);
        txtmonto5.setEnabled(true);

        txtbillete.setEnabled(true);
        txtbillete1.setEnabled(true);
        txtbillete2.setEnabled(true);
        txtbillete3.setEnabled(true);
        txtbillete4.setEnabled(true);
        txtbillete5.setEnabled(true);
        txtbillete6.setEnabled(true);
        txtbillete7.setEnabled(true);
        txtbillete8.setEnabled(true);
        txtbillete9.setEnabled(true);

        if (f == true) {
            Calendar c = Calendar.getInstance();
            String dia = Integer.toString(c.get(Calendar.DATE));
            String mes = Integer.toString(c.get(Calendar.MONTH) + 1);
            String anho = Integer.toString(c.get(Calendar.YEAR));
            String fechaactual = dia + "-" + mes + "-" + anho;
            try {
                java.util.Date fecha = new SimpleDateFormat("dd-MM-yyyy").parse(fechaactual);
                jFechaCierre.setDate(fecha);
            } catch (Exception e) {

            }

            txtmontocierre.requestFocus();
        }

    }

    public static void inhabilitar() {
        txtMontoApertura.setEnabled(true);
        txtmontocierre.setEnabled(true);
        jFechaCierre.setEnabled(false);
        txtcapitalcaja.setEnabled(true);
        txtmontoegreso.setEnabled(true);
        txtDocumento.setEnabled(true);
        txtnombreapellido.setEnabled(true);
        txtmontoventa.setEnabled(true);
        txtMontoApertura.setText("0");
        txtmontocierre.setText("0");
        txtcompras.setText("0");
        txtDocumento.setText("");
        txtnombreapellido.setText("");
        txtmontoventa.setText("0");
        txtcapitalcaja.setText("0");
        txtcontado.setText("0");
        txtmontoegreso.setText("0");
        txtotros.setText("0");
        txtcredito.setText("0");
        txtIDCaja.setText("");
        txtID.setText("");
        txtNroCaja.setText("");

        txtbillete.setText("0");
        txtbillete1.setText("0");
        txtbillete2.setText("0");
        txtbillete3.setText("0");
        txtbillete4.setText("0");
        txtbillete5.setText("0");
        txtbillete6.setText("0");
        txtbillete7.setText("0");
        txtbillete8.setText("0");
        txtbillete9.setText("0");

        txtdescripcion1.setText("sin detalle");
        txtdescripcion2.setText("sin detalle");
        txtdescripcion3.setText("sin detalle");
        txtdescripcion4.setText("sin detalle");
        txtdescripcion5.setText("sin detalle");

        txtmonto1.setText("0");
        txtmonto2.setText("0");
        txtmonto3.setText("0");
        txtmonto4.setText("0");
        txtmonto5.setText("0");

        txtdescripcion1.setEnabled(false);
        txtdescripcion2.setEnabled(false);
        txtdescripcion3.setEnabled(false);
        txtdescripcion4.setEnabled(false);
        txtdescripcion5.setEnabled(false);

        txtmonto1.setEnabled(false);
        txtmonto2.setEnabled(false);
        txtmonto3.setEnabled(false);
        txtmonto4.setEnabled(false);
        txtmonto5.setEnabled(false);

        txtbillete.setEnabled(false);
        txtbillete1.setEnabled(false);
        txtbillete2.setEnabled(false);
        txtbillete3.setEnabled(false);
        txtbillete4.setEnabled(false);
        txtbillete5.setEnabled(false);
        txtbillete6.setEnabled(false);
        txtbillete7.setEnabled(false);
        txtbillete8.setEnabled(false);
        txtbillete9.setEnabled(false);

        btnguardar.setEnabled(false);
    }

    //FUNCION PARA SUMAR EL ARQUEO
    void sumarqueo() {
        Integer billete = 0;
        billete = (Integer.parseInt(txtbillete.getText()) * 50)
                + (Integer.parseInt(txtbillete1.getText()) * 100)
                + (Integer.parseInt(txtbillete2.getText()) * 500)
                + (Integer.parseInt(txtbillete3.getText()) * 1000)
                + (Integer.parseInt(txtbillete4.getText()) * 2000)
                + (Integer.parseInt(txtbillete5.getText()) * 5000)
                + (Integer.parseInt(txtbillete6.getText()) * 10000)
                + (Integer.parseInt(txtbillete7.getText()) * 20000)
                + (Integer.parseInt(txtbillete8.getText()) * 50000)
                + (Integer.parseInt(txtbillete9.getText()) * 100000);
        txttotalarqueo.setText(String.valueOf((formatea.format((int) billete))));
    }

    public static void imprimir_cierre() {

        try {
            Connection cn = mysql.conectar();
//            System.out.println("imprimiendo");
            Map p = new HashMap();
            p.put("id", txtIDCaja.getText());
//            p.put("usuario", txtnombreapellido.getText());
//            p.put("contado", txtcontado.getText());
//            p.put("cobrado", txtcobrado.getText());
//            p.put("credito", txtcredito.getText());
//            p.put("egresos", txtmontoegreso.getText());
//            p.put("caja", txtcapitalcaja.getText());

            p.put("50", Integer.parseInt(txtbillete.getText()));
            p.put("100", Integer.parseInt(txtbillete1.getText()));
            p.put("500", Integer.parseInt(txtbillete2.getText()));
            p.put("1000", Integer.parseInt(txtbillete3.getText()));
            p.put("2000", Integer.parseInt(txtbillete4.getText()));
            p.put("5000", Integer.parseInt(txtbillete5.getText()));
            p.put("10000", Integer.parseInt(txtbillete6.getText()));
            p.put("20000", Integer.parseInt(txtbillete7.getText()));
            p.put("50000", Integer.parseInt(txtbillete8.getText()));
            p.put("100000", Integer.parseInt(txtbillete9.getText()));

            JasperReport jr;
            JasperPrint jp;

            jr = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/Reportes/rpt_cierre_caja.jrxml");//Jasper para tener vista en exel y demas editores de texto

            jp = JasperFillManager.fillReport(jr, p, cn);
//            JasperPrintManager.printReport(jp, true);

            JasperViewer view = new JasperViewer(jp, false);
            view.setTitle("Reporte de cierre");
            view.setVisible(true);
//            System.out.println("imprimiendo2");

        } catch (Exception e) {
        } finally {
//            cerramos la conexion
            mysql.desconectar();
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

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        txtMontoApertura = new javax.swing.JTextField();
        txtNroCaja = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtmontocierre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jFechaCierre = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        txtnombreapellido = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtmontoventa = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtIDCaja = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtmontoegreso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        txtcapitalcaja = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtcontado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtcobrado = new javax.swing.JTextField();
        txtcredito = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtotros = new javax.swing.JTextField();
        txtcompras = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtbillete = new javax.swing.JTextField();
        txtbillete1 = new javax.swing.JTextField();
        txtbillete2 = new javax.swing.JTextField();
        txtbillete3 = new javax.swing.JTextField();
        txtbillete4 = new javax.swing.JTextField();
        txtbillete5 = new javax.swing.JTextField();
        txtbillete6 = new javax.swing.JTextField();
        txtbillete7 = new javax.swing.JTextField();
        txtbillete8 = new javax.swing.JTextField();
        txtbillete9 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txttotalarqueo = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtdescripcion1 = new javax.swing.JTextField();
        txtmonto1 = new javax.swing.JTextField();
        txtdescripcion2 = new javax.swing.JTextField();
        txtdescripcion3 = new javax.swing.JTextField();
        txtdescripcion4 = new javax.swing.JTextField();
        txtdescripcion5 = new javax.swing.JTextField();
        txtmonto4 = new javax.swing.JTextField();
        txtmonto3 = new javax.swing.JTextField();
        txtmonto2 = new javax.swing.JTextField();
        txtmonto5 = new javax.swing.JTextField();

        setClosable(true);
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

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMontoApertura.setEditable(false);
        txtMontoApertura.setForeground(new java.awt.Color(0, 153, 0));
        txtMontoApertura.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtMontoApertura.setEnabled(false);
        txtMontoApertura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMontoAperturaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMontoAperturaFocusLost(evt);
            }
        });
        txtMontoApertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoAperturaActionPerformed(evt);
            }
        });
        txtMontoApertura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontoAperturaKeyReleased(evt);
            }
        });
        jPanel1.add(txtMontoApertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 157, 25));

        txtNroCaja.setEditable(false);
        txtNroCaja.setEnabled(false);
        txtNroCaja.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNroCajaFocusLost(evt);
            }
        });
        txtNroCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNroCajaActionPerformed(evt);
            }
        });
        txtNroCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroCajaKeyTyped(evt);
            }
        });
        jPanel1.add(txtNroCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 160, 25));

        jLabel2.setBackground(new java.awt.Color(222, 220, 220));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("NRO. CAJA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, 25));

        jLabel3.setBackground(new java.awt.Color(222, 220, 220));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("INGRESO VENTA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 100, 25));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar1 - copia.png"))); // NOI18N
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 40, 40));

        txtmontocierre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtmontocierreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtmontocierreFocusLost(evt);
            }
        });
        txtmontocierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmontocierreActionPerformed(evt);
            }
        });
        txtmontocierre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmontocierreKeyReleased(evt);
            }
        });
        jPanel1.add(txtmontocierre, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 157, 25));

        jLabel6.setBackground(new java.awt.Color(222, 220, 220));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("MONTO CIERRE");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 157, 25));

        jLabel8.setBackground(new java.awt.Color(222, 220, 220));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("FECHA CIERRE");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 100, 25));
        jPanel1.add(jFechaCierre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 157, 25));

        jLabel9.setBackground(new java.awt.Color(222, 220, 220));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("C.I.");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 100, 25));

        txtDocumento.setEditable(false);
        txtDocumento.setEnabled(false);
        txtDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDocumentoFocusLost(evt);
            }
        });
        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });
        jPanel1.add(txtDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 157, 25));

        txtnombreapellido.setEditable(false);
        txtnombreapellido.setEnabled(false);
        txtnombreapellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnombreapellidoFocusGained(evt);
            }
        });
        txtnombreapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreapellidoActionPerformed(evt);
            }
        });
        jPanel1.add(txtnombreapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 157, 25));

        jLabel10.setBackground(new java.awt.Color(222, 220, 220));
        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("COD. CIERRE DE CAJA");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 157, 25));

        jLabel5.setBackground(new java.awt.Color(222, 220, 220));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("MONTO APERTURA");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 134, 25));

        txtmontoventa.setEditable(false);
        txtmontoventa.setBackground(new java.awt.Color(255, 255, 153));
        txtmontoventa.setForeground(new java.awt.Color(0, 153, 0));
        txtmontoventa.setDisabledTextColor(new java.awt.Color(255, 255, 153));
        txtmontoventa.setEnabled(false);
        txtmontoventa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtmontoventaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtmontoventaFocusLost(evt);
            }
        });
        txtmontoventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmontoventaActionPerformed(evt);
            }
        });
        jPanel1.add(txtmontoventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 157, 25));

        txtID.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 10, -1));

        txtIDCaja.setBorder(null);
        txtIDCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDCajaActionPerformed(evt);
            }
        });
        jPanel1.add(txtIDCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 157, 25));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CIERRE CAJA");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1100, 30));

        txtmontoegreso.setEditable(false);
        txtmontoegreso.setBackground(new java.awt.Color(255, 255, 153));
        txtmontoegreso.setForeground(new java.awt.Color(255, 0, 0));
        txtmontoegreso.setEnabled(false);
        txtmontoegreso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtmontoegresoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtmontoegresoFocusLost(evt);
            }
        });
        txtmontoegreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmontoegresoActionPerformed(evt);
            }
        });
        jPanel1.add(txtmontoegreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 157, 25));

        jLabel4.setBackground(new java.awt.Color(222, 220, 220));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("EGRESO VENTA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 100, 25));

        btnguardar.setBackground(new java.awt.Color(255, 255, 255));
        btnguardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnguardar.setText("Cerrar Caja");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, 130, 40));

        txtcapitalcaja.setEditable(false);
        txtcapitalcaja.setForeground(new java.awt.Color(255, 153, 0));
        txtcapitalcaja.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtcapitalcaja.setEnabled(false);
        txtcapitalcaja.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcapitalcajaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcapitalcajaFocusLost(evt);
            }
        });
        txtcapitalcaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcapitalcajaActionPerformed(evt);
            }
        });
        jPanel1.add(txtcapitalcaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 157, 25));

        jLabel7.setBackground(new java.awt.Color(222, 220, 220));
        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("TOTAL CAJA");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 157, 25));

        txtcontado.setEditable(false);
        txtcontado.setBackground(new java.awt.Color(255, 255, 153));
        txtcontado.setForeground(new java.awt.Color(255, 0, 0));
        txtcontado.setEnabled(false);
        txtcontado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcontadoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcontadoFocusLost(evt);
            }
        });
        txtcontado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontadoActionPerformed(evt);
            }
        });
        jPanel1.add(txtcontado, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 157, 25));

        jLabel11.setBackground(new java.awt.Color(222, 220, 220));
        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("VENTA CONTADO");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, 25));

        jLabel12.setBackground(new java.awt.Color(222, 220, 220));
        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("VENTA CREDITO");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 157, 25));

        jLabel13.setBackground(new java.awt.Color(222, 220, 220));
        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("TOTAL COBRADO");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, 25));

        txtcobrado.setEditable(false);
        txtcobrado.setBackground(new java.awt.Color(255, 255, 153));
        txtcobrado.setForeground(new java.awt.Color(255, 0, 0));
        txtcobrado.setEnabled(false);
        txtcobrado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcobradoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcobradoFocusLost(evt);
            }
        });
        txtcobrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcobradoActionPerformed(evt);
            }
        });
        jPanel1.add(txtcobrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 157, 25));

        txtcredito.setEditable(false);
        txtcredito.setBackground(new java.awt.Color(255, 255, 153));
        txtcredito.setForeground(new java.awt.Color(255, 0, 0));
        txtcredito.setEnabled(false);
        txtcredito.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcreditoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcreditoFocusLost(evt);
            }
        });
        txtcredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcreditoActionPerformed(evt);
            }
        });
        jPanel1.add(txtcredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 157, 25));

        jLabel14.setBackground(new java.awt.Color(222, 220, 220));
        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("OTROS INGRESOS");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 121, 25));

        txtotros.setEditable(false);
        txtotros.setBackground(new java.awt.Color(255, 255, 153));
        txtotros.setForeground(new java.awt.Color(0, 153, 0));
        txtotros.setDisabledTextColor(new java.awt.Color(102, 204, 0));
        txtotros.setEnabled(false);
        txtotros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtotrosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtotrosFocusLost(evt);
            }
        });
        txtotros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtotrosActionPerformed(evt);
            }
        });
        jPanel1.add(txtotros, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 157, 25));

        txtcompras.setEditable(false);
        txtcompras.setBackground(new java.awt.Color(255, 255, 153));
        txtcompras.setForeground(new java.awt.Color(255, 0, 0));
        txtcompras.setEnabled(false);
        txtcompras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcomprasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcomprasFocusLost(evt);
            }
        });
        txtcompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcomprasActionPerformed(evt);
            }
        });
        jPanel1.add(txtcompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 157, 25));

        jLabel15.setBackground(new java.awt.Color(222, 220, 220));
        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("TOTAL COMPRAS");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 100, 25));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Arqueo de caja"));
        jPanel2.setName("Arqueo de caja"); // NOI18N

        jLabel16.setBackground(new java.awt.Color(222, 220, 220));
        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("50 GS");

        jLabel17.setBackground(new java.awt.Color(222, 220, 220));
        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("100 GS");

        jLabel18.setBackground(new java.awt.Color(222, 220, 220));
        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("500 GS");

        jLabel19.setBackground(new java.awt.Color(222, 220, 220));
        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("1.000 GS");

        jLabel20.setBackground(new java.awt.Color(222, 220, 220));
        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("2.000 GS");

        jLabel21.setBackground(new java.awt.Color(222, 220, 220));
        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("5.000 GS");

        jLabel22.setBackground(new java.awt.Color(222, 220, 220));
        jLabel22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("10.000GS");

        jLabel23.setBackground(new java.awt.Color(222, 220, 220));
        jLabel23.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("20.000 GS");

        jLabel24.setBackground(new java.awt.Color(222, 220, 220));
        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("50.000 GS");

        jLabel25.setBackground(new java.awt.Color(222, 220, 220));
        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("100.000 GS");

        txtbillete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbilleteKeyReleased(evt);
            }
        });

        txtbillete1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbillete1KeyReleased(evt);
            }
        });

        txtbillete2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbillete2KeyReleased(evt);
            }
        });

        txtbillete3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbillete3KeyReleased(evt);
            }
        });

        txtbillete4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbillete4KeyReleased(evt);
            }
        });

        txtbillete5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbillete5KeyReleased(evt);
            }
        });

        txtbillete6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbillete6KeyReleased(evt);
            }
        });

        txtbillete7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbillete7KeyReleased(evt);
            }
        });

        txtbillete8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbillete8KeyReleased(evt);
            }
        });

        txtbillete9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbillete9KeyReleased(evt);
            }
        });

        jLabel29.setBackground(new java.awt.Color(222, 220, 220));
        jLabel29.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("TOTAL");

        txttotalarqueo.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtbillete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtbillete5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtbillete6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtbillete7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtbillete8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtbillete9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtbillete2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtbillete3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtbillete4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtbillete1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttotalarqueo)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbillete, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbillete1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbillete2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbillete3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbillete4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbillete5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbillete6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbillete7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbillete8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbillete9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotalarqueo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 180, 380));

        jLabel26.setBackground(new java.awt.Color(222, 220, 220));
        jLabel26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("USUARIO");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 157, 25));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles Extras"));
        jPanel3.setName("Arqueo de caja"); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setBackground(new java.awt.Color(222, 220, 220));
        jLabel27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Descripcion");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 93, 25));

        jLabel28.setBackground(new java.awt.Color(222, 220, 220));
        jLabel28.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("Monto");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 65, 25));

        txtdescripcion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdescripcion1KeyReleased(evt);
            }
        });
        jPanel3.add(txtdescripcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 173, 25));

        txtmonto1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmonto1KeyReleased(evt);
            }
        });
        jPanel3.add(txtmonto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 78, 25));
        jPanel3.add(txtdescripcion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 173, 25));
        jPanel3.add(txtdescripcion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 173, 25));
        jPanel3.add(txtdescripcion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 173, 25));
        jPanel3.add(txtdescripcion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 173, 25));

        txtmonto4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmonto4KeyReleased(evt);
            }
        });
        jPanel3.add(txtmonto4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 77, 25));

        txtmonto3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmonto3KeyReleased(evt);
            }
        });
        jPanel3.add(txtmonto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 77, 25));

        txtmonto2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmonto2KeyReleased(evt);
            }
        });
        jPanel3.add(txtmonto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 78, 25));

        txtmonto5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmonto5KeyReleased(evt);
            }
        });
        jPanel3.add(txtmonto5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 77, 25));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, 290, 380));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtcomprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcomprasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcomprasActionPerformed

    private void txtcomprasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcomprasFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcomprasFocusLost

    private void txtcomprasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcomprasFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcomprasFocusGained

    private void txtotrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtotrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtotrosActionPerformed

    private void txtotrosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtotrosFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtotrosFocusLost

    private void txtotrosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtotrosFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtotrosFocusGained

    private void txtcreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcreditoActionPerformed

    private void txtcreditoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcreditoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcreditoFocusLost

    private void txtcreditoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcreditoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcreditoFocusGained

    private void txtcobradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcobradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcobradoActionPerformed

    private void txtcobradoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcobradoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcobradoFocusLost

    private void txtcobradoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcobradoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcobradoFocusGained

    private void txtcontadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontadoActionPerformed

    private void txtcontadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcontadoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontadoFocusLost

    private void txtcontadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcontadoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontadoFocusGained

    private void txtcapitalcajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcapitalcajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcapitalcajaActionPerformed

    private void txtcapitalcajaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcapitalcajaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcapitalcajaFocusLost

    private void txtcapitalcajaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcapitalcajaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcapitalcajaFocusGained


    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        guardareditar();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        frmprincipal.mostrarhoy(dtf.format(LocalDateTime.now()));


    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtmontoegresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmontoegresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontoegresoActionPerformed

    private void txtmontoegresoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmontoegresoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontoegresoFocusLost

    private void txtmontoegresoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmontoegresoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontoegresoFocusGained

    private void txtIDCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDCajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDCajaActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed

    }//GEN-LAST:event_txtIDActionPerformed

    private void txtmontoventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmontoventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontoventaActionPerformed

    private void txtmontoventaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmontoventaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontoventaFocusLost

    private void txtmontoventaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmontoventaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontoventaFocusGained

    private void txtnombreapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreapellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreapellidoActionPerformed

    private void txtnombreapellidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombreapellidoFocusGained
        // TODO add your handling code here:
        //        funControl.controlarestejtextfield(txtDocumento, "ESTE CAMPO NO PUEDE QUEDAR VACÍO");
    }//GEN-LAST:event_txtnombreapellidoFocusGained

    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoActionPerformed

    private void txtDocumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDocumentoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoFocusLost

    private void txtmontocierreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmontocierreKeyReleased
        // TODO add your handling code here:
        if (txtmontocierre.getText().length() >= 0) {
            txtmontocierre.setText(txtmontocierre.getText().replace(".", ""));
            int c = Integer.parseInt(txtmontocierre.getText());
            txtmontocierre.setText(formatea.format(c) + "");
        }
    }//GEN-LAST:event_txtmontocierreKeyReleased

    private void txtmontocierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmontocierreActionPerformed
        // TODO add your handling code here:
        txtDocumento.requestFocus();
    }//GEN-LAST:event_txtmontocierreActionPerformed

    private void txtmontocierreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmontocierreFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontocierreFocusLost

    private void txtmontocierreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmontocierreFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontocierreFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FrmVista2 form = new FrmVista2();

        form.setVisible(true);
        form.toFront();
        form.dondebuscar = 2;
        form.lbltitulovista.setText("CIERRE DE CAJA");
        DefaultComboBoxModel modelocbo;
        modelocbo = new DefaultComboBoxModel();
        modelocbo.addElement("ACTIVO");
        form.txtbuscar.setText(frmprincipal.lblcodusuario.getText());
        form.txtbuscar.setEnabled(false);
        form.jComboBox1.setModel(modelocbo);
        form.buscador();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNroCajaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroCajaKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if (txtNroCaja.getText().length() > 3) {
            evt.consume();
        }
        if (!Character.isDigit(key)) {

            evt.consume();
        }
    }//GEN-LAST:event_txtNroCajaKeyTyped

    private void txtNroCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNroCajaActionPerformed
        // TODO add your handling code here:
        jButton1.requestFocus();
    }//GEN-LAST:event_txtNroCajaActionPerformed

    private void txtNroCajaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNroCajaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNroCajaFocusLost

    private void txtMontoAperturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoAperturaKeyReleased
        if (txtMontoApertura.getText().length() >= 0) {
            txtMontoApertura.setText(txtMontoApertura.getText().replace(".", ""));
            int c = Integer.parseInt(txtMontoApertura.getText());
            txtMontoApertura.setText(formatea.format(c) + "");
        }// TODO add your handling code here:
    }//GEN-LAST:event_txtMontoAperturaKeyReleased

    private void txtMontoAperturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoAperturaActionPerformed
        // TODO add your handling code here:
        txtmontocierre.requestFocus();
    }//GEN-LAST:event_txtMontoAperturaActionPerformed

    private void txtMontoAperturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMontoAperturaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoAperturaFocusLost

    private void txtMontoAperturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMontoAperturaFocusGained
        // TODO add your handling code here:
        //       funControl.controlarestejtextfield(txtNroCaja,"ESTE CAMPO NO PUEDE QUEDAR VACÍO");
    }//GEN-LAST:event_txtMontoAperturaFocusGained

    private void txtbilleteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbilleteKeyReleased
        sumarqueo();
    }//GEN-LAST:event_txtbilleteKeyReleased

    private void txtdescripcion1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcion1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescripcion1KeyReleased

    private void txtmonto1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmonto1KeyReleased
        if (txtmonto1.getText().length() >= 0) {
            txtmonto1.setText(txtmonto1.getText().replace(".", ""));
            int c = Integer.parseInt(txtmonto1.getText());
            txtmonto1.setText(formatea.format(c) + "");
        }
    }//GEN-LAST:event_txtmonto1KeyReleased

    private void txtmonto2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmonto2KeyReleased
        if (txtmonto2.getText().length() >= 0) {
            txtmonto2.setText(txtmonto2.getText().replace(".", ""));
            int c = Integer.parseInt(txtmonto2.getText());
            txtmonto2.setText(formatea.format(c) + "");
        }
    }//GEN-LAST:event_txtmonto2KeyReleased

    private void txtmonto3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmonto3KeyReleased
        if (txtmonto3.getText().length() >= 0) {
            txtmonto3.setText(txtmonto3.getText().replace(".", ""));
            int c = Integer.parseInt(txtmonto3.getText());
            txtmonto3.setText(formatea.format(c) + "");
        }
    }//GEN-LAST:event_txtmonto3KeyReleased

    private void txtmonto4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmonto4KeyReleased
        if (txtmonto4.getText().length() >= 0) {
            txtmonto4.setText(txtmonto4.getText().replace(".", ""));
            int c = Integer.parseInt(txtmonto4.getText());
            txtmonto4.setText(formatea.format(c) + "");
        }
    }//GEN-LAST:event_txtmonto4KeyReleased

    private void txtmonto5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmonto5KeyReleased
        if (txtmonto5.getText().length() >= 0) {
            txtmonto5.setText(txtmonto5.getText().replace(".", ""));
            int c = Integer.parseInt(txtmonto5.getText());
            txtmonto5.setText(formatea.format(c) + "");
        }
    }//GEN-LAST:event_txtmonto5KeyReleased

    private void txtbillete1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbillete1KeyReleased
        sumarqueo();
    }//GEN-LAST:event_txtbillete1KeyReleased

    private void txtbillete2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbillete2KeyReleased
        sumarqueo();
    }//GEN-LAST:event_txtbillete2KeyReleased

    private void txtbillete3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbillete3KeyReleased
        sumarqueo();
    }//GEN-LAST:event_txtbillete3KeyReleased

    private void txtbillete4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbillete4KeyReleased
        sumarqueo();
    }//GEN-LAST:event_txtbillete4KeyReleased

    private void txtbillete5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbillete5KeyReleased
        sumarqueo();
    }//GEN-LAST:event_txtbillete5KeyReleased

    private void txtbillete6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbillete6KeyReleased
        sumarqueo();
    }//GEN-LAST:event_txtbillete6KeyReleased

    private void txtbillete7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbillete7KeyReleased
        sumarqueo();
    }//GEN-LAST:event_txtbillete7KeyReleased

    private void txtbillete8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbillete8KeyReleased
        sumarqueo();
    }//GEN-LAST:event_txtbillete8KeyReleased

    private void txtbillete9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbillete9KeyReleased
        sumarqueo();
    }//GEN-LAST:event_txtbillete9KeyReleased
    static void guardareditar() {
        if (txtNroCaja.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "FALTO EL NRO DE CAJA");
            return;
        }
        if (txtbillete.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "DEBES INGRESAR LA CANTIDAD DE BILLETES");
            return;
        }
        if (txtbillete1.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "DEBES INGRESAR LA CANTIDAD DE BILLETES");
            return;
        }
        if (txtbillete2.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "DEBES INGRESAR LA CANTIDAD DE BILLETES");
            return;
        }
        if (txtbillete3.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "DEBES INGRESAR LA CANTIDAD DE BILLETES");
            return;
        }
        if (txtbillete4.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "DEBES INGRESAR LA CANTIDAD DE BILLETES");
            return;
        }
        if (txtbillete5.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "DEBES INGRESAR LA CANTIDAD DE BILLETES");
            return;
        }
        if (txtbillete6.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "DEBES INGRESAR LA CANTIDAD DE BILLETES");
            return;
        }
        if (txtbillete7.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "DEBES INGRESAR LA CANTIDAD DE BILLETES");
            return;
        }
        if (txtbillete8.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "DEBES INGRESAR LA CANTIDAD DE BILLETES");
            return;
        }
        if (txtbillete9.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "DEBES INGRESAR LA CANTIDAD DE BILLETES");
            return;
        }

        String montoApertura = txtMontoApertura.getText();
        String montoCierre = txtmontocierre.getText();
        String montototal = txtcapitalcaja.getText();

        try {

            montoApertura = montoApertura.replace(".", "");
            montoApertura = montoApertura.replace(",", ".");
            if (Double.parseDouble(montoApertura) <= 0) {
                JOptionPane.showMessageDialog(null, "LA CANTIDAD NO PUEDE SER MENOR A 0");
                return;
            }

            montoCierre = montoCierre.replace(".", "");
            montoCierre = montoCierre.replace(",", ".");
            montototal = montototal.replace(".", "");
            montoCierre = montoCierre.replace(",", ".");

            if (Double.parseDouble(montototal) != Double.parseDouble(montoCierre)) {
                JOptionPane.showMessageDialog(null, "EL MONTO NO PUEDE SER MENOR A 0 NI DIFERENTE AL TOTAL DE LA CAJA");
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "LA CANTIDAD INGRESADA DEL MONTO APERTURA O MONTO CIERRE ES INVALIDO");
            return;
        }

        fmovimiento_caja func = new fmovimiento_caja();

        vmovimiento_caja dts = new vmovimiento_caja();

//        dts.setNrocaja(txtNroCaja.getText());
        dts.setMonto_apertura(Long.parseLong(montoApertura));
        dts.setMonto_cierre(Long.parseLong(montoCierre));
        Calendar cal;
        int d, m, a;
        cal = jFechaCierre.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        dts.setFecha_cierre(new Date(a, m, d));

        dts.setEstado("CERRADO");

        dts.setIdmovimiento(Integer.parseInt(txtIDCaja.getText()));
        dts.setContado(Long.parseLong(txtcontado.getText().replaceAll("\\.", "")));
        dts.setCredito(Long.parseLong(txtcredito.getText().replaceAll("\\.", "")));
        dts.setGastos(Long.parseLong(txtmontoegreso.getText().replaceAll("\\.", "")));
        dts.setIngresos(Long.parseLong(txtotros.getText().replaceAll("\\.", "")));
        dts.setCompras(Long.parseLong(txtcompras.getText().replaceAll("\\.", "")));
        dts.setCobrado(Long.parseLong(txtcobrado.getText().replaceAll("\\.", "")));

        if (func.cerraCaja(dts)) {

            JOptionPane.showMessageDialog(null, "CAJA CERRADA CORRECTAMENTE");
//            ();
            guardararqueo();
            inhabilitar();
            frmprincipal.lblidmovimiento2.setText("0");
            frmprincipal.ocultar();

        }

    }

    static void guardararqueo() {

        farqueo func2 = new farqueo();

        varqueo dts = new varqueo();

        dts.setDetalle1(txtdescripcion1.getText());
        dts.setDetalle2(txtdescripcion2.getText());
        dts.setDetalle3(txtdescripcion3.getText());
        dts.setDetalle4(txtdescripcion4.getText());
        dts.setDetalle5(txtdescripcion5.getText());

        dts.setMonto1(Long.parseLong(txtmonto1.getText().replaceAll("\\.", "")));
        dts.setMonto2(Long.parseLong(txtmonto2.getText().replaceAll("\\.", "")));
        dts.setMonto3(Long.parseLong(txtmonto3.getText().replaceAll("\\.", "")));
        dts.setMonto4(Long.parseLong(txtmonto4.getText().replaceAll("\\.", "")));
        dts.setMonto5(Long.parseLong(txtmonto5.getText().replaceAll("\\.", "")));

        dts.setA50(Integer.parseInt(txtbillete.getText()));
        dts.setA100(Integer.parseInt(txtbillete1.getText()));
        dts.setA500(Integer.parseInt(txtbillete2.getText()));
        dts.setA1000(Integer.parseInt(txtbillete3.getText()));
        dts.setA2000(Integer.parseInt(txtbillete4.getText()));
        dts.setA5000(Integer.parseInt(txtbillete5.getText()));
        dts.setA10000(Integer.parseInt(txtbillete6.getText()));
        dts.setA20000(Integer.parseInt(txtbillete7.getText()));
        dts.setA50000(Integer.parseInt(txtbillete8.getText()));
        dts.setA100000(Integer.parseInt(txtbillete9.getText()));

        dts.setTotal(Long.parseLong(txttotalarqueo.getText().replaceAll("\\.", "")));

//        dts.setIdarqueo(Integer.parseInt(frmprincipal.lblidmovimiento2.getText()));
        dts.setIdmovimiento(Integer.parseInt(txtIDCaja.getText()));

        if (func2.insertar(dts)) {
        }
        imprimir_cierre();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCerrarCaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnguardar;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JCalendar jCalendar1;
    public static com.toedter.calendar.JDateChooser jFechaCierre;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JTextField txtDocumento;
    public static javax.swing.JTextField txtID;
    public static javax.swing.JTextField txtIDCaja;
    public static javax.swing.JTextField txtMontoApertura;
    public static javax.swing.JTextField txtNroCaja;
    public static javax.swing.JTextField txtbillete;
    public static javax.swing.JTextField txtbillete1;
    public static javax.swing.JTextField txtbillete2;
    public static javax.swing.JTextField txtbillete3;
    public static javax.swing.JTextField txtbillete4;
    public static javax.swing.JTextField txtbillete5;
    public static javax.swing.JTextField txtbillete6;
    public static javax.swing.JTextField txtbillete7;
    public static javax.swing.JTextField txtbillete8;
    public static javax.swing.JTextField txtbillete9;
    public static javax.swing.JTextField txtcapitalcaja;
    public static javax.swing.JTextField txtcobrado;
    public static javax.swing.JTextField txtcompras;
    public static javax.swing.JTextField txtcontado;
    public static javax.swing.JTextField txtcredito;
    public static javax.swing.JTextField txtdescripcion1;
    public static javax.swing.JTextField txtdescripcion2;
    public static javax.swing.JTextField txtdescripcion3;
    public static javax.swing.JTextField txtdescripcion4;
    public static javax.swing.JTextField txtdescripcion5;
    public static javax.swing.JTextField txtmonto1;
    public static javax.swing.JTextField txtmonto2;
    public static javax.swing.JTextField txtmonto3;
    public static javax.swing.JTextField txtmonto4;
    public static javax.swing.JTextField txtmonto5;
    public static javax.swing.JTextField txtmontocierre;
    public static javax.swing.JTextField txtmontoegreso;
    public static javax.swing.JTextField txtmontoventa;
    public static javax.swing.JTextField txtnombreapellido;
    public static javax.swing.JTextField txtotros;
    public static javax.swing.JTextField txttotalarqueo;
    // End of variables declaration//GEN-END:variables

}
