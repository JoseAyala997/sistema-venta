package Presentacion;

import Datos.vcompras;
import Datos.vdetalle_compra;
import Datos.vdetalle_venta;
import Datos.vdeudas;
import Datos.vventas;
import Logica.LOcultarColumna;
import Logica.StyloTabla;
import Logica.fcompra;
import Logica.fdeudas;
import Logica.fproductos;
import Logica.fventa;
import static Presentacion.frmprincipal.jDesktopPane2;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class frmventas extends javax.swing.JInternalFrame implements KeyListener {

    public static DefaultTableModel modelo = new DefaultTableModel();
    public static String x;

    public frmventas() {

        initComponents();

        x = "x";
        DecimalFormat formatea = new DecimalFormat();

        deshabilitar();
        centrar_frm();

//        cliente();
        NroFctura();
        txtestado.setText("FINALIZADO");

        Calendar mifecha = new GregorianCalendar();
        dcfecha.setCalendar(mifecha);

        lblidproducto.setVisible(false);
        txtcodcliente.setVisible(false);
        txtpulgadas.setVisible(false);
        txtpulgadas.setText("0");
        txtredondeo.setText("0");

        txtcategoria.setVisible(false);

        StyloTabla st = new StyloTabla();
        st.stylotabla(tablaventas);

        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("PRECIO UNIT.");
        modelo.addColumn("PULGADAS");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("SUB TOTAL");
        modelo.addColumn("CATEGORIA");
        modelo.addColumn("DESC.");

        this.tablaventas.setModel(modelo);
//        txtcantidad.requestFocus();
//        jtable();
        LOcultarColumna.modjtable(tablaventas);
        btnb_Cliente.requestFocus(true);
        txtcliente.requestFocus();
//        frmventas.btnb_Cliente.addKeyListener(this); 
        LOcultarColumna.ocultar_esta_columna3(tablaventas, 0, 1, 3, 6);
        eventos();

    }

    void eventos() {
        btnb_Cliente.addKeyListener(this);
        cbotipo.addKeyListener(this);
        dcfecha.addKeyListener(this);
        btnagregar.addKeyListener(this);
        btnquitar.addKeyListener(this);
        btnbProducto.addKeyListener(this);
        btncliente.addKeyListener(this);
        jButton3.addKeyListener(this);
        jButton5.addKeyListener(this);
        btncalculadora.addKeyListener(this);
        jScrollPane1.addKeyListener(this);
        lblidproducto.addKeyListener(this);
        panel.addKeyListener(this);
        tablaventas.addKeyListener(this);
        txtcantidad.addKeyListener(this);
        txtcategoria.addKeyListener(this);
        txtcliente.addKeyListener(this);
        txtcodcliente.addKeyListener(this);
        txtestado.addKeyListener(this);
        txtnrofactura.addKeyListener(this);
        txtprecio.addKeyListener(this);
        txtproducto.addKeyListener(this);
        txtpulgadas.addKeyListener(this);
        txtredondeo.addKeyListener(this);
        txttotal.addKeyListener(this);
        txttotal_descuento.addKeyListener(this);

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
                frmvistapa_venta form = new frmvistapa_venta();
                form.setVisible(true);
                form.toFront();
                form.dondebuscar = 1;
                form.buscador();
                break;

            case 113:
                dayString = "f2";

                FrmVista_Servicios form2 = new FrmVista_Servicios();
                form2.setVisible(true);
                form2.toFront();
                form2.dondebuscar = 1;
                form2.buscador();

                break;

            case 114:
                dayString = "f3";
                agregar();
                break;

            case 115:
                dayString = "f4";
                presupuesto();
                break;

            case 116:
                dayString = "f5";
                venta();
                break;

            case 117:
                dayString = "f6";
                agregar_cliente();
                break;

            case 118:
                dayString = "f7";
                frmCalculadora form3 = new frmCalculadora();
                form3.setVisible(true);
                form3.toFront();
                break;
        }
//        JOptionPane.showConfirmDialog(null, dayString + " cod: " + codigo);
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

//    public static void cliente() {
//        //asignamos un cliente general
//        txtcodcliente.setText("3");
//        txtcliente.setText("CLIENTE GENERAL");
//        txtpulgadas.setText("0");
//    }
    //funcion para agregar productos al jtable
    void agregar() {
        String[] agregar = new String[8];
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
        if (txtpulgadas.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "la pulgada no puede estar vacia");
            txtpulgadas.setText("0");
            return;
        }
        if (txtredondeo.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "El descuento no puede estar vacio - Valor minimo 0");
            txtredondeo.setText("0");
            return;
        }
