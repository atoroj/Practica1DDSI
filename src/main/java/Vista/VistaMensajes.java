
package Vista;

/**
 *
 * @author AToro
 */
public class VistaMensajes {
    public void mensajeConsola(String texto){
        System.out.println("************************");
        System.out.println(texto);
        System.out.println("************************");
    }
    public void mensajeConsola (String texto, String error){
        System.out.println("*************************");
        System.out.println(texto);
        System.out.println(error);
        System.out.println("*************************");
    }
}
