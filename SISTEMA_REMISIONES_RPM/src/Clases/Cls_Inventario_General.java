package Clases;

import Conexion.Conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class Cls_Inventario_General {
    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    private final String SQL_SELECT_INVENTARIO = "SELECT inv_pro_codigo, pro_descripcion, inv_merma, inv_rechazos2, inv_rechazos, inv_stock2, inv_stock, (inv_merma + inv_rechazos2 + inv_rechazos + inv_stock2 + inv_stock) FROM inventario INNER JOIN producto ON inv_pro_codigo = pro_codigo";
    public Cls_Inventario_General(){
        PS = null;
        CN = new Conectar();
    }
    
    private DefaultTableModel setTitulosInventario2(){
        DT = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        DT.addColumn("Código");
        DT.addColumn("Tipo de material");
        DT.addColumn("Merma proveedor");
        DT.addColumn("Armado no conforme");
        DT.addColumn("Desplegado no conforme");
        DT.addColumn("Armado conforme");
        DT.addColumn("Desplegado conforme");
        DT.addColumn("Total");
        return DT;
    }
    
    
    public DefaultTableModel getDatosInventario2(){
        try {
            setTitulosInventario2();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_INVENTARIO);
            RS = PS.executeQuery();
            Object[] fila = new Object[8];
            while(RS.next()){
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getInt(3);
                fila[3] = RS.getInt(4);
                fila[4] = RS.getInt(5);
                fila[5] = RS.getInt(6);
                fila[6] = RS.getInt(7);
                fila[7] = RS.getInt(8);
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
}