//        if (txtredondeo.getText().length() == 0) {
//            JOptionPane.showMessageDialog(rootPane, "El redondeo no puede estar vacio - Valor minimo 0");
//            txtredondeo.setText("0");
//            return;
//        }

        int redondeo;
        int cant;
        redondeo = Integer.parseInt(txtredondeo.getText().replaceAll("\\.", ""));
        cant = Integer.parseInt(txtcantidad.getText().replaceAll("\\.", ""));
        if (redondeo > 0 && cant >= 1) {

            agregar[0] = lblidproducto.getText();
            agregar[1] = txtproducto.getText();
            agregar[2] = String.valueOf(format.format(Integer.parseInt(txtprecio.getText().replaceAll("\\.", ""))));
            agregar[3] = txtpulgadas.getText();
            agregar[4] = txtcantidad.getText();
            agregar[6] = txtcategoria.getText();
            agregar[7] = String.valueOf(format.format(Integer.parseInt(txtredondeo.getText().replaceAll("\\.", ""))));
//            int subttotal = Integer.parseInt(txtcantidad.getText()) * Integer.parseInt(txtprecio.getText()) - Integer.parseInt(txtdescuento.getText());
            int subttotal = Integer.parseInt(txtsubtotal.getText().replaceAll("\\.", "")) - Integer.parseInt(txtredondeo.getText().replaceAll("\\.", ""));
            agregar[5] = String.valueOf(format.format(Integer.parseInt("" + subttotal)));
            modelo.addRow(agregar);
            sumarsubtotal();

            txtprecio.setText("0");
            txtcantidad.setText("0");
            lblidproducto.setText("");
            txtproducto.setText("");
            txtcategoria.setText("");
            txtpulgadas.setText("0");
            txtredondeo.setText("0");
            txtsubtotal.setText("0");

        } else {

            agregar[0] = lblidproducto.getText();
            agregar[1] = txtproducto.getText();
            agregar[2] = String.valueOf(format.format(Integer.parseInt(txtprecio.getText().replaceAll("\\.", ""))));
            agregar[3] = txtpulgadas.getText();
            agregar[4] = txtcantidad.getText();
            agregar[6] = txtcategoria.getText();
            agregar[7] = String.valueOf(format.format(Integer.parseInt(txtredondeo.getText().replaceAll("\\.", ""))));
//            int subttotal = Integer.parseInt(txtcantidad.getText()) * Integer.parseInt(txtprecio.getText().replaceAll("\\.", ""));
            int subttotal = Integer.parseInt(txtsubtotal.getText().replaceAll("\\.", "")) - Integer.parseInt(txtredondeo.getText().replaceAll("\\.", ""));
//            int subttotal = Integer.parseInt(txtcantidad.getText()) * Integer.parseInt(txtdescuento.getText());
            agregar[5] = String.valueOf(format.format(Integer.parseInt("" + subttotal)));
            modelo.addRow(agregar);
            sumarsubtotal();

            txtprecio.setText("0");
            txtcantidad.setText("0");
            lblidproducto.setText("");
            txtproducto.setText("");
            txtcategoria.setText("");
            txtpulgadas.setText("0");
            txtredondeo.setText("0");
            txtsubtotal.setText("0");

        }
        deshabilitar();

    }

    void habilitar() {
        txtredondeo.setEnabled(true);
    }

    void deshabilitar() {
        txtredondeo.setEnabled(false);
    }

    void centrar_frm() {
        int a = frmprincipal.jDesktopPane2.getWidth() - this.getWidth();
        int b = frmprincipal.jDesktopPane2.getHeight() - this.getHeight();
        setLocation(a / 2, b / 2);
        setVisible(true);
    }

    void estado() {

        if (cbotipo.getSelectedItem().equals("CONTADO")) {
            txtestado.setText("FINALIZADO");

        } else {
            txtestado.setText("PENDIENTE");
        }
    }

    public static DecimalFormat formateador = new DecimalFormat("0000000");//damos formato al numero de factura

    public static void NroFctura() {

        fventa funcion = new fventa();

        int NroFactura = funcion.NroFactura();//llamamos la funcion nrofactura
        txtnrofactura.setText(formateador.format(NroFactura));//asignamos el numero de factura al txt

    }

    public static void NroPresupuesto() {

        fcompra funcion = new fcompra();

        int NroFactura = funcion.NroFactura();//llamamos la funcion nrofactura
        txtnrofactura.setText(formateador.format(NroFactura));//asignamos el numero de factura al txt

    }

    public static void insertarVenta() {
        String tipo = cbotipo.getSelectedItem().toString();
//        System.out.println(tipo);
        if (tipo.equals("CONTADO")) {

            vventas datos = new vventas();
            fventa funcion = new fventa();

            datos.setEstado(txtestado.getText());
            datos.setIdusuarios(Integer.parseInt(frmprincipal.lblcodusuario.getText()));
            datos.setIdpaciente(Integer.parseInt(txtcodcliente.getText()));
            datos.setSaldo(Long.parseLong("0"));
            datos.setTotal(Long.parseLong(txttotal.getText().replaceAll("\\.", "")));
            datos.setDescuento(Long.parseLong(txttotal_descuento.getText().replaceAll("\\.", "")));
            datos.setIdmovimiento(Integer.parseInt(frmprincipal.idcaja1));

            Calendar cal = dcfecha.getCalendar();
            int a, m, d;
            a = cal.get(cal.YEAR) - 1900;
            m = cal.get(cal.MONTH);
            d = cal.get(cal.DAY_OF_MONTH);

            datos.setFecha(new Date(a, m, d));
            datos.setNro_factura(txtnrofactura.getText());
            datos.setTipo(cbotipo.getSelectedItem().toString());

            if (funcion.insertarVentas(datos)) {

            }
//            funcion.insertarVentas(datos);

            imsertarDetalle();
            //FUNCION PARA ACTUALIZAR LAS VENTAS EN FRMPRINCIPAL
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            frmprincipal.mostrarhoy(dtf.format(LocalDateTime.now()));

        } else {
            vventas datos = new vventas();
            fventa funcion = new fventa();

            datos.setEstado(txtestado.getText());
            datos.setIdusuarios(Integer.parseInt(frmprincipal.lblcodusuario.getText()));
            datos.setIdpaciente(Integer.parseInt(txtcodcliente.getText()));
            datos.setSaldo(Long.parseLong(txttotal.getText().replaceAll("\\.", "")));
            datos.setTotal(Long.parseLong(txttotal.getText().replaceAll("\\.", "")));
            datos.setDescuento(Long.parseLong(txttotal_descuento.getText().replaceAll("\\.", "")));
            datos.setIdmovimiento(Integer.parseInt(frmprincipal.idcaja1));

            Calendar cal = dcfecha.getCalendar();
            int a, m, d;
            a = cal.get(cal.YEAR) - 1900;
            m = cal.get(cal.MONTH);
            d = cal.get(cal.DAY_OF_MONTH);

            datos.setFecha(new Date(a, m, d));
            datos.setNro_factura(txtnrofactura.getText());
            datos.setTipo(cbotipo.getSelectedItem().toString());

            if (funcion.insertarVentas(datos)) {

            }
            imsertarDetalle();

            //FUNCION PARA ACTUALIZAR LAS VENTAS EN FRMPRINCIPAL
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            frmprincipal.mostrarhoy(dtf.format(LocalDateTime.now()));
        }

    }

    public static void insertarpresupuesto() {

        vcompras datos = new vcompras();
        fcompra funcion = new fcompra();

        datos.setEstado("PRESUPUESTO");
        datos.setIdusuarios(Integer.parseInt(frmprincipal.lblcodusuario.getText()));
//        datos.setIdpaciente(Integer.parseInt(txtcodcliente.getText()));
//        datos.setSaldo(Long.parseLong("0"));
        datos.setTotal(Long.parseLong(txttotal.getText().replaceAll("\\.", "")));
//      datos.setDescuento(Long.parseLong(txttotal_descuento.getText().replaceAll("\\.", "")));
        datos.setIdmovimiento(Integer.parseInt(frmprincipal.idcaja1));

        Calendar cal = dcfecha.getCalendar();
        int a, m, d;
        a = cal.get(cal.YEAR) - 1900;
        m = cal.get(cal.MONTH);
        d = cal.get(cal.DAY_OF_MONTH);

        datos.setFecha(new Date(a, m, d));
        datos.setNro_factura(txtnrofactura.getText());
//        datos.setNro_factura("0");
        datos.setTipo("PRESUPUESTO");

        if (funcion.insertarVentas(datos)) {

        }
//            funcion.insertarVentas(datos);

        Detalle_presupuesto();
//        NroFctura();

    }

    public static void imsertarDetalle() {
        vdetalle_venta datos = new vdetalle_venta();
        fventa funcion = new fventa();
        fproductos cd = new fproductos();

        for (int i = 0; i < tablaventas.getRowCount(); i++) {
            String cat = (tablaventas.getValueAt(i, 6).toString());
            if (cat.equals("SERVICIOS")) {
                datos.setIdservicios(Integer.parseInt(tablaventas.getValueAt(i, 0).toString()));
                datos.setCantidad(Integer.parseInt(tablaventas.getValueAt(i, 4).toString()));
                datos.setPulgadas(Integer.parseInt(tablaventas.getValueAt(i, 3).toString()));
                datos.setPrecio(Long.parseLong(tablaventas.getValueAt(i, 2).toString().replaceAll("\\.", "")));
                datos.setSub_total(Long.parseLong(tablaventas.getValueAt(i, 5).toString().replaceAll("\\.", "")));
//                System.out.println("servicio");
                funcion.insertarDetalle(datos);
            } else {
                datos.setIdservicios(Integer.parseInt(tablaventas.getValueAt(i, 0).toString()));
                datos.setCantidad(Integer.parseInt(tablaventas.getValueAt(i, 4).toString()));
                datos.setPulgadas(Integer.parseInt(tablaventas.getValueAt(i, 3).toString()));
                datos.setPrecio(Long.parseLong(tablaventas.getValueAt(i, 2).toString().replaceAll("\\.", "")));
                datos.setSub_total(Long.parseLong(tablaventas.getValueAt(i, 5).toString().replaceAll("\\.", "")));
                cd.restarpulgadas(Double.parseDouble(tablaventas.getValueAt(i, 3).toString()), Integer.parseInt(tablaventas.getValueAt(i, 0).toString()));
                cd.restarStock(Double.parseDouble(tablaventas.getValueAt(i, 4).toString()), Integer.parseInt(tablaventas.getValueAt(i, 0).toString()));

                funcion.insertarDetalle(datos);
//                System.out.println("no es un servicio");
            }

        }

    }
    static String iddeuda;
    static String total;

    public static void insertar_deuda() {

        vdeudas dts = new vdeudas();
        fdeudas func = new fdeudas();
        String[] registro = new String[3];

//        String idcliente = txtcodcliente.getText();
//        func.id_cliente(idcliente);
//        int sal= Integer.parseInt(fegresos.saldo);
        registro = func.id_cliente(txtcodcliente.getText());
        iddeuda = registro[0];
        total = registro[2];
        int entrega = Integer.parseInt(FrmFactura_Entrega.txtentrega.getText().replaceAll("\\.", ""));
//if (iddeuda == null) {
        if (iddeuda.equals("")) {

            if (entrega > 0) {
//                  JOptionPane.showMessageDialog(null, "esta vacio "+total);
//            iddeuda total_deuda saldo estado fecha_deuda fecha_pago idcliente
                dts.setIdcliente(Integer.parseInt(txtcodcliente.getText()));
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
                insertarpago2();

            } else {
//                  JOptionPane.showMessageDialog(null, "esta vacio "+total);
//            iddeuda total_deuda saldo estado fecha_deuda fecha_pago idcliente
                dts.setIdcliente(Integer.parseInt(txtcodcliente.getText()));
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
                dts.setIdcliente(Integer.parseInt(txtcodcliente.getText()));
                dts.setTotal_deuda(Long.parseLong(FrmFactura_Entrega.txtsaldo.getText().replaceAll("\\.", "")) + Long.parseLong(total));
                dts.setEstado("PENDIENTE");

                Calendar cal = dcfecha.getCalendar();
                int a, m, d;
                a = cal.get(cal.YEAR) - 1900;
                m = cal.get(cal.MONTH);
                d = cal.get(cal.DAY_OF_MONTH);

                dts.setFecha_deuda(new Date(a, m, d));
                func.editarDeuda(dts);
                insertarpago2();
            } else {
                dts.setIddeuda(Integer.parseInt(iddeuda));
                dts.setIdcliente(Integer.parseInt(txtcodcliente.getText()));
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
    public static void insertarpago2() {
        vventas datos = new vventas();
        fventa funcion = new fventa();

        datos.setEstado("PAGADO");
        datos.setIdusuarios(Integer.parseInt(frmprincipal.lblcodusuario.getText()));
        datos.setIdpaciente(Integer.parseInt(txtcodcliente.getText()));
        datos.setSaldo(Long.parseLong("0"));
        datos.setTotal(Long.parseLong(FrmFactura_Entrega.txtentrega.getText().replaceAll("\\.", "")));
        datos.setDescuento(Long.parseLong("0"));
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
        registro = func.id_cliente(txtcodcliente.getText());
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

        insertarpago2();
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

    //Funcion para agregar presupuesto
    void presupuesto() {
        NroPresupuesto();
        int fila = tablaventas.getRowCount();//creamos una variable para determinar si no hay filas en el jtable

        if (txtcodcliente.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR EL CLIENTE");//validamos que el codcliente no este vacio
        } else {
            if (fila == 0) {//validamos si el jtable viene vacio 
                JOptionPane.showMessageDialog(rootPane, "La tabla no puede estar vacia");

            } else {
                //mandamos los datos al frm factura
                FrmFactura frm = new FrmFactura();
                frm.txtFactura.setText(txtnrofactura.getText());
                frm.txtMonto.setText(txttotal.getText());
                frm.txtdescuento.setText(txttotal_descuento.getText());
                frm.txtpresupuesto.setText("PRESUPUESTO");
                frm.setVisible(true);
//                insertarpresupuesto();

            }
        }
    }

    public static void Detalle_presupuesto() {
        vdetalle_compra datos = new vdetalle_compra();
        fcompra funcion = new fcompra();

        for (int i = 0; i < tablaventas.getRowCount(); i++) {

//            pst.setInt(1, dts.getIdservicios());
//            pst.setInt(2, dts.getCantidad());
//            pst.setLong(3, dts.getPrecio());
//            pst.setLong(4, dts.getSub_total());
//            pst.setInt(5, dts.getPulgadas());
//            pst.setInt(6, dts.getIdproveedor());
            datos.setIdservicios(Integer.parseInt(tablaventas.getValueAt(i, 0).toString()));
            datos.setCantidad(Integer.parseInt(tablaventas.getValueAt(i, 4).toString()));
            datos.setPulgadas(Integer.parseInt(tablaventas.getValueAt(i, 3).toString()));
            datos.setPrecio(Long.parseLong(tablaventas.getValueAt(i, 2).toString().replaceAll("\\.", "")));
            datos.setSub_total(Long.parseLong(tablaventas.getValueAt(i, 5).toString().replaceAll("\\.", "")));

            funcion.insertarDetalle(datos);

        }

    }

    public static void venta() {
        int fila = tablaventas.getRowCount();//creamos una variable para determinar si no hay filas en el jtable

        if (txtcodcliente.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "DEBES INGRESAR EL CLIENTE");//validamos que el codcliente no este vacio
        } else {
            if (fila == 0) {//validamos si el jtable viene vacio 
                JOptionPane.showMessageDialog(null, "La tabla no puede estar vacia");

            } else {
                if (cbotipo.getSelectedItem().equals("CREDITO")) {
                    //mandamos los datos al frm factura
                    FrmFactura_Entrega frm = new FrmFactura_Entrega();
                    FrmFactura_Entrega.txttipo.setText("venta");
                    FrmFactura_Entrega.txtFactura.setText(txtnrofactura.getText());
                    FrmFactura_Entrega.txtMonto.setText(txttotal.getText());
                    FrmFactura_Entrega.txtdescuento.setText(txttotal_descuento.getText());
                    FrmFactura_Entrega.txtsaldo.setText(txttotal.getText());
                    frm.setVisible(true);
//                insertarVenta();
                } else {
                    //mandamos los datos al frm factura
                    FrmFactura frm = new FrmFactura();
                    FrmFactura.txttipo.setText("venta");
                    frm.txtFactura.setText(txtnrofactura.getText());
                    frm.txtMonto.setText(txttotal.getText());
                    frm.txtdescuento.setText(txttotal_descuento.getText());
                    frm.setVisible(true);
//                insertarVenta();
                }

            }
        }
    }

    void agregar_cliente() {
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        txtcategoria = new javax.swing.JTextField();
        btnbProducto = new javax.swing.JButton();
        txtredondeo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtpulgadas = new javax.swing.JTextField();
        txtproducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaventas = new javax.swing.JTable();
        txttotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txttotal_descuento = new javax.swing.JTextField();
        btncalculadora = new javax.swing.JButton();
        txtsubtotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtiva = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbotipo = new javax.swing.JComboBox<>();
        dcfecha = new com.toedter.calendar.JDateChooser();
        btnb_Cliente = new javax.swing.JButton();
        txtestado = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        txtcodcliente = new javax.swing.JTextField();
        txtnrofactura = new javax.swing.JTextField();
        btncliente = new javax.swing.JButton();
        lblidproducto = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnagregar = new javax.swing.JButton();
        btnquitar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
                formInternalFrameOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setForeground(new java.awt.Color(0, 153, 153));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtcategoria.setEnabled(false);
        txtcategoria.setPreferredSize(null);
        panel.add(txtcategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 30, 20));

        btnbProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar32.png"))); // NOI18N
        btnbProducto.setText("F2");
        btnbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbProductoActionPerformed(evt);
            }
        });
        panel.add(btnbProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 35, 80, 35));

        txtredondeo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtredondeoKeyReleased(evt);
            }
        });
        panel.add(txtredondeo, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 140, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("DESCUENTO");
        panel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 124, 20));

        txtprecio.setEnabled(false);
        txtprecio.setPreferredSize(null);
        panel.add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 140, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("SUB-TOTAL");
        panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 100, 20));

        txtcantidad.setPreferredSize(null);
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcantidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });
        panel.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 90, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CANTIDAD");
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 80, 20));

        txtpulgadas.setPreferredSize(null);
        txtpulgadas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpulgadasKeyTyped(evt);
            }
        });
        panel.add(txtpulgadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 30, 20));

        txtproducto.setEnabled(false);
        txtproducto.setPreferredSize(null);
        panel.add(txtproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 250, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("PRODUCTO");
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 20));

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaventas.getTableHeader().setResizingAllowed(false);
        tablaventas.getTableHeader().setReorderingAllowed(false);
        tablaventas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaventasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaventas);

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 990, 300));

        txttotal.setEnabled(false);
        panel.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 140, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("TOTAL:");
        panel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 46, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("TOTAL DESCUENTO:");
        panel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 120, 30));

        txttotal_descuento.setEnabled(false);
        panel.add(txttotal_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, 141, 30));

        btncalculadora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/calculadora.png"))); // NOI18N
        btncalculadora.setText("F7");
        btncalculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalculadoraActionPerformed(evt);
            }
        });
        panel.add(btncalculadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 35, 80, 35));

        txtsubtotal.setEnabled(false);
        txtsubtotal.setPreferredSize(null);
        txtsubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubtotalActionPerformed(evt);
            }
        });
        panel.add(txtsubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 140, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("PRECIO");
        panel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 60, 20));

        txtiva.setEnabled(false);
        panel.add(txtiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, 140, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("IVA 10%:");
        panel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 70, 30));

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1020, 470));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel5.setText("VENTAS");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 11, 159, 42));

        cbotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONTADO", "CREDITO" }));
        cbotipo.setPreferredSize(null);
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
        jPanel1.add(cbotipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 150, 30));

        dcfecha.setEnabled(false);
        dcfecha.setPreferredSize(null);
        jPanel1.add(dcfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 150, 30));

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
        jPanel1.add(btnb_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 95, 80, 35));

        txtestado.setEnabled(false);
        txtestado.setPreferredSize(null);
        jPanel1.add(txtestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 100, 163, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("ESTADO");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 80, 116, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("CLIENTE");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 76, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("FECHA");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("NRO. FACTURA");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("TIPO");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, 58, -1));

        txtcliente.setEnabled(false);
        txtcliente.setPreferredSize(null);
        jPanel1.add(txtcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 98, 230, 30));

        txtcodcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodclienteActionPerformed(evt);
            }
        });
        jPanel1.add(txtcodcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 71, 66, -1));

        txtnrofactura.setEnabled(false);
        txtnrofactura.setPreferredSize(null);
        jPanel1.add(txtnrofactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 150, 30));

        btncliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregar-usuario.png"))); // NOI18N
        btncliente.setText("F6");
        btncliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclienteActionPerformed(evt);
            }
        });
        jPanel1.add(btncliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 95, 80, 35));

        lblidproducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(lblidproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 88, 31));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 150));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        btnagregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnagregar.setText("AÑADIR F3");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btnquitar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnquitar.setText("QUITAR ");
        btnquitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("FINALIZAR VENTA F5");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("PRESUPUESTO F4");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("CANCELAR VENTA F8");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnagregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnquitar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnquitar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 150, 200, 470));

        setBounds(0, 0, 1234, 648);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtcodclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodclienteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        venta();


    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnquitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarActionPerformed
        int fila = tablaventas.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes Seleccionar el Producto");

        } else {
            int confirmacion = JOptionPane.showConfirmDialog(null, "?Deseas Eliminar el Producto de la lista?");
            if (JOptionPane.OK_OPTION == confirmacion) {
                modelo.removeRow(fila);
                sumarsubtotal();

            }
        }
    }//GEN-LAST:event_btnquitarActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
        agregar();

    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnvistaclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvistaproducto1ActionPerformed


    }//GEN-LAST:event_btnvistaproducto1ActionPerformed

    private void btnb_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnb_ClienteActionPerformed
        frmvistapa_venta form = new frmvistapa_venta();
        form.setVisible(true);
        form.toFront();
        form.dondebuscar = 1;
        form.buscador();
    }//GEN-LAST:event_btnb_ClienteActionPerformed

    private void btnbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbProductoActionPerformed
        FrmVista_Servicios form = new FrmVista_Servicios();
        form.setVisible(true);
        form.toFront();
        form.dondebuscar = 1;
        form.buscador();
    }//GEN-LAST:event_btnbProductoActionPerformed

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
//        permitir solo hasta 4 numeros
        char key = evt.getKeyChar();
        if (txtcantidad.getText().length() > 3) {
            evt.consume();
        }
        if (!Character.isDigit(key)) {

            evt.consume();
        }
