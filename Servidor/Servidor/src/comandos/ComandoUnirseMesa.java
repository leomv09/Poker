/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import java.util.ArrayList;
import poker.Jugador;
import servidor.Servidor;

/**
 *
 * @author Leo
 */
public class ComandoUnirseMesa extends Comando{
    
    public static final String COMANDO = "unirseMesa";//Comando de la clase.
    private static final short POS_JUGADOR = 0;
    private static final short POS_IDMESA = 1;
    
    public Object ejecutar(Object args)
   {
       ArrayList<Object> dato = (ArrayList<Object>) args;
       Jugador jugador = (Jugador)dato.get(POS_JUGADOR);
       String idmesa = (String)dato.get(POS_IDMESA);
       
       Servidor serv = Servidor.getInstance();
       
       return null;
   }
    
}
