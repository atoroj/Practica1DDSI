
package Modelo;

import java.sql.*;

/**
 *
 * @author Atoro
 */
public class Conexion {

    private Connection conn = null;

    public Conexion(String sgbd, String ip, String service_bd, String usuario, String password) throws ClassNotFoundException, SQLException {
        conn = DriverManager.getConnection("jdbc:oracle:thin:@172.17.20.39:1521:etsi", "DDSI_040","DDSI_040");
    }

    public Connection getConexion() {
        return conn;
    }

    public void desconexion() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
    //conn = DriverManager.getConnection("jdbc:oracle:thin:@172.17.20.39:1521:etsi", "DDSI_040","DDSI_040");
}
