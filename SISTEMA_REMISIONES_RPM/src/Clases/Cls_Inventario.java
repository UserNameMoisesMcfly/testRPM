package Clases;

import Conexion.Conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class Cls_Inventario {
    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    private final String SQL_SELECT_INVENTARIO = "SELECT inv_pro_codigo, pro_descripcion, inv_entradas, inv_salidas, inv_traspasos, inv_merma, inv_rechazos, inv_stock FROM inventario INNER JOIN producto ON inv_pro_codigo = pro_codigo";
    
    public Cls_Inventario(){
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
        DT.addColumn("Entradas");
        DT.addColumn("Consumo");
        DT.addColumn("Traspasos");
        DT.addColumn("Merma");
        DT.addColumn("Desplegado no conforme");
        DT.addColumn("Desplegado conforme");
        return DT;
    }
    
    public DefaultTableModel getDatosInventario2(){
        try {
            setTitulosInventario2();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_INVENTARIO);
            RS = PS.executeQuery();
            Object[] fila = new Object[9];
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
