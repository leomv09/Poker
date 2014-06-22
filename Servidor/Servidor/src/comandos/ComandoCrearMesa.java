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
    private static final short POS_ARGUMENTOS = 0;
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
       ArrayList<Object> arg = (ArrayList<Object>) dato.get(POS_ARGUMENTOS);
       Servidor serv = Servidor.getInstance();
       return serv.crearMesa((Jugador)dato.get(POS_JUGADOR),
                              (String)arg.get(POS_NOMBRE),
                              (int)arg.get(POS_CANTIDAD),
                              (int)arg.get(POS_TIPO));
   }
}
