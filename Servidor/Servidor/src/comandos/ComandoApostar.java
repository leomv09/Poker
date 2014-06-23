/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import java.util.ArrayList;
import poker.Mesa;
import servidor.*;

/**
 *
 * @author Leo
 */
public class ComandoApostar extends Comando{
    
    public static final String COMANDO = "apostar";//Comando de la clase.
    

   public Object ejecutar(Object args)
   {
       /*
       ArrayList<Object> datos=new ArrayList<>();
       String jugador= (String)datos.get(2);
       String idMesa=(String)datos.get(1);
       int cantidadApuesta=(int)datos.get(0);
       
       Mesa mesa=Servidor.getInstance().getMesa(idMesa);
       
       mesa.getPokerBet().almacenarApuesta(mesa.getIndexJugador(jugador), cantidadApuesta);
       */
       //devuelve null
       return null;
   }
    
}
