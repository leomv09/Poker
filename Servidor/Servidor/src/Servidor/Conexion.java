/*
 * Instituto Tecnológico de Costa Rica
 * Escuela de Ingeniería en Computación
 * Lenguajes de Programación
 * Casa de Apuestas de Eddy
 */

package Servidor;

import com.sun.imageio.plugins.jpeg.JPEG;
import comandos.Comando;
import comandos.ComandoGraficarApuesta;
import comandos.ComandoGraficarCarta;
import comandos.ComandoSolicitarApuesta;
import comandos.ComandoSolicitarCambioCarta;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion extends Thread{
    //Atributos
    /**
     * Socket del cliente, recibido por el servidor
     */
    private Socket scli;
    /**
     * Referencia al servidor
     */
    private Servidor serv;
    /**
     * Buffer de entrada
     */
    private ObjectInputStream entrada;
    /**
     * Buffer de salida
     */
    private ObjectOutputStream salida;
    /**
     * Identificador del jugador
     */
    private String idJugador;
    /**
     * Flag de control para saber cuando se termina la conexión.
     */
    private boolean corriendo;

    //Constructores
    /**
     * Crea una instancia de Conexion
     * @param scli
     * @param serv 
     */
    public Conexion(Socket scli, Servidor serv) {
        this.scli = scli;
        this.serv = serv;
        this.idJugador = "";
        serv.post("Conexion agregada: "+this);
        try {
            entrada = new ObjectInputStream(scli.getInputStream());
            salida = new ObjectOutputStream(scli.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //Métodos
     /*
     *Método que inicializa el mapa de comandos del cliente.
     * Retorna: El mapa con los comandos.
     */
    private Map<String, Comando> inicializarComandos()
    {
        Map<String, Comando> res = new HashMap<>();
	res.put(ComandoSolicitarApuesta.COMANDO, new ComandoSolicitarApuesta());
        res.put(ComandoSolicitarCambioCarta.COMANDO, new ComandoSolicitarCambioCarta());
        res.put(ComandoGraficarCarta.COMANDO, new ComandoGraficarCarta());
        res.put(ComandoGraficarApuesta.COMANDO, new ComandoGraficarApuesta());
        return res;
    }
    
    public void run(){
        
        try{
            //Lee el id del jugador apenas se establece la conexión.
            idJugador = entrada.readUTF();
            
            //Espera comandos
            while(corriendo){
                String comando = entrada.readUTF();
                ArrayList<Object> argumentos = (ArrayList<Object>) entrada.readObject();
                Comando comAEjecutar = (Comando)Class.forName(comando).newInstance();
                salida.writeObject(comAEjecutar.ejecutar(argumentos));
            }
            
        }
        catch(IOException e)
        {
            serv.post(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
