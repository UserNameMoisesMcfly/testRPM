package Formularios;

import Clases.Cls_Salida;
import static Formularios.Frm_Principals.contenedor;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicTableUI;



public class Frm_Salida1_1_1_1 extends javax.swing.JInternalFrame {
    private final Cls_Salida CP;
   // TableColumnModel columnModel;
    public static String codigo="",codigo1="",codigo2="",codigo3="",codigo4="", cantidadd="",
            cantidadd1="",cantidadd2="",cantidadd3="",cantidadd4="";
    public static Date fechaa;
    public static int  enviar = 0,click;

    int num = 0;
    
    public Frm_Salida1_1_1_1() {
        initComponents();
        CP = new Cls_Salida();
       
        iniciar();
        activar();
      
  
   
    }
    public void removeButton(Container container){
        Component[] components = container.getComponents();
        for(Component component : components){
            if(component instanceof AbstractButton){
               container.remove(component);
               // container.setBackground(Color.white);
                
                
            }
        }
    }
    
    private void listar(){
        jtb_salida.setTableHeader(null);
        
        jtb_salida.setModel(CP.getDatosSalida());
        //columnModel.getColumn(3).setPreferredWidth(350);
    }
    
    private void iniciar(){

        txt_des.setUI(new BasicComboBoxUI());
        txt_clien.setUI(new BasicComboBoxUI());
       // ((JLabel)txt_clien.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
      
        txt_au.setUI(new BasicComboBoxUI());
        txt_pla.setUI(new BasicComboBoxUI());
        txt_op.setUI(new BasicComboBoxUI());
        txt_linea.setUI(new BasicComboBoxUI());
        txt_linea.setBackground(Color.white);
        txt_linea.setOpaque(true);  
        txt_linea1.setUI(new BasicComboBoxUI());
        txt_linea1.setBackground(Color.white);
        txt_linea1.setOpaque(true);
        txt_des.setBackground(Color.white);
        txt_des.setOpaque(true);
        txt_clien.setBackground(Color.white);
        txt_clien.setOpaque(true);
        txt_au.setBackground(Color.white);
        txt_au.setOpaque(true);
        txt_pla.setBackground(Color.white);
        txt_pla.setOpaque(true);
        txt_op.setBackground(Color.white);
        txt_op.setOpaque(true);
        jdc_fecha.setBackground(Color.white);
        jdc_fecha.setOpaque(true);
        jtb_salida.setUI(new BasicTableUI());
       
        listar();
       // iniciar();
        //activar();
        txt_cantidad.setEnabled(false);
        jPanel10.setVisible(false);
        click=0;
       fecha();
       
    }
    private void fecha(){
        Calendar fecha = new GregorianCalendar();
       int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int min = fecha.get(Calendar.MINUTE);
        int seg = fecha.get(Calendar.SECOND);
       SimpleDateFormat ffe=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
       String fe=(""+año+"/"+(mes+1)+"/"+dia+"  "+(hora-1)+":"+min+":"+seg);
      // jdc_fecha.setText(fe);
       Date fech=null;
       try{
           fech=ffe.parse(fe);
       jdc_fecha.setDate(fech);
       }catch(ParseException ex){
           ex.printStackTrace();
       }
    }    
    private void activar(){
        
       jdc_fecha.setEnabled(true);
        jTextField1.setEnabled(true);
        jTextField6.setEnabled(true);
        jTextField16.setEnabled(true);
        jTextField3.setEnabled(true);
        jTextField4.setEnabled(true);
        txt_des.setEnabled(true);
        txt_clien.setEnabled(true);
        txt_au.setEnabled(true);
        txt_pla.setEnabled(true);
        txt_op.setEnabled(true);
        txt_pedido.setEnabled(true);
        txt_pedido1.setEnabled(true);
        txt_linea.setEnabled(true);   
        txt_linea1.setEnabled(true);  
        txt_codigo.setEnabled(true);
        txt_codigo1.setEnabled(true);
        txt_descripcion.setEnabled(true);
        txt_descripcion1.setEnabled(true);
        txt_tarimas.setEnabled(true);
        txt_tarimas1.setEnabled(true);
        txt_cantidad.setEnabled(true);
        txt_cantidad1.setEnabled(true);
       txt_codigo1.setText(" ");
       txt_cantidad.setText("0");
       txt_cantidad1.setText("0");
    }
  private void des(){
        
       jdc_fecha.setEnabled(false);
        jTextField1.setEnabled(false);
        jTextField6.setEnabled(false);
        jTextField16.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        txt_des.setEnabled(false);
        txt_clien.setEnabled(false);
        txt_au.setEnabled(false);
        txt_pla.setEnabled(false);
        txt_op.setEnabled(false);
        txt_pedido.setEnabled(false);
        txt_pedido1.setEnabled(false);
        txt_linea.setEnabled(false); 
        txt_linea1.setEnabled(false); 
        txt_codigo.setEnabled(false);
        txt_codigo1.setEnabled(false);
        txt_tarimas.setEnabled(false);
        txt_tarimas1.setEnabled(false);
        txt_descripcion.setEnabled(false);
        txt_descripcion1.setEnabled(false);
      
        txt_cantidad.setEnabled(false);
        txt_cantidad1.setEnabled(false);
    
    }
    
