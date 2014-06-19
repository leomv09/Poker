/*
 * Instituto Tecnológico de Costa Rica
 * Escuela de Ingeniería en Computación
 * Lenguajes de Programación
 * Casa de Apuestas de Eddy
 */

package Servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Vector;

public class Conexion extends Thread{
    Socket scli;//referencia a socket de comuniacion y admin
    Servidor serv;// referencia al servidor
    BufferedReader entrada;//Lectura:comunicacion y admin
    DataOutputStream salida;//Escritura:comunic y admin
    // vector con los hilos activos, del as Conexion
    public static Vector<Conexion> clientesActivos =
            new Vector();

    public Conexion(Socket scli, Servidor serv) {
        this.scli = scli;
        this.serv = serv;
        
        clientesActivos.add(this);//se agrega al vector el hilo 
        //en la pantalla del servidor que fue agregado
    }
    
    public void run(){
    }

}
