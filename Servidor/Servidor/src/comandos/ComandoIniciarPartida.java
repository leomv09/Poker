/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import java.util.ArrayList;
import poker.Mesa;
import servidor.Servidor;

/**
 *
 * @author Leo
 */
public class ComandoIniciarPartida extends Comando{
    
    public static final String COMANDO = "iniciarPartida";//Comando de la clase
    private static final short POS_MESA = 0;
    private static final short POS_JUGADOR = 1;
    
    public Object ejecutar(Object args)
   {
       ArrayList<Object> dato = new ArrayList<>();
       String idmesa = (String) dato.get(POS_MESA);
       Servidor serv = Servidor.getInstance();
       Mesa mesa = serv.getMesa(idmesa);
       mesa.notificarInicioJuego();
       return null;
   }
}
