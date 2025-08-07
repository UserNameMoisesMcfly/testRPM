package Clases;

import Conexion.Conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cls_Pedido {
    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    private final String SQL_INSERT_PRODUCTOS = "INSERT INTO pedido (ped_num,ped_codigo,ped_descripcion,ped_cantidad) values (?,?,?,?)";
    private final String SQL_SELECT_PRODUCTOS = "SELECT *FROM pedido";
    
    public Cls_Pedido(){
        PS = null;
        CN = new Conectar();
    }
    
    private DefaultTableModel setTitulosProductos(){
        DT = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        DT.addColumn("Pedido");
        DT.addColumn("SKU");
        DT.addColumn("Descripcion");
        DT.addColumn("cantidad");
        return DT;
    }
    
    public DefaultTableModel getDatosProductos(){
        try {
            setTitulosProductos();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_PRODUCTOS);
            RS = PS.executeQuery();
            Object[] fila = new Object[4];
            while(RS.next()){
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);  
                fila[2] = RS.getString(3);
                fila[3] = RS.getInt(4); 
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
    
    public int registrarProducto(String pedido,String codigo, String descripcion, int cantidad){
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_PRODUCTOS);
            PS.setString(1, pedido);
            PS.setString(2, codigo);
            PS.setString(3, descripcion);
            PS.setInt(4, cantidad);
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Pedido registrado con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el pedido.");
            System.err.println("Error al registrar el pedido." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }

    public int actualizarProducto(String pedido,String codigo, String descripcion,int cantidad){
        eliminarProducto1(pedido);
        String SQL = "INSERT INTO pedido (ped_num,ped_codigo,ped_descripcion,ped_cantidad) values (?,?,?,?)";
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            PS.setString(1, pedido);
            PS.setString(2, codigo);
            PS.setString(3, descripcion);
            PS.setInt(4, cantidad);
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Pedido actualizado con éxito");
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar pedido." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
    public int eliminarProducto1(String pedido){
        String SQL = "DELETE from pedido WHERE ped_num ='"+pedido+"'";
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            if(res > 0){
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar pedido." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
    public int eliminarProducto(String pedido){
        String SQL = "DELETE from pedido WHERE ped_num ='"+pedido+"'";
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Pedido eliminado con éxito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No es posible eliminar el pedido.");
            System.err.println("Error al eliminar pedido." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
    
}
