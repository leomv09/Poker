/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import java.util.ArrayList;
import java.util.List;
import poker.Carta;
import poker.Mesa;
import servidor.Servidor;

/**
 *
 * @author Leo
 */
public class ComandoCambiarCarta extends Comando{
    
    public static final String COMANDO = "cambiarCarta";//Comando de la clase.

   public Object ejecutar(Object args)
   {
       List<Object> dato = (ArrayList<Object>) args;
       
       String idMesa = (String) dato.get(0);
       String idJugador = (String) dato.get(1);
       List<Carta> cartas = (List<Carta>) dato.get(2);
       
       Mesa mesa = Servidor.getInstance().getMesa(idMesa);
       mesa.cambiarCartas(idJugador, cartas);
       return null;
   }
    
}
