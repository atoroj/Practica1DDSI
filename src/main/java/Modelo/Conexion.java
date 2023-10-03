package Modelo;

import java.sql.*;

/**
 *
 * @author Atoro
 */
public class Conexion {
    private Connection conn = null;

    public Conexion(String sgbd, String ip, String service_bd, String usuario, String password) throws ClassNotFoundException, SQLException {
        if (sgbd.equals("mariadb")) {
            conn = DriverManager.getConnection("jdbc:" + sgbd + "://" + ip + "/" + service_bd, usuario, password);
        } else {
            conn = DriverManager.getConnection("jdbc:" + sgbd + ":thin:@" + ip + ":" + service_bd, usuario, password);
        }
        System.out.println("Conexion correcta");
    }

    public Connection getConexion() {
        return conn;
    }

    public void desconexion() throws SQLException {
        if (conn != null) {
            conn.close();
            System.out.println("Desconexion correcta");
        }
    }
    
    public DatabaseMetaData informacionDB() throws SQLException{
        return conn.getMetaData();
    }
}
