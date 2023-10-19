/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.ControladorPrincipal;
import Modelo.Socio;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Antonio
 */
public class VistaSocios {

    Scanner scanner = new Scanner(System.in);
    ControladorPrincipal cp;

    public void muestraSocios_Numero_Nombre(Socio socio) {
        System.out.println("Numero: " + socio.getCodSocio());
        System.out.println("Nombre: " + socio.getNombre());
        System.out.println("************************");
    }

    public String muestraMenuMSG() {

        System.out.println("************************");
        System.out.println("1.Listar Socios // 2.Añadir socio // 3.Eliminar socio // 4.Modificar socio // 5.Salir");
        System.out.print("Introduce una funcion: ");
        String op = scanner.nextLine();
        return op;
    }

    public String eliminarSocioMSG() {
        String idSocio = "";
        System.out.println("************************");
        System.out.print("Introduce una id a eliminar: ");
        idSocio = scanner.nextLine();
        return idSocio;
    }

    public String modificarSocioMSG(String caso) {
        String devolver = "";
        switch (caso) {
            case "id":
                System.out.println("************************");
                System.out.print("Introduce una id a modificar: ");
                devolver = scanner.nextLine();
                break;
            case "campoModificar":
                System.out.print("¿Que campo desea modificar? 1.Nombre, 2.DNI, 3.Fecha de nacimiento, 4.Telefono, 5.Correo, 6.Fecha de entrada, 7.Categoria ");
                devolver = scanner.nextLine();
                break;
            case "1":
                System.out.print("Introduce un nombre: ");
                devolver = scanner.nextLine();
                break;
            case "2":
                 System.out.print("Introduce un DNI: ");
                devolver = scanner.nextLine();
                break;
            case "3":
               System.out.print("Introduce fecha de nacimiento: ");
                devolver = scanner.nextLine();
                break;
            case "4":
                System.out.print("Introduce un telefono: ");
                devolver = scanner.nextLine();
                break;
            case "5":
                System.out.print("Introduce un correo: ");
                devolver = scanner.nextLine();
                break;
            case "6":
                System.out.print("Introduce una fecha de entrada: ");
                devolver = scanner.nextLine();
                break;
            case "7":
                System.out.print("Introduce una categoria: ");
                devolver = scanner.nextLine();
                break;
            default:
                System.out.println("Campo erroneo");
                break;
        }
        /* if (caso == "id") {
            System.out.println("************************");
            System.out.print("Introduce una id a modificar: ");
            devolver = scanner.nextLine();
        } else if (caso == "campoModificar") {
            System.out.print("¿Que campo desea modificar? 1.Nombre, 2.DNI, 3.Fecha de nacimiento, 4.Telefono, 5.Correo, 6.Fecha de entrada, 7.Categoria ");
            devolver = scanner.nextLine();
        } else {
            if (caso == "1") {
                System.out.print("Introduce un nombre: ");
                devolver = scanner.nextLine();
            } else if (caso == "2") {
                System.out.print("Introduce un DNI: ");
                devolver = scanner.nextLine();
            } else if (caso == "3") {
                System.out.print("Introduce fecha de nacimiento: ");
                devolver = scanner.nextLine();
            } else if (caso == "4") {
                System.out.print("Introduce un telefono: ");
                devolver = scanner.nextLine();
            } else if (caso == "5") {
                System.out.print("Introduce un correo: ");
                devolver = scanner.nextLine();
            } else if (caso == "6") {
                System.out.print("Introduce una fecha de entrada: ");
                devolver = scanner.nextLine();
            } else if (caso == "7") {
                System.out.print("Introduce una categoria: ");
                devolver = scanner.nextLine();
            } else {
                System.out.println("Introduce un campo válido");
            }
        }*/
        return devolver;
    }
}
