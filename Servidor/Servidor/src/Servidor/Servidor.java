/*
 * Instituto Tecnológico de Costa Rica
 * Escuela de Ingeniería en Computación
 * Lenguajes de Programación
 * Casa de Apuestas de Eddy
 */

package Servidor;

/**
 * Servidor, Se encarga de recibir las conexiones entrantes
 * y la comunicación entre cada jugador y sus mesas.
 * Clase Singleton
 * @author kortega
 */
public class Servidor extends Thread{
    //Atributos
    /**
     * Única instancia del servidor
     */
    private static Servidor instance;
    /**
     * Única unstancia de ServerLog, para ir posteando los cambios
     * ocurridos en el servidor
     */
    private static ServerLog ventana;
    
    //Constructores
    /**
     * Crea una nueva instancia del servidor.
     */
    private Servidor(){
    }
    
    //Métodos
    
    public void crearVentana(){
        if(ventana == null){
            ventana = new ServerLog();
        }
    }
    
    /**
     * Devuelve la única instancia de servidor.
     * @return Servidor
     */
    public static Servidor getInstance(){
        if(instance == null){
            instance = new Servidor();
        }
        return instance;
    }
    
    public void asignarVentana(ServerLog pVentana){
        Servidor.ventana = pVentana;
    }
    
    /**
     * Postea un cambio en ventana ServerLog
     * @param msg
     */
    public final void post(String msg){
        ventana.post(msg);
    }
}
