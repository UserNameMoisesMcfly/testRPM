package Clases;

import Conexion.Conectar;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cls_Salida1 {
    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    private final String SQL_INSERT_SALIDA = "INSERT INTO salida (sal_fecha,sal_pro_codigo,sal_pro_codigo1,sal_pro_codigo2,sal_pro_codigo3,sal_cantidad,sal_cantidad1,sal_cantidad2,sal_cantidad3) values (?,?,?,?,?,?,?,?,?)";
   private final String SQL_SELECT_SALIDA = "SELECT (COUNT(sal_id)+1) From salida";
    String a="";
    public Cls_Salida1(){
        PS = null;
        CN = new Conectar();
    }
    
    private DefaultTableModel setTitulosSalida(){
        DT = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
           }
            
        };
        DT.addColumn("No. FOLIO:");
       
        return DT;
    }
    
    public DefaultTableModel getDatosSalida(){
       
        try {
            setTitulosSalida();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_SALIDA);
            RS = PS.executeQuery();
            Object[] fila = new Object[1];
            while(RS.next()){
                 int r=RS.getInt(1);
                if(r<10){
                a="Folio:  B00000";
                fila[0] =a+ RS.getInt(1);
                }else if(r>=10 && r<100){
                a="Folio:  B0000";
                fila[0] =a+ RS.getInt(1);    
                }else if(r>=100 && r<1000){
                a="Folio B000";
                fila[0] =a+ RS.getInt(1);    
                }else if(r>=1000 && r<10000){
                a="Folio:  B00";
                fila[0] =a+ RS.getInt(1);    
                }else if(r>=10000 && r<100000){
                a="Folio:  B0";
                fila[0] =a+ RS.getInt(1);    
                }else{
                a="Folio:  B";
                fila[0] =a+ RS.getInt(1);    
                }
            
                DT.addRow(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar los datos."+e.getMessage());
        } finally{
            PS = null;
            RS = null;
            CN.desconectar();
        }
       
        return DT;
    }
    
    public int registrarSalida(Date fecha,String codigo,String codigo1,String codigo2,String codigo4, int cantidad,int cantidad1,int cantidad2,int cantidad4){
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_SALIDA);
            PS.setDate(1, fecha);
            PS.setString(2, codigo);
            PS.setString(3, codigo1);
            PS.setString(4, codigo2);
            PS.setString(5, codigo4);
            PS.setInt(6, cantidad);
            PS.setInt(7, cantidad1);
            PS.setInt(8, cantidad2);
            PS.setInt(9, cantidad4);
            res = PS.executeUpdate();
            //if(res > 0){
             //   JOptionPane.showMessageDialog(null, "Salida registrada con éxito.");
           // }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la salida.");
            System.err.println("Error al registrar la salida." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
    
   // public int verificarStock(String codigo){
      //  int res=0;
       // try {
          //  PS = CN.getConnection().prepareStatement("SELECT inv_stock2 from inventario where inv_pro_codigo='"+codigo+"'");
          //  RS = PS.executeQuery();
            
          //  while(RS.next()){
           //     res = RS.getInt(1);
          //  }
            
       // } catch (SQLException e) {
       //     System.err.println("Error al devolver cantidad de registros." +e.getMessage());
      //  } finally{
         //   PS = null;
        //    CN.desconectar();
        //}
      //  return res;
    //}
}
