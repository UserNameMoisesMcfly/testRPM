package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conectar {
    // Driver nuevo (MySQL Connector)
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    // Ajusta según la config
private static final String USER = "rpmuser";
private static final String PASSWORD = "12345678";
private static final String HOST = "192.168.1.148";
private static final String DB   = "bd_rpm_ori";

private static final String URL =
    "jdbc:mysql://" + HOST + ":3306/" + DB
    + "?useUnicode=true&characterEncoding=UTF-8"
    + "&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"
    + "&connectTimeout=8000&socketTimeout=30000&tcpKeepAlive=true";

    private Connection conn;

    public Conectar() {
        conn = null;
    }

    public Connection getConnection() {
        try {
            // Conectorse auto‑registra, para mantener tu flujo
            Class.forName(DRIVER);

            // Reutiliza la conexión si sigue abierta
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(
                null,
                e.getMessage(),
                "Error al conectar con la base de datos",
                JOptionPane.ERROR_MESSAGE
            );
            System.exit(0); // conservado para no romper el comportamiento actual
        }
        return conn;
    }

    public void desconectar() {
        if (conn != null) {
            try {
                if (!conn.isClosed()) conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Error al cerrar la conexion con la base de datos",
                    JOptionPane.ERROR_MESSAGE
                );
            } finally {
                conn = null;
            }
        }
    }
}