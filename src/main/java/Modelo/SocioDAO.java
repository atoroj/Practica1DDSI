/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Antonio
 */
public class SocioDAO {

    Conexion conexion = null;
    PreparedStatement ps = null;

    public SocioDAO(Conexion c) {
        this.conexion = c;
    }

    public ArrayList<Socio> listaSocios() throws SQLException {
        ArrayList listaSocios = new ArrayList();
        String consulta = "SELECT * FROM SOCIO";
        ps = conexion.getConexion().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Socio socio = new Socio(rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
            listaSocios.add(socio);
        }
        return listaSocios;
    }

    public void altaSocio(Socio nuevoSocio) throws SQLException {
            //'S001','Iria Mosquera Gil','54941721B','31/03/1977','656391774','iria_89@post.com','04/06/2016','A');
            String consulta = "INSERT INTO SOCIO VALUES (?,?,?,?,?,?,?,?)";
            ps = conexion.getConexion().prepareStatement(consulta);
            ps.setString(1, "S011");
            ps.setString(2, "Antonio Toro Jaen");
            ps.setString(3, "774978856");
            ps.setString(4, "25/09/1999");
            ps.setString(5, "618729985");
            ps.setString(6, "atorojaen@gmail.com");
            ps.setString(7, "10/10/2023");
            ps.setString(8, "A");
            ps.executeUpdate();
    }
    public void eliminarSocio(String idSocio) throws SQLException{
        String consulta = "DELETE FROM SOCIO WHERE numeroSocio = ?";
        ps = conexion.getConexion().prepareStatement(consulta);
        ps.setString(1, idSocio);
        ps.executeUpdate();
    }
    public void modificarSocio(String idSocio, String campoAModificar, String campoModificado) throws SQLException{
        String consulta = "UPDATE SOCIO SET " +campoAModificar+" = ? WHERE numeroSocio = ?";
        ps = conexion.getConexion().prepareStatement(consulta);
        ps.setString(1, campoModificado);
        ps.setString(2, idSocio);
        ps.executeUpdate();
    }
}
