package Presentacion;

import CONSULTAS.frmImprimir_cierre;
import CONSULTAS.frmconsulta_productos;
import CONSULTAS.frmhistorial_ventas;
import CONSULTAS.frmpaciente_consulta;
import CONSULTAS.frmusuarios_consulta;
import CONSULTAS.frmImprimir_factura;
import CONSULTAS.frm_ingreso_egreso;
import CONSULTAS.frm_ingreso_egreso_final;
import CONSULTAS.frmhistorial_compras;
import CONSULTAS.frmventa_general;
import CONSULTAS.frmventas_diarias;
import Logica.StyloTabla;
import Logica.fmovimiento_caja;
import Respaldos.Backup;
import Respaldos.HiloLector;
import Respaldos.copia_de_seguridad;
import Respaldos.frmrestaurar_copia;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jose Ayala
 */
public class frmprincipal extends javax.swing.JFrame {

    Fondopanel fondo = new Fondopanel();//declaramos una variable de tipo panel llamada fondo
    public static String id_usuario;
    public static String usuario;
    public static String documento;

    public frmprincipal() {

        setIconImage(getIconImage());//agregamos un icono al jframe
        this.setContentPane(fondo);//establecemos la imagen solo al jframe
        initComponents();

        StyloTabla st = new StyloTabla();
        this.setExtendedState(frmprincipal.MAXIMIZED_BOTH);
        ocultar();

//        fecha();
    }

    //funcion para agregar un icono al formulario
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Iconos/venta.png"));
        return retValue;
    }

    //funcion para ocultar elementos del formulario
    public static void ocultar() {
        lblcodusuario.setVisible(false);
//        lbldocumento.setVisible(false);
        lblidmovimiento2.setVisible(false);

        txthoy.setText("0");
//        txthoy1.setText("0");
        txtcontado.setText("0");
        txtcontado1.setText("0");
        txtcredito.setText("0");
        txtcredito1.setText("0");
        txtcaja.setText("0");
        txtpagado.setText("0");
        txtpagado1.setText("0");
        txtegresos.setText("0");
        txtegresos1.setText("0");
        txtingresos.setText("0");
        txtingresos1.setText("0");
        TXTCOMPRAS.setText("0");
        TXTCOMPRAS1.setText("0");
        txtapertura.setText("0");
        txtcaja.setText("0");
        txtgananciahoy.setText("0");
        txtgananciatotal.setText("0");

        txtcontado.setEnabled(false);
        txtcaja.setEnabled(false);
        txthoy.setEnabled(false);
        txtcredito.setEnabled(false);
        txtpagado.setEnabled(false);
        txtapertura.setEnabled(false);
        txtegresos.setEnabled(false);
        txtgananciahoy.setEnabled(false);
        txtgananciatotal.setEnabled(false);

//        txtcontado1.setVisible(false);
//        txtcredito1.setVisible(false);
//        txtpagado1.setVisible(false);
//        txtegresos1.setVisible(false);
//        txtingresos1.setVisible(false);
//        TXTCOMPRAS1.setVisible(false);
    }