    private void limpiar(){
        txt_des.setSelectedItem(" ");
        txt_clien.setSelectedItem(" ");
        txt_au.setSelectedItem(" ");
        txt_pla.setSelectedItem(" ");
        txt_op.setSelectedItem(" ");
        txt_pedido.setText("");
        txt_pedido1.setText("");
        txt_linea.setSelectedItem(" ");
        txt_linea1.setSelectedItem(" ");
        txt_codigo.setText("");
        txt_codigo1.setText("");
        txt_descripcion.setText("");
        txt_descripcion1.setText("");
        txt_cantidad.setText("");
        txt_cantidad1.setText("");
        txt_tarimas.setText("");
        txt_tarimas1.setText("");
         
        
    }
  
           
    private void guardar(){
        codigo = txt_codigo.getText();
        codigo1 = txt_codigo1.getText();
        int cantidad = Integer.parseInt(txt_cantidad.getText());
       cantidadd=Integer.toString (cantidad);
        int cantidad1 = Integer.parseInt(txt_cantidad1.getText());
       cantidadd1=Integer.toString (cantidad1);
         
         fechaa = jdc_fecha.getDate();
        long d = fechaa.getTime();
        java.sql.Date fecha_sql = new java.sql.Date(d);
        
       if(num == 0){
            
             CP.registrarSalida(fecha_sql,codigo,codigo1,cantidad,cantidad1);
                
            }
        
        
    }
    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_des = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txt_clien = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_au = new javax.swing.JComboBox<>();
        txt_pla = new javax.swing.JComboBox<>();
        txt_op = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        txt_pedido1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_codigo1 = new javax.swing.JButton();
        txt_descripcion1 = new javax.swing.JTextField();
        txt_cantidad1 = new javax.swing.JTextField();
        txt_tarimas1 = new javax.swing.JTextField();
        txt_linea1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtb_salida = new javax.swing.JTable();
        jTextField10 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        txt_pedido = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JButton();
        txt_descripcion = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        txt_tarimas = new javax.swing.JTextField();
        txt_linea = new javax.swing.JComboBox<>();
        jTextField6 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jdc_fecha = new com.toedter.calendar.JDateChooser();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 102));
        setClosable(true);
        setTitle("Salida");
        setPreferredSize(new java.awt.Dimension(800, 830));
        setVerifyInputWhenFocusTarget(false);

        jButton1.setText("IMPRIMIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(612, 792));
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel5.setText("FECHA:");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel1.setText("ORIGEN:");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel2.setText("No. DE PROVEEDOR:");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel7.setText("ALMACEN:");

        jTextField1.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jTextField1.setText("MAQUILA RPM");
        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField1.setPreferredSize(new java.awt.Dimension(69, 15));

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel9.setText("DESTINO:");

        txt_des.setEditable(true);
        txt_des.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        txt_des.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "CERVECERIA CUAUHTEMOC MOCTEZUMA", "INTERNATIONAL PAPER", "CROWN ORIZABA", " " }));
        txt_des.setToolTipText("");
        txt_des.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_des.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_des.setPreferredSize(new java.awt.Dimension(197, 15));

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel10.setText("CLIENTE:");

        txt_clien.setEditable(true);
        txt_clien.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        txt_clien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "SUMINISTRO DE EMPAQUE", "CEDIS", "ALMACEN DE MATERIALES", "ACE", "CAD", "PIVO", "MONTOSA", "VERACRUZ", "CERDAN", "TEHUACAN", "VILAHERMOSA", "TEHUANTEPEC" }));
        txt_clien.setToolTipText("");
        txt_clien.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_clien.setPreferredSize(new java.awt.Dimension(137, 17));

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel12.setText("OBSERVACIONES:");

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel13.setText("AUTORIZA:");

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel14.setText("TRANSPORTE:");

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel15.setText("PLACAS:");

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel16.setText("OPERADOR:");

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel17.setText("SOLICITA CLIENTE:");

        txt_au.setEditable(true);
        txt_au.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        txt_au.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "JORGE CARRERA", "PAOLA LOPEZ", "FELIX MENCIAS", "ANTONIO BASILIO", "PEDRO VALENCIA", "JULIO CESAR", "JORGE VASQUEZ" }));
        txt_au.setToolTipText("");
        txt_au.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_au.setPreferredSize(new java.awt.Dimension(103, 15));

        txt_pla.setEditable(true);
        txt_pla.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        txt_pla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RAM XV0307 A", "RAM 2XX862 A", "RAM XX5712 A", "RAM XT 2464 A", "DODGE XT 2463 A", "CHEVROLETH XT 2465 A", "DOSGE XT 2462 A", "89UH 1-S", "YL 1227 A", "YL 1336 A", "88UH 1-S", "XX5712A" }));
        txt_pla.setToolTipText("");
        txt_pla.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_pla.setPreferredSize(new java.awt.Dimension(121, 15));
        txt_pla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_plaActionPerformed(evt);
            }
        });

        txt_op.setEditable(true);
        txt_op.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        txt_op.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RAFAEL SANCHEZ", "RAUL ROJAS", "AMADO FLORES", "JOSE HUERTA", "CORNELIO ORTIZ", "ANTONIO BASILIO", "RODOLFO VALLEJO", "VICTOR CADENA", "VICTOR RAMIREZ", "JESUS MORALES", "MARINO GARCIA", "MARCOS IVAN", "ANGEL VILLALVAZO", "MARGARITO SANCHEZ" }));
        txt_op.setToolTipText("");
        txt_op.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_op.setPreferredSize(new java.awt.Dimension(147, 15));
        txt_op.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_opActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jTextField3.setText("RPM");
        jTextField3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField3.setPreferredSize(new java.awt.Dimension(26, 15));

        jTextField4.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jTextField4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField4.setPreferredSize(new java.awt.Dimension(7, 15));

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("FIRMA OPERADOR:");

        jTextField5.setBackground(new java.awt.Color(51, 51, 51));
        jTextField5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("SELLO Y FIRMA SALIDA RPM");

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("SELLO Y FIRMA RECIBIDO DEL CLIENTE");

        jTextField7.setBackground(new java.awt.Color(51, 51, 51));
        jTextField7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField8.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("CESAR PUERTOS DE LOS SANTOS RFC: PUSC 811030 8Y8");
        jTextField8.setBorder(null);

        jTextField9.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setText("AV.VENUSTIANO CARRANZA N° 125 COL.JALAPILLA, RAFAEL DELGADO, VER. CP. 94410 TEL (272)7428669");
        jTextField9.setBorder(null);

        jTextField11.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setText("www.maquilarpm.com.mx  ");
        jTextField11.setBorder(null);

        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jTextField2.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("PEDIDO");
        jTextField2.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("#");

        jButton4.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jButton4.setText("LINEA");
        jButton4.setBorder(null);

        jButton5.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jButton5.setText("SKU MATERIAL");
        jButton5.setBorder(null);

        jTextField12.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setText("DESCRIPCION");
        jTextField12.setBorder(null);

        jTextField13.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setText("TARIMAS");
        jTextField13.setBorder(null);

        jTextField14.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setText("CANTIDAD");
        jTextField14.setBorder(null);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField14, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3)
                .addComponent(jButton4)
                .addComponent(jButton5)
                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTextField14.getAccessibleContext().setAccessibleName("");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        txt_pedido1.setEditable(false);
        txt_pedido1.setBackground(new java.awt.Color(255, 255, 255));
        txt_pedido1.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        txt_pedido1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pedido1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_pedido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pedido1ActionPerformed(evt);
            }
        });

        jLabel8.setText("2");

        txt_codigo1.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        txt_codigo1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_codigo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigo1ActionPerformed(evt);
            }
        });

        txt_descripcion1.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        txt_descripcion1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_descripcion1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_cantidad1.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        txt_cantidad1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cantidad1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_tarimas1.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        txt_tarimas1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tarimas1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_tarimas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tarimas1ActionPerformed(evt);
            }
        });

        txt_linea1.setEditable(true);
        txt_linea1.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        txt_linea1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "      40", "      60", "      80", "      120", "      N/A" }));
        txt_linea1.setToolTipText("");
        txt_linea1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_linea1.setPreferredSize(new java.awt.Dimension(137, 17));
        txt_linea1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_linea1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_pedido1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_linea1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_codigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_descripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_tarimas1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cantidad1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_codigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txt_pedido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel8)
                .addComponent(txt_descripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_cantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_tarimas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_linea1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtb_salida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jtb_salida.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jtb_salida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtb_salida.setGridColor(new java.awt.Color(255, 255, 255));
        jtb_salida.setRowHeight(36);
        jtb_salida.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jtb_salida.setTableHeader(null);
        jtb_salida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_salidaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtb_salida);

        jTextField10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField15.setBackground(new java.awt.Color(51, 51, 51));
        jTextField15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        txt_pedido.setEditable(false);
        txt_pedido.setBackground(new java.awt.Color(255, 255, 255));
        txt_pedido.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        txt_pedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pedido.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel24.setText("1");

        txt_codigo.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        txt_codigo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoActionPerformed(evt);
            }
        });

        txt_descripcion.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        txt_descripcion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_descripcion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_cantidad.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        txt_cantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_tarimas.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        txt_tarimas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tarimas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_tarimas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tarimasActionPerformed(evt);
            }
        });

        txt_linea.setEditable(true);
        txt_linea.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        txt_linea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "      40", "      60", "      80", "      120", "      N/A" }));
        txt_linea.setToolTipText("");
        txt_linea.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_linea.setPreferredSize(new java.awt.Dimension(137, 17));
        txt_linea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lineaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_linea, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_tarimas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txt_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel24)
                .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_tarimas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_linea, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTextField6.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("4024182");
        jTextField6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField6.setPreferredSize(new java.awt.Dimension(69, 15));

        jTextField16.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.setText("N/A");
        jTextField16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField16.setPreferredSize(new java.awt.Dimension(69, 15));

        jdc_fecha.setDateFormatString("yyyy/MM/dd  HH:mm:ss");
        jdc_fecha.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_des, 0, 219, Short.MAX_VALUE)
                            .addComponent(txt_clien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_op, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jTextField5))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField15)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField7)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(1, 1, 1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_pla, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_au, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jdc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 311, Short.MAX_VALUE)))))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jdc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_des, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txt_clien, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_au, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_pla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txt_op, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(129, 129, 129)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jButton6.setBackground(new java.awt.Color(242, 242, 242));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inicio.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(242, 242, 242));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton3.setText("AGREGAR ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("NUEVO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        listar();
        if(txt_des.getSelectedItem().equals(" ")){
            JOptionPane.showMessageDialog(null,"Falta ingresar el destino");
            
        }
        else if(txt_clien.getSelectedItem().equals(" ")){
            JOptionPane.showMessageDialog(null,"Falta ingresar el cliente");
            
        }
       else if(txt_au.getSelectedItem().equals(" ")){
            JOptionPane.showMessageDialog(null,"Falta ingresar quien autoriza");
            
        }
       else if(txt_pla.getSelectedItem().equals(" ")){
            JOptionPane.showMessageDialog(null,"Falta ingresar las placas de la unidad ");
            
        }
       else if(txt_op.getSelectedItem().equals(" ")){
            JOptionPane.showMessageDialog(null,"Falta ingresar el operador");
            
        }
       else if(txt_linea.getSelectedItem().equals(" ")){
            JOptionPane.showMessageDialog(null,"Falta ingresar la linea");    
        }
       else if(txt_cantidad.getText().equals("0")){
            JOptionPane.showMessageDialog(null,"Falta ingresar cantidad");    
        }
        else{
        removeButton(txt_des);
        removeButton(txt_clien);
        removeButton(txt_au);
        removeButton(txt_pla);
        removeButton(txt_op);
        removeButton(jdc_fecha);
        removeButton(txt_linea);
        removeButton(txt_linea1);
        
        fecha();

          Miprintable mp = new Miprintable(jPanel1);
          PrinterJob job = PrinterJob.getPrinterJob();
       
           job.setPrintable(mp);
           boolean ok = job.printDialog();
           if (ok) {
           
            try {
                  job.print();        
                  guardar();
                  des();
                 
        
      
              } catch (PrinterException ex) {
                 System.err.println(ex.getMessage());
                 JOptionPane.showMessageDialog(null,"Error al imprimir");
              
             }
        }
           
           }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       if(click==0){
           jPanel10.setVisible(true);
       }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_codigo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigo1ActionPerformed
        enviar = 2;
        
        Frm_BuscarPedido C = new Frm_BuscarPedido();
        Frm_Principals.contenedor.add(C);
        Dimension desktopSize = contenedor.getSize();
        Dimension FrameSize = C.getSize();
        C.setLocation(( FrameSize.width)/2, ( FrameSize.height)/2);
        C.toFront();
        C.setVisible(true);
    }//GEN-LAST:event_txt_codigo1ActionPerformed
    private void tarimas1(){
        String cod=txt_codigo.getText();
        int tar = Integer.parseInt(txt_tarimas.getText());
        if(cod.equals("31000821")){
        int pzss=tar*3750;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
    }
        else if(cod.equals("31000821.")){
        int pzss=tar*2550;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
        else if(cod.equals("31000821..")){
        int pzss=tar*2250;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
        else if(cod.equals("31000824")){
        int pzss=tar*3150;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
        else if(cod.equals("31000826")){
        int pzss=tar*2625;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
        else if(cod.equals("3100026.")){
        int pzss=tar*3675;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
        else if(cod.equals("31002805")){
        int pzss=tar*4950;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
        else if(cod.equals("31002805.")){
        int pzss=tar*3600;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
       else if(cod.equals("31009392")){
        int pzss=tar*3150;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
    }
    private void tarimas2(){
        String cod=txt_codigo1.getText();
        int tar = Integer.parseInt(txt_tarimas1.getText());
        if(cod.equals("31000821")){
        int pzss=tar*3750;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
    }
        else if(cod.equals("31000821.")){
        int pzss=tar*2550;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
        else if(cod.equals("31000821..")){
        int pzss=tar*2250;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
        else if(cod.equals("31000824")){
        int pzss=tar*3150;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
        else if(cod.equals("31000826")){
        int pzss=tar*2625;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
        else if(cod.equals("3100026.")){
        int pzss=tar*3675;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
        else if(cod.equals("31002805")){
        int pzss=tar*4950;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
        else if(cod.equals("31002805.")){
        int pzss=tar*3600;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
       else if(cod.equals("31009392")){
        int pzss=tar*3150;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
    }
    private void jtb_salidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_salidaMouseClicked

    }//GEN-LAST:event_jtb_salidaMouseClicked

    private void txt_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoActionPerformed
        enviar = 1;
        
        Frm_BuscarPedido C = new Frm_BuscarPedido();
        Frm_Principals.contenedor.add(C);
        Dimension desktopSize = contenedor.getSize();
        Dimension FrameSize = C.getSize();
        C.setLocation(( FrameSize.width)/2, ( FrameSize.height)/2);
        C.toFront();
        C.setVisible(true);
    }//GEN-LAST:event_txt_codigoActionPerformed

    private void txt_tarimasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tarimasActionPerformed
        int cod = Integer.parseInt(txt_codigo.getText());
        int tar = Integer.parseInt(txt_tarimas.getText());
   
        if(cod==31007809){
        int pzss=tar*90;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
        else if(cod==31007805){
        int pzss=tar*90;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
        else if(cod==31007793){
        int pzss=tar*90;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
        else if(cod==31009889){
        int pzss=tar*90;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
        else if(cod==31009274){
        int pzss=tar*90;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
        else if(cod==31007810){
        int pzss=tar*105;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
        else if(cod==31007794){
        int pzss=tar*105;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
        else if(cod==31007784){
        int pzss=tar*128;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
        else if(cod==31007803){
        int pzss=tar*128;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
        else if(cod==31009270){
        int pzss=tar*144;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
        else if(cod==31007801){
        int pzss=tar*144;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
        else if(cod==31007790){
        int pzss=tar*144;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
        else if(cod==31009275){
        int pzss=tar*230;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }
        else if(cod==31007799){
        int pzss=tar*230;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
    }
        else if(cod==31007792){
        int pzss=tar*230;
        String pzs1=""+pzss;
        txt_cantidad.setText(pzs1);
        }else {
            tarimas1();
        }
     // int cantidad = Integer.parseInt(txt_cantidad.getText());
       //codigo = txt_codigo.getText();
       //int stock = CP.verificarStock(codigo);
        
        //if(cantidad > stock){
          // JOptionPane.showMessageDialog(null, "¡Pedido agotado!");
           //txt_cantidad.setText("0");
           //txt_tarimas.setText("");
           
        //}
       
    }//GEN-LAST:event_txt_tarimasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         limpiar();
                  iniciar();
                  activar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_lineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lineaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lineaActionPerformed

    private void txt_linea1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_linea1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_linea1ActionPerformed

    private void txt_pedido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pedido1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pedido1ActionPerformed

    private void txt_tarimas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tarimas1ActionPerformed
       int cod = Integer.parseInt(txt_codigo1.getText());
        int tar = Integer.parseInt(txt_tarimas1.getText());
   
        if(cod==31007809){
        int pzss=tar*90;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
        else if(cod==31007805){
        int pzss=tar*90;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
        else if(cod==31007793){
        int pzss=tar*90;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
        else if(cod==31009889){
        int pzss=tar*90;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
        else if(cod==31009274){
        int pzss=tar*90;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
        else if(cod==31007810){
        int pzss=tar*105;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
        else if(cod==31007794){
        int pzss=tar*105;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
        else if(cod==31007784){
        int pzss=tar*128;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
        else if(cod==31007803){
        int pzss=tar*128;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
        else if(cod==31009270){
        int pzss=tar*144;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
        else if(cod==31007801){
        int pzss=tar*144;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
        else if(cod==31007790){
        int pzss=tar*144;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
        else if(cod==31009275){
        int pzss=tar*230;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }
        else if(cod==31007799){
        int pzss=tar*230;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
    }
        else if(cod==31007792){
        int pzss=tar*230;
        String pzs1=""+pzss;
        txt_cantidad1.setText(pzs1);
        }else {
            tarimas2();
        }
    }//GEN-LAST:event_txt_tarimas1ActionPerformed

    private void txt_plaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_plaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_plaActionPerformed

    private void txt_opActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_opActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_opActionPerformed

        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    public static com.toedter.calendar.JDateChooser jdc_fecha;
    private javax.swing.JTable jtb_salida;
    private javax.swing.JComboBox<String> txt_au;
    public static javax.swing.JTextField txt_cantidad;
    public static javax.swing.JTextField txt_cantidad1;
    private javax.swing.JComboBox<String> txt_clien;
    public static javax.swing.JButton txt_codigo;
    public static javax.swing.JButton txt_codigo1;
    private javax.swing.JComboBox<String> txt_des;
    public static javax.swing.JTextField txt_descripcion;
    public static javax.swing.JTextField txt_descripcion1;
    private javax.swing.JComboBox<String> txt_linea;
    private javax.swing.JComboBox<String> txt_linea1;
    private javax.swing.JComboBox<String> txt_op;
    public static javax.swing.JTextField txt_pedido;
    public static javax.swing.JTextField txt_pedido1;
    private javax.swing.JComboBox<String> txt_pla;
    public static javax.swing.JTextField txt_tarimas;
    public static javax.swing.JTextField txt_tarimas1;
    // End of variables declaration//GEN-END:variables
}
