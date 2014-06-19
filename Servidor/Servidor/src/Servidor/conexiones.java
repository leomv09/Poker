/*
 * Instituto Tecnológico de Costa Rica
 * Escuela de Ingeniería en Computación
 * Lenguajes de Programación
 * Casa de Apuestas de Eddy
 */

package Servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Vector;

public class conexiones extends Thread{
    Socket scli;//referencia a socket de comuniacion y admin
    Servidor serv;// referencia al servidor
    BufferedReader entrada;//Lectura:comunicacion y admin
    DataOutputStream salida;//Escritura:comunic y admin
    DataOutputStream salida2;//Escritura: mensajes
    // vector con los hilos activos, del as conexiones
    public static Vector<conexiones> clientesActivos =
            new Vector();

    public conexiones(Socket scli, Servidor serv) {
        this.scli = scli;
        this.serv = serv;
        
        clientesActivos.add(this);//se agrega al vector el hilo 
        //en la pantalla del servidor que fue agregado
    }
    
    public void run(){
    }

}
