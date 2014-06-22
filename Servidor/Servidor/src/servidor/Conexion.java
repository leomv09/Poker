/*
 * Instituto Tecnológico de Costa Rica
 * Escuela de Ingeniería en Computación
 * Lenguajes de Programación
 * Casa de Apuestas de Eddy
 */

package servidor;

import comandos.Comando;
import comandos.ComandoApostar;
import comandos.ComandoCambiarCarta;
import comandos.ComandoCrearMesa;
import comandos.ComandoIniciarPartida;
import comandos.ComandoObtenerMesas;
import comandos.ComandoUnirseMesa;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import poker.Jugador;

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
    private Jugador idJugador;
    /**
     * Flag de control para saber cuando se termina la conexión.
     */
    private boolean corriendo;
    /**
     * Hash para obtener el tipo de comando recibido.
     */
    private Map<String, Comando> comandos;
    
    private List<ListenerComandos> listeners;

    //Constructores
    /**
     * Crea una instancia de Conexion
     * @param scli
     * @param serv 
     */
    public Conexion(Socket scli, Servidor serv) {
        this.listeners = new LinkedList<>();
        this.scli = scli;
        this.serv = serv;
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
    
    public void agregarListener(ListenerComandos l)
    {
        this.listeners.add(l);
    }
    
    public void run(){
        
        try{
            //Lee el id del jugador apenas se establece la conexión.
            idJugador = (Jugador) entrada.readObject();
            
            //Espera comandos
            while(corriendo)
            {
                String nombreComando = entrada.readUTF();
                Object argumentos = entrada.readObject();
                
                for (ListenerComandos l : this.listeners)
                {
                    l.handleEvent(nombreComando);
                }
                
                Comando com = comandos.get(nombreComando);
                ArrayList<Object> parametros = new ArrayList<>();
                parametros.add(argumentos);
                parametros.add(idJugador);
                //Comando comAEjecutar = (Comando)Class.forName(comando).newInstance(); //Idea de usar reflection, descartada por rendimiento.
                salida.writeObject(com.ejecutar(parametros));
            }
            
        }
        catch(IOException e)
        {
            serv.post(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Envía el id del jugador dueño de la conexion
     * @return 
     */
    public String getID(){
        return idJugador.getId();
    }
    
    /**
     * Envía un comando al cliente.
     * @param comando
     * @param argumentos 
     */
    public void enviarComando(String comando, Object argumentos){
        try {
            ArrayList<Object> dato = new ArrayList<>();
            dato.add(comando);
            dato.add(argumentos);
            salida.writeObject(dato);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
