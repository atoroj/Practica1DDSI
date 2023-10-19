/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Socio;
import Modelo.SocioDAO;
import Vista.VistaMensajes;
import Vista.VistaSocios;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Antonio
 */
public class ControladorPrincipal {

    private Conexion conexion = null;
    private SocioDAO socioDAO;
    private VistaMensajes vMensaje;
    private VistaSocios vSocios;

    public ControladorPrincipal(Conexion conexion) {
        this.conexion = conexion;
        vSocios = new VistaSocios();
        vMensaje = new VistaMensajes();
        socioDAO = new SocioDAO(conexion);
        ejecutarCRUD();
    }

    private void ejecutarCRUD() {
        socioDAO = new SocioDAO(this.conexion);
        String idSocio;
        switch (vSocios.muestraMenuMSG()) {
            case "1":
                ArrayList<Socio> lSocios = pideSocios();
                for (int i = 0; i < lSocios.size(); i++) {
                    vSocios.muestraSocios_Numero_Nombre(lSocios.get(i));
                }
            break;
            case "2":
                Socio nuevoSocio = null;
                altaSocios(nuevoSocio);
                break;
            case "3":
                eliminarSocio(vSocios.eliminarSocioMSG());
                break;
            case "4":
                String campoAModificar, campoModificado;
                idSocio = vSocios.modificarSocioMSG("id");
                campoAModificar = vSocios.modificarSocioMSG("campoModificar");
                    switch (campoAModificar) {
                        case "1" -> modificarSocio(idSocio, "nombre", vSocios.modificarSocioMSG(campoAModificar));
                        case "2" -> modificarSocio(idSocio, "dni", vSocios.modificarSocioMSG(campoAModificar));
                        case "3" -> modificarSocio(idSocio, "fechaNacimiento", vSocios.modificarSocioMSG(campoAModificar));
                        case "4" -> modificarSocio(idSocio, "telefono", vSocios.modificarSocioMSG(campoAModificar));
                        case "5" -> modificarSocio(idSocio, "correo", vSocios.modificarSocioMSG(campoAModificar));
                        case "6" -> modificarSocio(idSocio, "fechaEntrada", vSocios.modificarSocioMSG(campoAModificar));
                        case "7" -> modificarSocio(idSocio, "categoria", vSocios.modificarSocioMSG(campoAModificar));
                    }
                break;

            case "5":
                System.exit(0);
                break;
        }
    }

    private ArrayList<Socio> pideSocios(){
         ArrayList<Socio> lSocios = new ArrayList<Socio>();
        try {
           lSocios = socioDAO.listaSocios();
        } catch (SQLException e) {
            vMensaje.mensajeConsola("Error en la peticion: ", e.getMessage());
        }
        return lSocios;
    }

    private void altaSocios(Socio nuevoSocio) {
        try {
            socioDAO.altaSocio(nuevoSocio);
            vMensaje.mensajeConsola("Usuario creado con exito");
        } catch (SQLException e) {
            vMensaje.mensajeConsola("Error en la peticion: ", e.getMessage());
        }
    }

    private void eliminarSocio(String idSocio) {
        try {
            socioDAO.eliminarSocio(idSocio);
            vMensaje.mensajeConsola("Usuario eliminado con exito");
        } catch (SQLException e) {
            vMensaje.mensajeConsola("Error en la peticion: ", e.getMessage());
        }
    }

    private void modificarSocio(String idSocio, String campoAModificar, String campoModificado) {
        try {
            socioDAO.modificarSocio(idSocio, campoAModificar, campoModificado);
            vMensaje.mensajeConsola("Usuario actualizado con exito");
        } catch (SQLException e) {
            vMensaje.mensajeConsola("Error en la peticion: ", e.getMessage());
        }
    }
}
