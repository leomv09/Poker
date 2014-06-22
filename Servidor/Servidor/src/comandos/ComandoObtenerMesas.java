/*
 * Instituto Tecnológico de Costa Rica
 * Escuela de Ingeniería en Computación
 * Lenguajes de Programación
 * Casa de Apuestas de Eddy
 */

package comandos;

import servidor.Servidor;

/**
 *
 * @author kortega
 */
public class ComandoObtenerMesas extends Comando{
    
    public static final String COMANDO = "obtenerMesas";//Comando de la clase.
    
   public Object ejecutar(Object args)
   {
       Servidor serv = Servidor.getInstance();
       return (Object)serv.getMesas();
   }
}