//        int precio=0;
//        int cantidad=0;
//        int sub=0;
//        precio=Integer.parseInt(txtprecio.getText());
//        cantidad=Integer.parseInt(txtcantidad.getText());
//        sub = precio*cantidad;
//        txtredondeo.setText(String.valueOf(sub));
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void cbotipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbotipoActionPerformed

    private void txtpulgadasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpulgadasKeyTyped
        char key = evt.getKeyChar();
        if (txtpulgadas.getText().length() > 4) {
            evt.consume();
        }
        if (!Character.isDigit(key)) {

            evt.consume();
        }
    }//GEN-LAST:event_txtpulgadasKeyTyped

    private void cbotipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbotipoItemStateChanged
        estado();
    }//GEN-LAST:event_cbotipoItemStateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        presupuesto();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtcantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyPressed


    }//GEN-LAST:event_txtcantidadKeyPressed

    private void txtcantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyReleased
//funcion al presionar enter
//        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
        int precio = 0;
        int cantidad = 1;
        int sub = 0;
        precio = Integer.parseInt(txtprecio.getText().replaceAll("\\.", ""));
        cantidad = Integer.parseInt(txtcantidad.getText().replaceAll("\\.", ""));
        sub = precio * cantidad;
        txtsubtotal.setText(String.valueOf(format.format(sub)));
