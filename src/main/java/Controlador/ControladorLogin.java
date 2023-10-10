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
    private VistaSocios vSocios;
    private SocioDAO socioDAO;
    //private VistaInfoBD vInfoBD = null;

    public ControladorLogin() {
        vMensaje = new VistaMensajes();
        vDatos = new VistaDatosDB();
        vSocios = new VistaSocios();
        conectarDB();
        recuperarDatos();
        ejecutarCRUD();
        desconectarDB();
    }

    private void ejecutarCRUD() {
        String idSocio;
        socioDAO = new SocioDAO(conexion);
        Scanner scanner = new Scanner(System.in);
        System.out.println("************************");
        System.out.println("1.Listar Socios // 2.Añadir socio // 3.Eliminar socio // 4.Modificar socio");
        System.out.print("Introduce una funcion: ");
        String op = scanner.nextLine();
        switch (op) {
            case "1":
                try {
                ArrayList<Socio> lSocios = pideSocios();
                for (int i = 0; i < lSocios.size(); i++) {
                    vSocios.muestraSocios_Numero_Nombre(lSocios.get(i));
                }
            } catch (SQLException e) {
                vMensaje.mensajeConsola("Error en la peticion: ", e.getMessage());
            }
            break;
            case "2":
                Socio nuevoSocio = null;
                altaSocios(nuevoSocio);
            break;
            case "3":
                System.out.println("************************");
                System.out.print("Introduce una id a eliminar: ");
                idSocio = scanner.nextLine();
                eliminarSocio(idSocio);
            break;
            case "4":
                String campoAModificar, campoModificado;
                System.out.println("************************");
                System.out.print("Introduce una id a modificar: ");
                idSocio = scanner.nextLine();
                System.out.print("¿Que campo desea modificar? 1.Nombre, 2.DNI, 3.Fecha de nacimiento, 4.Telefono, 5.Correo, 6.Fecha de entrada, 7.Categoria ");
                campoAModificar = scanner.nextLine();
                if(null == campoAModificar){
                    System.out.println("Introduce un campo valido");
                }else switch (campoAModificar) {
                case "1":
                    System.out.print("Introduce un nombre: ");
                    campoModificado = scanner.nextLine();
                    modificarSocio(idSocio, "nombre", campoModificado);
                    break;
                case "2":
                    System.out.print("Introduce un DNI: ");
                    campoModificado = scanner.nextLine();
                    modificarSocio(idSocio, "dni", campoModificado);
                    break;
                case "3":
                    System.out.print("Introduce fecha de nacimiento: ");
                    campoModificado = scanner.nextLine();
                    modificarSocio(idSocio, "fechaNacimiento", campoModificado);
                    break;
                case "4":
                    System.out.print("Introduce un telefono: ");
                    campoModificado = scanner.nextLine();
                    modificarSocio(idSocio, "telefono", campoModificado);
                    break;
                case "5":
                    System.out.print("Introduce un correo: ");
                    campoModificado = scanner.nextLine();
                    modificarSocio(idSocio, "correo", campoModificado);
                    break;
                case "6":
                    System.out.print("Introduce una fecha de entrada: ");
                    campoModificado = scanner.nextLine();
                    modificarSocio(idSocio, "fechaEntrada", campoModificado);
                    break;
                case "7":
                    System.out.print("Introduce una categoria: ");
                    campoModificado = scanner.nextLine();
                    modificarSocio(idSocio, "categoria", campoModificado);
                    break;
                default:
                    System.out.println("Introduce un campo valido");
                    break;
            }
            break;

            default:
                throw new AssertionError();
        }
    }

    private ArrayList<Socio> pideSocios() throws SQLException {
        return socioDAO.listaSocios();
    }

    private void altaSocios(Socio nuevoSocio) {
        try {
            socioDAO.altaSocio(nuevoSocio);
            vMensaje.mensajeConsola("Usuario creado con exito");
        } catch (SQLException e) {
            vMensaje.mensajeConsola("Error en la peticion: ", e.getMessage());
        }
    }
    
    private void eliminarSocio(String idSocio){
        try {
            socioDAO.eliminarSocio(idSocio);
            vMensaje.mensajeConsola("Usuario eliminado con exito");
        } catch (SQLException e) {
             vMensaje.mensajeConsola("Error en la peticion: ", e.getMessage());
        }
    }
    
    private void modificarSocio(String idSocio, String campoAModificar ,String campoModificado){
        try {
            socioDAO.modificarSocio(idSocio, campoAModificar, campoModificado);
            vMensaje.mensajeConsola("Usuario actualizado con exito");
        } catch (SQLException e) {
            vMensaje.mensajeConsola("Error en la peticion: ", e.getMessage());
        }
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