//funcion para hacer backup cuando se cierra el sistema

    void backup() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaback = dtf.format(LocalDateTime.now());

        try {
            Process p = Runtime.getRuntime().exec("C:\\Program Files\\MySQL\\MySQL Server 5.6\\bin\\mysqldump -udb_ventas_user -p12345 ventas");

            new HiloLector(p.getErrorStream()).start();

            InputStream is = p.getInputStream();//Pedimos la entrada

            FileOutputStream fos = new FileOutputStream("backup\\backup_ventas--" + fechaback + "--.sql"); //creamos el archivo para le respaldo

            byte[] buffer = new byte[1000]; //Creamos una variable de tipo byte para el buffer

            int leido = is.read(buffer); //Devuelve el número de bytes leídos o -1 si se alcanzó el final del stream.

            while (leido > 0) {
                fos.write(buffer, 0, leido);//Buffer de caracteres, Desplazamiento de partida para empezar a escribir caracteres, Número de caracteres para escribir
                leido = is.read(buffer);
            }

            fos.close();//Cierra respaldo

        } catch (IOException ex) {
            Logger.getLogger(copia_de_seguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    void mostrar() {
//        try {
//            fmovimiento_caja func = new fmovimiento_caja();
//
//            func.mostrar_ultimo_id();
////            func.mostrarTotalAcumuladoPagosVentas(lblidmovimiento2.getText());
//
//        } catch (Exception e) {
//            JOptionPane.showConfirmDialog(rootPane, e);
//        }
//    }
    static DecimalFormat format = new DecimalFormat("###,###.##");

    //funcion para mostrar los montos en los jtextfield
    public static void mostrarhoy(String fecha) {
        frmusuariologin.idmovimiento = Integer.parseInt(lblidmovimiento2.getText());
        fmovimiento_caja func = new fmovimiento_caja();
//            func.mostrar_ultimo_id(lblcodusuario.getText());

        func.ventashoy(String.valueOf(frmusuariologin.idmovimiento), fecha);
        func.ventasmod(String.valueOf(frmusuariologin.idmovimiento));
        func.creditohoy(String.valueOf(frmusuariologin.idmovimiento), fecha);
        func.creditomod(String.valueOf(frmusuariologin.idmovimiento));
        func.cobradohoy(String.valueOf(frmusuariologin.idmovimiento), fecha);
        func.cobradomod(String.valueOf(frmusuariologin.idmovimiento));
        func.egresohoy(String.valueOf(frmusuariologin.idmovimiento), fecha);
        func.egresomov(String.valueOf(frmusuariologin.idmovimiento));
        func.ingresohoy(String.valueOf(frmusuariologin.idmovimiento), fecha);
        func.ingresomov(String.valueOf(frmusuariologin.idmovimiento));
        func.comprashoy(String.valueOf(frmusuariologin.idmovimiento), fecha);
        func.comprasmov(String.valueOf(frmusuariologin.idmovimiento));
        func.aperturahoy(String.valueOf(frmusuariologin.idmovimiento));
        func.gananciatotal(String.valueOf(frmusuariologin.idmovimiento));
        func.gananciashoy(String.valueOf(frmusuariologin.idmovimiento), fecha);

        int egre = Integer.parseInt(txtegresos1.getText().replace(".", ""));
        int ingre = Integer.parseInt(txtingresos1.getText().replace(".", ""));
        int pago = Integer.parseInt(txtpagado1.getText().replace(".", ""));
        int cont = Integer.parseInt(txtcontado1.getText().replace(".", ""));
        int cont2 = Integer.parseInt(txtcontado.getText().replace(".", ""));
        int cred = Integer.parseInt(txtcredito.getText().replace(".", ""));
        int aper = Integer.parseInt(txtapertura.getText().replace(".", ""));
        int compra = Integer.parseInt(TXTCOMPRAS1.getText().replace(".", ""));

        int totalhoy = cont2 + cred;
        int caj = (cont + aper + ingre + pago) - (compra + egre);
        txthoy.setText(String.valueOf(format.format((int) totalhoy)));
        txtcaja.setText(String.valueOf(format.format((int) caj)));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane2 = new javax.swing.JDesktopPane();
        jPanel2 = new Fondopanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtcontado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txthoy = new javax.swing.JTextField();
        txtcredito = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtpagado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtcaja = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtegresos = new javax.swing.JTextField();
        txtapertura = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtingresos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TXTCOMPRAS = new javax.swing.JTextField();
        txtingresos1 = new javax.swing.JTextField();
        TXTCOMPRAS1 = new javax.swing.JTextField();
        txtcontado1 = new javax.swing.JTextField();
        txtcredito1 = new javax.swing.JTextField();
        txtpagado1 = new javax.swing.JTextField();
        txtegresos1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtgananciatotal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtgananciahoy = new javax.swing.JTextField();
        lbl = new javax.swing.JLabel();
        lblfechahoy = new javax.swing.JLabel();
        lblcodusuario = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblacceso = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblusuario = new javax.swing.JLabel();
        lblidmovimiento2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menumovimiento = new javax.swing.JMenu();
        menuventas = new javax.swing.JMenuItem();
        menucompras = new javax.swing.JMenuItem();
        apertura = new javax.swing.JMenuItem();
        cierre = new javax.swing.JMenuItem();
        registros = new javax.swing.JMenu();
        MENUUSUARIO = new javax.swing.JMenuItem();
        menuproductos = new javax.swing.JMenuItem();
        menucliente = new javax.swing.JMenuItem();
        menucategoria = new javax.swing.JMenuItem();
        menuproveedor = new javax.swing.JMenuItem();
        menuingresoyegre = new javax.swing.JMenuItem();
        menupagodeuda = new javax.swing.JMenuItem();
        menureporte = new javax.swing.JMenu();
        rptusuarios = new javax.swing.JMenuItem();
        imprimirfactura = new javax.swing.JMenuItem();
        imprimirfactura1 = new javax.swing.JMenuItem();
        rptclientes = new javax.swing.JMenuItem();
        cutMenuItem5 = new javax.swing.JMenuItem();
        historialventas1 = new javax.swing.JMenuItem();
        historialventas_dia = new javax.swing.JMenuItem();
        historialventas_cliente = new javax.swing.JMenuItem();
        historial_compras = new javax.swing.JMenuItem();
        menuIngresos_Egresos_historial = new javax.swing.JMenuItem();
        resumenIE = new javax.swing.JMenuItem();
        menurespaldo = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Reporte diario"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("TOTALES DEL CIERRE");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 20, 170, -1));

        txtcontado.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtcontado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtcontado.setEnabled(false);
        txtcontado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontadoActionPerformed(evt);
            }
        });
        jPanel3.add(txtcontado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 130, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CONTADO:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 90, -1));

        txthoy.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txthoy.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txthoy.setEnabled(false);
        txthoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthoyActionPerformed(evt);
            }
        });
        jPanel3.add(txthoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 130, 30));

        txtcredito.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtcredito.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtcredito.setEnabled(false);
        txtcredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcreditoActionPerformed(evt);
            }
        });
        jPanel3.add(txtcredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 130, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("CREDITO:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("PAGADO:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 90, -1));

        txtpagado.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtpagado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtpagado.setEnabled(false);
        txtpagado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpagadoActionPerformed(evt);
            }
        });
        jPanel3.add(txtpagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 130, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel7.setText("TOTAL CAJA:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 520, 140, 30));

        txtcaja.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        txtcaja.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtcaja.setEnabled(false);
        txtcaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcajaActionPerformed(evt);
            }
        });
        jPanel3.add(txtcaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, 170, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("EGRESOS:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 90, -1));

        txtegresos.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtegresos.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtegresos.setEnabled(false);
        txtegresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtegresosActionPerformed(evt);
            }
        });
        jPanel3.add(txtegresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 130, 30));

        txtapertura.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtapertura.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtapertura.setEnabled(false);
        txtapertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaperturaActionPerformed(evt);
            }
        });
        jPanel3.add(txtapertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 130, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("MONTO APERTURA:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 148, -1));

        txtingresos.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtingresos.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtingresos.setEnabled(false);
        txtingresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtingresosActionPerformed(evt);
            }
        });
        jPanel3.add(txtingresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 130, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("INGRESOS:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 90, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("COMPRAS:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 90, -1));

        TXTCOMPRAS.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        TXTCOMPRAS.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TXTCOMPRAS.setEnabled(false);
        TXTCOMPRAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTCOMPRASActionPerformed(evt);
            }
        });
        jPanel3.add(TXTCOMPRAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 130, 30));

        txtingresos1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtingresos1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtingresos1.setEnabled(false);
        txtingresos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtingresos1ActionPerformed(evt);
            }
        });
        jPanel3.add(txtingresos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 130, 30));

        TXTCOMPRAS1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        TXTCOMPRAS1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TXTCOMPRAS1.setEnabled(false);
        TXTCOMPRAS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTCOMPRAS1ActionPerformed(evt);
            }
        });
        jPanel3.add(TXTCOMPRAS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 130, 30));

        txtcontado1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtcontado1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtcontado1.setEnabled(false);
        txtcontado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontado1ActionPerformed(evt);
            }
        });
        jPanel3.add(txtcontado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 130, 30));

        txtcredito1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtcredito1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtcredito1.setEnabled(false);
        txtcredito1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcredito1ActionPerformed(evt);
            }
        });
        jPanel3.add(txtcredito1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 130, 30));

        txtpagado1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtpagado1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtpagado1.setEnabled(false);
        txtpagado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpagado1ActionPerformed(evt);
            }
        });
        jPanel3.add(txtpagado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 130, 30));

        txtegresos1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtegresos1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtegresos1.setEnabled(false);
        txtegresos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtegresos1ActionPerformed(evt);
            }
        });
        jPanel3.add(txtegresos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 130, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("VENDIDO HOY:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("TOTALES DEL DIA");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 20, 140, -1));

        txtgananciatotal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtgananciatotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtgananciatotal.setEnabled(false);
        txtgananciatotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgananciatotalActionPerformed(evt);
            }
        });
        jPanel3.add(txtgananciatotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 130, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("GANANCIA VENTA:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 140, -1));

        txtgananciahoy.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtgananciahoy.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtgananciahoy.setEnabled(false);
        txtgananciahoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgananciahoyActionPerformed(evt);
            }
        });
        jPanel3.add(txtgananciahoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 130, 30));

        lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl.setForeground(new java.awt.Color(255, 255, 255));
        lbl.setText("Fecha :");

        lblfechahoy.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblfechahoy.setForeground(new java.awt.Color(255, 255, 255));
        lblfechahoy.setText("FECHA");

        lblcodusuario.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblcodusuario.setText("Cod_USUARIO");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ACCESO:");

        lblacceso.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblacceso.setForeground(new java.awt.Color(255, 255, 255));
        lblacceso.setText("LABEL2");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("USUARIO:");

        lblusuario.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblusuario.setForeground(new java.awt.Color(255, 255, 255));
        lblusuario.setText("LABEL1");

        lblidmovimiento2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblidmovimiento2.setText("ID Mov");

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CAMBIAR USUARIO");
        jButton1.setToolTipText("CAMBIAR USUARIO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lblfechahoy, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 575, Short.MAX_VALUE)
                .addComponent(lblidmovimiento2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblcodusuario)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(lblacceso, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblfechahoy, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(lblcodusuario)
                                .addComponent(lblidmovimiento2))
                            .addComponent(lblacceso)
                            .addComponent(jLabel4)
                            .addComponent(lblusuario)))))
        );

        jDesktopPane2.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menumovimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/caja.png"))); // NOI18N
        menumovimiento.setText("Movimiento");
        menumovimiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        menuventas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        menuventas.setText("Ventas");
        menuventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuventasActionPerformed(evt);
            }
        });
        menumovimiento.add(menuventas);

        menucompras.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menucompras.setText("Compras");
        menucompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menucomprasActionPerformed(evt);
            }
        });
        menumovimiento.add(menucompras);

        apertura.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        apertura.setText("Apertura Caja");
        apertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aperturaActionPerformed(evt);
            }
        });
        menumovimiento.add(apertura);

        cierre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        cierre.setText("Cierre Caja");
        cierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cierreActionPerformed(evt);
            }
        });
        menumovimiento.add(cierre);

        menuBar.add(menumovimiento);

        registros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save.png"))); // NOI18N
        registros.setMnemonic('f');
        registros.setText("Registros");
        registros.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        MENUUSUARIO.setMnemonic('x');
        MENUUSUARIO.setText("Usuarios");
        MENUUSUARIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MENUUSUARIOActionPerformed(evt);
            }
        });
        registros.add(MENUUSUARIO);

        menuproductos.setMnemonic('t');
        menuproductos.setText("Productos");
        menuproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuproductosActionPerformed(evt);
            }
        });
        registros.add(menuproductos);

        menucliente.setMnemonic('t');
        menucliente.setText("Clientes");
        menucliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuclienteActionPerformed(evt);
            }
        });
        registros.add(menucliente);

        menucategoria.setMnemonic('t');
        menucategoria.setText("Categorias");
        menucategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menucategoriaActionPerformed(evt);
            }
        });
        registros.add(menucategoria);

        menuproveedor.setMnemonic('t');
        menuproveedor.setText("Proveedores");
        menuproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuproveedorActionPerformed(evt);
            }
        });
        registros.add(menuproveedor);

        menuingresoyegre.setMnemonic('t');
        menuingresoyegre.setText("Ingresos y Egresos");
        menuingresoyegre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuingresoyegreActionPerformed(evt);
            }
        });
        registros.add(menuingresoyegre);

        menupagodeuda.setMnemonic('t');
        menupagodeuda.setText("Pago de deudas");
        menupagodeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menupagodeudaActionPerformed(evt);
            }
        });
        registros.add(menupagodeuda);

        menuBar.add(registros);

        menureporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/estadistica.png"))); // NOI18N
        menureporte.setMnemonic('e');
        menureporte.setText("Reportes");
        menureporte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        rptusuarios.setMnemonic('t');
        rptusuarios.setText("Reporte Usuarios");
        rptusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rptusuariosActionPerformed(evt);
            }
        });
        menureporte.add(rptusuarios);

        imprimirfactura.setMnemonic('t');
        imprimirfactura.setText("Imprimir Factura");
        imprimirfactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirfacturaActionPerformed(evt);
            }
        });
        menureporte.add(imprimirfactura);

        imprimirfactura1.setMnemonic('t');
        imprimirfactura1.setText("Imprimir Cierre de caja");
        imprimirfactura1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirfactura1ActionPerformed(evt);
            }
        });
        menureporte.add(imprimirfactura1);

        rptclientes.setMnemonic('t');
        rptclientes.setText("Reporte Clientes");
        rptclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rptclientesActionPerformed(evt);
            }
        });
        menureporte.add(rptclientes);

        cutMenuItem5.setMnemonic('t');
        cutMenuItem5.setText("Reporte Productos");
        cutMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItem5ActionPerformed(evt);
            }
        });
        menureporte.add(cutMenuItem5);

        historialventas1.setMnemonic('t');
        historialventas1.setText("Historial Ventas");
        historialventas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialventas1ActionPerformed(evt);
            }
        });
        menureporte.add(historialventas1);

        historialventas_dia.setMnemonic('t');
        historialventas_dia.setText("Venta total del dia");
        historialventas_dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialventas_diaActionPerformed(evt);
            }
        });
        menureporte.add(historialventas_dia);

        historialventas_cliente.setMnemonic('t');
        historialventas_cliente.setText("Venta general por  cliente");
        historialventas_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialventas_clienteActionPerformed(evt);
            }
        });
        menureporte.add(historialventas_cliente);

        historial_compras.setMnemonic('t');
        historial_compras.setText("Historial Compras");
        historial_compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historial_comprasActionPerformed(evt);
            }
        });
        menureporte.add(historial_compras);

        menuIngresos_Egresos_historial.setMnemonic('t');
        menuIngresos_Egresos_historial.setText("Ingresos y Egresos");
        menuIngresos_Egresos_historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIngresos_Egresos_historialActionPerformed(evt);
            }
        });
        menureporte.add(menuIngresos_Egresos_historial);

        resumenIE.setMnemonic('t');
        resumenIE.setText("Resumen Ingresos y Egresos");
        resumenIE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumenIEActionPerformed(evt);
            }
        });
        menureporte.add(resumenIE);

        menuBar.add(menureporte);

        menurespaldo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/copias.png"))); // NOI18N
        menurespaldo.setMnemonic('f');
        menurespaldo.setText("Respaldo");
        menurespaldo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menurespaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menurespaldoActionPerformed(evt);
            }
        });

        jMenuItem5.setText("Copia de Seguridad");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menurespaldo.add(jMenuItem5);

        jMenuItem6.setText("Restaurar copia");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menurespaldo.add(jMenuItem6);

        menuBar.add(menurespaldo);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MENUUSUARIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MENUUSUARIOActionPerformed
        String x = frmusuario.x;
        try {
            if (x == null) {
                frmusuario form = new frmusuario();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_MENUUSUARIOActionPerformed
    static String idcaja1;
    private void menuventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuventasActionPerformed
        fmovimiento_caja func1 = new fmovimiento_caja();
        String[] registro = new String[8];
        registro = func1.obtenerdatos(frmprincipal.lblcodusuario.getText());
        idcaja1 = registro[0];
//        JOptionPane.showMessageDialog(null, idcaja1);
        if (registro[0].equals("")) {
            JOptionPane.showMessageDialog(null, "DEBE REALIZAR LA APERTURA DE CAJA PÁRA HACER LAS VENTAS");        // TODO add your handling code here:

        } else {
            String x = frmventas.x;
            try {
                if (x == null) {
                    frmventas form = new frmventas();
                    jDesktopPane2.add(form);
                    jDesktopPane2.moveToFront(form);
                    form.btnb_Cliente.requestFocus(true);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_menuventasActionPerformed

    private void imprimirfacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirfacturaActionPerformed
        // TODO add your handling code here:
        String x = frmImprimir_factura.x;
        try {
            if (x == null) {
                frmImprimir_factura form = new frmImprimir_factura();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_imprimirfacturaActionPerformed

    private void rptusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rptusuariosActionPerformed
        String x = frmusuarios_consulta.x;
        try {
            if (x == null) {
                frmusuarios_consulta form = new frmusuarios_consulta();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_rptusuariosActionPerformed

    private void rptclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rptclientesActionPerformed
        String x = frmpaciente_consulta.x;
        try {
            if (x == null) {
                frmpaciente_consulta form = new frmpaciente_consulta();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_rptclientesActionPerformed


    private void cutMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItem5ActionPerformed
        String x = frmconsulta_productos.x;
        try {
            if (x == null) {
                frmconsulta_productos form = new frmconsulta_productos();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);

            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cutMenuItem5ActionPerformed

    private void menuproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuproductosActionPerformed
        String x = frmproducto2.x;
        try {
            if (x == null) {
                frmproducto2 form = new frmproducto2();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_menuproductosActionPerformed

    private void menuclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuclienteActionPerformed
        String x = frmpaciente.x;
        try {
            if (x == null) {
                frmpaciente form = new frmpaciente();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
                form.btnnuevo.requestFocus();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_menuclienteActionPerformed

    private void aperturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aperturaActionPerformed
        String x = FrmApertura_Caja.x;
        try {
            if (x == null) {
                FrmApertura_Caja form = new FrmApertura_Caja();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
//                documento = lbldocumento.getText();
                id_usuario = lblcodusuario.getText();
                usuario = lblusuario.getText();
                FrmApertura_Caja.txtnombreapellido.setText(usuario);
                FrmApertura_Caja.txtID.setText(id_usuario);
                FrmApertura_Caja.txtDocumento.setText(documento);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_aperturaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frmusuariologin frm = new frmusuariologin();
        frm.setVisible(true);
        frm.toFront();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        backup();

    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        String x = Backup.x;
        try {
            if (x == null) {
                Backup form = new Backup();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        String x = frmrestaurar_copia.x;
        try {
            if (x == null) {
                frmrestaurar_copia form = new frmrestaurar_copia();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void menurespaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menurespaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menurespaldoActionPerformed

    private void cierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cierreActionPerformed
        String x = FrmCerrarCaja.x;
        try {
            if (x == null) {
                FrmCerrarCaja form = new FrmCerrarCaja();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cierreActionPerformed

    private void menucategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menucategoriaActionPerformed
        String x = FrmCategorias.x;
        try {
            if (x == null) {
                FrmCategorias form = new FrmCategorias();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
                form.btnnuevo.requestFocus();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_menucategoriaActionPerformed

    private void menucomprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menucomprasActionPerformed
        fmovimiento_caja func1 = new fmovimiento_caja();
        String[] registro = new String[8];
        registro = func1.obtenerdatos(frmprincipal.lblcodusuario.getText());
        idcaja1 = registro[0];
        if (registro[0].equals("")) {
            JOptionPane.showMessageDialog(null, "DEBE REALIZAR LA APERTURA DE CAJA PÁRA HACER LAS COMPRAS");        // TODO add your handling code here:

        } else {
            String x = frmcompras.x;
            try {
                if (x == null) {
                    frmcompras form = new frmcompras();
                    jDesktopPane2.add(form);
                    jDesktopPane2.moveToFront(form);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_menucomprasActionPerformed

    private void menuproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuproveedorActionPerformed
        String x = frmproveedor.x;
        try {
            if (x == null) {
                frmproveedor form = new frmproveedor();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_menuproveedorActionPerformed

    private void menuingresoyegreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuingresoyegreActionPerformed
        fmovimiento_caja func1 = new fmovimiento_caja();
        String[] registro = new String[8];
        registro = func1.obtenerdatos(frmprincipal.lblcodusuario.getText());
        idcaja1 = registro[0];
        if (registro[0].equals("")) {
            JOptionPane.showMessageDialog(null, "DEBE REALIZAR LA APERTURA DE CAJA PÁRA CARGAR UN EGRESO");        // TODO add your handling code here:

        } else {
            String x = frmEgresos.x;
            try {
                if (x == null) {
                    frmEgresos form = new frmEgresos();
                    jDesktopPane2.add(form);
                    jDesktopPane2.moveToFront(form);
                    frmEgresos.txtidmovimiento.setText(idcaja1);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_menuingresoyegreActionPerformed

    private void menupagodeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menupagodeudaActionPerformed
        fmovimiento_caja func1 = new fmovimiento_caja();
        String[] registro = new String[8];
        registro = func1.obtenerdatos(frmprincipal.lblcodusuario.getText());
        idcaja1 = registro[0];
        if (registro[0].equals("")) {
            JOptionPane.showMessageDialog(null, "DEBE REALIZAR LA APERTURA DE CAJA PARA VER LOS DEUDORES");        // TODO add your handling code here:

        } else {
            String x = frmDeudas.x;
            try {
                if (x == null) {
                    frmDeudas form = new frmDeudas();
                    jDesktopPane2.add(form);
                    jDesktopPane2.moveToFront(form);
//                    frmDeudas.txtidmovimiento.setText(idcaja1);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_menupagodeudaActionPerformed

    private void historialventas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialventas1ActionPerformed
        String x = frmhistorial_ventas.x;
        try {
            if (x == null) {
                frmhistorial_ventas form = new frmhistorial_ventas();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_historialventas1ActionPerformed

    private void historialventas_diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialventas_diaActionPerformed
        String x = frmventas_diarias.x;
        try {
            if (x == null) {
                frmventas_diarias form = new frmventas_diarias();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_historialventas_diaActionPerformed

    private void historialventas_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialventas_clienteActionPerformed
        String x = frmventa_general.x;
        try {
            if (x == null) {
                frmventa_general form = new frmventa_general();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_historialventas_clienteActionPerformed

    private void menuIngresos_Egresos_historialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIngresos_Egresos_historialActionPerformed
        String x = frm_ingreso_egreso.x;
        try {
            if (x == null) {
                frm_ingreso_egreso form = new frm_ingreso_egreso();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_menuIngresos_Egresos_historialActionPerformed

    private void resumenIEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumenIEActionPerformed
        String x = frm_ingreso_egreso_final.x;
        try {
            if (x == null) {
                frm_ingreso_egreso_final form = new frm_ingreso_egreso_final();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_resumenIEActionPerformed

    private void historial_comprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historial_comprasActionPerformed
        String x = frmhistorial_compras.x;
        try {
            if (x == null) {
                frmhistorial_compras form = new frmhistorial_compras();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_historial_comprasActionPerformed

    private void TXTCOMPRAS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTCOMPRAS1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTCOMPRAS1ActionPerformed

    private void txtingresos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtingresos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtingresos1ActionPerformed

    private void txtegresos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtegresos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtegresos1ActionPerformed

    private void txtpagado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpagado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpagado1ActionPerformed

    private void txtcredito1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcredito1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcredito1ActionPerformed

    private void txtcontado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontado1ActionPerformed

    private void TXTCOMPRASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTCOMPRASActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTCOMPRASActionPerformed

    private void txtingresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtingresosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtingresosActionPerformed

    private void txtaperturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaperturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaperturaActionPerformed

    private void txtegresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtegresosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtegresosActionPerformed

    private void txtcajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcajaActionPerformed

    private void txtpagadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpagadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpagadoActionPerformed

    private void txtcreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcreditoActionPerformed

    private void txthoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthoyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthoyActionPerformed

    private void txtcontadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontadoActionPerformed

    private void imprimirfactura1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirfactura1ActionPerformed
        String x = frmImprimir_cierre.x;
        try {
            if (x == null) {
                frmImprimir_cierre form = new frmImprimir_cierre();
                jDesktopPane2.add(form);
                jDesktopPane2.moveToFront(form);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta ventana ya esta abierta!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_imprimirfactura1ActionPerformed

    private void txtgananciatotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgananciatotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgananciatotalActionPerformed

    private void txtgananciahoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgananciahoyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgananciahoyActionPerformed

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
            java.util.logging.Logger.getLogger(frmprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmprincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenuItem MENUUSUARIO;
    public static javax.swing.JTextField TXTCOMPRAS;
    public static javax.swing.JTextField TXTCOMPRAS1;
    public static javax.swing.JMenuItem apertura;
    public static javax.swing.JMenuItem cierre;
    public static javax.swing.JMenuItem cutMenuItem5;
    public static javax.swing.JMenuItem historial_compras;
    public static javax.swing.JMenuItem historialventas1;
    public static javax.swing.JMenuItem historialventas_cliente;
    public static javax.swing.JMenuItem historialventas_dia;
    public static javax.swing.JMenuItem imprimirfactura;
    public static javax.swing.JMenuItem imprimirfactura1;
    public static javax.swing.JButton jButton1;
    public static javax.swing.JDesktopPane jDesktopPane2;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    public static javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel14;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    public static javax.swing.JMenuItem jMenuItem5;
    public static javax.swing.JMenuItem jMenuItem6;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    public static javax.swing.JLabel lbl;
    public static javax.swing.JLabel lblacceso;
    public static javax.swing.JLabel lblcodusuario;
    public static javax.swing.JLabel lblfechahoy;
    public static javax.swing.JLabel lblidmovimiento2;
    public static javax.swing.JLabel lblusuario;
    public static javax.swing.JMenuBar menuBar;
    public static javax.swing.JMenuItem menuIngresos_Egresos_historial;
    public static javax.swing.JMenuItem menucategoria;
    public static javax.swing.JMenuItem menucliente;
    public static javax.swing.JMenuItem menucompras;
    public static javax.swing.JMenuItem menuingresoyegre;
    public static javax.swing.JMenu menumovimiento;
    public static javax.swing.JMenuItem menupagodeuda;
    public static javax.swing.JMenuItem menuproductos;
    public static javax.swing.JMenuItem menuproveedor;
    public static javax.swing.JMenu menureporte;
    public static javax.swing.JMenu menurespaldo;
    public static javax.swing.JMenuItem menuventas;
    public static javax.swing.JMenu registros;
    public static javax.swing.JMenuItem resumenIE;
    public static javax.swing.JMenuItem rptclientes;
    public static javax.swing.JMenuItem rptusuarios;
    public static javax.swing.JTextField txtapertura;
    public static javax.swing.JTextField txtcaja;
    public static javax.swing.JTextField txtcontado;
    public static javax.swing.JTextField txtcontado1;
    public static javax.swing.JTextField txtcredito;
    public static javax.swing.JTextField txtcredito1;
    public static javax.swing.JTextField txtegresos;
    public static javax.swing.JTextField txtegresos1;
    public static javax.swing.JTextField txtgananciahoy;
    public static javax.swing.JTextField txtgananciatotal;
    public static javax.swing.JTextField txthoy;
    public static javax.swing.JTextField txtingresos;
    public static javax.swing.JTextField txtingresos1;
    public static javax.swing.JTextField txtpagado;
    public static javax.swing.JTextField txtpagado1;
    // End of variables declaration//GEN-END:variables
//codigo para agregar imgaen
    class Fondopanel extends JPanel {

        private Image imagen;//se declara una variable

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Iconos/fondo.jpg")).getImage();//selecciona el paquete y la imagen que se quiere usar
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);//obtiene el tamaño del panel para ajustar la imagen
            setOpaque(false);//sirve para que se vea la imagen
            super.paint(g);//para mostrar todos los componentes del panel que estan estableci
        }
    }
}
