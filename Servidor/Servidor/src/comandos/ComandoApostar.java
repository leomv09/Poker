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
    

    /**
     *
     * @param args En este caso se recibe un arreglo de objetos. 
     * con la información de la apuesta.
     * @return null
     */
    @Override
   public Object ejecutar(Object args)
   {

       if(args != null)
       {
            ArrayList<Object> datos = (ArrayList<Object>) args;
            String jugador = (String)datos.get(2);
            String idMesa = (String)datos.get(1);
            int cantidadApuesta = (int)datos.get(0);
            System.out.println("Jugador: "+jugador);
            System.out.println("Mesa: "+idMesa);
            System.out.println("Cantidad apostar: "+cantidadApuesta);
            Mesa mesa = Servidor.getInstance().getMesa(idMesa);
            mesa.getPokerBet().almacenarApuesta(mesa.getIndexJugador(jugador), cantidadApuesta);
        }

       return null;
   }
    
}
