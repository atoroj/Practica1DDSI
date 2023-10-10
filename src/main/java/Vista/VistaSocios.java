/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.Socio;
import java.util.ArrayList;

/**
 *
 * @author Antonio
 */
public class VistaSocios {
    public void muestraSocios_Numero_Nombre(Socio socio){
        System.out.println("Numero: "+socio.getCodSocio());
        System.out.println("Nombre: "+socio.getNombre());
        System.out.println("************************");
    }
}
