/*
 * Instituto Tecnológico de Costa Rica
 * Escuela de Ingeniería en Computación
 * Lenguajes de Programación
 * Casa de Apuestas de Eddy
 */

package servidor;

import com.sun.imageio.plugins.jpeg.JPEG;
import comandos.Comando;
import comandos.ComandoApostar;
import comandos.ComandoCambiarCarta;
import comandos.ComandoCrearMesa;
import comandos.ComandoIniciarPartida;
import comandos.ComandoObtenerMesas;
import comandos.ComandoUnirseMesa;
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
    /**
     * Hash para obtener el tipo de comando recibido.
     */
    private Map<String, Comando> comandos;

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
        comandos=inicializarComandos();
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
	res.put(ComandoApostar.COMANDO, new ComandoApostar());
        res.put(ComandoCambiarCarta.COMANDO, new ComandoCambiarCarta());
        res.put(ComandoCrearMesa.COMANDO, new ComandoCrearMesa());
        res.put(ComandoIniciarPartida.COMANDO, new ComandoIniciarPartida());
        res.put(ComandoObtenerMesas.COMANDO, new ComandoObtenerMesas());
        res.put(ComandoUnirseMesa.COMANDO, new ComandoUnirseMesa());
        return res;
    }
    
    public void run(){
        
        try{
            //Lee el id del jugador apenas se establece la conexión.
            idJugador = entrada.readUTF();
            
            //Espera comandos
            while(corriendo){
                String nombreComando = entrada.readUTF();
                Object argumentos = entrada.readObject();
                Comando com = comandos.get(nombreComando);
                //Comando comAEjecutar = (Comando)Class.forName(comando).newInstance(); //Idea de usar reflection, descartada por rendimiento.
                salida.writeObject(com.ejecutar(argumentos));
            }
            
        }
        catch(IOException e)
        {
            serv.post(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
