/*
 * Instituto Tecnológico de Costa Rica
 * Escuela de Ingeniería en Computación
 * Lenguajes de Programación
 * Casa de Apuestas de Eddy
 */

package comandos;

import java.util.ArrayList;
import poker.Jugador;
import servidor.Servidor;

/**
 * Esta clase se encarga de implementar el comportamiento del comando
 * CrearMesa.
 * @author kortega
 */
public class ComandoCrearMesa extends Comando{
    
    public static final String COMANDO = "crearMesa";//Comando de la clase.
    
    private static final short POS_JUGADOR = 3;
    private static final short POS_NOMBRE = 0;
    private static final short POS_CANTIDAD = 1;
    private static final short POS_TIPO = 2;
        
    @Override
   public Object ejecutar(Object args)
   {
       //idmesa 0
       //cantidad jugadores
       //tipo juego
       //Nombre del juego
       ArrayList<Object> dato = (ArrayList<Object>) args;
       Servidor serv = Servidor.getInstance();
       Jugador jugador = (Jugador)dato.get(POS_JUGADOR);
       serv.post((String) dato.get(POS_NOMBRE)+jugador.getId());
       String idMesa = serv.crearMesa(jugador,
                              (String)dato.get(POS_NOMBRE),
                              Integer.parseInt( (String) dato.get(POS_CANTIDAD) ),
                              Integer.parseInt( (String) dato.get(POS_TIPO) ));
       Servidor.getInstance().enviarComando(jugador.getId(), "mesaCreada", idMesa);
       return null;
   }
}
