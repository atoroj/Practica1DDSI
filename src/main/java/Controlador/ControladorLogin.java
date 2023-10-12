package Controlador;

import Modelo.Conexion;
import Modelo.Socio;
import Modelo.SocioDAO;
import Vista.VistaDatosDB;
import Vista.VistaMensajes;
import Vista.VistaSocios;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AToro
 */
public class ControladorLogin {

    private Conexion conexion = null;
    private VistaMensajes vMensaje;
    private VistaDatosDB vDatos;
    private SocioDAO socioDAO;
    //private VistaInfoBD vInfoBD = null;

    public ControladorLogin() {
        vMensaje = new VistaMensajes();
        vDatos = new VistaDatosDB();
        ControladorPrincipal cPrincipal = new ControladorPrincipal(conectarDB());
        recuperarDatos();
        desconectarDB();
    }

    private Conexion conectarDB() {
        try {
            String server = "mariadb";
            String ip = "172.18.1.241";
            String bd = "DDSI_040";
            String u = "DDSI_040";
            String p = "DDSI_040";
            conexion = new Conexion(server, ip, bd, u, p);
        } catch (ClassNotFoundException ex) {
            vMensaje.mensajeConsola("Error de conexion: ", ex.getMessage());
        } catch (SQLException ex) {
            vMensaje.mensajeConsola("Error de conexion: ", ex.getMessage());
        }
        return conexion;
    }

    private void desconectarDB() {
        try {
            conexion.desconexion();
        } catch (Exception ex) {
            vMensaje.mensajeConsola("Error de desconexion: ", ex.getMessage());
        }
    }

    private void recuperarDatos() {
        try {
            vDatos.infoMetadatos(conexion.informacionDB());
        } catch (Exception ex) {
            vMensaje.mensajeConsola("Error de datos: ", ex.getMessage());
        }
    }

}
