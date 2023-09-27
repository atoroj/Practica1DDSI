
package Controlador;

import Modelo.Conexion;
import Vista.VistaMensajes;

/**
 *
 * @author AToro
 */
public class ControladorLogin {

    ControladorLogin cLogin = new ControladorLogin();
    private Conexion conexion = null;
    private VistaMensajes vMensaje = null;
    //private VistaInfoBD vInfoBD = null;
    
    public ControladorLogin(){
        vMensaje = new VistaMensajes();
        //vInfoBD = new VistaInfoBD();
    }
    private Conexion conectarDB(){
        return conexion;
    }

}
