/*
 * Instituto Tecnológico de Costa Rica
 * Escuela de Ingeniería en Computación
 * Lenguajes de Programación
 * Casa de Apuestas de Eddy
 */

package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
    
    /**
     * Inicia las labores del servidor.
     */
    public void runServer(){
        ServerSocket serv;// es para counicacion y admin
        boolean listening = true;// bandera del while
        
        try
        {
            //Crea el socket que va a estar escuchando las peticiones
            serv = new ServerSocket(7777);
            
            post(".:: Servidor Activo");
            
            
            //Ciclo infinito que espera los clientes
            while(listening)
            {
                
                // Dos cokets para los clientes que acepta
                post(".::Esperando Conexiones");
                Socket sock1;
                
                try{
                    // espera las conexiones de los clientes
                    // a ambos sockets, por eso sson dos accepts
                    
                    sock1 = serv.accept();
                    
                }
                catch(IOException e){
                    post("Conexión falida: "+
                            serv+ ", "+ e.getMessage());
                    continue;
                }
                
                //crea un hilo para cada conexion con los clientes
                // y server
                Conexion user = new Conexion(sock1,this);
                user.start();

            }
        }
        catch (IOException e)
        {
            post("Error: "+e);
        }
        
        
        
    }
}
