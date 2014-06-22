/*
 * Instituto Tecnológico de Costa Rica
 * Escuela de Ingeniería en Computación
 * Lenguajes de Programación
 * Casa de Apuestas de Eddy
 */

package comandos;

import poker.Jugador;
import servidor.Servidor;

/**
 * Esta clase se encarga de implementar el comportamiento del comando
 * CrearMesa.
 * @author kortega
 */
public class ComandoCrearMesa extends Comando{
    
    public static final String COMANDO = "crearMesa";//Comando de la clase.

    @Override
   public Object ejecutar(Object args)
   {
       Servidor serv = Servidor.getInstance();
       return serv.crearMesa((Jugador)args);
   }
}
