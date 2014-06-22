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
    private static final short POS_JUGADOR = 1;
    private static final short POS_NOMBREMESA = 0;
    private static final short POS_CANTIDADJUGADORES = 1;
    private static final short POS_TIPOJUEGO = 2;
    
    @Override
   public Object ejecutar(Object args)
   {
       //Nombre mesa
       //cantidad jugadores
       //tipo juego
       //Jugador
       ArrayList<Object> dato = (ArrayList<Object>) args;
       ArrayList<Object> argumentos = (ArrayList<Object>) dato.get(0);
       Servidor serv = Servidor.getInstance();
       return serv.crearMesa((Jugador)dato.get(POS_JUGADOR),(String)argumentos.get(POS_NOMBREMESA),(String)argumentos.get(POS_CANTIDADJUGADORES),(int)argumentos.get(POS_TIPOJUEGO));
   }
}