//            txtredondeo.requestFocus();
        habilitar();
//        }


    }//GEN-LAST:event_txtcantidadKeyReleased

    private void txtredondeoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtredondeoKeyReleased
        if (txtredondeo.getText().length() >= 0) {
            txtredondeo.setText(txtredondeo.getText().replace(".", ""));
            int c = Integer.parseInt(txtredondeo.getText());
            txtredondeo.setText(format.format(c) + "");
        }
    }//GEN-LAST:event_txtredondeoKeyReleased

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void tablaventasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaventasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int fila = tablaventas.getSelectedRow();
            if (fila < 0) {
                JOptionPane.showMessageDialog(rootPane, "Debes Seleccionar el Producto");

            } else {
                int confirmacion = JOptionPane.showConfirmDialog(null, "?Deseas Eliminar el Producto de la lista?");
                if (JOptionPane.OK_OPTION == confirmacion) {
                    modelo.removeRow(fila);
                    sumarsubtotal();

                }
            }
        }
    }//GEN-LAST:event_tablaventasKeyPressed

    private void btnclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclienteActionPerformed
        agregar_cliente();
    }//GEN-LAST:event_btnclienteActionPerformed

    private void btncalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalculadoraActionPerformed
        frmCalculadora form = new frmCalculadora();
        form.setVisible(true);
        form.toFront();
    }//GEN-LAST:event_btncalculadoraActionPerformed

    private void txtsubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubtotalActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//        Llamamos a la vista servicios y le pasamos la variable donde buscark
        FrmAnularventa form = new FrmAnularventa();
        form.setVisible(true);
        form.toFront();
        form.dondebuscar = 4;
        form.buscador();
    }//GEN-LAST:event_jButton4ActionPerformed

    public static DecimalFormat format = new DecimalFormat("###,###.###");
    public static float sumatoria;
    public static float sumador;
    public static float pulgadas;
    public static float des1;
    public static float des2;
    public static float iva;

    public static void sumarsubtotal() {
        int totalrow = tablaventas.getRowCount();
        totalrow -= 1;
        sumatoria = 0;
        pulgadas = 0;
        des1 = 0;
        des2 = 0;
        for (int i = 0; i <= (totalrow); i++) {
            sumador = Float.valueOf(tablaventas.getValueAt(i, 5).toString().replaceAll("\\.", ""));
            sumatoria += sumador;
            des1 = Float.valueOf(tablaventas.getValueAt(i, 7).toString().replaceAll("\\.", ""));
            des2 += des1;

        }
        txttotal.setText(String.valueOf(format.format(sumatoria)));
        iva = sumatoria / 11;
        txtiva.setText(String.valueOf(format.format(iva)));

        txttotal_descuento.setText(String.valueOf(format.format(des2)));
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
            java.util.logging.Logger.getLogger(frmventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnagregar;
    public static javax.swing.JButton btnbProducto;
    public static javax.swing.JButton btnb_Cliente;
    public static javax.swing.JButton btncalculadora;
    public static javax.swing.JButton btncliente;
    public static javax.swing.JButton btnquitar;
    public static javax.swing.JComboBox<String> cbotipo;
    public static com.toedter.calendar.JDateChooser dcfecha;
    public static javax.swing.JButton jButton3;
    public static javax.swing.JButton jButton4;
    public static javax.swing.JButton jButton5;
    public static javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    public static javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel14;
    public static javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblidproducto;
    public static javax.swing.JPanel panel;
    public static javax.swing.JTable tablaventas;
    public static javax.swing.JTextField txtcantidad;
    public static javax.swing.JTextField txtcategoria;
    public static javax.swing.JTextField txtcliente;
    public static javax.swing.JTextField txtcodcliente;
    public static javax.swing.JTextField txtestado;
    public static javax.swing.JTextField txtiva;
    public static javax.swing.JTextField txtnrofactura;
    public static javax.swing.JTextField txtprecio;
    public static javax.swing.JTextField txtproducto;
    public static javax.swing.JTextField txtpulgadas;
    public static javax.swing.JTextField txtredondeo;
    public static javax.swing.JTextField txtsubtotal;
    public static javax.swing.JTextField txttotal;
    public static javax.swing.JTextField txttotal_descuento;
    // End of variables declaration//GEN-END:variables
}
