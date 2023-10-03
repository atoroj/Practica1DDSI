/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 *
 * @author Antonio
 */
public class VistaDatosDB {
    public void infoMetadatos(DatabaseMetaData dbmb) throws SQLException{
        System.out.println("*************************");
        System.out.println(dbmb.getDatabaseProductName());
        System.out.println(dbmb.getDatabaseProductVersion());
        System.out.println(dbmb.getURL());
        System.out.println(dbmb.getDriverName());
        System.out.println(dbmb.getDriverVersion());
        System.out.println(dbmb.getUserName());
        System.out.println("*************************");
    }
}
