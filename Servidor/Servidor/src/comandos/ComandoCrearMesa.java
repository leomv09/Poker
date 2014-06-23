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
       serv.post((String) dato.get(POS_NOMBRE)+(Jugador)dato.get(POS_JUGADOR));
       return serv.crearMesa((Jugador)dato.get(POS_JUGADOR),
                              (String)dato.get(POS_NOMBRE),
                              (int)dato.get(POS_CANTIDAD),
                              (int)dato.get(POS_TIPO));
   }
}
